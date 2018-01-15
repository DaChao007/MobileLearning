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
import java.lang.IllegalStateException;
import java.lang.Override;

public class WordActivity_ViewBinding<T extends WordActivity> implements Unbinder {
  protected T target;

  private View view2131558824;

  private View view2131558664;

  private View view2131558670;

  @UiThread
  public WordActivity_ViewBinding(final T target, View source) {
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
    view = Utils.findRequiredView(source, R.id.startLearn, "field 'startLearn' and method 'onViewClicked'");
    target.startLearn = Utils.castView(view, R.id.startLearn, "field 'startLearn'", ImageView.class);
    view2131558664 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.courseWordName = Utils.findRequiredViewAsType(source, R.id.courseWordName, "field 'courseWordName'", TextView.class);
    target.courseWordObject = Utils.findRequiredViewAsType(source, R.id.courseWordObject, "field 'courseWordObject'", TextView.class);
    target.courseWordLabel = Utils.findRequiredViewAsType(source, R.id.courseWordLabel, "field 'courseWordLabel'", TextView.class);
    target.courseWordTime = Utils.findRequiredViewAsType(source, R.id.courseWordTime, "field 'courseWordTime'", TextView.class);
    target.descriptionWord = Utils.findRequiredViewAsType(source, R.id.descriptionWord, "field 'descriptionWord'", TextView.class);
    view = Utils.findRequiredView(source, R.id.butWordStartExam, "field 'butWordStartExam' and method 'onViewClicked'");
    target.butWordStartExam = Utils.castView(view, R.id.butWordStartExam, "field 'butWordStartExam'", Button.class);
    view2131558670 = view;
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
    target.startLearn = null;
    target.courseWordName = null;
    target.courseWordObject = null;
    target.courseWordLabel = null;
    target.courseWordTime = null;
    target.descriptionWord = null;
    target.butWordStartExam = null;

    view2131558824.setOnClickListener(null);
    view2131558824 = null;
    view2131558664.setOnClickListener(null);
    view2131558664 = null;
    view2131558670.setOnClickListener(null);
    view2131558670 = null;

    this.target = null;
  }
}
