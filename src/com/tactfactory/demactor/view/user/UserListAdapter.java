/**************************************************************************
 * UserListAdapter.java, demactor Android
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

import android.database.Cursor;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tactfactory.demactor.entity.User;
import com.tactfactory.demactor.harmony.view.HarmonyCursorAdapter;
import com.tactfactory.demactor.harmony.view.HarmonyViewHolder;
import com.tactfactory.demactor.provider.contract.UserContract;
import com.tactfactory.demactor.provider.contract.ScoreContract;
import com.tactfactory.demactor.provider.contract.JockeyContract;

/**
 * List adapter for User entity.
 */
public class UserListAdapter extends HarmonyCursorAdapter<User> {
    
    /**
     * Constructor.
     * @param ctx context
     */
    public UserListAdapter(android.content.Context context) {
        super(context);
    }
    
    /**
     * Constructor.
     * @param ctx context
     * @param cursor cursor
     */
    public UserListAdapter(android.content.Context context, Cursor cursor) {
        super(context, cursor);
    }
    
    @Override
    protected User cursorToItem(Cursor cursor) {
        return UserContract.cursorToItem(cursor);
    }

    @Override
    protected String getColId() {
        return UserContract.COL_ID1HNY;
    }
    
    @Override
    protected HarmonyViewHolder<User> getNewViewHolder(
            android.content.Context context,
            Cursor cursor, ViewGroup group) {
        return new ViewHolder(context, group);
    }
    
    /** Holder row. */
    private class ViewHolder extends HarmonyViewHolder<User> {
    
        /**
         * Constructor.
         *
         * @param context The context
         * @param parent Optional view to be the parent of the generated hierarchy
         */
        public ViewHolder(android.content.Context context, ViewGroup parent) {
            super(context, parent, R.layout.row_user);
        }

        /**
         * Populate row with a {@link User}.
         *
         * @param model {@link User} data
         */
        public void populate(final User model) {
            TextView naFGHme1View = (TextView) this.getView().findViewById(
                    R.id.row_user_nafghme1);
                    
            TextView surnFGHame1View = (TextView) this.getView().findViewById(
                    R.id.row_user_surnfghame1);
                    
            TextView scoFGHre1View = (TextView) this.getView().findViewById(
                    R.id.row_user_scofghre1);
                    
            TextView jocFGHkey1View = (TextView) this.getView().findViewById(
                    R.id.row_user_jocfghkey1);
                    

            if (model.getNaFGHme1() != null) {
                naFGHme1View.setText(model.getNaFGHme1());
            }
            if (model.getSurnFGHame1() != null) {
                surnFGHame1View.setText(model.getSurnFGHame1());
            }
            if (model.getScoFGHre1() != null) {
                scoFGHre1View.setText(
                        String.valueOf(model.getScoFGHre1().getIdFD1()));
            }
            if (model.getJocFGHkey1() != null) {
                jocFGHkey1View.setText(
                        String.valueOf(model.getJocFGHkey1().getFbgDFbdf()));
            }
        }
    }
}
