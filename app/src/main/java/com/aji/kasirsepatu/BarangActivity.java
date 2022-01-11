package com.aji.kasirsepatu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BarangActivity extends AppCompatActivity {
    FloatingActionButton tambah;
    AdapterSepatu adapterSepatu;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    ArrayList<ModelSepatu> listSepatu;
    RecyclerView rev;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang);

        tambah = findViewById(R.id.btnTambah);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BarangActivity.this, tambahActivity.class));

            }
        });
        rev = findViewById(R.id.rev);
        RecyclerView.LayoutManager mLayout = new LinearLayoutManager(this);
        rev.setLayoutManager(mLayout);
        rev.setItemAnimator(new DefaultItemAnimator());

        tampilData();

    }

    private void tampilData() {
        database.child("SEPATU").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listSepatu = new ArrayList<>();
                for (DataSnapshot item : snapshot.getChildren()){
                    ModelSepatu spt = item.getValue(ModelSepatu.class);
                    spt.setKey(item.getKey());
                    listSepatu.add(spt);
                }
                adapterSepatu = new AdapterSepatu(listSepatu, BarangActivity.this);
                rev.setAdapter(adapterSepatu);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}