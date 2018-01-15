package com.example.tiger.mobilelearning.adapter.mobilelearningadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.NewNoviceShoolBean;

import java.util.ArrayList;

/**
 * Created by Tiger on 2017/12/9.
 * 新手七天每一天里每一章的adapter
 */

public class OneDayGridAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<NewNoviceShoolBean.DataBean.CoursesBean.ChaptersBean.SourcesBean> list;
    private ViewHolder holder;

    public OneDayGridAdapter(Context context, ArrayList list) {
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
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_gridcourse, null);
            holder.gridCourseImg = (ImageView) convertView.findViewById(R.id.gridCourseImg);
            holder.gridCourseName = (TextView) convertView.findViewById(R.id.gridCourseName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        NewNoviceShoolBean.DataBean.CoursesBean.ChaptersBean.SourcesBean sourcesBean = list.get(position);
        holder.gridCourseName.setText(sourcesBean.getSourceTitle());
        setImg(holder.gridCourseImg, sourcesBean.getSourceType(),sourcesBean);
        return convertView;
    }

    private void setImg(ImageView img, int sourceType, final NewNoviceShoolBean.DataBean.CoursesBean.ChaptersBean.SourcesBean sourcesBean) {
        switch (sourceType) {
            case 2:
                Glide.with(context).load(R.drawable.img_mp3).into(img);
                break;
            case 3:
                Glide.with(context).load(R.drawable.img_mp4).into(img);
                break;
            default:
                Glide.with(context).load(R.drawable.img_other).into(img);
                break;
        }
    }


    class ViewHolder {
        TextView gridCourseName;
        ImageView gridCourseImg;
    }
}
