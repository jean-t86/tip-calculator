package au.com.example.tipcalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _tipValue: MutableLiveData<String> = MutableLiveData("$0.00")
    val tipValue: LiveData<String>
        get() = _tipValue

    private var billTotal: Double = 0.0
    private var percentageTip = 0f

    fun onTotalChanged(billTotalStr: String) {
        billTotal = if (billTotalStr.isEmpty()) {
            0.0
        } else {
            billTotalStr.toDouble()
        }
        calculateTip()
    }

    fun onTipPercentageChanged(percentageTip: Float) {
        this.percentageTip = percentageTip
        calculateTip()
    }

    private fun calculateTip() {
        val tip = billTotal * (percentageTip / 100.0)
        val tipValue = "%.2f".format(tip)
        _tipValue.value = "$$tipValue"
    }
}
