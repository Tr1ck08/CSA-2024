import java.util.ArrayList;
public class AppMain {
    public static void main(String[] args) {
        Practice practice = new Practice();

        System.out.println("-------- toArrayList --------");
        String[] a = {"a","b","c"};
        String[] b = {"aaa","cccc", "dddd"};
        System.out.println(practice.toArrayList(a));
        System.out.println(practice.toArrayList(b));
        System.out.println("\n-------- reverseList --------");
        String[] c = {"a","b","c"};
        String[] d = {"aaa","cccc", "dddd"};
        System.out.println(practice.reverseList(c));
        System.out.println(practice.reverseList(d));
        System.out.println("\n-------- splitString --------");
        System.out.println(practice.splitString("This is a test"));
        System.out.println(practice.splitString("aoewjuiaweihwae,   arejiaerae, !aewae .awe"));
        System.out.println("\n-------- justPrimes --------");
        int[] e = {1,2,3,4,5,6,7};
        int[] g = { 1, 3, 4, 7, 8, 11 };
        System.out.println(practice.justPrimes(e));
        System.out.println(practice.justPrimes(g));
    }
}
