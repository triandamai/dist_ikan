package com.distributor_ikan.pembeli;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.distributor_ikan.R;

public class pemesanan extends AppCompatActivity implements View.OnClickListener {
Button lanjut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemesanan);
        lanjut = findViewById(R.id.btn_lanjutpembayaran);
        lanjut.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_lanjutpembayaran:

                startActivity(new Intent(pemesanan.this,pembayaran.class));
                break;

        }
    }
}
