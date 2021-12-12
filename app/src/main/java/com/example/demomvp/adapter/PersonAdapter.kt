package com.example.demomvp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demomvp.R
import com.example.demomvp.dao.OnClickItemPerson
import com.example.demomvp.model.Person

class PersonAdapter (
    private val listPerson: List<Person>,
    private val onClickItem: OnClickItemPerson
) :
    RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPerson.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listPerson[position])
        holder.itemView.setOnClickListener {
            listPerson[position].id.let { id -> onClickItem.onClickItem(id) }
        }
    }

    /**
     * class viewHolder item
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(person: Person) {
            val tvName = itemView.findViewById<TextView>(R.id.tv_name)
            val tvAge = itemView.findViewById<TextView>(R.id.tv_age)

            tvName.text = person.name
            tvAge.text = person.age.toString()
        }
    }
}
