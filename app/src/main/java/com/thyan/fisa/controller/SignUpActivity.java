package com.thyan.fisa.controller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.thyan.fisa.Checkinform.CheckEmptyModule;
import com.thyan.fisa.Checkinform.CheckRegexModule;
import com.thyan.fisa.R;
import com.thyan.fisa.entities.TaiKhoan;
import com.thyan.fisa.others.ShowHidePasswordModule;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private  Button buttonSignUp;
    private ImageButton imageButtonCapture, imageButtonChoose, buttonReturn;
    private ImageView imageViewPicture;
    private static final int CHOOSEN = 1;
    private static final int CAPTURE = 2;
    private Uri avatar;

    //Firebase
    private FirebaseAuth mAuth;
    private DatabaseReference mdata;
    FirebaseStorage storage = FirebaseStorage.getInstance("gs://fisa-financialsavings.appspot.com");
    final StorageReference storageRef = storage.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_signup);
        mAuth = FirebaseAuth.getInstance();
        mdata= FirebaseDatabase.getInstance().getReference();
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");
        String userId = mDatabase.push().getKey();
        TaiKhoan user = new TaiKhoan("Ravi Tamada", "ravi@androidhive.info");
        mDatabase.child(userId).setValue(user);
        init();
        eventReturn();
        eventOpenGallery();
        eventOpenCapture();
        eventSignUp();
        eventShowPassword();
        DatabaseReference databaseArtists;

    }
    private void eventOpenCapture() {
        imageButtonCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cInt = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cInt, CAPTURE);
            }
        });
    }

    private void eventOpenGallery() {
        imageButtonChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickPhoto.setType("image/*");
                pickPhoto.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(pickPhoto, CHOOSEN);
            }
        });
    }

    private void eventReturn() {
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    private void eventSignUp() {
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
    }

    private void eventShowPassword() {
        ShowHidePasswordModule.eventShowHidePassword(editTextPassword);
    }

    private void signup(){
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        if(CheckEmptyModule.isEmpty(email, password, password)) {
            if(CheckRegexModule.isEmail(email)) {
                if(CheckRegexModule.isPassword(password)) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            uploadImage();
                            Toast.makeText(getApplicationContext(), R.string.success_signup, Toast.LENGTH_SHORT).show();
                            TaiKhoan tk=new TaiKhoan(editTextEmail.getText().toString(),editTextPassword.getText().toString());
                            mdata.child("Taikhoan").push().setValue(tk, new DatabaseReference.CompletionListener() {
                                @Override
                                public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                                    if(databaseError.equals("")){

                                        Toast.makeText(SignUpActivity.this,"save succes",Toast.LENGTH_LONG).show();
                                    }else{
                                        Toast.makeText(SignUpActivity.this,"error",Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(getApplicationContext(), R.string.unsuccess_signup, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                } else Toast.makeText(getApplicationContext(), R.string.regex_password, Toast.LENGTH_SHORT).show();
            } else Toast.makeText(getApplicationContext(), R.string.regex_email, Toast.LENGTH_SHORT).show();
        } else Toast.makeText(getApplicationContext(), R.string.empty_info, Toast.LENGTH_SHORT).show();
    }
    private void uploadImage() {

        Calendar calendar=Calendar.getInstance();
        StorageReference mountainsRef = storageRef.child("image"+calendar.getTimeInMillis()+".jpg");

        imageViewPicture.setDrawingCacheEnabled(true);
        imageViewPicture.buildDrawingCache();
        Bitmap bitmap = ((BitmapDrawable) imageViewPicture.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] data = baos.toByteArray();

        UploadTask uploadTask = mountainsRef.putBytes(data);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(SignUpActivity.this,"error!!!",Toast.LENGTH_LONG).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Uri downloaduri=taskSnapshot.getUploadSessionUri();

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CHOOSEN && resultCode == RESULT_OK && data != null && data.getData() != null) {
            try {
                avatar = data.getData();
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), avatar);
                Bitmap bitmap2 = Bitmap.createScaledBitmap(bitmap,600, 600, true);
                imageViewPicture.setImageBitmap(bitmap2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(requestCode == CAPTURE && resultCode == RESULT_OK && data != null) {
            try {
                avatar = data.getData();
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                Bitmap bitmap2 = Bitmap.createScaledBitmap(bitmap,600, 600, true);
                imageViewPicture.setImageBitmap(bitmap2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void init() {
        editTextEmail = findViewById(R.id.editTextEmail_signup);
        editTextPassword = findViewById(R.id.editTextPassword_signup);
        buttonSignUp = findViewById(R.id.buttonSignUp_signup);
        imageButtonCapture = findViewById(R.id.imageButtonCapture_signup);
        imageButtonChoose = findViewById(R.id.imageButtonChoose_signup);
        imageViewPicture = findViewById(R.id.imageViewPicture_signup);
        buttonReturn = findViewById(R.id.buttonReturn_signup);
        getSupportActionBar().hide();
    }
}