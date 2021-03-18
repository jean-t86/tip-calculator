package au.com.example.tipcalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _percentageTipValue: MutableLiveData<String> = MutableLiveData("0%")
    val percentageTipValue: LiveData<String>
        get() = _percentageTipValue

    private var billTotal = 0
    private var percentageTip = 0

    fun onTotalChanged(billTotal: Int) {
        this.billTotal = billTotal
    }

    fun onTipPercentageChanged(percentageTip: Int) {
        this.percentageTip = percentageTip
        _percentageTipValue.value = "$percentageTip%"
    }

    private fun calculateTip(): Int = billTotal * percentageTip
}
