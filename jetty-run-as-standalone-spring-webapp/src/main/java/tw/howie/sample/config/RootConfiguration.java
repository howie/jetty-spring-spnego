/**
 * 
 */
package tw.howie.sample.config;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

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
@ImportResource({"classpath:META-INF/spring/root-context.xml"})
@PropertySource("classpath:app-config.properties")
@Import({JettyConfiguration.class, SecurityConfiguration.class})
public class RootConfiguration {

	@Bean
	public Properties retrieveSystemProperties() {
		return System.getProperties();
	}

	private Properties systemProperties;

	public Properties getSystemProperties() {
		return systemProperties;
	}

	@Resource(name = "retrieveSystemProperties")
	public void setSystemProperties(Properties systemProperties) {
		this.systemProperties = systemProperties;
	}

	@Bean
	public MethodInvokingFactoryBean methodInvokingFactoryBean() {
		MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
		methodInvokingFactoryBean.setStaticMethod("java.lang.System.setProperties");
		systemProperties.setProperty("http.keepAlive", "false");
		systemProperties.setProperty("org.apache.jasper.compiler.disablejsr199", "true");
		methodInvokingFactoryBean.setArguments(new Object[]{systemProperties});
		return methodInvokingFactoryBean;
	}

}
