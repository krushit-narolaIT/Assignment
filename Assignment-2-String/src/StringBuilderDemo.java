public class StringBuilderDemo {
    public static void main(String[] args) {
        // Creation of StringBuilder using its constructors
        StringBuilder sb1 = new StringBuilder();

        CharSequence sequence = "Hello World..!!!";
        StringBuilder sb2 = new StringBuilder(sequence);

        StringBuilder sb3 = new StringBuilder("Hello World..!!");

        StringBuilder sb4 = new StringBuilder(10);

        System.out.println("SB1 :: " + sb1);
        System.out.println("SB2 :: " + sb2);
        System.out.println("SB3 :: " + sb3);
        System.out.println("SB4 :: " + sb4);

        // Operations on StringBuilder
        System.out.println();
        StringBuilder sb5 = new StringBuilder("Hello, My Name is");
        System.out.println("SB5 :: " + sb5);

        // Appending strings and other data types
        sb5.append(" Krushit");
        System.out.println("After Appending :: " + sb5);

        sb5.append(true);
        System.out.println("After Appending :: " + sb5);

        System.out.println("Capacity :: " + sb5.capacity());

        // inserting at a specific position
        sb5.insert(13, " Developer");
        System.out.println("After Inserting :: " + sb5);

        sb5.replace(0, 5, "Hi");
        System.out.println("After Replacing :: " + sb5);

        sb5.delete(3, 15);
        System.out.println("After Deleting :: " + sb5);

        // Reverse the string
        sb5.reverse();
        System.out.println("After Reversing :: " + sb5);

        sb5.reverse();
        sb5.setCharAt(5, 'X');
        System.out.println("After Setting Char :: " + sb5);

        // substring operation
        String substring = sb5.substring(7, 16);
        System.out.println("Substring (7, 16) :: " + substring);

        // Ensuring capacity
        sb5.ensureCapacity(50);
        System.out.println("Size :: " + sb5.length());
        System.out.println("Capacity after increasing:: " + sb5.capacity());

        Thread th1 = new Thread("th1");
    }
}
