package edu.example.shoppinglist.data

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import edu.example.shoppinglist.domain.ShopItem
import edu.example.shoppinglist.domain.ShopListRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.lang.RuntimeException
import javax.inject.Inject
import kotlin.random.Random

class ShopListRepositoryImpl @Inject constructor(
    private val shopListDao: ShopListDao,
    private val mapper: ShopListMapper
) : ShopListRepository {

//    private val shopListDao = AppDataBase.getInstance(application).shopListDao()
//    private val mapper = ShopListMapper()

//    конструктор класса принимал application: Application

//    private val shopListLD = MutableLiveData<List<ShopItem>>()
//    private val shopList = sortedSetOf<ShopItem>({ o1, o2 -> o1.id.compareTo(o2.id) })
//
//    private var autoIncrementId = 0
//
//    init {
//        for (i in 0 until 10) {
//            val item = ShopItem("Name $i", i, Random.nextBoolean())
//            addShopItem(item)
//        }
//    }

    override suspend fun addShopItem(shopItem: ShopItem) {
//        if (shopItem.id == ShopItem.UNDEFINED_ID) {
//            shopItem.id = autoIncrementId++
//        }
//        shopList.add(shopItem)
//        updateList()
        shopListDao.addAndEditShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override fun getShopList(): Flow<List<ShopItem>> {
//        return shopListLD
//        return shopListDao.getShopList().map { mapper.mapListDbModelToListEntity(it) }
//        return MediatorLiveData<List<ShopItem>>().apply {
//            addSource(shopListDao.getShopList()) {
//                value = mapper.mapListDbModelToListEntity(it)
//            }
//        }
        return shopListDao.getShopList().map { mapper.mapListDbModelToListEntity(it) }
    }

    override suspend fun getShopItem(id: Int): ShopItem {
//        return shopList.find { it.id == id }
//            ?: throw RuntimeException("Element with id $id not found")
        return mapper.mapDbModelToEntity(shopListDao.getShopItem(id))
    }

    override suspend fun editShopItem(shopItem: ShopItem) {
//        val oldElement = getShopItem(shopItem.id)
//        shopList.remove(oldElement)
//        addShopItem(shopItem)
        shopListDao.addAndEditShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override suspend fun deleteShopItem(shopItem: ShopItem) {
//        shopList.remove(shopItem)
//        updateList()
        shopListDao.deleteShopItem(shopItem.id)
    }

//    private fun updateList() {
//        shopListLD.value = shopList.toList()
//    }


}