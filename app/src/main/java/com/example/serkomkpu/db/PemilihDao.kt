package com.example.serkomkpu.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface PemilihDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(pemilih: PemilihDB)

    @Update
    fun update(pemilih: PemilihDB)

    @Delete
    fun delete(pemilih: PemilihDB)

    @Query("SELECT * from pemilih ORDER BY id ASC")
    fun getDataPemilih(): LiveData<List<PemilihDB>>

    @Query("SELECT * FROM pemilih WHERE nik = :nik")
    fun getPemilihNIK(nik: String): LiveData<PemilihDB>
}