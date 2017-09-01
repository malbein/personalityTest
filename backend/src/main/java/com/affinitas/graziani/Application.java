package com.affinitas.graziani;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by matiasgraziani on 8/31/17.
 */
@SpringBootApplication
@EnableJpaRepositories("com.affinitas.graziani.repository")
@EnableTransactionManagement
@ComponentScan(basePackages={"com.affinitas.graziani.*"})
@EntityScan("com.affinitas.graziani.domain")
@EnableSwagger2
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
