module com.example.mathgameproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mathgameproject to javafx.fxml;
    exports com.example.mathgameproject;
}