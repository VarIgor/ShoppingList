package edu.example.shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import edu.example.shoppinglist.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ShopListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()

        viewModel =
            ViewModelProvider.AndroidViewModelFactory(application).create(MainViewModel::class.java)
        viewModel.shopList.observe(this) {
          adapter.shopList = it
        }


    }

    private fun setupRecyclerView() {
        val shopListRecyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        adapter = ShopListAdapter()
        shopListRecyclerView.adapter = adapter
    }


}