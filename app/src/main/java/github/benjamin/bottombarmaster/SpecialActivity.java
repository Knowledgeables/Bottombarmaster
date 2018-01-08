package github.benjamin.bottombarmaster;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import github.benjamin.bottombar.NavigationController;
import github.benjamin.bottombar.PageNavigationView;
import github.benjamin.bottombar.item.BaseTabItem;
import github.benjamin.bottombarmaster.custom.SpecialTab;
import github.benjamin.bottombarmaster.custom.SpecialTabRound;
import github.benjamin.bottombarmaster.other.AFragment;
import github.benjamin.bottombarmaster.other.FragmentAdapter;

/**
 * Created by mjj on 2017/6/25
 */
public class SpecialActivity extends AppCompatActivity {
    private ArrayList<Fragment> fragmentList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special);

        PageNavigationView tab = findViewById(R.id.tab);
        BaseTabItem center = newRoundItem(R.mipmap.ic_center_def, R.mipmap.ic_center_sel, "工作");
        center.setMessageNumber(999);
        NavigationController navigationController = tab.custom()
                .addItem(newItem(R.mipmap.ic_message_def, R.mipmap.ic_message_sel, "消息"))
                .addItem(newItem(R.mipmap.ic_contact_def, R.mipmap.ic_contact_sel, "通讯录"))
                .addItem(center)
                .addItem(newItem(R.mipmap.ic_chart_def, R.mipmap.ic_chart_sel, "报表"))
                .addItem(newItem(R.mipmap.ic_mine_def, R.mipmap.ic_mine_sel, "我的"))
                .build();

        ViewPager viewPager = findViewById(R.id.viewPager);
        fragmentList = new ArrayList<>();
        fragmentList.add(AFragment.newInstance("消息"));
        fragmentList.add(AFragment.newInstance("通讯录"));
        fragmentList.add(AFragment.newInstance("工作"));
        fragmentList.add(AFragment.newInstance("报表"));
        fragmentList.add(AFragment.newInstance("我的"));
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), fragmentList));


        //自动适配ViewPager页面切换
        navigationController.setupWithViewPager(viewPager);
    }

    /**
     * 正常tab
     */
    private BaseTabItem newItem(int drawable, int checkedDrawable, String text) {
        SpecialTab mainTab = new SpecialTab(this);
        mainTab.initialize(drawable, checkedDrawable, text);
        mainTab.setTextDefaultColor(0xffb8bfcc);
        mainTab.setTextCheckedColor(0xff689df8);
        return mainTab;
    }

    /**
     * 圆形tab
     */
    private BaseTabItem newRoundItem(int drawable, int checkedDrawable, String text) {
        SpecialTabRound mainTab = new SpecialTabRound(this);
        mainTab.initialize(drawable, checkedDrawable, text);
        mainTab.setTextDefaultColor(0xffb8bfcc);
        mainTab.setTextCheckedColor(0xff689df8);
        return mainTab;
    }

}
