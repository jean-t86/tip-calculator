package au.com.example.tipcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import au.com.example.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.etTotal.doAfterTextChanged { text ->
            viewModel.onTotalChanged(text.toString())
        }

        binding.slTipPercentage.addOnChangeListener { _, value, _ ->
            viewModel.onTipPercentageChanged(value)
        }

        viewModel.tipValue.observe(this, { tipValue ->
            binding.tvCalculatedTip.text = tipValue
        })
    }
}
