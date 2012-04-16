package com.kjl.mobile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DeviceController {

	private static final Logger logger = LoggerFactory.getLogger(DeviceController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/ldr", method=RequestMethod.GET)
	public String deviceResolverLite(Device device, ModelMap model) {
		logger.info("Device controller! is mobile=" + device.isMobile());
		model.addAttribute("device", device);
		return "device_resolver_lite";
	}
	
}

