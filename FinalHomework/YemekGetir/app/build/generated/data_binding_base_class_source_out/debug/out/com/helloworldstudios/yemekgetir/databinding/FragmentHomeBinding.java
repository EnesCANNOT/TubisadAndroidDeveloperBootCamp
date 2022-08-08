// Generated by data binding compiler. Do not edit!
package com.helloworldstudios.yemekgetir.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.helloworldstudios.yemekgetir.R;
import com.helloworldstudios.yemekgetir.ui.adapter.YemeklerAdapter;
import com.helloworldstudios.yemekgetir.ui.fragment.HomeFragment;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentHomeBinding extends ViewDataBinding {
  @NonNull
  public final Button buttonAZ;

  @NonNull
  public final Button buttonDescending;

  @NonNull
  public final Button buttonPriceAscending;

  @NonNull
  public final Button buttonZA;

  @NonNull
  public final RecyclerView rvYemek;

  @NonNull
  public final SearchView searchView;

  @Bindable
  protected HomeFragment mHomeFragmentObject;

  @Bindable
  protected YemeklerAdapter mYemeklerAdapter;

  protected FragmentHomeBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button buttonAZ, Button buttonDescending, Button buttonPriceAscending, Button buttonZA,
      RecyclerView rvYemek, SearchView searchView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.buttonAZ = buttonAZ;
    this.buttonDescending = buttonDescending;
    this.buttonPriceAscending = buttonPriceAscending;
    this.buttonZA = buttonZA;
    this.rvYemek = rvYemek;
    this.searchView = searchView;
  }

  public abstract void setHomeFragmentObject(@Nullable HomeFragment homeFragmentObject);

  @Nullable
  public HomeFragment getHomeFragmentObject() {
    return mHomeFragmentObject;
  }

  public abstract void setYemeklerAdapter(@Nullable YemeklerAdapter yemeklerAdapter);

  @Nullable
  public YemeklerAdapter getYemeklerAdapter() {
    return mYemeklerAdapter;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_home, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentHomeBinding>inflateInternal(inflater, R.layout.fragment_home, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_home, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentHomeBinding>inflateInternal(inflater, R.layout.fragment_home, null, false, component);
  }

  public static FragmentHomeBinding bind(@NonNull View view) {
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
  public static FragmentHomeBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentHomeBinding)bind(component, view, R.layout.fragment_home);
  }
}
