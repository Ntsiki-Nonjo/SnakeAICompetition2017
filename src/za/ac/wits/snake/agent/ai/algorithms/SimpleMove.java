/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.wits.snake.agent.ai.algorithms;

import za.ac.wits.snake.agent.extra.AppleCoords;
import za.ac.wits.snake.agent.extra.Coords;
import za.ac.wits.snake.agent.player.SnakePlayer;

/**
 * FILE : SimpleMove.java
 * @author ntsiki
 */
public class SimpleMove {

    public static int move(SnakePlayer mySnake, AppleCoords myApples) {
        
        /**
         * AI :
         * check which distance is longer
         * and move towards it
         * 
         * No collision detection
         * just for tests
         */
        
        // SET : snake head
        Coords snakeHead = mySnake.getSnakeHead();
        
        // SET : normal apple
        Coords normalApple = myApples.getNormalApple();
        
        // SET : distance
        int xdist = Math.abs(snakeHead.getxCo() - normalApple.getxCo());
        int ydist = Math.abs(snakeHead.getyCo() - normalApple.getyCo());
        
        
        if (xdist > ydist) {
            
            // MOVE : either left or right
            if (Coords.leftOf(normalApple, snakeHead)) return 2;
            else return 3;
            
        }
        else {
            
            // MOVE : either up or down
            if (Coords.aboveOf(normalApple, snakeHead)) return 0;
            else return 1;
            
        }
        
    }
    
    public static int move(int sx, int sy, int ax, int ay) {
        
        /**
         * AI :
         * check which distance is longer
         * and move towards it
         * 
         * No collision detection
         * just for tests
         */
        
        // SET : snake head
        Coords snakeHead = new Coords(sx, sy);
        
        // SET : normal apple
        Coords normalApple = new Coords(ax, ay);
        
        // SET : distance
        int xdist = Math.abs(snakeHead.getxCo() - normalApple.getxCo());
        int ydist = Math.abs(snakeHead.getyCo() - normalApple.getyCo());
        
        
        if (xdist > ydist) {
            
            // MOVE : either left or right
            if (Coords.leftOf(normalApple, snakeHead)) return 2;
            else return 3;
            
        }
        else {
            
            // MOVE : either up or down
            if (Coords.aboveOf(normalApple, snakeHead)) return 0;
            else return 1;
            
        }
        
    }
    
}
