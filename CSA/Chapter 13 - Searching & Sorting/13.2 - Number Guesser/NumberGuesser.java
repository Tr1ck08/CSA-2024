public class NumberGuesser extends NumberGuesserBase {
    /* Things you can use & how your methods should behave...
     *   Your methods should repeatedly call the parent class method guess(int n)
     *   to guess a number, until a match is found. That method returns...
     *       0 : You are correct (you got it!)
     *      -1 : My number is smaller than your guess
     *       1 : My number is larger than your guess
     * Each of your methods should return the correctly guessed number. */

    /* guessNumberBasic() should be a very simple linear/sequential
     *   guesser (i.e. it should guess 1, 2, 3, ... till it finds it).
     *   This method should not attempt to minimize guesses, it is purely 
     *   a linear / sequential guesser. Keep it simple. */
    public int guessNumberBasic() {
        int n = 0;
        while (true){
            if(guess(n) == 0){
                return n;
            }
            if(guess(n) == 1){
                n++;
            }
            if(guess(n) == -1){
                n--;
            }
        }
    }

    /* guessNumberFast() should try to guess the number with the minimum
     *   number of guesses. This is the method I will judge you on. 
     *   Unlike the sequential guesser, this method should attempt to 
     *   minimize the number of guesses it takes to guess the answer. */
    public int guessNumberFast() {
        int min = 0;
        int max = 1000;
        while(min <= max){
            int mid = (max+min)/2;
            int guess = guess(mid);
            if(guess == 0){
                return mid;
            }
            if(guess == -1){
                max = mid-1;
            }
            else if(guess == 1){
                min = mid+1;
            }
        }
        return -1;
    }
}
