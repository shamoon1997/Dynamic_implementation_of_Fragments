package com.example.fragments_again

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
lateinit var button: Button ;
    lateinit var button2: Button ;
    val TAG : String="TAG";


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button.setOnClickListener()
        {
            var  bundle :Bundle= Bundle();
            bundle.putString("message","Message is from Activity to Fragment ");
            val fragment1 : Fragment =BlankFragment1();

            val manager=supportFragmentManager;

            fragment1.arguments=bundle;

            val transaction=manager.beginTransaction();

            transaction.replace(R.id.linearlayout_fragment1,fragment1);
            transaction.addToBackStack(null);
            transaction.commit();

        }
        button2.setOnClickListener()
        {

            val fragment2=BlankFragment2();
            val manager1 :FragmentManager=supportFragmentManager;
            val transaction1 :FragmentTransaction=manager1.beginTransaction();
          transaction1.replace(R.id.linearlayout_fragment1,fragment2);
            transaction1.addToBackStack(null);
            transaction1.commit();

        }

    }

    override fun onStart() {
        Log.d(TAG,"OnStart Activity()");
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG,"OnResume Activity")
        super.onResume()
    }

    override fun onStop() {
        Log.d(TAG,"OnStop Activity")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG,"OnDestroy Activity")
        super.onDestroy()
    }
}

