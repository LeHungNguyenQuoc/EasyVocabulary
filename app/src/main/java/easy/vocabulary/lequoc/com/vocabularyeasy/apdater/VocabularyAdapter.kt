package easy.vocabulary.lequoc.com.vocabularyeasy.apdater

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import easy.vocabulary.lequoc.com.vocabularyeasy.R
import easy.vocabulary.lequoc.com.vocabularyeasy.entity.Vocabulary
import kotlinx.android.synthetic.main.view_vocabulary_item.view.*

/**
 * Created by quocle on 4/2/18.
 */
class VocabularyAdapter(val context: Context) : RecyclerView.Adapter<VocabularyAdapter.ViewHolder>() {

    private  var items: List<Vocabulary> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.view_vocabulary_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.tvName?.text = items[position].engMeaning
    }

    fun setData(data: List<Vocabulary>) {
        items = data
        notifyDataSetChanged()
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val tvName = view.tvVocabulary!!
    }
}