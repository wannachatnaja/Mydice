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
    private TextView showTextView;


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
        showTextView = (TextView) findViewById(R.id.txtshow);

    }

    private void myRandomPicture(int intUser) {
        int myRandom = 0;
        Random objRandom = new Random();
        myRandom = objRandom.nextInt(6) + 1;
        Log.d("Ran", "myRandom ==>" + myRandom);

        overChange(myRandom);


    }// MRP

    private void overChange(int myRandom) {
        int intSound = R.raw.effect_btn_long;
        int[] intSource = new int[7];
        intSource[0] = 0;
        intSource[1] = R.drawable.dice1;
        intSource[2] = R.drawable.dice2;
        intSource[3] = R.drawable.dice3;
        intSource[4] = R.drawable.dice4;
        intSource[5] = R.drawable.dice5;
        intSource[6] = R.drawable.dice6;
        
        
        Imagedice.setImageResource(intSource[myRandom]);
        MediaPlayer iMediaPlayer = MediaPlayer.create(getBaseContext(), intSound);
        iMediaPlayer.start();
    }

    private void changeplay(int intdice) {

        Log.d("test", "ค่าที่รับได้ = " + intdice);
        int intSound = R.raw.effect_btn_long;
        String str1 = "ได้แต้ม หนึ่ง";
        String str2 = "ได้แต้ม สอง";
        String str3 = "ได้แต้ม สาม";
        String str4 = "ได้แต้ม สี่";
        String str5 = "ได้แต้ม ห้า";
        String str6 = "ได้แต้ม หก";
        String strshow = null;

        switch (intdice) {
            case 1:
                Imagedice.setImageResource(R.drawable.dice1);
                strshow = str1;
                intSound = R.raw.effect_btn_long;
                break;
            case 2:
                Imagedice.setImageResource(R.drawable.dice2);
                strshow = str2;
                intSound = R.raw.effect_btn_long;
                break;
            case 3:
                Imagedice.setImageResource(R.drawable.dice3);
                strshow = str3;
                intSound = R.raw.effect_btn_long;
                break;
            case 4:
                Imagedice.setImageResource(R.drawable.dice4);
                strshow = str4;
                intSound = R.raw.effect_btn_long;
                break;
            case 5:
                Imagedice.setImageResource(R.drawable.dice5);
                strshow = str5;
                intSound = R.raw.effect_btn_long;
                break;
            case 6:
                Imagedice.setImageResource(R.drawable.dice6);
                strshow = str6;
                intSound = R.raw.effect_btn_long;
                break;
            
        }// switch
        showTextView.setText(strshow);
        MediaPlayer iMediaPlayer = MediaPlayer.create(getBaseContext(), intSound);
        iMediaPlayer.start();
    }// changplay
}
