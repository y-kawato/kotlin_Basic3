package jp.co.stv_tech.test217

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import jp.co.stv_tech.test217.databinding.FragmentTest2Binding

class Test2Fragment : Fragment() {

    private val viewModel: TestViewModel by activityViewModels()
    private lateinit var binding: FragmentTest2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test2, container, false)
        binding.testViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}
