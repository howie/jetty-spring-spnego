/**
 * 
 */
package tw.howie.sample.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author howie_yu
 * 
 */
@Controller
@RequestMapping("/mvc")
public class DummyMvcController {

	final Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
	public ModelAndView helloWorld(Model model) {
		ModelAndView view = new ModelAndView();
		view.setViewName("test"); // name of the jsp-file in the 'page' folder
		String str = "MVC Spring is here!";
		view.addObject("message", str); // adding of str object as 'message' parameter
		return view;

	}
}
