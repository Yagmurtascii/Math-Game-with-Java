package com.example.mathgameproject;

import javafx.scene.ImageCursor;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Cursor {
    public void Cursor(Pane pane) throws FileNotFoundException {
        FileInputStream cursor = new FileInputStream("src/main/resources/cursor.png"); //cursor image
        Image cursorImage = new Image(cursor);//cursor image
        pane.setCursor(new ImageCursor(cursorImage,
                cursorImage.getWidth() / 2,
                cursorImage.getHeight() / 2));
    }
}
