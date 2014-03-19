

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

    public int FindStartR() {//Finds the starting row
        for (int j = 0; j < rows; j++) {
            for (int k = 0; k < columns; k++) {
                if (maze[j][k] == 'S') {
                    startR = j;
                }
            }
        }

        return startR;

    }

    public int FindStartC() {//Finds the Starting Column
        for (int j = 0; j < rows; j++) {
            for (int k = 0; k < columns; k++) {
                if (maze[j][k] == 'S') {
                    startC = k;
                }
            }
        }

        return startC;

    }

    public boolean SolveMaze(int x, int y) {//recursive method that solves the maze

        if (x < 0 || y < 0 || x >= rows || y >= columns) {

            return false;
        } else if (maze[x][y] == '*' || maze[x][y] == '.' || maze[x][y] == '+') {

            return false;
        } else if (maze[x][y] == 'F') {

            return true;
        } else {

            maze[x][y] = '+';
            if (SolveMaze(x, y - 1) == true || SolveMaze(x, y + 1) == true || SolveMaze(x - 1, y) == true || SolveMaze(x + 1, y) == true) {
                return true;
            } else {
                maze[x][y] = '.';
                return false;
            }
        }

    }

    public char[][] ReadTextFile(String file) {//reads text file and mades it a 2d array

        String fileName = file;
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
                }
            }
            return maze;

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
    }

    public boolean checkPos() {//checks if the maze is possible
        for (int j = 0; j < rows; j++) {
            for (int k = 0; k < columns; k++) {
                if (maze[j][k] == '+') {
                    return true;
                }
            }
        }
        System.out.println("This maze is impossible");
        return false;
    }

    public void print() {//gets rid of breadcrumbs and prints completed maze
        maze[startR][startC] = 'S';
        for (int l = 0; l < rows; l++) {

            for (int m = 0; m < columns; m++) {
                if (maze[l][m] == '.') {
                    maze[l][m] = ' ';

                }
            }
        }

        for (int j = 0; j < rows; j++) {
            System.out.println();
            for (int k = 0; k < columns; k++) {
                System.out.print(maze[j][k]);
            }
        }

    }

    
    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.ReadTextFile("C:/Users/Nevin/Documents/testtextfile.txt");
        maze.SolveMaze(maze.FindStartR(), maze.FindStartC());
        System.out.println();
        System.out.println();
        System.out.println();
        if (maze.checkPos()) {
            maze.print();
        }
        

       
    }

}
 

