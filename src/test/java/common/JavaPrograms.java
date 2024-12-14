package common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.openqa.selenium.By;

public class JavaPrograms {

	// public static void main(String[] args) {
	// //Unqiue Numbers Printing
	// int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2 };
	// HashSet<Integer> unqiuenumbers = new HashSet<>();
	// for (int nums : numbers) {
	// unqiuenumbers.add(nums);
	// }
	// System.out.println(unqiuenumbers);
	// for (int number : unqiuenumbers) {
	// System.out.println(number);
	// }
	// }

	// -------------------------------------------

//	public static void main(String[] args) {
//		String reverse = "RAVITEJA";
//		String reversed = new StringBuilder(reverse).reverse().toString();
//		System.out.println(" String Reversed: "+reversed);
//	}
//}

//-------------------------------------------

//	public static void main(String[] args) {
//		String name = "RAVITEJA12345";
//		char n = name.charAt(0);
//		String letters = name.replaceAll("[^a-zA-Z]", "");
////        String letters = input.replaceAll("[^a-zA-Z]", ""); // Replace all non-alphabetic characters with an empty string
//		String concat = name.concat("SUBBU");
//		System.out.println(" String at 0: " + n);
//		System.out.println(" letters in String value: " + letters);
//		System.out.println(" letters in String value: " + concat);
//
//		String numbers = name.replaceAll("[^0-9]", "");
//		System.out.println("Numbers in String value: " + numbers);
//
//	}

	public static void main(String[] args) {
		        Map<Integer, Integer> mp = new HashMap<>();
		        mp.put(1, 1);
		        mp.put(2, 2);
		        mp.put(4, 4);
		        mp.put(3, 3);
		        mp.put(4, 4); // Duplicate key, ignored
		        mp.put(91, 91);

		        // Retrieve a specific value
		        System.out.println("Value for key 91: " + mp.get(91));

		        // Print all entries in the map
		        System.out.println("All entries in the map: " + mp.entrySet());

		        // Iterating over the map using entrySet()
		        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
		            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		        }
		    }
}
