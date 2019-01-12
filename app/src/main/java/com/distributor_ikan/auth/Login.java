package com.distributor_ikan.auth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.distributor_ikan.R;

public class Login extends AppCompatActivity implements View.OnClickListener {
    //TODO:: halaman login
    Button login;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inisiasi_variabel();
        login.setOnClickListener(this);

    }
    //TODO ::: onclick
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                break;
        }
    }
    //TODO ::: methods
    private void inisiasi_variabel() {
        login = findViewById(R.id.btn_login);
        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
    }
}
