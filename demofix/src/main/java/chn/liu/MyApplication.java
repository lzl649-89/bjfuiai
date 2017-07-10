package chn.liu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableScheduling
public class MyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConf() {
		return new WebMvcConfigurerAdapter() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				super.addCorsMappings(registry);
				registry.addMapping("/**/**")
						.allowedOrigins("*")
						.allowedMethods("POST, GET, OPTIONS, DELETE, PUT")
						.allowedHeaders("Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With")
						.allowCredentials(true);
			}

		};
	}
}
