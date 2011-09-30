package com.gramercysoftware.utils;

public class StringUtils {

	private static final String EMPTY = "";

	public static String center(String original, int finalSize) {
		return center(original, finalSize, " ");
	}
	
	public static String center(String original, int finalSize, String padder) {
		int padSize = finalSize - original.length();
		int leftPad = padSize / 2;
		int rightPad = padSize - leftPad;
		return leftPad(original, leftPad, padder).concat(repeat(rightPad, padder));
	}

	public static String leftPad(String original, int leftPad) {
		return leftPad(original, leftPad, " ");
	}
	
	public static String leftPad(String original, int leftPad, String padder) {
		return repeat(leftPad, padder).concat(original);
	}

	public static String rightPad(String original, int rightPad) {
		return rightPad(original, rightPad, " ");
	}
	
	public static String rightPad(String original, int rightPad, String padder) {
		return original.concat(repeat(rightPad, padder));
	}
	
	public static String repeat(int repeatCount, String padder) {
		StringBuffer padding = new StringBuffer();
		for(int i = 0; i < repeatCount; i++) {
			padding.append(padder);
		}
		return padding.toString();
	}

    public static String substringBefore(String str, String separator) {
        if (isEmpty(str) || separator == null) {
            return str;
        }
        if (separator.length() == 0) {
            return EMPTY;
        }
        int pos = str.indexOf(separator);
        if (pos == -1) {
            return str;
        }
        return str.substring(0, pos);
    }

    public static String substringBeforeLast(String str, String separator) {
        if (isEmpty(str) || isEmpty(separator)) {
            return str;
        }
        int pos = str.lastIndexOf(separator);
        if (pos == -1) {
            return str;
        }
        return str.substring(0, pos);
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
    	return !isEmpty(str);
    }
}
