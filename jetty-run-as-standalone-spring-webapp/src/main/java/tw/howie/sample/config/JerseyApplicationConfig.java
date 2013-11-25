/**
 * 
 */
package tw.howie.sample.config;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author howie_yu
 * 
 */
public class JerseyApplicationConfig extends ResourceConfig {

	public JerseyApplicationConfig() {

		// scan controller package
		this.packages("tw.howie.sample.jersey.restful");

	}
}
