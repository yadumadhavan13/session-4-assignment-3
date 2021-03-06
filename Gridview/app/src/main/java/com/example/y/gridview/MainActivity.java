package com.example.y.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private ImageView androidimageview;
    private ArrayList<Integer>androidversionlist;
    private Myadapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidimageview = (ImageView) findViewById(R.id.android_image_view);
        gridView = (GridView) findViewById(R.id.grid_view);

        androidversionlist = new ArrayList<>();
        androidversionlist.add(R.drawable.gingerbread);
        androidversionlist.add(R.drawable.honeycomb);
        androidversionlist.add(R.drawable.icecream);
        androidversionlist.add(R.drawable.jellybean);
        androidversionlist.add(R.drawable.kitkat);
        androidversionlist.add(R.drawable.lollipop);

        adapter = new Myadapter();
        gridView.setAdapter(adapter);

    }
    public class Myadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return androidversionlist.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            viewholder holder;
            if (convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.row_view,parent,false);
                holder = new viewholder();
                holder.bindview(convertView);
                convertView.setTag(holder);
                Log.e("MainActivity","convertview is null");
            }
            else {
                holder = (viewholder)convertView.getTag();

            }
            holder.androidimageview.setImageResource(androidversionlist.get(position));
            return convertView;
        }
    }
    public class viewholder{
        ImageView androidimageview;
        void bindview(View convertview){
            Log.e("MainActivity","convertview is not null");
            androidimageview = (ImageView) convertview.findViewById(R.id.android_image_view);


        }
    }



}
