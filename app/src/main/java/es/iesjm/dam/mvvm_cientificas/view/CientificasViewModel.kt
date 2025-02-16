package es.iesjm.dam.mvvm_cientificas.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import es.iesjm.dam.mvvm_cientificas.BaseApplication
import es.iesjm.dam.mvvm_cientificas.data.Cientificas
import es.iesjm.dam.mvvm_cientificas.data.CientificasDao
import kotlinx.coroutines.flow.Flow

class CientificasViewModel(private val cientificasDao: CientificasDao): ViewModel() {


    fun getCientificas(): Flow<List<Cientificas>> = cientificasDao.getAll()

    companion object {
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BaseApplication)
                CientificasViewModel(application.database.cientificasDao())
            }
        }
    }
}
