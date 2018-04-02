package easy.vocabulary.lequoc.com.vocabularyeasy.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import easy.vocabulary.lequoc.com.vocabularyeasy.R
import easy.vocabulary.lequoc.com.vocabularyeasy.db.database.VocabularyDatabase
import easy.vocabulary.lequoc.com.vocabularyeasy.entity.Vocabulary
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_input_data.*

/**
 * Created by quocle on 3/19/18.
 */
class InputFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_input_data, container, false)
    }

    companion object Factory {
        fun create(): InputFragment = InputFragment()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSubmit.setOnClickListener {
            val vocabulary = Vocabulary()
            vocabulary.name = editTextWord.text.toString()
            vocabulary.voiceUrl = editTextVoice.text.toString()
            vocabulary.engMeaning = editTextEnglishMeaning.text.toString()
            vocabulary.vnMeaning = editTextVNMeaning.text.toString()
            vocabulary.example1 = editTextExample1.text.toString()
            vocabulary.example2 = editTextExample2.text.toString()
            saveInput(vocabulary)
        }

    }
    private fun saveInput(vocabulary: Vocabulary) {
        Completable.fromCallable {
            VocabularyDatabase.getInstance(context).vocabularyDao().insert(vocabulary)
        }.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    clearUserInput()
                })
    }

    private fun clearUserInput() {
        editTextWord.text.clear()
        editTextVoice.text.clear()
        editTextEnglishMeaning.text.clear()
        editTextVNMeaning.text.clear()
        editTextExample1.text.clear()
        editTextExample2.text.clear()
    }
}