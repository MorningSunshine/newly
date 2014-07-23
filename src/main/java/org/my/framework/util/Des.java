package org.my.framework.util;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class Des {

	private final static String DES = "DES";

	public static String encrypt(String srcStr, String keyStr) throws Exception {
		if (srcStr != null) {
			byte[] key = hex2byte(keyStr);
			byte[] src = srcStr.getBytes("GB2312");
			SecureRandom sr = new SecureRandom();
			DESKeySpec dks = new DESKeySpec(key);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
			SecretKey securekey = keyFactory.generateSecret(dks);
			Cipher cipher = Cipher.getInstance(DES);
			cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
			//byte[] tempby = cipher.doFinal(src);
			return byte2hex(cipher.doFinal(src));
		} else {
			return null;
		}
	}

	public static byte[] encrypt(byte[] src, String keyStr) throws Exception {
		if (src != null) {
			byte[] key = hex2byte(keyStr);
			SecureRandom sr = new SecureRandom();
			DESKeySpec dks = new DESKeySpec(key);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
			SecretKey securekey = keyFactory.generateSecret(dks);
			Cipher cipher = Cipher.getInstance(DES);
			cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
			byte[] tempby = cipher.doFinal(src);
			return tempby;
		} else {
			return null;
		}
	}

	public static byte[] decrypt(byte[] src, String keyStr) throws Exception {
		if (src != null) {
			byte[] key = hex2byte(keyStr);
			// byte[] src = hex2byte(srcStr);
			SecureRandom sr = new SecureRandom();
			DESKeySpec dks = new DESKeySpec(key);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
			SecretKey securekey = keyFactory.generateSecret(dks);
			Cipher cipher = Cipher.getInstance(DES);
			cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
			return cipher.doFinal(src);
		} else {
			return null;
		}
	}

	public static String decrypt(String srcStr, String keyStr) throws Exception {
		if (srcStr != null) {
			byte[] key = hex2byte(keyStr);
			byte[] src = hex2byte(srcStr);
			SecureRandom sr = new SecureRandom();
			DESKeySpec dks = new DESKeySpec(key);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
			SecretKey securekey = keyFactory.generateSecret(dks);
			Cipher cipher = Cipher.getInstance(DES);
			cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
			return new String(cipher.doFinal(src), "GB2312");
		} else {
			return null;
		}
	}

	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
		}
		return hs;
	}

	private static byte[] hex2byte(String src) {
		byte[] bt = new byte[src.length() / 2];
		int k = 0;
		for (int i = 0; i < src.length(); i = i + 2) {
			Integer inte = new Integer(Integer.parseInt(
					src.substring(i, i + 2), 16));
			bt[k] = inte.byteValue();
			k++;
		}
		return bt;
	}
}
