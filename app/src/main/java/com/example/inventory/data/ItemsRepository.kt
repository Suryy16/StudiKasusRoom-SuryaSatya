/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data

import kotlinx.coroutines.flow.Flow

//Buat interface ItemsRepository
interface ItemsRepository {
    //Buat fungsi getAllItemsStream() yang mengembalikan Flow<List<Item>>
    // untuk mendapatkan semua item dari database
    fun getAllItemsStream(): Flow<List<Item>>

    //Buat fungsi getItemStream(id: Int) yang mengembalikan Flow<Item?>
    // untuk mendapatkan item berdasarkan id yang diberikan
    fun getItemStream(id: Int): Flow<Item?>

    //Buat fungsi suspend insertItem(item: Item) untuk menyisipkan item ke database
    suspend fun insertItem(item: Item)

    //Buat fungsi suspend deleteItem(item: Item) untuk menghapus item dari database
    suspend fun deleteItem(item: Item)

    //Buat fungsi suspend updateItem(item: Item) untuk memperbarui item yang ada di database
    suspend fun updateItem(item: Item)
}
