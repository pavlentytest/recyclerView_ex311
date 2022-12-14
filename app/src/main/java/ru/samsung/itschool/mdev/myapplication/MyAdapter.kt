package ru.samsung.itschool.mdev.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val list: List<Person>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val tvName: TextView = item.findViewById(R.id.tvName)
        val tvPhone: TextView = item.findViewById(R.id.tvPhone)
        val imgSex: ImageView = item.findViewById(R.id.imgSex)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val myItemView = LayoutInflater.from(parent.context).inflate(R.layout.item,parent, false)
        return MyViewHolder(myItemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvName.text = list.get(position).name
        holder.tvPhone.text = list.get(position).phoneNumber
        holder.imgSex.setImageResource(
            when(list.get(position).sex) {
                'M' -> R.drawable.ic_baseline_man_24
                else -> R.drawable.ic_baseline_woman_24
            }
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }
}