   //Solution 1
    public boolean isValidSudoku(char[][] board) {
        //row, col, and grid
       boolean[] valid = new boolean[9*9 + 9*9 + 9*9];
       //这个想法是用一个boolean数组来记录横竖和方格的九宫格，因为board的size是固定的
        //所以前9*9表示横九宫格，9*9 + 9*j表示竖九宫格
        //9*9 + 9*9 + ((i/3)*3 + (j/3))*9 表示方格九宫格
        int val;
       for(int i = 0; i < 9; i++){
           for(int j = 0; j < 9; j++){
               if(board[i][j] == '.') continue;
               else{
                   val = board[i][j] - '1';
               }
               int row_x = i*9 + val;
               int col_x = 9*9+ j*9 + val;
               int grid_x = 9*9 + 9*9 + ((i/3)*3 + (j/3))*9 + val;               
               if(valid[row_x] || valid[col_x] || valid[grid_x]) return false;
               else{
                   valid[row_x] = true;
                   valid[col_x] = true;
                   valid[grid_x] = true;
               }  
           }
       }
        return true;
    }

    //Solution 2
        public boolean isValidSudoku(char[][] board) {
        //或者是利用hashset，那么一共需要9*3个set
        int val;
       for(int i = 0; i < 9; i++){
           HashSet<Character> row = new HashSet<>();
           HashSet<Character> col = new HashSet<>();
           HashSet<Character> grid = new HashSet<>();
           for(int j = 0; j < 9; j++){
             if(board[i][j] != '.' && !row.add(board[i][j])) return false;
             if(board[j][i] != '.' && !col.add(board[j][i])) return false;
               
              //这个我想了好久啊，不知道怎么解释了，就是将i,j映射到grid上。。。
             int grid_r = 3*(i/3) + (j/3);
             int grid_c = (j%3) + (i%3)*3;
             if(board[grid_r][grid_c] != '.' && !grid.add(board[grid_r][grid_c])) return false;
           }
       }
        return true;
    }