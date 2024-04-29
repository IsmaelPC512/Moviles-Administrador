package cr.ac.una.administradorfinanciero.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cr.ac.una.administradorfinanciero.R
import cr.ac.una.administradorfinanciero.entities.Transaction

class TransactionAdapter(private val transactionList: List<Transaction>): RecyclerView.Adapter<TransactionVIewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionVIewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TransactionVIewHolder(layoutInflater.inflate(R.layout.item_transaction, parent, false))
    }

    override fun getItemCount(): Int = transactionList.size

    override fun onBindViewHolder(holder: TransactionVIewHolder, position: Int) {
        val item = transactionList[position]
        holder.render(item)
    }
}