/**************************************************************************
 * UserShowFragment.java, demactor Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : Jun 15, 2016
 *
 **************************************************************************/
package com.tactfactory.demactor.view.user;


import android.content.Intent;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tactfactory.demactor.R;
import com.tactfactory.demactor.entity.User;
import com.tactfactory.demactor.harmony.view.DeleteDialog;
import com.tactfactory.demactor.harmony.view.HarmonyFragment;
import com.tactfactory.demactor.harmony.view.MultiLoader;
import com.tactfactory.demactor.harmony.view.MultiLoader.UriLoadedCallback;
import com.tactfactory.demactor.menu.CrudDeleteMenuWrapper.CrudDeleteMenuInterface;
import com.tactfactory.demactor.menu.CrudEditMenuWrapper.CrudEditMenuInterface;
import com.tactfactory.demactor.provider.utils.UserProviderUtils;
import com.tactfactory.demactor.provider.UserProviderAdapter;
import com.tactfactory.demactor.provider.contract.UserContract;
import com.tactfactory.demactor.provider.contract.ScoreContract;
import com.tactfactory.demactor.provider.contract.JockeyContract;

/** User show fragment.
 *
 * This fragment gives you an interface to show a User.
 * 
 * @see android.app.Fragment
 */
public class UserShowFragment
        extends HarmonyFragment
        implements CrudDeleteMenuInterface,
                DeleteDialog.DeleteDialogCallback,
                CrudEditMenuInterface {
    /** Model data. */
    protected User model;
    /** DeleteCallback. */
    protected DeleteCallback deleteCallback;

    /* This entity's fields views */
    /** naFGHme1 View. */
    protected TextView naFGHme1View;
    /** surnFGHame1 View. */
    protected TextView surnFGHame1View;
    /** scoFGHre1 View. */
    protected TextView scoFGHre1View;
    /** jocFGHkey1 View. */
    protected TextView jocFGHkey1View;
    /** Data layout. */
    protected RelativeLayout dataLayout;
    /** Text view for no User. */
    protected TextView emptyText;


    /** Initialize view of curr.fields.
     *
     * @param view The layout inflating
     */
    protected void initializeComponent(final View view) {
        this.naFGHme1View =
            (TextView) view.findViewById(
                    R.id.user_nafghme1);
        this.surnFGHame1View =
            (TextView) view.findViewById(
                    R.id.user_surnfghame1);
        this.scoFGHre1View =
            (TextView) view.findViewById(
                    R.id.user_scofghre1);
        this.jocFGHkey1View =
            (TextView) view.findViewById(
                    R.id.user_jocfghkey1);

        this.dataLayout =
                (RelativeLayout) view.findViewById(
                        R.id.user_data_layout);
        this.emptyText =
                (TextView) view.findViewById(
                        R.id.user_empty);
    }

    /** Load data from model to fields view. */
    public void loadData() {
        if (this.model != null) {

            this.dataLayout.setVisibility(View.VISIBLE);
            this.emptyText.setVisibility(View.GONE);


        if (this.model.getNaFGHme1() != null) {
            this.naFGHme1View.setText(this.model.getNaFGHme1());
        }
        if (this.model.getSurnFGHame1() != null) {
            this.surnFGHame1View.setText(this.model.getSurnFGHame1());
        }
        if (this.model.getScoFGHre1() != null) {
            this.scoFGHre1View.setText(
                    String.valueOf(this.model.getScoFGHre1().getIdFD1()));
        }
        if (this.model.getJocFGHkey1() != null) {
            this.jocFGHkey1View.setText(
                    String.valueOf(this.model.getJocFGHkey1().getFbgDFbdf()));
        }
        } else {
            this.dataLayout.setVisibility(View.GONE);
            this.emptyText.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view =
                inflater.inflate(
                        R.layout.fragment_user_show,
                        container,
                        false);  
        if (this.getActivity() instanceof DeleteCallback) {
            this.deleteCallback = (DeleteCallback) this.getActivity();
        }

        this.initializeComponent(view);
        
        final Intent intent =  getActivity().getIntent();
        this.update((User) intent.getParcelableExtra(UserContract.PARCEL));

        return view;
    }

    /**
     * Updates the view with the given data.
     *
     * @param item The User to get the data from.
     */
    public void update(User item) {
        this.model = item;
        
        this.loadData();
        
        if (this.model != null) {
            MultiLoader loader = new MultiLoader(this);
            String baseUri = 
                    UserProviderAdapter.USER_URI 
                    + "/" 
                    + this.model.getId1HNY();

            loader.addUri(Uri.parse(baseUri), new UriLoadedCallback() {

                @Override
                public void onLoadComplete(android.database.Cursor c) {
                    UserShowFragment.this.onUserLoaded(c);
                }

                @Override
                public void onLoaderReset() {

                }
            });
            loader.addUri(Uri.parse(baseUri + "/scofghre1"), 
                    new UriLoadedCallback() {

                @Override
                public void onLoadComplete(android.database.Cursor c) {
                    UserShowFragment.this.onScoFGHre1Loaded(c);
                }

                @Override
                public void onLoaderReset() {

                }
            });
            loader.addUri(Uri.parse(baseUri + "/jocfghkey1"), 
                    new UriLoadedCallback() {

                @Override
                public void onLoadComplete(android.database.Cursor c) {
                    UserShowFragment.this.onJocFGHkey1Loaded(c);
                }

                @Override
                public void onLoaderReset() {

                }
            });
            loader.init();
        }
    }

    /**
     * Called when the entity has been loaded.
     * 
     * @param c The cursor of this entity
     */
    public void onUserLoaded(android.database.Cursor c) {
        if (c.getCount() > 0) {
            c.moveToFirst();
            
            UserContract.cursorToItem(
                        c,
                        this.model);
            this.loadData();
        }
    }
    /**
     * Called when the relation has been loaded.
     * 
     * @param c The cursor of this relation
     */
    public void onScoFGHre1Loaded(android.database.Cursor c) {
        if (this.model != null) {
            if (c != null) {
                if (c.getCount() > 0) {
                    c.moveToFirst();
                    this.model.setScoFGHre1(ScoreContract.cursorToItem(c));
                    this.loadData();
                }
            } else {
                this.model.setScoFGHre1(null);
                    this.loadData();
            }
        }
    }
    /**
     * Called when the relation has been loaded.
     * 
     * @param c The cursor of this relation
     */
    public void onJocFGHkey1Loaded(android.database.Cursor c) {
        if (this.model != null) {
            if (c != null) {
                if (c.getCount() > 0) {
                    c.moveToFirst();
                    this.model.setJocFGHkey1(JockeyContract.cursorToItem(c));
                    this.loadData();
                }
            } else {
                this.model.setJocFGHkey1(null);
                    this.loadData();
            }
        }
    }

    /**
     * Calls the UserEditActivity.
     */
    @Override
    public void onClickEdit() {
        final Intent intent = new Intent(getActivity(),
                                    UserEditActivity.class);
        Bundle extras = new Bundle();
        extras.putParcelable(UserContract.PARCEL, this.model);
        intent.putExtras(extras);

        this.getActivity().startActivity(intent);
    }
    /**
     * Shows a confirmation dialog.
     */
    @Override
    public void onClickDelete() {
        new DeleteDialog(this.getActivity(), this).show();
    }

    @Override
    public void onDeleteDialogClose(boolean ok) {
        if (ok) {
            new DeleteTask(this.getActivity(), this.model).execute();
        }
    }
    
    /** 
     * Called when delete task is done.
     */    
    public void onPostDelete() {
        if (this.deleteCallback != null) {
            this.deleteCallback.onItemDeleted();
        }
    }

    /**
     * This class will remove the entity into the DB.
     * It runs asynchronously.
     */
    private class DeleteTask extends AsyncTask<Void, Void, Integer> {
        /** AsyncTask's context. */
        private android.content.Context ctx;
        /** Entity to delete. */
        private User item;

        /**
         * Constructor of the task.
         * @param item The entity to remove from DB
         * @param ctx A context to build UserSQLiteAdapter
         */
        public DeleteTask(final android.content.Context ctx,
                    final User item) {
            super();
            this.ctx = ctx;
            this.item = item;
        }

        @Override
        protected Integer doInBackground(Void... params) {
            int result = -1;

            result = new UserProviderUtils(this.ctx)
                    .delete(this.item);

            return result;
        }

        @Override
        protected void onPostExecute(Integer result) {
            if (result >= 0) {
                UserShowFragment.this.onPostDelete();
            }
            super.onPostExecute(result);
        }
        
        

    }

    /**
     * Callback for item deletion.
     */ 
    public interface DeleteCallback {
        /** Called when current item has been deleted. */
        void onItemDeleted();
    }
}

