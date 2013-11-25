/**
 * 
 */
package tw.howie.sample.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * The SpringMVC application context.
 * 
 * This is the annotation variation of configuring the SpringMVC application
 * context. An XML configuration is imported so XML based configuration can
 * still be used.
 * 
 * Any @Controller classes will be picked up by component scanning. All other
 * components are ignored as they will be picked up by the root application
 * context.
 * 
 * @author howie_yu
 * 
 */
@EnableWebMvc
@Configuration
@EnableAsync
@ComponentScan(basePackages = "tw.howie.sample.mvc.controller")
@ImportResource({"classpath:META-INF/spring/servlet-context.xml"})
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		/* Mapping to the login view. */
		registry.addViewController("/login").setViewName("login");

	}

	/**
	 * Allow the default servlet to serve static files from the webapp root.
	 * 
	 * @param configurer
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	// @Bean
	// public InternalResourceViewResolver jspViewResolver() {
	// InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	// resolver.setPrefix("/WEB-INF/jsp");
	// resolver.setSuffix(".jsp");
	// return resolver;
	// }

	@Bean
	public ServletContextTemplateResolver thymeleafTemplateResolver() {
		ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".html");
		resolver.setTemplateMode("HTML5");
		resolver.setCacheable(true);
		return resolver;
	}

	@Bean
	public SpringTemplateEngine thymeleafTemplateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(thymeleafTemplateResolver());

		return engine;
	}

	@Bean
	public ThymeleafViewResolver thymeleafViewResolver() {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(thymeleafTemplateEngine());
		resolver.setOrder(1);
		return resolver;
	}

}
