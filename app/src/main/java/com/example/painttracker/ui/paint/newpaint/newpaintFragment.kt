package com.example.painttracker.ui.paint.newpaint

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.painttracker.R
import com.example.painttracker.databinding.FragmentNewPaintBinding
import com.example.painttracker.ui.paint.viewmodel.paintViewModel

class newpaintFragment : Fragment() {
    private val viewModel: paintViewModel by activityViewModels {
        paintViewModel.Factory
    }

    private lateinit var binding: FragmentNewPaintBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewPaintBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.viewmodel = viewModel
    }

    private fun observeStatus() {
        viewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(paintViewModel.WRONG_INFORMATION) -> {
                    Log.d("APP_TAG", status)
                    viewModel.clearstatus()
                }

                status.equals(paintViewModel.PAINT_ADD) -> {
                    Log.d("APP_TAG", status)
                    Log.d("APP_TAG", viewModel.getpaints().toString())
                    viewModel.cleardata()

                    viewModel.clearstatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

}
