package cn.tongyl.febs.fauth;

import cn.tongyl.febs.common.annotation.EnableFebsAuthExceptionHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFebsAuthExceptionHandler
@MapperScan("cn.tongyl.febs.fauth.mapper")
public class FebsAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(FebsAuthApplication.class, args);
	}

}
