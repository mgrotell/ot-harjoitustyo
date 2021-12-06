/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

/**
 *
 * @author miklas
 */
public class Ristinolla extends Application {

    private String vuoro = "Vuoro: X";
    private Label info;
    private int alku = 0;
    private int numero = 0;

    @Override
    public void start(Stage arg0) throws Exception {
        Grid grid = new Grid(70);
        BorderPane pane = new BorderPane();
        info = new Label("Vuoro: X");
        pane.setTop(info);
        pane.setCenter(grid.getGrid());
        Button kona = new Button(" ");
        Scene jarjestelut = new Scene(pane);
        arg0.setScene(jarjestelut);
        arg0.show();
        int x = 1;
        int y = 1;

        Button[][] tiles = grid.getTiles();
        while (x <= grid.getGridSize()) {

            y = 1;
            while (y <= grid.getGridSize()) {
                Button b = tiles[x][y];
                b.setOnAction((event) -> {
                    if (b.getText().equals(" ") && grid.getGameState() == 0) {
                        String vuoro = grid.getTurn();
                        b.setText(vuoro);
                    }
                    String voittaja = grid.checkWinner();
                    if(!voittaja.equals("")) {
                        info.setText("Voittaja: " + voittaja);
                    }
                });
                y++;

            }
            x++;
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
