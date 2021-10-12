package com.example.befit;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Register_Befit extends AppCompatActivity {
    private EditText mName;
    private EditText mMail;
    private EditText mpw;
    private EditText mHeight;
    private EditText mWeight;
    private Button mButtons;
    private boolean isEmailValid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //getting the id's


        mMail = findViewById(R.id.email_id);
        mpw = findViewById(R.id.password_id);
        mHeight = findViewById(R.id.height_id);
        mWeight = findViewById(R.id.weight_id);
        mButtons = findViewById(R.id.register_btn);


        mButtons.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

//                if(mName.getText().toString().isEmpty()){
//                    mName.setError("Username is Required");
//                    mName.requestFocus();
//                }
                // Check for a valid email address.
                if (mMail.getText().toString().isEmpty()) {
                    mMail.setError(getResources().getString(R.string.email_error));
                    isEmailValid = false;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(mMail.getText().toString()).matches()) {
                    mMail.setError(getResources().getString(R.string.error_invalid_email));
                    isEmailValid = false;
                } else  {
                    isEmailValid = true;
                }
                if(mpw.getText().toString().length()==0){
                    mpw.setError("Password not entered");
                    mpw.requestFocus();}
                else{

                }
                Intent intent = new Intent( getApplicationContext(),Login_Befit.class);
                startActivity(intent);
            }

        });





    }
}





