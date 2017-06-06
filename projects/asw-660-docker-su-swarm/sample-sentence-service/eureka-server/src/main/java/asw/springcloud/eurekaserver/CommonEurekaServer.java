package asw.springcloud.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CommonEurekaServer {

	public static void main(String[] args) {
		SpringApplication.run(CommonEurekaServer.class, args);
	}
}
