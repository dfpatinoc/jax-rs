package com.dfpatino.testfeatures.web.providers;

import com.dfpatino.testfeatures.model.ApiError;
import com.dfpatino.testfeatures.model.ApiErrorResponse;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Provider
@Slf4j
public class ConstraintViolationExceptionMapper extends AbstractExceptionMapper<ConstraintViolationException> {

    private static final String defaultApiCode = "V-ERR-000";
    private static final String defaultApiMessage = "error.validation";

    @Autowired
    public ConstraintViolationExceptionMapper(MessageSource messageSource) {
        super(messageSource);
    }

    @Override
    public Response toResponse(ConstraintViolationException cve) {
        log.error("Error: {}", cve.getMessage());
        val apiErrors = getValidationErrors(cve.getConstraintViolations());
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(ApiErrorResponse.builder()
                        .code(defaultApiCode)
                        .message(i18nMessage(defaultApiMessage))
                        .errors(apiErrors)
                        .build())
                .build();
    }

    private List<ApiError> getValidationErrors(final Set<ConstraintViolation<?>> constraintViolations) {
        val apiErrors = new ArrayList<ApiError>();
        for (final ConstraintViolation<?> error : constraintViolations) {
            val errorMessage = error.getMessageTemplate();
            val propertyName = getPropertyName(error.getPropertyPath().toString());
            apiErrors.add(ApiError.builder()
                    .message(i18nMessage(errorMessage, propertyName))
                    .build());
        }
        return apiErrors;
    }

    private String getPropertyName(final String propertyPath) {
        //The property has the name of the method and class and must be discarded
        return propertyPath.split("\\.", 3)[2];
    }
}