import java.io.*;
import java.util.*;

class Solution {
    String[][] block;
    boolean[][] bomb;
    int bombCnt;
    public int solution(int m, int n, String[] board) {
        bombCnt = 0;

        block = new String[board.length][];
        for(int i=0; i<block.length; i++){
            block[i] = board[i].split("");
            // System.out.println(Arrays.toString(block[i]));
        }
        
        while(isBomb()) {
            moveDown();
        }
        
        return bombCnt;
    }
    
    // 지울 블럭 있는지 확인
    public boolean isBomb() {
        if(bombCnt == block.length * block[0].length) return false; 
        
        bomb = new boolean[block.length][block[0].length];
        boolean isTarget = false;
        
        for(int i=0; i+1<block.length; i++) {
            for(int j=0; j+1<block[i].length; j++) {
                String type = block[i][j];
                
                if(!type.equals("0") && type.equals(block[i][j+1]) && type.equals(block[i+1][j]) && type.equals(block[i+1][j+1])) {
                    if(!bomb[i][j]) {
                        bomb[i][j] = true;
                        bombCnt++;
                    }
                    if(!bomb[i][j+1]) {
                        bomb[i][j+1] = true;
                        bombCnt++;
                    }
                    if(!bomb[i+1][j]) {
                        bomb[i+1][j] = true;
                        bombCnt++;
                    }
                    if(!bomb[i+1][j+1]) {
                        bomb[i+1][j+1] = true;
                        bombCnt++;
                    }
                    isTarget = true;
                }
            }
        }
        return isTarget;
    }
    
    // 빈 공간 채우도록 이동시키기
    public void moveDown() {
        Stack<String> stack = new Stack<>();
        for(int c=0; c<block[0].length; c++) { 
            for(int r=0; r<block.length; r++) {
                if(!bomb[r][c]) stack.push(block[r][c]);
                block[r][c] = "0";
            }
            
            for(int r=block.length-1; r>=0; r--) {
                if(!stack.isEmpty()) block[r][c] = stack.pop();
                else break;
            }
        }
    }
}