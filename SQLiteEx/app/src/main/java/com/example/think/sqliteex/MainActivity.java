package com.example.think.sqliteex;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnDbOpListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.fragment_container)!=null){
            if (savedInstanceState!=null){
                return;
            }
            //一开始即调用了home fragment, 同时这个主函数还执行了hf的Ondblistener,这是在homefragment中定义
            // 要覆盖performed函数
            HomeFragment homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,homeFragment).commit();
            //接下来就是在hf中进行操作了
        }
    }

    @Override
    public void dBOpPerformaed(int method) {
        switch (method){
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AddContactFragment()).addToBackStack(null).commit();
                break;
            case 1:
                //按下的是view的时候，替换当前的fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ViewFragment()).addToBackStack(null).commit();
                break;
            case 2:
                //按下的是view的时候，替换当前的fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new UpdateFragment()).addToBackStack(null).commit();
                break;
            case 3:
                //按下的是view的时候，替换当前的fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new DeleteFragment()).addToBackStack(null).commit();
                break;
        }
    }
}
