/**************************************************************************
 * UserShowActivity.java, demactor Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : Jun 15, 2016
 *
 **************************************************************************/
package com.tactfactory.demactor.view.user;

import com.tactfactory.demactor.R;

import com.tactfactory.demactor.harmony.view.HarmonyFragmentActivity;
import com.tactfactory.demactor.view.user.UserShowFragment.DeleteCallback;
import android.os.Bundle;

/** User show Activity.
 *
 * This only contains a UserShowFragment.
 *
 * @see android.app.Activity
 */
public class UserShowActivity 
        extends HarmonyFragmentActivity 
        implements DeleteCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setNavigationBack(true);
    }
    
    @Override
    protected int getContentView() {
        return R.layout.activity_user_show;
    }

    @Override
    public void onItemDeleted() {
        this.finish();
    }
}
