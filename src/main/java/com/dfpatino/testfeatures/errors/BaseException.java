package com.dfpatino.testfeatures.errors;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private static final String defaultApiCode = "ERR-000";
    private static final String defaultApiMessage = "error.default";
    private String apiMessage;
    private String apiCode;
    private transient Object[] messageParameters;

    public BaseException(final String message) {
        this(message, null);
    }

    public BaseException(final String message, final Throwable cause) {
        this(message, cause, null, null, null);
    }

    public BaseException(final String apiCode, final String apiMessage, final Object[] messageParameters) {
        this(null, null, apiCode, apiMessage, messageParameters);
    }

    public BaseException(final String message, final Throwable cause, final String apiCode, final String apiMessage,
                         final Object... messageParameters) {
        super(message, cause);
        this.apiCode = apiCode != null ? apiCode : defaultApiCode;
        this.apiMessage = apiMessage != null ? apiMessage : defaultApiMessage;
        this.messageParameters = messageParameters != null ? messageParameters.clone() : null;
    }

}
