package com.pactera.acesys_android;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

/**
 * Product list interface
 * 
 * @author David.Wei
 * @version 1.0
 * created: 2013-8-19
 */
public class ProductList extends Activity {
	
	private ListView listView;  
	private Spinner mSpinner;
	private EditText editText;
	private Button searchButton;
    //String[] titles={"标题1","标题2","标题3","标题4"};  
    private String[] productNames;
    private String[] productPrices;
    private int[] pictureIds;
    //String[] texts={"文本内容A","文本内容B","文本内容C","文本内容D"};  
    //int[] resIds={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};  
	private DataTransmit dataTransmit;
	//private ArrayList<Product> products = new ArrayList<Product>();
	private static final String TAG = "ProductActivity";
	private static final String SEARCH_URL = "http://192.168.1.107:8080/acesys-group03/ProductServlet?operation=search";
	//private static final String SEARCH_URL = "http://172.17.200.90:8080/acesys-group03/ProductServlet?operation=search";
	private String searchKey;
	private String searchValue;
	private static final int SEARCH_SUCCESS = 0;
	private static final int SEARCH_FAILURE = 1;
	private ArrayList<Product> searchResults = new ArrayList<Product>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.product_list);
		dataTransmit = (DataTransmit)getApplication();
		Product p = (Product)(dataTransmit.getProducts().get(0));
		Log.i(TAG,p.getProductName());
//		String[] test = this.getProductNames();
//		String[] test2 = this.getProductPrices();
//		Log.i(TAG, test[0]);
//		Log.i(TAG, test2[4]);
		productNames = this.getProductNames();
		productPrices = this.getProductPrices();
		pictureIds = this.getPictureIds();
        listView=(ListView)this.findViewById(R.id.listView1);  
        listView.setAdapter(new ListViewAdapter(productNames,productPrices,pictureIds));  
        //listView.setAdapter(new ListViewAdapter(titles,texts,resIds)); 
        listView.setOnItemClickListener(itemListener);
        
        mSpinner = (Spinner) findViewById(R.id.spinner1);
        String[] mItems = getResources().getStringArray(R.array.spinnername);
        ArrayAdapter<String> _Adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, mItems);
        mSpinner.setAdapter(_Adapter);
        
        editText = (EditText) findViewById(R.id.search_text);
        searchButton = (Button) findViewById(R.id.search_bt);
        searchButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				searchKey = mSpinner.getSelectedItem().toString();				
				searchValue = editText.getText().toString();
				try {
					searchValue = URLEncoder.encode(searchValue,"UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				Log.i(TAG, searchKey + searchValue);
				if(searchKey.equals("商品编号")) 	searchKey = "product_number";
				if(searchKey.equals("商品名称")) 	searchKey = "productname";
				if(searchKey.equals("分类名称")) 	searchKey = "category_name";
				if(searchKey.equals("分类号")) 	searchKey = "categoryno";
				Log.i(TAG, searchKey + searchValue);
				search();
			}
		});
        
	}
	
	/**
	 * Search products
	 */
	public void search(){
		Thread httpThread = new Thread(runnable);
		httpThread.start();
	}
	
	/**
	 * Thread for handling searching products
	 */
	Runnable runnable = new Runnable() {

		@Override
		public void run() {
			try {

				URL url = new URL(SEARCH_URL + "&searchName=" + searchKey
						+ "&searchValue=" + searchValue);
//				Log.i(TAG, urlString);
//				URL url = new URL(urlString);				
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection();
				connection.setConnectTimeout(3000);
				connection.setRequestMethod("GET");
				connection.setDoInput(true);
				int code = connection.getResponseCode();
				if (code == 200) {
					
					String jsonString = ChangeInputStream(connection.getInputStream());
					ArrayList<Product> searchResults = JsonTools.getProducts("searchResults", jsonString);
					Log.i(TAG, searchKey);
					Log.i(TAG, "Search Done!");
					Log.i(TAG, jsonString);
					Log.i(TAG, searchResults.size()+"");
					// Go on
					searchHandler.obtainMessage(SEARCH_SUCCESS,searchResults).sendToTarget();
				} else {
					connection.disconnect();
					searchHandler.obtainMessage(SEARCH_FAILURE).sendToTarget();

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
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
	private Handler searchHandler = new Handler(){

		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SEARCH_SUCCESS:	
				searchResults = (ArrayList<Product>)msg.obj;
				//Log.i(TAG, searchResults.get(0).getProductName()+" THis works!");
				String[] searchResultNames = getSearchResultNames(searchResults);
				String[] searchResultPrices = getSearchResultPrices(searchResults);
				int[] searchResultPrictureIds = getSearchResultPictureIds(searchResults);
				//Log.i(TAG, searchResultNames[0]);
				//Log.i(TAG, searchResultPrices[0]);
				if(searchResults.size() != 0){
					listView.setAdapter(new ListViewAdapter(searchResultNames,searchResultPrices,searchResultPrictureIds));  
					listView.setOnItemClickListener(searchItemListener);
				}else{
					listView.setAdapter(new ListViewAdapter(productNames,productPrices,pictureIds));  
			        listView.setOnItemClickListener(itemListener);
			        Toast.makeText(getApplicationContext(), "没有您要搜索的商品",
			        	     Toast.LENGTH_SHORT).show();
				}				
				break;

			case SEARCH_FAILURE:
				//showDialog();
				Toast.makeText(getApplicationContext(), "network connection error",
		        	     Toast.LENGTH_SHORT).show();
				break;
			}
		}
	};
	
	/**
	 * Listener for search Item
	 */
	OnItemClickListener searchItemListener = new OnItemClickListener(){  	

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			
			Product p = (Product)(searchResults.get(arg2));
			String[] productDetails = new String[12];
			productDetails[0] = "编号："+p.getProductNumber();
			productDetails[1] = "名称："+p.getProductName();
			if(p.getCategory().getCategoryNo() == "001"){
				productDetails[2] = "分类："+"西药";
				productDetails[3] = "分类号："+"001";
			}else{
				productDetails[2] = "分类："+"中药";
				productDetails[3] = "分类号："+"002";
			}
			productDetails[4] = "MDL编号：" + p.getMDLNumber();
			productDetails[5] = "化学公式：" + p.getFormula();
			productDetails[6] = "价格：" + p.getNormalPrice()+"￥/g";
			productDetails[7] = "VIP价格：" + p.getVipPrice()+"￥/g";
			productDetails[8] = "实际库存：" + p.getRealStock()+"g";
			productDetails[9] = "重量：" + p.getWeight()+"g";
			productDetails[10] = "CAS：" + p.getCas();
			productDetails[11] = "备注：" + p.getNote();					
			
			new AlertDialog.Builder(ProductList.this).setTitle("药品信息")
			.setItems(productDetails, null)
			.setIcon(android.R.drawable.ic_dialog_info)
			.setView( new EditText(ProductList.this)).setPositiveButton("购买", 
				new Dialog.OnClickListener() {
				@Override
					public void onClick(DialogInterface dialog, int which) {					
						dialog.dismiss();

						// TODO
						// For Brandon.Wang to deal with the function "Purchase", start from HERE!
						// FYI, you can transmit data using DataTransmit.class
						
						// Intent intent = new Intent();
						// intent.setClass(ProductList.this, Order.class);
						// startActivity(intent);
					}
				})
			.setNegativeButton("返回", null).show();
			Log.i(TAG, arg2+"");
		}  
    };
	
    /**
     * Get search results' names
     * @param searchResults product list
     * @return
     */
	public String[] getSearchResultNames(ArrayList<Product> searchResults){
		String[] searchNames = new String[searchResults.size()];
		for(int i=0; i<searchResults.size(); i++){
			Product p = (Product)searchResults.get(i);
			searchNames[i] = p.getProductName();
		}
		return searchNames;
	}
	
    /**
     * Get search results' prices
     * @param searchResults product list
     * @return
     */
	public String[] getSearchResultPrices(ArrayList<Product> searchResults){
		String[] searchPrices = new String[searchResults.size()];
		for(int i=0; i<searchResults.size(); i++){
			Product p = (Product)searchResults.get(i);
			searchPrices[i] = p.getNormalPrice()+"￥/g";
		}
		return searchPrices;
	}
	
    /**
     * Get search results' picture Ids
     * @param searchResults product list
     * @return
     */
	public int[] getSearchResultPictureIds(ArrayList<Product> searchResults){
		int[] pictureIds = new int[searchResults.size()];
		for(int i=0; i<searchResults.size(); i++){
			Product p = (Product)(searchResults.get(i));
			//pictureIds[i] = p.getNormalPrice()+"";
			pictureIds[i] = R.drawable.pic;
			
		}
		return pictureIds;
	}
	
    /**
     * Get all products' name 
     * @param searchResults product list
     * @return
     */
	public String[] getProductNames(){
		//String[] names = {"","","","",""};
		String[] names = new String[dataTransmit.getProducts().size()];
		//ArrayList<String> names = new ArrayList<String>();
		for(int i=0; i<dataTransmit.getProducts().size(); i++){
			Product p = (Product)(dataTransmit.getProducts().get(i));
			names[i] = p.getProductName();
		}
		return names;
	}
	
    /**
     * Get all products' prices 
     * @param searchResults product list
     * @return
     */
	public String[] getProductPrices(){
		String[] prices = new String[dataTransmit.getProducts().size()];
		Log.i(TAG, dataTransmit.getProducts().size()+"");
		for(int i=0; i<dataTransmit.getProducts().size(); i++){
			Product p = (Product)(dataTransmit.getProducts().get(i));
			prices[i] = p.getNormalPrice()+"￥/g";
		}
		return prices;
	}
	
    /**
     * Get all products' picture Ids 
     * @param searchResults product list
     * @return
     */
	public int[] getPictureIds(){
		int[] pictureIds = new int[dataTransmit.getProducts().size()];
		for(int i=0; i<dataTransmit.getProducts().size(); i++){
			Product p = (Product)(dataTransmit.getProducts().get(i));
			//pictureIds[i] = p.getNormalPrice()+"";
			pictureIds[i] = R.drawable.pic;
		}
		return pictureIds;
	}
	
	/**
	 * Listener for product item
	 */
	OnItemClickListener itemListener = new OnItemClickListener(){  	

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
						
			Product p = (Product)(dataTransmit.getProducts().get(arg2));
			String[] productDetails = new String[12];
			productDetails[0] = "编号："+p.getProductNumber();
			productDetails[1] = "名称："+p.getProductName();
			if(p.getCategory().getCategoryNo() == "001"){
				productDetails[2] = "分类："+"西药";
				productDetails[3] = "分类号："+"001";
			}else{
				productDetails[2] = "分类："+"中药";
				productDetails[3] = "分类号："+"002";
			}
			productDetails[4] = "MDL编号：" + p.getMDLNumber();
			productDetails[5] = "化学公式：" + p.getFormula();
			productDetails[6] = "价格：" + p.getNormalPrice()+"￥/g";
			productDetails[7] = "VIP价格：" + p.getVipPrice()+"￥/g";
			productDetails[8] = "实际库存：" + p.getRealStock()+"g";
			productDetails[9] = "重量：" + p.getWeight()+"g";
			productDetails[10] = "CAS：" + p.getCas();
			productDetails[11] = "备注：" + p.getNote();					
			
			new AlertDialog.Builder(ProductList.this).setTitle("药品信息")
			.setItems(productDetails, null)
			.setIcon(android.R.drawable.ic_dialog_info)
			.setView( new EditText(ProductList.this)).setPositiveButton("购买", 
				new Dialog.OnClickListener() {
				@Override
					public void onClick(DialogInterface dialog, int which) {
					
						dialog.dismiss();
						
						// TODO
						// Do the same thing with that in searchItemListener
						// Sorry for the duplication!
						
						//Intent intent = new Intent();
						//intent.setClass(ProductList.this, Order.class);
						//startActivity(intent);
					}
				})
			.setNegativeButton("返回", null).show();
			Log.i(TAG, arg2+"");
		}  
    };
    
    /**
     * Adapter for ListView
     */
    public class ListViewAdapter extends BaseAdapter {  
        View[] itemViews;  
  
        public ListViewAdapter(String[] itemTitles, String[] itemTexts,  
                int[] itemImageRes) {  
            itemViews = new View[itemTitles.length];  
  
            for (int i = 0; i < itemViews.length; i++) {  
                itemViews[i] = makeItemView(itemTitles[i], itemTexts[i],  
                        itemImageRes[i]);  
            }  
        }  
  
        public int getCount() {  
            return itemViews.length;  
        }  
  
        public View getItem(int position) {  
            return itemViews[position];  
        }  
  
        public long getItemId(int position) {  
            return position;  
        }  
  
        private View makeItemView(String strTitle, String strText, int resId) {  
            LayoutInflater inflater = (LayoutInflater) ProductList.this  
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
  
            
            View itemView = inflater.inflate(R.layout.item, null); 
            TextView title = (TextView) itemView.findViewById(R.id.itemTitle);  
            title.setText(strTitle);  
            TextView text = (TextView) itemView.findViewById(R.id.itemText);  
            text.setText(strText);  
            ImageView image = (ImageView) itemView.findViewById(R.id.itemImage);  
            image.setImageResource(resId);  
              
            return itemView;  
        }  
  
        public View getView(int position, View convertView, ViewGroup parent) {  
            if (convertView == null)  
                return itemViews[position];  
            return convertView;  
        }  
    }  

}
