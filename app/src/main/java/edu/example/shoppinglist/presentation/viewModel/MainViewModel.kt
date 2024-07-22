package edu.example.shoppinglist.presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import edu.example.shoppinglist.data.ShopListRepositoryImpl
import edu.example.shoppinglist.domain.DeleteShopItemUseCase
import edu.example.shoppinglist.domain.EditShopItemUseCase
import edu.example.shoppinglist.domain.GetShopListUseCase
import edu.example.shoppinglist.domain.ShopItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getShopListUseCase: GetShopListUseCase,
    private val editShopItemUseCase: EditShopItemUseCase,
    private val deleteShopItemUseCase: DeleteShopItemUseCase
) : ViewModel() {

    //наследовались от AndroidViewModel(application), конструктор принемал application:Application
//    private val repository = ShopListRepositoryImpl(application)
//    private val getShopListUseCase = GetShopListUseCase(repository)
//    private val editShopItemUseCase = EditShopItemUseCase(repository)
//    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList().asLiveData()

    fun changeEnableState(shopItem: ShopItem) {
        viewModelScope.launch {
            val newItem = shopItem.copy(enabled = !shopItem.enabled)
            editShopItemUseCase.editShopItem(newItem)
        }
    }

    fun deleteShopItem(shopItem: ShopItem) {
        viewModelScope.launch {
            deleteShopItemUseCase.deleteShopItem(shopItem)
        }
    }
}
