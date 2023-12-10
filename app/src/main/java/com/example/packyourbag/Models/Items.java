package com.example.packyourbag.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "items")
public class Items implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "item_name")
    private String itemName;

    @ColumnInfo(name = "category")
    private String category;

    @ColumnInfo(name = "addedby")
    private String addedBy;

    @ColumnInfo(name = "checked")
    private Boolean checked = false;

    // Default constructor, if needed
    public Items() {
    }

    public Items(String itemName, String category, Boolean checked) {
        this.addedBy = "system";
        this.itemName = itemName;
        this.category = category;
        this.checked = checked;
    }

    public Items(String itemName, String category, String addedBy, Boolean checked) {
        this.itemName = itemName;
        this.category = category;
        this.addedBy = addedBy;
        this.checked = checked;
    }

    // Getters and setters (if needed)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
