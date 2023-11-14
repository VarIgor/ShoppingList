package edu.example.shoppinglist.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import edu.example.shoppinglist.domain.ShopItem
import edu.example.shoppinglist.domain.ShopListRepository
import java.util.concurrent.Executors
import kotlin.random.Random


class ShopListRepositoryImpl(application: Application) : ShopListRepository {


    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private var shopList = sortedSetOf<ShopItemDbModel>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private val shopItemDao = AppDatabase.getInstance(application).getShopItemDao()
    private val mapper = ShopListMapper()
    private val executor = Executors.newSingleThreadExecutor()

    init {
        for (i in 0 until 1000) {
            val item = ShopItem(0,  "Name $i",  i, Random.nextBoolean())
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        executor.execute { shopItemDao.addShopItem(mapper.mapEntityToDbModel(shopItem)) }
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        executor.execute { shopItemDao.deleteShopItem(shopItem.id) }
    }

    override fun editShopItem(shopItem: ShopItem) {
        executor.execute { shopItemDao.editShopItem(mapper.mapEntityToDbModel(shopItem)) }
    }

    override fun getShopItem(shopItemId: Int) {

        executor.execute { shopItemDao.getShopItem(shopItemId) }

    }

    override fun getShopList(): LiveData<List<ShopItem>> {
//        executor.execute { shopList = shopItemDao.getShopList().toMutableList() }
        return shopListLD
    }

    private fun updateList() {
        shopListLD.value = mapper.mapListDbModelToListEntity(shopList.toList())
    }


}