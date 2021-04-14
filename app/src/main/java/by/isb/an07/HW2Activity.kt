package by.isb.an07

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HW2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_hw2)

        val buttonFlags = findViewById<Button>(R.id.button_flags)
        val buttonAnimation = findViewById<Button>(R.id.button_animation)

        buttonFlags.setOnClickListener {
            startActivity(Intent(this,FlagsActivity::class.java))
        }

        buttonAnimation.setOnClickListener {
            startActivity(Intent(this,AnimationActivity::class.java))
        }
    }
}