package com.distributor_ikan.pembeli;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.distributor_ikan.R;
import com.distributor_ikan.model.list_ikan;

import java.util.List;

public class adapter_list_ikan extends RecyclerView.Adapter<adapter_list_ikan.MyViewHolder> {
    //TODO:: adapter list ikan
    private List<list_ikan> list_ikanList;
    Context context;
    public adapter_list_ikan(List<list_ikan> lemparan, Context context){
        this.list_ikanList = lemparan;
        this.context = context;
    }

    @Override
    public adapter_list_ikan.MyViewHolder
    onCreateViewHolder(ViewGroup viewGroup,
                       int i) {
        //TODO : ngeset layout list ikan
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list_ikan,viewGroup,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final adapter_list_ikan.MyViewHolder pengendali,
                                 int i) {
    //TODO : ngeset isi komponen adapter list ikan
        list_ikan ikan = list_ikanList.get(i);
        pengendali.penjual.setText(ikan.getPenjual());
        pengendali.stok.setText(ikan.getStok());
        pengendali.harga.setText(ikan.getHarga());
    //TODO : di klik item ikan
        pengendali.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context.getApplicationContext(),pemesanan.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_ikanList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView penjual,stok,harga;
        ImageView imageView;
        LinearLayout parent;

        public MyViewHolder(View view){
          super(view);
        //TODO : inisiasi variabel (adapter list ikan)
            penjual = (TextView) view.findViewById(R.id.tv_penjual);
            stok = (TextView) view.findViewById(R.id.tv_stock);
            harga =(TextView) view.findViewById(R.id.tv_harga);
            imageView = (ImageView) view.findViewById(R.id.iv_fotoikan);
            parent = (LinearLayout) view.findViewById(R.id.linearlayout);
        }
    }

}
