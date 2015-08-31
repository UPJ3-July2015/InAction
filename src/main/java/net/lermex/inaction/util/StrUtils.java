package net.lermex.inaction.util;

public class StrUtils {

	public static boolean isNullOrEmpty(String s) {
		return ((s == null) || (s.length() == 0)); 
	}
	
    public static boolean isNullOrEmptyTrim(String s) {
    	return ((s == null) || (s.trim().length() == 0));
	}	
	
}
