package test;

import utility.tools.RandomString;

public class TestRandomString {

	public static void main(String[] args) {

		System.out.println(RandomString.getRandomInt(2, 100));
		System.out.println(RandomString.getAlphaNumeric().substring(0, 9));
		System.out.println(RandomString.getRandomChar().substring(0, 19));
		System.out.println(RandomString.getRandomDigit().substring(0, 8));
		System.out.println(RandomString.generateRandomDigit());
	}

}
