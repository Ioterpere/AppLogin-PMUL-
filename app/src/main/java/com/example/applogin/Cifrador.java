package com.example.applogin;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cifrador {

    static public String generateHash(String texto) {
        MessageDigest md = null;
        byte[] hash = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
            hash = md.digest(texto.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException ex) {
            return "";
        } catch (UnsupportedEncodingException ex) {
            return "";
        }
        return convertToHex(hash);
    }

    static private String convertToHex(byte[] raw) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < raw.length; i++)
            sb.append(Integer.toString((raw[i] & 0xff) + 0x100, 16).substring(1));
        return sb.toString();
    }
}
