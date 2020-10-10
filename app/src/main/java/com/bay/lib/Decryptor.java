package com.bay.lib;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
public class Decryptor
{
	private static SecretKeySpec secretKey;
    private static byte[] key;

	public static String Run(String enc){
		try
        {
            setKey(Keys());
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(enc)));
        } 
        catch (Exception e) 
        {}
		return null;
	}

	private static String Keys()
	{
		String hx = "62617975";
		
		return hxt(hx);
	}
	public static void setKey(String myKey) 
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKey = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
	public static String hxt(String hex) 
    { 
        String ascii = ""; 
        for (int i = 0; i < hex.length(); i += 2) { 
            String part = hex.substring(i, i + 2); 
            char ch = (char)Integer.parseInt(part, 16);
            ascii = ascii + ch; 
        } 
        return ascii; 
    }
	public static String encrypt(String strToEncrypt) 
    {
        try
        {
            setKey(Keys());
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } 
        catch (Exception e) 
        {

        }
        return null;
    }

}
