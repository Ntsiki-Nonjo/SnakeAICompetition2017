/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.wits.snake.agent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import za.ac.wits.snake.DevelopmentAgent;

/**
 * FILE : MyAgent.java
 */
public class MyAgent extends DevelopmentAgent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MyAgent agent = new MyAgent();
        MyAgent.start(agent, args);
        
    }

    @Override
    public void run() {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            
            /**
             * GAME : initialization
             */
            String initString = br.readLine();
            String[] temp = initString.split(" ");
            
            // GAME : number of snakes
            int nSnakes = Integer.parseInt(temp[0]);
            
            // GAME : width x height
            int gameWidth = Integer.parseInt(temp[1]);
            int gameHeight = Integer.parseInt(temp[2]);
            
            while(true) {
                
                // GAME : apple1 or game over
                String line = br.readLine();
                
                // GAME : end game
                if (line.contains("Game Over")) {
                    break;
                }
                
                // GAME : set all map variables
                
                
                // GAME : apples
                String apple1 = line;
                String apple2 = br.readLine();
                
                // GAME : sets my snake number
                int mySnakeNum = Integer.parseInt(br.readLine());
                
                GameHandler g = new GameHandler(mySnakeNum, gameWidth, gameHeight);
                g.addApples(apple1, apple2);
                
                
                for (int i = 0; i < nSnakes; i++) {
                    
                    String snakeLine = br.readLine();
                    
                    g.addSnake(snakeLine, i);
                    
                    if (i == mySnakeNum) {
                        // hey! That's me :)
                    }
                    else {
                        // other snakes
                    }
                    // do stuff with snakes
                }
                
                // finished reading, calculate move
                int move = g.move();
                
                //System.out.println("log calculation...");
                int mover = new Random().nextInt(4);
                
                /**
                 * GAME : directions
                 * 
                 * RELATIVE TO PLAY AREA
                 * 0    north
                 * 1    south
                 * 2    west
                 * 3    east
                 * 
                 * RELATIVE TO HEAD
                 * 4    left
                 * 5    straight
                 * 6    right
                 */
                
                // GAME : make move
                //System.out.println(mover); (random agent)
                System.out.println(move);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
