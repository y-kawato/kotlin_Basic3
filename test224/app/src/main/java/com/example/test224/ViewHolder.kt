package com.example.test224

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.one_result.view.*

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var dateText: TextView? = null
    var limitdateText: TextView? = null
    var titleText: TextView? = null
    var contentsText: TextView? = null
    init {
        dateText = itemView.dateText
        limitdateText = itemView.limitdateText
        titleText = itemView.titleText
        contentsText = itemView.contentsText
    }
}