package tw.howie.sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
// @EnableWebSecurity
@ImportResource({"classpath:META-INF/spring/kerberos/speing-spnego-context.xml"})
@PropertySource("classpath:kerberos.properties")
public class SecurityConfiguration {// extends WebSecurityConfigurerAdapter {
//
// @Value("${krb.debug}")
// private boolean debug;
//
// @Value("${krb.keytab.location}")
// private String keyTabLocation;
//
// @Value("${krb.service.prinicipal}")
// private String servicePrincipal;
//
// @Autowired
// private UserDetailsService dummyUserDetailsService;
//
// @Bean
// public UserDetailsService dummyUserDetailsService() {
//
// System.out.println("==============Initial UserDetailsService======================");
// return new DummyUserDetailsServiceImpl();
// }
//
// /**
// * <sec:http entry-point-ref="spnegoEntryPoint">
// * <sec:intercept-url pattern="/css/**" access="IS_AUTHENTICATED_ANONYMOUSLY" />
// * <sec:intercept-url pattern="/js/**" access="IS_AUTHENTICATED_ANONYMOUSLY" />
// * <sec:intercept-url pattern="/images/**" access="IS_AUTHENTICATED_ANONYMOUSLY" />
// * <sec:intercept-url pattern="/secure/**" access="IS_AUTHENTICATED_FULLY" />
// * <sec:intercept-url pattern="/monitor/**" access="IS_AUTHENTICATED_FULLY" />
// * <sec:intercept-url pattern="/j_spring_security_check*" access="IS_AUTHENTICATED_ANONYMOUSLY" />
// * <sec:custom-filter ref="spnegoAuthenticationProcessingFilter" position="BASIC_AUTH_FILTER" />
// * <sec:form-login login-page="/login.html" default-target-url="/secure/index.jsp" />
// * </sec:http>
// *
// *
// *
// */
//
// @Override
// protected void configure(HttpSecurity http) throws Exception {
//
// http.authorizeRequests().antMatchers("/css/**", "/js", "/images").permitAll().
// antMatchers("/secure/**").authenticated().
// antMatchers("/monitor/**").authenticated().
// and().addFilter(spnegoAuthenticationProcessingFilter()).httpBasic().and().formLogin();
//
// }
//
// // TODO http://www.baeldung.com/2011/10/31/securing-a-restful-web-service-with-spring-security-3-1-part-3/
//
//
// @Bean
// public AuthenticationManager authenticationManager() {
// List<AuthenticationProvider> providers = new ArrayList<AuthenticationProvider>();
// providers.add(kerberosAuthenticationProvider());
// providers.add(kerberosServiceAuthenticationProvider());
// AuthenticationManager authenticationManager = new
// org.springframework.security.authentication.ProviderManager(providers);
//
// return authenticationManager;
// }
//
// @Bean
// public SpnegoEntryPoint spnegoEntryPoint() {
//
// return new SpnegoEntryPoint();
// }
//
// @Bean
// public SpnegoAuthenticationProcessingFilter spnegoAuthenticationProcessingFilter() throws Exception {
//
// SpnegoAuthenticationProcessingFilter spFilter = new SpnegoAuthenticationProcessingFilter();
// spFilter.setAuthenticationManager(authenticationManager());
// return spFilter;
// }
//
// @Bean
// public KerberosAuthenticationProvider kerberosAuthenticationProvider() {
// KerberosAuthenticationProvider provider = new KerberosAuthenticationProvider();
// SunJaasKerberosClient kerberosClient = new SunJaasKerberosClient();
// kerberosClient.setDebug(debug);
// provider.setKerberosClient(kerberosClient);
// System.out.println("------------->" + dummyUserDetailsService());
// provider.setUserDetailsService(dummyUserDetailsService());
// return provider;
// }
//
// @Bean
// public KerberosServiceAuthenticationProvider kerberosServiceAuthenticationProvider() {
//
// KerberosServiceAuthenticationProvider provider = new KerberosServiceAuthenticationProvider();
// SunJaasKerberosTicketValidator ticketValidator = new SunJaasKerberosTicketValidator();
// ticketValidator.setDebug(debug);
//
// ticketValidator.setKeyTabLocation(new FileSystemResource(keyTabLocation));
// ticketValidator.setServicePrincipal(servicePrincipal);
// provider.setTicketValidator(ticketValidator);
// provider.setUserDetailsService(dummyUserDetailsService());
// return provider;
// }
//
// @Bean
// public GlobalSunJaasKerberosConfig globalSunJaasKerberosConfig() {
//
// GlobalSunJaasKerberosConfig config = new GlobalSunJaasKerberosConfig();
// config.setDebug(debug);
// config.setKrbConfLocation(keyTabLocation);
// return config;
// }

}
