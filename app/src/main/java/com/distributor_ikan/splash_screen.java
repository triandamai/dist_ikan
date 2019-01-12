package com.distributor_ikan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.distributor_ikan.pembeli.dashboard_pembeli;
import com.distributor_ikan.penjual.dashboard_penjual;

public class splash_screen extends AppCompatActivity implements View.OnClickListener {
    Button pembeli,penjual;


    //TODO:: halaman loading
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splash_screen);
        penjual = findViewById(R.id.btn_penjual);
        pembeli = findViewById(R.id.btn_pembeli);


            penjual.setOnClickListener(this);
            pembeli.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_penjual:
                pindah_gan(true);
                break;
            case R.id.btn_pembeli:
                pindah_gan(false);
                break;
        }
    }
    public void pindah_gan(boolean iSpenjual) {
        if (iSpenjual) {
            startActivity(new Intent(splash_screen.this, dashboard_penjual.class));
            //startActivity(new Intent(splash_screen.this,Register.class));
        } else{
            startActivity(new Intent(splash_screen.this, dashboard_pembeli.class));
    }

}
}

