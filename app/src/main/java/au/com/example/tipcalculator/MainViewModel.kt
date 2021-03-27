package au.com.example.tipcalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _percentageTipValue: MutableLiveData<String> = MutableLiveData("0%")
    val percentageTipValue: LiveData<String>
        get() = _percentageTipValue

    private val _tipValue: MutableLiveData<String> = MutableLiveData("$0")
    val tipValue: LiveData<String>
        get() = _tipValue

    private var billTotal = 0
    private var percentageTip = 0

    fun onTotalChanged(billTotalStr: String) {
        val billTotal = if (billTotalStr.isEmpty()) {
            0L
        } else {
            billTotalStr.toLong()
        }
        calculateTip()
    }

    fun onTipPercentageChanged(percentageTip: Int) {
        this.percentageTip = percentageTip
        _percentageTipValue.value = "$percentageTip%"
        calculateTip()
    }

    private fun calculateTip() {
        val tip = billTotal * (percentageTip / 100.0)
        _tipValue.value = "$${tip.toInt()}"
    }
}
