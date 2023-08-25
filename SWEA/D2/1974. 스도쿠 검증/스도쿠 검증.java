import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
         
        loop :
        for (int tc = 1; tc<=t; tc++) {
            int[][] sudoku = new int[9][9];
            for (int i = 0; i<9; i++) {
                for (int j = 0; j<9; j++) {
                    sudoku[i][j] = sc.nextInt();
                }
            }
             
            Set<Integer> s = new HashSet<Integer>();
             
            //가로탐색
            for (int i = 0; i<9; i++) {
                for (int j = 0; j<9; j++) {
                    if (!s.contains(sudoku[i][j]))
                        s.add(sudoku[i][j]);
                    else {
                        System.out.println("#" + tc + " 0");
                        continue loop;
                    }
                }
                s.clear();
            }
            //세로탐색 
            for (int i = 0; i<9; i++) {
                for (int j = 0; j<9; j++) {
                    if (!s.contains(sudoku[j][i]))
                        s.add(sudoku[j][i]);
                    else {
                        System.out.println("#" + tc + " 0");
                        continue loop;
                    }
                }
                s.clear();
            }
            //3*3탐색 
            for (int a = 0; a<3; a++) {
                for (int b = 0; b<3; b++) {
                    for (int i = 0; i<3; i++) {
                        for (int j = 0; j<3; j++) {
                            if (!s.contains(sudoku[a*3 + i][b*3 + j]))
                                s.add(sudoku[a*3 + i][b*3 + j]);
                            else {
                                System.out.println("#" + tc + " 0");
                                continue loop;
                            }
                        }
                    }
                    s.clear();
                }
            }
            System.out.println("#" + tc + " 1");
        }
        sc.close();
    }
}