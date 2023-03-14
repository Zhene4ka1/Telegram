package com.exam.telegrambot1;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.lang.reflect.GenericArrayType;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TelegramBot1Application {

	public static void main(String[] args) {
		SpringApplication.run(TelegramBot1Application.class, args);
	}

}
