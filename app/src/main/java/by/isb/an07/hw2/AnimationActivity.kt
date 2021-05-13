package by.isb.an07.hw2

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import by.isb.an07.R

class AnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        val imageBox = findViewById<ImageView>(R.id.image_box)
        imageBox.setBackgroundResource(R.drawable.cat_animation)
        (imageBox.background as AnimationDrawable).start()
    }
}