/* The Board stores the state of the Tic-Tac-Toe board */
public class Board {
    public static final String empty = " ";

    // 3x3 array of single character Strings. This stores the current
    //  state of the board. After construction, it is guarenteed to
    //  contain nine String elements. 
    // Each element stores one of the following...
    //    Board.empty, HumanPlayer.marker, or AiPlayer.marker
    private String[][] board; 

    public Board() {
        board = new String[3][3];
        reset();
    }

    // Reset board so that each element is a an empty string (use Board.empty)
    //  postcondition: board is a 3x3 array. all elements are Board.empty.
    public void reset() {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = Board.empty;
            }
        }
    }

    // Returns the number of rows in the board
    public int rows() {
        return board.length;
    }

    // Returns the number of columns in the board
    public int columns() {
        return board[0].length;
    }

    // Returns true if the specified row/column space is empty 
    //  (does not already store an X or O)
    //  You can assume r & c are valid values.
    public boolean isEmpty(int r, int c) {
        return(board[r][c].equals(Board.empty));
    }

    // Returns the String marker at the specified row/column (e.g. "X")
    //  You can assume r & c are valid values.
    public String getMarkerAt(int r, int c) {
        return board[r][c];
    }

    // Creates and returns a String that can be printed display the board.
    //  Example return value: " X |   | O \n-----------\n O | X |   \n-----------\n   |   | O "
    public String renderToString() {
        String temp = " ";
        for(int i = 0; i < rows(); i++){
            for(int j = 0; j < columns(); j++){
                temp += getMarkerAt(i,j);
                if(j != 2){
                    temp += " | ";
                }
            }
            if(i != 2){
                temp += "\n-----------\n ";
            }
        }
        return temp;
    }

    // Returns the number of empty spaces on the board. 
    //  An empty board (at the start of the game) would return 9.
    //  After both players have places one mark, it would return 7.
    public int numberEmpty() {
        int temp = 0;
        for(int i = 0; i < rows(); i++){
            for(int j = 0; j < columns(); j++){
                if(board[i][j].equals(Board.empty)){
                    temp++;
                }
            }
        }
        return temp;
    }

    // Update the board with the specified move applied.
    //  You can assume it is a valid move.
    public void placeMark(Move move) {
        board[move.r][move.c] = move.mark;
    }

    // Determines if there is a winner, based on the current board state.
    //  Note that in the case that no one has won, it returns 0.
    //  Returns: 0:none, 1:human(HumanPlayer.marker), 2:AI(AiPlayer.marker)
    public int calcWinner() {
        for(int r = 0; r < rows(); r++){
            if(board[r][0].equals(board[r][1]) && board[r][0].equals(board[r][2]) && !board[r][0].equals(Board.empty)){
                return getMarkerAt(r,0).equals("X") ? 1 : 2;
            }
        }
        for(int j = 0; j < columns(); j++){
            if(board[0][j].equals(board[1][j]) && board[0][j].equals(board[2][j]) && !board[0][j].equals(Board.empty)){
                return getMarkerAt(0,j).equals("X") ? 1 : 2;
            }
        }
        if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].equals(Board.empty)){
            return getMarkerAt(0,0).equals("X") ? 1 : 2;
        }
        if(board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && !board[0][2].equals(Board.empty)){
            return getMarkerAt(2,0).equals("X") ? 1 : 2;
        }
        return 0;
    }
}
