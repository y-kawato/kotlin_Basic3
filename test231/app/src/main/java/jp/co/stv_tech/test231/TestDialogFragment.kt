package jp.co.stv_tech.test231


import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment


class TestDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        Log.i("MainActivity", "onCreateDialog")
        val builder = AlertDialog.Builder(activity)

        val telop = arguments?.getString("telop")
        builder.setMessage(telop)

        return builder.create()
    }

}