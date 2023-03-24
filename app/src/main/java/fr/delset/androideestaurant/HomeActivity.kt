package fr.delset.androideestaurant

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.delset.androideestaurant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button4.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
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