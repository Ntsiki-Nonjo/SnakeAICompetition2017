/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.wits.snake.agent.extra;

/**
 *
 * @author ntsiki
 */
public class AppleCoords {
    
    private final Coords inv, norm;

    public AppleCoords(int invX, int invY, int norX, int norY) {
        
        inv = new Coords(invX, invY);
        norm = new Coords(norX, norY);
        
    }
    
    public Coords getInvincibleApple() {
        
        return inv;
        
    }
    
    public Coords getNormalApple() {
        
        return norm;
        
    }
    
}
