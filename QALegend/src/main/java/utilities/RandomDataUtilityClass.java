package utilities;





import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;

public class RandomDataUtilityClass {
	
	static Faker faker;
	static String fName;
	static String lName;
	static String prefix;
	static String randomStringEmail;
	static String username;
	static String password;
	
	public static String getfName() {
		faker = new Faker(new Locale("en-IND"));
		fName = faker.name().firstName();
		return fName;
	}
	
	public static String getlName()
	{
		faker=new Faker(new Locale("en-IND"));
		lName=faker.name().lastName();
		return lName;
	}
	
	public static String getPrefix()
	{
		faker=new Faker(new Locale("en-IND"));
		prefix=faker.name().prefix();
		return prefix;
		
	}
	
	 public static String getRandomEmail() {
	        String alphabet = "abcdefghijklmnopqrstuvwxyz";
	        StringBuilder sb = new StringBuilder();
	        Random random = new Random();
	        int length = 5;
	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(alphabet.length());
	            char randomChar = alphabet.charAt(index);
	            sb.append(randomChar);
	        }
	        String randomStringEmail = sb.toString() + "@gmail.com";
	        return randomStringEmail;
	        
	    }
	 
	 
	 public static String getUsername()
	 {
		 faker=new Faker(new Locale("en-IND"));
		 username=faker.name().username();
		 return username;
	 }
	 
	 public static String getPassword()
	 {
		 faker=new Faker(new Locale("en-IND"));
		 password=faker.internet().password();
		 return password;
	 }

	
	

}
