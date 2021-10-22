package com.example.lab4.ui.holiday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lab4.databinding.FragmentHolidayBinding
import com.example.lab4.ui.log.Logcycle

class HolidayFragment : Fragment() {

    private lateinit var holidayViewModel: HolidayViewModel
    private var _binding: FragmentHolidayBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Logcycle(lifecycle, "HolidayActivity")
        holidayViewModel =
            ViewModelProvider(this).get(HolidayViewModel::class.java)

        _binding = FragmentHolidayBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHoliday
        holidayViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}