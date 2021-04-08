package com.elevenzon.MarkUTApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

   TextView forgotpwdproceed;
   EditText name, email, phone, password;
    boolean isNameValid, isEmailValid, isPhoneValid, isPasswordValid;
    TextInputLayout nameError, emailError, phoneError, passError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        email = (EditText) findViewById(R.id.email);
        emailError = (TextInputLayout) findViewById(R.id.emailError);
        //forgotpwdproceed = (Button) findViewById(R.id.forgotpwdproceed);
        forgotpwdproceed = (TextView) findViewById(R.id.forgotpwdproceed);


//        forgotpwdproceed.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SetValidation();
//            }
//        });

        forgotpwdproceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to ValidOTPActivity
                Intent intent = new Intent(getApplicationContext(), ValidateOtp.class);
                startActivity(intent);
            }
        });



    }

    public void SetValidation() {


        // Check for a valid email address.
        if (email.getText().toString().isEmpty()) {
            emailError.setError(getResources().getString(R.string.email_error));
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
            emailError.setError(getResources().getString(R.string.error_invalid_email));
            isEmailValid = false;
        } else {
            isEmailValid = true;
            emailError.setErrorEnabled(false);
        }

        // Check for a valid phone number.
        if (phone.getText().toString().isEmpty()) {
            phoneError.setError(getResources().getString(R.string.phone_error));
            isPhoneValid = false;
        } else {
            isPhoneValid = true;
            phoneError.setErrorEnabled(false);
        }


        if (isEmailValid) {
            Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();
        }
    }
}