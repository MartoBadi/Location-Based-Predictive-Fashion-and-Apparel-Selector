
package com.ibm.mobileappbuilder.travelanalyser1.pkg120161001081254.ds;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class DataDSItem implements Parcelable, IdentifiableBean {

    @SerializedName("nAME") public String nAME;
    @SerializedName("tYPE") public String tYPE;
    @SerializedName("id") public String id;

    @Override
    public String getIdentifiableId() {
      return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nAME);
        dest.writeString(tYPE);
        dest.writeString(id);
    }

    public static final Creator<DataDSItem> CREATOR = new Creator<DataDSItem>() {
        @Override
        public DataDSItem createFromParcel(Parcel in) {
            DataDSItem item = new DataDSItem();

            item.nAME = in.readString();
            item.tYPE = in.readString();
            item.id = in.readString();
            return item;
        }

        @Override
        public DataDSItem[] newArray(int size) {
            return new DataDSItem[size];
        }
    };

}


