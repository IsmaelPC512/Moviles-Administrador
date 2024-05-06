package cr.ac.una.administradorfinanciero.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.CheckBox
import android.widget.EditText
import cr.ac.una.administradorfinanciero.R
import cr.ac.una.administradorfinanciero.R.*
import cr.ac.una.administradorfinanciero.entities.Transaction
import java.util.Calendar

class CreatorFragment : Fragment() {

    private lateinit var etMoney: EditText
    private lateinit var cvDate: CalendarView
    private lateinit var chBoxCredito: CheckBox
    private lateinit var chBoxDebito: CheckBox
    private lateinit var listener: OnTransactionAddedListener


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(layout.fragment_creator, container, false)

        etMoney = view.findViewById(R.id.etMoney)
        cvDate = view.findViewById(R.id.cvDate)
        chBoxCredito = view.findViewById(R.id.chboxCredito)
        chBoxDebito = view.findViewById(R.id.chboxDebito)


        val btnSendTransaction = view.findViewById<Button>(R.id.btnSendTransaction)
        btnSendTransaction.setOnClickListener{

            val newMoney = etMoney.text.toString()
            val newDate = cvDate.date.toString()
            val newDebito = chBoxDebito.isChecked
            val newCredito = chBoxCredito.isChecked

            val transactionType = if (newCredito) 1 else if (newDebito) 2 else 0

            val newTransaction = Transaction(null, newMoney, 1, newDate)

            listener.onTransactionAdded(newTransaction)

        }

        return view
    }

    interface OnTransactionAddedListener {
        fun onTransactionAdded(transaction: Transaction)
    }


}