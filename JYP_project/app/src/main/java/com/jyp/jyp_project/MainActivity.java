package com.jyp.jyp_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button classButton = (Button) findViewById(R.id.classButton);

        classButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sub1Intent = new Intent(MainActivity.this, SubActivity1.class);
                MainActivity.this.startActivity(sub1Intent);
            }
        });
    }
}
