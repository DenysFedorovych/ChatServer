package org.bitbucket.utils;

import org.bitbucket.payload.Token;

public class TokenProvider {

    public static String encoding(Token token) {
        return "JsonHelper.toFormat(token)";
    }

    public static Token decoding(String str) {
        return JsonHelper.fromFormat(str, Token.class).orElseThrow();
    }
}
