/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.wits.snake.agent.extra;

/**
 * FILE : Coords.java
 * @author ntsiki
 */
public class Coords {
    
    private final int xCo, yCo;

    public Coords(String string) {
        
        String[] toks = string.split(",");
        
        this.xCo = Integer.parseInt(toks[0]);
        this.yCo = Integer.parseInt(toks[1]);
        
    }
    
    public Coords(int x, int y) {
        
        this.xCo = x;
        this.yCo = y;
        
    }
    
    public int getxCo() {
        return xCo;
    }
    
    public int getyCo() {
        return yCo;
    }
    
    public static boolean leftOf(Coords a, Coords b) {
        
        /**
         * COORDINATES : 
         * check if A is left of B;
         */
        return a.getxCo() < b.getxCo();
        
    }
    
    public static boolean rightOf(Coords a, Coords b) {
        
        /**
         * COORDINATES : 
         * check if A is right of B;
         */
        return a.getxCo() > b.getxCo();
        
    }
    
    public static boolean aboveOf(Coords a, Coords b) {
        
        /**
         * COORDINATES : 
         * check if A is above B;
         */
        return a.getyCo() < b.getyCo();
        
    }
    
    public static boolean belowOf(Coords a, Coords b) {
        
        /**
         * COORDINATES : 
         * check if A is below B;
         */
        return a.getxCo() > b.getxCo();
        
    }
    
    public static boolean equals(Coords a, Coords b) {
        
        /**
         * COORDINATES :
         * check if coordinates are equal
         */
        return a.getxCo() == b.getxCo() && a.getyCo() == b.getyCo();
    }
    
    
    /*  try {
     *      PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
     *      writer.println("The first line");
     *      writer.println("The second line");
     *      writer.close();
     *  } catch (IOException e) {
     *       // do something
     *      }
    */
    
}
