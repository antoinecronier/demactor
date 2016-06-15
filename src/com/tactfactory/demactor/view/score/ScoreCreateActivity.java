/**************************************************************************
 * ScoreCreateActivity.java, demactor Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : Jun 15, 2016
 *
 **************************************************************************/
package com.tactfactory.demactor.view.score;

import com.tactfactory.demactor.R;

import com.tactfactory.demactor.harmony.view.HarmonyFragmentActivity;

import android.os.Bundle;

/** 
 * Score create Activity.
 *
 * This only contains a ScoreCreateFragment.
 *
 * @see android.app.Activity
 */
public class ScoreCreateActivity extends HarmonyFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setNavigationBack(true);
    }
    
    @Override
    protected int getContentView() {
        return R.layout.activity_score_create;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
