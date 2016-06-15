package com.tactfactory.demactor.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

import com.tactfactory.harmony.annotation.Column;
import com.tactfactory.harmony.annotation.Entity;
import com.tactfactory.harmony.annotation.GeneratedValue;
import com.tactfactory.harmony.annotation.Id;
import com.tactfactory.harmony.annotation.ManyToMany;
import com.tactfactory.harmony.annotation.OneToMany;
import com.tactfactory.harmony.annotation.Column.Type;
import com.tactfactory.harmony.annotation.GeneratedValue.Strategy;
import com.tactfactory.harmony.annotation.OneToOne;

@Entity
public class Jockey  implements Serializable , Parcelable {

    /** Parent parcelable for parcellisation purposes. */
    protected List<Parcelable> parcelableParents;


	@Id
    @Column(type = Type.INTEGER, hidden = true)
    @GeneratedValue(strategy = Strategy.MODE_IDENTITY)
	private int fbgDFbdf;

	@Column(type = Type.STRING)
	private String dfdfgdDDfgdfg;

	@Column(type = Type.STRING)
	private String dfgdfgdfgdfFg;

	@ManyToMany(mappedBy = "PoneyDFd1")
	private ArrayList<Poney> dzerzerBCze;

    @OneToOne(targetEntity = "User")
    private User iuytrezBa;

    /**
     * Default constructor.
     */
    public Jockey() {

    }

     /**
     * Get the FbgDFbdf.
     * @return the fbgDFbdf
     */
    public int getFbgDFbdf() {
         return this.fbgDFbdf;
    }
     /**
     * Set the FbgDFbdf.
     * @param value the fbgDFbdf to set
     */
    public void setFbgDFbdf(final int value) {
         this.fbgDFbdf = value;
    }
     /**
     * Get the DfdfgdDDfgdfg.
     * @return the dfdfgdDDfgdfg
     */
    public String getDfdfgdDDfgdfg() {
         return this.dfdfgdDDfgdfg;
    }
     /**
     * Set the DfdfgdDDfgdfg.
     * @param value the dfdfgdDDfgdfg to set
     */
    public void setDfdfgdDDfgdfg(final String value) {
         this.dfdfgdDDfgdfg = value;
    }
     /**
     * Get the DfgdfgdfgdfFg.
     * @return the dfgdfgdfgdfFg
     */
    public String getDfgdfgdfgdfFg() {
         return this.dfgdfgdfgdfFg;
    }
     /**
     * Set the DfgdfgdfgdfFg.
     * @param value the dfgdfgdfgdfFg to set
     */
    public void setDfgdfgdfgdfFg(final String value) {
         this.dfgdfgdfgdfFg = value;
    }
     /**
     * Get the DzerzerBCze.
     * @return the dzerzerBCze
     */
    public ArrayList<Poney> getDzerzerBCze() {
         return this.dzerzerBCze;
    }
     /**
     * Set the DzerzerBCze.
     * @param value the dzerzerBCze to set
     */
    public void setDzerzerBCze(final ArrayList<Poney> value) {
         this.dzerzerBCze = value;
    }
     /**
     * Get the IuytrezBa.
     * @return the iuytrezBa
     */
    public User getIuytrezBa() {
         return this.iuytrezBa;
    }
     /**
     * Set the IuytrezBa.
     * @param value the iuytrezBa to set
     */
    public void setIuytrezBa(final User value) {
         this.iuytrezBa = value;
    }
    /**
     * This stub of code is regenerated. DO NOT MODIFY.
     *
     * @param dest Destination parcel
     * @param flags flags
     */
    public void writeToParcelRegen(Parcel dest, int flags) {
        if (this.parcelableParents == null) {
            this.parcelableParents = new ArrayList<Parcelable>();
        }
        if (!this.parcelableParents.contains(this)) {
            this.parcelableParents.add(this);
        }
        dest.writeInt(this.getFbgDFbdf());
        if (this.getDfdfgdDDfgdfg() != null) {
            dest.writeInt(1);
            dest.writeString(this.getDfdfgdDDfgdfg());
        } else {
            dest.writeInt(0);
        }
        if (this.getDfgdfgdfgdfFg() != null) {
            dest.writeInt(1);
            dest.writeString(this.getDfgdfgdfgdfFg());
        } else {
            dest.writeInt(0);
        }

        if (this.getDzerzerBCze() != null) {
            dest.writeInt(this.getDzerzerBCze().size());
            for (Poney item : this.getDzerzerBCze()) {
                if (!this.parcelableParents.contains(item)) {
                    item.writeToParcel(dest, flags);
                } else {
                    dest.writeParcelable(null, flags);
                }
            }
        } else {
            dest.writeInt(-1);
        }
        if (this.getIuytrezBa() != null
                    && !this.parcelableParents.contains(this.getIuytrezBa())) {
            this.getIuytrezBa().writeToParcel(dest, flags);
        } else {
            dest.writeParcelable(null, flags);
        }
    }

    /**
     * Regenerated Parcel Constructor.
     *
     * This stub of code is regenerated. DO NOT MODIFY THIS METHOD.
     *
     * @param parc The parcel to read from
     */
    public void readFromParcel(Parcel parc) {
        this.setFbgDFbdf(parc.readInt());
        int dfdfgdDDfgdfgBool = parc.readInt();
        if (dfdfgdDDfgdfgBool == 1) {
            this.setDfdfgdDDfgdfg(parc.readString());
        }
        int dfgdfgdfgdfFgBool = parc.readInt();
        if (dfgdfgdfgdfFgBool == 1) {
            this.setDfgdfgdfgdfFg(parc.readString());
        }

        int nbDzerzerBCze = parc.readInt();
        if (nbDzerzerBCze > -1) {
            ArrayList<Poney> items =
                new ArrayList<Poney>();
            for (int i = 0; i < nbDzerzerBCze; i++) {
                items.add((Poney) parc.readParcelable(
                        Poney.class.getClassLoader()));
            }
            this.setDzerzerBCze(items);
        }
        this.setIuytrezBa((User) parc.readParcelable(User.class.getClassLoader()));
    }

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel arg0, int arg1) {
		// TODO Auto-generated method stub

	}

}
