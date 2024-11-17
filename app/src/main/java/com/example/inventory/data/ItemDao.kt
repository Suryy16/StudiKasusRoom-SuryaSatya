package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

//Buat interface ItemDao
//Tambahkan Annotasi Dao diatas interface
@Dao
interface ItemDao {
    //Buat fungsi insert untuk menambahkan item dengan parameter item
    // dan Annotasi @Insert dengan onConflict = OnConflictStrategy.IGNORE
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    //Buat fungsi update untuk mengupdate item dengan parameter item
    @Update
    suspend fun update(item: Item)

    //Buat fungsi delete untuk menghapus item dengan parameter item
    @Delete
    suspend fun delete(item: Item)

    //Buat fungsi getItem untuk mendapatkan item berdasarkan id
    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>


    //Buat fungsi getAllItems untuk mendapatkan semua item yang ada dan diurutkan berdasarkan nama secara ascending
    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>>
}