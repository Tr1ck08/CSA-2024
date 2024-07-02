public class AppMain {
    public static void main(String[] args) {
        Cumulative cumulative = new Cumulative();
        System.out.println("-------- alphabet --------");
        System.out.println(cumulative.alphabet('y', 6));
        System.out.println(cumulative.alphabet('a', 5));
        System.out.println(cumulative.alphabet('c', 4));


        System.out.println("------- factorSum --------");
        System.out.println(cumulative.factorSum(6));
        System.out.println(cumulative.factorSum(14));


        System.out.println("------- isPerfect --------");
        System.out.println(cumulative.isPerfect(6));

        }
}
