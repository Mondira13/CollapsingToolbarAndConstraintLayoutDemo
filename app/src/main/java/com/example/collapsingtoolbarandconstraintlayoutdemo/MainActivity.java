package com.example.collapsingtoolbarandconstraintlayoutdemo;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    AppBarLayout appBarLayout;
    Toolbar toolbar;
    CollapsingToolbarLayout c;
    EditText editTextTop;
    EditText editTextBottom;
    TextView name;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appBarLayout = (AppBarLayout) findViewById(R.id.appBar);
        toolbar = (Toolbar) findViewById(R.id.toolbarId);
        c = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        editTextTop = (EditText) findViewById(R.id.editText2);
        editTextBottom = (EditText) findViewById(R.id.editText3);
        name = (TextView) findViewById(R.id.name);
        next = (Button) findViewById(R.id.next);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        c.setTitleEnabled(false);


        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {

            boolean isVisible = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    toolbar.setTitle("");
                    editTextTop.setVisibility(View.VISIBLE);
                    name.setVisibility(View.GONE);
                    editTextBottom.setVisibility(View.GONE);
                    isVisible = true;
                } else if (isVisible) {
//                    toolbar.setTitle("Mondira");
                    editTextTop.setVisibility(View.GONE);
                    name.setVisibility(View.VISIBLE);
                    editTextBottom.setVisibility(View.VISIBLE);
                    isVisible = false;
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });


    }
}
