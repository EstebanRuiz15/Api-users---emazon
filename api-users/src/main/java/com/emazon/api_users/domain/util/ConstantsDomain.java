package com.emazon.api_users.domain.util;

public final class ConstantsDomain {
    private ConstantsDomain(){
        throw new IllegalStateException("Utility class");
    }
    
    public static final Integer AGE_MAY= 18;
    public static final String AGE_MAY_ERROR= "the user cannot be a minor";
    public static final String ROLE_ERROR_MESSAGE="Invalid role. Must be ADMIN, USER, or AUX_BODEGA.";
    public static final String EMAIL_AL_READY_EXIST_ERROR_MESSAGE="the email is al ready exist";
    public static final String ROLE="ROLE_";
}
