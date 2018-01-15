// Generated code from Butter Knife. Do not modify!
package com.example.tiger.mobilelearning.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.tiger.mobilelearning.R;
import com.zhy.android.percent.support.PercentRelativeLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyRecordActivity_ViewBinding<T extends MyRecordActivity> implements Unbinder {
  protected T target;

  private View view2131558824;

  private View view2131558608;

  private View view2131558609;

  private View view2131558610;

  private View view2131558611;

  private View view2131558612;

  private View view2131558613;

  @UiThread
  public MyRecordActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.backButImg, "field 'backButImg' and method 'onViewClicked'");
    target.backButImg = Utils.castView(view, R.id.backButImg, "field 'backButImg'", ImageView.class);
    view2131558824 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.titleText = Utils.findRequiredViewAsType(source, R.id.titleText, "field 'titleText'", TextView.class);
    target.myName = Utils.findRequiredViewAsType(source, R.id.myName, "field 'myName'", TextView.class);
    target.learnTodayTime = Utils.findRequiredViewAsType(source, R.id.learnTodayTime, "field 'learnTodayTime'", TextView.class);
    target.learningCourseNum = Utils.findRequiredViewAsType(source, R.id.learningCourseNum, "field 'learningCourseNum'", TextView.class);
    target.haveFinished = Utils.findRequiredViewAsType(source, R.id.haveFinished, "field 'haveFinished'", TextView.class);
    view = Utils.findRequiredView(source, R.id.imgHead, "field 'imgHead' and method 'onViewClicked'");
    target.imgHead = Utils.castView(view, R.id.imgHead, "field 'imgHead'", ImageView.class);
    view2131558608 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.trainerRelative, "field 'trainerRelative' and method 'onViewClicked'");
    target.trainerRelative = Utils.castView(view, R.id.trainerRelative, "field 'trainerRelative'", PercentRelativeLayout.class);
    view2131558609 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.courseRelative, "field 'courseRelative' and method 'onViewClicked'");
    target.courseRelative = Utils.castView(view, R.id.courseRelative, "field 'courseRelative'", PercentRelativeLayout.class);
    view2131558610 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.feedbackRelative, "field 'feedbackRelative' and method 'onViewClicked'");
    target.feedbackRelative = Utils.castView(view, R.id.feedbackRelative, "field 'feedbackRelative'", PercentRelativeLayout.class);
    view2131558611 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.changePasswordRelative, "field 'changePasswordRelative' and method 'onViewClicked'");
    target.changePasswordRelative = Utils.castView(view, R.id.changePasswordRelative, "field 'changePasswordRelative'", PercentRelativeLayout.class);
    view2131558612 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.cleanupthecacheRelative, "field 'cleanupthecacheRelative' and method 'onViewClicked'");
    target.cleanupthecacheRelative = Utils.castView(view, R.id.cleanupthecacheRelative, "field 'cleanupthecacheRelative'", PercentRelativeLayout.class);
    view2131558613 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.myPosition = Utils.findRequiredViewAsType(source, R.id.myPosition, "field 'myPosition'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.backButImg = null;
    target.titleText = null;
    target.myName = null;
    target.learnTodayTime = null;
    target.learningCourseNum = null;
    target.haveFinished = null;
    target.imgHead = null;
    target.trainerRelative = null;
    target.courseRelative = null;
    target.feedbackRelative = null;
    target.changePasswordRelative = null;
    target.cleanupthecacheRelative = null;
    target.myPosition = null;

    view2131558824.setOnClickListener(null);
    view2131558824 = null;
    view2131558608.setOnClickListener(null);
    view2131558608 = null;
    view2131558609.setOnClickListener(null);
    view2131558609 = null;
    view2131558610.setOnClickListener(null);
    view2131558610 = null;
    view2131558611.setOnClickListener(null);
    view2131558611 = null;
    view2131558612.setOnClickListener(null);
    view2131558612 = null;
    view2131558613.setOnClickListener(null);
    view2131558613 = null;

    this.target = null;
  }
}
