package com.helloworldstudios.yemekgetir;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.helloworldstudios.yemekgetir.databinding.FragmentBaseBindingImpl;
import com.helloworldstudios.yemekgetir.databinding.FragmentCartBindingImpl;
import com.helloworldstudios.yemekgetir.databinding.FragmentForgotPasswordBindingImpl;
import com.helloworldstudios.yemekgetir.databinding.FragmentHomeBindingImpl;
import com.helloworldstudios.yemekgetir.databinding.FragmentLoginBindingImpl;
import com.helloworldstudios.yemekgetir.databinding.FragmentNewAccountBindingImpl;
import com.helloworldstudios.yemekgetir.databinding.FragmentProfileBindingImpl;
import com.helloworldstudios.yemekgetir.databinding.FragmentSuccessfullyLoginSplashBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_FRAGMENTBASE = 1;

  private static final int LAYOUT_FRAGMENTCART = 2;

  private static final int LAYOUT_FRAGMENTFORGOTPASSWORD = 3;

  private static final int LAYOUT_FRAGMENTHOME = 4;

  private static final int LAYOUT_FRAGMENTLOGIN = 5;

  private static final int LAYOUT_FRAGMENTNEWACCOUNT = 6;

  private static final int LAYOUT_FRAGMENTPROFILE = 7;

  private static final int LAYOUT_FRAGMENTSUCCESSFULLYLOGINSPLASH = 8;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(8);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.helloworldstudios.yemekgetir.R.layout.fragment_base, LAYOUT_FRAGMENTBASE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.helloworldstudios.yemekgetir.R.layout.fragment_cart, LAYOUT_FRAGMENTCART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.helloworldstudios.yemekgetir.R.layout.fragment_forgot_password, LAYOUT_FRAGMENTFORGOTPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.helloworldstudios.yemekgetir.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.helloworldstudios.yemekgetir.R.layout.fragment_login, LAYOUT_FRAGMENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.helloworldstudios.yemekgetir.R.layout.fragment_new_account, LAYOUT_FRAGMENTNEWACCOUNT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.helloworldstudios.yemekgetir.R.layout.fragment_profile, LAYOUT_FRAGMENTPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.helloworldstudios.yemekgetir.R.layout.fragment_successfully_login_splash, LAYOUT_FRAGMENTSUCCESSFULLYLOGINSPLASH);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_FRAGMENTBASE: {
          if ("layout/fragment_base_0".equals(tag)) {
            return new FragmentBaseBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_base is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCART: {
          if ("layout/fragment_cart_0".equals(tag)) {
            return new FragmentCartBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_cart is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFORGOTPASSWORD: {
          if ("layout/fragment_forgot_password_0".equals(tag)) {
            return new FragmentForgotPasswordBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_forgot_password is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOME: {
          if ("layout/fragment_home_0".equals(tag)) {
            return new FragmentHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTLOGIN: {
          if ("layout/fragment_login_0".equals(tag)) {
            return new FragmentLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_login is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTNEWACCOUNT: {
          if ("layout/fragment_new_account_0".equals(tag)) {
            return new FragmentNewAccountBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_new_account is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPROFILE: {
          if ("layout/fragment_profile_0".equals(tag)) {
            return new FragmentProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSUCCESSFULLYLOGINSPLASH: {
          if ("layout/fragment_successfully_login_splash_0".equals(tag)) {
            return new FragmentSuccessfullyLoginSplashBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_successfully_login_splash is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(9);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "baseFragmentObject");
      sKeys.put(2, "cartFragmentObject");
      sKeys.put(3, "forgotPasswordObject");
      sKeys.put(4, "homeFragmentObject");
      sKeys.put(5, "loginFragmentObject");
      sKeys.put(6, "newAccountObject");
      sKeys.put(7, "profileFragmentObject");
      sKeys.put(8, "successfullyLoginSplashFragmentObject");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(8);

    static {
      sKeys.put("layout/fragment_base_0", com.helloworldstudios.yemekgetir.R.layout.fragment_base);
      sKeys.put("layout/fragment_cart_0", com.helloworldstudios.yemekgetir.R.layout.fragment_cart);
      sKeys.put("layout/fragment_forgot_password_0", com.helloworldstudios.yemekgetir.R.layout.fragment_forgot_password);
      sKeys.put("layout/fragment_home_0", com.helloworldstudios.yemekgetir.R.layout.fragment_home);
      sKeys.put("layout/fragment_login_0", com.helloworldstudios.yemekgetir.R.layout.fragment_login);
      sKeys.put("layout/fragment_new_account_0", com.helloworldstudios.yemekgetir.R.layout.fragment_new_account);
      sKeys.put("layout/fragment_profile_0", com.helloworldstudios.yemekgetir.R.layout.fragment_profile);
      sKeys.put("layout/fragment_successfully_login_splash_0", com.helloworldstudios.yemekgetir.R.layout.fragment_successfully_login_splash);
    }
  }
}
