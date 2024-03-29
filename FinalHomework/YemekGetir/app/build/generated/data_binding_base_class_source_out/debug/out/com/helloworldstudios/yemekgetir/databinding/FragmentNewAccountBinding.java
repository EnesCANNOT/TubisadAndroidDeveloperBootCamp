// Generated by data binding compiler. Do not edit!
package com.helloworldstudios.yemekgetir.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.helloworldstudios.yemekgetir.R;
import com.helloworldstudios.yemekgetir.ui.fragment.NewAccountFragment;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentNewAccountBinding extends ViewDataBinding {
  @NonNull
  public final Button buttonRegister;

  @NonNull
  public final TextInputEditText etEmailFromNewAccountFragment;

  @NonNull
  public final TextInputEditText etFullnameFromNewAccountFragment;

  @NonNull
  public final TextInputEditText etPassword1FromNewAccountFragment;

  @NonNull
  public final TextInputEditText etPassword2FromNewAccountFragment;

  @NonNull
  public final TextInputEditText etPhoneNumberFromNewAccountFragment;

  @NonNull
  public final TextInputLayout textInputLayout;

  @NonNull
  public final TextInputLayout textInputLayout2;

  @NonNull
  public final TextInputLayout textInputLayout3;

  @NonNull
  public final TextInputLayout textInputLayout4;

  @NonNull
  public final TextInputLayout textInputLayout6;

  @NonNull
  public final Toolbar toolbarNewAccount;

  @Bindable
  protected NewAccountFragment mNewAccountObject;

  protected FragmentNewAccountBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button buttonRegister, TextInputEditText etEmailFromNewAccountFragment,
      TextInputEditText etFullnameFromNewAccountFragment,
      TextInputEditText etPassword1FromNewAccountFragment,
      TextInputEditText etPassword2FromNewAccountFragment,
      TextInputEditText etPhoneNumberFromNewAccountFragment, TextInputLayout textInputLayout,
      TextInputLayout textInputLayout2, TextInputLayout textInputLayout3,
      TextInputLayout textInputLayout4, TextInputLayout textInputLayout6,
      Toolbar toolbarNewAccount) {
    super(_bindingComponent, _root, _localFieldCount);
    this.buttonRegister = buttonRegister;
    this.etEmailFromNewAccountFragment = etEmailFromNewAccountFragment;
    this.etFullnameFromNewAccountFragment = etFullnameFromNewAccountFragment;
    this.etPassword1FromNewAccountFragment = etPassword1FromNewAccountFragment;
    this.etPassword2FromNewAccountFragment = etPassword2FromNewAccountFragment;
    this.etPhoneNumberFromNewAccountFragment = etPhoneNumberFromNewAccountFragment;
    this.textInputLayout = textInputLayout;
    this.textInputLayout2 = textInputLayout2;
    this.textInputLayout3 = textInputLayout3;
    this.textInputLayout4 = textInputLayout4;
    this.textInputLayout6 = textInputLayout6;
    this.toolbarNewAccount = toolbarNewAccount;
  }

  public abstract void setNewAccountObject(@Nullable NewAccountFragment newAccountObject);

  @Nullable
  public NewAccountFragment getNewAccountObject() {
    return mNewAccountObject;
  }

  @NonNull
  public static FragmentNewAccountBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_new_account, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentNewAccountBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentNewAccountBinding>inflateInternal(inflater, R.layout.fragment_new_account, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentNewAccountBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_new_account, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentNewAccountBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentNewAccountBinding>inflateInternal(inflater, R.layout.fragment_new_account, null, false, component);
  }

  public static FragmentNewAccountBinding bind(@NonNull View view) {
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
  public static FragmentNewAccountBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentNewAccountBinding)bind(component, view, R.layout.fragment_new_account);
  }
}
