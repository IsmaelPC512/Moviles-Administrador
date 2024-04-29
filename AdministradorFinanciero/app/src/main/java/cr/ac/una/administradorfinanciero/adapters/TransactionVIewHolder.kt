package cr.ac.una.administradorfinanciero.adapters

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import cr.ac.una.administradorfinanciero.R
import cr.ac.una.administradorfinanciero.entities.Transaction

class TransactionVIewHolder(view: View): ViewHolder(view) {

    val date = view.findViewById<TextView>(R.id.tvFecha)
    val type = view.findViewById<TextView>(R.id.tvTipo)
    val money = view.findViewById<TextView>(R.id.tvMonto)
    val image = view.findViewById<TextView>(R.id.tvImage)

    @SuppressLint("SetTextI18n")
    fun render(transactionModel: Transaction){
        date.text = transactionModel.date
        type.text = transactionModel.type.toString()
        money.text = transactionModel.money.toString()
        image.text = "en proceso"
    }
}