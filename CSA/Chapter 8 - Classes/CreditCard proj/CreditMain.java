public class CreditMain{
    public static void main(String[] args){
        CreditCard tom = new CreditCard("tom");
        tom.makePurchase(1000);
        tom.makePayment(500);
        System.out.print(tom);
        
    
    }
}
