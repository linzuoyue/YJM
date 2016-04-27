package com.yjm.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lcylib.util.GsonUtil;
import com.yjm.R;
import com.yjm.TemplateSet;

import yjm.com.templatelib.ClickListener;
import yjm.com.templatelib.template.TemplateAdapter;

/**
 * Created by lzy on 2016/3/23.
 */
public class GoodsListFragment extends BaseFragment {


    String jsonStr = "{\"resultInfo\":{\"resultCode\":200,\"resultMsg\":\"成功\"},\"lastVersion\":1460461794,\"data\":[{\"template\":\"combined\",\"type\":\"combined\",\"subTemplates\":[{\"template\":\"label\",\"type\":\"label\",\"extra\":\"{\\\"marginTop\\\":\\\"0\\\",\\\"marginBottom\\\":\\\"0\\\",\\\"marginLeft\\\":\\\"10\\\",\\\"marginRight\\\":\\\"10\\\"}\",\"items\":[{\"style\":\"label\",\"type\":\"common\",\"titles\":[{\"valueDesc\":\"直播推荐\"},{\"valueDesc\":\"更多\"}],\"href\":\"http://m.miguxue.com/client/p/moreonlive.jsp\"}]},{\"template\":\"grid\",\"type\":\"grid\",\"extra\":\"{\\\"row\\\":\\\"2\\\",\\\"col\\\":\\\"2\\\",\\\"divider\\\":\\\"\\\",\\\"dividerHeight\\\":\\\"10\\\",\\\"marginTop\\\":\\\"0\\\",\\\"marginBottom\\\":\\\"10\\\",\\\"marginLeft\\\":\\\"10\\\",\\\"marginRight\\\":\\\"10\\\"}\",\"items\":[{\"style\":\"image\",\"type\":\"common\",\"imgs\":[{\"imgUrl\":\"http://ccms.miguxue.com:8081/upload/image/upload_ddae5d8690055918d30bb602713b818d.jpg\",\"aspectRation\":\"1.82105263\"}],\"href\":\"http://m.miguxue.com/client/yyonlive.html\"},{\"style\":\"image\",\"type\":\"common\",\"imgs\":[{\"imgUrl\":\"http://ccms.miguxue.com:8081/upload/image/upload_a4c417256a72328127be1411497fe5bf.jpg\",\"aspectRation\":\"1.82105263\"}],\"href\":\"http://m.miguxue.com/client/hyonlive.html\"},{\"style\":\"image\",\"type\":\"common\",\"imgs\":[{\"imgUrl\":\"http://ccms.miguxue.com:8081/upload/image/upload_a841055a2075b373f74f930cffa97e14.png\",\"aspectRation\":\"1.82105263\"}],\"href\":\"http://m.miguxue.com/client/zzonlive.html\"},{\"style\":\"image\",\"type\":\"common\",\"imgs\":[{\"imgUrl\":\"http://ccms.miguxue.com:8081/upload/image/upload_6c21a250a791da26343b1653114f25d5.jpg\",\"aspectRation\":\"1.82105263\"}],\"href\":\"http://m.miguxue.com/client/zyonlinve.html\"}]}],\"name\":\"直播推荐\"},{\"template\":\"combined\",\"type\":\"combined\",\"subTemplates\":[{\"template\":\"label\",\"type\":\"label\",\"extra\":\"{\\\"marginTop\\\":\\\"0\\\",\\\"marginBottom\\\":\\\"0\\\",\\\"marginLeft\\\":\\\"10\\\",\\\"marginRight\\\":\\\"10\\\"}\",\"items\":[{\"style\":\"label\",\"type\":\"common\",\"titles\":[{\"valueDesc\":\"精彩回放\"},{\"valueDesc\":\"更多\"}],\"href\":\"http://m.miguxue.com/client/p/moreonlive.jsp\"}]},{\"template\":\"vertical_list\",\"type\":\"list\",\"extra\":\"{\\\"marginTop\\\":\\\"0\\\",\\\"marginBottom\\\":\\\"10\\\",\\\"marginLeft\\\":\\\"10\\\",\\\"marginRight\\\":\\\"10\\\",\\\"divider\\\":\\\"\\\",\\\"dividerHeight\\\":\\\"10\\\"}\",\"items\":[{\"style\":\"live_telecast2\",\"type\":\"common\",\"extra\":\"{\\\"contentId\\\":\\\"490404\\\",\\\"studyCount\\\":\\\"12316人在学\\\",\\\"anchor\\\":\\\"韦晓亮\\\",\\\"date\\\":\\\"时长：1小时16分钟\\\"}\",\"titles\":[{\"valueDesc\":\"如何做好每一步职业选择\"}],\"imgs\":[{\"imgUrl\":\"http://ccms.miguxue.com:8081/upload/image/upload_d5a036a2af9a6215eac050b88a09bf3f.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=490404\"},{\"style\":\"live_telecast2\",\"type\":\"common\",\"extra\":\"{\\\"contentId\\\":\\\"377971\\\",\\\"studyCount\\\":\\\"33645人在学\\\",\\\"anchor\\\":\\\"翟少成\\\",\\\"date\\\":\\\"时长：1小时52分钟\\\"}\",\"titles\":[{\"valueDesc\":\"教你一口流利的英语口语\"}],\"imgs\":[{\"imgUrl\":\"http://ccms.miguxue.com:8081/upload/image/upload_d58862b337121761193a1982c5e23caf.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=377971\"},{\"style\":\"live_telecast2\",\"type\":\"common\",\"extra\":\"{\\\"contentId\\\":\\\"378032\\\",\\\"studyCount\\\":\\\"33719人在学\\\",\\\"anchor\\\":\\\"周星剑\\\",\\\"date\\\":\\\"时长：1小时20分钟\\\"}\",\"titles\":[{\"valueDesc\":\"零基础一小时学会说韩语\"}],\"imgs\":[{\"imgUrl\":\"http://ccms.miguxue.com:8081/upload/image/upload_937b09ae8fbafebd6becb916572f3d18.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=378032\"},{\"style\":\"live_telecast2\",\"type\":\"common\",\"extra\":\"{\\\"contentId\\\":\\\"465844\\\",\\\"studyCount\\\":\\\"4555人在学\\\",\\\"anchor\\\":\\\"王军\\\",\\\"date\\\":\\\"时长：2小时5分钟\\\"}\",\"titles\":[{\"valueDesc\":\"45个核心词横扫考研写作圈\"}],\"imgs\":[{\"imgUrl\":\"http://ccms.miguxue.com:8081/upload/image/upload_548d4f767abaf40c81355bcd70471d5c.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=465844\"},{\"style\":\"live_telecast2\",\"type\":\"common\",\"extra\":\"{\\\"contentId\\\":\\\"337077\\\",\\\"studyCount\\\":\\\"6104人在学\\\",\\\"anchor\\\":\\\"郭继承\\\",\\\"date\\\":\\\"时长：1小时52分钟\\\"}\",\"titles\":[{\"valueDesc\":\"考研政治知识点串讲强化\"}],\"imgs\":[{\"imgUrl\":\"http://ccms.miguxue.com:8081/upload/image/upload_6ea2bb1b1553d9f9f629e9e85d13e2ff.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=337077\"}]}],\"name\":\"\"}]}";
    private RecyclerView xrv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goods, container, false);
        xrv = (RecyclerView) view.findViewById(R.id.xrv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        xrv.setLayoutManager(linearLayoutManager);
        TemplateSet templateSet = GsonUtil.fromJson(jsonStr, TemplateSet.class);
        TemplateAdapter templateAdapter = new TemplateAdapter(getContext(), new ClickListener() {
            @Override
            public void onClick(String href) {

            }
        });
        templateAdapter.setData(templateSet.getData());
        xrv.setAdapter(templateAdapter);
        return view;
    }
}
