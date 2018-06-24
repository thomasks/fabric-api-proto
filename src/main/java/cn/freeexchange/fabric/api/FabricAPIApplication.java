package cn.freeexchange.fabric.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "cn.freeexchange.fabric.api")
public class FabricAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(FabricAPIApplication.class, args);
	}
}
