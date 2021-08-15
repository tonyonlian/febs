package cn.tongyl.febs.fauth;

import cn.tongyl.febs.common.annotation.EnableFebsAuthExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFebsAuthExceptionHandler
public class FebsAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(FebsAuthApplication.class, args);
	}

}
