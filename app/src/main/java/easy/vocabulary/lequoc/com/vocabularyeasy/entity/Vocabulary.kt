package easy.vocabulary.lequoc.com.vocabularyeasy.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by quocle on 3/30/18.
 */
@Entity(tableName = "Vocabularies")
data class Vocabulary(@PrimaryKey(autoGenerate = true) var id: Long?,
                      @ColumnInfo(name = "name") var name: String,
                      @ColumnInfo(name = "voice_url") var voiceUrl: String,
                      @ColumnInfo(name = "english_meaning") var engMeaning: String,
                      @ColumnInfo(name = "vn_meaning") var vnMeaning: String,
                      @ColumnInfo(name = "example_1") var example1: String,
                      @ColumnInfo(name = "example_2") var example2: String
                      ) {
    constructor(): this(null, "",  "", "", "", "", "")
}