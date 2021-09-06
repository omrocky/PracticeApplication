package com.example.practiceapplication

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.practiceapplication.R
import com.example.practiceapplication.MainFragmentActivity
import com.example.practiceapplication.fragment.SampleFragment
import com.example.practiceapplication.fragment.SecondFragment
import com.example.practiceapplication.fragment.ThirdFragment
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainFragmentActivity : AppCompatActivity(), View.OnClickListener {
    private var fragmentManager: FragmentManager? = null
    var fragmentTransaction: FragmentTransaction? = null
    var btnAddFragment: AppCompatButton? = null
    var btnPopFragment: AppCompatButton? = null
    var btnRemoveFragment: AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)
        //Mapping
        btnAddFragment = findViewById(R.id.btnAddFragment)
        btnPopFragment = findViewById(R.id.btnPopFragment)
        btnRemoveFragment = findViewById(R.id.btnRemoveFragment)
        fragmentManager = supportFragmentManager

        //  btnAddFragment.setOnClickListener(view -> addFragment());
        fragmentManager = supportFragmentManager
        Log.i(COMMON_TAG, "Initial BackStackEntryCount: " + fragmentManager!!.backStackEntryCount)
        btnAddFragment?.setOnClickListener(this)
        btnPopFragment?.setOnClickListener(this)
        btnRemoveFragment?.setOnClickListener(this)
    }

    private fun addFragment() {
        val fragment: Fragment?
        if (fragmentManager!!.backStackEntryCount > 0) {
            when (fragmentManager!!.backStackEntryCount) {
                0 -> loadFragmentOne()
                1 -> loadFragmentTwo()
                2 -> loadFragmentThree()
                else -> loadFragmentOne()
            }
        } else {
            fragment = fragmentManager!!.findFragmentById(R.id.fragmentContainer)
            if (fragment is SampleFragment) {
                loadFragmentTwo()
            } else if (fragment is SecondFragment) {
                loadFragmentThree()
            } else if (fragment is ThirdFragment) {
                loadFragmentOne()
            } else {
                loadFragmentOne()
            }
        }
    }

    private fun loadFragmentOne() {
        fragmentTransaction = fragmentManager!!.beginTransaction()
        var fragment: Fragment? = fragmentManager!!.findFragmentByTag("demofragment")
        /*if(fragment!=null){
            fragmentTransaction.remove(fragment);
        }*/fragment = SampleFragment()
        fragmentTransaction!!.replace(R.id.fragmentContainer, fragment, "demofragment")
        fragmentTransaction!!.addToBackStack("Add $fragment")
        fragmentTransaction!!.commit()
    }

    private fun loadFragmentTwo() {
        fragmentTransaction = fragmentManager!!.beginTransaction()
        var fragment: Fragment? = fragmentManager!!.findFragmentByTag("demofragment")
        /*if(fragment!=null){
            fragmentTransaction.remove(fragment);
        }*/fragment = SecondFragment()
        fragmentTransaction!!.replace(R.id.fragmentContainer, fragment, "demofragment")
        fragmentTransaction!!.addToBackStack("Add $fragment")
        fragmentTransaction!!.commit()
    }

    private fun loadFragmentThree() {
        fragmentTransaction = fragmentManager!!.beginTransaction()
        var fragment: Fragment? = fragmentManager!!.findFragmentByTag("demofragment")
        /*if(fragment!=null){
            fragmentTransaction.remove(fragment);
        }*/fragment = ThirdFragment()
        fragmentTransaction!!.replace(R.id.fragmentContainer, fragment, "demofragment")
        fragmentTransaction!!.addToBackStack("Add $fragment")
        fragmentTransaction!!.commit()
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnAddFragment -> addFragment()
            R.id.btnPopFragment -> fragmentManager!!.popBackStack("Add SampleFragment", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            R.id.btnRemoveFragment -> {
                fragmentTransaction = fragmentManager!!.beginTransaction()
                val fragment = fragmentManager!!.findFragmentById(R.id.fragmentContainer)
                if (fragment != null) {
                    fragmentTransaction!!.remove(fragment)
                    fragmentTransaction!!.addToBackStack("Remove $fragment")
                    fragmentTransaction!!.commit()
                } else {
                    Toast.makeText(this, "No Fragment to remove", Toast.LENGTH_SHORT).show()
                }
            }
            else -> {
            }
        }
    }

    companion object {
        private const val COMMON_TAG = "CombinedLifeCycle"
        private val ACTIVITY_NAME = MainFragmentActivity::class.java.simpleName
        private val TAG = ACTIVITY_NAME
    }

}