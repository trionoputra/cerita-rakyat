package com.yondev.ceritarakyat;

import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.yondev.ceritarakyat.adapter.PulauAdapter;

public class MenuCeritaActivity extends Activity {
	public Integer pulau[] = {R.mipmap.sumatera,R.mipmap.jawa,R.mipmap.kalimantan,R.mipmap.nusa_tenggara,R.mipmap.sulawesi,R.mipmap.maluku,R.mipmap.papua};
	private ListView lv;
	private PulauAdapter adapter;

	private AdRequest adRequest;
	private AdView mAdView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_cerita);

		mAdView = (AdView)findViewById(R.id.ad_view);
		adRequest = new AdRequest.Builder().build();

		mAdView.loadAd(adRequest);


		lv = (ListView)findViewById(R.id.listView1);
		adapter = new PulauAdapter(this);
		adapter.set(Arrays.asList(pulau));
		lv.setAdapter(adapter);
	
	}

}
