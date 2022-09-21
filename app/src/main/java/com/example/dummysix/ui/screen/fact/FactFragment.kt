package com.example.dummysix.ui.screen.fact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.dummysix.R
import com.example.dummysix.core.utils.extension.observeFlows
import com.example.dummysix.core.utils.viewBinding
import com.example.dummysix.databinding.FragmentFactBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class FactFragment : Fragment(R.layout.fragment_fact) {

    private val binding by viewBinding(FragmentFactBinding::bind)
    private val viewModel: FactViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
    }
    private fun onClick() {
        binding.btnGenerate.setOnClickListener {
            observe()
        }
    }

    private fun observe() {
        viewModel.getFacts()
        observeFlows {
            viewModel.factState.collect { state ->
                when (state.status) {
                    Status.SUCCESS -> {
                        val result = state.fact
                        binding.tvFact.text = result!!.fact
                        Toast.makeText(context, "SUCCESS :$result", Toast.LENGTH_SHORT).show()
                    }
                    Status.ERROR -> {
                        Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show()
                    }
                    Status.EXCEPTION -> {
                        Toast.makeText(context, "EXCEPTION", Toast.LENGTH_SHORT).show()
                    }
                    else -> {

                    }
                }
            }
        }
    }

}