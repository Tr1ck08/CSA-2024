public class Sequence {
    private int a;
    private int d1;
    private int n;

    public Sequence(int a, int d1, int n){
        this.a = a;
        this.d1 = d1;
        this.n = n;
    }

    public String returnSequence(){
        String num = "";
        for(int i = 0; i < n; i++){
            num +=a+(d1*i);
            if(i+1 != n){
                num += ", ";
            }
            else{
                num += ", ...";
            }
        }
        return num;
    }
    
    public int returnA(){
        return a;
    }
    public int returnD1(){
        return d1;
    }
    public int returnN(){
        return n;
    }
}
