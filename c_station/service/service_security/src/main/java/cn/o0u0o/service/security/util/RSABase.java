package cn.o0u0o.service.security.util;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Component
public class RSABase {
    KeyPairGenerator pairGenerator = null;
    KeyPair pair = null;
    public RSABase(){
        try {
            pairGenerator = KeyPairGenerator.getInstance("RSA");
            pairGenerator.initialize(512,new SecureRandom());
            pair = pairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * 公钥，私钥 获取
     * */
    public static String PublicKey(){
        try {
            KeyPairGenerator pairGenerator = KeyPairGenerator.getInstance("RSA");
            pairGenerator.initialize(512,new SecureRandom());
            KeyPair pair = pairGenerator.generateKeyPair();
            PrivateKey privateKey = pair.getPrivate();          //私钥
            PublicKey publicKey = pair.getPublic();             //公钥

            byte[] encode = Base64.getEncoder().encode(publicKey.getEncoded());
            byte[] encode1 = Base64.getEncoder().encode(privateKey.getEncoded());

            String strPublicKey = new String(encode,"UTF-8");
            String strPrivateKey= new String(encode1,"UTF-8");

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 公钥获取
     * */
    public String getPublicKey(){
        String strPublicKey = null;
        try {
            PublicKey publicKey = pair.getPublic();
            strPublicKey = new String(Base64.getEncoder().encode(publicKey.getEncoded()),"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strPublicKey;
    }

    /**
     * 私钥获取
     * */
    public String getPriveatKey(){
        String strPriveateKey = null;
        try {
            PrivateKey privateKey = pair.getPrivate();
            strPriveateKey = new String(Base64.getEncoder().encode(privateKey.getEncoded()),"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strPriveateKey;
    }

    /**
     * RSA 公钥加密
     * */
    public  String publicKeyEncyData(String Data, String publicKey){
        String result = null;
        try {
            //公钥说明书
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.getMimeDecoder().decode(publicKey.getBytes()));
            //密钥工厂
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey1 = keyFactory.generatePublic(x509EncodedKeySpec);

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE,publicKey1);
            byte[] encData = cipher.doFinal(Data.getBytes("UTF-8"));
            result = Base64.getEncoder().encodeToString(encData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * RSA 私钥解密
     * */
    public  String privKeyDectytData(String Data, String privateKey){
        String result = null;
        try {
            //私钥说明书
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.getMimeDecoder().decode(privateKey.getBytes()));
            //密钥工厂
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey1 = keyFactory.generatePrivate(pkcs8EncodedKeySpec);

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE,privateKey1);
            byte[] decData = cipher.doFinal(Base64.getMimeDecoder().decode(Data));
            result = new String(decData,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
