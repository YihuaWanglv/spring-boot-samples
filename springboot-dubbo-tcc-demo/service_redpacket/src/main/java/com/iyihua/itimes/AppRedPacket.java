package com.iyihua.itimes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:dubbo.xml", "classpath:appcontext-service-dao.xml", "classpath:appcontext-service-datasource.xml", "classpath:tcc-transaction.xml"})
public class AppRedPacket 
{
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AppRedPacket.class, args);
	}
}
