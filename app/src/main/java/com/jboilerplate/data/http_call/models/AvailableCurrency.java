
package com.jboilerplate.data.http_call.models;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class AvailableCurrency {

    @SerializedName("CurrencySymbol")
    private String mCurrencySymbol;
    @SerializedName("CustomProperties")
    private com.jboilerplate.data.http_call.models.CustomProperties mCustomProperties;
    @SerializedName("Id")
    private Long mId;
    @SerializedName("Name")
    private String mName;

    public String getCurrencySymbol() {
        return mCurrencySymbol;
    }

    public void setCurrencySymbol(String CurrencySymbol) {
        mCurrencySymbol = CurrencySymbol;
    }

    public com.jboilerplate.data.http_call.models.CustomProperties getCustomProperties() {
        return mCustomProperties;
    }

    public void setCustomProperties(com.jboilerplate.data.http_call.models.CustomProperties CustomProperties) {
        mCustomProperties = CustomProperties;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long Id) {
        mId = Id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String Name) {
        mName = Name;
    }

}
