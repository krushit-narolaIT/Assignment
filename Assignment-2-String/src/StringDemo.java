public class StringDemo {
    public static void main(String[] args) {
        //String examples
        String str1 = "Hello";
        String str2 = new String("Hello World..!!");

        char[] chars1 = {'H', 'e', 'l', 'l', 'o'};
        String str3 = new String(chars1);

        char[] chars2 = { 'H', 'e', 'l', 'l', 'o' };
        String str4 = new String(chars2, 2, 3);

        byte[] bytes1 = { 97, 98, 99, 100 }; //ASCII values
        String str5 = new String(bytes1);

        byte[] bytes2 = { 65, 66, 67, 68, 69, 70 };
        String str6 = new String(bytes2, 2, 4); // CDEF

        System.out.println("String1 :: " + str1);
        System.out.println("String2 :: " + str2);
        System.out.println("String3 :: " + str3);
        System.out.println("String4 :: " + str4);
        System.out.println("String5 :: " + str5);
        System.out.println("String6 :: " + str6);

        //Operations on String
        System.out.println("Length of str1: " + str1.length());

        // Concatenation
        String concatenated = str1.concat(" World!");
        System.out.println("Concatenated String: " + concatenated);

        // Substring
        String substring = str2.substring(6, 11);
        System.out.println("Substring of str2: " + substring);

        // Character at a specific index
        char charAt = str1.charAt(1);
        System.out.println("Character at index 1 of str1: " + charAt);

        // Index of a character or substring
        int index = str2.indexOf("World");
        System.out.println("Index of 'World' in str2: " + index);

        // Replace characters
        String replaced = str2.replace("World", "Java");
        System.out.println("Replaced String: " + replaced);

        // Convert to uppercase and lowercase
        System.out.println("Uppercase str1: " + str1.toUpperCase());
        System.out.println("Lowercase str2: " + str2.toLowerCase());

        // Trim whitespace
        String strWithSpaces = "   Hello Java   ";
        System.out.println("Trimmed String: '" + strWithSpaces.trim() + "'");

        // Check if a string starts or ends with a specific substring
        System.out.println("Does str2 start with 'Hello'? " + str2.startsWith("Hello"));
        System.out.println("Does str2 end with '!!'? " + str2.endsWith("!!"));

        // String equality
        System.out.println("Is str1 equal to 'Hello'? " + str1.equals("Hello"));
        System.out.println("Is str1 equal to 'hello' (case insensitive)? " + str1.equalsIgnoreCase("hello"));

        // Split a string
        String[] words = str2.split(" ");
        for (String word : words) {
            System.out.println(word);
        }

        // Convert a string to a character array
        char[] charArray = str1.toCharArray();
        for (char c : charArray) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.println("==================================");

        String strBlock = """
            Hello,
                    My Name is Krushit.
                        How are you??
                            i am fine...!!
                """;
        System.out.println("String Block :: \n" + strBlock);
    }
}
