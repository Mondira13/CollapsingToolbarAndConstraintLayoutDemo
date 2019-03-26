package com.example.collapsingtoolbarandconstraintlayoutdemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    TextView heading;
    TextView content;
    TextView placeName;
    Button search;
    private Random mRandom = new Random();
    private Shader shader;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mContext = getApplicationContext();

        heading = findViewById(R.id.heading);
        content = findViewById(R.id.content);
        placeName = findViewById(R.id.placeName);
        search = findViewById(R.id.search);

        try {
            shader = new LinearGradient(0,0,0,heading.getTextSize(), Color.BLUE,Color.GREEN,Shader.TileMode.CLAMP);
            heading.getPaint().setShader(shader);

            shader = new LinearGradient(0,0,0,heading.getTextSize(), Color.YELLOW, Color.MAGENTA,Shader.TileMode.CLAMP);
            placeName.getPaint().setShader(shader);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(Main2Activity.this,Main3Activity.class));
            }
        });

    }
}
