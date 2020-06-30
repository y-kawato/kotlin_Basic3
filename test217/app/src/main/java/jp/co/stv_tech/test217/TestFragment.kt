package jp.co.stv_tech.test217

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import jp.co.stv_tech.test217.databinding.FragmentTestBinding
import kotlinx.android.synthetic.main.fragment_test.*


class TestFragment : Fragment() {

    private val viewModel: TestViewModel by activityViewModels()
    private lateinit var binding: FragmentTestBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lvButton.setOnClickListener {
            viewModel.addText(lvEditText.text.toString())
        }
    }
}
