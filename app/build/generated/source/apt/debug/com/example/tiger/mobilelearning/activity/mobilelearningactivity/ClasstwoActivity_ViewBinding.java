// Generated code from Butter Knife. Do not modify!
package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.tiger.mobilelearning.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ClasstwoActivity_ViewBinding<T extends ClasstwoActivity> implements Unbinder {
  protected T target;

  private View view2131558837;

  @UiThread
  public ClasstwoActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.backButImg, "field 'backButImg' and method 'onViewClicked'");
    target.backButImg = Utils.castView(view, R.id.backButImg, "field 'backButImg'", ImageView.class);
    view2131558837 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.titleText = Utils.findRequiredViewAsType(source, R.id.titleText, "field 'titleText'", TextView.class);
    target.classTwoExpandable = Utils.findRequiredViewAsType(source, R.id.classTwoExpandable, "field 'classTwoExpandable'", ExpandableListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.backButImg = null;
    target.titleText = null;
    target.classTwoExpandable = null;

    view2131558837.setOnClickListener(null);
    view2131558837 = null;

    this.target = null;
  }
}
