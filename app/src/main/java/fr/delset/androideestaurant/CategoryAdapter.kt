package fr.delset.androideestaurant;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.delset.androideestaurant.model.Items
import fr.delset.androideestaurant.model.Prices

class CategoryAdapter(private var dishes: List<Items>,val function: (Items) -> Unit) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryItem: TextView = view.findViewById(R.id.NomPlat)
        val ImagePlat: ImageView = view.findViewById(R.id.ImagePlat)
        val PriceItem: TextView = view.findViewById(R.id.Price)  //pour ajouter les prix

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dish = dishes[position]
        holder.categoryItem.text = dish.nameFr // update the TextView with the name of the dish
       // holder.PriceItem.text = dish.prices.price               //tentative d'ajout du prix
        if (dish.images[0].isNotEmpty()){
            Picasso.get().load(dishes[position].images[0])
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.ImagePlat)
        }
        holder.itemView.setOnClickListener {
            function(dish)
        }
    }

    override fun getItemCount(): Int {
        return dishes.size
    }
    fun updateDishes(dishesFromAPI: List<Items>) {
        dishes = dishesFromAPI
        notifyDataSetChanged() // refresh the RecyclerView
    }
}