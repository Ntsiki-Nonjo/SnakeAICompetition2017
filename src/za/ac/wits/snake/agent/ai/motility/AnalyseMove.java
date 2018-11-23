/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.wits.snake.agent.ai.motility;

import za.ac.wits.snake.agent.ai.collider.HeadCollision;
import za.ac.wits.snake.agent.ai.vision.LineOfSight;
import za.ac.wits.snake.agent.extra.Coords;
import za.ac.wits.snake.agent.player.SnakeBundle;

/**
 * FILE : AnalyseMove.java
 * @author ntsiki
 */
public class AnalyseMove {
    
    // SET : set direction
    private int dir;
    
    // SET : move
    private int move;
    
    // SET : tyoe of collision
    private static int type;
    
    // SET : snake head
    private Coords snakeHead;
    
    // SET : line of sight
    private LineOfSight line;
    
    // SET : snake bundle
    private SnakeBundle bundle;
    
    // SET : set map
    private final int[][] map;
    
    public AnalyseMove(Coords snakeHead, int move, int dir, 
            int[][] map, LineOfSight line, SnakeBundle sb) {
        
        // SET : direction
        this.dir = dir;
        
        // SET : map
        this.map = map;
        
        // SET : move
        this.move = move;
        
        // SET : snake head
        this.snakeHead = snakeHead;
        
        // SET : type
        this.type = 0;
        
    }
    
    private void typeHeadCollision() {
        
        // SET : type of collision
        if (HeadCollision.headOn(snakeHead, bundle, dir, map)) this.type = 1;
        
    }
    
    public static boolean collision() {
        
        return true;
        
    }
    
    public static int move(String algorithm) {
        return 1;
    }
    
}
