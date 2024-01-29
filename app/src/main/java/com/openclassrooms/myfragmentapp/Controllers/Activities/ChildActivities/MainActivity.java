package com.openclassrooms.myfragmentapp.Controllers.Activities.ChildActivities;


import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.openclassrooms.myfragmentapp.Controllers.Activities.ParentActivity.BaseActivity;
import com.openclassrooms.myfragmentapp.Controllers.Fragments.ChildFragments.DetailFragment;
import com.openclassrooms.myfragmentapp.Controllers.Fragments.ChildFragments.MainFragment;
import com.openclassrooms.myfragmentapp.R;

public class MainActivity extends BaseActivity implements MainFragment.OnButtonClickedListener {

    //FOR DATA
    private MainFragment mainFragment;
    private DetailFragment detailFragment;

    // --------------
    // BASE METHODS
    // --------------
    @Override
    protected int getFragmentLayout() { return R.layout.activity_main;  }

    @Override
    protected void configureDesign() {
        this.configureAndShowMainFragment();
        this.configureAndShowDetailFragment();
        this.configureToolbar();
    }

    @Override
    protected void updateDesign() { }

    // -----------------
    // METHODS OVERRIDE
    // -----------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_activity_main_params:
                this.showParamsActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // --------------
    // CALLBACK
    // --------------

    @Override
    public void onButtonClicked(View view) {

        int buttonTag = Integer.parseInt(view.getTag().toString());

        if (detailFragment != null && detailFragment.isVisible()) {
            detailFragment.updateTextView(buttonTag);
        } else {
            this.showDetailActivity(buttonTag);
        }
    }


    // --------------
    // FRAGMENTS
    // --------------

    private void configureAndShowMainFragment(){
        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_main);

        if (mainFragment == null) {
            mainFragment = new MainFragment();
            this.showFragment(mainFragment, R.id.frame_layout_main);
        }
    }

    private void configureAndShowDetailFragment(){
        detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);

        if (detailFragment == null && findViewById(R.id.frame_layout_detail) != null) {
            detailFragment = new DetailFragment();
            this.showFragment(detailFragment, R.id.frame_layout_detail);
        }
    }

    // --------------
    // ACTIVITIES
    // --------------

    private void showParamsActivity(){
        Intent i = new Intent(this, ParamsActivity.class);
        startActivity(i);
    }

    private void showDetailActivity(int buttonTag){
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra(DetailActivity.EXTRA_BUTTON_TAG, buttonTag);
        startActivity(i);
    }
}
