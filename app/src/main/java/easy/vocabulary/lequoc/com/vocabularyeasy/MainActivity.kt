package easy.vocabulary.lequoc.com.vocabularyeasy

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import easy.vocabulary.lequoc.com.vocabularyeasy.fragments.BaseFragment
import easy.vocabulary.lequoc.com.vocabularyeasy.fragments.HomeFragment
import easy.vocabulary.lequoc.com.vocabularyeasy.fragments.InputFragment
import easy.vocabulary.lequoc.com.vocabularyeasy.fragments.NotificationFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                viewPager.setCurrentItem(0, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                viewPager.setCurrentItem(1, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                viewPager.setCurrentItem(2, true)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPager()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun initPager() {
        val pagerAdapter = MainPagerAdapter(arrayOf(HomeFragment.create(), InputFragment.create(), NotificationFragment.create()), supportFragmentManager)
        viewPager.adapter = pagerAdapter
    }

    inner class MainPagerAdapter(private var fragments: Array<BaseFragment>, fm: FragmentManager?) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }
    }
}
