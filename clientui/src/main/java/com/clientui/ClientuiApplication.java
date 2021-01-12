package com.clientui;

import com.clientui.exceptions.CustomErrorDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients("com.clientui")
public class ClientuiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientuiApplication.class, args);
	}

}
