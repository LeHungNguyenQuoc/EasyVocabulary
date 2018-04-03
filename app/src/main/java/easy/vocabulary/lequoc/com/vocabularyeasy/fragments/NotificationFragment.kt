package easy.vocabulary.lequoc.com.vocabularyeasy.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import easy.vocabulary.lequoc.com.vocabularyeasy.R
import easy.vocabulary.lequoc.com.vocabularyeasy.db.database.VocabularyDatabase
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_notification.*

/**
 * Created by quocle on 3/19/18.
 */
class NotificationFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnClearAll.setOnClickListener {

            Completable.fromAction {
                        VocabularyDatabase.getInstance(context).vocabularyDao().deleteAllUsers()
                    }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        Toast.makeText(activity, "Vocabularies all clear", Toast.LENGTH_SHORT).show()
                    }
        }
    }

    companion object Factory {
        fun create(): NotificationFragment = NotificationFragment()
    }
}