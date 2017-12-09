
package com.jboilerplate.data.http_call.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class Language {

    @SerializedName("AvailableLanguages")
    private List<AvailableLanguage> mAvailableLanguages;
    @SerializedName("CurrentLanguageId")
    private Long mCurrentLanguageId;
    @SerializedName("CustomProperties")
    private com.jboilerplate.data.http_call.models.CustomProperties mCustomProperties;
    @SerializedName("UseImages")
    private Boolean mUseImages;

    public List<AvailableLanguage> getAvailableLanguages() {
        return mAvailableLanguages;
    }

    public void setAvailableLanguages(List<AvailableLanguage> AvailableLanguages) {
        mAvailableLanguages = AvailableLanguages;
    }

    public Long getCurrentLanguageId() {
        return mCurrentLanguageId;
    }

    public void setCurrentLanguageId(Long CurrentLanguageId) {
        mCurrentLanguageId = CurrentLanguageId;
    }

    public com.jboilerplate.data.http_call.models.CustomProperties getCustomProperties() {
        return mCustomProperties;
    }

    public void setCustomProperties(com.jboilerplate.data.http_call.models.CustomProperties CustomProperties) {
        mCustomProperties = CustomProperties;
    }

    public Boolean getUseImages() {
        return mUseImages;
    }

    public void setUseImages(Boolean UseImages) {
        mUseImages = UseImages;
    }

}
