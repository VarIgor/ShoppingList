package edu.example.shoppinglist.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase


@Database(entities = [ShopItemDbModel::class], version = 1, exportSchema = false)
 abstract class AppDatabase: RoomDatabase() {

    abstract fun getShopItemDao(): ShopItemDao

    companion object{

        private var INSTANCE: AppDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "shop_list.db"

        fun getInstance(application: Application): AppDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = databaseBuilder(
                    application,
                    AppDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = db
                return db
            }
        }

    }

}