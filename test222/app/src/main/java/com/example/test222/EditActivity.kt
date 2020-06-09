package com.example.test222

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_edit.*
import java.util.*

class EditActivity : AppCompatActivity() {
    private lateinit var realm:Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        realm = Realm.getDefaultInstance()

        saveBtn.setOnClickListener {
            var title: String = ""
            var contents: String = ""

            if (!titleEdit.text.isNullOrEmpty()) {
                title = titleEdit.text.toString().trim()


                if (!contentsEdit.text.isNullOrEmpty()) {
                    contents = contentsEdit.text.toString()
                }

                realm.executeTransaction {
                    val titleId = realm.where<Todo>().max("todoId")
                    val nextId = (titleId?.toLong() ?: 0L) + 1L
                    val todo = realm.createObject<Todo>(nextId)
                    todo.created = Date()
                    todo.modified = Date()
                    val cal = Calendar.getInstance()
                    cal.time = Date()
                    cal.add(Calendar.DATE, 7)
                    todo.limitDate = cal.time
                    todo.title = title
                    todo.contents = contents
                }
                finish()
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}
