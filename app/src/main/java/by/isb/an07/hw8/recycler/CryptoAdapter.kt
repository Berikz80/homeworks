package by.isb.an07.hw8.recycler

import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.PopupMenu
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import by.isb.an07.R
import by.isb.an07.hw8.data.entities.crypto.Crypto
import com.google.android.material.snackbar.Snackbar
import java.math.RoundingMode

class CryptoAdapter(val cryptos: List<Crypto>) :
    RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {

    inner class CryptoViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun setData(itemView: View, position: Int) {

            val crypto = cryptos[position]

            val cryptoContainer =
                itemView.findViewById<ConstraintLayout>(R.id.crypto_item_container)

            val imageBox = itemView.findViewById<ImageView>(R.id.crypto_image)

            if (crypto.percentChange1h > 0) {
                imageBox.setImageResource(R.drawable.ic_trending_up)
                cryptoContainer.setBackgroundResource(R.color.green)
            } else if (crypto.percentChange1h < 0) {
                imageBox.setImageResource(R.drawable.ic_trending_down)
                cryptoContainer.setBackgroundResource(R.color.red)
            } else imageBox.setImageResource(R.drawable.ic_trending_flat)

            itemView.findViewById<TextView>(R.id.crypto_name).text =
                "${crypto.name} (${crypto.symbol})"

            itemView.findViewById<TextView>(R.id.crypto_price).text =
                crypto.price.toBigDecimal().setScale(5, RoundingMode.DOWN).toString()

            itemView.findViewById<TextView>(R.id.crypto_percent).text =
                crypto.percentChange1h.toBigDecimal().setScale(2, RoundingMode.DOWN).toString()+"%"

            cryptoContainer.setOnClickListener {
                Snackbar.make(view, crypto.name, Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_crypto, parent, false)
        return CryptoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        holder.setData(holder.itemView, position)

        val mFavButton = holder.itemView.findViewById<ImageButton>(R.id.crypto_button_menu)
        mFavButton.setOnClickListener {



        }
    }

    override fun getItemCount(): Int {
        return cryptos.size
    }

}