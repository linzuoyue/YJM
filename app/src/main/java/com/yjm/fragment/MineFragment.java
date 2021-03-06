package com.yjm.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lcylib.util.GsonUtil;
import com.yjm.R;
import com.yjm.TemplateSet;

import yjm.com.templatelib.ClickListener;
import yjm.com.templatelib.template.TemplateAdapter;

/**
 * Created by Administrator on 2016/3/23.
 */
public class MineFragment extends BaseFragment {

    String jsonStr = "{\"resultInfo\":{\"resultCode\":200,\"resultMsg\":\"成功\"},\"lastVersion\":1461565711,\"data\":[{\"template\":\"banner\",\"type\":\"banner\",\"extra\":\"{\\\"marginTop\\\":\\\"0\\\",\\\"marginBottom\\\":\\\"10\\\",\\\"marginLeft\\\":\\\"0\\\",\\\"marginRight\\\":\\\"0\\\",\\\"aspectRation\\\":\\\"2.46153846\\\"}\",\"items\":[{\"style\":\"image\",\"type\":\"common\",\"device\":\"0\",\"imgs\":[{\"imgUrl\":\"http://ccms.miguxue.com:8081/upload/image/upload_196dc3ac363b57f7be79ee29ce0b28c3.jpg\",\"aspectRation\":\"2.41935484\"}],\"href\":\"http://m.miguxue.com/client/p/topic_bbc.jsp\"},{\"style\":\"image\",\"type\":\"common\",\"device\":\"0\",\"imgs\":[{\"imgUrl\":\"http://ccms.miguxue.com:8081/upload/image/upload_c78ba8f9d9a5525613a029a46c889004.png\",\"aspectRation\":\"2.46153846\"}],\"href\":\"http://m.miguxue.com/client/p/songhuafei.jsp\"},{\"style\":\"image\",\"type\":\"common\",\"device\":\"0\",\"imgs\":[{\"imgUrl\":\"http://ccms.miguxue.com:8081/upload/image/upload_ddc2011709b973476e13e1c8d0118437.png\",\"aspectRation\":\"2.46153846\"}],\"href\":\"http://m.miguxue.com/client/p/mfree.jsp\"},{\"style\":\"image\",\"type\":\"common\",\"device\":\"0\",\"imgs\":[{\"imgUrl\":\"http://ccms.miguxue.com:8081/upload/image/upload_7b7008cbaed50f890f4a3dcb919efada.jpg\",\"aspectRation\":\"2.41935484\"}],\"href\":\"http://m.miguxue.com/client/p/topic_4yuehk.jsp\"},{\"style\":\"image\",\"type\":\"common\",\"device\":\"0\",\"channel\":\"J003005Z\",\"imgs\":[{\"imgUrl\":\"http://ccms.miguxue.com:8081/upload/image/upload_cd3c67407a693081e1952d1b549a8b68.jpg\",\"aspectRation\":\"2.46153846\"}],\"href\":\"http://act.syhhkj.com/onegfree/index/210014\"}],\"name\":\"\",\"device\":\"0\"},{\"template\":\"combined\",\"type\":\"combined\",\"subTemplates\":[{\"template\":\"label\",\"type\":\"label\",\"extra\":\"{\\\"marginTop\\\":\\\"0\\\",\\\"marginBottom\\\":\\\"0\\\",\\\"marginLeft\\\":\\\"10\\\",\\\"marginRight\\\":\\\"10\\\"}\",\"items\":[{\"style\":\"label\",\"type\":\"common\",\"device\":\"0\",\"titles\":[{\"valueDesc\":\"趣味口语\"},{\"valueDesc\":\"更多\"}],\"href\":\"http://wap.cmread.com/emall/p/app/view_page?page=courseCategory&subClassId=42330&classId=42315\"}]},{\"template\":\"grid\",\"type\":\"grid\",\"extra\":\"{\\\"row\\\":\\\"2\\\",\\\"col\\\":\\\"2\\\",\\\"divider\\\":\\\"\\\",\\\"dividerHeight\\\":\\\"10\\\",\\\"marginTop\\\":\\\"0\\\",\\\"marginBottom\\\":\\\"0\\\",\\\"marginLeft\\\":\\\"10\\\",\\\"marginRight\\\":\\\"10\\\"}\",\"items\":[{\"style\":\"course1\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"458820\\\",\\\"studyCount\\\":\\\"2542\\\",\\\"mcp\\\":\\\"BBC\\\",\\\"mcpId\\\":\\\"bbc\\\"}\",\"titles\":[{\"valueDesc\":\"Eye candy 虚有其表的人或物\"}],\"imgs\":[{\"imgUrl\":\"http://m.miguxue.com/client/file/cover_file/8820/458820/20160329163500/cover640355.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=458820&mcpId=bbc\"},{\"style\":\"course1\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"458816\\\",\\\"studyCount\\\":\\\"750\\\",\\\"mcp\\\":\\\"BBC\\\",\\\"mcpId\\\":\\\"bbc\\\"}\",\"titles\":[{\"valueDesc\":\"Thingy 忘了名称的物或人\"}],\"imgs\":[{\"imgUrl\":\"http://m.miguxue.com/client/file/cover_file/8816/458816/20160329163500/cover640355.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=458816&mcpId=bbc\"},{\"style\":\"course1\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"459449\\\",\\\"studyCount\\\":\\\"1283\\\",\\\"mcp\\\":\\\"BBC\\\",\\\"mcpId\\\":\\\"bbc\\\"}\",\"titles\":[{\"valueDesc\":\"Table manners 英国餐桌礼仪 （上）\"}],\"imgs\":[{\"imgUrl\":\"http://m.miguxue.com/client/file/cover_file/9449/459449/20160329173501/cover640355.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=459449&mcpId=bbc\"},{\"style\":\"course1\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"458839\\\",\\\"studyCount\\\":\\\"817\\\",\\\"mcp\\\":\\\"BBC\\\",\\\"mcpId\\\":\\\"bbc\\\"}\",\"titles\":[{\"valueDesc\":\"Sweet tooth 爱吃甜食\"}],\"imgs\":[{\"imgUrl\":\"http://m.miguxue.com/client/file/cover_file/8839/458839/20160329164001/cover640355.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=458839&mcpId=bbc\"}]},{\"template\":\"vertical_list\",\"type\":\"list\",\"extra\":\"{\\\"marginTop\\\":\\\"10\\\",\\\"marginBottom\\\":\\\"10\\\",\\\"marginLeft\\\":\\\"10\\\",\\\"marginRight\\\":\\\"10\\\",\\\"divider\\\":\\\"\\\",\\\"dividerHeight\\\":\\\"0\\\"}\",\"items\":[{\"style\":\"course2\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"459458\\\",\\\"studyCount\\\":\\\"801\\\",\\\"mcp\\\":\\\"BBC\\\",\\\"mcpId\\\":\\\"bbc\\\"}\",\"titles\":[{\"valueDesc\":\"Conversational English when using services 英国购物消费用语\"}],\"imgs\":[{\"imgUrl\":\"http://m.miguxue.com/client/file/cover_file/9458/459458/20160331105002/cover640355.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=459458&mcpId=bbc\"}]}],\"name\":\"趣味英语\",\"device\":\"0\"},{\"template\":\"combined\",\"type\":\"combined\",\"subTemplates\":[{\"template\":\"label\",\"type\":\"label\",\"extra\":\"{\\\"marginTop\\\":\\\"0\\\",\\\"marginBottom\\\":\\\"0\\\",\\\"marginLeft\\\":\\\"10\\\",\\\"marginRight\\\":\\\"10\\\"}\",\"items\":[{\"style\":\"label\",\"type\":\"common\",\"device\":\"0\",\"titles\":[{\"valueDesc\":\"编程技术\"},{\"valueDesc\":\"更多\"}],\"href\":\"http://wap.cmread.com/emall/p/app/view_page?page=courseCategory&subClassId=70397&classId=42437\"}]},{\"template\":\"grid\",\"type\":\"grid\",\"extra\":\"{\\\"row\\\":\\\"2\\\",\\\"col\\\":\\\"2\\\",\\\"divider\\\":\\\"\\\",\\\"dividerHeight\\\":\\\"10\\\",\\\"marginTop\\\":\\\"0\\\",\\\"marginBottom\\\":\\\"0\\\",\\\"marginLeft\\\":\\\"10\\\",\\\"marginRight\\\":\\\"10\\\"}\",\"items\":[{\"style\":\"course1\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"503306\\\",\\\"studyCount\\\":\\\"2540\\\",\\\"mcp\\\":\\\"溪聚网络\\\",\\\"mcpId\\\":\\\"xjwl\\\"}\",\"titles\":[{\"valueDesc\":\"深入剖析界面设计流程\"}],\"imgs\":[{\"imgUrl\":\"http://m.miguxue.com/client/file/cover_file/3306/503306/20160414144957/20160414144946640x355.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=503306&mcpId=xjwl\"},{\"style\":\"course1\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"503260\\\",\\\"studyCount\\\":\\\"4898\\\",\\\"mcp\\\":\\\"溪聚网络\\\",\\\"mcpId\\\":\\\"xjwl\\\"}\",\"titles\":[{\"valueDesc\":\"秒学UI设计\"}],\"imgs\":[{\"imgUrl\":\"http://m.miguxue.com/client/file/cover_file/3260/503260/20160414144954/20160414144941640x355.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=503260&mcpId=xjwl\"},{\"style\":\"course1\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"496941\\\",\\\"studyCount\\\":\\\"3154\\\",\\\"mcp\\\":\\\"极客学院\\\",\\\"mcpId\\\":\\\"jkxy\\\"}\",\"titles\":[{\"valueDesc\":\"快速掌握界面优化\"}],\"imgs\":[{\"imgUrl\":\"http://m.miguxue.com/client/file/cover_file/6941/496941/20160401171924/20160401171909640x355.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=496941&mcpId=jkxy\"},{\"style\":\"course1\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"496997\\\",\\\"studyCount\\\":\\\"4760\\\",\\\"mcp\\\":\\\"极客学院\\\",\\\"mcpId\\\":\\\"jkxy\\\"}\",\"titles\":[{\"valueDesc\":\"精讲安卓核心技术\"}],\"imgs\":[{\"imgUrl\":\"http://m.miguxue.com/client/file/cover_file/6997/496997/20160401171927/20160401171913640x355.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=496997&mcpId=jkxy\"}]},{\"template\":\"vertical_list\",\"type\":\"list\",\"extra\":\"{\\\"marginTop\\\":\\\"10\\\",\\\"marginBottom\\\":\\\"10\\\",\\\"marginLeft\\\":\\\"10\\\",\\\"marginRight\\\":\\\"10\\\",\\\"divider\\\":\\\"\\\",\\\"dividerHeight\\\":\\\"0\\\"}\",\"items\":[{\"style\":\"course2\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"503364\\\",\\\"studyCount\\\":\\\"2207\\\",\\\"mcp\\\":\\\"溪聚网络\\\",\\\"mcpId\\\":\\\"xjwl\\\"}\",\"titles\":[{\"valueDesc\":\"轻松学会网页特效编写\"}],\"imgs\":[{\"imgUrl\":\"http://m.miguxue.com/client/file/cover_file/3364/503364/20160414145002/20160414144949640x355.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=503364&mcpId=xjwl\"}]}],\"name\":\"编程技术\",\"device\":\"0\"},{\"template\":\"combined\",\"type\":\"combined\",\"subTemplates\":[{\"template\":\"label\",\"type\":\"label\",\"extra\":\"{\\\"marginTop\\\":\\\"0\\\",\\\"marginBottom\\\":\\\"0\\\",\\\"marginLeft\\\":\\\"10\\\",\\\"marginRight\\\":\\\"10\\\"}\",\"items\":[{\"style\":\"label\",\"type\":\"common\",\"device\":\"0\",\"titles\":[{\"valueDesc\":\"职业考证\"},{\"valueDesc\":\"更多\"}],\"href\":\"http://wap.cmread.com/emall/p/app/view_page?page=courseCategory&subClassId=42383&classId=42348\"}]},{\"template\":\"grid\",\"type\":\"grid\",\"extra\":\"{\\\"row\\\":\\\"2\\\",\\\"col\\\":\\\"2\\\",\\\"divider\\\":\\\"\\\",\\\"dividerHeight\\\":\\\"10\\\",\\\"marginTop\\\":\\\"0\\\",\\\"marginBottom\\\":\\\"0\\\",\\\"marginLeft\\\":\\\"10\\\",\\\"marginRight\\\":\\\"10\\\"}\",\"items\":[{\"style\":\"course1\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"231899\\\",\\\"studyCount\\\":\\\"4582\\\",\\\"mcp\\\":\\\"爱迪科森\\\",\\\"mcpId\\\":\\\"adksjy\\\"}\",\"titles\":[{\"valueDesc\":\"突破经济师考试难点\"}],\"imgs\":[{\"imgUrl\":\"http://m.miguxue.com/client/file/cover_file/1899/231899/20151009095931/20150708090657594640x355.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=231899&mcpId=adksjy\"},{\"style\":\"course1\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"262251\\\",\\\"studyCount\\\":\\\"3342\\\",\\\"mcp\\\":\\\"万学教育\\\",\\\"mcpId\\\":\\\"cmread_wxws\\\"}\",\"titles\":[{\"valueDesc\":\"让HR一眼看中你\"}],\"imgs\":[{\"imgUrl\":\"http://m.miguxue.com/client/file/cover_file/2251/262251/20151009095931/20150803161732640x355.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=262251&mcpId=cmread_wxws\"},{\"style\":\"course1\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"184379\\\",\\\"studyCount\\\":\\\"5484\\\",\\\"mcp\\\":\\\"好学教育\\\",\\\"mcpId\\\":\\\"hxjys\\\"}\",\"titles\":[{\"valueDesc\":\"强化重点  圆梦教师\"}],\"imgs\":[{\"imgUrl\":\"http://m.miguxue.com/client/file/cover_file/4379/184379/20151009095931/20150525213818640x355.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=184379&mcpId=hxjys\"},{\"style\":\"course1\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"235354\\\",\\\"studyCount\\\":\\\"4990\\\",\\\"mcp\\\":\\\"爱迪科森\\\",\\\"mcpId\\\":\\\"adksjy\\\"}\",\"titles\":[{\"valueDesc\":\"深入讲解  助阵考研\"}],\"imgs\":[{\"imgUrl\":\"http://m.miguxue.com/client/file/cover_file/5354/235354/20151009095931/20150709105740640x355.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=235354&mcpId=adksjy\"}]},{\"template\":\"vertical_list\",\"type\":\"list\",\"extra\":\"{\\\"marginTop\\\":\\\"10\\\",\\\"marginBottom\\\":\\\"10\\\",\\\"marginLeft\\\":\\\"10\\\",\\\"marginRight\\\":\\\"10\\\",\\\"divider\\\":\\\"\\\",\\\"dividerHeight\\\":\\\"0\\\"}\",\"items\":[{\"style\":\"course2\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"247742\\\",\\\"studyCount\\\":\\\"5158\\\",\\\"mcp\\\":\\\"优异网校\\\",\\\"mcpId\\\":\\\"yywx\\\"}\",\"titles\":[{\"valueDesc\":\"全面掌握建造师考试考点\"}],\"imgs\":[{\"imgUrl\":\"http://m.miguxue.com/client/file/cover_file/7742/247742/20151009095931/20150721174544640x355.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=247742&mcpId=yywx\"}]}],\"name\":\"职业考证\",\"device\":\"0\"},{\"template\":\"combined\",\"type\":\"combined\",\"subTemplates\":[{\"template\":\"label\",\"type\":\"label\",\"extra\":\"{\\\"marginTop\\\":\\\"0\\\",\\\"marginBottom\\\":\\\"0\\\",\\\"marginLeft\\\":\\\"10\\\",\\\"marginRight\\\":\\\"10\\\"}\",\"items\":[{\"style\":\"label\",\"type\":\"common\",\"device\":\"0\",\"titles\":[{\"valueDesc\":\"时尚生活\"},{\"valueDesc\":\"更多\"}],\"href\":\"http://wap.cmread.com/emall/p/app/view_page?page=courseCategory&subClassId=42525&classId=42348\"}]},{\"template\":\"grid\",\"type\":\"grid\",\"extra\":\"{\\\"row\\\":\\\"2\\\",\\\"col\\\":\\\"2\\\",\\\"divider\\\":\\\"\\\",\\\"dividerHeight\\\":\\\"10\\\",\\\"marginTop\\\":\\\"0\\\",\\\"marginBottom\\\":\\\"0\\\",\\\"marginLeft\\\":\\\"10\\\",\\\"marginRight\\\":\\\"10\\\"}\",\"items\":[{\"style\":\"course1\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"488221\\\",\\\"studyCount\\\":\\\"3897\\\",\\\"mcp\\\":\\\"优学教育\\\",\\\"mcpId\\\":\\\"mymz\\\"}\",\"titles\":[{\"valueDesc\":\"别样唇妆  进阶女神\"}],\"imgs\":[{\"imgUrl\":\"http://m.miguxue.com/client/file/cover_file/8221/488221/20160321170144/20160321170139640x355.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=488221&mcpId=mymz\"},{\"style\":\"course1\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"269285\\\",\\\"studyCount\\\":\\\"8903\\\",\\\"mcp\\\":\\\"优学教育\\\",\\\"mcpId\\\":\\\"mxyb\\\"}\",\"titles\":[{\"valueDesc\":\"秒变服装设计师\"}],\"imgs\":[{\"imgUrl\":\"http://m.miguxue.com/client/file/cover_file/9285/269285/20150807175830/20150807175828640x355.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=269285&mcpId=mxyb\"},{\"style\":\"course1\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"486593\\\",\\\"studyCount\\\":\\\"4726\\\",\\\"mcp\\\":\\\"央广视讯\\\",\\\"mcpId\\\":\\\"ygsx\\\"}\",\"titles\":[{\"valueDesc\":\"健康身体从舞蹈开始\"}],\"imgs\":[{\"imgUrl\":\"http://m.miguxue.com/client/file/cover_file/6593/486593/20160321100840/20160321100838640x355.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=486593&mcpId=ygsx\"},{\"style\":\"course1\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"406762\\\",\\\"studyCount\\\":\\\"9230\\\",\\\"mcp\\\":\\\"东华众辰\\\",\\\"mcpId\\\":\\\"dhzc\\\"}\",\"titles\":[{\"valueDesc\":\"分分钟学会咖啡调制\"}],\"imgs\":[{\"imgUrl\":\"http://m.miguxue.com/client/file/cover_file/6762/406762/20151231102854/20151231102851640x355.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=406762&mcpId=dhzc\"}]},{\"template\":\"vertical_list\",\"type\":\"list\",\"extra\":\"{\\\"marginTop\\\":\\\"10\\\",\\\"marginBottom\\\":\\\"10\\\",\\\"marginLeft\\\":\\\"10\\\",\\\"marginRight\\\":\\\"10\\\",\\\"divider\\\":\\\"\\\",\\\"dividerHeight\\\":\\\"0\\\"}\",\"items\":[{\"style\":\"course2\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"406760\\\",\\\"studyCount\\\":\\\"39398\\\",\\\"mcp\\\":\\\"东华众辰\\\",\\\"mcpId\\\":\\\"dhzc\\\"}\",\"titles\":[{\"valueDesc\":\"秒学高端西式甜点\"}],\"imgs\":[{\"imgUrl\":\"http://m.miguxue.com/client/file/cover_file/6760/406760/20151231102855/20151231102854640x355.jpg\"}],\"href\":\"http://m.miguxue.com/emall/p/detail.jsp?cid=406760&mcpId=dhzc\"}]}],\"name\":\"时尚生活\",\"device\":\"0\"},{\"template\":\"combined\",\"type\":\"combined\",\"subTemplates\":[{\"template\":\"label\",\"type\":\"label\",\"extra\":\"{\\\"marginTop\\\":\\\"0\\\",\\\"marginBottom\\\":\\\"0\\\",\\\"marginLeft\\\":\\\"10\\\",\\\"marginRight\\\":\\\"10\\\"}\",\"items\":[{\"style\":\"label\",\"type\":\"common\",\"device\":\"0\",\"titles\":[{\"valueDesc\":\"MOOC慕课\"},{\"valueDesc\":\"更多\"}],\"href\":\"http://m.miguxue.com/client/p/zt_mooc_ft.jsp\"}]},{\"template\":\"grid\",\"type\":\"grid\",\"extra\":\"{\\\"row\\\":\\\"2\\\",\\\"col\\\":\\\"2\\\",\\\"divider\\\":\\\"\\\",\\\"dividerHeight\\\":\\\"10\\\",\\\"marginTop\\\":\\\"0\\\",\\\"marginBottom\\\":\\\"0\\\",\\\"marginLeft\\\":\\\"10\\\",\\\"marginRight\\\":\\\"10\\\"}\",\"items\":[{\"style\":\"course1\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"\\\",\\\"studyCount\\\":\\\"4604\\\",\\\"mcp\\\":\\\"麻省理工学院\\\",\\\"mcpId\\\":\\\"\\\"}\",\"titles\":[{\"valueDesc\":\"创业101：你的客户是谁？\"}],\"imgs\":[{\"imgUrl\":\"http://ccms.miguxue.com:8081/upload/image/upload_32f0cb9ea80e409f8dbfe6b975b3dc32.jpg\"}],\"href\":\"http://www.xuetangx.com/chinamobile/course/course-v1:MITx+15_390x+sp?spam=mclub\"},{\"style\":\"course1\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"\\\",\\\"studyCount\\\":\\\"3823\\\",\\\"mcp\\\":\\\"清华大学\\\",\\\"mcpId\\\":\\\"\\\"}\",\"titles\":[{\"valueDesc\":\"设计的人因与文化\"}],\"imgs\":[{\"imgUrl\":\"http://ccms.miguxue.com:8081/upload/image/upload_f460605e8024007e5875fdaa9f052ffb.jpg\"}],\"href\":\"http://www.xuetangx.com/chinamobile/course/course-v1:TsinghuaX+70167012_tv+2015_T1?spam=mclub\"},{\"style\":\"course1\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"\\\",\\\"studyCount\\\":\\\"2091\\\",\\\"mcp\\\":\\\"昆士兰大学\\\",\\\"mcpId\\\":\\\"\\\"}\",\"titles\":[{\"valueDesc\":\"日常思考的科学\"}],\"imgs\":[{\"imgUrl\":\"http://ccms.miguxue.com:8081/upload/image/upload_8bc17f304e7897c8bf191fc56a1c5eb5.jpg\"}],\"href\":\"http://www.xuetangx.com/chinamobile/course/course-v1:UQx+Think101x+sp?spam=mclub\"},{\"style\":\"course1\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"\\\",\\\"studyCount\\\":\\\"3681\\\",\\\"mcp\\\":\\\"台湾交通大学\\\",\\\"mcpId\\\":\\\"\\\"}\",\"titles\":[{\"valueDesc\":\"孙子兵法与企业经营\"}],\"imgs\":[{\"imgUrl\":\"http://ccms.miguxue.com:8081/upload/image/upload_8b36908d69ed331faca896aeea2d6eb6.jpg\"}],\"href\":\"http://www.xuetangx.com/chinamobile/course/course-v1:NCTU+nctucmszb_tv+2015_T1?spam=mclub\"}]},{\"template\":\"vertical_list\",\"type\":\"list\",\"extra\":\"{\\\"marginTop\\\":\\\"10\\\",\\\"marginBottom\\\":\\\"10\\\",\\\"marginLeft\\\":\\\"10\\\",\\\"marginRight\\\":\\\"10\\\",\\\"divider\\\":\\\"\\\",\\\"dividerHeight\\\":\\\"0\\\"}\",\"items\":[{\"style\":\"course2\",\"type\":\"common\",\"device\":\"0\",\"extra\":\"{\\\"contentId\\\":\\\"\\\",\\\"studyCount\\\":\\\"1303\\\",\\\"mcp\\\":\\\"清华大学\\\",\\\"mcpId\\\":\\\"\\\"}\",\"titles\":[{\"valueDesc\":\"中国崛起的经济、历史、国际研究分析\"}],\"imgs\":[{\"imgUrl\":\"http://ccms.miguxue.com:8081/upload/image/upload_89c0443134206226f786179aa8ce74c2.jpg\"}],\"href\":\"http://www.xuetangx.com/chinamobile/course/course-v1:TsinghuaX+THU00022X_tv+2015_T1?spam=mclub\"}]}],\"name\":\"MOOC慕课\",\"device\":\"0\"}]}";
    private RecyclerView xrv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        xrv = (RecyclerView) view.findViewById(R.id.xrv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        xrv.setLayoutManager(linearLayoutManager);
        TemplateSet templateSet = GsonUtil.fromJson(jsonStr, TemplateSet.class);
        TemplateAdapter templateAdapter = new TemplateAdapter(getContext(), new ClickListener() {
            @Override
            public void onClick(String href) {
                Toast.makeText(getContext(), href, Toast.LENGTH_LONG).show();
            }
        });
        templateAdapter.setData(templateSet.getData());
        xrv.setAdapter(templateAdapter);
        return view;
    }
}
