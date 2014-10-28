package com.example.login;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Settings extends Activity {
	Button back;
	
	TextView tvPassword;
	
	EditText etPassword;
	
	Button bPass;
	
	
	String u;
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		readFile("pass.txt",u);
		tvPassword.setText(u);
		
		super.onResume();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		
		back=(Button) findViewById(R.id.bBack);
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Settings.this, Thepage.class);
				startActivity(intent);
			}
		});
		
		tvPassword=(TextView) findViewById(R.id.tvPass);
		readFile("pass.txt",u);
		tvPassword.setText(u);
				
		etPassword=(EditText) findViewById(R.id.etPassword);
		
				
		bPass=(Button) findViewById(R.id.bPass);
		
		bPass.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			String a=etPassword.getText().toString();
			writeFile("pass.txt",a);
			tvPassword.setText(a);
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
