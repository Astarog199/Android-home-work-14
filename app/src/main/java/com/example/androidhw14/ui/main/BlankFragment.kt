package com.example.androidhw14.ui.main

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.example.androidhw14.Data.ResultModel
import com.example.androidhw14.Data.RetrofitInstance
import com.example.androidhw14.databinding.FragmentBlankBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BlankFragment : Fragment() {
    private var _binding: FragmentBlankBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = BlankFragment()
    }

    private val viewModel: BlankViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getUser()

        binding.button.setOnClickListener {
            getUser()
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

//   TODO: Как перенести эту функцию в BlankViewModel? Я пытался, но меня возвращает null.
    fun getUser(){
        RetrofitInstance.searchUserApi.getUser()
            .enqueue(object : Callback<ResultModel> {
                override fun onResponse(
                    call: Call<ResultModel>,
                    response: Response<ResultModel>
                ) {
                    if (response.isSuccessful){
                        val result = response.body() ?: return
                        binding.textView.text = result.toString()
                        val user = result.results.last()
                        binding.imageView.load(user.picture.get("large"))
                    }
                }
                override fun onFailure(call: Call<ResultModel>, t: Throwable) {
                    Log.e("Network", "Something went wrong", t)
                }
            })
    }
}