package cr.ac.una.administradorfinanciero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.google.android.material.navigation.NavigationView
import cr.ac.una.administradorfinanciero.adapters.TransactionAdapter
import cr.ac.una.administradorfinanciero.entities.Transaction
import cr.ac.una.administradorfinanciero.fragments.CreatorFragment
import cr.ac.una.administradorfinanciero.fragments.TransactionLogFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.navMenu)
        navigationView.setNavigationItemSelectedListener (this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itemCreate -> supportFragmentManager.beginTransaction().replace(
                R.id.frameContainer, CreatorFragment()
            ).commit()
            R.id.itemTransactionLog -> supportFragmentManager.beginTransaction().replace(
                R.id.frameContainer, TransactionLogFragment()
            ).commit()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}