package edu.example.shoppinglist.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import edu.example.shoppinglist.presentation.viewModel.MainViewModel
import edu.example.shoppinglist.presentation.viewModel.ShopItemViewModel

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModule(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShopItemViewModel::class)
    fun bindShopItemViewModel(viewModel: ShopItemViewModel): ViewModel
}