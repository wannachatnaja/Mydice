package kru.poompunk.wannachat.mydice;

import android.media.MediaPlayer;
import android.service.voice.VoiceInteractionSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView Imagedice;
    private Button btnback, btnrandom, btnnext;
    private int intdice = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindWidget();
        backCon();
        randomCon();
        nextCon();

    }

    private void nextCon() {
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intdice += 1;
                if (intdice == 7) {
                    intdice = 1;
                }
                changeplay(intdice);

            }
        });
    }

    private void randomCon() {
        btnrandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRandomPicture(intdice);
            
            }
        });
    }


    private void backCon() {
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intdice -= 1;
                if (intdice == 0) {
                    intdice = 6;
                }
                changeplay(intdice);

            }
        });
    }


    private void bindWidget() {

        Imagedice = (ImageView) findViewById(R.id.imgDice);
        btnback = (Button) findViewById(R.id.btnBack);
        btnrandom = (Button) findViewById(R.id.btnRandom);
        btnnext = (Button) findViewById(R.id.btnNext);

    }

    private void myRandomPicture(int intUser) {
        int myRandom = 0;
        Random objRandom = new Random();
        myRandom = objRandom.nextInt(6) + 1;
        Log.d("Ran", "myRandom ==>" + myRandom);

        overChange(myRandom);


    }// MRP

    private void overChange(int myRandom) {
        int[] intSource = new int[7];
        intSource[0] = 0;
        intSource[1] = R.drawable.dice1;
        intSource[2] = R.drawable.dice2;
        intSource[3] = R.drawable.dice3;
        intSource[4] = R.drawable.dice4;
        intSource[5] = R.drawable.dice5;
        intSource[6] = R.drawable.dice6;

        Imagedice.setImageResource(intSource[myRandom]);
        
    }

    private void changeplay(int intdice) {

        Log.d("test", "ค่าที่รับได้ = " + intdice);

        switch (intdice) {
            case 1:
                Imagedice.setImageResource(R.drawable.dice1);
                break;
            case 2:
                Imagedice.setImageResource(R.drawable.dice2);
                break;
            case 3:
                Imagedice.setImageResource(R.drawable.dice3);
                break;
            case 4:
                Imagedice.setImageResource(R.drawable.dice4);
                break;
            case 5:
                Imagedice.setImageResource(R.drawable.dice5);
                break;
            case 6:
                Imagedice.setImageResource(R.drawable.dice6);
                break;
        }// switch
        
    }// changplay
}
