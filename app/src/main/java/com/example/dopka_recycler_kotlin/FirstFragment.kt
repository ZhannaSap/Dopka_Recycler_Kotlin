package com.example.dopka_recycler_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dopka_recycler_kotlin.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    val list = arrayListOf(
        "text1",
        "text2",
        "text3",
        "text4",
        "text5",
        "text6",
        "text7"
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val itemAdapter = ItemAdapter(list, this::onClick)
        binding.recycler.adapter = itemAdapter
    }

    private fun onClick(text: String) {
        val bundle = Bundle()
        bundle.putString("key", text)
        bundle.putString("key2", "text2")
        val secondFragment = SecondFragment()
        secondFragment.arguments = bundle

        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.main, secondFragment)
            .commit()
    }
}