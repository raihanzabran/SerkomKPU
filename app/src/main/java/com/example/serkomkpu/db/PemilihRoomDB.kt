package com.example.serkomkpu.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PemilihDB::class], version = 1)
abstract class PemilihRoomDB : RoomDatabase() {

    abstract fun pemilihDao(): PemilihDao

    companion object {
        @Volatile
        private var INSTANCE: PemilihRoomDB? = null

        @JvmStatic
        fun getDatabase(context: android.content.Context): PemilihRoomDB {
            if (INSTANCE == null) {
                synchronized(PemilihRoomDB::class.java) {
                    INSTANCE = androidx.room.Room.databaseBuilder(
                        context.applicationContext,
                        PemilihRoomDB::class.java, "pemilih_database")
                        .build()
                }
            }
                return INSTANCE as PemilihRoomDB
            }
    }
}