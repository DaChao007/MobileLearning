package com.example.tiger.mobilelearning.adapter.mobilelearningadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.HistoryRecordBean;

import java.util.ArrayList;


/**
 * 历史记录的adapter
 */

public class MyHistoryRecordAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<HistoryRecordBean.DataBean> list;
    private ViewHolder viewHolder;

    public MyHistoryRecordAdapter(Context context, ArrayList<HistoryRecordBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_myhistory, null);
            viewHolder.itemMyHistoryImg = (ImageView) convertView.findViewById(R.id.itemMyHistoryImg);
            viewHolder.itemMyHistoryName = (TextView) convertView.findViewById(R.id.itemMyHistoryName);
            viewHolder.itemMyHistoryTime = (TextView) convertView.findViewById(R.id.itemMyHistoryTime);
            viewHolder.itemMyHistoryType = (TextView) convertView.findViewById(R.id.itemMyHistoryType);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        HistoryRecordBean.DataBean dataBean = list.get(position);
        if (dataBean.getSourceType() == 3 || dataBean.getSourceType() == 2) {
            Glide.with(context).load(R.drawable.img_historyrecordvideo).into(viewHolder.itemMyHistoryImg);
        } else {
            Glide.with(context).load(R.drawable.img_historyrecordword).into(viewHolder.itemMyHistoryImg);
        }
        viewHolder.itemMyHistoryName.setText(dataBean.getSourceName());
        viewHolder.itemMyHistoryType.setText("课程分类:" + dataBean.getCourseName());
        if (dataBean.getFinished() == 1) {
            viewHolder.itemMyHistoryTime.setText("已学完");
        } else {
            viewHolder.itemMyHistoryTime.setText(secondToTime(Integer.parseInt(dataBean.getViewProgress())));
        }
        return convertView;
    }

    /**
     * 将秒数转换为日时分秒，
     *
     * @param second
     * @return
     */
    public static String secondToTime(long second) {
        long days = second / 86400;            //转换天数
        second = second % 86400;            //剩余秒数
        long hours = second / 3600;            //转换小时
        second = second % 3600;                //剩余秒数
        long minutes = second / 60;            //转换分钟
        second = second % 60;                //剩余秒数
        /*if(days>0){
            return days + "天" + hours + "小时" + minutes + "分" + second + "秒";
        }else{
            return hours + "小时" + minutes + "分" + second + "秒";
        }*/
        if (hours > 0) {
            return hours + "小时" + minutes + "分" + second + "秒";
        } else {
            return minutes + "分" + second + "秒";
        }
    }

    class ViewHolder {
        private TextView itemMyHistoryName, itemMyHistoryTime, itemMyHistoryType;
        private ImageView itemMyHistoryImg;
    }

}
