package fr.delset.androideestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import fr.delset.androideestaurant.databinding.ActivityCategoryBinding
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import com.android.volley.Request
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import fr.delset.androideestaurant.model.DataResult
import fr.delset.androideestaurant.model.Items

class CategoryActivity : AppCompatActivity() {
    private lateinit var adapter: CategoryAdapter
    private lateinit var binding: ActivityCategoryBinding
    private var category: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        category = intent.getStringExtra("category") ?: ""

        binding.categoryTitle.text = category

        getDishesFromServer()
    }

    private fun getDishesFromServer() {
        val queue = Volley.newRequestQueue(this)
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val body = JSONObject().apply { put("id_shop", "1") }
        val request = JsonObjectRequest(Request.Method.POST, url, body,
            {
                Log.d("CategoryActivity", "ça marche : $it")
                GetinfoServer(it.toString(), category)
            },
            {
                Log.e("CategoryActivity", "ça marche pas")
            }
        )

        queue.add(request)

    }


    private fun GetinfoServer(data: String, category: String) {
        val dishesResult = Gson().fromJson(data, DataResult::class.java)
        val dishCategory = dishesResult.data.firstOrNull { it.nameFr == category }
        val platList = arrayListOf<Items>()

        for (dishCat in dishesResult.data) {
            for (dish in dishCat.items) {
                if (dishCat.nameFr == category) {
                    platList.add(dish)
                }
            }
        }

        adapter = CategoryAdapter(platList) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("dishTitle", it.nameFr)
            intent.putExtra("dishDes", it.images)
            startActivity(intent)
        }

        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.categoryRecyclerView.adapter = adapter
    }
}











