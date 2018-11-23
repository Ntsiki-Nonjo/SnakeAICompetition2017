/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.wits.snake.agent;

import za.ac.wits.snake.agent.ai.AIHandler;
import za.ac.wits.snake.agent.extra.AppleCoords;
import za.ac.wits.snake.agent.player.SnakeBundle;
import za.ac.wits.snake.agent.player.SnakePlayer;
import za.ac.wits.snake.agent.ai.feed.AppleMunch;
import za.ac.wits.snake.agent.extra.Coords;

/**
 * FILE : GameHandler.java
 * @author ntsiki
 */
public class GameHandler {
    
    // GAME : map
    private final int[][] playArea;
    
    // GAME : my snake
    private static int mySnakeNum;
    
    // GAME : apple coordinates
    private AppleCoords appleCo;
    
    // GAME : apple munch
    private AppleMunch munch;
    
    // GAME : snake bundle
    private final SnakeBundle snakeBundle = new SnakeBundle();

    GameHandler(int mySnakeNum, int gameWidth, int gameHeight) {
        
        GameHandler.mySnakeNum = mySnakeNum;
        playArea = new int[gameWidth][gameHeight];
        
    }

    public void addApples(String apple1, String apple2) {
        
        // coordinate tokens of apples
        String[] temp1 = apple1.split(" ");
        String[] temp2 = apple2.split(" ");
        
        // coordinates of apples
        int invX = Integer.parseInt(temp1[0]);
        int invY = Integer.parseInt(temp1[1]);
        int norX = Integer.parseInt(temp2[0]);
        int norY = Integer.parseInt(temp2[1]);
        
        appleCo = new AppleCoords(invX, invY, norX, norY);
        
        // SET : apples in map
        if (invX != -1) {
            // invincible apple
            playArea[invX][invY] = 9;
        }
        // normal apple
        playArea[norX][norY] = 8;
        
        this.munch = new AppleMunch(appleCo);
    }

    public void addSnake(String snakeLine, int snakeNum) {
        
        SnakePlayer sp = new SnakePlayer(snakeLine, snakeNum, playArea);
        
        // COORDS : head
        Coords thead = sp.getSnakeHead();
        
        if (thead != null) {
            this.munch.set(thead, snakeNum, playArea);
        }
        
        snakeBundle.addSnakeBundle(sp);
        
    }
    
    public static int getMySnakeNumber() {
        return GameHandler.mySnakeNum;
    }

    public int move() {
        
        // GAME : get move
        AIHandler ai = new AIHandler(mySnakeNum, appleCo, munch, snakeBundle, playArea);
        
        // GAME : set move
        int move = ai.move();
        
        return move;
    }
    
}
