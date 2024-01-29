package com.ballofknives.dialogsandnavigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.ballofknives.dialogsandnavigation.databinding.FragmentHomePageBinding
import com.ballofknives.dialogsandnavigation.dialogs.GoToFragmentB0

const val TAG = "HomePageFragment"
class HomePageFragment : Fragment(){
    private var binding : FragmentHomePageBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("request_key"
        ) { key, bundle ->
            val result = bundle.getString("bundle_key")
            Log.i(TAG, result ?: "no result")
            Toast.makeText(activity, result, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentHomePageBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.homePageFragment = this
    }

    fun onShowDialogClicked(v: View){
        GoToFragmentB0().show(parentFragmentManager, "Melvyns Dialog")
    }

}