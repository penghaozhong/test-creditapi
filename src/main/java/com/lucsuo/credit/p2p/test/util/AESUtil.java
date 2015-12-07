package com.lucsuo.credit.p2p.test.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * AES 工具类
 * 
 * @author penghaozhong
 *
 */
public class AESUtil {

	/**
	 * 加密算法
	 * 
	 * @param content
	 * @param password
	 * @return
	 */
	public static byte[] encrypt(String content, String aesKey) {
		try {
			SecretKeySpec key = new SecretKeySpec(Base64.decodeBase64(aesKey), "AES");
			Cipher cipher = Cipher.getInstance("AES");
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			return cipher.doFinal(byteContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密算法
	 * 
	 * @param content
	 * @param password
	 * @return
	 */
	public static byte[] decrypt(String content, String aesKey) {
		Cipher decrypter = null;
		try {
			SecretKey secretKey = new SecretKeySpec(Base64.decodeBase64(aesKey), "AES");
			decrypter = Cipher.getInstance("AES");
			decrypter.init(Cipher.DECRYPT_MODE, secretKey);
			return decrypter.doFinal(Base64.decodeBase64(content));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
