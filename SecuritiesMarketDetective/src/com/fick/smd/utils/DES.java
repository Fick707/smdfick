package com.fick.smd.utils;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DES {

	private final static String DES = "DES";

	/**
	 * DES加密的密钥.
	 */
	private final static byte[] PASSWORD_CRYPT_KEY = "5B9&+TwnqVl$pI<Lo}(N*E<Kb5o~(^d)CYQuc%T#zCtz[LrVDQ#VYdgnKPS1gfw8>]UID0T[+AhAC_wGY<j_Od&77u*;70l4B&c:)]LXyEJ'EE$W5}oDf@mDCw{TT1Sq"
			.getBytes();

	/**
	 * 加密
	 * 
	 * @param src
	 *            数据源
	 * @param key
	 *            密钥，长度必须是8的倍数
	 * @return 返回加密后的数据
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] src) throws Exception {
		// DES算法要求有一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		// 从原始密匙数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(PASSWORD_CRYPT_KEY);
		// 创建一个密匙工厂，然后用它把DESKeySpec转换成
		// 一个SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);
		// Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance(DES);
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
		// 现在，获取数据并加密
		// 正式执行加密操作
		return cipher.doFinal(src);
	}

	/**
	 * 解密
	 * 
	 * @param src
	 *            数据源
	 * @param key
	 *            密钥，长度必须是8的倍数
	 * @return 返回解密后的原始数据
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] src) throws Exception {
		// DES算法要求有一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		// 从原始密匙数据创建一个DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(PASSWORD_CRYPT_KEY);
		// 创建一个密匙工厂，然后用它把DESKeySpec对象转换成
		// 一个SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance(DES);
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
		// 现在，获取数据并解密
		// 正式执行解密操作
		return cipher.doFinal(src);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// String cs = "0123456789~!@#$%^&*()_+[]{}QWERTYUIOPLKJHGFDSAZXCVBNMmnbvcxzasdfghjklpoiuytrewq<>:;'";
		// char[] chars = cs.toCharArray();
		// Random ran = new Random();
		// StringBuffer sb = new StringBuffer("");
		// for (int i = 0; i < 128; i++) {
		// sb.append(chars[ran.nextInt(84)]);
		// }
		// System.out.println(sb.toString());

		String name = "$1000$";
		String name2 = "$1000$\n";
		byte[] src = name.getBytes();
		byte[] src2 = name2.getBytes();
		byte[] srcen = encrypt(src);
		byte[] srcen2 = encrypt(src2);
		byte[] srcr = decrypt(srcen);
		byte[] srcr2 = decrypt(srcen2);
		System.out.println(new String(srcr));
		System.out.println(new String(srcr2));

		// byte[] encryptData = encrypt("admin".getBytes());
		// String s = "";
		// for (int i = 0; i < encryptData.length; i++) {
		// s += encryptData[i];
		// }
		// System.out.println(s);
		// byte[] decryptData = decrypt(encryptData);
		// System.out.println(new String(decryptData));

	}
}
