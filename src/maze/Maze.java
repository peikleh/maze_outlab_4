/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maze;

import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Nevin
 */
public class Maze {
    private int startR;
    private int startC;
      char[][] maze;
       private int rows = 0;
        private int columns = 0;
        private int fillR = 0;
     public int FindStartR(){
         for (int j = 0; j < rows; j++) {
            for (int k = 0; k < columns; k++) {
                 if(maze[j][k]=='S'){
                      startR=j;
                   }
                } }  
               System.out.println(startR);
                     return startR;
         
     }
     public int FindStartC(){
         for (int j = 0; j < rows; j++) {
            for (int k = 0; k < columns; k++) {
                 if(maze[j][k]=='S'){
                      startC=k;
                   }
                } } 
         System.out.println(startC);
                     return startC;
         
     }
    public boolean SolveMaze(int x, int y){//this is a test of git
        System.out.println("poo");
        if(x<0||y<0||x>rows||y>=columns){
            System.out.println("1");
            return false;
        }else if(maze[x][y]=='*'||maze[x][y]=='.' ){
            System.out.println("2");
            return false;
        }else if(maze[x][y]=='F'){
            maze[x][y]='+';
            System.out.println("3");
            return true;
        }else{
            System.out.println("4rf");
            maze[x][y]='+';
            if(SolveMaze(x-1,y)||SolveMaze(x+1,y)||SolveMaze(x,y-1)||SolveMaze(x,y+1)){
                return true;
            }else{
                maze[x][y]='.';
                return false;
            }
        }
      
    }
    

    public char[][] ReadTextFile() {
        
        String fileName = "C:/Users/Nevin/Documents/testtextfile.txt";
        try {
            Scanner scanner = new Scanner(new FileReader(fileName));
            Scanner scan = new Scanner(new FileReader(fileName));

            while (scan.hasNextLine()) {
                String find = scan.nextLine();
                columns = find.length();
                rows++;
            }
             maze = new char[rows][columns];

            System.out.println(rows + " " + columns);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (int i = 0; i < columns; i++) {
                    maze[fillR][i] = line.charAt(i);
                }
                fillR++;
            }
            for (int j = 0; j < rows; j++) {
                System.out.println();
                for (int k = 0; k < columns; k++) {
                    System.out.print(maze[j][k]);
                } }
            return maze;
            
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
    }
    public void print(){
        for (int j = 0; j < rows; j++) {
                System.out.println();
                for (int k = 0; k < columns; k++) {
                    System.out.print(maze[j][k]);
                } }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.ReadTextFile();
       System.out.println( maze.SolveMaze(maze.FindStartR(), maze.FindStartC()));
        maze.print();
        // TODO code application logic here
       
        // System.out.println(board[0][1]);
    }

}

