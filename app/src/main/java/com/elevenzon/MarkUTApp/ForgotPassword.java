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

public class ForgotPassword extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
    }

    public void proceedToNextActivity(View view)
    {
        if(!isEmailCorrect())
        {
            return;
        }

        startActivity(new Intent(ForgotPassword.this, ValidateSecurityQuestions.class));
    }

    public boolean isEmailCorrect()
    {
        boolean isEmailValid = false;

        EditText email = (EditText) findViewById(R.id.email);
        TextInputLayout emailError = (TextInputLayout) findViewById(R.id.emailError);

        // Check for a valid email address.
        if (email.getText().toString().isEmpty())
        {
            emailError.setError(getResources().getString(R.string.email_error));
        }

        else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches())
        {
            emailError.setError(getResources().getString(R.string.error_invalid_email));
        }

        else
        {
            isEmailValid = true;
            emailError.setErrorEnabled(false);
        }

        return isEmailValid;
    }
}