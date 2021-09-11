package cn.tongyl.febs.server.system;

import cn.tongyl.febs.common.annotation.EnableFebsAuthExceptionHandler;
import cn.tongyl.febs.common.annotation.EnableFebsServerProtect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableFebsAuthExceptionHandler
@EnableFebsServerProtect
@MapperScan("cn.tongyl.febs.server.system.mapper")
@EnableTransactionManagement
public class FebsServerSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FebsServerSystemApplication.class, args);
	}

}
