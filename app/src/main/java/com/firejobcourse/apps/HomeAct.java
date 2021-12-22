package com.firejobcourse.apps;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Context;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;
import java.util.concurrent.locks.Lock;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;



public class HomeAct extends AppCompatActivity{
    TextView nik,textView2;
    ImageView imageView5;
    DatabaseReference reference;

    String USERNAME_KEY= "usernamekey";
    String username_key="";
    String username_key_new="";

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getUsernameLocal();

        textView2 = findViewById(R.id.textView2);
        nik = findViewById(R.id.nik);
        imageView5 = findViewById(R.id.imageView5);

        reference = FirebaseDatabase.getInstance().getReference().child("Users").child(username_key_new);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                textView2.setText(snapshot.child("username").getValue().toString());
                nik.setText(snapshot.child("nik").getValue().toString());
                Picasso.with(HomeAct.this).load(snapshot.child("url_photo_profile").getValue().toString()).centerCrop().fit().into(imageView5);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void getUsernameLocal(){
        SharedPreferences sharedPreferences=getSharedPreferences(USERNAME_KEY,MODE_PRIVATE);
        username_key_new=sharedPreferences.getString(username_key,"");
    }
}
