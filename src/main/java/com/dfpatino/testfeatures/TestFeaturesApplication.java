package com.dfpatino.testfeatures;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.dfpatino.testfeatures.config")
@Slf4j
public class TestFeaturesApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestFeaturesApplication.class, args);
    }

}
