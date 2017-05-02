package utility.tools;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class RandomString {
	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String DIGIT_LIST = "123456789012345678901234567890123456789012345678901234567890";
	private static final int RANDOM_STRING_LENGTH = 150;
	private static final int RANDOM_DIGIT_LENGTH = 150;

	/**
	 * generate a 200 byte AlphaNumeric(each digit in a base 32 number can encode 5 bits)
	 * @return random AlphaNumberic
	 */
	public static String getAlphaNumeric() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(1000, random).toString(32);
	}

	/**
	 * 
	 * @param min
	 * @param max
	 * @return random int in [min, max]
	 */
	public static int getRandomInt(int min, int max) {
		if (min > max) {
			return (Integer) null;
		}
		Random rnd = new Random();
		int num = 0;
		for (int p = 0; p < 1; p++) {
			num = rnd.nextInt(max + 1);
			if (num < min)
				p--;
		}
		return num;
	}

	/**
	 * This method generates random string
	 * 
	 * @return random String
	 */
	 public static String getRandomChar(){
         
	        StringBuffer randStr = new StringBuffer();
	        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
	            int number = generateRandomDigit();
	            char ch = CHAR_LIST.charAt(number);
	            randStr.append(ch);
	        }
	        return randStr.toString();
	    }
	 
	 /**
	  * This method generates random digits
	  * 
	  * @return random ditigs
	  */
	 
	 public static String getRandomDigit(){
         
	        StringBuffer randStr = new StringBuffer();
	        for(int i=0; i<RANDOM_DIGIT_LENGTH; i++){
	            int number = generateRandomDigit();
	            char ch = DIGIT_LIST.charAt(number);
	            randStr.append(ch);
	        }
	        return randStr.toString();
	    }


	/**
	 * This method generates random numbers
	 * 
	 * @return int
	 */
	 public static int generateRandomDigit() {
	        int randomInt = 0;
	        Random randomGenerator = new Random();
	        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
	        if (randomInt - 1 == -1) {
	            return randomInt;
	        } else {
	            return randomInt - 1;
	        }
	    }

}
