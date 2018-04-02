package easy.vocabulary.lequoc.com.vocabularyeasy.fragments

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import easy.vocabulary.lequoc.com.vocabularyeasy.R
import easy.vocabulary.lequoc.com.vocabularyeasy.db.DbWorkerThread
import easy.vocabulary.lequoc.com.vocabularyeasy.db.database.VocabularyDatabase
import easy.vocabulary.lequoc.com.vocabularyeasy.entity.Vocabulary
import kotlinx.android.synthetic.main.fragment_input_data.*

/**
 * Created by quocle on 3/19/18.
 */
class InputFragment : BaseFragment() {

    private var mVocabularyDatabase: VocabularyDatabase? = null
    private lateinit var mDbWorkerThread: DbWorkerThread
    private val mUiHandler = Handler()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_input_data, container, false)
    }

    companion object Factory {
        fun create(): InputFragment = InputFragment()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mVocabularyDatabase = VocabularyDatabase.getInstance(this.context)
        mDbWorkerThread = DbWorkerThread(this.javaClass.simpleName)
        mDbWorkerThread.start()

        btnSubmit.setOnClickListener {
            val vocabulary = Vocabulary()
            vocabulary.voiceUrl = editTextVoice.text.toString()
            vocabulary.engMeaning = editTextEnglishMeaning.text.toString()
            vocabulary.vnMeaning = editTextVNMeaning.text.toString()
            vocabulary.example1 = editTextExample1.text.toString()
            vocabulary.example2 = editTextExample2.text.toString()

            saveInput(vocabulary)
        }

    }
    private fun saveInput(vocabulary: Vocabulary) {
        val task = Runnable { mVocabularyDatabase?.vocabularyDao()?.insert(vocabulary) }
        mDbWorkerThread.postTask(task)
    }
}