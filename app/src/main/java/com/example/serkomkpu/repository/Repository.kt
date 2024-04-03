package com.example.serkomkpu.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.serkomkpu.db.PemilihDB
import com.example.serkomkpu.db.PemilihDao
import com.example.serkomkpu.db.PemilihRoomDB
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class Repository(application: Application) {
    private val mPemilihDao : PemilihDao

    private val executorService : ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = PemilihRoomDB.getDatabase(application)
        mPemilihDao = db.pemilihDao()
    }

    fun getAllPemilih() : LiveData<List<PemilihDB>> = mPemilihDao.getDataPemilih()

    fun insert(datapemilih : PemilihDB){
        executorService.execute { mPemilihDao.insert(datapemilih) }
    }

    fun getDatapemilihNIK(nik : String) : LiveData<PemilihDB>{
        return mPemilihDao.getPemilihNIK(nik)

    }

    fun delete(datapemilih : PemilihDB){
        executorService.execute { mPemilihDao.delete(datapemilih) }
    }

    fun update(datapemilih : PemilihDB){
        executorService.execute { mPemilihDao.update(datapemilih) }
    }

}