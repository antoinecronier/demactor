/**************************************************************************
 * ProviderAdapter.java, demactor Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : Jun 15, 2016
 *
 **************************************************************************/
package com.tactfactory.demactor.provider;

import com.tactfactory.demactor.provider.base.ProviderAdapterBase;
import com.tactfactory.demactor.provider.base.DemactorProviderBase;
import com.tactfactory.demactor.data.base.SQLiteAdapterBase;

/**
 * ProviderAdapter<T>. 
 *
 * Feel free to add your custom generic methods here.
 *
 * @param <T> must extends Serializable
 */
public abstract class ProviderAdapter<T> extends ProviderAdapterBase<T> {

    /**
     * Provider Adapter Base constructor.
     *
     * @param context The context.
     */
    public ProviderAdapter(
                final DemactorProviderBase provider,
                final SQLiteAdapterBase<T> adapter) {
        super(provider, adapter);
    }
}
