/*
Cancer.java 
Created by: Lucas Noritomi-Hartwig
Created on: April 1, 2020
Last edited on: April 2, 2020
This program finds the number of blobs of cancerous cells in the grid.
Note: It uses the Flood Fill algorithm to determine this information.
*/
package cancer;

public class Cancer {

    //Make global variables (grid&blobSize) which are accessible
    //from anywhere inside the class FloodIntro

    public static String grid[][];
    public static int spots = 0; // Variable to determine number of spots

    public static void main(String[] args) {
        int row, col;
        // Create 2D array size 15 x 15
        grid = new String[15][15];

        // Fill the array with plus signs
        for (row = 0; row < 15; row++) {
            for (col = 0; col < 15; col++) {
                grid[row][col] = "+";
            }
        }

        // Fill 70 random elements in the array with a minus sign
        // Do no choose an element along the border
        // The border will always contain elements with spaces
        // (blank border)
        for (int i = 0; i < 2; i++) {
            row = (int) (Math.random() * 13 + 1);
            col = (int) (Math.random() * 13 + 1);
            floodFill(row, col, "+", "-");
        }

        // Print out the current grid
        displayGrid();

        // For every element in the array that is not part of the border, check
        // for minus signs and reemoves the cancer spot, replacing it with spaces
        // then adding to the count of cancer spots
        for (row = 1; row < 14; row++) {
            for (col = 1; col < 14; col++) {
                if (grid[row][col].equals("-")) {
                    floodFill(row, col, "-", " ");
                    spots++;
                }
            }
        }
        
        System.out.println("The file has " + spots + " cancer spots in it");
        System.out.println("The new grid is:");
        //Print out the new grid
        displayGrid();
    }

    public static void floodFill(int row, int col, String check, String fill) {
        if (check.equals("-") && fill.equals(" ")) { // Removal of cancer cells
            if (grid[row][col].equals(check)) {
                grid[row][col] = fill;
                floodFill(row - 1, col - 1, check, fill);
                floodFill(row - 1, col, check, fill);
                floodFill(row - 1, col + 1, check, fill);
                floodFill(row, col - 1, check, fill);
                floodFill(row, col + 1, check, fill);
                floodFill(row + 1, col - 1, check, fill);
                floodFill(row + 1, col, check, fill);
                floodFill(row + 1, col + 1, check, fill);
            }
        } else if (check.equals("+") && fill.equals("-")) {
            if (grid[row][col].equals(check)) { // Weighted and randomized growth of cancer cells
                grid[row][col] = fill;
                int growthWeight = 77; 
                if (row - 1 > 0 && row + 1 < 14 && col - 1 > 0 && col + 1 < 14) {
                    int random1 = (int) Math.round(Math.random() * 100);
                    if (random1 >= growthWeight) {
                        floodFill(row - 1, col - 1, check, fill);
                    }
                    int random2 = (int) Math.round(Math.random() * 100);
                    if (random2 >= growthWeight) {
                        floodFill(row - 1, col, check, fill);
                    }
                    int random3 = (int) Math.round(Math.random() * 100);
                    if (random3 >= growthWeight) {
                        floodFill(row - 1, col + 1, check, fill);
                    }
                    int random4 = (int) Math.round(Math.random() * 100);
                    if (random4 >= growthWeight) {
                        floodFill(row, col - 1, check, fill);
                    }
                    int random5 = (int) Math.round(Math.random() * 100);
                    if (random5 >= growthWeight) {
                        floodFill(row, col + 1, check, fill);
                    }
                    int random6 = (int) Math.round(Math.random() * 100);
                    if (random6 >= growthWeight) {
                        floodFill(row + 1, col - 1, check, fill);
                    }
                    int random7 = (int) Math.round(Math.random() * 100);
                    if (random7 >= growthWeight) {
                        floodFill(row + 1, col, check, fill);
                    }
                    int random8 = (int) Math.round(Math.random() * 100);
                    if (random8 >= growthWeight) {
                        floodFill(row + 1, col + 1, check, fill);
                    }
                }
            }
        }
    }

    public static void displayGrid() {
        String output = "";
        for (int row = 0; row <= 14; row++) {
            for (int col = 0; col <= 14; col++) {
                output += grid[row][col];
            }
            output += "\n";
        }
        System.out.println(output);
    }
    
}
