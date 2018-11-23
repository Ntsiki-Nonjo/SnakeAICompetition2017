/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.wits.snake.agent.ai.feed;

import za.ac.wits.snake.agent.ai.algorithms.*;
import java.util.LinkedList;
import java.util.Queue;
import za.ac.wits.snake.agent.ai.vision.LineOfSight;
import za.ac.wits.snake.agent.extra.Coords;
import za.ac.wits.snake.agent.extra.MatrixWork;
import za.ac.wits.snake.agent.extra.Vertex;

/**
 *
 * @author ntsiki
 */
public class BreadthFirstSearchPredict {
    
    // SET : targets apple head
    private final Vertex start, goal;
    
    // SET : surrounding coordinates
    private final int[] nRow = {-1, 0, 0, 1};
    private final int[] nCol = {0, -1, 1, 0};
    
    // SET : matrices
    private static int[][] distance;
    
    public BreadthFirstSearchPredict(Coords h, Coords a, int length) {
        
        distance = new int[length][length];
        
        if (h != null && a != null) {
            this.start = new Vertex(h.getxCo(), h.getyCo());
            this.goal = new Vertex(a.getxCo(), a.getyCo());
        }
        else {
            start = null;
            goal = null;
        }
    }
    
    private void calculate(int[][] playArea) {
        
        // SET : distance and parent
        
        // SET : distance and parent to -1
        MatrixWork.setTo(distance, -1);
        
        // INIT : parent and distance
        distance[start.x][start.y] = 0;
        
        // QUEUE : start vertex
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(new Vertex(start.x, start.y));
        
        while (!queue.isEmpty()) {
            
            Vertex tmp = queue.remove();
            
            if (tmp.x == goal.x && tmp.y == goal.y) {
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int row = tmp.x + nRow[i];
                int col = tmp.y + nCol[i];
                
                if (isValid(row, col, playArea) && distance[row][col] == -1) {
                    
                    // SET : distance array
                    distance[row][col] = 1 + distance[tmp.x][tmp.y];
                    
                    // QUEUE : add vertex
                    queue.add(new Vertex(row, col));
                }
            }
        }
    }
    
    public boolean isValid(int x, int y, int[][] playArea) {
        return x >= 0 && x < playArea.length &&
                y >= 0 && y < playArea.length &&
                (playArea[x][y] == 7 || playArea[x][y] == 0);
    }
    
    public boolean isValidProcess(int x, int y, int[][] playArea) {
        return x >= 0 && x < playArea.length &&
                y >= 0 && y < playArea.length;
    }
    
    public int process(int[][] playArea) {
        
        Vertex t = goal;
        
        int d = distance[goal.x][goal.y];
        
        if (d != -1) {
            
            while(d != 1) {
                for (int i = 0; i < 4; i++) {
                
                    // neighbouring coordinates
                    int row = t.x + nRow[i];
                    int col = t.y + nCol[i];
                    
                    if (isValidProcess(row, col, distance) 
                            && distance[row][col] == distance[t.x][t.y] - 1) {
                        
                        t.x = row;
                        t.y = col;
                        d = distance[row][col];
                        break;
                    }
                    
                }
                
            }
            
            return SimpleMove.move(start.x, start.y, t.x, t.y);
        }
        else {
            
            for (int i = 0; i < 4; i++) {
                
                int row = start.x + nRow[i];
                int col = start.y + nCol[i];
                
                if (isValidProcess(row, col, distance) && distance[row][col] == 1) {
                    
                    for (int j = 0; j < 4; j++) {
                        
                        int r = row + nRow[j];
                        int c = col + nCol[j];
                        
                        if (isValidProcess(r, c, distance) && distance[r][c] == 2) {
                            
                            t.x = row;
                            t.y = col;
                            break;
                            
                        }
                        
                    }
                    break;
                    
                }
                
            }
            
        }
        return SimpleMove.move(start.x, start.y, t.x, t.y);
    }
    
    public static int move(Coords snakeHead, Coords apple, int[][] playArea) {
        
        // SET : BFS variable
        BreadthFirstSearchPredict b = new BreadthFirstSearchPredict(snakeHead, apple, playArea.length);
        
        // DO : BFS Algorithm
        b.calculate(playArea);
        
        // PROCESS : path
        int move = b.process(playArea);
        
        return move;
    }
}
