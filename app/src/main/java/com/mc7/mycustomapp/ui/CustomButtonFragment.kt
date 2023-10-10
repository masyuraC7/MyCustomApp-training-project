package com.mc7.mycustomapp.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mc7.mycustomapp.databinding.FragmentCustomButtonBinding

class CustomButtonFragment : Fragment() {

    private lateinit var binding: FragmentCustomButtonBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCustomButtonBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setMyButtonEnable()

        with(binding){
            seatsView.setOnClickListener{
                seatsView.seat?.let {
                    Toast.makeText(requireActivity(), "Kursi Anda nomor ${it.name}.", Toast.LENGTH_SHORT).show()
                } ?: run {
                    Toast.makeText(requireActivity(), "Silakan pilih kursi terlebih dahulu.", Toast.LENGTH_SHORT).show()
                }
            }

            myEditText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                }
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    setMyButtonEnable()
                }
                override fun afterTextChanged(s: Editable) {
                }
            })

            myButton.setOnClickListener { Toast.makeText(requireActivity(), myEditText.text, Toast.LENGTH_SHORT).show() }

            finishButton.setOnClickListener{
                seatsView.seat?.let {
                    Toast.makeText(requireActivity(), "Kursi Anda nomor ${it.name}.", Toast.LENGTH_SHORT).show()
                } ?: run {
                    Toast.makeText(requireActivity(), "Silakan pilih kursi terlebih dahulu.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setMyButtonEnable() {
        val result = binding.myEditText.text
        binding.myButton.isEnabled = (result != null) && result.toString().isNotEmpty()
    }
}