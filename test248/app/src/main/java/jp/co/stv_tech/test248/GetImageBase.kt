package jp.co.stv_tech.test248

import android.content.Context
import android.util.Log
import androidx.loader.content.AsyncTaskLoader

open class GetImageBase<T>(context: Context) : AsyncTaskLoader<T>(context) {

    override fun onStartLoading() {
        super.onStartLoading()

        Log.v("nullpo", "onStartLoading")

        if (takeContentChanged()) {

            forceLoad()
        }
    }

    override fun loadInBackground(): T? {
        Log.v("nullpo", "loadInBackground")
        return super.onLoadInBackground()
    }

    override fun deliverResult(data: T?) {
        super.deliverResult(data)
    }

    override fun onStopLoading() {
        super.onStopLoading()

        cancelLoad()
    }

    override fun onReset() {
        super.onReset()
        onStopLoading()
    }
}