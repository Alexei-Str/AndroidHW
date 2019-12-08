package com.example.hw6.ui.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw6.R
import kotlinx.android.synthetic.main.fragment_review3.*

class ReviewFragment3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_review3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.apply {
            text_info.text = arguments?.getString("info")
            text_review.text = arguments?.getString("review")
            text_bug.text = arguments?.getString("bugs")
        }
    }
}
