package org.bitbucket.utils;

import org.bitbucket.payload.Token;

public class TokenProvider {

    public static String encoding(Token token) {
        return JsonHelper.toJson(token);
    }

    public static Token decoding(String str) {
        return JsonHelper.fromFormat(str, Token.class).orElseThrow();
    }
}
