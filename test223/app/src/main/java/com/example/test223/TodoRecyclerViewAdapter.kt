package com.example.test223

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.realm.RealmResults
import android.text.format.DateFormat


class TodoRecyclerViewAdapter(realmResults: RealmResults<Todo>) : RecyclerView.Adapter<ViewHolder>() {
    private val rResults:RealmResults<Todo> = realmResults

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.one_result,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return rResults.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo = rResults[position]
        //holder.dateText?.text = DateFormat.format("yyyy/MM/dd kk:mm",todo?.created)
        holder.limitdateText?.text = DateFormat.format("yyyy/MM/dd",todo?.limitDate)
        holder.titleText?.text = todo?.title.toString()
        holder.contentsText?.text = todo?.contents.toString()

    }
}