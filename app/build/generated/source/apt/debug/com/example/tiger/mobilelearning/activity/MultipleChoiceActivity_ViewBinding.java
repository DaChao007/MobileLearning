// Generated code from Butter Knife. Do not modify!
package com.example.tiger.mobilelearning.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.activity.mobilelearningactivity.MultipleChoiceActivity;

import java.lang.IllegalStateException;
import java.lang.Override;

public class MultipleChoiceActivity_ViewBinding<T extends MultipleChoiceActivity> implements Unbinder {
  protected T target;

  private View view2131558837;

  private View view2131558601;

  private View view2131558602;

  @UiThread
  public MultipleChoiceActivity_ViewBinding(final T target, View source) {
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
    target.multipleTypeImg = Utils.findRequiredViewAsType(source, R.id.multipleTypeImg, "field 'multipleTypeImg'", ImageView.class);
    target.multipleName = Utils.findRequiredViewAsType(source, R.id.multipleName, "field 'multipleName'", TextView.class);
    target.multipleZongNum = Utils.findRequiredViewAsType(source, R.id.multipleZongNum, "field 'multipleZongNum'", TextView.class);
    target.multipleNum = Utils.findRequiredViewAsType(source, R.id.multipleNum, "field 'multipleNum'", TextView.class);
    target.multipleContent = Utils.findRequiredViewAsType(source, R.id.multipleContent, "field 'multipleContent'", TextView.class);
    target.multipleListView = Utils.findRequiredViewAsType(source, R.id.multipleListView, "field 'multipleListView'", ListView.class);
    view = Utils.findRequiredView(source, R.id.upQuestionBut, "field 'upQuestionBut' and method 'onViewClicked'");
    target.upQuestionBut = Utils.castView(view, R.id.upQuestionBut, "field 'upQuestionBut'", ImageView.class);
    view2131558601 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.nextQuestionBut, "field 'nextQuestionBut' and method 'onViewClicked'");
    target.nextQuestionBut = Utils.castView(view, R.id.nextQuestionBut, "field 'nextQuestionBut'", ImageView.class);
    view2131558602 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.countdownText = Utils.findRequiredViewAsType(source, R.id.countdownText, "field 'countdownText'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.backButImg = null;
    target.titleText = null;
    target.multipleTypeImg = null;
    target.multipleName = null;
    target.multipleZongNum = null;
    target.multipleNum = null;
    target.multipleContent = null;
    target.multipleListView = null;
    target.upQuestionBut = null;
    target.nextQuestionBut = null;
    target.countdownText = null;

    view2131558837.setOnClickListener(null);
    view2131558837 = null;
    view2131558601.setOnClickListener(null);
    view2131558601 = null;
    view2131558602.setOnClickListener(null);
    view2131558602 = null;

    this.target = null;
  }
}
