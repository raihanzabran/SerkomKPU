package com.example.serkomkpu.helper

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.serkomkpu.db.PemilihDB
import com.example.serkomkpu.repository.Repository

class EntryViewModel(mApplication: Application) : AndroidViewModel(mApplication){
        private val mRepository: Repository = Repository(mApplication)
    fun insert(entry: PemilihDB)
    {
        mRepository.insert(entry)
    }

    fun update(entry: PemilihDB)
    {
        mRepository.update(entry)
    }

    fun getPemilihByNIK(nik: String): LiveData<PemilihDB>
    {
        return mRepository.getDatapemilihNIK(nik)
    }

    fun delete(entry: PemilihDB)
    {
        mRepository.delete(entry)
    }
}
