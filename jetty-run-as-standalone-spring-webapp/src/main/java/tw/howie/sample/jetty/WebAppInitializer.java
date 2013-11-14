/**
 * 
 */
package tw.howie.sample.jetty;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author howie_yu
 * 
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements ServletContextListener {

	final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * See {@link org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer}.
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	/**
	 * Set the application context for the Spring MVC web tier.
	 * 
	 * @See {@link org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer}
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{MvcConfiguration.class};
	}

	/**
	 * Map the Spring MVC servlet as the root.
	 * 
	 * @See {@link org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer}
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		/* Let super do its thing... */
		super.onStartup(servletContext);

		/* Add the Spring Security filter. */
		servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy()).addMappingForUrlPatterns(null,
																													false,
																													"/*");

		/*
		 * We could add more servlets here such as the metrics servlet which is
		 * added in @{link ca.unx.template.config.JettyConfiguration}.
		 */
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		try {
			onStartup(servletContextEvent.getServletContext());
		}
		catch(ServletException e) {
			logger.error("Failed to initialize web application", e);
			System.exit(0);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
	}

	/**
	 * Overrided to squelch a meaningless log message when embedded.
	 */
	@Override
	protected void registerContextLoaderListener(ServletContext servletContext) {
	}
}
