package neljansuora.controller;

/**
* This class is used for testing purposes - it doesn't do anything in the actual programme.
* Only essential difference with class Gamecontrol is that this class uses String 2d arrays instead of Label arrays.
*/
public class FakeGamecontrol {
    
    
    /**
    * Returns the tile that can be played in a given column.
    * 
    * @param    gameArea    A 2d array representing current state of the game.
    * @param    index   Index of the column player has chosen play.
    * 
    * @return Index of the tile that is free. If the column is full, returns -1.
    */
    public int getPlayableTile(String[][] gameArea, int index) {
        
        //checking playable tile from the bottom
        for (int i = 5; i >= 0; i--) {
            if (gameArea[index][i].equals(" ")) {
                return i;
            }
        }
        return -1;
    }
    
    /**
    * Checks if the game has been already won and returns that information.
    * 
    * @param    gameArea    A 2d array representing current state of the game.
    * 
    * @return True if game is indeed over and false, if it still should continue.
    */
    public boolean gameIsOver(String[][] gameArea) {
        if (checkRows(gameArea)) { 
            return true;
        }
        if (checkColumns(gameArea)) { 
            return true;
        }
        
        if (checkDiagonallyLToR(gameArea)) {
            return true;
        }
        
        if (checkDiagonallyRToL(gameArea)) {
            return true;
        }
        
        return false;
    }
    
    /**
    * Checks if one of the players has formed a winning combo in any of the rows.
    * 
    * @param    gameArea    A 2d array representing current state of the game.
    * 
    * @return True if such combo exists, false if not.
    */
    public boolean checkRows(String[][] gameArea) {
        String currentRow = "";
        for (int i = 0; i < 7; i++) {
            for (int y = 0; y < 6; y++) {
                currentRow += gameArea[i][y];
            }
            if (currentRow.contains("XXXX") || currentRow.contains("OOOO")) {
                return true;
            }
            currentRow = "";
        }
        return false;
    }
    
    /**
    * Checks if one of the players has formed a winning combo in any of the columns.
    * 
    * @param    gameArea    A 2d array representing current state of the game.
    * 
    * @return True if such combo exists, false if not.
    */
    public boolean checkColumns(String[][] gameArea) {
        String currentCol = "";
        for (int i = 0; i < 6; i++) {
            for (int y = 0; y < 7; y++) {
                currentCol += gameArea[y][i];
            }
            if (currentCol.contains("XXXX") || currentCol.contains("OOOO")) {
                return true;
            }
            currentCol = "";
        }
        return false;
    }
    
    /**
    * Checks if one of the players has formed a winning combo in any diagonal tiles starting from upper left to lower right.
    * 
    * @param    gameArea    A 2d array representing current state of the game.
    * 
    * @return True if such combo exists, false if not.
    */
    public boolean checkDiagonallyLToR(String[][] gameArea) {
        String currentDiag = "";
        int column = 0;
        for (int startingRow = 0; startingRow < 3; startingRow++) {
            for (int startingColumn = 0; startingColumn < 4; startingColumn++) {
                column = startingColumn;
                for (int row = startingRow; row < gameArea[0].length; row++) {
                    if (column < gameArea.length) {
                        currentDiag += gameArea[column][row];
                        column++;
                    }
                }

                if (currentDiag.contains("XXXX") || currentDiag.contains("OOOO")) {
                    return true;
                }

                currentDiag = "";
            }
        }
   
        return false;
    }
    
    /**
    * Checks if one of the players has formed a winning combo in any diagonal tiles starting from upper right to lower left.
    * 
    * @param    gameArea    A 2d array representing current state of the game.
    * 
    * @return True if such combo exists, false if not.
    */
    
    public boolean checkDiagonallyRToL(String[][] gameArea) {
        String currentDiag = "";
        int column = 0;
        for (int startingRow = 0; startingRow < 3; startingRow++) {
            for (int startingColumn = gameArea.length - 1; startingColumn >= 3; startingColumn--) {
                column = startingColumn;
                for (int row = startingRow; row < gameArea[0].length; row++) {
                    if (column >= 0) {
                        currentDiag += gameArea[column][row];
                        column--;
                    }
                }

                if (currentDiag.contains("XXXX") || currentDiag.contains("OOOO")) {
                    return true;
                }

                currentDiag = "";
            }
        }
   
        return false;
    }
}