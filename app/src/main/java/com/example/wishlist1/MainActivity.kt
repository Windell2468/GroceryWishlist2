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
   lateinit var items: MutableList<GroceryWishlist>
   lateinit var groceryName: EditText
   lateinit var groceryPrice: EditText
   lateinit var groceryUrl: EditText
   lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items = mutableListOf()

        // Initialize RecyclerView and its adapter
        val groceryWishlistRv = findViewById<RecyclerView>(R.id.groceryList)
        val groceryWishlistAdapter = GroceryWishlistAdapter(items)

        // Set the adapter and layout manager
        groceryWishlistRv.adapter = groceryWishlistAdapter
        groceryWishlistRv.layoutManager = LinearLayoutManager(this)

        val groceryName = findViewById<EditText>(R.id.groceryName)
        val groceryPrice = findViewById<EditText>(R.id.groceryPrice)
        val groceryUrl = findViewById<EditText>(R.id.groceryUrl)

        val submitButton = findViewById<Button>(R.id.submitButton)
        submitButton.setOnClickListener {
            var groceryItem: GroceryWishlist = GroceryWishlist(
                groceryName.text.toString(),
                groceryUrl.text.toString(),
                groceryPrice.text.toString().toDouble()
            )

            items.add(groceryItem)
            groceryWishlistAdapter.notifyDataSetChanged()

            //Clear info
            groceryName.text.clear()
            groceryPrice.text.clear()
            groceryUrl.text.clear()
        }

    }

}

