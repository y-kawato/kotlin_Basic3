package com.example.test223

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Todo : RealmObject(){
    @PrimaryKey
    var todoId: Long = 0
    var title: String = ""
    var contents: String = ""
    var created: Date = Date()
    var modified: Date = Date()
    var limitDate: Date = Date()
}