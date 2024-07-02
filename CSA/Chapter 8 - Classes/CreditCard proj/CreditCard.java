public class CreditCard {
    private int debt;
    private int limit;
    private String name;
    public CreditCard(String name){
        this.name = name;
        limit = 1000;
    }
    public CreditCard(String name, int limit){
        this.name = name;
        this.limit = limit;
    }
    public boolean makePurchase(int price){
        if(price + debt > limit){
            return false;
        }
        else{
            debt += price;
            return true;
        }
    }
    public void makePayment(int pay){
        debt -= pay;
    }
    public String toString(){
        return name + ": " + debt + " due";
    }
}
