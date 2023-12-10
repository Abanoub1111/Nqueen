

package nqueen;



import java.util.* ;
import nqueen.SolutionOBJ;
import nqueen.Nqueen;

public class Main {
    static int N ;
    public static void main(String[] args) {
        try (Scanner input =new Scanner(System.in)) {
            while (true){
                System.out.println("Enter the number of Queens :");
                N = input.nextInt();
                if ( N == 2 || N ==3) {
                    System.out.println("No Solution possible for "+ N +" Queens. Please enter another number");
                }
                else
                    break;
            }
        }
        ArrayList<Thread> ThArray = new ArrayList<Thread>();
        int count = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col< N; col++) {
                boolean board[][] = new boolean[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N;j++) {
                        board[i][j] = false;
                    }
                }
                board[row][col] = true;
                Nqueen thread = new Nqueen(board, 1, N, count);
                thread.start();
                ThArray.add(thread);
                count++;
            }
        }
        try {
            for (int i = 0; i < ThArray.size(); i++) {
                ThArray.get(i).join();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interruption!.");
        }
       

    }

    public static void printSolution(SolutionOBJ solution) {
        System.out.println( " Thread NO. " + solution.TN );
        for (int row = 0; row < N; row++) {
            System.out.print("║");
            for (int col= 0; col < N; col++) {
                if (col< N - 1) {
                    if (solution.board[row][col] == true) {
                        System.out.print('Q' + " ");
                    } else {
                        System.out.print('─' + " ");
                    }
                } else {
                    if (solution.board[row][col] == true) {
                        System.out.print('Q');
                    } else {
                        System.out.print('─');
                    }
                }
            }
            System.out.print("║");
            System.out.println();
        }

    }
}

        
        
    
