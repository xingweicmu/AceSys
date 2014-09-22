package com.pactera.acesys_android;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * Login interface
 * 
 * @author David.Wei
 * @version 1.0
 * created: 2013-8-19
 */
public class LoginActivity extends Activity {

	private Button bt_login, bt_exit;
	private EditText name_edit, pwd_edit;
	private String username, password;
	private DataTransmit dataTransmit;
	private static final String LOGIN_URL = "http://192.168.1.107:8080/acesys-group03/LoginServlet?a=login";
	private static final String ProductList_URL = "http://192.168.1.107:8080/acesys-group03/ProductServlet?operation=showAll";
	//private static final String LOGIN_URL = "http://172.17.200.90:8080/acesys-group03/LoginServlet?a=login";
	//private static final String ProductList_URL = "http://172.17.200.90:8080/acesys-group03/ProductServlet?operation=showAll";
	
	private static final String TAG = "LoginActivity";
	private static final int LOGIN_SUCCESS = 0;
	private static final int LOGIN_FAILURE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		bt_login = (Button) this.findViewById(R.id.login);
		bt_exit = (Button) this.findViewById(R.id.exit);
		name_edit = (EditText) this.findViewById(R.id.username);
		pwd_edit = (EditText) this.findViewById(R.id.password);
		bt_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				login();
			}

		});
		bt_exit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// exit the
				LoginActivity.this.finish();
			}

		});
	}

	/**
	 * Login to the system
	 */
	public void login() {
		this.loginCheck();
	}

	/**
	 * Create a warning dialog
	 */
	private void showDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(
				LoginActivity.this);
		builder.setMessage("µÇÂ¼Ê§°Ü£¬Çë´ÓÐÂµÇÂ¼£¡").setTitle("´íÎó")
				.setPositiveButton("È¡Ïû", new Dialog.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						dialog.dismiss();
					}
				}).create().show();

	}

	/**
	 * Check the user's login right
	 * 
	 * @return whether the user can login to use
	 */
	private boolean loginCheck() {

		username = name_edit.getText().toString();
		password = pwd_edit.getText().toString();
		try {
			username = URLEncoder.encode(username,"UTF-8");			
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}

		// create a thread to handle http connection
		Thread httpThread = new Thread(runnable);
		httpThread.start();

		return false;

	}

	/**
	 * Thread to handle http connection.
	 */
	Runnable runnable = new Runnable() {
		public void run() {
			try {
				URL url = new URL(LOGIN_URL + "&username=" + username
						+ "&password=" + password);
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection();
				connection.setConnectTimeout(3000);
				connection.setRequestMethod("GET");
				connection.setDoInput(true);
				connection.connect();
				Log.i(TAG, "new thread");
				int code = connection.getResponseCode();
				if (code == 200) {
					//Log.i(TAG, "You are in, now you can go on!");					
					// close the connection for login
					connection.disconnect();						
					// open a new connection for showing product list
					String jsonString = this.getJsonContent(ProductList_URL);					
					// build object from json
					ArrayList<Product> products = JsonTools.getProducts("products", jsonString);
					httpHandler.obtainMessage(LOGIN_SUCCESS,products).sendToTarget();
				} else {
					// this.stopMyThread();
					connection.disconnect();
					httpHandler.obtainMessage(LOGIN_FAILURE).sendToTarget();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * Open a connection and get json string for product list
		 * @param url_path 
		 * @return
		 */
		public String getJsonContent(String url_path){
			try{
				URL url = new URL(url_path);
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection();
				connection.setConnectTimeout(3000);
				connection.setRequestMethod("GET");
				connection.setDoInput(true);
				int code = connection.getResponseCode();
				if(code == 200){
					return ChangeInputStream(connection.getInputStream());
				}
			}catch(Exception e){
				
			}
			return "";
		}
		
		/**
		 * Get json string
		 * @param inputStream
		 * @return
		 */
		public String ChangeInputStream(InputStream inputStream){
			String jsonString = "";
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			int len = 0;
			byte[] data = new byte[1024];
			
			try {
				while((len = inputStream.read(data))!=-1){
					outputStream.write(data, 0, len);
				}
				jsonString = new String(outputStream.toByteArray());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			return jsonString;
		}
	};

	/**
	 * Handler after thread
	 */
	private Handler httpHandler = new Handler(){

		public void handleMessage(Message msg) {
			switch (msg.what) {
			case LOGIN_SUCCESS:				
				dataTransmit = (DataTransmit)getApplication();
				dataTransmit.setProducts((ArrayList<?>)msg.obj);
				//ArrayList<Product> list = (ArrayList<Product>)msg.obj;
				Intent intent = new Intent();
				intent.setClass(LoginActivity.this, ProductList.class);
				startActivity(intent);
				break;

			case LOGIN_FAILURE:
				showDialog();
				break;
			}
		}
	};

}
