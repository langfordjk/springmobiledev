package com.kjl.mobile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

public abstract class AbstractController {

	protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractController.class);
	
	private static final String SWATCH_KEY_NAME = "swatch";
	
	private static final String LAST_VIEW = "last_view";
	
	protected final void defaultSwatch(HttpServletRequest request) {
		swicthSwatch(request, "d");
	}
	
	protected final void swicthSwatch(HttpServletRequest request, String swatch) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.setAttribute(SWATCH_KEY_NAME, swatch);
		}
	}
	
	protected String getSwatch(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return (session != null) ? (String) session.getAttribute(SWATCH_KEY_NAME) : null;
	}
	
	protected final void addSwatchToModel(HttpServletRequest request, Model model) {
		model.addAttribute("swatch", getSwatch(request));
	}
	
	protected final void addLastView(HttpServletRequest request, String view) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.setAttribute(LAST_VIEW, view);
		}
	}
	
	protected final String getLastView(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			return (String) session.getAttribute(LAST_VIEW);
		}
		return null;
	}
	
}
