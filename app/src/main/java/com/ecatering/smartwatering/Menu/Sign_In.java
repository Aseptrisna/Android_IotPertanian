package com.ecatering.smartwatering.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.ecatering.smartwatering.MainActivity;
import com.ecatering.smartwatering.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Sign_In extends AppCompatActivity {
    @BindView(R.id.singin)
    Button Login;
    @BindView(R.id.btRegister)
    ImageButton Register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__in);
        ButterKnife.bind(this);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Sign_In.this, DashBoard.class);
                startActivity(i);
                finish();

            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Sign_In.this, Register.class);
                startActivity(i);
                finish();
            }
        });


    }






}
