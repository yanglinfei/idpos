package com.rushay.idpos.util;

import java.security.*;
import java.util.Base64;

/**
 * @description: 加密工具类
 * @author: rushay
 * @create: 2018-11-27 21:01
 **/
public class CryptologyUtil {
    public static String applySha256(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for(int i=0;i<hash.length;i++){
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1){
                    hexString.append(0);
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    public static byte[] applyECDSASig(PrivateKey privateKey, String data){
        Signature dsa;
        try{
            dsa = Signature.getInstance("ECDSA","BC");
            dsa.initSign(privateKey);
            byte[] strByte = data.getBytes();
            dsa.update(strByte);
            return dsa.sign();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static boolean verifyECDSASig(PublicKey publicKey, String data, byte[] signature){
        try {
            Signature edcsaVerify = Signature.getInstance("ECDSA","BC");
            edcsaVerify.initVerify(publicKey);
            edcsaVerify.update(data.getBytes());
            return edcsaVerify.verify(signature);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static String getStringFromKey(Key key){
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

    public static void main(String[] args) {

    }
}
