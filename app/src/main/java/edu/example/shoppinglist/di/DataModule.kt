package edu.example.shoppinglist.di

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import edu.example.shoppinglist.data.AppDataBase
import edu.example.shoppinglist.data.ShopListDao
import edu.example.shoppinglist.data.ShopListRepositoryImpl
import edu.example.shoppinglist.domain.ShopListRepository

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object{

        @ApplicationScope
        @Provides
        fun provideShopListDao (
            application: Application
        ): ShopListDao {
            return AppDataBase.getInstance(application).shopListDao()
        }
    }
}