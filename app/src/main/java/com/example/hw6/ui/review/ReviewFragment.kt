package com.example.hw6.ui.review

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.hw6.R
import androidx.lifecycle.ViewModelProviders
import com.example.hw6.ui.home.HomeFragment
import com.example.hw6.ui.news.NewsFragment
import kotlinx.android.synthetic.main.fragment_review.*


class ReviewFragment : Fragment() {

    private lateinit var reviewViewModel: ReviewViewModel
    private var listener: onButtonClick? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        reviewViewModel =
            ViewModelProviders.of(this).get(ReviewViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_review, container, false)
        val textView: TextView = root.findViewById(R.id.text_review)
        reviewViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }

    interface onButtonClick {
        fun onReportBtnClick()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        report_btn.setOnClickListener {
            listener?.onReportBtnClick()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is onButtonClick) {
            listener = context
        } else {
            throw RuntimeException("$context must implement onHallButtonClick")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
