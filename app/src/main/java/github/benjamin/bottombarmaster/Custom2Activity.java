package github.benjamin.bottombarmaster;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import github.benjamin.bottombar.NavigationController;
import github.benjamin.bottombar.PageNavigationView;
import github.benjamin.bottombar.item.BaseTabItem;
import github.benjamin.bottombarmaster.custom.OnlyIconItemView;
import github.benjamin.bottombarmaster.custom.TestRepeatTab;
import github.benjamin.bottombarmaster.other.MyViewPagerAdapter;

public class Custom2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_horizontal);

        PageNavigationView tab = findViewById(R.id.tab);

        NavigationController navigationController = tab.custom()
                .addItem(newItem_test(R.drawable.ic_restore_gray_24dp,R.drawable.ic_restore_teal_24dp))
                .addItem(newItem(R.drawable.ic_favorite_gray_24dp,R.drawable.ic_favorite_teal_24dp))
                .addItem(newItem(R.drawable.ic_nearby_gray_24dp,R.drawable.ic_nearby_teal_24dp))
                .build();

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(),navigationController.getItemCount()));

        //自动适配ViewPager页面切换
        navigationController.setupWithViewPager(viewPager);
    }

    //创建一个Item
    private BaseTabItem newItem(int drawable, int checkedDrawable){
        OnlyIconItemView onlyIconItemView = new OnlyIconItemView(this);
        onlyIconItemView.initialize(drawable,checkedDrawable);
        return onlyIconItemView;
    }

    //创建一个Item(测试重复点击的方法)
    private BaseTabItem newItem_test(int drawable, int checkedDrawable){
        TestRepeatTab testRepeatTab = new TestRepeatTab(this);
        testRepeatTab.initialize(drawable,checkedDrawable);
        return testRepeatTab;
    }
}
