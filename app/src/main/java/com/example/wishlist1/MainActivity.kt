import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist1.GroceryWishlist
import com.example.wishlist1.R

class MainActivity : AppCompatActivity() {
   lateinit var adapter: GroceryWishlistAdapter
    lateinit var items: MutableList<GroceryWishlist>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView and its adapter
        val emailsRv = findViewById<RecyclerView>(R.id.grocery)
        items = mutableListOf()
        adapter = GroceryWishlistAdapter(items)

        // Set the adapter and layout manager
        emailsRv.adapter = adapter
        emailsRv.layoutManager = LinearLayoutManager(this)

        val submitButton = findViewById<Button>(R.id.submitbutton)
        submitButton.setOnClickListener {
            GroceryWishlistItems()
        }

    }
    private fun GroceryWishlistItems() {
        val editName = findViewById<EditText>(R.id.editName)
        val editPrice = findViewById<EditText>(R.id.editPrice)
        val editUrl = findViewById<EditText>(R.id.editUrl)

        val name = editName.text.toString()
        val price = editPrice.text.toString()
        val url = editUrl.text.toString()

        if (name.isNotBlank() && price.isNotBlank() && url.isNotBlank()) {
            val newItem = GroceryWishlist(name, price, url)
            items.add(newItem)
            adapter.notifyItemInserted(items.size - 1)

            // Clear the input fields after adding the item
            editName.text.clear()
            editPrice.text.clear()
            editUrl.text.clear()
        } else {
            // Handle empty input fields or any other validation logic here
            // For example, you can show a toast message indicating the missing fields
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
        }
    }


}

