package com.mkdika.booris.helper;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author maikel
 */
public class Crypto {

    private static final byte[] HEX_CHAR_TABLE = {
        (byte) '0', (byte) '1', (byte) '2', (byte) '3',
        (byte) '4', (byte) '5', (byte) '6', (byte) '7',
        (byte) '8', (byte) '9', (byte) 'a', (byte) 'b',
        (byte) 'c', (byte) 'd', (byte) 'e', (byte) 'f'
    };

    public static String Md5(String plainText, String salt) {
        try {
            String passwordAndSalt = plainText + "{" + salt + "}";
            MessageDigest md5Digester = MessageDigest.getInstance("MD5");
            byte[] digest = md5Digester.digest(passwordAndSalt.getBytes("UTF-8"));
            return hexString(digest);
        } catch (UnsupportedEncodingException ex) {
            throw new IllegalStateException("UTF-8 not supported!");
        } catch (NoSuchAlgorithmException ex) {
            throw new IllegalStateException("MD5 not supported!");
        }
    }

    public static String hexString(byte[] raw)
            throws UnsupportedEncodingException {
        byte[] hex = new byte[2 * raw.length];
        int index = 0;

        for (byte b : raw) {
            int v = b & 0xFF;
            hex[index++] = HEX_CHAR_TABLE[v >>> 4];
            hex[index++] = HEX_CHAR_TABLE[v & 0xF];
        }
        return new String(hex, "ASCII");
    }

}
