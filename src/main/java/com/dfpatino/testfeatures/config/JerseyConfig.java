package com.dfpatino.testfeatures.config;

import com.dfpatino.testfeatures.web.api.DomesticPaymentsApi;
import com.dfpatino.testfeatures.web.providers.*;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(DomesticPaymentsApi.class);
        register(BaseExceptionMapper.class);
        register(BusinessExceptionMapper.class);
        register(ConstraintViolationExceptionMapper.class);
        register(GlobalExceptionMapper.class);
        register(WebApplicationExceptionMapper.class);
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        property(ServerProperties.WADL_FEATURE_DISABLE, true);
    }

}
