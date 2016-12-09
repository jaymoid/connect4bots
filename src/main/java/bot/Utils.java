package bot;

public class Utils {

    public static String prettyPrintBoard(int[][] board) {
        String boardStr = "";
        for (int col = board[0].length-1; col >= 0; col--) {
            for (int row = 0; row < board.length; row++) {
                boardStr += String.format("[%d] ", board[row][col]);
            }
            boardStr += System.lineSeparator();
        }
        return boardStr;
    }

}
