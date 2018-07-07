package com.example.rahulpv.ghosts;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {
    private static final String COMPUTER_TURN ="Computer's turn" ;
    private static final String USER_TURN ="Your Turn" ;
    private TextView ghostTextView, gameStatus;
    private Button resetButton, challengeButton;
    private boolean turn;
    private SimpleDictionary simpleDictionary;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ghostTextView = findViewById(R.id.tv_ghostView);
        gameStatus = findViewById(R.id.tv_game_status);

        resetButton = findViewById(R.id.Reset);
        challengeButton = findViewById(R.id.Challenge);

        AssetManager assetManager = getAssets();
        try {
            simpleDictionary = new SimpleDictionary(
                    assetManager.open("words.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        reset();
        challenge();
        begin();
    }

    private void begin() {
        turn = new Random().nextBoolean();
        if (turn) {
            //user
            gameStatus.setText("Your Turn");
        } else {
            //computer
            gameStatus.setText("Computers turn");
        }

    }

    private void computerTurn() {
        Log.v("Turn",COMPUTER_TURN);
        gameStatus.setText(COMPUTER_TURN);

       new android.os.Handler().postDelayed(()-> {
            String ghostWord=ghostTextView.getText().toString();
            if(ghostWord.length()>=4&&simpleDictionary.isGoodWord(ghostWord)){
                gameStatus.setText("Computer Wins!");
                challengeButton.setEnabled(false);
            }else{
                String computerWord=simpleDictionary.getGoodWord(ghostWord);
                if(computerWord==null){
                    gameStatus.setText("computer wins");
                    challengeButton.setEnabled(false);
                }
                else{
                    ghostTextView.append(computerWord.charAt(ghostWord.length())+"");
                    turn=true;
                    gameStatus.setText(USER_TURN);
                }
            }
        },2000);
    }


    public void reset() {
        resetButton.setOnClickListener((view) -> {
            Log.v("reset", "reset button pressed");
        });
    }

    public void challenge() {
        challengeButton.setOnClickListener((view) -> {
            Log.v("challenge", "challenge button pressed");
        });
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (turn) {
            //users turn
            turn = false;
            char userInput = (char) event.getUnicodeChar();
            if (Character.isLetter(userInput)) {
                ghostTextView.append(Character.toString(userInput));
                computerTurn();
            }
        }


        return super.onKeyUp(keyCode, event);
    }
}
