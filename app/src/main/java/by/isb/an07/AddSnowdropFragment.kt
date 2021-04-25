package by.isb.an07

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider


class AddSnowdropFragment : Fragment() {

    lateinit var viewModel: HW4ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_snowdrop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(HW4ViewModel::class.java)

        val inputName = view.findViewById<EditText>(R.id.input_snowdrop_name)
        val inputHeight = view.findViewById<SeekBar>(R.id.input_snowdrop_height)
        val heightText = view.findViewById<TextView>(R.id.height_text)
        val buttonSave = view.findViewById<Button>(R.id.button_save_snowdrop)
        val radioGroupColor = view.findViewById<RadioGroup>(R.id.input_snowdrop_color)
        val radioGroupImage = view.findViewById<RadioGroup>(R.id.input_snowdrop_image)

        var currentColor: Drawable? = null
        radioGroupColor.setOnCheckedChangeListener { _, checkedId ->
            view.findViewById<RadioButton>(checkedId)?.apply {
                currentColor = background
            }
        }
        var currentImage: Drawable? = null
        radioGroupImage.setOnCheckedChangeListener { _, checkedId ->
            view.findViewById<RadioButton>(checkedId)?.apply {
                currentImage = background
            }
        }

        inputHeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                heightText.text = "$progress cm"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        }
        )

        buttonSave.setOnClickListener {
            var allCorrect = true
            if (inputName.text.toString() == "") {
                Toast.makeText(context, "Enter name", Toast.LENGTH_SHORT).show()
                allCorrect = false
            }
            if (currentColor == null) {
                Toast.makeText(context, "Choose color", Toast.LENGTH_SHORT).show()
                allCorrect = false
            }
            if (currentImage == null) {
                Toast.makeText(context, "Choose image", Toast.LENGTH_SHORT).show()
                allCorrect = false
            }

            if (allCorrect)
                if (viewModel.snowdrops.add(
                        MutableLiveData(
                            Snowdrop(
                                name = inputName.text.toString(),
                                image = currentImage,
                                color = currentColor,
                                height = inputHeight.progress
                            )
                        )
                    )
                ) Toast.makeText(
                    context,
                    "Snowdrop \'${inputName.text.toString()}\' added",
                    Toast.LENGTH_SHORT
                ).show()
                else Toast.makeText(context, "Error adding snowdrop", Toast.LENGTH_SHORT).show()

        }

    }


}