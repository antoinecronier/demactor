package com.tactfactory.demactor.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

import com.tactfactory.harmony.annotation.Column;
import com.tactfactory.harmony.annotation.Column.Type;
import com.tactfactory.harmony.annotation.Entity;
import com.tactfactory.harmony.annotation.GeneratedValue;
import com.tactfactory.harmony.annotation.GeneratedValue.Strategy;
import com.tactfactory.harmony.annotation.Id;
import com.tactfactory.harmony.annotation.ManyToMany;
import com.tactfactory.harmony.annotation.ManyToOne;

@Entity
public class Poney  implements Serializable , Parcelable {

    /** Parent parcelable for parcellisation purposes. */
    protected List<Parcelable> parcelableParents;


	@Id
    @Column(type = Type.INTEGER, hidden = true)
    @GeneratedValue(strategy = Strategy.MODE_IDENTITY)
	private int idlioEm1;

	@Column(type = Type.STRING)
	private String iomAiome1;

	@ManyToMany(mappedBy = "JockeyDF1")
	private ArrayList<Jockey> jockgFhjeys1;

    @ManyToOne(inversedBy = "ponRTYeys1")
    private Score scorvbnBe1;

    /**
     * Default constructor.
     */
    public Poney() {

    }

     /**
     * Get the IdlioEm1.
     * @return the idlioEm1
     */
    public int getIdlioEm1() {
         return this.idlioEm1;
    }
     /**
     * Set the IdlioEm1.
     * @param value the idlioEm1 to set
     */
    public void setIdlioEm1(final int value) {
         this.idlioEm1 = value;
    }
     /**
     * Get the IomAiome1.
     * @return the iomAiome1
     */
    public String getIomAiome1() {
         return this.iomAiome1;
    }
     /**
     * Set the IomAiome1.
     * @param value the iomAiome1 to set
     */
    public void setIomAiome1(final String value) {
         this.iomAiome1 = value;
    }
     /**
     * Get the JockgFhjeys1.
     * @return the jockgFhjeys1
     */
    public ArrayList<Jockey> getJockgFhjeys1() {
         return this.jockgFhjeys1;
    }
     /**
     * Set the JockgFhjeys1.
     * @param value the jockgFhjeys1 to set
     */
    public void setJockgFhjeys1(final ArrayList<Jockey> value) {
         this.jockgFhjeys1 = value;
    }
     /**
     * Get the ScorvbnBe1.
     * @return the scorvbnBe1
     */
    public Score getScorvbnBe1() {
         return this.scorvbnBe1;
    }
     /**
     * Set the ScorvbnBe1.
     * @param value the scorvbnBe1 to set
     */
    public void setScorvbnBe1(final Score value) {
         this.scorvbnBe1 = value;
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
        dest.writeInt(this.getIdlioEm1());
        if (this.getIomAiome1() != null) {
            dest.writeInt(1);
            dest.writeString(this.getIomAiome1());
        } else {
            dest.writeInt(0);
        }

        if (this.getJockgFhjeys1() != null) {
            dest.writeInt(this.getJockgFhjeys1().size());
            for (Jockey item : this.getJockgFhjeys1()) {
                if (!this.parcelableParents.contains(item)) {
                    item.writeToParcel(dest, flags);
                } else {
                    dest.writeParcelable(null, flags);
                }
            }
        } else {
            dest.writeInt(-1);
        }
        if (this.getScorvbnBe1() != null
                    && !this.parcelableParents.contains(this.getScorvbnBe1())) {
            this.getScorvbnBe1().writeToParcel(dest, flags);
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
        this.setIdlioEm1(parc.readInt());
        int iomAiome1Bool = parc.readInt();
        if (iomAiome1Bool == 1) {
            this.setIomAiome1(parc.readString());
        }

        int nbJockgFhjeys1 = parc.readInt();
        if (nbJockgFhjeys1 > -1) {
            ArrayList<Jockey> items =
                new ArrayList<Jockey>();
            for (int i = 0; i < nbJockgFhjeys1; i++) {
                items.add((Jockey) parc.readParcelable(
                        Jockey.class.getClassLoader()));
            }
            this.setJockgFhjeys1(items);
        }
        this.setScorvbnBe1((Score) parc.readParcelable(Score.class.getClassLoader()));
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
