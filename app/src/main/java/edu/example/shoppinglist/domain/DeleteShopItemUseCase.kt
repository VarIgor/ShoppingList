package edu.example.shoppinglist.domain

import edu.example.shoppinglist.data.ShopListRepositoryImpl

class DeleteShopItemUseCase (private val shopListRepository: ShopListRepositoryImpl) {
     fun deleteShopItem(shopItem: ShopItem){
        shopListRepository.deleteShopItem(shopItem)
    }
}