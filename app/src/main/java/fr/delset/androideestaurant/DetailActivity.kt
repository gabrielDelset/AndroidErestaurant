package fr.delset.androideestaurant

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.delset.androideestaurant.model.Items

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dish = intent.getSerializableExtra("dish") as? Items

        val titleTextView = findViewById<TextView>(R.id.Titre)
        val imageView = findViewById<ImageView>(R.id.imageView)

        titleTextView.text = dish?.nameFr

       // dish?.imageUrl?.let {
         //   Picasso.get().load(it).into(imageView)
        }
    }


/*



 */