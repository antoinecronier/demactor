/**************************************************************************
 * PoneyShowActivity.java, demactor Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : Jun 15, 2016
 *
 **************************************************************************/
package com.tactfactory.demactor.view.poney;

import com.tactfactory.demactor.R;

import com.tactfactory.demactor.harmony.view.HarmonyFragmentActivity;
import com.tactfactory.demactor.view.poney.PoneyShowFragment.DeleteCallback;
import android.os.Bundle;

/** Poney show Activity.
 *
 * This only contains a PoneyShowFragment.
 *
 * @see android.app.Activity
 */
public class PoneyShowActivity 
        extends HarmonyFragmentActivity 
        implements DeleteCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setNavigationBack(true);
    }
    
    @Override
    protected int getContentView() {
        return R.layout.activity_poney_show;
    }

    @Override
    public void onItemDeleted() {
        this.finish();
    }
}
