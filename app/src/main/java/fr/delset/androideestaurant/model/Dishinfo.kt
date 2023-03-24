package fr.delset.androideestaurant

import android.view.MenuItem

data class Dishinfo(
    private val _id: String,
    val title: String,
    val description: String,
    val price: Double,
    val image: String,
    val category: String,
    val data: List<MenuItem> // Ajouter cette propriété
) {
    val id: String get() = _id
}
