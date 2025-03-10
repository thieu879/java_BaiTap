public class Bt6 {
    public static void main(String[] args) {
        long startTime, endTime;
        String n = "Hello";
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            n += "word";
        }
        endTime = System.currentTimeMillis();
        System.out.println("String: " + (endTime - startTime) + " ms");

        StringBuilder sb = new StringBuilder();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            sb.append("word");
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder: " + (endTime - startTime) + " ms");

        StringBuffer sb2 = new StringBuffer();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            sb2.append("word");
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer: " + (endTime - startTime) + " ms");
    }
}
