package by.isb.an07.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import by.isb.an07.R
import by.isb.an07.database.entity.Product
import com.google.android.material.snackbar.Snackbar

class ProductAdapter(val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun setData(itemView: View, position: Int) {

            val product = products[position]

//            itemView.findViewById<ImageView>(R.id.item_image).setImageResource(product.image)
            itemView.findViewById<TextView>(R.id.item_name).text = product.name
            itemView.findViewById<TextView>(R.id.item_price).text = product.price.toString()
            itemView.findViewById<ConstraintLayout>(R.id.item_container).setOnClickListener {
                Snackbar.make(view,product.name,Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.setData(holder.itemView, position)
    }

    override fun getItemCount(): Int {
        return products.size
    }
}