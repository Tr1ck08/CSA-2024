public class AppMain {
    public static final double EPSILON = 0.01;
    public static void main(String[] args) {
        Conditionals conditionals = new Conditionals();
        System.out.println("-------- firstStars --------");
        System.out.println(conditionals.firstStars("**"));
        System.out.println(conditionals.firstStars("*-"));
        System.out.println(conditionals.firstStars("***abc"));
        System.out.println(conditionals.firstStars("**a*"));

        System.out.println("------ compareDouble -------");
        System.out.println(conditionals.compareDouble(6.001,6));
        System.out.println(conditionals.compareDouble(6.011,6));
        System.out.println(conditionals.compareDouble(-1.1,-1));

        System.out.println("-------- logicCheck --------");
        System.out.println(conditionals.logicCheck(5,6,true));
        System.out.println(conditionals.logicCheck(11,6,true));
    }
}
