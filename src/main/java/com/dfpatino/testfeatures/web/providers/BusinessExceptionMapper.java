package com.dfpatino.testfeatures.web.providers;

import com.dfpatino.testfeatures.errors.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class BusinessExceptionMapper extends AbstractExceptionMapper<BusinessException> {

    @Autowired
    public BusinessExceptionMapper(MessageSource messageSource) {
        super(messageSource);
    }

    @Override
    public Response toResponse(final BusinessException be) {
        return buildResponse(Response.Status.BAD_REQUEST, be);
    }
}
