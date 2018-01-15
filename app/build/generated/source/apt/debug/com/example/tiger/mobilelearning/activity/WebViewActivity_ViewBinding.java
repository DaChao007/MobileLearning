// Generated code from Butter Knife. Do not modify!
package com.example.tiger.mobilelearning.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.activity.mobilelearningactivity.WebViewActivity;
import com.github.barteksc.pdfviewer.PDFView;
import im.delight.android.webview.AdvancedWebView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WebViewActivity_ViewBinding<T extends WebViewActivity> implements Unbinder {
  protected T target;

  private View view2131558837;

  @UiThread
  public WebViewActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.myWebView = Utils.findRequiredViewAsType(source, R.id.myWebView, "field 'myWebView'", AdvancedWebView.class);
    target.myWebLayout = Utils.findRequiredViewAsType(source, R.id.myWebLayout, "field 'myWebLayout'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.backButImg, "field 'backButImg' and method 'onViewClicked'");
    target.backButImg = Utils.castView(view, R.id.backButImg, "field 'backButImg'", ImageView.class);
    view2131558837 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.titleText1 = Utils.findRequiredViewAsType(source, R.id.titleText, "field 'titleText1'", TextView.class);
    target.pdfView = Utils.findRequiredViewAsType(source, R.id.pdfView, "field 'pdfView'", PDFView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.myWebView = null;
    target.myWebLayout = null;
    target.backButImg = null;
    target.titleText1 = null;
    target.pdfView = null;

    view2131558837.setOnClickListener(null);
    view2131558837 = null;

    this.target = null;
  }
}
