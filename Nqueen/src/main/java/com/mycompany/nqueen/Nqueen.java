package N_queens_solver_package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import N_queens_solver_package.SolutionOBJ;

public class SolverThread extends Thread {

    private static volatile SolutionOBJ Solution;
    private static volatile boolean solutionFound = false;
    boolean[][] board;
    int col;
    int row;
    static int N;
    int TN;

    public SolverThread(boolean[][] board, int row, int N, int TN) {
        this.board = board;
        this.row = row;
        this.N = N;
        this.TN = TN;
    }

    private static boolean isValid(boolean[][] board, int row, int col) { //already mfe4 7aga t7teh fa m4 lazm a check ta7teh
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

    private static void theBt(boolean[][] board, int row, int TN) {
        if (row == board.length && !solutionFound) {
            addSolution(board, TN);
            solutionFound = true;
            return;
        }

        for (int i = 0; i < board.length && !solutionFound; i++) {
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

    private static synchronized void addSolution(boolean[][] boardWithSolution, int TN) {
        boolean[][] copiedBoard = new boolean[boardWithSolution.length][boardWithSolution.length];
        for (int i = 0; i < boardWithSolution.length; i++) {
            copiedBoard[i] = boardWithSolution[i].clone();
        }
        Solution = new SolutionOBJ(copiedBoard, TN);
    }
    public static SolutionOBJ getSolution() {
        return Solution;
    }
    
    public static boolean isSolutionFound() {
        return solutionFound;
    }
}
