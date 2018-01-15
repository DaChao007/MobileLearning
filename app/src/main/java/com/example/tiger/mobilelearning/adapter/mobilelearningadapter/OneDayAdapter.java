package com.example.tiger.mobilelearning.adapter.mobilelearningadapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.activity.CourseDetailsActivity;
import com.example.tiger.mobilelearning.activity.mobilelearningactivity.WordActivity;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.NewNoviceShoolBean;
import com.example.tiger.mobilelearning.view.NoScrollGridView;

import java.util.ArrayList;

/**
 * Created by Tiger on 2017/11/30.
 * 新手学堂里每一天里的Adapter
 */

public class OneDayAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<NewNoviceShoolBean.DataBean.CoursesBean.ChaptersBean> list;
    private ViewHolder holder;
    private int pId;
    private int kId;

    public OneDayAdapter(Context context, ArrayList<NewNoviceShoolBean.DataBean.CoursesBean.ChaptersBean> list, int pId, int kId) {
        this.context = context;
        this.list = list;
        this.pId = pId;
        this.kId = kId;
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
            convertView = View.inflate(context, R.layout.item_courseone, null);
            ArrayList<NewNoviceShoolBean.DataBean.CoursesBean.ChaptersBean.SourcesBean> sources = (ArrayList<NewNoviceShoolBean.DataBean.CoursesBean.ChaptersBean.SourcesBean>) list.get(position).getSources();
            holder = new ViewHolder(convertView, sources,list.get(position).getId());
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.courseName.setText(list.get(position).getTitle());
        return convertView;
    }

    class ViewHolder {

        NoScrollGridView gridView;
        OneDayGridAdapter adapter;
        TextView courseName;
        ImageView courseStatus;
        ArrayList<NewNoviceShoolBean.DataBean.CoursesBean.ChaptersBean.SourcesBean> list;

        public ViewHolder(View view, ArrayList<NewNoviceShoolBean.DataBean.CoursesBean.ChaptersBean.SourcesBean> list,int zId) {
            this.list = list;
            courseName = (TextView) view.findViewById(R.id.courseName);
            courseStatus = (ImageView) view.findViewById(R.id.courseStatus);
            gridView = (NoScrollGridView) view.findViewById(R.id.courseoneGridView);
            //将adapter定义在此，优化滑动效果(核心)
            if (list.size() > 0) {
                adapter = new OneDayGridAdapter(context, list);
                //在此设置适配器，数据源在getView中添加(核心)
                gridView.setAdapter(adapter);
            }
            setOnlistener(zId);
            view.setTag(this);
        }

        private void setOnlistener(final int zId) {
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    NewNoviceShoolBean.DataBean.CoursesBean.ChaptersBean.SourcesBean sourcesBean = list.get(position);
                    setImg(sourcesBean.getSourceType(), list.get(position),pId,kId, zId);
                }
            });
        }

        private void setImg( int sourceType, final NewNoviceShoolBean.DataBean.CoursesBean.ChaptersBean.SourcesBean sourcesBean,int pId,int kId,int zId) {

            switch (sourceType) {
                case 2:

                    Intent intent = new Intent(context, CourseDetailsActivity.class);
                    intent.putExtra("data", sourcesBean);
                    intent.putExtra("pId", pId);
                    intent.putExtra("kId", kId);
                    intent.putExtra("zId", zId);
                    context.startActivity(intent);

                    break;

                case 3:

                    Intent intent1 = new Intent(context, CourseDetailsActivity.class);
                    intent1.putExtra("data", sourcesBean);
                    intent1.putExtra("pId", pId);
                    intent1.putExtra("kId", kId);
                    intent1.putExtra("zId", zId);
                    context.startActivity(intent1);

                    break;

                default:
                    Intent intent2 = new Intent(context, WordActivity.class);
                    intent2.putExtra("data1", sourcesBean);
                    intent2.putExtra("pId", pId);
                    intent2.putExtra("kId", kId);
                    intent2.putExtra("zId", zId);
                    context.startActivity(intent2);
                   /* Uri uri1=Uri.parse(sourcesBean.getSourceRefLink());
                    Intent it1=new Intent(Intent.ACTION_VIEW,uri1);
                    context.startActivity(it1);*/

                    break;
            }
        }
    }
}
