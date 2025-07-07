package com.rajendra.notesapp_mvvm_cicd.di

import android.app.Application
import androidx.room.Room
import com.rajendra.notesapp_mvvm_cicd.data.local.NoteDatabase
import com.rajendra.notesapp_mvvm_cicd.data.repository.NoteRepositoryImpl
import com.rajendra.notesapp_mvvm_cicd.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }
}
