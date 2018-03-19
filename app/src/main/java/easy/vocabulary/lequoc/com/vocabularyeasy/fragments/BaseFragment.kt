package easy.vocabulary.lequoc.com.vocabularyeasy.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log

/**
 * Created by quocle on 3/19/18.
 */
open class BaseFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Tracking", "onCreate in ${ this.javaClass.simpleName }")
    }

    override fun onDestroy() {
        Log.d("Tracking", "onDestroy in ${ this.javaClass.simpleName }")
        super.onDestroy()
    }
}