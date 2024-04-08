import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist1.GroceryWishlist
import com.example.wishlist1.R

class GroceryWishlistAdapter(private val wishlist: List<GroceryWishlist>) :
    RecyclerView.Adapter<GroceryWishlistAdapter.WishlistViewHolder>() {

    inner class WishlistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textName)
        val priceTextView: TextView = itemView.findViewById(R.id.textPrice)
        val urlTextView: TextView = itemView.findViewById(R.id.textUrl)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishlistViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.grocerywishlist_items1, parent, false)
        return WishlistViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WishlistViewHolder, position: Int) {
        val currentItem = wishlist[position]
        holder.nameTextView.text = currentItem.Name
        holder.priceTextView.text = currentItem.Price.toString()
        holder.urlTextView.text = currentItem.Url
    }

    override fun getItemCount() = wishlist.size
}
