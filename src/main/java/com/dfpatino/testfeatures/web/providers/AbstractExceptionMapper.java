package com.dfpatino.testfeatures.web.providers;

import com.dfpatino.testfeatures.errors.BaseException;
import com.dfpatino.testfeatures.model.ApiErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

@Slf4j
public abstract class AbstractExceptionMapper<T extends Throwable> implements ExceptionMapper<T> {

    private final MessageSource messageSource;

    public AbstractExceptionMapper(final MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    protected Response buildResponse(final Response.Status httpStatusCode, BaseException be) {
        log.error("Error: ", be);
        return Response.status(httpStatusCode)
                .entity(ApiErrorResponse.builder()
                        .code(be.getApiCode())
                        .message(i18nMessage(be))
                        .build())
                .build();
    }

    protected String i18nMessage(final BaseException ex) {
        return i18nMessage(ex.getApiMessage(), ex.getMessageParameters());
    }

    protected String i18nMessage(final String messageProperty, final Object... messageParameters) {
        return messageSource.getMessage(messageProperty, messageParameters, LocaleContextHolder.getLocale());
    }
}
