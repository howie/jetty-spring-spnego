/**
 * 
 */
package tw.howie.sample.jetty;

import java.io.IOException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.codahale.metrics.servlets.AdminServlet;
import com.codahale.metrics.servlets.HealthCheckServlet;
import com.codahale.metrics.servlets.MetricsServlet;

/**
 * Configure the embedded Jetty server and the SpringMVC dispatcher servlet.
 * 
 * @author howie_yu
 * 
 */
@Configuration
public class JettyConfiguration {

	final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private MetricRegistry metricRegistry;

	@Autowired
	private HealthCheckRegistry metricsHealthCheckRegistry;

	/**
	 * Performance Monitor
	 * 
	 * @param webAppContext
	 */
	private void addMetricsServlet(WebAppContext webAppContext) {

		// Set Metric attributes on the handler for the metrics servlets, then
		// add the metrics servlet.
		webAppContext.setAttribute(MetricsServlet.METRICS_REGISTRY, metricRegistry);
		webAppContext.setAttribute(HealthCheckServlet.HEALTH_CHECK_REGISTRY, metricsHealthCheckRegistry);

		webAppContext.addServlet(new ServletHolder(new AdminServlet()), "/metrics/*");
	}

	@Bean
	public WebAppContext webAppContext() throws IOException {

		WebAppContext ctx = new WebAppContext();
		ctx.setContextPath("/");
		ctx.setWar(new ClassPathResource("webapp").getURI().toString());

		/* Disable directory listings if no index.html is found. */
		ctx.setInitParameter("org.eclipse.jetty.servlet.Default.dirAllowed", "false");

		/*
		 * Create the root web application context and set it as a servlet
		 * attribute so the dispatcher servlet can find it.
		 */
		GenericWebApplicationContext webApplicationContext = new GenericWebApplicationContext();
		webApplicationContext.setParent(applicationContext);
		webApplicationContext.refresh();
		ctx.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, webApplicationContext);

		ctx.addEventListener(new WebAppInitializer());

		return ctx;
	}

	/**
	 * Jetty Server bean.
	 * <p/>
	 * Instantiate the Jetty server.
	 */
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server jettyServer() throws IOException {

		/* Create the server. */
		Server server = new Server();

		/* Create a basic connector. */
		ServerConnector httpConnector = new ServerConnector(server);
		httpConnector.setPort(8080);
		server.addConnector(httpConnector);

		server.setHandler(webAppContext());

		/*
		 * We can add servlets or here, or we could do it in the
		 * WebAppInitializer.
		 */
		addMetricsServlet(webAppContext());

		return server;
	}
}
