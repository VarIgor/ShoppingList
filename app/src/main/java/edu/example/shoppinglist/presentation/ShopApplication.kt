package edu.example.shoppinglist.presentation

import android.app.Application
import edu.example.shoppinglist.di.DaggerApplicationComponent

class ShopApplication : Application() {
    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}