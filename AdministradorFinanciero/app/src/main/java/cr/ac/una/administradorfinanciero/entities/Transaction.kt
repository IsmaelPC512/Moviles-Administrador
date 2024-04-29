package cr.ac.una.administradorfinanciero.entities

import java.util.Date

data class Transaction (
    var money: Double,
    var type: Int,
    var date: String,
)