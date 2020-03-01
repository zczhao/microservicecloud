package zzc.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import zzc.springcloud.entities.Dept;

//@FeignClient(name = "MICROSERVICECLOUD-DEPT") // 单独使用feign
@FeignClient(name = "MICROSERVICECLOUD-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class) // 服务降级
public interface DeptClientService {

	@PostMapping(value="/dept/add")
	public boolean add(Dept dept);

	@GetMapping(value="/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id);

	@GetMapping(value="/dept/list")
	public List<Dept> list();
}
