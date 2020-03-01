package zzc.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class ConfigBean {

	@Bean
	@LoadBalanced // Spring Cloud Ribbon是基于Netflix Ribbon	实现的一套客户端负载均衡的工具
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	/**
	 * IRule：根据特定算法从服务列表中选取一个要访问的服务
	 * @return
	 */
	@Bean
	public IRule myRule() {
		return new RoundRobinRule(); // 轮询(默认)
		// return new RandomRule(); // 随机
		// return new RetryRule(); // 先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内进行重试，获取可用的服务
		// return new BestAvailableRule(); // 会选过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最少的服务
	}

}
