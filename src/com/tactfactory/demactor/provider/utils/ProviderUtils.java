/**************************************************************************
 * ProviderUtils.java, demactor Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : Jun 15, 2016
 *
 **************************************************************************/
package com.tactfactory.demactor.provider.utils;

import com.tactfactory.demactor.provider.utils.base.ProviderUtilsBase;



/**
 * Generic Proxy class for the provider calls.
 *
 * Feel free to modify it and your own generic methods in it.
 *
 * @param <T>     The entity type
 */
public abstract class ProviderUtils<T> extends ProviderUtilsBase<T> {

    /**
     * Constructor.
     * @param context android.content.Context
     */
    public ProviderUtils(android.content.Context context) {
        super(context);
    }
}

