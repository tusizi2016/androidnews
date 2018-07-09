package com.news;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

public class MainActivity extends ActionBarActivity {
	private final int COLUMNWIDTHPX = 55;
	private int mColumnWidthDip;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mColumnWidthDip = DensityUtil.px2dip(this, COLUMNWIDTHPX);
		String [] categoryArray = getResources().getStringArray(R.array.categories);
		List <HashMap<String,String>> catefories = new ArrayList<HashMap<String,String>>();
		for (int i = 0; i < categoryArray.length; i++) {
			HashMap<String,String> hashMap = new HashMap<String, String>();
			hashMap.put("category_title", categoryArray[i]);
			catefories.add(hashMap);
		}
		SimpleAdapter categoryAdapter = new SimpleAdapter(this, catefories, R.layout.category_title, new String []{"category_title"}, new int [] {R.id.category_title});
		
		GridView category = new GridView(this);
		category.setColumnWidth(COLUMNWIDTHPX);
		category.setNumColumns(GridView.AUTO_FIT);
		category.setGravity(Gravity.LEFT);//对其方式
		
		int width = mColumnWidthDip*catefories.size();
		LayoutParams params = new LayoutParams(width,LayoutParams.WRAP_CONTENT);
		category.setLayoutParams(params);
		
		category.setAdapter(categoryAdapter);
		
		LinearLayout categoryLayout =(LinearLayout)findViewById(R.id.category_layout);
		categoryLayout.addView(category);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
