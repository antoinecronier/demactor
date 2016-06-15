/**************************************************************************
 * PoneySQLiteAdapter.java, demactor Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : Jun 15, 2016
 *
 **************************************************************************/
package com.tactfactory.demactor.data;

import com.tactfactory.demactor.data.base.PoneySQLiteAdapterBase;


/**
 * Poney adapter database class. 
 * This class will help you access your database to do any basic operation you
 * need. 
 * Feel free to modify it, override, add more methods etc.
 */
public class PoneySQLiteAdapter extends PoneySQLiteAdapterBase {

    /**
     * Constructor.
     * @param ctx context
     */
    public PoneySQLiteAdapter(final android.content.Context ctx) {
        super(ctx);
    }
}
