package com.example.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by kmurali on 18-11-2017.
 */

public class T1 extends AppCompatActivity {

    //0=t,1=t1

    int activeplayer=0;


    //2 means unplayed


    int[] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2};



    int[][] winningpositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    private android.os.Bundle savedInstanceState;


    public void play(View view) {
        ImageView counter = (ImageView) view;

        System.out.println(counter.getTag().toString());

        int Tappedcounter = Integer.parseInt(counter.getTag().toString());

        if (gamestate[Tappedcounter] == 2) {

            gamestate[Tappedcounter] = activeplayer;


            counter.setTranslationY(-1000f);

            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.t);
                activeplayer = 1;
            } else {
                counter.setImageResource(R.drawable.t1);
                activeplayer = 0;
            }
            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);

            for (int[] winningposition : winningpositions) {

                if (gamestate[winningposition[0]] == gamestate[winningposition[1]] &&
                        gamestate[winningposition[1]] == gamestate[winningposition[2]] && gamestate[winningposition[0]] != 2) {


                    String winnerMessage;




                    if (gamestate[winningposition[0]] == 0) {

                        winnerMessage="X";

                        winnerMessage="O";

                        TextView winner = (TextView) findViewById(R.id.winner);

                        winner.setText(winnerMessage  + " has won!!");

                        LinearLayout layout = (LinearLayout) findViewById(R.id.playagainLayout);

                        layout.setVisibility(view.VISIBLE);


                    }

                }

            }
        }
    }

    public void playagain(View view) {


        LinearLayout layout = (LinearLayout) findViewById(R.id.playagainLayout);

        layout.setVisibility(View.INVISIBLE);

        activeplayer = 0;

        //2 means unplayed


        for (int i = 0; i < gamestate.length;i++) {

            gamestate[i] = 2;


        }


        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        for (int i = 0; i < gridLayout.getChildCount(); i++) {

            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t1);
    }
}
