package nl.inholland.javafx.Assigmnents;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.Random;

public class Assignment3 {

    String[][] grid;
    GridPane btnGrid;


    public Assignment3(GridPane btnGrid){
        grid = new String[3][3];
        fillStringGrid();
        this.btnGrid = btnGrid;
    }

    private void fillStringGrid(){
        for (int r = 0; r < 3; r++) {
            for (int k = 0; k < 3; k++) {
                grid[r][k] = "_";
            }
        }
    }


    public void playerTurn(Button b, int r, int k){
        b.setText("X");
        b.setDisable(true);
        grid[r][k] = "x";
        fillGrid();
        if (checkBoard())
        computerTurn();
    }

    public void computerTurn(){

        // create random values for random move
        int r;
        int k;
        do {
            r = new Random().nextInt(3);
            k = new Random().nextInt(3);
        }while (grid[r][k] != "_");

        // when a empty pos is found, place an o in the grid and fill grid again
        grid[r][k] = "o";
        fillGrid();

        // check for a winner
        if (checkBoard())
            System.out.println("End");
    }

    public GridPane fillGrid(){
        for (int r = 0; r < 3; r++) {
            for (int k = 0; k < 3; k++) {
                // make a button with a fixed size
                Button b = new Button();
                b.setMinSize(100, 100);

                // set an event handler on each button
                int R = r;
                int K = k;
                b.setOnAction(actionEvent -> playerTurn(b, R, K));

                // iterate through grid and set button text
                if (grid[r][k] == "o")
                    b.setText("O");
                else if (grid[r][k] == "x")
                    b.setText("X");
                else
                    b.setText("_");

                // add button to GridPane
                btnGrid.add(b, k, r);
            }
        }
        return btnGrid;
    }



    public boolean checkBoard(){
        // check horizontal or vertical rows
        if (checkHorizontal() || checkVertical())
            return true;
        else
            return false;
    }

    private boolean checkVertical(){
        // iterate through all the columns on a row
        for (int k = 0; k < 3; k++) {
            if (grid[0][k] != "_")
                if (grid[0][k].equalsIgnoreCase(grid[1][k]) && grid[1][k].equalsIgnoreCase(grid[2][k])){
                    return true;
            }
        }
        return false;
    }

    private boolean checkHorizontal(){
        // iterate through all rows on a column
        for (int r = 0; r < 3; r++) {
            if (grid[r][0] != "_")
                if (grid[r][0].equalsIgnoreCase(grid[r][1]) && grid[r][1].equalsIgnoreCase(grid[r][2])){
                    return true;
            }
        }
        return false;
    }
}
