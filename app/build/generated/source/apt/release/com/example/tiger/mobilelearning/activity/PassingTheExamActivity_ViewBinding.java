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
import com.example.tiger.mobilelearning.view.RoundProgressBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PassingTheExamActivity_ViewBinding<T extends PassingTheExamActivity> implements Unbinder {
  protected T target;

  private View view2131558824;

  private View view2131558632;

  @UiThread
  public PassingTheExamActivity_ViewBinding(final T target, View source) {
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
    target.passingFraction = Utils.findRequiredViewAsType(source, R.id.passingFraction, "field 'passingFraction'", TextView.class);
    target.passingTime = Utils.findRequiredViewAsType(source, R.id.passingTime, "field 'passingTime'", TextView.class);
    target.passingNum = Utils.findRequiredViewAsType(source, R.id.passingNum, "field 'passingNum'", TextView.class);
    target.passingAllNum = Utils.findRequiredViewAsType(source, R.id.passingAllNum, "field 'passingAllNum'", TextView.class);
    target.wrongNum = Utils.findRequiredViewAsType(source, R.id.wrongNum, "field 'wrongNum'", TextView.class);
    view = Utils.findRequiredView(source, R.id.passingUnderBut, "field 'passingUnderBut' and method 'onViewClicked'");
    target.passingUnderBut = Utils.castView(view, R.id.passingUnderBut, "field 'passingUnderBut'", Button.class);
    view2131558632 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.passRoundProgressBar = Utils.findRequiredViewAsType(source, R.id.passRoundProgressBar, "field 'passRoundProgressBar'", RoundProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.backButImg = null;
    target.titleText = null;
    target.passingFraction = null;
    target.passingTime = null;
    target.passingNum = null;
    target.passingAllNum = null;
    target.wrongNum = null;
    target.passingUnderBut = null;
    target.passRoundProgressBar = null;

    view2131558824.setOnClickListener(null);
    view2131558824 = null;
    view2131558632.setOnClickListener(null);
    view2131558632 = null;

    this.target = null;
  }
}
