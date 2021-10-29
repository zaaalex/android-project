package com.example.lab4.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lab4.R
import com.example.lab4.databinding.FragmentProfileBinding
import com.example.lab4.ui.log.Logcycle

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel
    private var _binding: FragmentProfileBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Logcycle(lifecycle, "ProfileActivity")
        profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.profileSettingsText.setOnClickListener {
        openFragment(SettingsFragment())
        }

        binding.profileAboutText.setOnClickListener {
            openFragment(AboutFragment())
        }

        binding.profileShareText.setOnClickListener {
            shareApp()
        }

        return root
    }

    private fun shareApp() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, getString(R.string.shareDescription))
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun openFragment(fragment: Fragment){
        getActivity()?.getSupportFragmentManager()
            ?.beginTransaction()
            ?.replace(R.id.container, fragment)
            ?.commit()
    }
}