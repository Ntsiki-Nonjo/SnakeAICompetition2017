/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.wits.snake.agent.ai.feed;

import java.util.Random;
import za.ac.wits.snake.agent.extra.Coords;

/**
 * FILE : PredictApple.java
 * @author ntsiki
 */
public class PredictApple {
    
    //
    
    public static Coords prediction(Coords c, int n, int[][] map) {
        
        // SET : apple coordinates
        int x = c.getxCo();
        int y = c.getyCo();
        
        if (x >= 0 && x < n/2
                && y >= 0 && y < n/2) {
            
            // 1ST QUAD
            int rX = getRandomInt(n, true);
            int rY = getRandomInt(n, true);
            
            if (map[rX][rY] == 0) {
                map[rX][rY] = 7;
                return new Coords(rX, rY);
            }
            else {
                return prediction(c, n, map);
            }
        }
        else if (x >= n/2 && x < n 
                && y >= 0 && y < n/2) {
            
            // 0TH QUAD
            int rX = getRandomInt(n, false);
            int rY = getRandomInt(n, true);
            
            if (map[rX][rY] == 0) {
                map[rX][rY] = 7;
                return new Coords(rX, rY);
            }
            else {
                return prediction(c, n, map);
            }
        }
        else if (x >= 0 && x < n/2
                && y >= n/2 && y < n) {
            
            // 2ND QUAD
            int rX = getRandomInt(n, true);
            int rY = getRandomInt(n, false);
            
            if (map[rX][rY] == 0) {
                map[rX][rY] = 7;
                return new Coords(rX, rY);
            }
            else {
                return prediction(c, n, map);
            }
        }
        else {
            
            // 3RD QUAD
            int rX = getRandomInt(n, false);
            int rY = getRandomInt(n, false);
            
            if (map[rX][rY] == 0) {
                map[rX][rY] = 7;
                return new Coords(rX, rY);
            }
            else {
                return prediction(c, n, map);
            }
        }
        
    }
    
    private static int getRandomInt(int x, boolean add) {
        
        int n = new Random().nextInt(x/2);
        
        if (add) {
            return n + x/2;
        }
        else {
            return n;
        }
    }
    
}