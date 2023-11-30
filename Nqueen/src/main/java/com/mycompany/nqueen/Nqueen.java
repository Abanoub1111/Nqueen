package com.mycompany.nqueen;

import java.util.Arrays;
import java.util.ArrayList; // import the ArrayList class
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
//import N_queens_solver_package.SolutionOBJ;


public class Nqueen extends Thread {
    public static List<SolutionOBJ> solutions = Collections.synchronizedList(new ArrayList<SolutionOBJ>());
    boolean[][] board;
    int col;
    static int N;
    int TN;
    
    public Nqueen(boolean[][] board, int col, int N, int TN) {
    this.board = board;
    this.col = col;
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
    if (row == board.length) {
        addSolution(new SolutionOBJ(board, TN));
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
        theBt(board, col, TN);
    }
    
    private static void addSolution(SolutionOBJ solution) {
        
        boolean[][] copiped_board = new boolean[N][N];
        for (int i = 0; i < solution.board.length; i++) {
            boolean[] aMatrix = solution.board[i];
            int aLength = solution.board.length;
            copiped_board[i] = new boolean[N];
            System.arraycopy(aMatrix, 0, copiped_board[i], 0, aLength);
        }
        solutions.add(new SolutionOBJ(copiped_board, solution.TN));
    }
   
}
