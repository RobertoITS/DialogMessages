package com.roberto.dialogmessages

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class SimpleAlertDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val title = "Titulo del diálogo"
            val content = "Contenido del diálogo."
            val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
            builder.setTitle(title).setMessage(content)
                .setPositiveButton(android.R.string.ok) { _, _ ->
                    Toast.makeText(context, "Aceptado", Toast.LENGTH_LONG).show()
                }
                .setNegativeButton(android.R.string.cancel) { _, _ ->
                    Toast.makeText(context, "Cancelado", Toast.LENGTH_LONG).show()
                }
            return builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}
