package by.isb.an07.hw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import by.isb.an07.R
import com.squareup.picasso.Picasso

class HW1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw1)

        val imageBox = findViewById<ImageView>(R.id.image_box)
        val inputUrl = findViewById<EditText>(R.id.input_url)
        val buttonShow = findViewById<Button>(R.id.button_show)

        buttonShow.setOnClickListener {
            if (inputUrl.text.isNotEmpty()) Picasso.get().load(inputUrl.text.toString()).into(imageBox)
            else Toast.makeText(this, "URL is empty", Toast.LENGTH_SHORT).show()
        }
    }
}