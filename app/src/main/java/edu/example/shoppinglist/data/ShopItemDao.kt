package edu.example.shoppinglist.data

 import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface ShopItemDao {
    @Insert
    fun addShopItem(shopItem: ShopItemDbModel)

    @Query("DELETE FROM shop_list_items WHERE shop_item_id=:shopItemId")
    fun deleteShopItem(shopItemId: Int)

    @Update
    fun editShopItem(shopItem: ShopItemDbModel)

    @Query("select * from shop_list_items where shop_item_id ==:shopItemId")
    fun getShopItem(shopItemId: Int):ShopItemDbModel

    @Query("select * from shop_list_items")
    fun getShopList():List<ShopItemDbModel>
}