package com.dfpatino.testfeatures.web.providers;

import com.dfpatino.testfeatures.errors.BaseException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Slf4j
public class WebApplicationExceptionMapper extends AbstractExceptionMapper<WebApplicationException> {

    @Autowired
    public WebApplicationExceptionMapper(MessageSource messageSource) {
        super(messageSource);
    }

    @Override
    public Response toResponse(final WebApplicationException wae) {
        log.error("Error: ", wae);
        val baseException = new BaseException(wae.getMessage(), wae);
        return buildResponse(Response.Status.INTERNAL_SERVER_ERROR, baseException);
    }
}
