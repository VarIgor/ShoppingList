package edu.example.shoppinglist.domain

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)
    fun getShopList(): List<ShopItem>
    fun getShopItem(id: Int): ShopItem
    fun editShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)

}