
/**************************************************************************
 * PoneySQLiteAdapterBase.java, demactor Android
 *
 * Copyright 2016
 * Description :
 * Author(s)   : Harmony
 * Licence     :
 * Last update : Jun 15, 2016
 *
 **************************************************************************/
package com.tactfactory.demactor.data.base;

import java.util.ArrayList;
import android.content.ContentValues;


import android.database.sqlite.SQLiteDatabase;


import com.google.common.base.Strings;
import com.google.common.collect.ObjectArrays;
import com.tactfactory.demactor.data.SQLiteAdapter;
import com.tactfactory.demactor.data.PoneySQLiteAdapter;
import com.tactfactory.demactor.data.PoneytoJockeySQLiteAdapter;
import com.tactfactory.demactor.data.JockeySQLiteAdapter;
import com.tactfactory.demactor.data.ScoreSQLiteAdapter;
import com.tactfactory.demactor.provider.contract.PoneyContract;
import com.tactfactory.demactor.provider.contract.PoneytoJockeyContract;
import com.tactfactory.demactor.provider.contract.JockeyContract;
import com.tactfactory.demactor.provider.contract.ScoreContract;
import com.tactfactory.demactor.entity.Poney;
import com.tactfactory.demactor.entity.Jockey;
import com.tactfactory.demactor.entity.Score;


import com.tactfactory.demactor.DemactorApplication;



/** Poney adapter database abstract class. <br/>
 * <b><i>This class will be overwrited whenever you regenerate the project<br/>
 * with Harmony.<br />
 * You should edit PoneyAdapter class instead of this<br/>
 * one or you will lose all your modifications.</i></b>
 */
public abstract class PoneySQLiteAdapterBase
                        extends SQLiteAdapter<Poney> {

    /** TAG for debug purpose. */
    protected static final String TAG = "PoneyDBAdapter";


    /**
     * Get the table name used in DB for your Poney entity.
     * @return A String showing the table name
     */
    public String getTableName() {
        return PoneyContract.TABLE_NAME;
    }

    /**
     * Get the joined table name used in DB for your Poney entity
     * and its parents.
     * @return A String showing the joined table name
     */
    public String getJoinedTableName() {
        String result = PoneyContract.TABLE_NAME;
        return result;
    }

    /**
     * Get the column names from the Poney entity table.
     * @return An array of String representing the columns
     */
    public String[] getCols() {
        return PoneyContract.ALIASED_COLS;
    }

    /**
     * Generate Entity Table Schema.
     * @return "SQL query : CREATE TABLE..."
     */
    public static String getSchema() {
        return "CREATE TABLE "
        + PoneyContract.TABLE_NAME    + " ("

         + PoneyContract.COL_IDLIOEM1    + " INTEGER PRIMARY KEY AUTOINCREMENT,"
         + PoneyContract.COL_IOMAIOME1    + " VARCHAR NOT NULL,"
         + PoneyContract.COL_SCORVBNBE1_IDFD1    + " INTEGER NOT NULL,"


         + "FOREIGN KEY(" + PoneyContract.COL_SCORVBNBE1_IDFD1 + ") REFERENCES "
             + ScoreContract.TABLE_NAME
                + " (" + ScoreContract.COL_IDFD1 + ")"
        + ");"
;
    }

    /**
     * Constructor.
     * @param ctx context
     */
    public PoneySQLiteAdapterBase(final android.content.Context ctx) {
        super(ctx);
    }

    // Converters

    /**
     * Convert Poney entity to Content Values for database.
     * @param item Poney entity object
     * @return ContentValues object
     */
    public ContentValues itemToContentValues(final Poney item) {
        return PoneyContract.itemToContentValues(item);
    }

    /**
     * Convert android.database.Cursor of database to Poney entity.
     * @param cursor android.database.Cursor object
     * @return Poney entity
     */
    public Poney cursorToItem(final android.database.Cursor cursor) {
        return PoneyContract.cursorToItem(cursor);
    }

    /**
     * Convert android.database.Cursor of database to Poney entity.
     * @param cursor android.database.Cursor object
     * @param result Poney entity
     */
    public void cursorToItem(final android.database.Cursor cursor, final Poney result) {
        PoneyContract.cursorToItem(cursor, result);
    }

    //// CRUD Entity ////
    /**
     * Find & read Poney by id in database.
     *
     * @param id Identify of Poney
     * @return Poney entity
     */
    public Poney getByID(final int idlioEm1) {
        final android.database.Cursor cursor = this.getSingleCursor(idlioEm1);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
        }

        final Poney result = this.cursorToItem(cursor);
        cursor.close();

        PoneytoJockeySQLiteAdapter poneytojockeyAdapter =
                new PoneytoJockeySQLiteAdapter(this.ctx);
        poneytojockeyAdapter.open(this.mDatabase);
        android.database.Cursor jockgfhjeys1Cursor = poneytojockeyAdapter.getByPoneyDFd1(
                            result.getIdlioEm1(),
                            JockeyContract.ALIASED_COLS,
                            null,
                            null,
                            null);
        result.setJockgFhjeys1(new JockeySQLiteAdapter(ctx).cursorToItems(jockgfhjeys1Cursor));

        jockgfhjeys1Cursor.close();
        if (result.getScorvbnBe1() != null) {
            final ScoreSQLiteAdapter scorvbnBe1Adapter =
                    new ScoreSQLiteAdapter(this.ctx);
            scorvbnBe1Adapter.open(this.mDatabase);

            result.setScorvbnBe1(scorvbnBe1Adapter.getByID(
                            result.getScorvbnBe1().getIdFD1()));
        }
        return result;
    }

    /**
     * Find & read Poney by scorvbnBe1.
     * @param scorvbnbe1Id scorvbnbe1Id
     * @param orderBy Order by string (can be null)
     * @return List of Poney entities
     */
     public android.database.Cursor getByScorvbnBe1(final int scorvbnbe1Id, String[] projection, String selection, String[] selectionArgs, String orderBy) {
        String idSelection = PoneyContract.COL_SCORVBNBE1_IDFD1 + "= ?";
        String idSelectionArgs = String.valueOf(scorvbnbe1Id);
        if (!Strings.isNullOrEmpty(selection)) {
            selection += " AND " + idSelection;
            selectionArgs = ObjectArrays.concat(selectionArgs, idSelectionArgs);
        } else {
            selection = idSelection;
            selectionArgs = new String[]{idSelectionArgs};
        }
        final android.database.Cursor cursor = this.query(
                projection,
                selection,
                selectionArgs,
                null,
                null,
                orderBy);

        return cursor;
     }

    /**
     * Read All Poneys entities.
     *
     * @return List of Poney entities
     */
    public ArrayList<Poney> getAll() {
        final android.database.Cursor cursor = this.getAllCursor();
        final ArrayList<Poney> result = this.cursorToItems(cursor);
        cursor.close();

        return result;
    }



    /**
     * Insert a Poney entity into database.
     *
     * @param item The Poney entity to persist
     * @return Id of the Poney entity
     */
    public long insert(final Poney item) {
        if (DemactorApplication.DEBUG) {
            android.util.Log.d(TAG, "Insert DB(" + PoneyContract.TABLE_NAME + ")");
        }

        final ContentValues values =
                PoneyContract.itemToContentValues(item);
        values.remove(PoneyContract.COL_IDLIOEM1);
        int insertResult;
        if (values.size() != 0) {
            insertResult = (int) this.insert(
                    null,
                    values);
        } else {
            insertResult = (int) this.insert(
                    PoneyContract.COL_IDLIOEM1,
                    values);
        }
        item.setIdlioEm1(insertResult);
        if (item.getJockgFhjeys1() != null) {
            PoneytoJockeySQLiteAdapterBase jockgFhjeys1Adapter =
                    new PoneytoJockeySQLiteAdapter(this.ctx);
            jockgFhjeys1Adapter.open(this.mDatabase);
            for (Jockey i : item.getJockgFhjeys1()) {
                jockgFhjeys1Adapter.insert(
                        i.getFbgDFbdf(),
                        insertResult);
            }
        }
        return insertResult;
    }

    /**
     * Either insert or update a Poney entity into database whether.
     * it already exists or not.
     *
     * @param item The Poney entity to persist
     * @return 1 if everything went well, 0 otherwise
     */
    public int insertOrUpdate(final Poney item) {
        int result = 0;
        if (this.getByID(item.getIdlioEm1()) != null) {
            // Item already exists => update it
            result = this.update(item);
        } else {
            // Item doesn't exist => create it
            final long id = this.insert(item);
            if (id != 0) {
                result = 1;
            }
        }

        return result;
    }

    /**
     * Update a Poney entity into database.
     *
     * @param item The Poney entity to persist
     * @return count of updated entities
     */
    public int update(final Poney item) {
        if (DemactorApplication.DEBUG) {
            android.util.Log.d(TAG, "Update DB(" + PoneyContract.TABLE_NAME + ")");
        }

        final ContentValues values =
                PoneyContract.itemToContentValues(item);
        final String whereClause =
                 PoneyContract.COL_IDLIOEM1
                 + " = ?";
        final String[] whereArgs =
                new String[] {String.valueOf(item.getIdlioEm1()) };

        return this.update(
                values,
                whereClause,
                whereArgs);
    }


    /**
     * Delete a Poney entity of database.
     *
     * @param idlioEm1 idlioEm1
     * @return count of updated entities
     */
    public int remove(final int idlioEm1) {
        if (DemactorApplication.DEBUG) {
            android.util.Log.d(
                TAG,
                "Delete DB("
                    + PoneyContract.TABLE_NAME
                    + ")"
                    + " id : "+ idlioEm1);
        }

        final String whereClause =
                PoneyContract.COL_IDLIOEM1
                + " = ?";
        final String[] whereArgs = new String[] {
                    String.valueOf(idlioEm1)};

        return this.delete(
                whereClause,
                whereArgs);
    }

    /**
     * Deletes the given entity.
     * @param poney The entity to delete
     * @return count of updated entities
     */
    public int delete(final Poney poney) {
        return this.remove(poney.getIdlioEm1());
    }

    /**
     *  Internal android.database.Cursor.
     * @param idlioEm1 idlioEm1
     *  @return A android.database.Cursor pointing to the Poney corresponding
     *        to the given id.
     */
    protected android.database.Cursor getSingleCursor(final int idlioEm1) {
        if (DemactorApplication.DEBUG) {
            android.util.Log.d(TAG, "Get entities id : " + idlioEm1);
        }

        final String whereClause =
                PoneyContract.ALIASED_COL_IDLIOEM1
                + " = ?";
        final String[] whereArgs = new String[] {String.valueOf(idlioEm1)};

        return this.query(
                PoneyContract.ALIASED_COLS,
                whereClause,
                whereArgs,
                null,
                null,
                null);
    }


    /**
     * Query the DB to find a Poney entity.
     *
     * @param idlioEm1 The idlioEm1 of the entity to get from the DB
     *
     * @return The cursor pointing to the query's result
     */
    public android.database.Cursor query(final int idlioEm1) {

        String selection = PoneyContract.ALIASED_COL_IDLIOEM1 + " = ?";


        String[] selectionArgs = new String[1];
        selectionArgs[0] = String.valueOf(idlioEm1);

        return this.query(
                PoneyContract.ALIASED_COLS,
                selection,
                selectionArgs,
                null,
                null,
                null);
    }




}

