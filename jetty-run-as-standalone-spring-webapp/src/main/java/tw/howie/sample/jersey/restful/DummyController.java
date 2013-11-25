/**
 * 
 */
package tw.howie.sample.jersey.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author howie_yu
 * 
 */
@Path("/api")
@Controller
public class DummyController {

	final Logger logger = LoggerFactory.getLogger(getClass());

	@GET
	@Path("/ping")
	public ModelAndView ping() {

		logger.info("ping");
		return new ModelAndView("ping");
	}

	@GET
	@Path("/echo/{msg}")
	public Response echo(@PathParam("msg") String msg) {
		logger.info("msg:{}", msg);
		return Response.ok(msg).build();
	}

}
