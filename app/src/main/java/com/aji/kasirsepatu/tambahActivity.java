package com.aji.kasirsepatu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.FileObserver;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class tambahActivity extends AppCompatActivity {
    EditText edNama, edMerk;
    Button btnSimpan;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        edNama = findViewById(R.id.edNama);
        edMerk = findViewById(R.id.edMerk);
        btnSimpan = findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNama = edNama.getText().toString();
                String getMerk = edMerk.getText().toString();

                if (getNama.isEmpty()) {
                    edNama.setError("Masukkan Nama Sepatu");
                }else if (getMerk.isEmpty()){
                    edMerk.setError("Merk Sepatu masih kosong");

                }else{
                    database.child("SEPATU").push().setValue(new ModelSepatu(getNama, getMerk)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(tambahActivity.this, "Data berhasil Disimpan", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(tambahActivity.this, BarangActivity.class));
                            finish();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(tambahActivity.this, "Gagal Menyimpan Data", Toast.LENGTH_SHORT).show();

                        }
                    });
                }



            }


        });
    }
}