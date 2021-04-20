package by.isb.an07

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment

class AddSnowdropFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_snowdrop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val inputName = view.findViewById<EditText>(R.id.edit_name)
//        val inputAge = view.findViewById<EditText>(R.id.edit_age)
        val heightText = view.findViewById<TextView>(R.id.height_text)
        val heightBar = view.findViewById<SeekBar>(R.id.height_bar)

        heightBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                heightText.text = "Height = $progress cm"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        }

        )

       val buttonSave = view.findViewById<Button>(R.id.button_save_snowdrop)
        buttonSave.setOnClickListener {

        }

    }


}