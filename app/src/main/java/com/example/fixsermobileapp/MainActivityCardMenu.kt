package com.example.fixsermobileapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import com.example.fixsermobileapp.enter.EnterActivity
import com.example.fixsermobileapp.expenses.ExpensesActivity


class MainActivityCardMenu : AppCompatActivity() {
    lateinit var cardMenuEnter:CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_card_menu)

        val animation = AnimationUtils.loadAnimation(this, R.anim.slide_down)
        findViewById<RelativeLayout>(R.id.re_layout_card_menu).startAnimation(animation)
        //overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        //CardView Recuperation des id des
        val cardMenuExpense = findViewById<CardView>(R.id.card_expense)
        cardMenuEnter = findViewById(R.id.card_menu_enter)
        //Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar_menu_card)
        setSupportActionBar(toolbar)
        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Acceuil"


        //CardViews events
        //Open ExspenseActivity
        cardMenuExpense.setOnClickListener{
            // Entrer CardView Animation
            //val animationCard = AnimationUtils.loadAnimation(this, R.anim.rotate)
            cardMenuExpense.startAnimation(cardAnimation())
            //Opening Expenses Activity
            val intent = Intent(this, ExpensesActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_bottom)

        }
        //Open Enter Activity
        cardMenuEnter.setOnClickListener(View.OnClickListener {
            //Apply Card Animation
            cardMenuEnter.startAnimation(cardAnimation())
            //Open EnterActivity
            val intent = Intent(this, EnterActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_bottom)
        })


    }

    //Funtion for Animate Cardviews Menu
    fun cardAnimation():Animation{
        return AnimationUtils.loadAnimation(this, R.anim.rotate)
    }

    override fun onResume() {
        val animation = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom)//fade_in slide_down
        findViewById<RelativeLayout>(R.id.re_layout_card_menu).startAnimation(animation)
        super.onResume()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_statistique){
            Toast.makeText(this, "My Code", Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}