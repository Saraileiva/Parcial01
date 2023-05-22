package com.example.painttracker.repositories

import com.example.painttracker.data.model.PaintModel

class paintRepository(private val paints: MutableList<PaintModel>){

    fun getpaints() = paints

    fun addpaints(paint: PaintModel) = paints.add(paint)
}