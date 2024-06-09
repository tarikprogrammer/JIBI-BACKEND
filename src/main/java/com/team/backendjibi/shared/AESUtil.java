package com.team.backendjibi.shared;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtil {

    private static final String ALGORITHM = "AES";

    //private static final String STATIC_KEY = "aV8rYm0fGT3rmK3yW1rhz45bG5L0JfUI";
    private static final String STATIC_KEY = "y4f6d8g9k3o1q1s7";

    public static SecretKey getStaticKey() {
        return new SecretKeySpec(STATIC_KEY.getBytes(), "AES");
    }

    // Generate a new AES key
    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(128); // Use 128, 192, or 256 bits for the key size
        return keyGen.generateKey();
    }

    // Encrypt a string
    public static String encrypt(String plainText, SecretKey secretKey) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Decrypt a string
    public static String decrypt(String encryptedText, SecretKey secretKey) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedText)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Convert SecretKey to String
    public static String secretKeyToString(SecretKey secretKey) {
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    // Convert String to SecretKey
    public static SecretKey stringToSecretKey(String keyString) {
        byte[] decodedKey = Base64.getDecoder().decode(keyString);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, ALGORITHM);
    }
}

