package es.iesjm.dam.mvvm_cientificas.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// Definimos una entidad de Room llamada "cientificas" para la base de datos.
// La clase representa una tabla con las columnas id, nombre, logros y biografía.
// El id es la clave primaria y se genera automáticamente.

@Entity(tableName = "cientificas")
data class Cientifica(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nombre: String,
    val logros: String,
    val biografia: String,
)