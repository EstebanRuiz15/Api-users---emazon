package com.emazon.api_users.infraestructure.util;

public final class ConstantsInfra {
    private ConstantsInfra(){
        throw new IllegalStateException("Utility class");
    }

    public static final String ERROR_USER = "Error creating user";
    public static final String ERROR_NAME_NULL = "the name cannot be null";
    public static final String ERROR_LAST_NAME = "The last name cannot be null";
    public static final String ERROR_PASSWORD_INCORRECT="The password must contain a capital letter, 1 number and at least 8 characters.";
    public static final String ERROR_PASSWORD_NULL="The password cannot be null";
    public static final String ERROR_EMAIL_NULL="The email cannot be null";
    public static final String ERROR_EMAIL_INCORRECT = "The email structure is incorrect";
    public static final String ERROR_DOCUMENT_ID= "The document cannot be null";
    public static final String ERROR_DOCUMENT= "The document should only have numbers";
    public static final int TEN=10;
    public static final int TERTEEN=13;
    public static final String ERROR_CEL= "The cell phone must have between 10 and 13 characters";
    public static final String ERROR_CEL_NULL= "The cell phone cannot be null";
    public static final String ERROR_CEL_INVALID= "The cell phone is invalid";
    public static final String ERROR_DATE_NULL= "The date birth cannor be null";
    public static final String ERROR_DATE_INVALID= "the date birth invalid";
    public static final String ERROR_ROLE= "The rol should only 'AUX_BODEGA''";
    public static final String ERROR_ROLE_NULL= "The role cannot be null";
    public static final String ERROR_MESSAGE_UNAUTHORIZED="Invalid email or password";
    public static final String ACCES_DENIED_MESSAGE="{\"error\": \"Access Denied: ";
    public static final String USER_NOT_FOUND="User not found";
    public static final String KEY="294A404E635266556A586E327235753878214125442A472D4B6150645367566B";
    public static final String AUTHORIZATIOn="Authorization";
    public static final String BEARER="Bearer ";
    public static final String PASS_REGEX="^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,}$";
    public static final String REGEX_Document="^[0-9]+$";
    public static final String REGEX_CEL="^\\+?[0-9]+$";
    public static final String URL_AUTH_LOGIN="/auth/login";




}
