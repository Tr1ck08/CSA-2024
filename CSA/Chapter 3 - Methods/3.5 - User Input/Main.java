public class Main {
    public static void main(String[] args){
        System.out.print(leapYears(2020,2025));
    }

    public static int leapYears(int year1, int year2){
        int years = 0;
        for(int i = year1; i <= year2; i++){
            if(i % 4 == 0){
                years++;
            }
        }
        return years;
}
}
