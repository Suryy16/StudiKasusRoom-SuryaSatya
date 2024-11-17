package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Annotasi Database dengan entities = [Item::class], version = 1, exportSchema = false
//Inisialisasi dengan design pattern Singleton
@Database(entities = [Item::class], version = 1, exportSchema = false)

// Buat abstract class InventoryDatabase yang extends RoomDatabase
abstract class InventoryDatabase : RoomDatabase() {

    // Buat abstract fun itemDao() yang mengembalikan ItemDao
    abstract fun itemDao(): ItemDao

    // Buat companion object
    companion object {
        // Buat private var Instance yang merupakan nullable dan volatile
        @Volatile
        private var Instance: InventoryDatabase? = null

        // Buat fun getDatabase(context: Context): InventoryDatabase
        fun getDatabase(context: Context): InventoryDatabase {
            // Jika Instance null, maka buat database dengan databaseBuilder
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}