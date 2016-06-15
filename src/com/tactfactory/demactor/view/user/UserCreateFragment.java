/**************************************************************************
 * UserCreateFragment.java, demactor Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : Jun 15, 2016
 *
 **************************************************************************/
package com.tactfactory.demactor.view.user;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.common.base.Strings;
import com.tactfactory.demactor.R;
import com.tactfactory.demactor.entity.User;
import com.tactfactory.demactor.entity.Score;
import com.tactfactory.demactor.entity.Jockey;

import com.tactfactory.demactor.harmony.view.HarmonyFragmentActivity;
import com.tactfactory.demactor.harmony.view.HarmonyFragment;

import com.tactfactory.demactor.harmony.widget.SingleEntityWidget;
import com.tactfactory.demactor.menu.SaveMenuWrapper.SaveMenuInterface;
import com.tactfactory.demactor.provider.utils.UserProviderUtils;
import com.tactfactory.demactor.provider.utils.ScoreProviderUtils;
import com.tactfactory.demactor.provider.utils.JockeyProviderUtils;

/**
 * User create fragment.
 *
 * This fragment gives you an interface to create a User.
 */
public class UserCreateFragment extends HarmonyFragment
            implements SaveMenuInterface {
    /** Model data. */
    protected User model = new User();

    /** Fields View. */
    /** naFGHme1 View. */
    protected EditText naFGHme1View;
    /** surnFGHame1 View. */
    protected EditText surnFGHame1View;
    /** The scoFGHre1 chooser component. */
    protected SingleEntityWidget scoFGHre1Widget;
    /** The scoFGHre1 Adapter. */
    protected SingleEntityWidget.EntityAdapter<Score> 
                scoFGHre1Adapter;
    /** The jocFGHkey1 chooser component. */
    protected SingleEntityWidget jocFGHkey1Widget;
    /** The jocFGHkey1 Adapter. */
    protected SingleEntityWidget.EntityAdapter<Jockey> 
                jocFGHkey1Adapter;

    /** Initialize view of fields.
     *
     * @param view The layout inflating
     */
    protected void initializeComponent(final View view) {
        this.naFGHme1View =
            (EditText) view.findViewById(R.id.user_nafghme1);
        this.surnFGHame1View =
            (EditText) view.findViewById(R.id.user_surnfghame1);
        this.scoFGHre1Adapter = 
                new SingleEntityWidget.EntityAdapter<Score>() {
            @Override
            public String entityToString(Score item) {
                return String.valueOf(item.getIdFD1());
            }
        };
        this.scoFGHre1Widget =
            (SingleEntityWidget) view.findViewById(R.id.user_scofghre1_button);
        this.scoFGHre1Widget.setAdapter(this.scoFGHre1Adapter);
        this.scoFGHre1Widget.setTitle(R.string.user_scofghre1_dialog_title);
        this.jocFGHkey1Adapter = 
                new SingleEntityWidget.EntityAdapter<Jockey>() {
            @Override
            public String entityToString(Jockey item) {
                return String.valueOf(item.getFbgDFbdf());
            }
        };
        this.jocFGHkey1Widget =
            (SingleEntityWidget) view.findViewById(R.id.user_jocfghkey1_button);
        this.jocFGHkey1Widget.setAdapter(this.jocFGHkey1Adapter);
        this.jocFGHkey1Widget.setTitle(R.string.user_jocfghkey1_dialog_title);
    }

    /** Load data from model to fields view. */
    public void loadData() {

        if (this.model.getNaFGHme1() != null) {
            this.naFGHme1View.setText(this.model.getNaFGHme1());
        }
        if (this.model.getSurnFGHame1() != null) {
            this.surnFGHame1View.setText(this.model.getSurnFGHame1());
        }

        new LoadTask(this).execute();
    }

    /** Save data from fields view to model. */
    public void saveData() {

        this.model.setNaFGHme1(this.naFGHme1View.getEditableText().toString());

        this.model.setSurnFGHame1(this.surnFGHame1View.getEditableText().toString());

        this.model.setScoFGHre1(this.scoFGHre1Adapter.getSelectedItem());

        this.model.setJocFGHkey1(this.jocFGHkey1Adapter.getSelectedItem());

    }

    /** Check data is valid.
     *
     * @return true if valid
     */
    public boolean validateData() {
        int error = 0;

        if (Strings.isNullOrEmpty(
                    this.naFGHme1View.getText().toString().trim())) {
            error = R.string.user_nafghme1_invalid_field_error;
        }
        if (Strings.isNullOrEmpty(
                    this.surnFGHame1View.getText().toString().trim())) {
            error = R.string.user_surnfghame1_invalid_field_error;
        }
        if (this.scoFGHre1Adapter.getSelectedItem() == null) {
            error = R.string.user_scofghre1_invalid_field_error;
        }
        if (this.jocFGHkey1Adapter.getSelectedItem() == null) {
            error = R.string.user_jocfghkey1_invalid_field_error;
        }
    
        if (error > 0) {
            Toast.makeText(this.getActivity(),
                this.getActivity().getString(error),
                Toast.LENGTH_SHORT).show();
        }
        return error == 0;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(
                R.layout.fragment_user_create,
                container,
                false);

        this.initializeComponent(view);
        this.loadData();
        return view;
    }

    /**
     * This class will save the entity into the DB.
     * It runs asynchronously and shows a progressDialog
     */
    public static class CreateTask extends AsyncTask<Void, Void, Uri> {
        /** AsyncTask's context. */
        private final android.content.Context ctx;
        /** Entity to persist. */
        private final User entity;
        /** Progress Dialog. */
        private ProgressDialog progress;

        /**
         * Constructor of the task.
         * @param entity The entity to insert in the DB
         * @param fragment The parent fragment from where the aSyncTask is
         * called
         */
        public CreateTask(final UserCreateFragment fragment,
                final User entity) {
            super();
            this.ctx = fragment.getActivity();
            this.entity = entity;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            this.progress = ProgressDialog.show(this.ctx,
                    this.ctx.getString(
                            R.string.user_progress_save_title),
                    this.ctx.getString(
                            R.string.user_progress_save_message));
        }

        @Override
        protected Uri doInBackground(Void... params) {
            Uri result = null;

            result = new UserProviderUtils(this.ctx).insert(
                        this.entity);

            return result;
        }

        @Override
        protected void onPostExecute(Uri result) {
            super.onPostExecute(result);
            if (result != null) {
                final HarmonyFragmentActivity activity =
                                         (HarmonyFragmentActivity) this.ctx;
                activity.finish();
            } else {
                final AlertDialog.Builder builder =
                        new AlertDialog.Builder(this.ctx);
                builder.setIcon(0);
                builder.setMessage(
                        this.ctx.getString(
                                R.string.user_error_create));
                builder.setPositiveButton(
                        this.ctx.getString(android.R.string.yes),
                        new Dialog.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                    int which) {

                            }
                        });
                builder.show();
            }

            this.progress.dismiss();
        }
    }

    /**
     * This class will save the entity into the DB.
     * It runs asynchronously and shows a progressDialog
     */
    public static class LoadTask extends AsyncTask<Void, Void, Void> {
        /** AsyncTask's context. */
        private final android.content.Context ctx;
        /** Progress Dialog. */
        private ProgressDialog progress;
        /** Fragment. */
        private UserCreateFragment fragment;
        /** scoFGHre1 list. */
        private ArrayList<Score> scoFGHre1List;
        /** jocFGHkey1 list. */
        private ArrayList<Jockey> jocFGHkey1List;

        /**
         * Constructor of the task.
         * @param fragment The parent fragment from where the aSyncTask is
         * called
         */
        public LoadTask(final UserCreateFragment fragment) {
            super();
            this.ctx = fragment.getActivity();
            this.fragment = fragment;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            this.progress = ProgressDialog.show(this.ctx,
                    this.ctx.getString(
                            R.string.user_progress_load_relations_title),
                    this.ctx.getString(
                            R.string.user_progress_load_relations_message));
        }

        @Override
        protected Void doInBackground(Void... params) {
            this.scoFGHre1List = 
                new ScoreProviderUtils(this.ctx).queryAll();
            this.jocFGHkey1List = 
                new JockeyProviderUtils(this.ctx).queryAll();
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            this.fragment.scoFGHre1Adapter.loadData(this.scoFGHre1List);
            this.fragment.jocFGHkey1Adapter.loadData(this.jocFGHkey1List);
            this.progress.dismiss();
        }
    }

    @Override
    public void onClickSave() {
        if (this.validateData()) {
            this.saveData();
            new CreateTask(this, this.model).execute();
        }
    }
}
