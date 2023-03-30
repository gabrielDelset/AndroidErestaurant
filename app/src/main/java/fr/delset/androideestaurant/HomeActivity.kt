package fr.delset.androideestaurant

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.delset.androideestaurant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val entree = findViewById<Button>(R.id.button4)
        entree.setOnClickListener {
            Toast.makeText(this,"vous avez cliqué sur entrée", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("category",getString(R.string.home_starters))
            startActivity(intent)
        }


        val plat = findViewById<Button>(R.id.button5)
        plat.setOnClickListener {
            Toast.makeText(this,"vous avez cliqué sur plats", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("category", "Plats")
            startActivity(intent)
        }


        val dessert = findViewById<Button>(R.id.button6)
        dessert.setOnClickListener {
            Toast.makeText(this,"vous avez cliqué sur Dessert", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("category", "Desserts")
            startActivity(intent)
        }
    }
}

/*




 */





//  binding.button4.setOnClickListener {
//      val intent = Intent(this, CategoryActivity::class.java)
//       startActivity(intent)
//    }