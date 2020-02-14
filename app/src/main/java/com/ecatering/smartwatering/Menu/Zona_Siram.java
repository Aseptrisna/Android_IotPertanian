package com.ecatering.smartwatering.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.ecatering.smartwatering.R;

public class Zona_Siram extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona__siram);
    }


    public void onBackPressed() {
        super.onBackPressed();
        goBackMenu();
    }

    public void goBackMenu(){
        startActivity(new Intent(this, Sign_In.class));
        finish();
    }
}
