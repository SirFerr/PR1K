package com.example.pr1k.UI.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.pr1k.Data.Item.Item
import com.example.pr1k.Data.Item.ItemDatabase
import com.example.pr1k.Data.Item.ItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemVM(application: Application) : AndroidViewModel(application) {
    private val repository: ItemRepository
    val getAllData: LiveData<List<Item>>

    init {
        val itemDao = ItemDatabase.getDatabase(application).itemDao()
        repository = ItemRepository(itemDao)
        getAllData = repository.getAllData
    }

    fun addItem(item: Item) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addItem(item)
        }
    }


}