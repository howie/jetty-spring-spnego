package tw.howie.sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@EnableWebSecurity
@ImportResource({"classpath:META-INF/spring/kerberos/speing-spnego-context.xml"})
@PropertySource("classpath:kerberos.properties")
public class SecurityConfiguration {

}
