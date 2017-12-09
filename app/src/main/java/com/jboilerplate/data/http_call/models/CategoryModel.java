package com.jboilerplate.data.http_call.models;

/**
 * Created by Ashraful on 3/23/2015.
 */
public class CategoryModel {
    private int ParentCategoryId;
    private int DisplayOrder;
    private String IconPath;
    private int Id;
    private String Name;
    private String Description;
    private int ProductCount;

    public int getParentCategoryId() {
        return ParentCategoryId;
    }

    public void setParentCategoryId(int parentCategoryId) {
        ParentCategoryId = parentCategoryId;
    }

    public int getDisplayOrder() {
        return DisplayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        DisplayOrder = displayOrder;
    }

    public String getIconPath() {
        return IconPath;
    }

    public void setIconPath(String iconPath) {
        IconPath = iconPath;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getProductCount() {
        return ProductCount;
    }

    public void setProductCount(int productCount) {
        ProductCount = productCount;
    }
}
