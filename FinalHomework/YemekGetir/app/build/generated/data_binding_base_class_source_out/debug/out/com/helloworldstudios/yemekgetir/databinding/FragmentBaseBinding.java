// Generated by data binding compiler. Do not edit!
package com.helloworldstudios.yemekgetir.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.helloworldstudios.yemekgetir.BaseFragment;
import com.helloworldstudios.yemekgetir.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentBaseBinding extends ViewDataBinding {
  @NonNull
  public final BottomNavigationView bottomNavigationView;

  @NonNull
  public final ConstraintLayout frameLayout;

  @Bindable
  protected BaseFragment mBaseFragmentObject;

  protected FragmentBaseBinding(Object _bindingComponent, View _root, int _localFieldCount,
      BottomNavigationView bottomNavigationView, ConstraintLayout frameLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bottomNavigationView = bottomNavigationView;
    this.frameLayout = frameLayout;
  }

  public abstract void setBaseFragmentObject(@Nullable BaseFragment baseFragmentObject);

  @Nullable
  public BaseFragment getBaseFragmentObject() {
    return mBaseFragmentObject;
  }

  @NonNull
  public static FragmentBaseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_base, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentBaseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentBaseBinding>inflateInternal(inflater, R.layout.fragment_base, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentBaseBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_base, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentBaseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentBaseBinding>inflateInternal(inflater, R.layout.fragment_base, null, false, component);
  }

  public static FragmentBaseBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentBaseBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentBaseBinding)bind(component, view, R.layout.fragment_base);
  }
}
