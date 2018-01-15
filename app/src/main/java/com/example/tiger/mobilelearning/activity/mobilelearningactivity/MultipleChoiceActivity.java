package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.content.Context;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.adapter.mobilelearningadapter.MultipleChoiceAdapter;
import com.example.tiger.mobilelearning.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 考试题目详情页：多选
 */
public class MultipleChoiceActivity extends BaseActivity {

    @BindView(R.id.backButImg)
    ImageView backButImg;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.multipleTypeImg)
    ImageView multipleTypeImg;
    @BindView(R.id.multipleName)
    TextView multipleName;
    @BindView(R.id.multipleZongNum)
    TextView multipleZongNum;
    @BindView(R.id.multipleNum)
    TextView multipleNum;
    @BindView(R.id.multipleContent)
    TextView multipleContent;
    @BindView(R.id.multipleListView)
    ListView multipleListView;
    @BindView(R.id.upQuestionBut)
    ImageView upQuestionBut;
    @BindView(R.id.nextQuestionBut)
    ImageView nextQuestionBut;
    @BindView(R.id.countdownText)
    TextView countdownText;
    private MultipleChoiceAdapter adapter;

    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {
        multipleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView itemExamImg = (ImageView) view.findViewById(R.id.itemExamImg);
                SparseBooleanArray checkedItemPositions = multipleListView.getCheckedItemPositions();
//                setMultiple(checkedItemPositions,itemExamImg,position);
                boolean b = checkedItemPositions.get(position);
                if (b){
                    getImg(itemExamImg,position);
                }else {
                    setimg(itemExamImg,position);
                }
                adapter.notifyDataSetChanged();
            }

        });
    }


    private String setMultiple(SparseBooleanArray checkedItemPositions) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i <checkedItemPositions.size() ; i++) {
            boolean b = checkedItemPositions.get(i);
            if (b){
                String s = updataNum(i);
                buffer.append(s);
            }
        }
        return "您的选择是"+buffer.toString();
    }

    private String updataNum(int checkedItemPosition) {
        switch (checkedItemPosition) {
            case 0:
                return "A";
            case 1:
                return "B";
            case 2:
                return "C";
            case 3:
                return "D";
        }
        return "您当前无选择";
    }

    @Override
    protected void initData() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                titleText.setText("我的考试");
            }
        });
        adapter = new MultipleChoiceAdapter(this);
        multipleListView.setAdapter(adapter);
    }

    @Override
    protected void initView() {
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_multiple_choice;
    }

    @Override
    protected void destroyData() {

    }

    @OnClick({R.id.backButImg, R.id.upQuestionBut, R.id.nextQuestionBut})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.backButImg:
                this.finish();
                break;
            case R.id.upQuestionBut:
                startJump(this, TheExamDidNotPassActivity.class);
                break;
            case R.id.nextQuestionBut:
                SparseBooleanArray checkedItemPositions = multipleListView.getCheckedItemPositions();
                Toast.makeText(this, setMultiple(checkedItemPositions), Toast.LENGTH_SHORT).show();
                startJump(this, PassingTheExamActivity.class);
                break;
        }
    }

    private void startJump(Context context, Class c) {
        Intent intent = new Intent(context, c);
        startActivity(intent);
    }

    private void getImg(ImageView view, int position) {
        switch (position) {
            case 0:
                view.setImageResource(R.drawable.img_aok);
                break;
            case 1:
                view.setImageResource(R.drawable.img_bok);
                break;
            case 2:
                view.setImageResource(R.drawable.img_cok);
                break;
            case 3:
                view.setImageResource(R.drawable.img_dok);
                break;
        }
    }

    private void setimg(ImageView view, int position) {
        switch (position) {
            case 0:
                view.setImageResource(R.drawable.img_ano);
                break;
            case 1:
                view.setImageResource(R.drawable.img_bno);
                break;
            case 2:
                view.setImageResource(R.drawable.img_cno);
                break;
            case 3:
                view.setImageResource(R.drawable.img_dno);
                break;
        }
    }
}
