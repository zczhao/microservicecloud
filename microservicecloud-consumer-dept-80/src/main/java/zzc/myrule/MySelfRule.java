package zzc.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

@Configuration
public class MySelfRule {

	@Bean
	public IRule myRule() {
		// return new RandomRule(); // Ribbon默认是轮询，改为随机
		return new RandomRule_ZZC(); // 自定义为每台机器5次
	}
}
