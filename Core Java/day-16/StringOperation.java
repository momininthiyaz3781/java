package day16;

//task:2
//String Operations Write a method that takes two strings, concatenates them, reverses the result, and then extracts the middle substring of the given length. Ensure your method handles edge cases, such as an empty string or a substring length larger than the concatenated string. show this code in java

public class StringOperation {
  public static void main(String[] args) {
      String str1 = "hello";
      String str2 = "world";
      int substringLength = 5;

      try {
          String result = processStrings(str1, str2, substringLength);
          System.out.println("Result: " + result);
      } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
      }
  }

  public static String processStrings(String str1, String str2, int length) {
      if (str1 == null) str1 = "";
      if (str2 == null) str2 = "";
      
      String concatenated = str1 + str2;
      if (concatenated.isEmpty()) {
          throw new IllegalArgumentException("The concatenated string is empty.");
      }

      String reversed = new StringBuilder(concatenated).reverse().toString();

      if (length > reversed.length()) {
          throw new IllegalArgumentException("The requested substring length is greater than the length of the reversed string.");
      }

      int startIndex = (reversed.length() - length) / 2;
      return reversed.substring(startIndex, startIndex + length);
  }
}