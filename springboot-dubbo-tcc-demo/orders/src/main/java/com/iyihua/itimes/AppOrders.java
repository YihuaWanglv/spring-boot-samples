package com.iyihua.itimes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableAspectJAutoProxy
@ComponentScan
@ImportResource({"classpath:dubbo_client.xml", "classpath:appcontext-service-dao.xml", "classpath:appcontext-service-datasource.xml", "classpath:tcc-transaction.xml"})
public class AppOrders 
{
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AppOrders.class, args);
	}
}
