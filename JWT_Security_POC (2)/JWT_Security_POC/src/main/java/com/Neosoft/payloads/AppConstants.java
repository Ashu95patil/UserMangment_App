package com.Neosoft.payloads;

public class AppConstants {

    public static final Integer ADMIN_USER=101;

    public static final Integer MODERATE_USER = 102;

    public static final Integer NORMAL_USER = 103;

    public static final String  NOT_FOUND = "User Not Found with Id";

    public static final String  USER_DELETE = "User Delete SuccessFully with Id";

    public static final String INVALID_USERNAME_PASSWORD= "Invalid username or password !!";

    public static final String UNAUTHORIZED_MESSAGE="Access Denied!!";

    // For Security

    public static final String SECRET = "jwtTokenKey";

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    public static final String HEADER_STRING="Authorization";

    public static final String TOKEN_PREFIX="Bearer";

    public static final Integer TOKEN_INDEX=6;

}
