package fr.delset.androideestaurant

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import fr.delset.androideestaurant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val entree= findViewById<Button>(R.id.button4)
        entree.setOnClickListener{

        }
    }

}