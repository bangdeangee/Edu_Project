package com.jyp.jyp_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        Button levelButton =(Button) findViewById(R.id.levelButton);

        levelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent undersub1Intent = new Intent(SubActivity1.this, UnderSubActivity1.class);
                SubActivity1.this.startActivity(undersub1Intent);
            }
        });
    }
}
