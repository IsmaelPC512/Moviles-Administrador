package cr.ac.una.administradorfinanciero.entities

import java.util.Date

data class Transaction (
    var _uuid: String?,
    var money: String,
    var type: Int,
    var date: String,
)