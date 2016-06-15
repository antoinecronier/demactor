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
import com.tactfactory.harmony.annotation.OneToOne;
import com.tactfactory.harmony.annotation.Column.Type;
import com.tactfactory.harmony.annotation.GeneratedValue.Strategy;
import com.tactfactory.harmony.annotation.ManyToOne;

@Entity
public class User  implements Serializable , Parcelable {

    /** Parent parcelable for parcellisation purposes. */
    protected List<Parcelable> parcelableParents;


	@Id
    @Column(type = Type.INTEGER, hidden = true)
    @GeneratedValue(strategy = Strategy.MODE_IDENTITY)
	private int id1HNY;

	@Column(type = Type.STRING)
	private String naFGHme1;

	@Column(type = Type.STRING)
	private String surnFGHame1;

	@ManyToOne(inversedBy = "useGHHNrs1")
	private Score scoFGHre1;

    @OneToOne(targetEntity = "Jockey")
    private Jockey jocFGHkey1;

    /**
     * Default constructor.
     */
    public User() {

    }

     /**
     * Get the Id1HNY.
     * @return the id1HNY
     */
    public int getId1HNY() {
         return this.id1HNY;
    }
     /**
     * Set the Id1HNY.
     * @param value the id1HNY to set
     */
    public void setId1HNY(final int value) {
         this.id1HNY = value;
    }
     /**
     * Get the NaFGHme1.
     * @return the naFGHme1
     */
    public String getNaFGHme1() {
         return this.naFGHme1;
    }
     /**
     * Set the NaFGHme1.
     * @param value the naFGHme1 to set
     */
    public void setNaFGHme1(final String value) {
         this.naFGHme1 = value;
    }
     /**
     * Get the SurnFGHame1.
     * @return the surnFGHame1
     */
    public String getSurnFGHame1() {
         return this.surnFGHame1;
    }
     /**
     * Set the SurnFGHame1.
     * @param value the surnFGHame1 to set
     */
    public void setSurnFGHame1(final String value) {
         this.surnFGHame1 = value;
    }
     /**
     * Get the ScoFGHre1.
     * @return the scoFGHre1
     */
    public Score getScoFGHre1() {
         return this.scoFGHre1;
    }
     /**
     * Set the ScoFGHre1.
     * @param value the scoFGHre1 to set
     */
    public void setScoFGHre1(final Score value) {
         this.scoFGHre1 = value;
    }
     /**
     * Get the JocFGHkey1.
     * @return the jocFGHkey1
     */
    public Jockey getJocFGHkey1() {
         return this.jocFGHkey1;
    }
     /**
     * Set the JocFGHkey1.
     * @param value the jocFGHkey1 to set
     */
    public void setJocFGHkey1(final Jockey value) {
         this.jocFGHkey1 = value;
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
        dest.writeInt(this.getId1HNY());
        if (this.getNaFGHme1() != null) {
            dest.writeInt(1);
            dest.writeString(this.getNaFGHme1());
        } else {
            dest.writeInt(0);
        }
        if (this.getSurnFGHame1() != null) {
            dest.writeInt(1);
            dest.writeString(this.getSurnFGHame1());
        } else {
            dest.writeInt(0);
        }
        if (this.getScoFGHre1() != null
                    && !this.parcelableParents.contains(this.getScoFGHre1())) {
            this.getScoFGHre1().writeToParcel(dest, flags);
        } else {
            dest.writeParcelable(null, flags);
        }
        if (this.getJocFGHkey1() != null
                    && !this.parcelableParents.contains(this.getJocFGHkey1())) {
            this.getJocFGHkey1().writeToParcel(dest, flags);
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
        this.setId1HNY(parc.readInt());
        int naFGHme1Bool = parc.readInt();
        if (naFGHme1Bool == 1) {
            this.setNaFGHme1(parc.readString());
        }
        int surnFGHame1Bool = parc.readInt();
        if (surnFGHame1Bool == 1) {
            this.setSurnFGHame1(parc.readString());
        }
        this.setScoFGHre1((Score) parc.readParcelable(Score.class.getClassLoader()));
        this.setJocFGHkey1((Jockey) parc.readParcelable(Jockey.class.getClassLoader()));
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
