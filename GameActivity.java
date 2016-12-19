package com.example.veres.games;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    TextView questionText;
    int min, max;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);

        questionText = (TextView) findViewById(R.id.question);

        Intent i = getIntent();
        String minStr = i.getStringExtra("min");
        String maxStr = i.getStringExtra("max");
        min = Integer.parseInt(minStr);
        max = Integer.parseInt(maxStr);

        Log.d("my", "min = " + minStr + " max = " + maxStr);
        questionText.setText("Угадываем число от " + minStr + " до "+ maxStr + "\nВаше число больше " + (max-min)/2);

    }
    public void onYesNoClick(View v)
    {
        if(max-min!=1)
        {

            if (v.getId() == R.id.yes) {
                min = (min + max) / 2;

                questionText.setText("Ваше число больше " + min + "?");

            }
            if (v.getId() == R.id.no) {
                max = (min + max) / 2;

                questionText.setText("Ваше число меньше " + max + "?");
            }
            if (max - max == 1)
            {
                questionText.setText("Ваше число " + max + "?");
            }

        }

        else {

            if (v.getId() == R.id.yes) {
                questionText.setText("Ура!Угадал!Ваше число " + min);
            }
            if (v.getId() == R.id.no) {
                questionText.setText("Ура!Угадал!Ваше число " + max);
            }
        }
    }
}
