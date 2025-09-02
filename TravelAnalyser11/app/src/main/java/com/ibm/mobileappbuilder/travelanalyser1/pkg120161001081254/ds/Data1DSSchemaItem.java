
package com.ibm.mobileappbuilder.travelanalyser1.pkg120161001081254.ds;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Data1DSSchemaItem implements Parcelable, IdentifiableBean {

    @SerializedName("id") public String id;
    @SerializedName("name") public String name;
    @SerializedName("type") public String type;

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
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(type);
    }

    public static final Creator<Data1DSSchemaItem> CREATOR = new Creator<Data1DSSchemaItem>() {
        @Override
        public Data1DSSchemaItem createFromParcel(Parcel in) {
            Data1DSSchemaItem item = new Data1DSSchemaItem();

            item.id = in.readString();
            item.name = in.readString();
            item.type = in.readString();
            return item;
        }

        @Override
        public Data1DSSchemaItem[] newArray(int size) {
            return new Data1DSSchemaItem[size];
        }
    };

}


