package com.helloworldstudios.todoapp.di

import android.content.Context
import androidx.room.Room
import com.helloworldstudios.todoapp.data.repo.IslerDaoRepository
import com.helloworldstudios.todoapp.room.IslerDao
import com.helloworldstudios.todoapp.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideIslerDaoRepository(idao: IslerDao) : IslerDaoRepository{
        return IslerDaoRepository(idao)
    }

    @Provides
    @Singleton
    fun provideIslerDao(@ApplicationContext context: Context) : IslerDao{
        val db = Room.databaseBuilder(context, Veritabani::class.java, "todoapp.sqlite")
            .createFromAsset("todoapp.sqlite").build()
        return db.getIslerDao()
    }
}