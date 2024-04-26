package globalict.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Random r = new Random(123);
        String s = "";
        for (int i = 0; i < 65536; i++){
            s = s + r.nextInt(2);
        }
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++)
            sb.append(r.nextInt(2));
        s = sb.toString();
        System.out.println(System.currentTimeMillis() - start);
    }

}
