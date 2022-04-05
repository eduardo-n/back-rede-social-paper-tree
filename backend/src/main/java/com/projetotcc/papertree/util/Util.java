package com.projetotcc.papertree.util;

import java.util.Base64;

public class Util {

	public static String decodeValue(String value) {
		byte[] emailBytes = Base64.getDecoder().decode(value);
		return new String(emailBytes);
	}
}
