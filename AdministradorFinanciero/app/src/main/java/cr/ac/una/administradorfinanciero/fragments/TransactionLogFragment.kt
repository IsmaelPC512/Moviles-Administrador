package cr.ac.una.administradorfinanciero.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cr.ac.una.administradorfinanciero.R
import cr.ac.una.administradorfinanciero.adapters.TransactionAdapter
import cr.ac.una.administradorfinanciero.entities.Transaction

class TransactionLogFragment : Fragment() {

    private var transactionList = mutableListOf<Transaction>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transaction_log, container, false)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvTransaction = view.findViewById<RecyclerView>(R.id.rvTransaction)
        rvTransaction.layoutManager = LinearLayoutManager(context)
        rvTransaction.adapter = TransactionAdapter(transactionList)

        transactionList.add(Transaction(1000.0,1,"hoy"))
        transactionList.add(Transaction(20.0,2,"manana"))
        transactionList.add(Transaction(10.0,1 ,"adas"))
        transactionList.add(Transaction(21000.0,1,"hsdasdd"))

        rvTransaction.adapter?.notifyDataSetChanged()

    }

}