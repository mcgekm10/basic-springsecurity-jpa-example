package io.springsecurity.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "io.springsecurity")
@EntityScan("io.springsecurity.domain")
@EnableJpaRepositories("io.springsecurity.repository")
@PropertySource("classpath:application.properties")
public class WebContextConfig {

}
