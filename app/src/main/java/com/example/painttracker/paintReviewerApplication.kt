package com.example.painttracker

import android.app.Application
import com.example.painttracker.data.paints
import com.example.painttracker.repositories.paintRepository

class paintReviewerApplication : Application() {
    val paintRepository: paintRepository by lazy {
        paintRepository(paints)
    }
}