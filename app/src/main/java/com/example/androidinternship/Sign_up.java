package com.example.androidinternship;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Sign_up extends AppCompatActivity {
    private EditText username, name, email, contact, password, confirmpassword;
    private Button signup;
    private ImageView passwordHide, passwordShow, confirmPasswordHide, confirmPasswordShow;
    private RadioGroup gender;

    Spinner city;
    String[] cityArray = {"Vadodara", "Rajkot", "Surat", "Ahmedabad"};


    private static final String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initializeViews();

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                new CommonMethod(Sign_up.this, radioButton.getText().toString());
            }
        });
        city=findViewById(R.id.signup_city);
        ArrayAdapter adapter= new ArrayAdapter(Sign_up.this, android.R.layout.simple_list_item_checked,cityArray);
        city.setAdapter(adapter);


        setupPasswordToggle(password, passwordShow, passwordHide);
        setupPasswordToggle(confirmpassword, confirmPasswordShow, confirmPasswordHide);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndSignUp();
            }
        });
    }


    private void initializeViews() {
        username = findViewById(R.id.signup_username);
        name = findViewById(R.id.signup_name);
        email = findViewById(R.id.signup_Email);
        contact = findViewById(R.id.signup_Contact);
        password = findViewById(R.id.signup_password);
        confirmpassword = findViewById(R.id.signup_confirmpassword);

        passwordHide = findViewById(R.id.signup_password_hidden);
        passwordShow = findViewById(R.id.signup_password_show);
        confirmPasswordShow = findViewById(R.id.signup_confirmpassword_show);
        confirmPasswordHide = findViewById(R.id.signup_confirmpassword_hidden);

        gender = findViewById(R.id.signup_gender);

        signup = findViewById(R.id.main_button);
    }

    private void setupPasswordToggle(final EditText passwordField, ImageView showView, ImageView hideView) {
        showView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showView.setVisibility(View.GONE);
                hideView.setVisibility(View.VISIBLE);
                passwordField.setTransformationMethod(null);
            }
        });

        hideView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showView.setVisibility(View.VISIBLE);
                hideView.setVisibility(View.GONE);
                passwordField.setTransformationMethod(new PasswordTransformationMethod());
            }
        });
    }

    private void validateAndSignUp() {
        if (username.getText().toString().trim().isEmpty()) {
            username.setError("Username required");
        } else if (name.getText().toString().trim().isEmpty()) {
            name.setError("Name required");
        } else if (email.getText().toString().trim().isEmpty()) {
            email.setError("Email required");
        } else if (!email.getText().toString().trim().matches(EMAIL_PATTERN)) {
            email.setError("Valid email required");
        } else if (contact.getText().toString().trim().isEmpty()) {
            contact.setError("Contact required");
        } else if (password.getText().toString().trim().isEmpty()) {
            password.setError("Password required");
        } else if (password.getText().toString().trim().length() < 6) {
            password.setError("Min 6 char password required");
        } else if (confirmpassword.getText().toString().trim().isEmpty()) {
            confirmpassword.setError("Confirm password required");
        } else if (confirmpassword.getText().toString().trim().length() < 6) {
            confirmpassword.setError("Min 6 char confirm password required");
        } else if (!password.getText().toString().equals(confirmpassword.getText().toString())) {
            confirmpassword.setError("Passwords do not match");
        } else if (gender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(Sign_up.this, "Please select a gender", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Sign_up.this, "Sign up successful", Toast.LENGTH_SHORT).show();
        }
    }
}
