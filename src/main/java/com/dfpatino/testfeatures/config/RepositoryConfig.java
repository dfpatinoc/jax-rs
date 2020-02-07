package com.dfpatino.testfeatures.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.dfpatino.testfeatures.repository.impl")
public class RepositoryConfig {
}
