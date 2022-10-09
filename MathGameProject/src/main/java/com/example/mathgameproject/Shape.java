package com.example.mathgameproject;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Shape {
    public void shapeQuestionsButton(Button button, int localX, int localY)
    {
        button.setTranslateX(localX);
        button.setTranslateY(localY);
        button.setTextAlignment(TextAlignment.CENTER);
        button.setMinWidth(80);
        button.setMinHeight(80);
        button.setStyle( "-fx-background-color: #F4F4F4; -fx-border-color: #F4F4F4; ");
        button.setFont(new Font("Bernard MT Condensed",35));
    }
    public void shapeLabel(Label label, int localX, int localY)
    {
        label.setFont(new Font("Bernard MT Condensed",20));
        label.setTranslateX(localX);
        label.setTranslateY(localY);
    }
    public void startButtons(Button button,int localX,int localY) {
        button.setTranslateX(localX);
        button.setTranslateY(localY);
        button.setMinWidth(90);
        button.setMinHeight(90);
        button.setFont(new Font("Bernard MT Condensed", 35));
    }
    public void shapeButton(Button button,int localX,int localY)
    {
        button.setTranslateX(localX);
        button.setTranslateY(localY);
        button.setMinWidth(90);
        button.setMinHeight(90);
        button.setFont(new Font("Bernard MT Condensed",35));
        button.setStyle( "-fx-background-color: #F4F4F4; -fx-border-color:#ffca3a;-fx-border-width: 4; -fx-border-radius:5");
    }
}
