package com.distributor_ikan.pembeli;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.distributor_ikan.R;
import com.distributor_ikan.model.list_ikan;

import java.util.ArrayList;
import java.util.List;


public class dashboard_pembeli extends AppCompatActivity implements View.OnClickListener {
    //TODO:: halaman awal pembeli
    RecyclerView recyclerView;
    adapter_list_ikan adapter_list_ikan;
    List<list_ikan> list_ikan = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_pembeli);
        inisiasi_variabel();
        adapter_list_ikan = new adapter_list_ikan(list_ikan,dashboard_pembeli.this);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter_list_ikan);

        //contoh buat datanya
        contoh();


    }
    //TODO ::: onclick
    @Override
    public void onClick(View v) {

    }
    //TODO ::: methods
    private void inisiasi_variabel() {
        recyclerView = findViewById(R.id.rv_ikan);
    }
    private void contoh(){
       for (int i = 1 ; i <= 10; i++){
        com.distributor_ikan.model.list_ikan ikan =
                new list_ikan("yoo","30","1000","ikan");
        list_ikan.add(ikan);
       }


        adapter_list_ikan.notifyDataSetChanged();
    }
    //TODO ::: external class ex. asynctask
}
