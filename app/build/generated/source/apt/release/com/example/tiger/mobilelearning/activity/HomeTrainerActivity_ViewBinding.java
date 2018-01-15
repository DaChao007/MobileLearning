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
import com.zhy.android.percent.support.PercentRelativeLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeTrainerActivity_ViewBinding<T extends HomeTrainerActivity> implements Unbinder {
  protected T target;

  private View view2131558567;

  private View view2131558569;

  private View view2131558571;

  private View view2131558573;

  private View view2131558575;

  private View view2131558578;

  private View view2131558824;

  @UiThread
  public HomeTrainerActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.advancedSchool, "field 'advancedSchool' and method 'onViewClicked'");
    target.advancedSchool = Utils.castView(view, R.id.advancedSchool, "field 'advancedSchool'", PercentRelativeLayout.class);
    view2131558567 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.noviceSevenDays, "field 'noviceSevenDays' and method 'onViewClicked'");
    target.noviceSevenDays = Utils.castView(view, R.id.noviceSevenDays, "field 'noviceSevenDays'", PercentRelativeLayout.class);
    view2131558569 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.specialClass, "field 'specialClass' and method 'onViewClicked'");
    target.specialClass = Utils.castView(view, R.id.specialClass, "field 'specialClass'", PercentRelativeLayout.class);
    view2131558571 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.notification, "field 'notification' and method 'onViewClicked'");
    target.notification = Utils.castView(view, R.id.notification, "field 'notification'", PercentRelativeLayout.class);
    view2131558573 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.myrecord, "field 'myrecord' and method 'onViewClicked'");
    target.myrecord = Utils.castView(view, R.id.myrecord, "field 'myrecord'", PercentRelativeLayout.class);
    view2131558575 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.trainingProgram, "field 'trainingProgram' and method 'onViewClicked'");
    target.trainingProgram = Utils.castView(view, R.id.trainingProgram, "field 'trainingProgram'", PercentRelativeLayout.class);
    view2131558578 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
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
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.advancedSchool = null;
    target.noviceSevenDays = null;
    target.specialClass = null;
    target.notification = null;
    target.myrecord = null;
    target.trainingProgram = null;
    target.backButImg = null;
    target.titleText = null;

    view2131558567.setOnClickListener(null);
    view2131558567 = null;
    view2131558569.setOnClickListener(null);
    view2131558569 = null;
    view2131558571.setOnClickListener(null);
    view2131558571 = null;
    view2131558573.setOnClickListener(null);
    view2131558573 = null;
    view2131558575.setOnClickListener(null);
    view2131558575 = null;
    view2131558578.setOnClickListener(null);
    view2131558578 = null;
    view2131558824.setOnClickListener(null);
    view2131558824 = null;

    this.target = null;
  }
}
