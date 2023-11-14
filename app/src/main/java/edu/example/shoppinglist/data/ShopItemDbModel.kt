package edu.example.shoppinglist.data

import androidx.room.ColumnInfo
import androidx.room.Entity

import androidx.room.PrimaryKey

@Entity(tableName = "shop_list_items")
data class ShopItemDbModel(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "shop_item_id") var id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "count") val count: Int,
    @ColumnInfo(name = "enabled") val enabled: Boolean
)
