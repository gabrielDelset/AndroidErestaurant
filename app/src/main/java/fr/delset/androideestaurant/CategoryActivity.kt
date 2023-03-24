package fr.delset.androideestaurant

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import fr.delset.androideestaurant.databinding.ActivityCategoryBinding
import android.content.Intent
import android.util.Log
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import com.android.volley.Request
import com.google.gson.Gson






class CategoryActivity : AppCompatActivity() {
    private lateinit var adapter: CategoryAdapter
    private lateinit var binding: ActivityCategoryBinding // Inclure la classe de liaison chatGPT
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            ActivityCategoryBinding.inflate(layoutInflater) // Instancier la classe de liaison  chatGPT
        setContentView(binding.root)

        binding.categoryTitle.text = intent.getStringExtra("category") ?: ""

        val dishes = resources.getStringArray(R.array.dishes)
            .toList() as ArrayList // Récupérer la liste des plats depuis les ressources
        binding.categoryRecyclerView.layoutManager =
            LinearLayoutManager(this) // Définir le LayoutManager pour le RecyclerView
        adapter = CategoryAdapter(dishes) {
            val intent = Intent(this, DetailActivity::class.java)
       //    intent.putExtra("dish", it)
            startActivity(intent)
        }
        binding.categoryRecyclerView.adapter=adapter
      //  getDishesFromServer()
    }

    private fun getDishesFromServer() {
        val queue = Volley.newRequestQueue(this)
        val url = "http://test.api.catering.bluecodegames.com/menu"

        val body = JSONObject()
        body.put("id_shop", 1)

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.POST, url, body,
            { response ->
                Log.d("CategoryActivity", "Response : $response")
                val data = Gson().fromJson(response.toString(), Dishinfo::class.java)
                val dishes = data.data.firstOrNull { response.category == "Plats" }?.item?.map { response.title ?: "" }
                adapter.updateDishes(dishes as ArrayList<String>)
            },
            { error ->
                Log.e("CategoryActivity", "Erreur lors de l'appel : ${error.localizedMessage}")
            }
        )
        queue.add(jsonObjectRequest)
    }
/*
    private fun parseJson(response: String, categoryTitle: String): ArrayList<String> {
        val dishes = ArrayList<String>()

        val gson = Gson()
        val dataResult = gson.fromJson(response, Dishinfo::class.java)

        val categoryData = dataResult.data.find { it.nameFr == categoryTitle }
        categoryData?.item?.forEach { item ->
            dishes.add(item.nameFr ?: "")
        }

        return dishes
    }

*/

}










