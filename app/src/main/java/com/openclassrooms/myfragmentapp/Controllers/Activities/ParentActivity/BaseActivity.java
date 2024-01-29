package com.openclassrooms.myfragmentapp.Controllers.Activities.ParentActivity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.openclassrooms.myfragmentapp.Controllers.Fragments.ParentFragment.BaseFragment;
import com.openclassrooms.myfragmentapp.R;

import butterknife.ButterKnife;
import icepick.Icepick;

public abstract class BaseActivity extends AppCompatActivity {

    // --------------
    // BASE METHODS
    // --------------
    protected abstract int getFragmentLayout();
    protected abstract void configureDesign();
    protected abstract void updateDesign();

    // -----------------
    // METHODS OVERRIDE
    // -----------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getFragmentLayout());
        ButterKnife.bind(this);
        Icepick.restoreInstanceState(this, savedInstanceState);
        this.configureDesign();
    }

    @Override
    public void onResume() {
        super.onResume();
        this.updateDesign();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    // --------------
    // DESIGN
    // --------------
    protected void configureToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    protected void configureUpButton(){
        ActionBar ab = getSupportActionBar();
        if (ab != null) ab.setDisplayHomeAsUpEnabled(true);
    }

    // --------------
    // FRAGMENTS
    // --------------

    protected void showFragment(BaseFragment fragment, int layout){
        getSupportFragmentManager().beginTransaction()
                .add(layout, fragment)
                .commit();
    }
}