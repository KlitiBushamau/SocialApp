package com.socialapp.social.exception;

public class SocialAppException extends RuntimeException {
    public SocialAppException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }
    public SocialAppException(String exMessage) {
        super(exMessage);
    }
}
