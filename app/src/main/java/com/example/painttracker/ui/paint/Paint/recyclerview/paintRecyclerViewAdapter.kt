package com.example.painttracker.ui.paint.Paint.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.painttracker.data.model.PaintModel
import androidx.recyclerview.widget.RecyclerView
import com.example.painttracker.data.model.PaintModel

class paintRecyclerViewAdapter(private val clickListener: (PaintModel) -> Unit)
    : RecyclerView.Adapter<paintRecyclerViewHolder>() {
    private val paints = ArrayList<PaintModel>()

    fun setData(paintsList: List<PaintModel>){
        paints.clear()
        paints.addAll(painstList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): paintRecyclerViewHolder {
        val binding = PaintItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return paintRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return paints.size
    }

    override fun onBindViewHolder(holder: paintRecyclerViewHolder, position: Int) {
        val paints = paints[position]
        holder.bind(paints, clickListener)
    }
}