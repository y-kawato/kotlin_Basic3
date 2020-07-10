package com.example.test221

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import java.util.*

open class Todo : RealmObject(){
    @PrimaryKey
    var todoID: Long = 0 // id
    @Required
    var title: String = "" //　タイトル
    var contents: String = "" //内容
    var created: Date = Date() // 登録日
    var modified: Date = Date()  //変更日
    var limitDate: Date = Date() //期限日
    var deleteFlg: Boolean = true // 削除フラグ

}