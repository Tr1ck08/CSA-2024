public class Series {
    private int n;
    private Sequence seq;

    public Series(int n, Sequence seq){
        this.n = n;
        this.seq = seq;
    }
    public int returnSeries(){
        int num = 0;
        for(int i = 0; i < n; i++){
            num += seq.returnA() + (seq.returnD1() * i);
        }
        return num;
    }
}
