package com.example.serkomkpu.helper

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.serkomkpu.db.PemilihDB
import com.example.serkomkpu.repository.Repository

class DaftarViewModel(mApplication: Application) : ViewModel(){
    private val mDaftarRepository: Repository = Repository(mApplication)

    fun getDaftar() : LiveData<List<PemilihDB>> = mDaftarRepository.getAllPemilih()

}
