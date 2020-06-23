package jp.co.stv_tech.test217

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel : ViewModel() {

    private var _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    init {
        _text.value = ""
    }

    fun addText(text :String) {
        _text.value = text
    }
}