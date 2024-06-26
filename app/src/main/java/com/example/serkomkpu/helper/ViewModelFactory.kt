package com.example.serkomkpu.helper

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory private constructor(private val mApplication: Application) : ViewModelProvider.NewInstanceFactory(){
    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        @JvmStatic
        fun getInstance(application: Application): ViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    INSTANCE = ViewModelFactory(application)
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(DaftarViewModel::class.java) -> {
                DaftarViewModel(mApplication) as T
            }

            modelClass.isAssignableFrom(EntryViewModel::class.java) -> {
                EntryViewModel(mApplication) as T
            }

            else ->
                throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}