package com.leisure.baseapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.leisure.baseapplication.adapter.CommonAdapterActivity;
import com.leisure.baselibrary.adapter.BaseAdapterHelper;
import com.leisure.baselibrary.adapter.QuickAdapter;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.util.ArrayList;
import java.util.List;

import static com.leisure.baseapplication.R.id.main_lv;

public class MainActivity extends AppCompatActivity {
    private ListView mLV;
    List<String> ss=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().
                showImageForEmptyUri(R.mipmap.ic_launcher)
                .cacheInMemory(true).cacheOnDisk(true).build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext()).defaultDisplayImageOptions(defaultOptions)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO).build();
        ImageLoader.getInstance().init(config);
        mLV= (ListView) findViewById(main_lv);
        initData();
        mLV.setAdapter(new QuickAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, ss) {
            @Override
            protected void convert(BaseAdapterHelper helper,  String item) {
               final String data=item;
                helper.setText(android.R.id.text1, item)
                        .setOnClickListener(android.R.id.text1, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(data.equals("adapter")){
                                    startActivity(new Intent(MainActivity.this, CommonAdapterActivity.class));
                                }
                            }
                        });

            }
        });
    }
    private void initData(){
        ss.add("adapter");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
