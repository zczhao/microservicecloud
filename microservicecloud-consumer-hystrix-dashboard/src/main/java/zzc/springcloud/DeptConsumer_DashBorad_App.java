package zzc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer_DashBorad_App {

	/**
	 * 访问地址：http://localhost:9001/hystrix
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer_DashBorad_App.class, args);
	}
}
