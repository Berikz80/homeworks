package by.isb.an07

import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_hw3.*


class HW3Activity : AppCompatActivity() {

    lateinit var viewModel: HW3ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw3)

        viewModel = ViewModelProvider(this).get(HW3ViewModel::class.java)

        val anim: Animation = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 50
        anim.startOffset = 20
        anim.repeatMode = Animation.REVERSE
        anim.repeatCount = 2

        viewModel.isStop.observe(this){

            if (it) {
                val dialog = FinishDialogFragment("Победитель: " + viewModel.myRegions[viewModel.winner].value?.name.toString())
                dialog.show(supportFragmentManager, "custom")
            }
        }

        viewModel.myRegions[0].observe(this) {
            text1_1.text = it.corn.toString()
            text1_2.text = it.potato.toString()
            text1_3.text = it.cabbage.toString()
            layout_region1.startAnimation(anim)
        }

        viewModel.myRegions[1].observe(this) {
            text2_1.text = it.corn.toString()
            text2_2.text = it.potato.toString()
            text2_3.text = it.cabbage.toString()
            layout_region2.startAnimation(anim)
        }

        viewModel.myRegions[2].observe(this) {
            text3_1.text = it.corn.toString()
            text3_2.text = it.potato.toString()
            text3_3.text = it.cabbage.toString()
            layout_region3.startAnimation(anim)
        }

        viewModel.startDataLoading()

    }
}