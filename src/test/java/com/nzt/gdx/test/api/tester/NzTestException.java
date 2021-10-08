package com.nzt.gdx.test.api.tester;

public class NzTestException extends Exception {
    public NzTestException() {
    }

    public NzTestException(String message) {
        super(message);
    }

    public NzTestException(String message, Throwable cause) {
        super(message, cause);
    }

    public NzTestException(Throwable cause) {
        super(cause);
    }

    public NzTestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
