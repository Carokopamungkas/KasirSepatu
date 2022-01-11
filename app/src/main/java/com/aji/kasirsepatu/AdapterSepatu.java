package com.aji.kasirsepatu;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AdapterSepatu extends RecyclerView.Adapter<AdapterSepatu.MyViewHolder> {
    private List<ModelSepatu> mList;
    private Activity activity;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();


    public AdapterSepatu(List<ModelSepatu>mList, Activity activity){
        this.mList = mList;
        this.activity = activity;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.layout_item, parent, false);
        return new MyViewHolder(viewItem);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final ModelSepatu data = mList.get(position);
        holder.txNama.setText("Merk Sepatu : " + data.getNama());
        holder.txMerk.setText("Harga : " + data.getMerk());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txNama, txMerk;
        CardView cardHasil;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txNama = itemView.findViewById(R.id.txNama);
            txMerk = itemView.findViewById(R.id.txMerk);
            cardHasil = itemView.findViewById(R.id.cardHasil);

        }
    }
}
