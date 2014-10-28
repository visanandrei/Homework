package com.example.login;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class Login extends Activity {
	String us;
	String passw;
	EditText username;
	EditText password;
	Button login;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		readFile("user.txt",us);
		readFile("pass.txt",passw);
		
		
		username=(EditText) findViewById(R.id.editText1);
		
		password=(EditText) findViewById(R.id.editText2);
		
		login=(Button) findViewById(R.id.button1);
		
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String user= username.getText().toString();
				String pass= password.getText().toString();
				
				
				if(user.contentEquals("a")&& pass.contentEquals("b")){
					Intent intent = new Intent(Login.this, Thepage.class);
					startActivity(intent);
				}
			}
		});
	}

	public String readFile(String fileName, String a) {
		try {
			InputStream in = openFileInput(fileName);
			if (in != null) {
				InputStreamReader reader = new InputStreamReader(in);
				BufferedReader buffreader = new BufferedReader(reader);

				StringBuilder builder = new StringBuilder();
				String str;
				while ((str = buffreader.readLine()) != null) {
					builder.append(str + "\n");

					a = builder.toString();
				}
				in.close();

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;

	}
	public void writeFile(String fileName, String x) {

		try {
			OutputStreamWriter out = new OutputStreamWriter(openFileOutput(
					fileName, 0));
			out.write(x + "\n");

			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
