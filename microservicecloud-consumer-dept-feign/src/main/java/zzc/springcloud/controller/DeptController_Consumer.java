package zzc.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zzc.springcloud.entities.Dept;
import zzc.springcloud.service.DeptClientService;

@RestController
@RequestMapping("/consumer/dept")
public class DeptController_Consumer {

	@Autowired
	private DeptClientService deptClientService;

	/**
	 * http://localhost/consumer/dept/add?dname=bigdata
	 * 
	 * @param dept
	 * @return
	 */
	@GetMapping("/add")
	public boolean add(Dept dept) {
		return deptClientService.add(dept);
	}

	/**
	 * http://localhost/consumer/dept/get/2
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return deptClientService.get(id);
	}

	/**
	 * http://localhost/consumer/dept/list
	 * 
	 * @return
	 */
	@GetMapping("/list")
	public List<Dept> list() {
		return deptClientService.list();
	}

}
