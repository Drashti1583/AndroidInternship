package com.example.androidinternship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button login;
    TextView signup, forgotpassword;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    ImageView passwordHide, passwordshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.main_username);
        password = findViewById(R.id.main_password);
        login = findViewById(R.id.main_button);
        signup = findViewById(R.id.main_signup);
        forgotpassword = findViewById(R.id.main_forgot);
        forgotpassword.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        passwordHide = findViewById(R.id.password_hidden);
        passwordshow = findViewById(R.id.password_show);

        passwordshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordshow.setVisibility(View.GONE);
                passwordHide.setVisibility(View.VISIBLE);
                password.setTransformationMethod(null);
            }
        });

        passwordHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordshow.setVisibility(View.VISIBLE);
                passwordHide.setVisibility(View.GONE);
                password.setTransformationMethod(new PasswordTransformationMethod());
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().trim().isEmpty()) {
                    username.setError("Username Required");
                } else if (!username.getText().toString().trim().matches(emailPattern)) {
                    username.setError("Valid email is Required");
                } else if (password.getText().toString().trim().isEmpty()) {
                    password.setError("Password Required");
                } else if (password.getText().toString().trim().length() < 6) {
                    password.setError("Min 6 char password required");
                } else {
                    System.out.println("Login Successful");
                    Log.d("Response", "Login Successful");
                    //Toast.makeText(MainActivity.this, "Login success", Toast.LENGTH_SHORT).show();
                    //Snackbar.make(v, "Login Successful", Snackbar.LENGTH_LONG).show();
                    //Intent intent = new Intent(MainActivity.this,Dashboard_activity.class);
                    //startActivity(intent);
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Sign_up.class);
                startActivity(intent);
            }
        });
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Forgot_Password.class);
                startActivity(intent);
            }
        });

    }
}
