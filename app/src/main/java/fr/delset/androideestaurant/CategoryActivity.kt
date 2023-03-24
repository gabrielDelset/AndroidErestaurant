package fr.delset.androideestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import fr.delset.androideestaurant.databinding.ActivityCategoryBinding
import android.content.Intent

class CategoryActivity : AppCompatActivity() {
    private lateinit var adapter: CategoryAdapter
    private lateinit var binding: ActivityCategoryBinding // Inclure la classe de liaison chatGPT
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater) // Instancier la classe de liaison  chatGPT
        setContentView(binding.root)

        binding.categoryTitle.text = intent.getStringExtra("category") ?:""

        val dishes = resources.getStringArray(R.array.dishes).toList() as ArrayList // Récupérer la liste des plats depuis les ressources
        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(this) // Définir le LayoutManager pour le RecyclerView
        adapter = CategoryAdapter(dishes) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("dish", it)
            startActivity(intent)

        }

private fun getDishesFromServer() {
    val queue =Volley.bewRequestQueue(this)
}
    }

}



/*

    val queue = Volley.newRequestQueue(this)
    val url = "https://www.google.com"   //URL A MODIF

// Request a string response from the provided URL.
    val stringRequest = StringRequest(Request.Method.GET, url,
        Response.Listener<String> { response ->
            // Display the first 500 characters of the response string.
           Log.d("CategoryActivity")
        },
        Response.ErrorListener { textView.text = "That didn't work!" })

// Add the request to the RequestQueue.
    queue.add(stringRequest)
}
*/*/




/*






 */