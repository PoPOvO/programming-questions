package org.xli.palindrome_string;

public class PalindromeString {
	public PalindromeString() {
	}
	
	public boolean authString(String str) {
		for (int i = 0; i < str.length(); i++) {                                       //Öð´ÎÉ¾³ýÔ´´®µÄ×Ö·û
			if (auth(str.substring(0, i) + str.substring(i+1, str.length()))) {
				return true;
			}
		}
		return false;
	}
	
	private boolean auth(String str) {
		for (int i = 0; i < str.length()/2; i++) {
			if (str.codePointAt(i) != str.codePointAt(str.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new PalindromeString().authString("abca"));
	}
}
