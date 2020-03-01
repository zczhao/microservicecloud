package zzc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class Zuul_9527_StartSpringCloudApp {

	/**
	 * 访问地址：http://localhost:9527/microservicecloud-dept/dept/get/2
	 * 配置路由访问映射规则后的访问地址：http://localhost:9527/mydept/dept/get/2
	 * 设置统一公共前缀后的访问地址：http://localhost:9527/zzc/mydept/dept/get/2
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Zuul_9527_StartSpringCloudApp.class, args);
	}

}
