/*
etermine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> hs = new HashSet<Character>();
        for(int i = 0; i < board.length; i++) {
            hs.clear();
            for(int j = 0; j < board[i].length; j++) {
                if(hs.contains(board[i][j]) && board[i][j] != '.') {
                    return false;
                } else {
                    hs.add(board[i][j]);
                }
            }
        }
        hs.clear();
        for(int i = 0; i < board[0].length; i++) {
            hs.clear();
            for(int j = 0; j < board.length; j++) {
                if(hs.contains(board[j][i]) && board[j][i] != '.') {
                    return false;
                } else {
                    hs.add(board[j][i]);
                }
            }
        }
        hs.clear();
        for(int i = 0; i < 9; i+=3) {
            for(int j = 0; j < 9 ; j+=3) {
                hs.clear();
                for(int k = 0; k < 9; k++) {
                        if(hs.contains(board[i + k / 3][j + k % 3]) && board[i + k / 3][j + k % 3] != '.') {
                        return false;
                    } else {
                        hs.add(board[i + k / 3][j + k % 3]);
                    }
                }
            }
        }
        // int tmp = 0;
        // int tmp2 = 0;
        // for(int k = 0; k < 9; k++) {
        //     hs.clear();
        //     if(0 <= k && k <= 2) {
        //         tmp2 = k;
        //         tmp = 1;
        //     } else if(3 <= k && k <= 5) {
        //         tmp = 2;
        //         tmp2 = k - 3;
        //     } else if(6 <= k && k <= 8) {
        //         tmp = 3;
        //         tmp2 = k - 6;
        //     }
        //     for(int i = (tmp - 1) * 3; i < 3 * tmp; i++) {
        //         for(int j = 3 * tmp2; j < 3 * tmp2 + 3; j++) {
        //             if(hs.contains(board[i][j]) && board[i][j] != '.') {
        //                 return false;
        //             } else {
        //                 hs.add(board[i][j]);
        //             }
        //         }
        //     }
        // }
        return true;
    }
    
//     public boolean isValidSudoku(char[][] board) {
// 		boolean[] visited = new boolean[10];
// 		//row
// 		for(int i=0; i<9; i++) {
// 			Arrays.fill(visited, false);
// 			for(int j=0; j<9; j++) {
// 				if( !check(visited, board[i][j]) ) {
// 					return false;
// 				}
// 			}
// 		}
// 		//col
// 		for(int i=0; i<9; i++) {
// 			Arrays.fill(visited, false);
// 			for(int j=0; j<9; j++) {
// 				if( !check(visited, board[j][i]) ) {
// 					return false;
// 				}
// 			}
// 		}
/*
Good
*/
// 		//sub matrix
// 		for(int i=0; i<9; i+=3) {
// 			for(int j=0; j<9; j+=3) {
// 				Arrays.fill(visited, false);
// 				for(int k=0; k<9; k++) {
// 					if( !check(visited, board[i+k/3][j+k%3]) ) {
// 						return false;
// 					}
// 				}
// 			}
// 		}
// 		return true;
//     }
	
// 	private boolean check(boolean[] visited, char c) {
// 		if(c == '.') {
// 			return true;
// 		}
// 		int num = c - '0';
// 		if(num<1 || num>9 ||visited[num]) {
// 			return false;
// 		} else {
// 			visited[num] = true;
// 		}
// 		return true;
// 	}
}