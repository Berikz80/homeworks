package by.isb.an07.hw11

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.isb.an07.R
import by.isb.an07.hw11.data.entities.holiday.Country
import com.squareup.picasso.Picasso

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    private var list = ArrayList<Country>()

    fun init(newList: ArrayList<Country>) {
        list = newList
        notifyDataSetChanged()
    }

    fun updateItem(item: Country?) {
        val oldItem = list.find {
            it.code == item?.code
        }
        val oldItemIndex = list.indexOf(oldItem)
        item?.let { list.set(oldItemIndex, it) }
        notifyItemChanged(oldItemIndex)
    }

    fun getCurrentList() = list

    inner class CountryViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: Country) {
            view.findViewById<TextView>(R.id.title_country).text = item.name

            Picasso.get().load(item.flag).into(view.findViewById<ImageView>(R.id.flag_country))

            if (item.nextHoliday != null && item.nextHolidayDate != null) {
                view.findViewById<ProgressBar>(R.id.holiday_progress_bar).visibility = View.GONE
                view.findViewById<TextView>(R.id.holiday_country).text = item.nextHolidayDate + item.nextHoliday
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}