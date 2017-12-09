
package com.jboilerplate.data.http_call.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class BaseModel {

    @SerializedName("Count")
    private long mCount;
    @SerializedName("Currency")
    private Currency mCurrency;
    @SerializedName("Data")
    private List<Category> mData;
    @SerializedName("DisplayTaxInOrderSummary")
    private boolean mDisplayTaxInOrderSummary;
    @SerializedName("ErrorList")
    private List<Object> mErrorList;
    @SerializedName("Language")
    private Language mLanguage;
    @SerializedName("ShowDiscountBox")
    private boolean mShowDiscountBox;
    @SerializedName("StatusCode")
    private long mStatusCode;
    @SerializedName("SuccessMessage")
    private Object mSuccessMessage;

    public long getCount() {
        return mCount;
    }

    public void setCount(long Count) {
        mCount = Count;
    }

    public com.jboilerplate.data.http_call.models.Currency getCurrency() {
        return mCurrency;
    }

    public void setCurrency(com.jboilerplate.data.http_call.models.Currency Currency) {
        mCurrency = Currency;
    }

    public List<Category> getData() {
        return mData;
    }

    public void setData(List<Category> Data) {
        mData = Data;
    }

    public boolean getDisplayTaxInOrderSummary() {
        return mDisplayTaxInOrderSummary;
    }

    public void setDisplayTaxInOrderSummary(boolean DisplayTaxInOrderSummary) {
        mDisplayTaxInOrderSummary = DisplayTaxInOrderSummary;
    }

    public List<Object> getErrorList() {
        return mErrorList;
    }

    public void setErrorList(List<Object> ErrorList) {
        mErrorList = ErrorList;
    }

    public com.jboilerplate.data.http_call.models.Language getLanguage() {
        return mLanguage;
    }

    public void setLanguage(com.jboilerplate.data.http_call.models.Language Language) {
        mLanguage = Language;
    }

    public boolean getShowDiscountBox() {
        return mShowDiscountBox;
    }

    public void setShowDiscountBox(boolean ShowDiscountBox) {
        mShowDiscountBox = ShowDiscountBox;
    }

    public long getStatusCode() {
        return mStatusCode;
    }

    public void setStatusCode(long StatusCode) {
        mStatusCode = StatusCode;
    }

    public Object getSuccessMessage() {
        return mSuccessMessage;
    }

    public void setSuccessMessage(Object SuccessMessage) {
        mSuccessMessage = SuccessMessage;
    }

}
