public class Comparision {
    public static void main(String[] args) {
        String str = new String("Hello");
        StringBuffer strBuff = new StringBuffer("Hello");
        StringBuilder strBuil = new StringBuilder("Hello");

        long startTime = System.currentTimeMillis();

        for(int i=0;i<100000;i++){
            str = str.concat("lo");
            //str.toLowerCase();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken by String using concat():: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();

        for(int i=0;i<100000;i++){
            str+="lo";
        }

        endTime = System.currentTimeMillis();
        System.out.println("Time Taken by String using '+':: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();

        for(int i=0;i<100000;i++){
            str = str.join(" ", "lo");
        }

        endTime = System.currentTimeMillis();
        System.out.println("Time Taken by String using join():: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();

        for(int i=0;i<100000;i++){
            strBuff.append("lo");
        }

        endTime = System.currentTimeMillis();
        System.out.println("Time Taken by StringBuffer :: " + (endTime - startTime) + " ms");
    }
}
