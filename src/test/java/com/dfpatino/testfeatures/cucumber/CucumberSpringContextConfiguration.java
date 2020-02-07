package com.dfpatino.testfeatures.cucumber;

import com.dfpatino.testfeatures.TestFeaturesApplication;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = TestFeaturesApplication.class, loader = SpringBootContextLoader.class)
@Slf4j
public class CucumberSpringContextConfiguration {

    /**
     * Need this method so the cucumber will recognise this class as glue and load spring context configuration
     */
    @Before
    public void setUp() {
        log.info("Executing Cucumber Step in Spring Context");
    }

}
