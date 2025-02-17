package es.iesjm.dam.mvvm_cientificas

import android.app.Application
import es.iesjm.dam.mvvm_cientificas.data.CientificasDatabase


// Esta clase extiende `Application` y se utiliza para inicializar y proporcionar
// la instancia de la base de datos `CientificasDatabase`.

class BaseApplication : Application() {
    val database: CientificasDatabase by lazy { CientificasDatabase.getDatabase(this) }
}