package com.thanos.api;

import com.thanos.api.common.SpringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(
    basePackages = {"com.thanos.api"})
@EnableJpaRepositories(basePackages = {"com.thanos.api"})
public class ApiApplication {

	public static void main(String[] args) {
	    SpringApplication.run(ApiApplication.class, args);
	}

    @Bean
    public SpringUtils springUtilsBean() {
        return new SpringUtils();
    }
}
