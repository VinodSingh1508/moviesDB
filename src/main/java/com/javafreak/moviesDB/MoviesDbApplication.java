package com.javafreak.moviesDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoviesDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesDbApplication.class, args);
	}
	/*
	Swagger UI Available at: http://localhost:8080/swagger-ui/index.html
	https://stackoverflow.com/questions/71549614/springfox-type-javax-servlet-http-httpservletrequest-not-present
	*/
/*
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("*")
						.allowedHeaders("*")
						.allowCredentials(false).maxAge(3600);
			}
		};
	}
*/
}
