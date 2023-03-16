package fr.delset.androideestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import fr.delset.androideestaurant.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryBinding // Inclure la classe de liaison chatGPT
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater) // Instancier la classe de liaison  chatGPT
        setContentView(binding.root)

        val dishes = resources.getStringArray(R.array.dishes).toList() as ArrayList // Récupérer la liste des plats depuis les ressources
        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(this) // Définir le LayoutManager pour le RecyclerView
        binding.categoryRecyclerView.adapter = CategoryAdapter(dishes)  // Définir l'adaptateur pour le RecyclerView
    }
}
