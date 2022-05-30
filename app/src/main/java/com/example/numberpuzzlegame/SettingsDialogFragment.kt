package com.example.numberpuzzlegame

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class SettingsDialogFragment
(
        var size: Int
) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("Define the size of the puzzle")
                .setSingleChoiceItems(
                        R.array.size_options, size - 2
                ) { dialog, which -> size = which + 2 }
                .setPositiveButton(
                        "Change"
                ) { dialog, id ->
                    (getActivity() as MainActivity)
                            .changeSize(size)
                }
                .setNegativeButton(
                        "Cancel"
                ) { dialog, id -> dialog.cancel() }
        val settingsDialog =  builder.create()
        settingsDialog.show()
        return  settingsDialog
    }
}