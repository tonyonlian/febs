package cn.tongyl.febs.server.system;

import cn.tongyl.febs.common.annotation.EnableFebsAuthExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableFebsAuthExceptionHandler
public class FebsServerSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FebsServerSystemApplication.class, args);
	}

}
