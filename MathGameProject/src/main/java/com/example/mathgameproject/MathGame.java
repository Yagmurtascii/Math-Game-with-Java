package com.example.mathgameproject;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class MathGame extends Application {

    GenerateNumbers generateNumbers=new GenerateNumbers();
    Shape shape= new Shape();
    Cursor cursor=new Cursor();
    Label text=new Label("M a t h  G a m e");

    Scene startScene,playerScene;

    @Override
    public void start(Stage stage) throws IOException {

        //region StartPane
        Pane startPane = new Pane();

        text.setId("gameName");
        text.getStylesheets().add(getClass().getResource("DesignText.css").toExternalForm());


        cursor.Cursor(startPane);
        shape.shapeLabel(text,100,100);
        text.setFont(new Font("Bernard MT Condensed",50));

        Button easy = new Button("E A S Y");
        shape.startButtons(easy, 3, 300);
        easy.setId("buttonEasy");
        easy.getStylesheets().add(getClass().getResource("EasyButtonShape.css").toExternalForm());
        easy.setOnAction(e->
        {
            generateNumbers.bound=21;
            generateNumbers.generate();
            generateNumbers.fillRandomButtons();
            generateNumbers.checkAnswer();
            stage.setScene(playerScene);

        });

        Button medium = new Button("M E D I U M");
        shape.startButtons(medium, 147, 300);
        medium.setId("buttonMedium");
        medium.getStylesheets().add(getClass().getResource("MediumButtonShape.css").toExternalForm());

        medium.setOnAction(e->
        {
            generateNumbers.bound=41;
            generateNumbers.generate();
            generateNumbers.fillRandomButtons();
            generateNumbers.checkAnswer();
            stage.setScene(playerScene);
        });

        Button hard = new Button("H A R D");
        shape.startButtons(hard, 345, 300);
        hard.setId("buttonHard");
        hard.getStylesheets().add(getClass().getResource("HardButtonShape.css").toExternalForm());
        hard.setOnAction(e->
        {
            generateNumbers.bound=60;
            generateNumbers.generate();
            generateNumbers.fillRandomButtons();
            generateNumbers.checkAnswer();
            stage.setScene(playerScene);
        });

        startPane.getChildren().addAll(easy,medium,hard,text);
        startScene = new Scene(startPane, 500, 500);
        //endregion

        //region PlayerPane

        Pane playerPane=new Pane();
        cursor.Cursor(playerPane);


        FileInputStream backgroundImage = new FileInputStream("src/main/resources/elephant.png");
        Image background = new Image(backgroundImage);
        ImageView backgroundView = new ImageView(background);
        backgroundView.setX(220);
        backgroundView.setScaleX(backgroundView.getScaleX()/2);
        backgroundView.setScaleY(backgroundView.getScaleY()/2);

        shape.shapeLabel(generateNumbers.correctAnswer,330,50);
        shape.shapeLabel(generateNumbers.wrongAnswer,330,70);

        shape.shapeQuestionsButton(generateNumbers.numberLabel1,110,130);
        shape.shapeQuestionsButton(generateNumbers.numberLabel2,313,130);
        shape.shapeQuestionsButton(generateNumbers.operatorLabel,210,130);

        shape.shapeButton(generateNumbers.optionA,80,280);
        shape.shapeButton(generateNumbers.optionB,200,280);
        shape.shapeButton(generateNumbers.optionC,320,280);

        playerPane.getChildren().addAll(backgroundView, generateNumbers.numberLabel1,generateNumbers.numberLabel2,generateNumbers.operatorLabel,generateNumbers.optionA,generateNumbers.optionB,generateNumbers.optionC,generateNumbers.wrongAnswer,generateNumbers.correctAnswer);
        playerScene = new Scene(playerPane, 500, 500);

        stage.setScene(startScene);
        stage.setTitle("Math Game");
        stage.getIcons().add(new Image("file:src/main/resources/icons8_Math_128px_1.png"));
        stage.show();
        //endregion
    }

}