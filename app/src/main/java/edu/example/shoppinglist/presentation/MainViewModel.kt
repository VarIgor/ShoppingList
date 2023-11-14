package edu.example.shoppinglist.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import edu.example.shoppinglist.data.ShopListRepositoryImpl

import edu.example.shoppinglist.domain.DeleteShopItemUseCase
import edu.example.shoppinglist.domain.EditShopItemUseCase
import edu.example.shoppinglist.domain.GetShopListUseCase
import edu.example.shoppinglist.domain.ShopItem

class MainViewModel (application: Application) : AndroidViewModel(application) {

    private val repository = ShopListRepositoryImpl(application)

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)

    val shopList =  getShopListUseCase.getShopList()


    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

}