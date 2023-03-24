package fr.delset.androideestaurant

import android.content.Intent
import android.os.Bundle
//import android.view.View
//import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import fr.delset.androideestaurant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

      //  binding.button4.setOnClickListener {
      //      val intent = Intent(this, CategoryActivity::class.java)
     //       startActivity(intent)
    //    }
    }

}