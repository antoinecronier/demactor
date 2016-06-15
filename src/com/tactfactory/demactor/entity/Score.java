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
import com.tactfactory.harmony.annotation.Column.Type;
import com.tactfactory.harmony.annotation.GeneratedValue.Strategy;
import com.tactfactory.harmony.annotation.OneToMany;

@Entity
public class Score  implements Serializable , Parcelable {

    /** Parent parcelable for parcellisation purposes. */
    protected List<Parcelable> parcelableParents;


	@Id
    @Column(type = Type.INTEGER, hidden = true)
    @GeneratedValue(strategy = Strategy.MODE_IDENTITY)
	private int idFD1;

    @Column(type = Type.INTEGER, hidden = false)
    private int moneFGHFGy1;

	@OneToMany(targetEntity = "Poney", mappedBy = "scorvbnBe1")
	private ArrayList<Poney> ponRTYeys1;

    @OneToMany(targetEntity = "User", mappedBy = "scoFGHre1")
    private ArrayList<User> useGHHNrs1;

    /**
     * Default constructor.
     */
    public Score() {

    }

     /**
     * Get the IdFD1.
     * @return the idFD1
     */
    public int getIdFD1() {
         return this.idFD1;
    }
     /**
     * Set the IdFD1.
     * @param value the idFD1 to set
     */
    public void setIdFD1(final int value) {
         this.idFD1 = value;
    }
     /**
     * Get the MoneFGHFGy1.
     * @return the moneFGHFGy1
     */
    public int getMoneFGHFGy1() {
         return this.moneFGHFGy1;
    }
     /**
     * Set the MoneFGHFGy1.
     * @param value the moneFGHFGy1 to set
     */
    public void setMoneFGHFGy1(final int value) {
         this.moneFGHFGy1 = value;
    }
     /**
     * Get the PonRTYeys1.
     * @return the ponRTYeys1
     */
    public ArrayList<Poney> getPonRTYeys1() {
         return this.ponRTYeys1;
    }
     /**
     * Set the PonRTYeys1.
     * @param value the ponRTYeys1 to set
     */
    public void setPonRTYeys1(final ArrayList<Poney> value) {
         this.ponRTYeys1 = value;
    }
     /**
     * Get the UseGHHNrs1.
     * @return the useGHHNrs1
     */
    public ArrayList<User> getUseGHHNrs1() {
         return this.useGHHNrs1;
    }
     /**
     * Set the UseGHHNrs1.
     * @param value the useGHHNrs1 to set
     */
    public void setUseGHHNrs1(final ArrayList<User> value) {
         this.useGHHNrs1 = value;
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
        dest.writeInt(this.getIdFD1());
        dest.writeInt(this.getMoneFGHFGy1());

        if (this.getPonRTYeys1() != null) {
            dest.writeInt(this.getPonRTYeys1().size());
            for (Poney item : this.getPonRTYeys1()) {
                if (!this.parcelableParents.contains(item)) {
                    item.writeToParcel(dest, flags);
                } else {
                    dest.writeParcelable(null, flags);
                }
            }
        } else {
            dest.writeInt(-1);
        }

        if (this.getUseGHHNrs1() != null) {
            dest.writeInt(this.getUseGHHNrs1().size());
            for (User item : this.getUseGHHNrs1()) {
                if (!this.parcelableParents.contains(item)) {
                    item.writeToParcel(dest, flags);
                } else {
                    dest.writeParcelable(null, flags);
                }
            }
        } else {
            dest.writeInt(-1);
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
        this.setIdFD1(parc.readInt());
        this.setMoneFGHFGy1(parc.readInt());

        int nbPonRTYeys1 = parc.readInt();
        if (nbPonRTYeys1 > -1) {
            ArrayList<Poney> items =
                new ArrayList<Poney>();
            for (int i = 0; i < nbPonRTYeys1; i++) {
                items.add((Poney) parc.readParcelable(
                        Poney.class.getClassLoader()));
            }
            this.setPonRTYeys1(items);
        }

        int nbUseGHHNrs1 = parc.readInt();
        if (nbUseGHHNrs1 > -1) {
            ArrayList<User> items =
                new ArrayList<User>();
            for (int i = 0; i < nbUseGHHNrs1; i++) {
                items.add((User) parc.readParcelable(
                        User.class.getClassLoader()));
            }
            this.setUseGHHNrs1(items);
        }
    }

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub

	}

}
