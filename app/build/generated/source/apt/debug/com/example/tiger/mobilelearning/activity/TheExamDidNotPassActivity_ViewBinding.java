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
import com.example.tiger.mobilelearning.activity.mobilelearningactivity.TheExamDidNotPassActivity;
import com.example.tiger.mobilelearning.view.RoundProgressBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TheExamDidNotPassActivity_ViewBinding<T extends TheExamDidNotPassActivity> implements Unbinder {
  protected T target;

  private View view2131558837;

  private View view2131558665;

  @UiThread
  public TheExamDidNotPassActivity_ViewBinding(final T target, View source) {
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
    target.ditNotFraction = Utils.findRequiredViewAsType(source, R.id.ditNotFraction, "field 'ditNotFraction'", TextView.class);
    target.ditNotTime = Utils.findRequiredViewAsType(source, R.id.ditNotTime, "field 'ditNotTime'", TextView.class);
    target.ditNotNum = Utils.findRequiredViewAsType(source, R.id.ditNotNum, "field 'ditNotNum'", TextView.class);
    target.ditNotAllNum = Utils.findRequiredViewAsType(source, R.id.ditNotAllNum, "field 'ditNotAllNum'", TextView.class);
    target.ditNotWrongNum = Utils.findRequiredViewAsType(source, R.id.ditNotWrongNum, "field 'ditNotWrongNum'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ditNotReturnrBut, "field 'ditNotReturnrBut' and method 'onViewClicked'");
    target.ditNotReturnrBut = Utils.castView(view, R.id.ditNotReturnrBut, "field 'ditNotReturnrBut'", Button.class);
    view2131558665 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.notRoundProgressBar = Utils.findRequiredViewAsType(source, R.id.notRoundProgressBar, "field 'notRoundProgressBar'", RoundProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.backButImg = null;
    target.titleText = null;
    target.ditNotFraction = null;
    target.ditNotTime = null;
    target.ditNotNum = null;
    target.ditNotAllNum = null;
    target.ditNotWrongNum = null;
    target.ditNotReturnrBut = null;
    target.notRoundProgressBar = null;

    view2131558837.setOnClickListener(null);
    view2131558837 = null;
    view2131558665.setOnClickListener(null);
    view2131558665 = null;

    this.target = null;
  }
}
