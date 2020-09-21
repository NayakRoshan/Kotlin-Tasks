package com.example.mytask2.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mytask2.entity.PersonEntity
import com.example.mytask2.R
import kotlinx.android.synthetic.main.view_layout.view.*

class DetailsRecyclerViewAdapter(
    private val context : Context,
    private val dataSource : List<PersonEntity>,
    private val callDetailsFragment: (String)->Unit
) : RecyclerView.Adapter<DetailsRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id : TextView by lazy { itemView.personId }
        val name : TextView by lazy { itemView.name }
        val phoneNumber : TextView by lazy { itemView.phoneNumber }
        val age : TextView by lazy { itemView.age }
        val callPerson : Button by lazy { itemView.viewClick }

        fun adapterPosition() : Int = adapterPosition
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(this.context)
        return ViewHolder(
            inflater.inflate(
                R.layout.view_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data : PersonEntity = dataSource[position]
        holder.id.text = data.id.toString()
        holder.name.text = data.name
        holder.phoneNumber.text = data.phone
        holder.age.text = data.age.toString()
        holder.callPerson.setOnClickListener {
            val adapterPosition : Int = holder.adapterPosition()
            val person : PersonEntity = dataSource[adapterPosition]
            callDetailsFragment(person.name)
        }
    }

}