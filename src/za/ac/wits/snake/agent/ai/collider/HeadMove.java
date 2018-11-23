/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.wits.snake.agent.ai.collider;

import za.ac.wits.snake.agent.extra.Coords;

/**
 *
 * @author ntsiki
 */
public class HeadMove {
    
    public static Coords get(Coords head, int move, int dir) {
        
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
        if (dir == 1) {
            
            // DIRECTION : South
            
            if (move == 1) {
                
            }
            else if (move == 2) {
                
            }
            else if (move == 3) {
                
            }
            else if (move == 4) {
                
            }
            else if (move == 5) {
                
            }
            else if (move == 6) {
                
            }
            else {
                
            }
            
        }
        else if (dir == 2) {
            
            // DIRECTION : West
            
        }
        else if (dir == 3) {
            
            // DIRECTION : East
            
        }
        else {
            
            // DIRECTION : North
            
        }
        
        return head;
    }
    
}
