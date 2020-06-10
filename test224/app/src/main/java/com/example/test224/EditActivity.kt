package com.example.test224

import android.os.Bundle
import io.realm.Realm
import io.realm.kotlin.createObject
import androidx.appcompat.app.AppCompatActivity
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_edit.*
import java.util.*

class EditActivity : AppCompatActivity() {
    private lateinit var realm:Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        realm = Realm.getDefaultInstance()
        val tdId = intent.getLongExtra("todoId",0L)
        if (tdId > 0L) {
            val todo = realm.where<Todo>().equalTo("todoId",tdId).findFirst()
            titleEdit.setText(todo?.title.toString())
            contentsEdit.setText(todo?.contents.toString())
        }

        saveBtn.setOnClickListener {
            var title: String = ""
            var contents: String = ""

            if (!titleEdit.text.isNullOrEmpty()) {
                title = titleEdit.text.toString().trim()


                if (!contentsEdit.text.isNullOrEmpty()) {
                    contents = contentsEdit.text.toString()
                }
                when (tdId) {
                    0L -> {


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
                    }
                    else -> {
                        realm.executeTransaction {
                            val todo = realm.where<Todo>().equalTo("todoId",tdId).findFirst()
                            todo?.title = title
                            todo?.contents = contents
                        }
                    }
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
