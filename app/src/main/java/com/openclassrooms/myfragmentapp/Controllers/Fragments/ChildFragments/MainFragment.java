package com.openclassrooms.myfragmentapp.Controllers.Fragments.ChildFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.myfragmentapp.Controllers.Fragments.ParentFragment.BaseFragment;
import com.openclassrooms.myfragmentapp.R;

import butterknife.OnClick;

public class MainFragment extends BaseFragment implements View.OnClickListener {

    //CALLBACK
    public interface OnButtonClickedListener {
        public void onButtonClicked(View view);
    }
    private OnButtonClickedListener mCallback;

    // --------------
    // BASE METHODS
    // --------------

    @Override
    protected BaseFragment newInstance() { return new MainFragment(); }

    @Override
    protected int getFragmentLayout() { return R.layout.fragment_main; }

    @Override
    protected void configureDesign() { }

    @Override
    protected void updateDesign() {
        this.createCallbackToParentActivity();
    }

    // --------------
    // ACTIONS
    // --------------

    @Override
    @OnClick({ R.id.fragment_main_button_happy, R.id.fragment_main_button_sad, R.id.fragment_main_button_horrible })
    public void onClick(View v) {
        mCallback.onButtonClicked(v);
    }

    // --------------
    // FRAGMENT SUPPORT
    // --------------

    private void createCallbackToParentActivity(){
        try {
            mCallback = (OnButtonClickedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }
    }
}