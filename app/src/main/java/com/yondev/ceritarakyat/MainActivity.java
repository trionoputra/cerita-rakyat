package com.yondev.ceritarakyat;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.yondev.ceritarakyat.widget.ExitDialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends FragmentActivity implements OnClickListener {
	public static int nilai = 0;
	private InterstitialAd Interstitial;
	private AdRequest adRequest;
	private AdView mAdView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mAdView = (AdView)findViewById(R.id.ad_view);
		adRequest = new AdRequest.Builder().build();

		mAdView.loadAd(adRequest);

		Interstitial = new InterstitialAd(MainActivity.this);
		Interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));


		findViewById(R.id.btnCerita).setOnClickListener(this);
		findViewById(R.id.btnKeluar).setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnCerita:
			Intent intent = new Intent(MainActivity.this, MenuCeritaActivity.class);
			startActivity(intent);
			overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			break;
		case R.id.btnKeluar:
			ExitDialog exit = new ExitDialog();
			exit.show(getSupportFragmentManager(), "");
			break;	
		default:
			break;
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		Interstitial.loadAd(adRequest);
	}

	public void displayInterstitial() {
		// If Ads are loaded, show Interstitial else show nothing.
		if (Interstitial.isLoaded()) {
			Interstitial.show();
		}
	}

	@Override
	protected void onDestroy() {
		displayInterstitial();
		super.onDestroy();
	}
}

