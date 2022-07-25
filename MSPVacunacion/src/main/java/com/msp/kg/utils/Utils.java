package com.msp.kg.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

	public static boolean validaCedula(String document) {
		byte sum = 0;
		try {
			if (document.trim().length() != 10)
				return false;
			String[] data = document.split("");
			byte verifier = Byte.parseByte(data[0] + data[1]);
			if (verifier < 1 || verifier > 24)
				return false;
			byte[] digits = new byte[data.length];
			for (byte i = 0; i < digits.length; i++)
				digits[i] = Byte.parseByte(data[i]);
			if (digits[2] > 6)
				return false;
			for (byte i = 0; i < digits.length - 1; i++) {
				if (i % 2 == 0) {
					verifier = (byte) (digits[i] * 2);
					if (verifier > 9)
						verifier = (byte) (verifier - 9);
				} else
					verifier = (byte) (digits[i] * 1);
				sum = (byte) (sum + verifier);
			}
			if ((sum - (sum % 10) + 10 - sum) == digits[9])
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean validaCorreo(String correo) {
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher mather = pattern.matcher(correo);
		return mather.find();
	}

	public static boolean validaLetras(String cadena) {
		Pattern pattern = Pattern.compile("^[a-zA-Z\s]*$");
		Matcher mather = pattern.matcher(cadena);
		return mather.find();
	}
}
