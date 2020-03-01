package zzc.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zzc.springcloud.entities.Dept;
import zzc.springcloud.service.DeptService;

@RestController
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	private DeptService deptService;

	@Autowired
	private DiscoveryClient discoveryClient;

	@PostMapping("/add")
	public boolean add(@RequestBody Dept dept) {
		return deptService.add(dept);
	}

	/**
	 * http://localhost：8001/dept/get/1
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return deptService.get(id);
	}

	/**
	 * http://localhost：8001/dept/list
	 * 
	 * @return
	 */
	@GetMapping("/list")
	public List<Dept> list() {
		return deptService.list();
	}

	@GetMapping("/discovery")
	public Object discovery() {
		List<String> services = discoveryClient.getServices();
		System.out.println("******" + services);

		List<ServiceInstance> instances = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance instance : instances) {
			System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getUri());
		}
		return this.discoveryClient;
	}
}
