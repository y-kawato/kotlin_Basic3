package jp.co.stv_tech.test_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.auth.User
import kotlinx.android.synthetic.main.activity_main.*

private val lastName: Unit
    get() = Unit
private val firstName: Unit
    get() = Unit


class MainActivity(private val TAG: String = "MyMessage") : AppCompatActivity() {
    private lateinit var mAdapter: UserFirestoreRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = FirebaseFirestore.getInstance()
        val query = db.collection("users").orderBy("firstName", Query.Direction.ASCENDING)

        val options = FirestoreRecyclerOptions.Builder<User>().setQuery(query, User::class.java).build()

        add_button.setOnClickListener {
            val firstName = firstname_edit.text.toString()
            val lastName = lastname_edit.text.toString()

            val user = User(firstName, lastName)

            db.collection("users")
                    .add(user)
                    .addOnSuccessListener { documentReference ->
                        Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                    }
                    .addOnFailureListener { e ->
                        Log.w(TAG, "Error adding document", e)
                    }

        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        mAdapter = UserFirestoreRecyclerAdapter(options)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mAdapter

    }
    private inner class UserViewHolder internal constructor(private val view: View) : RecyclerView.ViewHolder(view){
        internal fun setUserName(firstName: Unit, lastName: Unit){

            val textviewFirst = view.findViewById<TextView>(R.id.text_first)
            textviewFirst.text = firstName.toString()

            val textviewLast = view.findViewById<TextView>(R.id.text_last)
            textviewLast.text = lastName.toString()

        }
    }
    private inner class UserFirestoreRecyclerAdapter internal constructor(options: FirestoreRecyclerOptions<User>):
        FirestoreRecyclerAdapter<User, UserViewHolder>(options){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

            val view = LayoutInflater.from(parent.context).inflate(R.layout.raw,parent, false)
            return UserViewHolder(view)
        }

        override fun onBindViewHolder(holder: UserViewHolder, position: Int, model: User) {
            holder.setUserName(firstName, lastName)
        }

    }
    override fun onStart() {
        super.onStart()
        mAdapter.startListening()
    }
    override fun onStop() {
        super.onStop()

        mAdapter.stopListening()
    }
}