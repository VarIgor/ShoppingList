package edu.example.shoppinglist.domain

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class GetShopListUseCase (private val shopListRepository: ShopListRepository){
    fun getShopList(): Flow<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}