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
import com.example.tiger.mobilelearning.entity.mobilelearningentity.NotBoundBean;

import java.util.ArrayList;


/**
 * 新增人员界面的adapter
 */

public class AddStaffAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<NotBoundBean.DataBean> list;
    private ViewHolder viewHolder;
    private CallbackAdd mCallback;

    public AddStaffAdapter(Context context, ArrayList<NotBoundBean.DataBean> list, CallbackAdd mCallback) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_addstaffitem, null);
            viewHolder.addstaffImg = (ImageView) convertView.findViewById(R.id.addstaffImg);
            viewHolder.addstaffName = (TextView) convertView.findViewById(R.id.addstaffName);
            viewHolder.addstaffTime = (TextView) convertView.findViewById(R.id.addstaffTime);
            viewHolder.itemUpImg = (RelativeLayout) convertView.findViewById(R.id.itemUpImg);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        NotBoundBean.DataBean dataBean = list.get(position);
        viewHolder.addstaffName.setText(dataBean.getEmployeeName());
        viewHolder.addstaffTime.setText(dataBean.getLastEntryDate());
        Glide.with(context).load(R.drawable.img_close).into(viewHolder.addstaffImg);
        viewHolder.itemUpImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.click(position);
            }
        });
        return convertView;
    }

    class ViewHolder {
        private TextView addstaffName, addstaffTime;
        private ImageView addstaffImg;
        private RelativeLayout itemUpImg;
    }


    public interface CallbackAdd {
        void click(int pos);
    }
}
