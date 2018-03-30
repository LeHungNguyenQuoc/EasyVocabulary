package easy.vocabulary.lequoc.com.vocabularyeasy.db.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import easy.vocabulary.lequoc.com.vocabularyeasy.db.dao.VocabularyDao
import easy.vocabulary.lequoc.com.vocabularyeasy.entity.Vocabulary

/**
 * Created by quocle on 3/30/18.
 */
@Database(entities = arrayOf(Vocabulary::class), version = 1)
abstract class VocabularyDatabase : RoomDatabase() {
    abstract fun vocabularyDao(): VocabularyDao

    companion object {

        @Volatile private var INSTANCE: VocabularyDatabase? = null

        fun getInstance(context: Context): VocabularyDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        VocabularyDatabase::class.java, "Sample.db")
                        .build()
    }
}