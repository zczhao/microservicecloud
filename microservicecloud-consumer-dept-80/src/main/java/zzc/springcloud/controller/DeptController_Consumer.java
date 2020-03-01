package zzc.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import zzc.springcloud.entities.Dept;

@RestController
@RequestMapping("/consumer/dept")
public class DeptController_Consumer {

	// private static final String REST_URL_PREFIX = "http://localhost:8001";
	// Ribbon和Eureka整合后Consumers可以直接调用服务而不用再关心地址和端口号
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

	/**
	 * 使用RestTemplate访问Restful接口非常的简单粗暴无脑(url, requestMap,ResonseBean.class)
	 * 这三个参数分别代表：REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
	 */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * http://localhost/consumer/dept/add?dname=bigdata
	 * 
	 * @param dept
	 * @return
	 */
	@GetMapping("/add")
	public boolean add(Dept dept) {
		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
	}

	/**
	 * http://localhost/consumer/dept/get/2
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
	}

	/**
	 * http://localhost/consumer/dept/list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/list")
	public List<Dept> list() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	}

	/**
	 * 测试@EnableDiscoveryClient,消费端可以调用服务发现
	 * http://localhost/consumer/dept/discovery
	 * @return
	 */
	@GetMapping("/discovery")
	public Object discovery() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
	}
}