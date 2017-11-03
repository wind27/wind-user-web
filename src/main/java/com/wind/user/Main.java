package com.wind.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.web.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Import({ DispatcherServletAutoConfiguration.class, EmbeddedServletContainerAutoConfiguration.class,
		ErrorMvcAutoConfiguration.class, HttpEncodingAutoConfiguration.class,
		HttpMessageConvertersAutoConfiguration.class, JacksonAutoConfiguration.class, MultipartAutoConfiguration.class,
		ServerPropertiesAutoConfiguration.class, WebMvcAutoConfiguration.class })
@ImportResource(locations = { "classpath*:spring/applicationContext-consumer.xml"})
@RestController
@SpringBootApplication
public class Main extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Main.class);
	}

	public static void main(String[] args) {
		try {
			SpringApplication.run(Main.class, args);
			synchronized (Main.class) {
				while (true) {
					Main.class.wait();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
