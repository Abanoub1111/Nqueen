package N_queens_solver_package;

import FirstScreenGUI.InputScreen;
import java.util.ArrayList; // import the ArrayList class
import N_queens_solver_package.ThreadSolver;

public class N_Qeeens_solver {

    static int N;

    public static void main(String args[]) {
        InputScreen Input = new InputScreen();
        Input.setVisible(true);
        Input.setTitle("N Queen Solver");
        while (InputScreen.CAN_STOP_window() != true);
        N = InputScreen.N;
        Input.setTitle("Processing Please Wait..");
        ArrayList<Thread> threadsArray = new ArrayList<Thread>();
        int count = 0;
        for (int k = 0; k < N; k++) {
            boolean board[][] = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = false;
                }
            }
            board[0][k] = true;
            ThreadSolver thread = new ThreadSolver(board, 1, N, count);
            thread.start();
            threadsArray.add(thread);
            count++;
        }
        
        
        try {
            for (int i = 0; i < threadsArray.size(); i++) {
                threadsArray.get(i).join();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interruption!.");
        }
        Input.setVisible(false);
        new solutionsScreen(N);

    }

    
}