/**
 * 
 */
package tw.howie.sample.jetty;

import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.xml.XmlConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author howie_yu
 * 
 */
public class NativeJettyServer {

	private static final Logger logger = LoggerFactory.getLogger(NativeJettyServer.class);

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		logger.info("Start KeyMgmt Server.....");
		Resource jettyConfig = Resource.newSystemResource("jetty.xml");
		XmlConfiguration configuration = new XmlConfiguration(jettyConfig.getInputStream());
		org.eclipse.jetty.server.Server server = (org.eclipse.jetty.server.Server) configuration.configure();
		server.setStopAtShutdown(true);
		// Allow 5 seconds to complete.
		// Adjust this to fit with your own webapp needs.
		// Remove this if you wish to shut down immediately (i.e. kill <pid> or Ctrl+C).

		WebAppContext wac = new WebAppContext();
		wac.setResourceBase(".");
		wac.setDescriptor("WEB-INF/web.xml");
		wac.setContextPath("/");
		wac.setParentLoaderPriority(true);
		server.setHandler(wac);

		// Start Jetty
		server.start();
		server.join();

	}

}
