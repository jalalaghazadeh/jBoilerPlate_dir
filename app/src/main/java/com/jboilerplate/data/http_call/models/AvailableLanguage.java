
package com.jboilerplate.data.http_call.models;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class AvailableLanguage {

    @SerializedName("CustomProperties")
    private com.jboilerplate.data.http_call.models.CustomProperties mCustomProperties;
    @SerializedName("FlagImageFileName")
    private String mFlagImageFileName;
    @SerializedName("Id")
    private Long mId;
    @SerializedName("Name")
    private String mName;

    public com.jboilerplate.data.http_call.models.CustomProperties getCustomProperties() {
        return mCustomProperties;
    }

    public void setCustomProperties(com.jboilerplate.data.http_call.models.CustomProperties CustomProperties) {
        mCustomProperties = CustomProperties;
    }

    public String getFlagImageFileName() {
        return mFlagImageFileName;
    }

    public void setFlagImageFileName(String FlagImageFileName) {
        mFlagImageFileName = FlagImageFileName;
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
