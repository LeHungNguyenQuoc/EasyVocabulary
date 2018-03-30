package easy.vocabulary.lequoc.com.vocabularyeasy.db

import android.os.Handler
import android.os.HandlerThread

/**
 * Created by quocle on 3/30/18.
 */
class DbWorkerThread(threadName: String) : HandlerThread(threadName) {
    private lateinit var mWorkerHandler: Handler

    override fun onLooperPrepared() {
        super.onLooperPrepared()
        mWorkerHandler = Handler(looper)
    }

    fun postTask(task: Runnable) {
        mWorkerHandler.post(task)
    }
}