package com.helloworldstudios.yemekgetir.databinding;
import com.helloworldstudios.yemekgetir.R;
import com.helloworldstudios.yemekgetir.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentLoginBindingImpl extends FragmentLoginBinding implements com.helloworldstudios.yemekgetir.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView, 2);
        sViewsWithIds.put(R.id.textInputLayout, 3);
        sViewsWithIds.put(R.id.etPasswordFromLoginFragment, 4);
        sViewsWithIds.put(R.id.textInputLayout2, 5);
        sViewsWithIds.put(R.id.etEmailFromLoginFragment, 6);
        sViewsWithIds.put(R.id.tvForgotPasswordFromLoginFragment, 7);
        sViewsWithIds.put(R.id.tvNewAccountFromLoginFragment, 8);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentLoginBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private FragmentLoginBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[1]
            , (com.google.android.material.textfield.TextInputEditText) bindings[6]
            , (com.google.android.material.textfield.TextInputEditText) bindings[4]
            , (android.widget.ImageView) bindings[2]
            , (com.google.android.material.textfield.TextInputLayout) bindings[3]
            , (com.google.android.material.textfield.TextInputLayout) bindings[5]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[8]
            );
        this.buttonLogin.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.helloworldstudios.yemekgetir.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.loginFragmentObject == variableId) {
            setLoginFragmentObject((com.helloworldstudios.yemekgetir.LoginFragment) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setLoginFragmentObject(@Nullable com.helloworldstudios.yemekgetir.LoginFragment LoginFragmentObject) {
        this.mLoginFragmentObject = LoginFragmentObject;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.loginFragmentObject);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.helloworldstudios.yemekgetir.LoginFragment loginFragmentObject = mLoginFragmentObject;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.buttonLogin.setOnClickListener(mCallback1);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // loginFragmentObject
        com.helloworldstudios.yemekgetir.LoginFragment loginFragmentObject = mLoginFragmentObject;
        // loginFragmentObject != null
        boolean loginFragmentObjectJavaLangObjectNull = false;



        loginFragmentObjectJavaLangObjectNull = (loginFragmentObject) != (null);
        if (loginFragmentObjectJavaLangObjectNull) {


            if ((etEmailFromLoginFragment) != (null)) {


                etEmailFromLoginFragment.getText();
                if ((etEmailFromLoginFragment.getText()) != (null)) {


                    etEmailFromLoginFragment.getText().toString();

                    if ((etPasswordFromLoginFragment) != (null)) {


                        etPasswordFromLoginFragment.getText();
                        if ((etPasswordFromLoginFragment.getText()) != (null)) {


                            etPasswordFromLoginFragment.getText().toString();

                            loginFragmentObject.login(etEmailFromLoginFragment.getText().toString(), etPasswordFromLoginFragment.getText().toString());
                        }
                    }
                }
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): loginFragmentObject
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}