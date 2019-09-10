package com.example.ass06_603020344_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.ass06_603020344_2.OneFragment
import com.example.ass06_603020344_2.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState== null){
            supportFragmentManager.beginTransaction().add(
                R.id.frameLayout,
                OneFragment()
            ).commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val manager :FragmentManager = supportFragmentManager
        val transaction :FragmentTransaction = manager.beginTransaction()
        //val toast  = Toast.makeText(this,item?.itemId , Toast.LENGTH_SHORT)
        //toast.show()
        when (item?.itemId){
            R.id.menu2 -> {
                transaction.replace(R.id.frameLayout,TwoFragment())
                transaction.addToBackStack(null)
                transaction.commit()
                return true
            }
            R.id.menu3 -> {
                transaction.replace(R.id.frameLayout,ThreeFragment())
                transaction.addToBackStack(null)
                transaction.commit()
                return true
            }
            else -> return super.onOptionsItemSelected(item)

        }
    }

}

