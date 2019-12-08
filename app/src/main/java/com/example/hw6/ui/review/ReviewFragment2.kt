package com.example.hw6.ui.review

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.hw6.R
import kotlinx.android.synthetic.main.fragment_review2.*

class ReviewFragment2 : Fragment() {

    private var listener: onButtonClick? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_review2, container, false)
    }

    interface onButtonClick {
        fun onSendReportBtnClick(info: String, review: String, bugs: String)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        send_report_btn.setOnClickListener {
            listener?.onSendReportBtnClick(
                et_info.text.toString(),
                et_review.text.toString(),
                et_bug.text.toString()
            )
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
