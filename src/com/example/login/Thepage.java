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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Thepage extends Activity {
	
	Button homework;
	Button settings;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thepage);
		
		homework=(Button) findViewById(R.id.bHome);
		
		homework.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(Thepage.this, Homework.class);
				startActivity(intent);
			}
		});
		
		settings=(Button) findViewById(R.id.bSettings);
		
		settings.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Thepage.this, Settings.class);
				startActivity(intent);
				
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
