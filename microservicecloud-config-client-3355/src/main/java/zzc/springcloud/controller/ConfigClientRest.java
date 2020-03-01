package zzc.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {

	@Value("${spring.application.name}")
	private String applicationName;
	
	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaServers;
	
	@Value("${server.port}")
	private int port;
	
	@GetMapping("/config")
	public ModelMap getConfig() {
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("applicationName", applicationName);
		modelMap.addAttribute("eurekaServers", eurekaServers);
		modelMap.addAttribute("port", port);
		return modelMap;
	}
}
