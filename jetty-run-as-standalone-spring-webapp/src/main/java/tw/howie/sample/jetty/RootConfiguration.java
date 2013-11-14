/**
 * 
 */
package tw.howie.sample.jetty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;

/**
 * The root application context.
 * <p/>
 * Beans can also be configured by XML in root-context.xml which is imported by this context class.
 * <p/>
 * Component scanning is also done to pickup any components other than
 * 
 * @Controllers. @Controllers will be picked up by the SpringMVC context.
 * @author howie_yu
 * 
 */
@Configuration
@ImportResource({	"classpath:META-INF/spring/root-context.xml",
					"classpath:META-INF/spring/kerberos/spnego-with-server-side-kerberos-option.xml"})
@Import({JettyConfiguration.class})
@ComponentScan(basePackages = {"tw.howie.sample"}, excludeFilters = {	@ComponentScan.Filter(Controller.class),
																		@ComponentScan.Filter(Configuration.class)})
public class RootConfiguration {

	/**
	 * The metrics registry.
	 */
	@Bean
	public MetricRegistry metricsRegistry() {
		return new MetricRegistry();
	}

	/**
	 * The metrics health check registry.
	 */
	@Bean
	public HealthCheckRegistry metricsHealthCheckRegistry() {
		return new HealthCheckRegistry();
	}
}
