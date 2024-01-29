package com.openclassrooms.myfragmentapp.Controllers.Activities.ChildActivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.openclassrooms.myfragmentapp.Controllers.Activities.ParentActivity.BaseActivity;
import com.openclassrooms.myfragmentapp.Controllers.Fragments.ChildFragments.DetailFragment;
import com.openclassrooms.myfragmentapp.R;
public class DetailActivity extends BaseActivity {

    //FOR DATA
    public static final String EXTRA_BUTTON_TAG = "com.openclassrooms.myfragmentapp.Controllers.Activities.ChildActivities.DetailActivity.EXTRA_BUTTON_TAG";
    private DetailFragment detailFragment;


    // --------------
    // BASE METHODS
    // --------------

    @Override
    protected int getFragmentLayout() { return R.layout.activity_detail; }

    @Override
    protected void configureDesign() {
        this.configureAndShowDetailFragment();
        this.configureToolbar();
        this.configureUpButton();
    }

    @Override
    protected void updateDesign() {
        this.updateDetailFragmentTextViewWithIntentTag();
    }

    // --------------
    // FRAGMENTS
    // --------------

    private void configureAndShowDetailFragment(){
        detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);

        if (detailFragment == null) {
            detailFragment = new DetailFragment();
            this.showFragment(detailFragment, R.id.frame_layout_detail);
        }
    }

    // --------------
    // UPDATE UI
    // --------------

    private void updateDetailFragmentTextViewWithIntentTag(){
        int buttonTag = getIntent().getIntExtra(EXTRA_BUTTON_TAG, 0);
        detailFragment.updateTextView(buttonTag);
    }
}

