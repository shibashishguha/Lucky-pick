package com.example.luckynumber;

import static android.content.Intent.ACTION_SEND;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SecondMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);

        TextView display_text=findViewById(R.id.displaytext);
        TextView display_number=findViewById(R.id.displaynumber);
        Button share=findViewById(R.id.share);

        Intent i=getIntent();
        String name=i.getStringExtra("name");
        int number=RandomNumber();
        display_number.setText(""+number);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(name,number);
            }
        });
    }

    public int RandomNumber()
    {
        Random num=new Random();
        int upperlimit=100;
        int number=num.nextInt(upperlimit);
        return number;
    }

    public void shareData(String name,int number)
    {
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,name+"just got ucky");
        i.putExtra(Intent.EXTRA_SUBJECT,"His lucky number is" +number);
        startActivity(Intent.createChooser(i,"Choose a platform"));
    }
}