package com.ecatering.smartwatering.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ecatering.smartwatering.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashBoard extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.scan)
    Button ScanBarcode;
    @BindView(R.id.Dashboard)
    Button KeDashboard;
    @BindView(R.id.adddevice)
    ImageButton Tambahdevice;
    @BindView(R.id.id_device)
    TextView IDDevice;


    private IntentIntegrator intentIntegrator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        ButterKnife.bind(this);
         ScanBarcode.setOnClickListener(this);
         Tambahdevice.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i=new Intent(DashBoard.this,Zona_Siram.class);
                 startActivity(i);
                 finish();
                 Toast.makeText(DashBoard.this, "Berhasil Menambah Device", Toast.LENGTH_SHORT).show();
             }
         });
        KeDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DashBoard.this,Zona_Siram.class);
                startActivity(i);
                finish();
//                Toast.makeText(DashBoard.this, "Berhasil Menambah Device", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null){
            if (result.getContents() == null){
                Toast.makeText(this, "Hasil tidak ditemukan", Toast.LENGTH_SHORT).show();
            }else{
                // jika qrcode berisi data
                try{
                    // converting the data json
                    JSONObject object = new JSONObject(result.getContents());
                    // atur nilai ke textviews
                    IDDevice.setText(object.getString("IDDevice"));
//                    Toast.makeText(this, (object.getString("nama")), Toast.LENGTH_SHORT).show();

//                    textViewTinggi.setText(object.getString("tinggi"));
                }catch (JSONException e){
                    e.printStackTrace();
                    // jika format encoded tidak sesuai maka hasil
                    // ditampilkan ke toast
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_SHORT).show();
                }
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onClick(View v) {
        // inisialisasi IntentIntegrator(scanQR)
        intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.initiateScan();
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
