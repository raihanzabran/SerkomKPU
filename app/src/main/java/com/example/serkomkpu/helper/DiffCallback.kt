package com.example.serkomkpu.helper

import androidx.recyclerview.widget.DiffUtil
import com.example.serkomkpu.db.PemilihDB

class DiffCallback (
    private val DataPemilihOldList: List<PemilihDB>,
    private val DataPemilihNewList: List<PemilihDB>
) : DiffUtil.Callback(){
    override fun getOldListSize(): Int = DataPemilihOldList.size

    override fun getNewListSize(): Int = DataPemilihNewList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return DataPemilihOldList[oldItemPosition].id == DataPemilihNewList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val dataPemilihOld = DataPemilihOldList[oldItemPosition]
        val dataPemilihNew = DataPemilihNewList[newItemPosition]
        return dataPemilihOld.id == dataPemilihNew.id
                && dataPemilihOld.nama == dataPemilihNew.nama
                && dataPemilihOld.nik == dataPemilihNew.nik
                && dataPemilihOld.alamat == dataPemilihNew.alamat
                && dataPemilihOld.nohp == dataPemilihNew.nohp
                && dataPemilihOld.jeniskelamin == dataPemilihNew.jeniskelamin
                && dataPemilihOld.date == dataPemilihNew.date
                && dataPemilihOld.latitude == dataPemilihNew.latitude
                && dataPemilihOld.longitude == dataPemilihNew.longitude
                && dataPemilihOld.foto.contentEquals(dataPemilihNew.foto)

    }


}