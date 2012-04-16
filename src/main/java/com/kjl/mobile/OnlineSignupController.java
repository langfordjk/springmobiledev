package com.kjl.mobile;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mobile.device.site.SitePreference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class OnlineSignupController extends AbstractController {

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/online-signup", method=RequestMethod.GET)
	public String deviceResolverLite(HttpServletRequest request, Model model, SitePreference sitePreference) {
		addSwatchToModel(request, model);
		String view = (sitePreference == SitePreference.MOBILE) ? "online_signup_home" : "online_signup_home_normal";
		addLastView(request, view);
		
		return view;
	}
	
}

