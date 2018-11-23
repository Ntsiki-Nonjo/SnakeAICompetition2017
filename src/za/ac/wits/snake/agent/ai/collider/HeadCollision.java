/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.wits.snake.agent.ai.collider;

import za.ac.wits.snake.agent.extra.Coords;
import za.ac.wits.snake.agent.player.SnakeBundle;

/**
 * FILE : HeadCollision.java
 * @author ntsiki
 */
public class HeadCollision {
    
    /**
     * SNAKE : intercept array
     * 0    diagonal left       clear ?
     * 1    diagonal right      clear ?
     * 
     * SNAKE : straight boolean
     * @param head
     * @param dir
     * @param bun
     * @param map
     * @return 
     */
    public static int collision(Coords head, int dir, SnakeBundle bun, int[][] map) {
        
        /**
         * CHECK : two types of collisions
         * interception and head on
         * 
         * 0    no collision
         * 1    head on
         * 2    diagonal
         */
        int type;
        
        if (headOn(head, bun, dir, map)) type = -1;
        else type = diagonalOn(head, bun, dir, map);
        
        return type;
        
    }
    
    public static boolean headOn(Coords head, SnakeBundle sb, int dir, int[][] map) {
        
        // SET : head x head y
        int x = head.getxCo();
        int y = head.getyCo();
        
        if (x >= 2 && x < map.length - 2 && y >= 2 && y < map.length - 2) {
            
            switch (dir) {
                case 1:
                    {
                        // SOUTH : look for a NORTH head
                        int sX = head.getxCo();
                        int sY = head.getyCo();
                        // two units below
                        sY = sY + 2;
                        // snake number at that point
                        if (map[sX][sY] != 0 && map[sX][sY] != 5
                                && map[sX][sY] != 7 && map[sX][sY] != 8
                                && map[sX][sY] != 9) {
                            
                            // FIND : snake
                            int sN = map[sX][sY];
                            
                            // VERIFY : if snake head
                            Coords s = sb.findSnakeHead(sN);
                            if (sX == s.getxCo() && sY == s.getyCo()) return true;
                        }       break;
                    }
                case 2:
                    {
                        // WEST : look for a EAST head
                        int sX = head.getxCo();
                        int sY = head.getyCo();
                        // two units left
                        sX = sX - 2;
                        // snake number at that point
                        if (map[sX][sY] != 0 && map[sX][sY] != 5
                                && map[sX][sY] != 7 && map[sX][sY] != 8
                                && map[sX][sY] != 9) {
                            
                            // FIND : snake
                            int sN = map[sX][sY];
                            
                            // VERIFY : if snake head
                            Coords s = sb.findSnakeHead(sN);
                            if (sX == s.getxCo() && sY == s.getyCo()) return true;
                        }       break;
                    }
                case 3:
                    {
                        // EAST : look for a WEST head
                        int sX = head.getxCo();
                        int sY = head.getyCo();
                        // two right above
                        sX = sX + 2;
                        // snake number at that point
                        if (map[sX][sY] != 0 && map[sX][sY] != 5
                                && map[sX][sY] != 7 && map[sX][sY] != 8
                                && map[sX][sY] != 9) {
                            
                            // FIND : snake
                            int sN = map[sX][sY];
                            
                            // VERIFY : if snake head
                            Coords s = sb.findSnakeHead(sN);
                            if (sX == s.getxCo() && sY == s.getyCo()) return true;
                        }       break;
                    }
                default:
                    {
                        // NORTH : look for a SOUTH head
                        int sX = head.getxCo();
                        int sY = head.getyCo();
                        // two units above
                        sY = sY - 2;
                        // snake number at that point
                        if (map[sX][sY] != 0 && map[sX][sY] != 5
                                && map[sX][sY] != 7 && map[sX][sY] != 8
                                && map[sX][sY] != 9) {
                            
                            // FIND : snake
                            int sN = map[sX][sY];
                            
                            // VERIFY : if snake head
                            Coords s = sb.findSnakeHead(sN);
                            if (sX == s.getxCo() && sY == s.getyCo()) return true;
                        }       break;
                    }
            }
            
        }
        
        return false;
        
    }
    
    public static int diagonalOn(Coords head, SnakeBundle bun, int dir, int[][] map) {
        
        /**
         * SNAKE : intercept array
         * 0    diagonal left       clear ?
         * 1    diagonal right      clear ?
         */
        
        // SET : head x and y
        int x = head.getxCo();
        int y = head.getyCo();
        
        
        if (x >= 1 && x < map.length - 1 && y >= 1 && y < map.length - 1) {
            if (dir == 1) {
                
                // SOUTH : check EAST and WEST
                int xleft = x + 1;
                int yleft = y + 1;
                int xright = x - 1;
                int yright = y + 1;
            
                // WEST FORWARD
                if (map[xright][yright] != 0
                        && map[xright][yright] != 5
                        && map[xright][yright] != 8
                        && map[xright][yright] != 9) {
                    
                    int num = map[xright][yright];
                    
                    Coords s = bun.findSnakeHead(num);
                    
                    if (xright == s.getxCo() && yright == s.getyCo()) return 3;
                }
                // EAST FORWARD
                if (map[xleft][yleft] != 0
                        && map[xleft][yleft] != 5
                        && map[xleft][yleft] != 8
                        && map[xleft][yleft] != 9) {
                    
                    int num = map[xleft][yleft];
                    
                    Coords s = bun.findSnakeHead(num);
                    
                    if (xleft == s.getxCo() && yleft == s.getyCo()) return 2;
                }
                
                ////////////////////////////////////////////////
                xleft = x + 1;
                yleft = y - 1;
                xright = x - 1;
                yright = y - 1;
                // WEST BACKWARD
                if (map[xright][yright] != 0
                        && map[xright][yright] != 5
                        && map[xright][yright] != 8
                        && map[xright][yright] != 9) {
                    
                    int num = map[xright][yright];
                    
                    Coords s = bun.findSnakeHead(num);
                    
                    if (xright == s.getxCo() && yright == s.getyCo()) return 3;
                }
                // EAST BACKWARD
                if (map[xleft][yleft] != 0
                        && map[xleft][yleft] != 5
                        && map[xleft][yleft] != 8
                        && map[xleft][yleft] != 9) {
                    
                    int num = map[xleft][yleft];
                    
                    Coords s = bun.findSnakeHead(num);
                    
                    if (xleft == s.getxCo() && yleft == s.getyCo()) return 2;
                }
            
            }
            else if (dir == 2) {
            
                // WEST : check SOUTH and NORTH
                int xleft = x - 1;
                int yleft = y + 1;
                int xright = x - 1;
                int yright = y - 1;
            
                // NORTH
                if (map[xright][yright] != 0
                        && map[xright][yright] != 5
                        && map[xright][yright] != 8
                        && map[xright][yright] != 9) {
                    
                    int num = map[xright][yright];
                    
                    Coords s = bun.findSnakeHead(num);
                    
                    if (xright == s.getxCo() && yright == s.getyCo()) return 1;
                }
                // SOUTH
                if (map[xleft][yleft] != 0
                        && map[xleft][yleft] != 5
                        && map[xleft][yleft] != 8
                        && map[xleft][yleft] != 9) {
                    
                    int num = map[xleft][yleft];
                    
                    Coords s = bun.findSnakeHead(num);
                    
                    if (xleft == s.getxCo() && yleft == s.getyCo()) return 0;
                }
                
                ////////////////////////////////////////////////
                xleft = x + 1;
                yleft = y + 1;
                xright = x + 1;
                yright = y - 1;
                // NORTH BACKWARD
                if (map[xright][yright] != 0
                        && map[xright][yright] != 5
                        && map[xright][yright] != 8
                        && map[xright][yright] != 9) {
                    
                    int num = map[xright][yright];
                    
                    Coords s = bun.findSnakeHead(num);
                    
                    if (xright == s.getxCo() && yright == s.getyCo()) return 1;
                }
                // SOUTH BACKWARD
                if (map[xleft][yleft] != 0
                        && map[xleft][yleft] != 5
                        && map[xleft][yleft] != 8
                        && map[xleft][yleft] != 9) {
                    
                    int num = map[xleft][yleft];
                    
                    Coords s = bun.findSnakeHead(num);
                    
                    if (xleft == s.getxCo() && yleft == s.getyCo()) return 0;
                }
            
            }
            else if (dir == 3) {
            
                // EAST : check SOUTH and NORTH
                int xleft = x + 1;
                int yleft = y - 1;
                int xright = x + 1;
                int yright = y + 1;
            
                // SOUTH
                if (map[xright][yright] != 0
                        && map[xright][yright] != 5
                        && map[xright][yright] != 8
                        && map[xright][yright] != 9) {
                    
                    int num = map[xright][yright];
                    
                    Coords s = bun.findSnakeHead(num);
                    
                    if (xright == s.getxCo() && yright == s.getyCo()) return 0;
                }
                // NORTH
                if (map[xleft][yleft] != 0
                        && map[xleft][yleft] != 5
                        && map[xleft][yleft] != 8
                        && map[xleft][yleft] != 9) {
                    
                    int num = map[xleft][yleft];
                    
                    Coords s = bun.findSnakeHead(num);
                    
                    if (xleft == s.getxCo() && yleft == s.getyCo()) return 1;
                }
                
                ////////////////////////////////////////////////
                xleft = x - 1;
                yleft = y - 1;
                xright = x - 1;
                yright = y + 1;
                // SOUTH BACKWARD
                if (map[xright][yright] != 0
                        && map[xright][yright] != 5
                        && map[xright][yright] != 8
                        && map[xright][yright] != 9) {
                    
                    int num = map[xright][yright];
                    
                    Coords s = bun.findSnakeHead(num);
                    
                    if (xright == s.getxCo() && yright == s.getyCo()) return 0;
                }
                // NORTH BACKWARD
                if (map[xleft][yleft] != 0
                        && map[xleft][yleft] != 5
                        && map[xleft][yleft] != 8
                        && map[xleft][yleft] != 9) {
                    
                    int num = map[xleft][yleft];
                    
                    Coords s = bun.findSnakeHead(num);
                    
                    if (xleft == s.getxCo() && yleft == s.getyCo()) return 1;
                }
            
            }
            else {
            
                // NORTH : check EAST and WEST
                int xleft = x - 1;
                int yleft = y - 1;
                int xright = x + 1;
                int yright = y - 1;
            
                // EAST
                if (map[xright][yright] != 0
                        && map[xright][yright] != 5
                        && map[xright][yright] != 8
                        && map[xright][yright] != 9) {
                    
                    int num = map[xright][yright];
                    
                    Coords s = bun.findSnakeHead(num);
                    
                    if (xright == s.getxCo() && yright == s.getyCo()) return 2;
                }
                // WEST
                if (map[xleft][yleft] != 0
                        && map[xleft][yleft] != 5
                        && map[xleft][yleft] != 8
                        && map[xleft][yleft] != 9) {
                    
                    int num = map[xleft][yleft];
                    
                    Coords s = bun.findSnakeHead(num);
                    
                    if (xleft == s.getxCo() && yleft == s.getyCo()) return 3;
                }
                
                ////////////////////////////////////////////////
                xleft = x - 1;
                yleft = y + 1;
                xright = x + 1;
                yright = y + 1;
                // EAST BACKWARD
                if (map[xright][yright] != 0
                        && map[xright][yright] != 5
                        && map[xright][yright] != 8
                        && map[xright][yright] != 9) {
                    
                    int num = map[xright][yright];
                    
                    Coords s = bun.findSnakeHead(num);
                    
                    if (xright == s.getxCo() && yright == s.getyCo()) return 2;
                }
                // EAST BACKWARD
                if (map[xleft][yleft] != 0
                        && map[xleft][yleft] != 5
                        && map[xleft][yleft] != 8
                        && map[xleft][yleft] != 9) {
                    
                    int num = map[xleft][yleft];
                    
                    Coords s = bun.findSnakeHead(num);
                    
                    if (xleft == s.getxCo() && yleft == s.getyCo()) return 3;
                }
            
            }
        }
        
        return -2;
    }
    
}
