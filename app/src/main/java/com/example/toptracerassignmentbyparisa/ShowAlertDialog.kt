package com.example.toptracerassignmentbyparisa

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog

class ShowAlertDialog(context: Context) : AlertDialog.Builder(context) {
    companion object {

        fun show(title: String, message: String, context: Context) {

            val builder = AlertDialog.Builder(context)
            builder.setTitle(title)
            builder.setMessage(message)
            builder.setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("ok", DialogInterface.OnClickListener { dialog, id ->
                    dialog.dismiss()
                })

            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()

        }
    }


}