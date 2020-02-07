package com.dfpatino.testfeatures.web.providers;

import com.dfpatino.testfeatures.errors.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class BaseExceptionMapper extends AbstractExceptionMapper<BaseException> {

    @Autowired
    public BaseExceptionMapper(MessageSource messageSource) {
        super(messageSource);
    }

    @Override
    public Response toResponse(final BaseException be) {
        return buildResponse(Response.Status.INTERNAL_SERVER_ERROR, be);
    }
}
