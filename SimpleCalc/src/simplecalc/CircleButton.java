/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalc;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 *
 * @author pizzasleaze
 */
public class CircleButton extends StackPane {
    private Label lblValue;
    private Circle circle;
    
    public CircleButton(){
        this.circle = new Circle(33.0);
        this.lblValue = new Label();
        this.circle.setFill(Color.SILVER);
        this.circle.setStroke(Color.SILVER);
        this.circle.setSmooth(true);
        this.setPrefSize(100, 100);
    }
    
    public CircleButton(String val){
        this();
        this.lblValue.setText(val);
        this.getChildren().addAll(circle, lblValue);
    }
    
    public void setColor(Paint color){
        this.circle.setFill(color);
    }
    
    public Paint getColor(){
        return circle.getFill();
    }
    
    public String getValue(){
        return lblValue.getText();
    }
    
}
