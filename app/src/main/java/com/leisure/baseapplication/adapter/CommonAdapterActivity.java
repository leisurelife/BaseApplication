package com.leisure.baseapplication.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.leisure.baseapplication.R;
import com.leisure.baselibrary.adapter.BaseAdapterHelper;
import com.leisure.baselibrary.adapter.QuickAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.leisure.baseapplication.R.layout.item_adaper;

/**
 * Created by json on 2015/11/30.
 */
public class CommonAdapterActivity extends Activity {
    private ListView mLV;
    private List<User> users;
    private String[] images = {"http://img2.imgtn.bdimg.com/it/u=3093785514,1341050958&fm=21&gp=0.jpg",
            "http://img2.3lian.com/2014/f2/37/d/40.jpg",
            "http://d.3987.com/sqmy_131219/001.jpg",
            "http://img2.3lian.com/2014/f2/37/d/39.jpg",
            "http://www.8kmm.com/UploadFiles/2012/8/201208140920132659.jpg",
            "http://f.hiphotos.baidu.com/image/h%3D200/sign=1478eb74d5a20cf45990f9df460b4b0c/d058ccbf6c81800a5422e5fdb43533fa838b4779.jpg",
            "http://f.hiphotos.baidu.com/image/pic/item/09fa513d269759ee50f1971ab6fb43166c22dfba.jpg"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        mLV= (ListView) findViewById(R.id.adapter_lv);
        users=new ArrayList<>();
        for(String url:images){
            User user=new User();
            user.name="xiaoxiao"+ new Random().nextInt(10);
            user.url=url;
            users.add(user);
        }
        mLV.setAdapter(new QuickAdapter<User>(this, item_adaper,users) {
            @Override
            protected void convert(BaseAdapterHelper helper, User item) {
                helper.setText(R.id.adapter_tv,item.name).setImageUrl(R.id.adapter_iv,item.url);
            }
        });

    }
    class User{
        public String name;
        public String url;
    }
}
