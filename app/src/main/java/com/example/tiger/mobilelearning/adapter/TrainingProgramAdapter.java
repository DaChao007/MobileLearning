package com.example.tiger.mobilelearning.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.TrainingProgramBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Tiger on 2017/12/9.
 * 培训计划页面里的adapter
 */

public class TrainingProgramAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<TrainingProgramBean.DataBean> list;
    private ViewHolder viewHolder;

    public TrainingProgramAdapter(Context context, ArrayList<TrainingProgramBean.DataBean> list) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_trainingprogram,null);
            viewHolder.trainingName = (TextView) convertView.findViewById(R.id.trainingName);
            viewHolder.trainingRange = (TextView) convertView.findViewById(R.id.trainingRange);
            viewHolder.trainingTime = (TextView) convertView.findViewById(R.id.trainingTime);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        TrainingProgramBean.DataBean trainPlansBean = list.get(position);
        viewHolder.trainingName.setText(trainPlansBean.getTitle());
        viewHolder.trainingRange.setText(trainPlansBean.getScope());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
        //进行格式化
        viewHolder.trainingTime.setText("创建时间:"+sdf.format(new Date(trainPlansBean.getDateCreated())));
        return convertView;

    }

    class ViewHolder {
        TextView trainingName;
        TextView trainingRange;
        TextView trainingTime;
    }

    class ViewHolderNo {
        TextView trainingNameNo;
        TextView trainingRangeNo;
        TextView trainingTimeNo;
    }
}
