/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.wits.snake.agent.ai;

import za.ac.wits.snake.agent.ai.algorithms.BreadthFirstSearch;
import za.ac.wits.snake.agent.ai.feed.AppleMunch;
import za.ac.wits.snake.agent.ai.feed.BreadthFirstSearchPredict;
import za.ac.wits.snake.agent.ai.feed.PredictApple;
import za.ac.wits.snake.agent.ai.collider.HeadCollision;
import za.ac.wits.snake.agent.ai.vision.LineOfSight;
import za.ac.wits.snake.agent.extra.AppleCoords;
import za.ac.wits.snake.agent.extra.Coords;
import za.ac.wits.snake.agent.player.SnakeBundle;
import za.ac.wits.snake.agent.player.SnakePlayer;

/**
 * FILE : AIHandler.java
 * @author ntsiki
 */
public class AIHandler {
    
    // SET : my snake number
    private final SnakePlayer mySnake;

    // SET : is my snake the nearest
    private double nearest;
    // SET : map
    private final int[][] myMap;
    
    // SET : line of sight
    private final LineOfSight line;
    
    // SET : apples
    private final AppleCoords myApples;
    
    // SET : snake bundle
    private final SnakeBundle snakeBundles;
    
    // SET : apple munch
    private final AppleMunch munch;
    

    public AIHandler(int mySnakeNum, AppleCoords appleCo, AppleMunch munch,
            SnakeBundle snakeBundle, int[][] playArea) {
        
        // SET : my snake
        this.mySnake = snakeBundle.findSnake(mySnakeNum);
        
        // SET : munch
        this.munch = munch;
        this.munch.check(mySnakeNum);
        
        // SET : map
        this.myMap = playArea;
        
        // SET : apples
        this.myApples = appleCo;
        
        // SET : snake bundles
        this.snakeBundles = snakeBundle;
        
        // SET : distance
        this.nearest = 2501;
        
        // SET : line of sight
        if (mySnake.getSnakeHead() != null) {
            line = new LineOfSight(mySnake.getSnakeHead(), mySnake.direction(), myMap);
        }
        else {
            line = null;
        }
        
        // SET : set snake distances
        for (int i = 0; i < snakeBundles.getNumSnakes(); i++) {
            SnakePlayer temp = snakeBundle.findSnake(i);
            temp.setTargetDistance(appleCo.getNormalApple(), temp.getSnakeHead());
            
            // SET : nearest snake
            if (temp.getDistance() < nearest) nearest = temp.getDistance();
        }
    }

    public int move() {
        
        if (mySnake != null) {
            // MOVE :
            int move;
        
            /**
            * GAME : 
            * if there's a snake longer than
            * mine eat otherwise kill the longest
            */
        
            if (snakeBundles.getLongest() * 2 > mySnake.getSnakeLength()
                    /*&& mySnake.getSnakeLength() != snakeBundles.getLongest()
                    || mySnake.getSnakeLength() == 5*/) {
                
                if (snakeBundles.isInvincible()) {
                    
                    // CHECK : if an invincible snake exists
                        
                    // avoid eating apple
                    Coords cP = PredictApple.prediction(myApples.getNormalApple(), myMap.length, myMap);
                    
                    move = BreadthFirstSearchPredict.move(mySnake.getSnakeHead(), cP, myMap);
                    return move;
                        
                }
                else {
                    // no invincible
                    int type = HeadCollision.collision(mySnake.getSnakeHead(),
                    mySnake.direction(), snakeBundles, myMap);
                
                    if (type == -1) {
                        if(line.leftClear()) return 4;
                        else return 6;
                    }
                    if (type >= 0) {
                        return type;
                    }
                
                    if (munch.getInvolved()) {
                        return munch.move();
                    }
                
                    if (nearest()) {
                    
                        move = BreadthFirstSearch.move(mySnake.getSnakeHead(), 
                            myApples.getNormalApple(), myMap);
                        return move;
                    }
                    else {
                        Coords cP = PredictApple.prediction(myApples.getNormalApple(), myMap.length, myMap);
                    
                        move = BreadthFirstSearchPredict.move(mySnake.getSnakeHead(), cP, myMap);
                        return move;
                    }
                    
                }
                
            }
        }
        
        return BreadthFirstSearch.move(mySnake.getSnakeHead(), myApples.getNormalApple(), myMap);
        
    }
    
    public boolean nearest() {
        return mySnake.getDistance() == nearest
                || mySnake.getDistance() < 20;
    }
    
}
