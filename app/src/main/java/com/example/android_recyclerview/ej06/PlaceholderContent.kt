package com.example.android_recyclerview.ej06

import com.example.android_recyclerview.ej06.PlaceholderContent.ITEMS
import java.util.ArrayList


fun addNextItem() = PlaceholderContent.addNextItem()

object PlaceholderContent {

    val ITEMS: MutableList<PlaceholderItem> = ArrayList()


    private val COUNT = 25


    var contador = 30
    fun addNextItem() = addItem(createPlaceholderItem(contador))

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createPlaceholderItem(i))
        }
    }

    private fun addItem(item: PlaceholderItem) {
        ITEMS.add(item)
        //ITEM_MAP.put(item.id, item)
    }

    private fun createPlaceholderItem(position: Int): PlaceholderItem {
        return PlaceholderItem(position.toString(), "Item " + position, makeDetails(position))
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A placeholder item representing a piece of content.
     */
    data class PlaceholderItem(val id: String, val content: String, val details: String) {
        override fun toString(): String = content
    }
}