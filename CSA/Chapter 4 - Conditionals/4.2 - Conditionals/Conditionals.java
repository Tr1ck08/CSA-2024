public class Conditionals {
    public boolean firstStars(String text) {
        // Returns true under the following conditions (false in all others).
        //  If the string has three or less characters, then all characters must be stars/asterisks.
        //  If the string has more than three characters, then the first three must be stars/asterisks.
        
        // Examples...
        //  minThreeStars("**") -> true
        //  minThreeStars("*-") -> false
        //  minThreeStars("***abc") -> true
        //  minThreeStars("**a*") -> false
        if(text.length() <= 3){
            for(int i = 0; i < text.length(); i++){
                if(text.charAt(i) != '*'){
                    return false;
                }
            }
            return true;
        }
        else{
            for(int i = 0; i < 3; i++){
                if(text.charAt(i) != '*'){
                    return false;
                }
            }
            return true;
        }
    }

    public boolean compareDouble(double number, double expected) {
        // Returns true if number is close to expected.
        //  Use the constant EPSILON, defined in AppMain for this function.
        //  If number is within EPSILON of expected (exclusive), then return true. False otherwise.
        
        // Examples...
        //  compareDouble(6.001, 6) -> true
        //  compareDouble(6.011, 6) -> false
        //  compareDouble(-1.1, -1) -> false
        if(number <= expected && expected <= number + AppMain.EPSILON || number >= expected && expected >= number - AppMain.EPSILON){
            return true;
        }
        return false;
    }

    public boolean logicCheck(int x, int y, boolean b) {
        // Rewrite the following logic into a single return statement.
        //  You cannot use any if statements, only a single return statement.
        //  The logic should remain the same.
        return (x>10) || ((x>y) && b);
    }
}
