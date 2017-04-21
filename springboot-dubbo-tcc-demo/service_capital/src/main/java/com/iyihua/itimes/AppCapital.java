package com.iyihua.itimes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:dubbo.xml", "classpath:appcontext-service-dao.xml", "classpath:appcontext-service-datasource.xml", "classpath:tcc-transaction.xml"})
public class AppCapital 
{
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AppCapital.class, args);
	}
}
