package easy.vocabulary.lequoc.com.vocabularyeasy.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import easy.vocabulary.lequoc.com.vocabularyeasy.entity.Vocabulary

/**
 * Created by quocle on 3/30/18.
 */
@Dao
interface VocabularyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vocabulary: Vocabulary)

    @Query("SELECT * FROM Vocabularies")
    fun getAll(): List<Vocabulary>
}