package easy.vocabulary.lequoc.com.vocabularyeasy.fragments

import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import easy.vocabulary.lequoc.com.vocabularyeasy.R
import easy.vocabulary.lequoc.com.vocabularyeasy.apdater.VocabularyAdapter
import easy.vocabulary.lequoc.com.vocabularyeasy.db.DbWorkerThread
import easy.vocabulary.lequoc.com.vocabularyeasy.db.database.VocabularyDatabase
import easy.vocabulary.lequoc.com.vocabularyeasy.entity.Vocabulary
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by quocle on 3/19/18.
 */
class HomeFragment : BaseFragment() {

    private lateinit var adapter: VocabularyAdapter
    private lateinit var mDbWorkerThread: DbWorkerThread
    private val mUiHandler = Handler()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false).apply {
            findViewById<TextView>(R.id.textViewTitle).setText(R.string.title_home)
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = VocabularyAdapter(activity)
        recyclerView.adapter = adapter

        mVocabularyDatabase = VocabularyDatabase.getInstance(this.context)
        mDbWorkerThread = DbWorkerThread(this.javaClass.simpleName)
        mDbWorkerThread.start()

        btnTest.setOnClickListener {
            loadDataFromLocal()
        }
    }


    private lateinit var mVocabularyDatabase: VocabularyDatabase

    private fun loadDataFromLocal() {
        val task = Runnable {
            val data = mVocabularyDatabase?.vocabularyDao()?.getAll()
            mUiHandler.post({
                adapter.setData(data)
            })
        }
        mDbWorkerThread.postTask(task)
    }

    companion object Factory {
        fun create(): HomeFragment = HomeFragment()
    }
}