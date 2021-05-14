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
import com.squareup.picasso.Picasso
import java.math.RoundingMode

class CryptoAdapter(val cryptos: List<Crypto>) :
    RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {

    inner class CryptoViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun setData(itemView: View, position: Int) {

            val crypto = cryptos[position]

            val imageBox = itemView.findViewById<ImageView>(R.id.crypto_image)
//            if (product.image.isNotEmpty()) Picasso.get().load(product.image.toString()).into(imageBox)

            itemView.findViewById<TextView>(R.id.crypto_name).text =
                "${crypto.name} (${crypto.symbol})"

            itemView.findViewById<TextView>(R.id.crypto_price).text =
                crypto.price.toBigDecimal().setScale(5, RoundingMode.DOWN).toString()

            itemView.findViewById<ConstraintLayout>(R.id.crypto_item_container).setOnClickListener {
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

        val mImageButton = holder.itemView.findViewById<ImageButton>(R.id.crypto_button_menu)
        mImageButton.setOnClickListener {
            showPopupMenu(
                mImageButton,
                position
            )
        }
    }

    private fun showPopupMenu(view: View, position: Int) {
        val popup = PopupMenu(view.context, view)
        val inflater: MenuInflater = popup.menuInflater
//        inflater.inflate(R.menu.card_product_menu, popup.menu)
        //      popup.setOnMenuItemClickListener(MyMenuItemClickListener(position))
        popup.show()
    }

    override fun getItemCount(): Int {
        return cryptos.size
    }

}