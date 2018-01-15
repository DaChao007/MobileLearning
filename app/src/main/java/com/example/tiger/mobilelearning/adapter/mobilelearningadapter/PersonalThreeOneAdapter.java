package com.example.tiger.mobilelearning.adapter.mobilelearningadapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.activity.mobilelearningactivity.PersonalLearningProgressActivity;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.OfflineReviewBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.PersonalExamBean;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.POfflineReviewImpl;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.OfflineReviewView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tiger on 2017/12/12.
 * 个人考试查询里 章节和素材
 */

public class PersonalThreeOneAdapter extends BaseExpandableListAdapter {

    private static final String TAG = "PersonalThreeAdapter";
    private static final String REQUESTSUCCESS = "0";

    private static final int WUKAOSHI = 3;
    private static final int WEIKSOHI = 2;
    private static final int WEITONGGUO = 0;
    private static final int YITONGGUO = 1;

    private boolean isupData;

    private Context context;
    private ArrayList<PersonalExamBean.DataBean.ChapterExmBean> list;
    private GroupViewHolder holder;
    private ChildViewHolder holder1;

    public PersonalThreeOneAdapter(boolean isupData, Context context, ArrayList<PersonalExamBean.DataBean.ChapterExmBean> list) {
        this.isupData = isupData;
        this.context = context;
        this.list = list;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return list.get(groupPosition).getSourceExm().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).getSourceExm().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holder = new GroupViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_personalexamtwo, null);
            holder.itemName = (TextView) convertView.findViewById(R.id.itemNameTwo);
            holder.itemIsExam = (TextView) convertView.findViewById(R.id.itemIsExamTwo);
            holder.itemNoby = (TextView) convertView.findViewById(R.id.itemNobyTwo);
            holder.itemDown = (ImageView) convertView.findViewById(R.id.itemDownTwo);
            convertView.setTag(holder);
        } else {
            holder = (GroupViewHolder) convertView.getTag();
        }
        PersonalExamBean.DataBean.ChapterExmBean chapterExmBean = list.get(groupPosition);
        holder.itemName.setText("  "+chapterExmBean.getChapterTitle());
//        setStatus(holder.itemIsExam, chapterExmBean.getExamStatus());
        return convertView;
    }

    private void setStatus(TextView textView, int examStatus) {
        switch (examStatus) {
            case WUKAOSHI:
                textView.setText("无考试");
                break;
            case WEIKSOHI:
                textView.setText("未考试");
                break;
            case WEITONGGUO:
                textView.setText("未通过");
                break;
            case YITONGGUO:
                textView.setText("已通过");
                break;
        }
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holder1 = new ChildViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_personalexamthree, null);
            holder1.itemName = (TextView) convertView.findViewById(R.id.itemNameThree);
            holder1.itemIsExam = (TextView) convertView.findViewById(R.id.itemIsExamThree);
            holder1.itemDown = (ImageView) convertView.findViewById(R.id.itemDownThree);
            holder1.itemNoby = (TextView) convertView.findViewById(R.id.itemNobyThree);
            convertView.setTag(holder1);
        } else {
            holder1 = (ChildViewHolder) convertView.getTag();
        }
        final PersonalExamBean.DataBean.ChapterExmBean.SourceExmBean sourceExmBean = list.get(groupPosition).getSourceExm().get(childPosition);
        holder1.itemName.setText(sourceExmBean.getSourceTitle());
        setStatus(holder1.itemIsExam, sourceExmBean.getExamStatus());
        if (isupData) {
            setIsBy(holder1.itemDown, holder1.itemNoby, sourceExmBean.getOfflinePassed());
            holder1.itemDown.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    switch (sourceExmBean.getOfflinePassed()) {
                        case WEITONGGUO:
                            SharedPreferences user = context.getSharedPreferences("user", Context.MODE_PRIVATE);
                            Map<String, Object> map = new HashMap();
                            map.put("userId", PersonalLearningProgressActivity.id);
                            map.put("type", 3);
                            map.put("typeId", sourceExmBean.getSourceId());
                            map.put("offlinePassed", 1);
                            new POfflineReviewImpl(new OfflineReviewView() {
                                @Override
                                public void OnSucceed(OfflineReviewBean bean) {
                                    if (REQUESTSUCCESS.equals(bean.getResultCode())) {
                                        Toast.makeText(context, "操作成功！", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(context, "操作失败！", Toast.LENGTH_SHORT).show();
                                    }
                                    Log.e(TAG, PersonalLearningProgressActivity.id + "--" + sourceExmBean.getSourceId() + "--" + 1);
                                }

                                @Override
                                public void OnDefeated(String error) {
                                    Log.e(TAG, "请求失败！" + error);
                                }
                            }, user.getString("token", null)).getSuccess(map);
//                        holder1.itemDown.setImageResource(R.drawable.img_open);
                            notifyDataSetChanged();
                            break;
                        case YITONGGUO:
                            SharedPreferences user1 = context.getSharedPreferences("user", Context.MODE_PRIVATE);
                            Map map1 = new HashMap();
                            map1.put("userId", PersonalLearningProgressActivity.id);
                            map1.put("type", 3);
                            map1.put("typeId", sourceExmBean.getSourceId());
                            map1.put("offlinePassed", 0);
                            new POfflineReviewImpl(new OfflineReviewView() {
                                @Override
                                public void OnSucceed(OfflineReviewBean bean) {
                                    if (REQUESTSUCCESS.equals(bean.getResultCode())) {
                                        Toast.makeText(context, "操作成功！", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(context, "操作失败！", Toast.LENGTH_SHORT).show();
                                    }
                                    Log.e(TAG, PersonalLearningProgressActivity.id + "--" + sourceExmBean.getSourceId() + "--" + 0);
                                }

                                @Override
                                public void OnDefeated(String error) {
                                    Log.e(TAG, "请求失败！" + error);
                                }
                            }, user1.getString("token", null)).getSuccess(map1);
//                        holder1.itemDown.setImageResource(R.drawable.img_close);
                            notifyDataSetChanged();
                            break;
                    }
                }
            });
        }else {
            holder1.itemDown.setVisibility(View.GONE);
            holder1.itemNoby.setVisibility(View.VISIBLE);
            setStatus(holder1.itemNoby,sourceExmBean.getOfflinePassed());
        }
        return convertView;
    }

    private void setIsBy(final ImageView imageView, TextView textView, final int offlinePassed) {
        switch (offlinePassed) {
            case WEITONGGUO:
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageResource(R.drawable.img_close);
                textView.setVisibility(View.GONE);
                break;
            case YITONGGUO:
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageResource(R.drawable.img_open);
                textView.setVisibility(View.GONE);
                break;
            case WUKAOSHI:
                imageView.setVisibility(View.GONE);
                textView.setVisibility(View.VISIBLE);
                break;
        }
    }

    class GroupViewHolder {
        TextView itemName, itemIsExam, itemNoby;
        ImageView itemDown;
    }

    class ChildViewHolder {
        TextView itemName, itemIsExam, itemNoby;
        ImageView itemDown;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // 根据方法名，此处应该表示二级条目是否可以被点击   先返回true 再讲
        return true;
    }
}
