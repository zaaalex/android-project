package com.example.lab4.ui.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab4.databinding.FragmentEventsBinding
import com.example.lab4.ui.events.EventAdapter
import com.example.lab4.ui.events.EventsViewModel
import com.example.lab4.ui.log.Logcycle

class EventsFragment : Fragment() {

    private val eventsAdapter = EventAdapter()
    private val eventsViewModel: EventsViewModel by viewModels()
    private var _binding: FragmentEventsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Logcycle(lifecycle, "EventsActivity")
        
        _binding = FragmentEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.list.apply {
            adapter = eventsAdapter
            layoutManager = LinearLayoutManager(context)
        }

        eventsViewModel.getEvents().observe(viewLifecycleOwner) {
            eventsAdapter.reload(it)
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}