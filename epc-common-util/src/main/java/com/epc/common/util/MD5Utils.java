package com.epc.common.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * <p>Description : MD5Utils
 * <p>Date : 2018-09-09 16:45
 * <p>@Author : wjq
 */
public class MD5Utils {

	protected MD5Utils(){

	}

	private static final String SALT = "ecp";

	private static final String ALGORITH_NAME = "md5";

	private static final int HASH_ITERATIONS = 2;

	public static String encrypt(String password) {
		return new SimpleHash(ALGORITH_NAME, password, ByteSource.Util.bytes(SALT), HASH_ITERATIONS).toHex();
	}

	public static String encrypt(String phone, String password) {
		return new SimpleHash(ALGORITH_NAME, password, ByteSource.Util.bytes(phone + SALT), HASH_ITERATIONS).toHex();
	}

}
