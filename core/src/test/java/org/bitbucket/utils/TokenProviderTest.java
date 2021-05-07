package org.bitbucket.utils;

import org.bitbucket.payload.Token;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class TokenProviderTest {

    private Token token = new Token(1L,"D","F", new Date(), new Date());

    @Test
    public void encodeAndDecodeEquality() {
        String encoded = TokenProvider.encode(token);
        Token decoded = TokenProvider.decode(encoded);
        Assert.assertNotEquals(JsonHelper.toFormat(token).orElse(null), encoded);
        Assert.assertEquals(token, decoded);
    }

}