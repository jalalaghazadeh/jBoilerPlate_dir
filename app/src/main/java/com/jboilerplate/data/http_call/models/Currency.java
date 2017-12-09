
package com.jboilerplate.data.http_call.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class Currency {
    @SerializedName("AvailableCurrencies")
    private List<AvailableCurrency> mAvailableCurrencies;
    @SerializedName("CurrentCurrencyId")
    private long mCurrentCurrencyId;
    @SerializedName("CustomProperties")
    private CustomProperties mCustomProperties;

    public List<AvailableCurrency> getAvailableCurrencies() {
        return mAvailableCurrencies;
    }

    public void setAvailableCurrencies(List<AvailableCurrency> AvailableCurrencies) {
        mAvailableCurrencies = AvailableCurrencies;
    }

    public long getCurrentCurrencyId() {
        return mCurrentCurrencyId;
    }

    public void setCurrentCurrencyId(long CurrentCurrencyId) {
        mCurrentCurrencyId = CurrentCurrencyId;
    }

    public CustomProperties getCustomProperties() {
        return mCustomProperties;
    }

    public void setCustomProperties(CustomProperties CustomProperties) {
        mCustomProperties = CustomProperties;
    }

}
