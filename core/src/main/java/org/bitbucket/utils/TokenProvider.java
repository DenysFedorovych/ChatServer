package org.bitbucket.utils;

import org.bitbucket.payload.Token;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;

public class TokenProvider {

    private static final String key = "TopSecret2281337";
    private static Key aesKey;

    static {
        try {
            aesKey = new SecretKeySpec(Arrays.copyOf(key.getBytes("UTF-8"), 16), "AES");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String data) {


        byte[] decodedKey = Base64.getDecoder().decode(key);

        try {
            Cipher cipher = Cipher.getInstance("AES");
            SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, originalKey);
            byte[] cipherText = cipher.doFinal(data.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(cipherText);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error occured while encrypting data", e);
        }

    }

    public static String decrypt(String encryptedString) {
        byte[] decodedKey = Base64.getDecoder().decode(key);
        try {
            Cipher cipher = Cipher.getInstance("AES");
            SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");
            cipher.init(Cipher.DECRYPT_MODE, originalKey);
            byte[] cipherText = cipher.doFinal(Base64.getDecoder().decode(encryptedString));
            return new String(cipherText);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error occured while decrypting data", e);
        }
    }

    public static String encode(Token token) {
        String jsonToken = JsonHelper.toFormat(token).orElse(null);
        return encrypt(jsonToken);
    }

    public static Token decode(String string) {
        return JsonHelper.fromFormat(decrypt(string), Token.class).orElse(null);
    }

}
