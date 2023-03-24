package fr.delset.androideestaurant;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(private var dishes: List<String>, val ont) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryItem: TextView = view.findViewById(R.id.categoryItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dish = dishes[position]
        holder.categoryItem.text = dish
    }

    override fun getItemCount(): Int {
        return dishes.size
    }
    fun updateDishes(dishesFromAPI: ArrayList<String>){
        dishes = dishesFromAPI
    }
}
