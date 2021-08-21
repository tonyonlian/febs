package cn.tongyl.febs.server.test;

import cn.tongyl.febs.common.annotation.FebsCloudApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * 应用启动类
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableFeignClients
@FebsCloudApplication
public class FebsServerTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FebsServerTestApplication.class, args);
	}

}
