package au.com.example.tipcalculator

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var billTotal = 0
    private var percentageTip = 0

    fun onTotalChanged(billTotal: Int) {
        this.billTotal = billTotal
    }

    fun onTipPercentageChanged(percentageTip: Int) {
        this.percentageTip = percentageTip
    }

    private fun calculateTip() = billTotal * percentageTip
}
