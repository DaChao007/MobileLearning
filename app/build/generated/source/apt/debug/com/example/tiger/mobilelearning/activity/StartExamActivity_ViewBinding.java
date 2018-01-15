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
import com.example.tiger.mobilelearning.activity.mobilelearningactivity.StartExamActivity;

import java.lang.IllegalStateException;
import java.lang.Override;

public class StartExamActivity_ViewBinding<T extends StartExamActivity> implements Unbinder {
  protected T target;

  private View view2131558837;

  private View view2131558658;

  @UiThread
  public StartExamActivity_ViewBinding(final T target, View source) {
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
    target.examName = Utils.findRequiredViewAsType(source, R.id.examName, "field 'examName'", TextView.class);
    target.examNum = Utils.findRequiredViewAsType(source, R.id.examNum, "field 'examNum'", TextView.class);
    target.examTime = Utils.findRequiredViewAsType(source, R.id.examTime, "field 'examTime'", TextView.class);
    target.examFullScore = Utils.findRequiredViewAsType(source, R.id.examFullScore, "field 'examFullScore'", TextView.class);
    target.examPassPoints = Utils.findRequiredViewAsType(source, R.id.examPassPoints, "field 'examPassPoints'", TextView.class);
    view = Utils.findRequiredView(source, R.id.startExamBut, "field 'startExamBut' and method 'onViewClicked'");
    target.startExamBut = Utils.castView(view, R.id.startExamBut, "field 'startExamBut'", Button.class);
    view2131558658 = view;
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
    target.examName = null;
    target.examNum = null;
    target.examTime = null;
    target.examFullScore = null;
    target.examPassPoints = null;
    target.startExamBut = null;

    view2131558837.setOnClickListener(null);
    view2131558837 = null;
    view2131558658.setOnClickListener(null);
    view2131558658 = null;

    this.target = null;
  }
}
