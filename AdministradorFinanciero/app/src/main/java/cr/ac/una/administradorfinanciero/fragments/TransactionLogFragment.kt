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

class TransactionLogFragment : Fragment(), CreatorFragment.OnTransactionAddedListener {

    private var transactionList = mutableListOf<Transaction>()
    private lateinit var rvTransaction: RecyclerView
    private lateinit var adapter: TransactionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_transaction_log, container, false)

        rvTransaction = view.findViewById(R.id.rvTransaction)
        rvTransaction.layoutManager = LinearLayoutManager(context)
        rvTransaction.adapter = TransactionAdapter(transactionList)

        return view
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvTransaction = view.findViewById(R.id.rvTransaction)
        rvTransaction.layoutManager = LinearLayoutManager(context)
        rvTransaction.adapter = TransactionAdapter(transactionList)

        transactionList.add(Transaction(null,"1000.0",1,"hoy"))
        transactionList.add(Transaction(null,"1000.0",1,"hoy"))
        transactionList.add(Transaction(null,"1000.0",1,"hoy"))
        transactionList.add(Transaction(null,"1000.0",1,"hoy"))
        transactionList.add(Transaction(null,"1000.0",1,"hoy"))
        transactionList.add(Transaction(null,"1000.0",1,"hoy"))

        rvTransaction.adapter?.notifyDataSetChanged()

    }

    private fun initRecyclerView() {
    }

    override fun onTransactionAdded(transaction: Transaction) {
        transactionList.add(transaction)
        rvTransaction.adapter?.notifyItemInserted(transactionList.size - 1)

    }

}