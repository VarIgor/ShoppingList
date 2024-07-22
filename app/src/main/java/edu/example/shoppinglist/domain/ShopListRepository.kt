package edu.example.shoppinglist.domain

import kotlinx.coroutines.flow.Flow


interface ShopListRepository {

    suspend fun addShopItem(shopItem: ShopItem)
    suspend fun getShopItem(id: Int): ShopItem
    suspend fun editShopItem(shopItem: ShopItem)
    suspend fun deleteShopItem(shopItem: ShopItem)
    fun getShopList(): Flow<List<ShopItem>>

}