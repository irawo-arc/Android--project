package com.example.befit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login_Befit extends AppCompatActivity {
    private EditText mEmail_one;
    private  EditText mPassword;
    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail_one = findViewById(R.id.login_mail);
        mPassword = findViewById(R.id.login_password);
        mButton = findViewById(R.id.login_btn);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetValidation();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }

        });
    }
        public void SetValidation() {
            // Check for a valid email address.
            boolean isEmailValid;
            if (mEmail_one.getText().toString().isEmpty()) {
               mEmail_one.setError(getResources().getString(R.string.email_error));
                isEmailValid = false;
            } else if (!Patterns.EMAIL_ADDRESS.matcher(mEmail_one.getText().toString()).matches()) {
                mEmail_one.setError(getResources().getString(R.string.error_invalid_email));
                isEmailValid = false;
            } else  {
                isEmailValid = true;
            }

            // Check for a valid password.
            boolean isPasswordValid;
            if (mPassword.getText().toString().isEmpty()) {
                mPassword.setError(getResources().getString(R.string.password_error));
                isPasswordValid = false;
            } else if (mPassword.getText().length() < 6) {
              mPassword.setError(getResources().getString(R.string.error_invalid_password));
                isPasswordValid = false;
            } else  {
                isPasswordValid = true;
            }

            if (isEmailValid && isPasswordValid) {
                Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();
            }

        }



    }


