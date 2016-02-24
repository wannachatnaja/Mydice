package kru.poompunk.wannachat.mydice;

import android.service.voice.VoiceInteractionSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView Imagedice;
    private Button btnback, btnrandom, btnnext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindWidget();

    }

    private void bindWidget() {

        Imagedice = (ImageView) findViewById(R.id.imgDice);
        btnback = (Button) findViewById(R.id.btnBack);
        btnrandom = (Button) findViewById(R.id.btnRandom);
        btnnext = (Button) findViewById(R.id.btnNext);


    }

}
