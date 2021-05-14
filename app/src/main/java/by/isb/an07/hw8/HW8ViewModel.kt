package by.isb.an07.hw8

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.isb.an07.hw8.data.entities.crypto.Crypto
import by.isb.an07.hw8.data.repository.crypto.CryptoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class HW8ViewModel : ViewModel() {

    private val cryptoRepository = CryptoRepository()
    private val ioScope = CoroutineScope(Dispatchers.IO)

    private val _crypto = MutableLiveData<List<Crypto>>()
    val crypto: LiveData<List<Crypto>> = _crypto

    private val _errorBus = MutableLiveData<String>()
    val errorBus: LiveData<String> = _errorBus

    private val _loading = MutableLiveData<Boolean>()
    val loading : LiveData<Boolean> = _loading

    fun loadCrypto(sort: String) {
        _loading.value = true
        ioScope.launch {
            try {
                _crypto.postValue(cryptoRepository.loadCrypto(sort))
                _loading.postValue(false)
            } catch (e: Exception) {
                _errorBus.postValue(e.message)
            }
        }
    }
}