package com.yondev.ceritarakyat;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class CeritaActivity extends Activity {
	private String file = "file:///android_asset/";

	private InterstitialAd Interstitial;
	private AdRequest adRequest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cerita);

		adRequest = new AdRequest.Builder().build();

		Interstitial = new InterstitialAd(CeritaActivity.this);
		// Insert the Ad Unit ID
		Interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));

		Interstitial.loadAd(adRequest);

		Interstitial.setAdListener(new AdListener() {
			public void onAdLoaded() {
				// Call displayInterstitial() function
				displayInterstitial();
			}
		});

		final RelativeLayout loader = (RelativeLayout)findViewById(R.id.loading);
		final WebView wb = (WebView)findViewById(R.id.webView1);
		wb.setBackgroundColor(0x00000000);
		wb.getSettings().setBuiltInZoomControls(true);
		wb.getSettings().setDisplayZoomControls(false);
		wb.getSettings().setJavaScriptEnabled(true);
		Bundle extras = getIntent().getExtras();
		if(extras != null)
		{
			int id = extras.getInt("id");

			if(id == R.mipmap.menu_baitusen)
				wb.loadUrl(file+"Sumatera/Baitusen dan Mai Lamah/index.html");
			else if(id == R.mipmap.menu_danau_toba)
				wb.loadUrl(file+"Sumatera/Asal Mula Danau Toba/index.html");
			else if(id == R.mipmap.menu_domas)
				wb.loadUrl(file+"Sumatera/Sultan Domas/index.html");
			else if(id == R.mipmap.menu_lancang)
				wb.loadUrl(file+"Sumatera/Si Lancang/index.html");
			else if(id == R.mipmap.menu_malin)
				wb.loadUrl(file+"Sumatera/Malin Kundang/index.html");
			else if(id == R.mipmap.menu_pahit_lidah)
				wb.loadUrl(file+"Sumatera/Si Pahit Lidah/index.html");
			else if(id == R.mipmap.menu_pukes)
				wb.loadUrl(file+"Sumatera/Putri Pukes/index.html");
			else if(id == R.mipmap.menu_pulau_kapal)
				wb.loadUrl(file+"Sumatera/Legenda Pulau Kapal/index.html");
			else if(id == R.mipmap.menu_sindang)
				wb.loadUrl(file+"Sumatera/Putri Sindang Bulan/index.html");
			else if(id == R.mipmap.menu_tangguk)
				wb.loadUrl(file+"Sumatera/Putri Tangguk/index.html");
				
			else if(id == R.mipmap.menu_batu_kuwung)
				wb.loadUrl(file+"Jawa/Asal Mula Batu Kuwung/index.html");
			else if(id == R.mipmap.menu_cindelaras)
				wb.loadUrl(file+"Jawa/Cindelaras/index.html");
			else if(id == R.mipmap.menu_pitung)
				wb.loadUrl(file+"Jawa/Si Pitung Jagoan Betawi/index.html");
			else if(id == R.mipmap.menu_sangkuriang)
				wb.loadUrl(file+"Jawa/Sangkuriang/index.html");
			else if(id == R.mipmap.menu_timun_mas)
				wb.loadUrl(file+"Jawa/Timun Mas/index.html");
			else if(id == R.mipmap.menu_prambanan)
				wb.loadUrl(file+"Jawa/Legenda Candi Prambanan/index.html");
				
			
			else if(id == R.mipmap.menu_batu_menangis)
				wb.loadUrl(file+"Kalimantan/Batu Menangis/index.html");
			else if(id == R.mipmap.menu_danau_lipan)
				wb.loadUrl(file+"Kalimantan/Legenda Danau Lipan/index.html");
			else if(id == R.mipmap.menu_manusia_ular)
				wb.loadUrl(file+"Kalimantan/Manusia Ular/index.html");
			else if(id == R.mipmap.menu_telaga_bidadari)
				wb.loadUrl(file+"Kalimantan/Telaga Bidadari/index.html");
				
				
			else if(id == R.mipmap.menu_bukit_catu)
				wb.loadUrl(file+"Nusa Tenggara/Asal Mula Bukit Catu/index.html");
			else if(id == R.mipmap.menu_pohon_enau)
				wb.loadUrl(file+"Nusa Tenggara/Legenda Pohon Enau/index.html");
			else if(id == R.mipmap.menu_suri_ikun)
				wb.loadUrl(file+"Nusa Tenggara/Suri Ikun dan Dua Burung/index.html");
				
				
			else if(id == R.mipmap.menu_batu_bagga)
				wb.loadUrl(file+"Sulawesi/Batu Bagga/index.html");
			else if(id == R.mipmap.menu_ladana)
				wb.loadUrl(file+"Sulawesi/Ladana dan Kerbau/index.html");
			else if(id == R.mipmap.menu_sigarlaki)
				wb.loadUrl(file+"Sulawesi/Sigarlaki dan Limbat/index.html");
			else if(id == R.mipmap.menu_sirimbone)
				wb.loadUrl(file+"Sulawesi/Legenda La Sirimbone/index.html");
			else if(id == R.mipmap.menu_tandampalik)
				wb.loadUrl(file+"Sulawesi/Putri Tandampalik/index.html");
			else if(id == R.mipmap.menu_tanduk_alam)
				wb.loadUrl(file+"Sulawesi/Tanduk Alam/index.html");	
				
				
			else if(id == R.mipmap.menu_rusa)
				wb.loadUrl(file+"Maluku/Si Rusa dan si Kulomang/index.html");	
			else if(id == R.mipmap.menu_telaga_biru)
				wb.loadUrl(file+"Maluku/Telaga Biru/index.html");	
				
				
			else if(id == R.mipmap.menu_buaya_ajaib)
				wb.loadUrl(file+"Papua/Buaya Ajaib/index.html");
			else if(id == R.mipmap.menu_neera)
				wb.loadUrl(file+"Papua/Cerita Neera/index.html");
		}
		
		
		DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
	    final float dpWidth = (displayMetrics.widthPixels) / displayMetrics.density;
		
		wb.setWebViewClient(new WebViewClient() {
	        @Override
	        public void onPageFinished(WebView view, final String url) {
	        	// TODO Auto-generated method stub
	        	super.onPageFinished(view, url);
	        	wb.loadUrl("javascript:setcss('"+(dpWidth)+"');");
	        	loader.setVisibility(View.GONE);
	        }
	        @Override
	        public void onPageStarted(WebView view, String url, Bitmap favicon) {
	        	// TODO Auto-generated method stub
	        	super.onPageStarted(view, url, favicon);
	        	loader.setVisibility(View.VISIBLE);
	        }
	    });
	}

	public void displayInterstitial() {
		// If Ads are loaded, show Interstitial else show nothing.
		if (Interstitial.isLoaded()) {
			Interstitial.show();
		}
	}

}
