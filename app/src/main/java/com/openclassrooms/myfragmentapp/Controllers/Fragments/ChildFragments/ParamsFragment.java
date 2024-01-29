package com.openclassrooms.myfragmentapp.Controllers.Fragments.ChildFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.myfragmentapp.Controllers.Fragments.ParentFragment.BaseFragment;
import com.openclassrooms.myfragmentapp.R;

public class ParamsFragment extends BaseFragment {

    // --------------
    // BASE METHODS
    // --------------

    @Override
    protected BaseFragment newInstance() { return new ParamsFragment(); }

    @Override
    protected int getFragmentLayout() { return R.layout.fragment_params; }

    @Override
    protected void configureDesign() { }

    @Override
    protected void updateDesign() { }
}