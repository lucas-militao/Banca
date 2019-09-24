package com.example.banca.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.banca.R
import com.example.banca.fragment.ArtigosFragment
import com.example.banca.fragment.EdicoesArtigosFragment
import com.example.banca.fragment.RevistasFragment
import com.example.banca.inTransaction
import com.example.banca.model.entity.Revista
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {

        const val CURRENT_SELECTED_ITEM = "selecteditem"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNaviagetionView.setOnNavigationItemSelectedListener { menu ->

            return@setOnNavigationItemSelectedListener when(menu.itemId) {

                R.id.Revistas -> {

                    supportFragmentManager.inTransaction {

                        replace(R.id.fragmentContainer, RevistasFragment())

                    }

                    true
                }

                R.id.Artigos -> {

                    supportFragmentManager.inTransaction {

                        replace(R.id.fragmentContainer, ArtigosFragment())

                    }

                    true
                }

                R.id.Edicoes -> {

                    supportFragmentManager.inTransaction {

                        replace(R.id.fragmentContainer, EdicoesArtigosFragment())

                    }

                    true
                }

                else -> false
            }
        }

        savedInstanceState?.let {
            bottomNaviagetionView.selectedItemId = it.getInt(CURRENT_SELECTED_ITEM)
        } ?: kotlin.run { bottomNaviagetionView.selectedItemId = R.id.Revistas }
    }

}
