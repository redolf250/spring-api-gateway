package com.redolf.apikeygenerator.utils;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

@UtilityClass
public class KeyGenerator {
    private String generateRandomString() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[32];
        secureRandom.nextBytes(randomBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }

    public String generateApiKey(@NonNull String message) throws Exception {
        String algorithm = "HmacSHA256";
        String key = generateRandomString();
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
        Mac mac = Mac.getInstance(algorithm);
        mac.init(secretKeySpec);
        byte[] hmacBytes = mac.doFinal(message.getBytes());
        return Base64.getUrlEncoder().withoutPadding().encodeToString(hmacBytes);
    }
}
