/**************************************************************************
 * JockeyTestDBBase.java, demactor Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : Jun 15, 2016
 *
 **************************************************************************/
package com.tactfactory.demactor.test.base;

import java.util.ArrayList;

import android.test.suitebuilder.annotation.SmallTest;

import com.tactfactory.demactor.data.JockeySQLiteAdapter;
import com.tactfactory.demactor.entity.Jockey;


import com.tactfactory.demactor.test.utils.*;

import junit.framework.Assert;

/** Jockey database test abstract class <br/>
 * <b><i>This class will be overwrited whenever you regenerate the project with Harmony.
 * You should edit JockeyTestDB class instead of this one or you will lose all your modifications.</i></b>
 */
public abstract class JockeyTestDBBase extends TestDBBase {
    protected android.content.Context ctx;

    protected JockeySQLiteAdapter adapter;

    protected Jockey entity;
    protected ArrayList<Jockey> entities;
    protected int nbEntities = 0;
    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();

        this.ctx = this.getContext();

        this.adapter = new JockeySQLiteAdapter(this.ctx);
        this.adapter.open();

    }

    /* (non-Javadoc)
     * @see junit.framework.TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        this.adapter.close();

        super.tearDown();
    }

    /** Test case Create Entity */
    @SmallTest
    public void testCreate() {
        int result = -1;
        if (this.entity != null) {
            Jockey jockey = JockeyUtils.generateRandom(this.ctx);

            result = (int)this.adapter.insert(jockey);

            Assert.assertTrue(result >= 0);
        }
    }

    /** Test case Read Entity */
    @SmallTest
    public void testRead() {
        Jockey result = null;
        if (this.entity != null) {
            result = this.adapter.getByID(this.entity.getFbgDFbdf());

            JockeyUtils.equals(this.entity, result);
        }
    }

    /** Test case Update Entity */
    @SmallTest
    public void testUpdate() {
        int result = -1;
        if (this.entity != null) {
            Jockey jockey = JockeyUtils.generateRandom(this.ctx);
            jockey.setFbgDFbdf(this.entity.getFbgDFbdf());

            result = (int) this.adapter.update(jockey);

            Assert.assertTrue(result >= 0);
        }
    }

    /** Test case Update Entity */
    @SmallTest
    public void testDelete() {
        int result = -1;
        if (this.entity != null) {
            result = (int) this.adapter.remove(this.entity.getFbgDFbdf());
            Assert.assertTrue(result >= 0);
        }
    }
    
    /** Test the get all method. */
    @SmallTest
    public void testAll() {
        int result = this.adapter.getAll().size();
        int expectedSize = this.nbEntities;
        Assert.assertEquals(expectedSize, result);
    }
}
