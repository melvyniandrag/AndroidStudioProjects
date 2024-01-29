package com.ballofknives.dialogsandnavigation.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult

class GoToFragmentB0 : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let{
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Navigation Dialog")
                .setMessage("Navigate to Fragment B?")
                .setPositiveButton("Navigate"){
                    dialog, id ->
                        //Toast.makeText(activity, "navigated!", Toast.LENGTH_LONG).show()
                        val result = "navigate"
                        setFragmentResult("request_key", bundleOf("bundle_key" to result))

                }
                .setNegativeButton("Cancel"){
                        dialog, id ->
                            val result = "do not navigate"
                            setFragmentResult("request_key", bundleOf("bundle_key" to result))
                }
            builder.create()
        }?: throw IllegalStateException("Activity cannot be null")

    }
}