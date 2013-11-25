/**
 * 
 */
package tw.howie.sample.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author howie_yu
 * 
 */
@Controller
@RequestMapping("/mvc")
public class AdminController {

	@RequestMapping("/admin")
	public @ResponseBody
	String index() {
		return "This is the admin section.";
	}

}
