import java.util.ArrayList;

public class Print {
    Funcs funcs = new Funcs();
    public void sortPoem(ArrayList<String> list, ArrayList<Integer> count){
        for(int i = 0; i < list.size(); i++){

        }
    }
    public void printPoem(ArrayList<String> list, ArrayList<Integer> count, ArrayList<String> temp, String poem){
        temp = funcs.splitString(poem);
        list = funcs.addArray(temp,count);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) != " "){
                System.out.println(list.get(i) +" " + count.get(i));
            }
        }
    }   
}
