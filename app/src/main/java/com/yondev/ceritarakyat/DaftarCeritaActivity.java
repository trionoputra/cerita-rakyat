package com.yondev.ceritarakyat;

import java.util.Arrays;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.yondev.ceritarakyat.adapter.CeritaAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;

public class DaftarCeritaActivity extends Activity {
	public Integer sumatra[] = {R.mipmap.menu_baitusen,R.mipmap.menu_danau_toba,R.mipmap.menu_domas,R.mipmap.menu_lancang,R.mipmap.menu_malin,R.mipmap.menu_pahit_lidah,R.mipmap.menu_pukes,R.mipmap.menu_pulau_kapal,R.mipmap.menu_sindang,R.mipmap.menu_tangguk};
	public Integer jawa[] = {R.mipmap.menu_batu_kuwung,R.mipmap.menu_cindelaras,R.mipmap.menu_pitung,R.mipmap.menu_sangkuriang,R.mipmap.menu_timun_mas,R.mipmap.menu_prambanan};
	public Integer kalimantan[] = {R.mipmap.menu_batu_menangis,R.mipmap.menu_danau_lipan,R.mipmap.menu_manusia_ular,R.mipmap.menu_telaga_bidadari};
	public Integer nusatengara[] = {R.mipmap.menu_bukit_catu,R.mipmap.menu_pohon_enau,R.mipmap.menu_suri_ikun};
	public Integer sulawesi[] = {R.mipmap.menu_batu_bagga,R.mipmap.menu_ladana,R.mipmap.menu_sigarlaki,R.mipmap.menu_sirimbone,R.mipmap.menu_tandampalik,R.mipmap.menu_tanduk_alam};
	public Integer maluku[] = {R.mipmap.menu_rusa,R.mipmap.menu_telaga_biru};
	public Integer papua[] = {R.mipmap.menu_buaya_ajaib,R.mipmap.menu_neera};
	
	private ListView lv;
	private CeritaAdapter adapter;
	private ImageView kop;
	private ImageView map;

	private AdRequest adRequest;
	private AdView mAdView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_daftar_cerita);


		mAdView = (AdView)findViewById(R.id.ad_view);
		adRequest = new AdRequest.Builder().build();

		mAdView.loadAd(adRequest);


		lv = (ListView)findViewById(R.id.listView1);
		
		adapter = new CeritaAdapter(this);
		lv.setAdapter(adapter);
		
		kop = (ImageView)findViewById(R.id.imageView2);
		map = (ImageView)findViewById(R.id.imageView1);
		
		Bundle extras = getIntent().getExtras();
		if(extras != null)
		{
			int id = extras.getInt("pulau");
			if(id == 0)
			{
				adapter.set(Arrays.asList(sumatra));
				kop.setImageResource(R.mipmap.kop_sumatera);
				map.setImageResource(R.mipmap.pulau_sumatera);
			}
			else if(id == 1)
			{
				adapter.set(Arrays.asList(jawa));
				kop.setImageResource(R.mipmap.kop_jawa);
				map.setImageResource(R.mipmap.pulau_jawa);
			}
			else if(id == 2)
			{
				adapter.set(Arrays.asList(kalimantan));
				kop.setImageResource(R.mipmap.kop_kalimantan);
				map.setImageResource(R.mipmap.pulau_kalimantan);
			}
			else if(id == 3)
			{
				adapter.set(Arrays.asList(nusatengara));
				kop.setImageResource(R.mipmap.kop_nusa_tenggara);
				map.setImageResource(R.mipmap.pulau_nusa_tenggara);
			}
			else if(id == 4)
			{
				adapter.set(Arrays.asList(sulawesi));
				kop.setImageResource(R.mipmap.kop_sulawesi);
				map.setImageResource(R.mipmap.pulau_sulawesi);
			}
			else if(id == 5)
			{
				adapter.set(Arrays.asList(maluku));
				kop.setImageResource(R.mipmap.kop_maluku);
				map.setImageResource(R.mipmap.pulau_maluku);
			}
			else if(id == 6)
			{
				adapter.set(Arrays.asList(papua));
				kop.setImageResource(R.mipmap.kop_papua);
				map.setImageResource(R.mipmap.pulau_papua);
			}
		}
		
	}
}
