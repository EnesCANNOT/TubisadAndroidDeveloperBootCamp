package com.helloworldstudios.yemekgetir.databinding;
import com.helloworldstudios.yemekgetir.R;
import com.helloworldstudios.yemekgetir.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentForgotPasswordBindingImpl extends FragmentForgotPasswordBinding implements com.helloworldstudios.yemekgetir.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.textInputLayout5, 4);
        sViewsWithIds.put(R.id.etEmailFromForgotPasswordFragment, 5);
        sViewsWithIds.put(R.id.toolbar, 6);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    @Nullable
    private final android.view.View.OnClickListener mCallback4;
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentForgotPasswordBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private FragmentForgotPasswordBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[1]
            , (com.google.android.material.textfield.TextInputEditText) bindings[5]
            , (com.google.android.material.textfield.TextInputLayout) bindings[4]
            , (androidx.appcompat.widget.Toolbar) bindings[6]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[2]
            );
        this.button.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvLoginFromForgotPasswordFragment.setTag(null);
        this.tvNewAccountFromForgotPasswordFragment.setTag(null);
        setRootTag(root);
        // listeners
        mCallback3 = new com.helloworldstudios.yemekgetir.generated.callback.OnClickListener(this, 2);
        mCallback4 = new com.helloworldstudios.yemekgetir.generated.callback.OnClickListener(this, 3);
        mCallback2 = new com.helloworldstudios.yemekgetir.generated.callback.OnClickListener(this, 1);
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
        if (BR.forgotPasswordObject == variableId) {
            setForgotPasswordObject((com.helloworldstudios.yemekgetir.ForgotPasswordFragment) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setForgotPasswordObject(@Nullable com.helloworldstudios.yemekgetir.ForgotPasswordFragment ForgotPasswordObject) {
        this.mForgotPasswordObject = ForgotPasswordObject;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.forgotPasswordObject);
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
        com.helloworldstudios.yemekgetir.ForgotPasswordFragment forgotPasswordObject = mForgotPasswordObject;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.button.setOnClickListener(mCallback2);
            this.tvLoginFromForgotPasswordFragment.setOnClickListener(mCallback4);
            this.tvNewAccountFromForgotPasswordFragment.setOnClickListener(mCallback3);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // forgotPasswordObject != null
                boolean forgotPasswordObjectJavaLangObjectNull = false;
                // forgotPasswordObject
                com.helloworldstudios.yemekgetir.ForgotPasswordFragment forgotPasswordObject = mForgotPasswordObject;



                forgotPasswordObjectJavaLangObjectNull = (forgotPasswordObject) != (null);
                if (forgotPasswordObjectJavaLangObjectNull) {


                    forgotPasswordObject.newAccount();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // forgotPasswordObject != null
                boolean forgotPasswordObjectJavaLangObjectNull = false;
                // forgotPasswordObject
                com.helloworldstudios.yemekgetir.ForgotPasswordFragment forgotPasswordObject = mForgotPasswordObject;



                forgotPasswordObjectJavaLangObjectNull = (forgotPasswordObject) != (null);
                if (forgotPasswordObjectJavaLangObjectNull) {


                    forgotPasswordObject.login();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // forgotPasswordObject != null
                boolean forgotPasswordObjectJavaLangObjectNull = false;
                // forgotPasswordObject
                com.helloworldstudios.yemekgetir.ForgotPasswordFragment forgotPasswordObject = mForgotPasswordObject;



                forgotPasswordObjectJavaLangObjectNull = (forgotPasswordObject) != (null);
                if (forgotPasswordObjectJavaLangObjectNull) {


                    if ((etEmailFromForgotPasswordFragment) != (null)) {


                        etEmailFromForgotPasswordFragment.getText();
                        if ((etEmailFromForgotPasswordFragment.getText()) != (null)) {


                            etEmailFromForgotPasswordFragment.getText().toString();
                            if ((etEmailFromForgotPasswordFragment.getText().toString()) != (null)) {


                                etEmailFromForgotPasswordFragment.getText().toString().trim();

                                forgotPasswordObject.resetPassword(etEmailFromForgotPasswordFragment.getText().toString().trim());
                            }
                        }
                    }
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): forgotPasswordObject
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}