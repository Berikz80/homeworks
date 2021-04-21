package by.isb.an07

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
        val radioGroup = view.findViewById<RadioGroup>(R.id.input_snowdrop_color)

        var currentColor = ""

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            view.findViewById<RadioButton>(checkedId)?.apply {
                currentColor = text.toString()
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
            if (viewModel.Snowdrops.add(
                    MutableLiveData(
                        Snowdrop(
                            name = inputName.toString(),
                            image = "",
                            color = currentColor,
                            height = inputHeight.progress
                        )
                    )
                )
            ) Toast.makeText(
                context,
                "Snowdrop \'${inputName.toString()}\' added",
                Toast.LENGTH_SHORT
            ).show()
            else Toast.makeText(context, "Error adding snowdrop", Toast.LENGTH_SHORT).show()

        }

    }


}