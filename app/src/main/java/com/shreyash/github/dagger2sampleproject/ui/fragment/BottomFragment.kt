package com.shreyash.github.dagger2sampleproject.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.shreyash.github.dagger2sampleproject.MyApplication
import com.shreyash.github.dagger2sampleproject.R
import com.shreyash.github.dagger2sampleproject.di.module.FragmentModule
import com.shreyash.github.dagger2sampleproject.ui.viewmodel.BottomFragmentViewmodel
import com.shreyash.github.dagger2sampleproject.ui.viewmodel.HomeFragmentViewmodel
import me.amitshekhar.dagger.learning.di.component.DaggerFragmentComponent
import javax.inject.Inject


class BottomFragment : Fragment() {

    @Inject
    lateinit var viewModel: HomeFragmentViewmodel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        getDependencies()
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvMessage = view.findViewById<TextView>(R.id.textView)
        tvMessage.text = viewModel.getSomeData()
    }

    companion object {


        const val TAG = "BottomFragment"
           @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BottomFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    fun getDependencies() {
        DaggerFragmentComponent
            .builder()
            .applicationComponent((requireContext().applicationContext as MyApplication).applicationComponent)
            .fragmentModule(FragmentModule(this))
            .build()
            .inject(this)
    }
}