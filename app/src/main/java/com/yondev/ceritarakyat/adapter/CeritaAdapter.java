package com.yondev.ceritarakyat.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;

import com.yondev.ceritarakyat.CeritaActivity;
import com.yondev.ceritarakyat.R;

public class CeritaAdapter extends BaseAdapter {	
	private Activity activity;
	private LayoutInflater inflater;
	private List<Integer> dtlist;
	public CeritaAdapter(Activity activity) {
		this.activity = activity;
		this.dtlist = new ArrayList<Integer>();
		inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return dtlist.size();
	}
	
	@Override
	public Object getItem(int location) {
		return dtlist.get(location);
	}
	
	public void add(Integer item) {
	
		dtlist.add(item);
		notifyDataSetChanged();
	}
	
	public void add(List<Integer> item){
	
		for (int i = 0; i < item.size(); i++) {
			dtlist.add(item.get(i));
		}
		notifyDataSetChanged();
	}
	
	public void set(List<Integer> data) {
	
		dtlist = data;
		notifyDataSetChanged();
		
	}
	
	public void insert(Integer item,int pos) {
	
		dtlist.add(pos, item);
		notifyDataSetChanged();
	}
	
	
	@Override
	public long getItemId(int position) {
		return position;
	}
	
	public static class ViewHolder{
	     public ImageButton img;
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View vi = convertView;
        ViewHolder holder;
        
        if(convertView==null){
            vi = inflater.inflate(R.layout.cerita_item, null);
            
            holder = new ViewHolder();
            
            holder.img = (ImageButton) vi.findViewById(R.id.imageButton1);
           
            vi.setTag(holder);
        }
        else
            holder=(ViewHolder)vi.getTag();
        
        holder.img.setImageResource(this.dtlist.get(position));
        holder.img.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(activity, CeritaActivity.class);
				intent.putExtra("cerita", position);
				intent.putExtra("id", dtlist.get(position));
				
				activity.startActivity(intent);
				activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			}
		});
        
		return vi;
	}
	
	

}
