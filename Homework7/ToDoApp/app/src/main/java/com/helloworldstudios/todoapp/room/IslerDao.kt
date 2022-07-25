package com.helloworldstudios.todoapp.room

import androidx.room.*
import com.helloworldstudios.todoapp.data.entity.Isler

@Dao
interface IslerDao {
    @Query("SELECT * FROM isler")
    suspend fun tumIsler() : List<Isler>

    @Insert
    suspend fun isEkle(yapilacak_is: Isler)

    @Update
    suspend fun isGuncelle(yapilacak_is: Isler)

    @Delete
    suspend fun isSil(yapilacak_is: Isler)

    @Query("SELECT * FROM isler WHERE yapilacak_is LIKE '%' || :aramaKelimesi || '%'")
    suspend fun isAra(aramaKelimesi: String) : List<Isler>
}