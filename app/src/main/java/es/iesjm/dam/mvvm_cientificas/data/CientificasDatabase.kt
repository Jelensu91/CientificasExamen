package es.iesjm.dam.mvvm_cientificas.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Definimos una clase abstracta que extiende RoomDatabase para crear la base de datos "CientificasDatabase".
// La base de datos contiene la entidad "Cientificas" y se establece en la versión 1.

// La función `cientificasDao()` devuelve el DAO que define las consultas para la entidad "Cientificas".

// En el bloque companion, se asegura que solo haya una instancia de la base de datos (singleton).
// Se utiliza @Volatile para que los cambios en la instancia sean visibles entre hilos.

@Database(entities = [Cientifica::class], version = 1)
abstract class CientificasDatabase : RoomDatabase() {
    abstract fun cientificasDao(): CientificasDao

    companion object {
        @Volatile
        private var INSTANCE: CientificasDatabase? = null

        fun getDatabase(context: Context): CientificasDatabase {
            return INSTANCE
                ?: synchronized(this) {
                    Room.databaseBuilder(
                        context,
                        CientificasDatabase::class.java,
                        "cientificas_database"
                    )
                        .createFromAsset("database/cientificas_database.db")
                        .fallbackToDestructiveMigration()
                        .build()
                        .also {
                            INSTANCE = it
                        }
                }
        }
    }
}