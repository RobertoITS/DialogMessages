package com.roberto.dialogmessages

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = findViewById(R.id.btn)
        btn.setOnClickListener {
            showDialogAlertSimple()
        }

        //Otra forma es llamarlo desde una clase:
        //Permanece al rotar la vista, no como la simple
        val modalDialog = SimpleAlertDialog()
        modalDialog.show(supportFragmentManager, "confirmDialog")

        //Para hacerlo desde un fragment
        //val modalDialog = SimpleAlertDialog()
        //modalDialog.show(requireActivity().supportFragmentManager, "confirmDialog")

    }
    //Se muestra el dialogo por funcion
    fun showDialogAlertSimple() {
        AlertDialog.Builder(this)
            .setTitle("Titulo del diálogo")
            .setMessage("Contenido del diálogo.")
            .setPositiveButton(android.R.string.ok,
                DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(this, "Aceptado", Toast.LENGTH_LONG).show()
                })
            .setNegativeButton(android.R.string.cancel,
                DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(this, "Cancelado", Toast.LENGTH_LONG).show()
                })
            //Con esta opcion, quitamos la opcion de tocar en la pantalla gris y que se cierre
            .setCancelable(false)
            .show()
    }
}