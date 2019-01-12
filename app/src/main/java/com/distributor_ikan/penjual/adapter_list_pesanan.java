package com.distributor_ikan.penjual;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.distributor_ikan.R;
import com.distributor_ikan.model.list_pesanan;

import java.util.List;

public class adapter_list_pesanan extends RecyclerView.Adapter<adapter_list_pesanan.MyViewHolder> {
    //TODO:: adapter list pesanan
    private List<list_pesanan> list_pesananList;
    Context context;

    public adapter_list_pesanan(List<list_pesanan> lemparan, Context context) {
        this.list_pesananList = lemparan;
        this.context = context;
    }

    @Override
    public adapter_list_pesanan.MyViewHolder
    onCreateViewHolder(ViewGroup viewGroup,
                       int i) {
        //TODO : ngeset layout adapter list pesanan
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list_pesanan,viewGroup,false);

        return new adapter_list_pesanan.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder( adapter_list_pesanan.MyViewHolder myViewHolder, int i) {
        //TODO : ngeset isi komponen adapter list pesanan

        //TODO : di klik item pesanan
    }

    @Override
    public int getItemCount() {
        return list_pesananList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        MyViewHolder(View view) {
            super(view);
            //TODO : inisissi variabel (adapter list pesanan)
        }
    }
}
