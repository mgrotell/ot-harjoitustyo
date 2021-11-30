/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla;

/**
 *
 * @author miklas
 */
public class Grid {

    int n;
    int[][] grid;

    public Grid(int n) {
        this.n = n < 2 ? 2 : n < 200 ? n : 200;
        grid = new int[this.n][this.n];
        int x = 0;
        while (x < this.n) {

            int y = 0;
            while (y < this.n) {
                this.grid[x][y] = -1;
                y++;
            }
            x++;
        }
    }

    public int getGridSize() {
        return this.n;
    }

    public int[][] getGrid() {
        return this.grid;
    }

    public void setGridnum(int x, int y, int player) {
        if (x <= this.n && y <= this.n && x >= 0 && y >= 0 && (player == 0 | player == 1)) {
            this.grid[x][y] = player;
        }
    }

    public boolean isPlaceFree(int x, int y) {
        if (x <= this.n && y <= this.n) {
            return this.grid[x][y] == -1;
        }
        return false;
    }
}
