package com.dfpatino.testfeatures.web.providers;

import com.dfpatino.testfeatures.errors.BaseException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Slf4j
public class GlobalExceptionMapper extends AbstractExceptionMapper<Exception> {

    @Autowired
    public GlobalExceptionMapper(MessageSource messageSource) {
        super(messageSource);
    }

    @Override
    public Response toResponse(final Exception e) {
        log.error("Error: {}", e.getMessage());
        val baseException = new BaseException(e.getMessage(), e);
        return buildResponse(Response.Status.INTERNAL_SERVER_ERROR, baseException);
    }
}
