package com.example.mathgameproject;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Random;

public class GenerateNumbers {
    Button numberLabel1 = new Button();
    Button numberLabel2 = new Button();
    Button operatorLabel = new Button();
    Button optionA = new Button();
    Button optionB = new Button();
    Button optionC = new Button();
    Random random = new Random();

    int correct = 0, wrong = 0;
    int newResult = 0;
    Label correctAnswer = new Label("Correct Answer: 0");
    Label wrongAnswer = new Label("Wrong Answer: 0");

    public int bound;
    int number1, number2, result = 0;

    public void generate() {
        number1 = random.nextInt(bound);
        number2 = random.nextInt(bound) + 1;
        int operator = random.nextInt(4);
        numberLabel1.setText(Integer.toString(number1));
        numberLabel2.setText(Integer.toString(number2));

        if (operator == 0) {
            operatorLabel.setText("+");
            result = number1 + number2;

        } else if (operator == 1) {
            operatorLabel.setText("-");
            result = number1 - number2;

        } else if (operator == 2) {
            operatorLabel.setText("X");
            result = number1 * number2;

        } else {
            operatorLabel.setText("/");

            if (number1 > number2 && number1 % number2 == 0)
                result = number1 / number2;

            else
                generate();


        }

    }

    public void fillRandomButtons() {

        int options = random.nextInt(50);
        int randomIncrease1 = random.nextInt(6) + 1;
        int randomIncrease2 = random.nextInt(6) + 1;

        int closeResult1 = randomIncrease1 + result;
        int closeResult2 = randomIncrease2 + result;

        if (options % 2 == 0 && options % 3 != 0) {
            optionA.setText(String.valueOf(result));
            optionB.setText(String.valueOf(closeResult2));
            optionC.setText(String.valueOf(closeResult1));
        } else if (options % 2 == 0 && options % 3 == 0) {
            optionA.setText(String.valueOf(closeResult1));
            optionB.setText(String.valueOf(result));
            optionC.setText(String.valueOf(closeResult2));
        } else if (options % 2 != 0 && options % 3 == 0) {
            optionA.setText(String.valueOf(closeResult2));
            optionC.setText(String.valueOf(result));
            optionB.setText(String.valueOf(closeResult1));
        } else {
            optionA.setText(String.valueOf(closeResult1));
            optionB.setText(String.valueOf(result));
            optionC.setText(String.valueOf(closeResult2));
        }
    }

    public void checkAnswer() {
        optionA.setOnAction(e -> {
            newResult = Integer.parseInt(optionA.getText());

            if (result == newResult) {
                correct++;
                correctAnswer.setText("Correct Answer: " + correct);
                generate();
                fillRandomButtons();
            } else {
                wrong++;
                wrongAnswer.setText("Wrong Answer: " + wrong);
                generate();
                fillRandomButtons();
            }
        });

        optionB.setOnAction(e -> {
            newResult = Integer.parseInt(optionB.getText());

            if (result == newResult) {
                correct++;
                correctAnswer.setText("Correct Answer: " + correct);
                generate();
                fillRandomButtons();
            } else {
                wrong++;
                wrongAnswer.setText("Wrong Answer: " + wrong);
                generate();
                fillRandomButtons();
            }
        });

        optionC.setOnAction(e -> {
            newResult = Integer.parseInt(optionC.getText());

            if (result == newResult) {
                correct++;
                correctAnswer.setText("Correct Answer: " + correct);
                generate();
                fillRandomButtons();
            } else {
                wrong++;
                wrongAnswer.setText("Wrong Answer: " + wrong);
                generate();
                fillRandomButtons();
            }
        });
    }
}
