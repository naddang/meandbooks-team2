package com.meandbooksteam2.shoppingmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = {"com.meandbooksteam2.shoppingmall.dao.admin", "com.meandbooksteam2.shoppingmall.dao.cs","com.meandbooksteam2.shoppingmall.dao.mall",
					 "com.meandbooksteam2.shoppingmall.dao.member","com.meandbooksteam2.shoppingmall.dao.orders"})
@SpringBootApplication
public class MeandbooksTeam2Application {

	public static void main(String[] args) {
		SpringApplication.run(MeandbooksTeam2Application.class, args);
	}


}
