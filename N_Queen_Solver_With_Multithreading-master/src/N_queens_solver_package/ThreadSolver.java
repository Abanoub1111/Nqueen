package N_queens_solver_package;

import java.util.ArrayList;
import java.util.List;

public class ThreadSolver extends Thread {

    public static List<Sol_OBJ> solutions = new ArrayList<>();
    boolean[][] board;
    int col;
    int row;
    static int N;
    int TN;

    public ThreadSolver(boolean[][] board, int row, int N, int TN) {
        this.board = board;
        this.row = row;
        this.N = N;
        this.TN = TN;
    }

    private boolean isValid(boolean[][] board, int row, int col) { //already mfe4 7aga t7teh fa m4 lazm a check ta7teh
        for (int i = 0; i < row; i++) { //CHECK COLUMN
            if (board[i][col] == true) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) { //CHECK LEFT DIAGONAL
            if (board[i][j] == true) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) { //CHECK RIGHT DIAGONAL
            if (board[i][j] == true) {
                return false;
            }
        }
        for (int i = 0; i < N; i++) { //CHECK ROW
            if (board[row][i] == true) {
                return false;
            }
        }

        return true;
    }

    private void theBt(boolean[][] board, int row, int TN) {
        if (row == board.length) {
            addSolution(new Sol_OBJ(board, TN));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (isValid(board, row, i)) {
                board[row][i] = true;
                theBt(board, row + 1, TN);
                board[row][i] = false;
            }
        }
    }

    @Override
    public void run() {
        theBt(board, row, TN);
    }

    private synchronized void addSolution(Sol_OBJ solution) {
        boolean[][] copiedBoard = new boolean[solution.board.length][solution.board.length];
        for (int i = 0; i < solution.board.length; i++) {
            copiedBoard[i] = solution.board[i].clone();
        }
        solutions.add(new Sol_OBJ(copiedBoard, TN));
    }

    public static List<Sol_OBJ> getAllSolutions() {
        return solutions;
    }
}
