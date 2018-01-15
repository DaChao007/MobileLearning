// Generated code from Butter Knife. Do not modify!
package com.example.tiger.mobilelearning.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.activity.mobilelearningactivity.SingleChoiceActivity;
import com.example.tiger.mobilelearning.view.NoScrollViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SingleChoiceActivity_ViewBinding<T extends SingleChoiceActivity> implements Unbinder {
  protected T target;

  private View view2131558837;

  private View view2131558601;

  private View view2131558602;

  private View view2131558649;

  @UiThread
  public SingleChoiceActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.backButImg, "field 'backButImg' and method 'onViewClicked'");
    target.backButImg = Utils.castView(view, R.id.backButImg, "field 'backButImg'", ImageView.class);
    view2131558837 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.titleText = Utils.findRequiredViewAsType(source, R.id.titleText, "field 'titleText'", TextView.class);
    target.singleTypeImg = Utils.findRequiredViewAsType(source, R.id.singleTypeImg, "field 'singleTypeImg'", ImageView.class);
    target.singleName = Utils.findRequiredViewAsType(source, R.id.singleName, "field 'singleName'", TextView.class);
    target.singleZongNum = Utils.findRequiredViewAsType(source, R.id.singleZongNum, "field 'singleZongNum'", TextView.class);
    target.countdownText = Utils.findRequiredViewAsType(source, R.id.countdownText, "field 'countdownText'", TextView.class);
    target.singleViewPager = Utils.findRequiredViewAsType(source, R.id.singleViewPager, "field 'singleViewPager'", NoScrollViewPager.class);
    view = Utils.findRequiredView(source, R.id.upQuestionBut, "method 'onViewClicked'");
    view2131558601 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.nextQuestionBut, "method 'onViewClicked'");
    view2131558602 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.carryOut, "method 'onViewClicked'");
    view2131558649 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.backButImg = null;
    target.titleText = null;
    target.singleTypeImg = null;
    target.singleName = null;
    target.singleZongNum = null;
    target.countdownText = null;
    target.singleViewPager = null;

    view2131558837.setOnClickListener(null);
    view2131558837 = null;
    view2131558601.setOnClickListener(null);
    view2131558601 = null;
    view2131558602.setOnClickListener(null);
    view2131558602 = null;
    view2131558649.setOnClickListener(null);
    view2131558649 = null;

    this.target = null;
  }
}
