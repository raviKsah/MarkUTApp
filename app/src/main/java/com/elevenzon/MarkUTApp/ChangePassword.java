package com.elevenzon.MarkUTApp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class ChangePassword extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change_password);
	}

	public void changePassword(View view)
	{
		if(!isPasswordCorrect())
		{
			return;
		}

		displayMessage("PASSWORD RESET", "Your password has successfully been reset.");
		startActivity(new Intent(ChangePassword.this, LoginActivity.class));
	}

	public boolean isPasswordCorrect()
	{
		boolean isPasswordValid = false;

		EditText passwordFirst = (EditText)findViewById(R.id.newPassword1);
		EditText passwordSecond = (EditText)findViewById(R.id.newPassword2);
		TextInputLayout pw1Err = (TextInputLayout)findViewById(R.id.pw1Error);
		TextInputLayout pw2Err = (TextInputLayout)findViewById(R.id.pw2Error);

		if (passwordFirst.getText().toString().isEmpty())
		{
			pw1Err.setError("Please enter a password.");
		}

		else if (passwordSecond.getText().toString().isEmpty())
		{
			pw2Err.setError("Please re-enter your password.");
		}

		else if (passwordFirst.getText().length() < 6)
		{
			pw1Err.setError("Please enter a minimum password of 6 characters.");
		}

		else if(!passwordFirst.getText().toString().equals(passwordSecond.getText().toString()))
		{
			pw2Err.setError("Your passwords do not match.");
		}

		else
		{
			isPasswordValid = true;
			pw1Err.setErrorEnabled(false);
			pw2Err.setErrorEnabled(false);
		}

		return isPasswordValid;
	}

	public void displayMessage(String title, String message)
	{
		AlertDialog alert = new AlertDialog.Builder(ChangePassword.this).create();
		alert.setTitle(title);
		alert.setMessage(message);
		alert.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
				new DialogInterface.OnClickListener()
				{
					public void onClick(DialogInterface dialog, int which)
					{
						dialog.dismiss();
					}
				});

		alert.show();
	}
}