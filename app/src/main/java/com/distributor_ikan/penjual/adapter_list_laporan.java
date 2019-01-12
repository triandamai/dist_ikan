package com.distributor_ikan.penjual;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.distributor_ikan.R;
import com.distributor_ikan.model.list_pesanan;

import java.util.List;

public class adapter_list_laporan extends RecyclerView.Adapter<adapter_list_laporan.MyViewHolder> {

    //TODO:: adapter list laporan
    private List<adapter_list_laporan> list_laporanList;
    Context context;

    public adapter_list_laporan(List<adapter_list_laporan> list_laporanList, Context context) {
        this.list_laporanList = list_laporanList;
        this.context = context;
    }

    @NonNull
    @Override
    public adapter_list_laporan.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //TODO : ngeset layout adapter list laporan
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_laporan,viewGroup,false);


        //TODO : di klik item pesanan
        return new adapter_list_laporan.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_list_laporan.MyViewHolder myViewHolder, int i) {
        //TODO : ngeset isi komponen adapter list laporan

        //TODO : di klik item laporan
    }

    @Override
    public int getItemCount() {
        return list_laporanList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        MyViewHolder(View view){
            super(view);
            //TODO : inisissi variabel (adapter list laporan)
        }
    }
}
