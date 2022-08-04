package com.helloworldstudios.yemekgetir.databinding;
import com.helloworldstudios.yemekgetir.R;
import com.helloworldstudios.yemekgetir.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentNewAccountBindingImpl extends FragmentNewAccountBinding implements com.helloworldstudios.yemekgetir.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbarNewAccount, 2);
        sViewsWithIds.put(R.id.textInputLayout, 3);
        sViewsWithIds.put(R.id.etFullnameFromNewAccountFragment, 4);
        sViewsWithIds.put(R.id.textInputLayout2, 5);
        sViewsWithIds.put(R.id.etEmailFromNewAccountFragment, 6);
        sViewsWithIds.put(R.id.textInputLayout3, 7);
        sViewsWithIds.put(R.id.etPhoneNumberFromNewAccountFragment, 8);
        sViewsWithIds.put(R.id.textInputLayout4, 9);
        sViewsWithIds.put(R.id.etPassword1FromNewAccountFragment, 10);
        sViewsWithIds.put(R.id.textInputLayout6, 11);
        sViewsWithIds.put(R.id.etPassword2FromNewAccountFragment, 12);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback5;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentNewAccountBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private FragmentNewAccountBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[1]
            , (com.google.android.material.textfield.TextInputEditText) bindings[6]
            , (com.google.android.material.textfield.TextInputEditText) bindings[4]
            , (com.google.android.material.textfield.TextInputEditText) bindings[10]
            , (com.google.android.material.textfield.TextInputEditText) bindings[12]
            , (com.google.android.material.textfield.TextInputEditText) bindings[8]
            , (com.google.android.material.textfield.TextInputLayout) bindings[3]
            , (com.google.android.material.textfield.TextInputLayout) bindings[5]
            , (com.google.android.material.textfield.TextInputLayout) bindings[7]
            , (com.google.android.material.textfield.TextInputLayout) bindings[9]
            , (com.google.android.material.textfield.TextInputLayout) bindings[11]
            , (androidx.appcompat.widget.Toolbar) bindings[2]
            );
        this.buttonRegister.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback5 = new com.helloworldstudios.yemekgetir.generated.callback.OnClickListener(this, 1);
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
        if (BR.newAccountObject == variableId) {
            setNewAccountObject((com.helloworldstudios.yemekgetir.NewAccountFragment) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setNewAccountObject(@Nullable com.helloworldstudios.yemekgetir.NewAccountFragment NewAccountObject) {
        this.mNewAccountObject = NewAccountObject;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.newAccountObject);
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
        com.helloworldstudios.yemekgetir.NewAccountFragment newAccountObject = mNewAccountObject;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.buttonRegister.setOnClickListener(mCallback5);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // newAccountObject
        com.helloworldstudios.yemekgetir.NewAccountFragment newAccountObject = mNewAccountObject;
        // newAccountObject != null
        boolean newAccountObjectJavaLangObjectNull = false;



        newAccountObjectJavaLangObjectNull = (newAccountObject) != (null);
        if (newAccountObjectJavaLangObjectNull) {


            if ((etFullnameFromNewAccountFragment) != (null)) {


                etFullnameFromNewAccountFragment.getText();
                if ((etFullnameFromNewAccountFragment.getText()) != (null)) {


                    etFullnameFromNewAccountFragment.getText().toString();
                    if ((etFullnameFromNewAccountFragment.getText().toString()) != (null)) {


                        etFullnameFromNewAccountFragment.getText().toString().trim();

                        if ((etEmailFromNewAccountFragment) != (null)) {


                            etEmailFromNewAccountFragment.getText();
                            if ((etEmailFromNewAccountFragment.getText()) != (null)) {


                                etEmailFromNewAccountFragment.getText().toString();
                                if ((etEmailFromNewAccountFragment.getText().toString()) != (null)) {


                                    etEmailFromNewAccountFragment.getText().toString().trim();

                                    if ((etPhoneNumberFromNewAccountFragment) != (null)) {


                                        etPhoneNumberFromNewAccountFragment.getText();
                                        if ((etPhoneNumberFromNewAccountFragment.getText()) != (null)) {


                                            etPhoneNumberFromNewAccountFragment.getText().toString();
                                            if ((etPhoneNumberFromNewAccountFragment.getText().toString()) != (null)) {


                                                etPhoneNumberFromNewAccountFragment.getText().toString().trim();

                                                if ((etPassword1FromNewAccountFragment) != (null)) {


                                                    etPassword1FromNewAccountFragment.getText();
                                                    if ((etPassword1FromNewAccountFragment.getText()) != (null)) {


                                                        etPassword1FromNewAccountFragment.getText().toString();
                                                        if ((etPassword1FromNewAccountFragment.getText().toString()) != (null)) {


                                                            etPassword1FromNewAccountFragment.getText().toString().trim();

                                                            if ((etPassword2FromNewAccountFragment) != (null)) {


                                                                etPassword2FromNewAccountFragment.getText();
                                                                if ((etPassword2FromNewAccountFragment.getText()) != (null)) {


                                                                    etPassword2FromNewAccountFragment.getText().toString();
                                                                    if ((etPassword2FromNewAccountFragment.getText().toString()) != (null)) {


                                                                        etPassword2FromNewAccountFragment.getText().toString().trim();

                                                                        newAccountObject.register(etFullnameFromNewAccountFragment.getText().toString().trim(), etEmailFromNewAccountFragment.getText().toString().trim(), etPhoneNumberFromNewAccountFragment.getText().toString().trim(), etPassword1FromNewAccountFragment.getText().toString().trim(), etPassword2FromNewAccountFragment.getText().toString().trim());
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): newAccountObject
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}