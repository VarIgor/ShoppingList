package edu.example.shoppinglist.domain

data class ShopItem(

  var id: Int,
  val name: String,
  val count: Int,
  val enabled: Boolean

)
