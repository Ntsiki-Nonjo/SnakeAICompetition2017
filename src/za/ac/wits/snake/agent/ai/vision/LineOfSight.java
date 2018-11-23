/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.wits.snake.agent.ai.vision;

import za.ac.wits.snake.agent.extra.Coords;

/**
 *
 * @author ntsiki
 */
public class LineOfSight {
    
    /**
     * SNAKE : clear array
     * 0    straight    clear ?
     * 1    left        clear ?
     * 2    right       clear ?
     */
    private boolean[] clear = new boolean[3];
    
    public LineOfSight(Coords h, int direction, int[][] playArea) {
        
        /**
         * SNAKE :
         * take in head and check
         * 
         * there are four ways a snake could be facing
         */
        
        int xhead = h.getxCo();
        int yhead = h.getyCo();
        
        switch (direction) {
            case 1:
                
                /**
                 * DIRECTION : SOUTH
                 */
                
                if (yhead != playArea.length - 1) {
                    
                    // HEAD : not on the boundary
                    if (xhead == 0) {
                        
                        // on the left boundary
                        if (playArea[xhead][yhead + 1] == 0
                                || playArea[xhead][yhead + 1] == 8
                                || playArea[xhead][yhead + 1] == 9
                                || playArea[xhead][yhead + 1] == 7) clear[0] = true;
                        if (playArea[xhead + 1][yhead] == 0
                                || playArea[xhead + 1][yhead] == 8
                                || playArea[xhead + 1][yhead] == 9
                                || playArea[xhead + 1][yhead] == 7) clear[1] = true;
                        
                    }
                    else if (xhead == playArea.length - 1) {
                        
                        // on the right boundary
                        if (playArea[xhead][yhead + 1] == 0
                                || playArea[xhead][yhead + 1] == 8
                                || playArea[xhead][yhead + 1] == 9
                                || playArea[xhead][yhead + 1] == 7) clear[0] = true;
                        if (playArea[xhead - 1][yhead] == 0
                                || playArea[xhead - 1][yhead] == 8
                                || playArea[xhead - 1][yhead] == 9
                                || playArea[xhead - 1][yhead] == 7) clear[2] = true;
                        
                    }
                    else {
                        
                        // in the middle
                        if (playArea[xhead][yhead + 1] == 0
                                || playArea[xhead][yhead + 1] == 8
                                || playArea[xhead][yhead + 1] == 9
                                || playArea[xhead][yhead + 1] == 7) clear[0] = true;
                        if (playArea[xhead + 1][yhead] == 0
                                || playArea[xhead + 1][yhead] == 8
                                || playArea[xhead + 1][yhead] == 9
                                || playArea[xhead + 1][yhead] == 7) clear[1] = true;
                        if (playArea[xhead - 1][yhead] == 0
                                || playArea[xhead - 1][yhead] == 8
                                || playArea[xhead - 1][yhead] == 9
                                || playArea[xhead - 1][yhead] == 7) clear[2] = true;
                        
                    }
                    
                }
                else {
                    
                    // HEAD : is on the boundary
                    if (xhead == 0) {
                        
                        // left boundary
                        if (playArea[xhead + 1][yhead] == 0
                                || playArea[xhead + 1][yhead] == 8
                                || playArea[xhead + 1][yhead] == 9
                                || playArea[xhead + 1][yhead] == 7) clear[1] = true;
                        
                    }
                    else if (xhead == playArea.length - 1) {
                        
                        // right boundary
                        if (playArea[xhead - 1][yhead] == 0
                                || playArea[xhead - 1][yhead] == 8
                                || playArea[xhead - 1][yhead] == 9
                                || playArea[xhead - 1][yhead] == 7) clear[2] = true;
                        
                    }
                    else {
                        
                        // in the middle
                        if (playArea[xhead + 1][yhead] == 0
                                || playArea[xhead + 1][yhead] == 8
                                || playArea[xhead + 1][yhead] == 9
                                || playArea[xhead + 1][yhead] == 7) clear[1] = true;
                        if (playArea[xhead - 1][yhead] == 0
                                || playArea[xhead - 1][yhead] == 8
                                || playArea[xhead - 1][yhead] == 9
                                || playArea[xhead - 1][yhead] == 7) clear[2] = true;
                    }
                    
                }
                break;
                
            case 2:
                
                /**
                 * DIRECTION : WEST
                 */
                
                if (xhead != 0) {
                    
                    // HEAD : not on the boundary
                    if (yhead == 0) {
                        
                        // on the top boundary
                        if (playArea[xhead - 1][yhead] == 0
                                || playArea[xhead - 1][yhead] == 8
                                || playArea[xhead - 1][yhead] == 9
                                || playArea[xhead - 1][yhead] == 7) clear[0] = true;
                        if (playArea[xhead][yhead + 1] == 0
                                || playArea[xhead][yhead + 1] == 8
                                || playArea[xhead][yhead + 1] == 9
                                || playArea[xhead][yhead + 1] == 7) clear[1] = true;
                        
                    }
                    else if (yhead == playArea.length - 1) {
                        
                        // on the bottom boundary
                        if (playArea[xhead - 1][yhead] == 0
                                || playArea[xhead - 1][yhead] == 8
                                || playArea[xhead - 1][yhead] == 9
                                || playArea[xhead - 1][yhead] == 7) clear[0] = true;
                        if (playArea[xhead][yhead - 1] == 0
                                || playArea[xhead][yhead - 1] == 8
                                || playArea[xhead][yhead - 1] == 9
                                || playArea[xhead][yhead - 1] == 7) clear[2] = true;
                        
                    }
                    else {
                        
                        // in the middle
                        if (playArea[xhead - 1][yhead] == 0
                                || playArea[xhead - 1][yhead] == 8
                                || playArea[xhead - 1][yhead] == 9
                                || playArea[xhead - 1][yhead] == 7) clear[0] = true;
                        if (playArea[xhead][yhead + 1] == 0
                                || playArea[xhead][yhead + 1] == 8
                                || playArea[xhead][yhead + 1] == 9
                                || playArea[xhead][yhead + 1] == 7) clear[1] = true;
                        if (playArea[xhead][yhead - 1] == 0
                                || playArea[xhead][yhead - 1] == 8
                                || playArea[xhead][yhead - 1] == 9
                                || playArea[xhead][yhead - 1] == 7) clear[2] = true;
                        
                    }
                    
                }
                else {
                    
                    // HEAD : is on the boundary
                    if (yhead == 0) {
                        
                        // top boundary
                        if (playArea[xhead][yhead + 1] == 0
                                || playArea[xhead][yhead + 1] == 8
                                || playArea[xhead][yhead + 1] == 9
                                || playArea[xhead][yhead + 1] == 7) {
                            clear[1] = true;
                        }
                        
                    }
                    else if (yhead == playArea.length - 1) {
                        
                        // bottom boundary
                        if (playArea[xhead][yhead - 1] == 0
                                || playArea[xhead][yhead - 1] == 8
                                || playArea[xhead][yhead - 1] == 9
                                || playArea[xhead][yhead - 1] == 7) clear[2] = true;
                        
                    }
                    else {
                        
                        // in the middle
                        if (playArea[xhead][yhead + 1] == 0
                                || playArea[xhead][yhead + 1] == 8
                                || playArea[xhead][yhead + 1] == 9
                                || playArea[xhead][yhead + 1] == 7) clear[1] = true;
                        if (playArea[xhead][yhead - 1] == 0
                                || playArea[xhead][yhead - 1] == 8
                                || playArea[xhead][yhead - 1] == 9
                                || playArea[xhead][yhead - 1] == 7) clear[2] = true;
                    }
                    
                }
                break;
                
            case 3:
                
                /**
                 * DIRECTION : EAST
                 */
                
                if (xhead != playArea.length - 1) {
                    
                    // HEAD : not on the boundary
                    if (yhead == 0) {
                        
                        // on the top boundary
                        if (playArea[xhead + 1][yhead] == 0
                                || playArea[xhead + 1][yhead] == 8
                                || playArea[xhead + 1][yhead] == 9
                                || playArea[xhead + 1][yhead] == 7) clear[0] = true;
                        if (playArea[xhead][yhead + 1] == 0
                                || playArea[xhead][yhead + 1] == 8
                                || playArea[xhead][yhead + 1] == 9
                                || playArea[xhead][yhead + 1] == 7) clear[2] = true;
                        
                    }
                    else if (yhead == playArea.length - 1) {
                        
                        // on the bottom boundary
                        if (playArea[xhead + 1][yhead] == 0
                                || playArea[xhead + 1][yhead] == 8
                                || playArea[xhead + 1][yhead] == 9
                                || playArea[xhead + 1][yhead] == 7) clear[0] = true;
                        if (playArea[xhead][yhead - 1] == 0
                                || playArea[xhead][yhead - 1] == 8
                                || playArea[xhead][yhead - 1] == 9
                                || playArea[xhead][yhead - 1] == 7) clear[1] = true;
                        
                    }
                    else {
                        
                        // in the middle
                        if (playArea[xhead + 1][yhead] == 0
                                || playArea[xhead + 1][yhead] == 8
                                || playArea[xhead + 1][yhead] == 9
                                || playArea[xhead + 1][yhead] == 7) clear[0] = true;
                        if (playArea[xhead][yhead - 1] == 0
                                || playArea[xhead][yhead - 1] == 8
                                || playArea[xhead][yhead - 1] == 9
                                || playArea[xhead][yhead - 1] == 7) clear[1] = true;
                        if (playArea[xhead][yhead + 1] == 0
                                || playArea[xhead][yhead + 1] == 8
                                || playArea[xhead][yhead + 1] == 9
                                || playArea[xhead][yhead + 1] == 7) clear[2] = true;
                        
                    }
                    
                }
                else {
                    
                    // HEAD : is on the boundary
                    if (yhead == 0) {
                        
                        // top boundary
                        if (playArea[xhead][yhead + 1] == 0
                                || playArea[xhead][yhead + 1] == 8
                                || playArea[xhead][yhead + 1] == 9
                                || playArea[xhead][yhead + 1] == 7) clear[2] = true;
                        
                    }
                    else if (yhead == playArea.length - 1) {
                        
                        // bottom boundary
                        if (playArea[xhead][yhead - 1] == 0
                                || playArea[xhead][yhead - 1] == 8
                                || playArea[xhead][yhead - 1] == 9
                                || playArea[xhead][yhead - 1] == 7) clear[1] = true;
                        
                    }
                    else {
                        
                        // in the middle
                        if (playArea[xhead][yhead - 1] == 0
                                || playArea[xhead][yhead - 1] == 8
                                || playArea[xhead][yhead - 1] == 9
                                || playArea[xhead][yhead - 1] == 7) clear[1] = true;
                        if (playArea[xhead][yhead + 1] == 0
                                || playArea[xhead][yhead + 1] == 8
                                || playArea[xhead][yhead + 1] == 9
                                || playArea[xhead][yhead + 1] == 7) clear[2] = true;
                    }
                    
                }
                break;
                
            default:
                
                /**
                 * DIRECTION : NORTH
                 */
                
                if (yhead != 0) {
                    
                    // HEAD : not on the boundary
                    if (xhead == 0) {
                        
                        // on the left boundary
                        if (playArea[xhead][yhead - 1] == 0
                                || playArea[xhead][yhead - 1] == 8
                                || playArea[xhead][yhead - 1] == 9
                                || playArea[xhead][yhead - 1] == 7) clear[0] = true;
                        if (playArea[xhead + 1][yhead] == 0
                                || playArea[xhead + 1][yhead] == 8
                                || playArea[xhead + 1][yhead] == 9
                                || playArea[xhead + 1][yhead] == 7) clear[2] = true;
                        
                    }
                    else if (xhead == playArea.length - 1) {
                        
                        // on the right boundary
                        if (playArea[xhead][yhead - 1] == 0
                                || playArea[xhead][yhead - 1] == 8
                                || playArea[xhead][yhead - 1] == 9
                                || playArea[xhead][yhead - 1] == 7) clear[0] = true;
                        if (playArea[xhead - 1][yhead] == 0
                                || playArea[xhead - 1][yhead] == 8
                                || playArea[xhead - 1][yhead] == 9
                                || playArea[xhead - 1][yhead] == 7) clear[1] = true;
                        
                    }
                    else {
                        
                        // in the middle
                        if (playArea[xhead][yhead - 1] == 0
                                || playArea[xhead][yhead - 1] == 8
                                || playArea[xhead][yhead - 1] == 9
                                || playArea[xhead][yhead - 1] == 7) clear[0] = true;
                        if (playArea[xhead - 1][yhead] == 0
                                || playArea[xhead - 1][yhead] == 8
                                || playArea[xhead - 1][yhead] == 9
                                || playArea[xhead - 1][yhead] == 7) clear[1] = true;
                        if (playArea[xhead + 1][yhead] == 0
                                || playArea[xhead + 1][yhead] == 8
                                || playArea[xhead + 1][yhead] == 9
                                || playArea[xhead + 1][yhead] == 7) clear[2] = true;
                        
                    }
                    
                }
                else {
                    
                    // HEAD : is on the boundary
                    if (xhead == 0) {
                        
                        // left boundary
                        if (playArea[xhead + 1][yhead] == 0
                                || playArea[xhead + 1][yhead] == 8
                                || playArea[xhead + 1][yhead] == 9
                                || playArea[xhead + 1][yhead] == 7) clear[2] = true;
                        
                    }
                    else if (xhead == playArea.length - 1) {
                        
                        // right boundary
                        if (playArea[xhead - 1][yhead] == 0
                                || playArea[xhead - 1][yhead] == 8
                                || playArea[xhead - 1][yhead] == 9
                                || playArea[xhead - 1][yhead] == 7) clear[1] = true;
                        
                    }
                    else {
                        
                        // in the middle
                        if (playArea[xhead - 1][yhead] == 0
                                || playArea[xhead - 1][yhead] == 8
                                || playArea[xhead - 1][yhead] == 9
                                || playArea[xhead - 1][yhead] == 7) clear[1] = true;
                        if (playArea[xhead + 1][yhead] == 0
                                || playArea[xhead + 1][yhead] == 8
                                || playArea[xhead + 1][yhead] == 9
                                || playArea[xhead + 1][yhead] == 7) clear[2] = true;
                    }
                    
                }
                break;
        }
        
    }
    
    public void printClarity() {
        
        System.out.println("log ");
        
        if (!clear[0]) System.out.println("log straight not clear");
        else System.out.println("log straight is clear");
        
        if (!clear[1]) System.out.println("log left not clear");
        else System.out.println("log left is clear");
        
        if (!clear[2]) System.out.println("log right not clear");
        else System.out.println("log right is clear");
        
    }
    
    public boolean straightClear() {
        return this.clear[0];
    }
    
    public boolean leftClear() {
        
        return this.clear[1];
    }
    
    public boolean rightClear() {
        return this.clear[2];
    }
    
    public boolean allClear() {
        return clear[0] && clear[1] && clear[2];
    }
    
    public boolean spaceClear() {
        return (clear[0] && clear[1]) || (clear[0] && clear[2]);
    }
    
    public int findClear() {
        
        /**
         * RELATIVE TO HEAD
         * 4    left
         * 5    straight
         * 6    right
         */
        
        if (clear[0]) return 5;
        else if(clear[1]) return 4;
        else return 6;
        
    }
    
    public boolean sideClear() {
        
        return clear[1] && clear[2];
        
    }
    
}
