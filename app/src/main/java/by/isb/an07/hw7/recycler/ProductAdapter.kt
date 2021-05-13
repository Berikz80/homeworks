package by.isb.an07.hw7.recycler

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
import by.isb.an07.database.entity.Product
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso


class ProductAdapter(val products: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun setData(itemView: View, position: Int) {

            val product = products[position]

            val imageBox = itemView.findViewById<ImageView>(R.id.item_image)
            if (product.image.isNotEmpty()) Picasso.get().load(product.image.toString()).into(imageBox)

            itemView.findViewById<TextView>(R.id.item_name).text = product.name
            itemView.findViewById<TextView>(R.id.item_price).text = product.price.toString()
            itemView.findViewById<ConstraintLayout>(R.id.item_container).setOnClickListener {
                Snackbar.make(view, product.name, Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }



    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.setData(holder.itemView, position)

        val mImageButton = holder.itemView.findViewById<ImageButton>(R.id.card_button_menu)
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
        inflater.inflate(R.menu.card_product_menu, popup.menu)
  //      popup.setOnMenuItemClickListener(MyMenuItemClickListener(position))
        popup.show()
    }

    override fun getItemCount(): Int {
        return products.size
    }
}