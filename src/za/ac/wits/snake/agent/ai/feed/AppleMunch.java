/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.wits.snake.agent.ai.feed;

import za.ac.wits.snake.agent.extra.AppleCoords;
import za.ac.wits.snake.agent.extra.Coords;

/**
 *
 * @author ntsiki
 */
public class AppleMunch {
    
    // SET : invincible apple
    private Coords invincible;
    
    // SET : normal apple
    private final Coords normal;
    
    // SET : collision normal array
    private final boolean[] cnormal;
    
    // SET : collision invincible array
    private boolean[] cinvincible;
    
    // SET : normal apple neighbour
    private final int[] nneightbour = {-1,-1,-1,-1};
    
    // SET : normal apple neighbour
    private final int[] ineightbour = {-1,-1,-1,-1};
    
    // SET : is my snake involved
    private boolean involved;
    
    public AppleMunch(AppleCoords myApples) {
        
        // SET : normal apple
        this.normal = myApples.getNormalApple();
        this.cnormal = new boolean[4];
        
        // SET : invincible apple
        if (myApples.getInvincibleApple().getxCo() != -1) {
            this.invincible = myApples.getInvincibleApple();
            this.cinvincible = new boolean[4];
        }
        
    }
    
    public void set(Coords head, int num, int[][] map) {
        
        // SET : head coordinates
        int xH = head.getxCo();
        int yH = head.getyCo();
        
        // SET : temporary normal
        int xN = normal.getxCo();
        int yN = normal.getyCo();
        
        if (xN >= 1 && xN < map.length - 1
                && yN >= 1 && yN < map.length - 1) {
            
            if (xN == xH && yN - 1 == yH) {
                
                // NORTH TOUCHED
                this.cnormal[0] = true;
                this.nneightbour[0] = num;
                
            }
            else if (xN == xH && yN + 1 == yH) {
                
                // SOUTH TOUCHED
                this.cnormal[1] = true;
                this.nneightbour[1] = num;
                
            }
            else if (xN - 1 == xH && yN == yH) {
                
                // WEST TOUCHED
                this.cnormal[2] = true;
                this.nneightbour[2] = num;
                
            }
            else if (xN + 1 == xH && yN == yH) {
                
                // EAST TOUCHED
                this.cnormal[3] = true;
                this.nneightbour[3] = num;
                
            }
            
        }
        
    }
    
    public void check(int num) {
        
        // SET : if more than two snakes then involved
        int s = 0;
        
        for (int i = 0; i < 4; i++) {
            
            if (cnormal[i]) s++;
            
        }
        
        if (s >= 2) {
            
            for (int i = 0; i < 4; i++) {
            
                if (nneightbour[i] == num) involved = true;
            
            }
        }
        
    }
    
    public boolean getInvolved() {
        return this.involved;
    }
    
    public int move() {
        
        int move = 0;
        
        for (int i = 0; i < 4; i++) {
            if (!cnormal[i]) {
                move = i;
                break;
            }
        }
        return move;
    }
    
}
