/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 *
 * @author miklas
 */
public class Grid {

    private int n;
    private int gameState = 0;
    private String turn;
    private GridPane grid;
    private Button[][] tiles;

    public Grid(int n) {
        this.n = n < 3 ? 3 : n > 100 ? 100 : n;
        grid = new GridPane();
        this.gameState = 0;
        this.turn = "O";
        int z = 1;
        tiles = new Button[this.n + 1][this.n + 1];

        while (z <= this.n) {

            int j = 1;

            while (j <= this.n) {
                tiles[z][j] = new Button(" ");
                grid.add(tiles[z][j], z, j);
                tiles[z][j].setFont(Font.font("Monospaced", 400 / this.n));
                j++;
            }

            z++;
        }
    }

    public int getGridSize() {
        return this.n;
    }

    public int getGameState() {
        return this.gameState;
    }

    public String checkWinner() {

        int x = 1;
        int y;
        String xp = "";
        String op = "";
        String kon = "";

        while (x <= this.n) {
            xp += "X";
            op += "O";
            x++;
        }
        x = 1;

        while (x <= this.n) {
            y = 1;
            while (y <= this.n) {
                kon += this.tiles[x][y].getText();
                String t = getStrafes(x, y);
                if (t.contains(op)) {
                    return "O";
                }
                if (t.contains(xp)) {
                    return "X";
                }
                y++;
            }
            x++;
        }

        x = 1;
        y = 1;
        while (y <= this.n) {
            kon += this.tiles[x][y].getText();
            x++;
            if (x > this.n) {
                x = 1;
                y++;
            }
        }

        if (kon.contains(xp)) {
            return "X";
        }

        if (kon.contains(op)) {
            return "O";
        }
        return "";
    }

    private String getStrafes(int x, int y) {

        int j = x;
        int k = y;
        String kona = "";
        while (j <= this.n && k <= this.n) {
            kona += this.tiles[j][k].getText();
            j++;
            k++;
        }
        kona += " ";
        j = x;
        k = y;
        while (j >= 1 && k >= 1) {
            kona += this.tiles[j][k].getText();
            j--;
            k--;
        }
        kona += " ";
        j = x;
        k = y;
        while (j <= this.n && k >= 1) {
            kona += this.tiles[j][k].getText();
            j++;
            k--;
        }
        kona += " ";
        j = x;
        k = y;
        while (j >= 1 && k <= this.n) {
            kona += this.tiles[j][k].getText();
            j--;
            k++;
        }
        return kona;

    }

    public String getTurn() {
        this.turn = this.turn.equals("O") ? "X" : "O";
        return this.turn;
    }

    public Button[][] getTiles() {
        return this.tiles;
    }

    public void setGameToWinState() {
        this.gameState = 1;
    }

    public GridPane getGrid() {
        return this.grid;
    }

}
