package edu.example.shoppinglist.domain



class GetShopItemUseCase (private val shopListRepository: ShopListRepository) {
     fun getShopItem(shopItemId: Int){
        shopListRepository.getShopItem(shopItemId)
    }
}