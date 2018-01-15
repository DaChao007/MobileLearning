package com.example.tiger.mobilelearning.adapter.mobilelearningadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.BoundBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Tiger on 2017/12/11.
 * 人员绑定界面ListView的Adapter
 */

public class StaffBindingAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<BoundBean.DataBean> list;
    private ViewHolder viewHolder;
    private Callback mCallback;

    public StaffBindingAdapter(Context context, ArrayList<BoundBean.DataBean> list, Callback mCallback) {
        this.context = context;
        this.list = list;
        this.mCallback = mCallback;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_staffbindingitem, null);
            viewHolder.staffBindingImg = (ImageView) convertView.findViewById(R.id.itemBindingImg);
            viewHolder.staffBindingName = (TextView) convertView.findViewById(R.id.itemBindingName);
            viewHolder.staffBindingTime = (TextView) convertView.findViewById(R.id.itemBindingTime);
            viewHolder.itemUpImg = (RelativeLayout) convertView.findViewById(R.id.itemUpImg);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        BoundBean.DataBean bindUsersBean = list.get(position);
        if (bindUsersBean.getEmployeeName() != null) {
            viewHolder.staffBindingName.setText(bindUsersBean.getEmployeeName());
        }
        Glide.with(context).load(R.drawable.img_open).into(viewHolder.staffBindingImg);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        viewHolder.staffBindingTime.setText(bindUsersBean.getLastEntryDate());
        viewHolder.itemUpImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.click(position);
            }
        });
        return convertView;
    }

    class ViewHolder {
        private TextView staffBindingName, staffBindingTime;
        private ImageView staffBindingImg;
        private RelativeLayout itemUpImg;
    }

    public interface Callback {
        void click(int pos);
    }
}
