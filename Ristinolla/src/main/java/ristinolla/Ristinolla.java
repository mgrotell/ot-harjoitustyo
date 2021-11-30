/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        GridPane grid = new GridPane();
 
        Button eka = new Button(" ");
        eka.setFont(Font.font("Monospaced", 40));
        grid.add(eka, 1, 1);
 
        Button toka = new Button(" ");
        toka.setFont(Font.font("Monospaced", 40));
        grid.add(toka, 2, 1);
 
        Button kolmas = new Button(" ");
        kolmas.setFont(Font.font("Monospaced", 40));
        grid.add(kolmas, 3, 1);
 
        Button neljas = new Button(" ");
        neljas.setFont(Font.font("Monospaced", 40));
        grid.add(neljas, 1, 2);
 
        Button viides = new Button(" ");
        viides.setFont(Font.font("Monospaced", 40));
        grid.add(viides, 2, 2);
 
        Button kuudes = new Button(" ");
        kuudes.setFont(Font.font("Monospaced", 40));
        grid.add(kuudes, 3, 2);
 
        Button seitsemas = new Button(" ");
        seitsemas.setFont(Font.font("Monospaced", 40));
        grid.add(seitsemas, 1, 3);
 
        Button kahdeksas = new Button(" ");
        kahdeksas.setFont(Font.font("Monospaced", 40));
        grid.add(kahdeksas, 2, 3);
 
        Button yhdeksas = new Button(" ");
        yhdeksas.setFont(Font.font("Monospaced", 40));
        grid.add(yhdeksas, 3, 3);
 
        BorderPane pane = new BorderPane();
        info = new Label("Vuoro: X");
        pane.setTop(info);
        pane.setCenter(grid);
 
        Scene jarjestelut = new Scene(pane);
 
        arg0.setScene(jarjestelut);
        arg0.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
