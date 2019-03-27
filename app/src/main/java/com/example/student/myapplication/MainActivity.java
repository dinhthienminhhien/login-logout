package com.example.student.myapplication;


import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class MainActivity extends AppCompatActivity {

    Button btnDN;
    Button btnNK;
    EditText edtten;
    EditText edtPass;
    private FirebaseAuth mAuth;

    FirebaseAuth mAuthencation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        mAuthencation = FirebaseAuth.getInstance();

        btnNK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DangKy();
            }
        });
        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DangNhap();
            }
        });
    }

    private void DangNhap(){
        String email = edtten.getText().toString();
        String password = edtPass.getText().toString();
        mAuthencation.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                           Toast.makeText(MainActivity.this,"Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this,"Đăng nhập KHÔNG thành công", Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }
    private void Anhxa(){
        btnDN = (Button) findViewById(R.id.btn_DN);
        btnNK = (Button) findViewById(R.id.btn_DK);
        edtten = (EditText) findViewById(R.id.edt_ten);
        edtPass = (EditText) findViewById(R.id.edt_Pass);
    }



    private void DangKy(){
        String email = edtten.getText().toString();
        String password = edtPass.getText().toString();
        mAuthencation.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"Đăng kí thành công",Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(MainActivity.this,"Lỗi !!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}
