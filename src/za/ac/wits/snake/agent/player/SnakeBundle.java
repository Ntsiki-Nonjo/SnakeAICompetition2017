/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.wits.snake.agent.player;

import java.util.HashSet;
import java.util.Set;
import za.ac.wits.snake.agent.extra.Coords;

/**
 * FILE : 
 * @author ntsiki
 */
public class SnakeBundle {
    
    // INIT : immediate access of snakes
    Set<SnakePlayer> sb = new HashSet<>();
    
    // SET : longest snake
    private int longestSnakeNum, longest = 0;
    
    // SET : snake most kills
    private int highestKiller, mostKills = 0;
    
    // SET : is a snake invincible
    private boolean invincible;
    
    public SnakePlayer findSnake(int i) {
        
        // SEARCH : for a snake
        for (SnakePlayer temp : sb) {
            
            if (temp.getSnakeNumber() == i) return temp;
            
        }
        // RET : no snake found
        return null;
    }
    
    public Coords findSnakeHead(int i) {
        
        // SEARCH : for a snake
        for (SnakePlayer temp : sb) {
            
            if (temp.getSnakeNumber() == i) return temp.getSnakeHead();
            
        }
        // RET : no snake found
        return null;
    }
    
    public int getNumSnakes() {
        return this.sb.size();
    }
    
    public void addSnakeBundle(SnakePlayer sp) {
        
        // ADD : add a snake
        sb.add(sp);
        
        // SET : longest snake
        if (longest < sp.getSnakeLength()) {
            longest = sp.getSnakeLength();
            longestSnakeNum = sp.getSnakeNumber();
        }
        
        // SET : most kills
        if (mostKills < sp.getSnakeKills()) {
            mostKills = sp.getSnakeKills();
            highestKiller = sp.getSnakeNumber();
        }
        
        if (sp.invincible()) invincible = true;
        
    }
    
    public int getLongest() {
        return this.longest;
    }
    
    public int getLongestNum() {
        return this.longestSnakeNum;
    }
    
    public boolean isInvincible(){
        return this.invincible;
    }
}
