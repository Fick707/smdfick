package com.fick.smd.utils;

import org.junit.Test;

public class ByteUtil {

	/**
	 * 将int类型转换成长度为4的byte数组；
	 * 
	 * @param value
	 * @return
	 */
	public static byte[] integerToBytes(int value) {
		if (value < 0) {
			throw new IllegalArgumentException("Can not cast negative to bytes : " + value);
		}
		byte[] result = new byte[4];

		result[0] = (byte) (value >> 24);
		result[1] = (byte) (value >> 16);
		result[2] = (byte) (value >> 8);
		result[3] = (byte) (value /*>> 0*/);
		return result;
	}

	/**
	 * 将长度为4的byte数组转换为int数值
	 * 
	 * @param bytes
	 * @return
	 */
	public static int bytesToInt(byte[] bytes) {
		return bytes[3] & 0xFF |
				(bytes[2] & 0xFF) << 8 |
				(bytes[1] & 0xFF) << 16 |
				(bytes[0] & 0xFF) << 24;
	}

	@Test
	public void test() {
		int v = 11111;
		byte[] bs = integerToBytes(v);
		System.out.println(bs);
		int vv = bytesToInt(bs);
		System.out.println(vv);
	}

}
