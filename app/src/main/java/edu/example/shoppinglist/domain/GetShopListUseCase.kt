package edu.example.shoppinglist.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetShopListUseCase @Inject constructor(private val shopListRepository: ShopListRepository){
    fun getShopList(): Flow<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}