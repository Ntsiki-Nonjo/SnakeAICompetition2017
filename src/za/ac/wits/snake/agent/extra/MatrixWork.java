/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.wits.snake.agent.extra;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author ntsiki
 */
public class MatrixWork {
    
    public static void writetofile(int[][] mat, String filename) throws FileNotFoundException, UnsupportedEncodingException {
        
        if (filename == null) filename = "output.txt";
        
        try (
                
                PrintWriter writer = new PrintWriter(filename, "UTF-8")) {
            
            for (int i = 0; i < mat.length; i++) {
                
                for (int j = 0; j < mat[i].length; j++) {
                    writer.print(mat[j][i] + " ");
                }
                writer.println();
            }
        }
    }
    
    public static void setTo(int[][] mat, int num) {
        
        for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    mat[i][j] = num;
                }
        }   
    }
}
