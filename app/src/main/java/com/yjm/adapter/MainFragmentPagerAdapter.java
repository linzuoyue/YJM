package com.yjm.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yjm.R;
import com.yjm.fragment.ActivityTaskFragment;
import com.yjm.fragment.BaseFragment;
import com.yjm.fragment.MineFragment;

/**
 * Created by lzy on 2016/3/23.
 */
public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

    private int titleIds[] = {R.string.goods, R.string.mine};
    private Context context;

    public MainFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        int titleId = titleIds[position];
        switch (titleId) {
            case R.string.mine:
                return Fragment.instantiate(context, MineFragment.class.getName());
            case R.string.goods:
                return Fragment.instantiate(context, ActivityTaskFragment.class.getName());
            default:
                return Fragment.instantiate(context, BaseFragment.class.getName());
        }
    }

    @Override
    public int getCount() {
        return titleIds.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return context.getString(titleIds[position]);
    }
}
