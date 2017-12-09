
package com.jboilerplate.data.http_call.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class Category {

    @SerializedName("Children")
    private List<Object> mChildren;
    @SerializedName("DisplayOrder")
    private Long mDisplayOrder;
    @SerializedName("Extension")
    private Object mExtension;
    @SerializedName("IconPath")
    private String mIconPath;
    @SerializedName("Id")
    private Long mId;
    @SerializedName("Name")
    private String mName;
    @SerializedName("ParentCategoryId")
    private Long mParentCategoryId;
    @SerializedName("ProductCount")
    private Long mProductCount;

    public List<Object> getChildren() {
        return mChildren;
    }

    public void setChildren(List<Object> Children) {
        mChildren = Children;
    }

    public Long getDisplayOrder() {
        return mDisplayOrder;
    }

    public void setDisplayOrder(Long DisplayOrder) {
        mDisplayOrder = DisplayOrder;
    }

    public Object getExtension() {
        return mExtension;
    }

    public void setExtension(Object Extension) {
        mExtension = Extension;
    }

    public String getIconPath() {
        return mIconPath;
    }

    public void setIconPath(String IconPath) {
        mIconPath = IconPath;
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

    public Long getParentCategoryId() {
        return mParentCategoryId;
    }

    public void setParentCategoryId(Long ParentCategoryId) {
        mParentCategoryId = ParentCategoryId;
    }

    public Long getProductCount() {
        return mProductCount;
    }

    public void setProductCount(Long ProductCount) {
        mProductCount = ProductCount;
    }

}
