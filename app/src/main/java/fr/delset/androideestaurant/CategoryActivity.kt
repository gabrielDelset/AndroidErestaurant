package fr.delset.androideestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import fr.delset.androideestaurant.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
    private lateinit var adapter: CategoryAdapter
    private lateinit var binding: ActivityCategoryBinding // Inclure la classe de liaison chatGPT
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater) // Instancier la classe de liaison  chatGPT
        setContentView(binding.root)

        val dishes = resources.getStringArray(R.array.dishes).toList() as ArrayList // Récupérer la liste des plats depuis les ressources
        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(this) // Définir le LayoutManager pour le RecyclerView
        binding.categoryRecyclerView.adapter = CategoryAdapter(dishes) {
        val intent = intent(this, DetailActivity::class.java)
            intent.putExtra("dih", it)
            startActivity(intent)
        } // Définir l'adaptateur pour le RecyclerView
    }
    val textView = findViewById<TextView>(R.id.text)
private fun getDishFromServer(){
    val textView = findViewById<TextView>(R.id.text)
// ...
/*
    val body = JSONobject()
    body.put("id_shop","1")
    val JsonObjectRequest =JsonObjectRequest()
    Request.Method.POST, url , body,
    {
        log.d("Categoryactivity", "ça marche" : $reponse)
        val data = Gson().fromJson(reponse.toString(), DataResult::class.java)
        val.dishes =data.data[0].items.map
        val jsonObjet = JSIONobject(resonse)
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
*/
}
