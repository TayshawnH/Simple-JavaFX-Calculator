/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author pizzasleaze
 */
public class SimpleCalc extends Application {

    private TextField tay;

    @Override
    public void start(Stage primaryStage) {
        BorderPane bp = new BorderPane();
        tay = new TextField();
        tay.setEditable(false);
        bp.setTop(tay);

        GridPane gp = new GridPane();
        int counter = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                CircleButton cb = new CircleButton(Integer.toString(counter));
                gp.add(cb, j, i);
                cb.setOnMousePressed(new myHandler());
                cb.setOnMouseReleased(new myHandler());
                counter++;
            }
        }
        bp.setCenter(gp);
        gp.setVgap(3);
        gp.setAlignment(Pos.CENTER);

        HBox hb = new HBox();
        Button math = new Button("Sqrt");
      
        math.setOnAction((ActionEvent e) -> {
            tay.setText(Math.sqrt(Double.parseDouble(tay.getText())) + "");
        });

        Button math1 = new Button("x^2");
        math1.setOnAction((ActionEvent e) -> {
            tay.setText(Math.pow(Double.parseDouble(tay.getText()), 2) + "");
        });
        
        Button math2 = new Button("Clr");
        math2.setOnAction((ActionEvent e) ->{
            tay.clear();
        });
     
        hb.getChildren().addAll(math, math1, math2);
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(3);
        bp.setBottom(hb);
        
        
        Scene scene = new Scene(bp, 250, 275);

        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class myHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent e) {
            CircleButton clicked = (CircleButton) e.getSource();

            if (clicked.getColor() == Color.SILVER) {
                clicked.setColor(Color.FLORALWHITE);
                tay.appendText(clicked.getValue());
            } else {
                clicked.setColor(Color.SILVER);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
