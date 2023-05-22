package com.example.painttracker.ui.paint.Paint

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.painttracker.R
import com.example.painttracker.data.model.PaintModel
import com.example.painttracker.ui.paint.Paint.recyclerview.paintRecyclerViewAdapter
import com.example.painttracker.ui.paint.viewmodel.paintViewModel

class PaintPFragment : Fragment() {
    private val paintViewModel: paintViewModel by activityViewModels {
        paintViewModel.Factory
    }

    private lateinit var adapter: paintRecyclerViewAdapter
    private lateinit var binding: FragmentPaintPBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPaintPBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)

        binding.floatingActionButton.setOnClickListener {
            paintViewModel.cleardata()
            it.findNavController().navigate(R.id)
        }
    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = paintRecyclerViewAdapter { selectedpaint ->
            showSelectedItem(selectedpaint)
        }

        binding.recyclerView.adapter = adapter
        displaypaint()
    }

    private fun showSelectedItem(paints: PaintModel) {
        paintViewModel.setSelectedPaint(paints)
        findNavController().navigate(R.id.)
    }

    private fun displaypaint() {
        adapter.setData(paintViewModel.getpaints())
        adapter.notifyDataSetChanged()
    }
}