/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.wits.snake.agent.player;

import java.util.HashSet;
import java.util.Set;
import za.ac.wits.snake.agent.GameHandler;
import za.ac.wits.snake.agent.extra.Coords;

/**
 * FILE : SnakePlayer.java
 * @author ntsiki
 */
public final class SnakePlayer {
    
    /**
     * GAME : snake description
     */
    private double distance, idistance;
    private final int snakeState, snakeNum, numCoords, length, kills, direction;
    
    /**
     * GAME : snake head and tail
     */
    Coords head, mid, tail;
    
    public SnakePlayer(String snakeLine, int snakeNum, int[][] playArea) {
        
        // get snake line tokens
        String[] temp = snakeLine.split(" ");
        
        // SET : snake state
        if (temp[0].contains("alive")) snakeState = 1;
        else if (temp[0].contains("invincible")) snakeState = 2;
        else snakeState = 3; // dead
        
        // SET: snake number
        this.snakeNum = snakeNum;
        
        // SET : longest
        length = Integer.parseInt(temp[1]);
        
        // SET : kills
        kills = Integer.parseInt(temp[2]);
        
        // SET : body
        int n;
        switch (snakeState) {
            case 1:
                /**
                 * SNAKE : is alive
                 */
                n = 3;
                numCoords = temp.length - n;
                head = new Coords(temp[n]);
                mid = new Coords(temp[n + 1]);
                tail = new Coords(temp[temp.length - 1]);
                direction = getDirection();
                
                for (int i = n; i < temp.length - 1; i++) {
                    
                    Coords a = new Coords(temp[i]);
                    Coords b = new Coords(temp[i + 1]);
                    
                    drawLine(a, b, snakeNum, playArea);
                    
                }   break;
            case 2:
                /**
                 * SNAKE : is invincible
                 *  snakeLine has extra token
                 */
                n = 4;
                numCoords = temp.length - n;
                head = new Coords(temp[n]);
                mid = new Coords(temp[n + 1]);
                tail = new Coords(temp[temp.length - 1]);
                direction = getDirection();
                
                for (int i = n; i < temp.length - 1; i++) {
                    
                    Coords a = new Coords(temp[i]);
                    Coords b = new Coords(temp[i + 1]);
                    
                    drawLine(a, b, snakeNum, playArea);
                    
                }   break;
            default:
                // snake is dead
                numCoords = 0;
                direction = -1;
                break;
        }
        
    }
    
    private void drawLine(Coords a, Coords b, int snakeNum, int[][] playArea) {
        
        // coords a
        int ax = a.getxCo();
        int ay = a.getyCo();
        
        // coords b
        int bx = b.getxCo();
        int by = b.getyCo();
        
        // min and max for loop
        int xmin = Math.min(ax, bx);
        int xmax = Math.max(ax, bx);
        int ymin = Math.min(ay, by);
        int ymax = Math.max(ay, by);
        
        // xlength ylength
        int xlength = xmax - xmin;
        int ylength = ymax - ymin;
        
        for (int i = xmin; i <= xmax; i++) {
            
            for (int j = ymin; j <= ymax; j++) {
                
                if (GameHandler.getMySnakeNumber() == snakeNum) {
                    playArea[i][j] = 5;
                }
                else {
                    playArea[i][j] = snakeNum;
                }
            }
        }
        
    }
    
    public int getDirection() {
        
        /**
         * GAME : directions
         * 
         * RELATIVE TO PLAY AREA
         * 0    north
         * 1    south
         * 2    west
         * 3    east
         */
        
        if (head != null && mid != null) {
            if (Coords.leftOf(head, mid))
                return 2;   // System.out.println("log west " + snakeNum);
            else if (Coords.rightOf(head, mid))
                return 3;   // System.out.println("log east " + snakeNum);
            else if (Coords.aboveOf(head, mid))
                return 0;   // System.out.println("log north " + snakeNum);
            else return 1;  // System.out.println("log south " + snakeNum);
        }
        
        return -1;
    }
    
    public int getSnakeNumber() {
        return this.snakeNum;
    }
    
    public Coords getSnakeHead() {
        return this.head;
    }
    
    public int getSnakeKills() {
        return this.kills;
    }
    
    public int getSnakeLength() {
        return this.length;
    }
    
    public int direction() {
        return this.direction;
    }
    
    public boolean alive() {
        return snakeState == 1 || snakeState == 2;
    }
    
    public boolean invincible() {
        return snakeState == 2;
    }

    public void setTargetDistance(Coords apple, Coords snakeHead) {
        
        if (apple != null && snakeHead != null) {
            // SET : apple coordinates
        double ax = (double) apple.getxCo();
        double ay = (double) apple.getyCo();
        
        // SET : snake head coordinates
        double sx = (double) snakeHead.getxCo();
        double sy = (double) snakeHead.getyCo();
        
        // SET : difference x and y
        double dx = Math.abs(ax - sx);
        double dy = Math.abs(ay - sy);
        
        // SET : set square of difference
        double dx2 = Math.pow(dx, 2);
        double dy2 = Math.pow(dy, 2);
        
        // SET : distance squared
        double dist = dx2 + dy2;
        
        // SET : distance
        this.distance = Math.sqrt(dist);
        }
        
    }
    
    public void setTargetDistanceInvincible(Coords apple, Coords snakeHead) {
        
        if (apple != null && snakeHead != null) {
            // SET : apple coordinates
        double ax = (double) apple.getxCo();
        double ay = (double) apple.getyCo();
        
        // SET : snake head coordinates
        double sx = (double) snakeHead.getxCo();
        double sy = (double) snakeHead.getyCo();
        
        // SET : difference x and y
        double dx = Math.abs(ax - sx);
        double dy = Math.abs(ay - sy);
        
        // SET : set square of difference
        double dx2 = Math.pow(dx, 2);
        double dy2 = Math.pow(dy, 2);
        
        // SET : distance squared
        double dist = dx2 + dy2;
        
        // SET : distance
        this.idistance = Math.sqrt(dist);
        }
        
    }
    
    public double getDistance() {
        return this.distance;
    }
    
    public double getDistanceInvinvible() {
        return this.idistance;
    }
    
}
