package com.example.painttracker.ui.paint.viewmodel

import android.view.LayoutInflater.Factory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.painttracker.data.model.PaintModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import com.example.painttracker.paintReviewerApplication
import com.example.painttracker.repositories.paintRepository

class paintViewModel(private val repository: paintRepository) : ViewModel() {
    var name = MutableLiveData("")
    var author = MutableLiveData("")
    var status = MutableLiveData("")


    fun getpaints() = repository.getpaints()

    fun addpaints(paints: PaintModel) = repository.addpaints(paints)

    fun createPaint() {

        if (!validationData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val paint = PaintModel(
            name.value!!,
            author.value!!
        )

        addpaints(paint)
        cleardata()

        status.value = PAINT_ADD
    }

    private fun validationData(): Boolean {
        when {
            name.value.isNullOrBlank() -> return false
            author.value.isNullOrBlank() -> return false
        }
        return false
    }

    fun cleardata() {
        name.value = ""
        author.value = ""
    }

    fun clearstatus() {
        status.value = INACTIVE
    }

    fun setSelectPaint(paints: PaintModel){
        name.value = paints.name
        author.value = paints.author
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as paintReviewerApplication
                paintViewModel(app.paintRepository)
            }
        }

        const val PAINT_ADD= "Paint add"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }

}