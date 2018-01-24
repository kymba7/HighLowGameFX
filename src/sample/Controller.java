package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.util.Random;
import java.util.Scanner;


public class Controller {
    Random random = new Random();
    int GAME_LOW = 0;
    int GAME_HIGH = 10;
    int low = GAME_LOW;
    int high = GAME_HIGH;
    int secretNumI = random.nextInt(high);
    String secretNumS = Integer.toString(secretNumI);

    int numberOfTries = 0;


    @FXML
    private TextField guessField;
    @FXML
    private Button submitButton;
    @FXML
    private Button newgame;
    @FXML
    private Button endgame;

    @FXML
    private Text highlow;
    @FXML
    private Text range;
    @FXML
    private Text showsecret;

    public void clicksubmit ( ActionEvent actionEvent ) {
        numberOfTries++;
        String guessFieldS = guessField.getText();
        int guessFieldI = Integer.parseInt(guessFieldS);
        if (guessFieldI > secretNumI) {
            high = guessFieldI;
            highlow.setText("Too high!");
            range.setText("Guess again between: " + low + " and " + high);
            showsecret.setText("Guess: " + numberOfTries);


        }
        if (guessFieldI < secretNumI) {
            low = guessFieldI;
            highlow.setText("Too low!");
            range.setText("Guess again between: " + low + " and " + high);
            showsecret.setText("Guess: " + numberOfTries);


        }
        if (guessFieldI == secretNumI) {
            highlow.setText("BaBoom!! You guessed it!!");
            showsecret.setText("It took you " + numberOfTries + " guesses to find the correct number.");
        }
        guessField.setText("");


    }

    public void clicknewgame ( ActionEvent actionEvent ) {
        GAME_LOW = 0;
        GAME_HIGH = 10;
        low = GAME_LOW;
        high = GAME_HIGH;
        numberOfTries=0;
        highlow.setText("");
        range.setText("");
        showsecret.setText("");
        secretNumI =random.nextInt(high);
        secretNumS = Integer.toString(secretNumI);



        }

        public void clickend(ActionEvent actionEvent){
            System.exit(0);
        }
    }

