package com.example.pr1k.Data.Item

import androidx.lifecycle.LiveData

class ItemRepository(private val itemDao: ItemDao) {

    var getAllData: LiveData<List<Item>> = itemDao.getAll()
    suspend fun addItem(item: Item) {
        itemDao.insert(item)
    }


}