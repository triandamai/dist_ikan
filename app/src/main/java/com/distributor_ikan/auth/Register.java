package com.distributor_ikan.auth;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.distributor_ikan.Helper.Bantuan;
import com.distributor_ikan.R;
import com.distributor_ikan.pembeli.dashboard_pembeli;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Register extends AppCompatActivity implements View.OnClickListener {
    //TODO:: halaman register
    EditText hp, password, ulangpassword, et_noHp, et_verifikasi;
    TextView tv_keterangan, tv_nomerSalah;
    Button register;
    FirebaseAuth firebaseAuth;
    Context context = Register.this;
    String codeSent;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        inisiasi_variabel();
        register.setOnClickListener(this);
        tv_nomerSalah.setOnClickListener(this);

    }

    //TODO ::: onclick
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                if (register.getText().toString()
                        .equalsIgnoreCase(getString(R.string.kirim_kode))) {
                    //TODO : cek nomer kosong atau < 10
                    if (et_noHp.getText().toString().isEmpty() || et_noHp.getText().toString().length() < 10) {
                        et_noHp.setError(getString(R.string.nomer_salah));
                        et_noHp.requestFocus();
                    } else {
                        //TODO : kirim kode OTP
                        kirimKodeOTP();
                        tv_keterangan.setText(getString(R.string.masukan_kode_verifikasi));
                        et_noHp.setVisibility(View.GONE);
                        et_verifikasi.setVisibility(View.VISIBLE);
                        tv_nomerSalah.setVisibility(View.VISIBLE);
                        register.setText(getString(R.string.register_login));
                    }
                } else {
                    //TODO : fungsi auth ke firebase
                    verifikasiDanLogin();
                }
                break;

            case R.id.tv_nomerSalah:
                tv_keterangan.setText(getString(R.string.masukan_nomer_hp));
                et_noHp.setVisibility(View.VISIBLE);
                et_verifikasi.setText("");
                et_verifikasi.setVisibility(View.GONE);
                tv_nomerSalah.setVisibility(View.GONE);
                register.setText(getString(R.string.kirim_kode));
                break;
        }
    }

    //TODO ::: methods
    private void inisiasi_variabel() {
        register = findViewById(R.id.btn_register);
        hp = findViewById(R.id.et_hp);
        password = findViewById(R.id.et_password);
        ulangpassword = findViewById(R.id.et_ulangpassword);
        et_noHp = findViewById(R.id.et_noHp);
        et_verifikasi = findViewById(R.id.et_verifikasi);
        tv_nomerSalah = findViewById(R.id.tv_nomerSalah);
        tv_keterangan = findViewById(R.id.tv_keterangan);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.setLanguageCode("id");

    }

    //TODO : method kirim kode OTP
    private void kirimKodeOTP() {
        String phoneNumber = "+62" + et_noHp.getText().toString();
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,        // Phone number to verify
                60,              // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,        // Activity (for callback binding)
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

                    }

                    @Override
                    public void onVerificationFailed(FirebaseException e) {
                        new Bantuan().alertDialogDebugging(context, "VerificationFailed : " + e.getMessage());
                    }

                    @Override
                    public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        codeSent = s;
                        new Bantuan().toastShort(context, "Kode Terkirim !");
                    }

                    @Override
                    public void onCodeAutoRetrievalTimeOut(String s) {
                        super.onCodeAutoRetrievalTimeOut(s);
                    }
                });        // OnVerificationStateChangedCallbacks
    }

    //TODO : verifikasi
    private void verifikasiDanLogin() {
        String codeVerifikasi = et_verifikasi.getText().toString();
        if (et_verifikasi.getText().toString().isEmpty()) {
            et_verifikasi.setError("Kode Verifikasi Belum Diisi !");
        } else {
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeSent, codeVerifikasi);
            prosesLogin(credential);
        }
    }

    //TODO : Proses Login
    private void prosesLogin(PhoneAuthCredential credential) {

        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            new Bantuan().toastLong(context, "LOGIN BERHASIL");

                            startActivity(new Intent(Register.this,dashboard_pembeli.class));
                            finish();
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                new Bantuan().toastLong(context, "KODE VERIFIKASI SALAH !");
                            }
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        new Bantuan().alertDialogDebugging(context, e.getMessage());
                    }
                });
    }
}
