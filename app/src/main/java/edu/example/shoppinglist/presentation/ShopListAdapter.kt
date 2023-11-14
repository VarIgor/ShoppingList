package edu.example.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.example.shoppinglist.R
import edu.example.shoppinglist.domain.ShopItem

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopListViewHolder>() {

    var shopList = listOf<ShopItem>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopListViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_shop_enabled, parent, false)
        return ShopListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return shopList.size
    }

    override fun onBindViewHolder(viewHolder: ShopListViewHolder, position: Int) {
        val shopItem = shopList[position]
        viewHolder.nameTextView.text = shopItem.name
        viewHolder.countTextView.text = shopItem.count.toString()
        viewHolder.itemView.setOnClickListener { true }
    }

    class ShopListViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTextView = itemView.findViewById<TextView>(R.id.tv_name)
        var countTextView = itemView.findViewById<TextView>(R.id.tv_count)
    }
}