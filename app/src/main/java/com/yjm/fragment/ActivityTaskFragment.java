package com.yjm.fragment;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yjm.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2016/5/31.
 */
public class ActivityTaskFragment extends BaseFragment {

    private ListView listView;
    private List<String> all = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private ActivityManager activityManager;
    private FragmentActivity mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_activity_task, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final SwipeRefreshLayout srl = (SwipeRefreshLayout) view.findViewById(R.id.srl);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listActivity();
                srl.setRefreshing(false);
            }
        });
        listView = (ListView) view.findViewById(R.id.list_view);
        activityManager = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
    }

    public void listActivity() {
        final List<ActivityManager.RunningTaskInfo> tasks = activityManager.getRunningTasks(30);
        Iterator<ActivityManager.RunningTaskInfo> itInfo = tasks.iterator();
        all.clear();
        while (itInfo.hasNext()) {
            ActivityManager.RunningTaskInfo info = itInfo.next();
            all.add("[package:" + info.topActivity.getPackageName() + "]---------[className:" + info.topActivity.getClassName() + "]");
        }
        adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, this.all);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                http://blog.sina.com.cn/s/blog_4e1e357d0101d6w6.html
                ActivityManager.RunningTaskInfo runningTaskInfo = tasks.get(position);
                Intent intent = new Intent(Intent.ACTION_MAIN);
                ComponentName cn = new ComponentName(runningTaskInfo.baseActivity.getPackageName(), runningTaskInfo.baseActivity.getClassName());
                intent.setComponent(cn);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}
