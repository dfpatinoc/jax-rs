package com.dfpatino.testfeatures.errors;

public class BusinessException extends BaseException {

    public BusinessException(final String apiCode, final String apiMessageProperty, final Object... messageParameters) {
        super(apiCode, apiMessageProperty, messageParameters);
    }
}
