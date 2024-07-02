import java.util.ArrayList;

public class Funcs{
    public ArrayList<String> splitString(String n) {
        ArrayList<String> list = new ArrayList<String>();
       
        String currentString = "";
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '.' || n.charAt(i) == ' ' || n.charAt(i) == '!' || n.charAt(i) == '?' || n.charAt(i) == ',') {
                if (!currentString.equals("")) {
                    list.add(currentString);
                }
                currentString = "";
            }
            else {
                currentString += n.charAt(i);
            }
        }
 
        if (!currentString.equals("")) {
            list.add(currentString);
        }
        return list;
    }

    public ArrayList<String> addArray(ArrayList<String> n, ArrayList<Integer> count){
        ArrayList<String> list = new ArrayList<String>();
        for(String v : n){
            list.add(" ");
            count.add(1);
        }
        for(int i = 0; i < n.size(); i++){
            if(list.contains(n.get(i).toLowerCase())){
                count.set(list.indexOf(n.get(i).toLowerCase()),count.get(list.indexOf(n.get(i).toLowerCase()))+1);
            }
            else{
                list.set(i,n.get(i).toLowerCase());
            }
        }
        return list;
    }
}