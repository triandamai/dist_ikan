package com.distributor_ikan.pembeli;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.distributor_ikan.R;

public class pembayaran extends AppCompatActivity implements View.OnClickListener {
    Button pilih;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);
        pilih = findViewById(R.id.pilih_foto);
        pilih.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.pilih_foto:
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/Pictures");
                intent.setType("*/*");

                startActivity(Intent.createChooser(intent, "Open Folder"));
            break;
        }

    }
}
