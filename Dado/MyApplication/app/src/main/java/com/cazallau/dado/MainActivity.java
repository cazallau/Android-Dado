package com.cazallau.dado;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Button button;
    ToggleButton percentil;
    ToggleButton normal;
    ImageView image;
    int [] imagenes = new int[] { R.drawable.dado1, R.drawable.dado2, R.drawable.dado3, R.drawable.dado4, R.drawable.dado5, R.drawable.dado6 };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.activity_main_button);
        image = (ImageView) findViewById(R.id.activity_main_image);
        percentil = (ToggleButton) findViewById(R.id.activity_main_percentil_button);
        normal = (ToggleButton) findViewById(R.id.activity_main_normal_button);
        text = (TextView) findViewById(R.id.activity_main_text);

        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setVisibility(View.VISIBLE);
                text.setVisibility(View.INVISIBLE);
                percentil.setChecked(false);
            }
        });

        percentil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setVisibility(View.INVISIBLE);
                text.setVisibility(View.VISIBLE);
                normal.setChecked(false);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int n;
                if (normal.isChecked()) {
                    n = aleatoryNumber(6);
                    image.setImageResource(imagenes[n]);
                }
                else{
                    n = aleatoryNumber(100);
                    text.setText("" + n);
                }
            }
        });


    }

    public int aleatoryNumber(int n){
        Random random = new Random();

        int number = random.nextInt(n);


        return number;
    }
}
