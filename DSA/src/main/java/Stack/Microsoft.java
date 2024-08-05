package Stack;

public class Microsoft {


    public static void main(String[] args) {
        System.out.println("hello");
        int countRect = 0;
        String[] board = new String[]{"...A", "...A", "...A"};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (ifSameCount(i, j, board)) {
                    countRect++;
                }
            }
        }
        System.out.println(countRect);
    }

    private static boolean ifSameCount(int row, int col, String[] board) {
        int aCount = 0;
        int bCount = 0;
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                if (board[i].charAt(j) == 'A') {
                    aCount++;
                }
                if (board[i].charAt(j) == 'B') {
                    bCount++;
                }
            }
        }
        return aCount == bCount;
    }
}
