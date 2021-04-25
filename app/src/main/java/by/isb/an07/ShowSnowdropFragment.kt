package by.isb.an07

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class ShowSnowdropFragment(private val index : Int) : Fragment() {

    lateinit var viewModel: HW4ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity()).get(HW4ViewModel::class.java)
        return inflater.inflate(R.layout.fragment_show_snowdrop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    override fun onResume() {
        super.onResume()

        val showName = view?.findViewById<TextView>(R.id.show_name)
        val showHeight = view?.findViewById<TextView>(R.id.show_height)
        val showColor = view?.findViewById<LinearLayout>(R.id.show_color)
        val showImage = view?.findViewById<ImageView>(R.id.show_image)

        showName?.text = viewModel.snowdrops[index].value?.name
        showHeight?.text = viewModel.snowdrops[index].value?.height.toString()
        showColor?.background = viewModel.snowdrops[index].value?.color
        showImage?.background = viewModel.snowdrops[index].value?.image
    }
}