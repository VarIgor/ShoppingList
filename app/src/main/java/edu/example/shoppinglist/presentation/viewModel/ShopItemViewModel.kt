package edu.example.shoppinglist.presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import edu.example.shoppinglist.data.ShopListRepositoryImpl
import edu.example.shoppinglist.domain.AddShopItemUseCase
import edu.example.shoppinglist.domain.EditShopItemUseCase
import edu.example.shoppinglist.domain.GetShopItemUseCase
import edu.example.shoppinglist.domain.ShopItem
import kotlinx.coroutines.launch


class ShopItemViewModel(application: Application): AndroidViewModel(application)  {

    private val repository = ShopListRepositoryImpl(application)

    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val getShopItemUseCase = GetShopItemUseCase(repository)

    private val _errorInputName = MutableLiveData<Boolean>()
    val errorInputName: LiveData<Boolean>
        get() = _errorInputName

    private val _errorInputCount = MutableLiveData<Boolean>()
    val errorInputCount: LiveData<Boolean>
        get() = _errorInputCount

    private val _shopItem = MutableLiveData<ShopItem>()
    val shopItem: LiveData<ShopItem>
        get() = _shopItem

    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

    fun addShopItem(inputName: String?, inputCount: String?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val resultValidate = validateInput(name, count)
        if (resultValidate) {
            viewModelScope.launch {
                addShopItemUseCase.addShopItem(ShopItem(name, count, true))
                finishScreen()
            }
        }
    }

    fun editShopItem(inputName: String?, inputCount: String?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val resultValidate = validateInput(name, count)
        if (resultValidate) {
            _shopItem.value?.let {
                viewModelScope.launch {
                    val item = it.copy(name = name, count = count)
                    editShopItemUseCase.editShopItem(item)
                    finishScreen()
                }
            }
        }
    }

    fun getShopItem(shopItemId: Int) {
        viewModelScope.launch {
            val item = getShopItemUseCase.getShopItem(shopItemId)
            _shopItem.value = item
        }
    }

    private fun parseName(inputName: String?): String {
        return inputName?.trim() ?: ""
    }

    private fun parseCount(inputCount: String?): Int {
        return try {
            inputCount?.trim()?.toInt() ?: 0
        }catch (e: Exception){
            0
        }
    }

    private fun validateInput(inputName: String, inputCount: Int): Boolean {
        var result = true
        if (inputName.isBlank()) {
            _errorInputName.value = true
            result = false
        }
        if (inputCount <= 0) {
            _errorInputCount.value = true
            result = false
        }
        return result
    }

    fun resetErrorName() {
        _errorInputName.value = false
    }

    fun resetErrorCount() {
        _errorInputCount.value = false
    }

    private fun finishScreen(){
        _shouldCloseScreen.value = Unit
    }
}
