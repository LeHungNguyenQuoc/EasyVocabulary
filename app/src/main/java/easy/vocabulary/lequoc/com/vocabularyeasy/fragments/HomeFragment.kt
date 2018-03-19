package easy.vocabulary.lequoc.com.vocabularyeasy.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import easy.vocabulary.lequoc.com.vocabularyeasy.R

/**
 * Created by quocle on 3/19/18.
 */
class HomeFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false).apply {
            findViewById<TextView>(R.id.textViewTitle).setText(R.string.title_home)
        }
    }

    companion object Factory {
        fun create(): HomeFragment = HomeFragment()
    }
}