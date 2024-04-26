package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView heading=findViewById(R.id.heading);
        EditText name_entry=findViewById(R.id.nameentry);
        Button submit=findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=name_entry.getText().toString();
                Intent i=new Intent(getApplicationContext()
                        ,SecondMainActivity.class
                );

                i.putExtra("name",username);
                startActivity(i);
            }
        });
    }
}