package kg.geektech.gallery_hw

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kg.geektech.gallery_hw.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myAdapter = GunAdapter()
    private val imageIdList = arrayListOf(
        "https://m.media-amazon.com/images/I/51E8OaL+7NL._AC_SL1280_.jpg",
        "https://i.ytimg.com/vi/RJwTtWuV1Zg/maxresdefault.jpg",
        "https://www.voicesofyouth.org/sites/voy/files/images/2021-07/2d012930-9f12-45a3-ad2e-57737512bb7f.jpeg",
        "https://images.unsplash.com/photo-1591123720164-de1348028a82?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Z3VufGVufDB8fDB8fA%3D%3D&w=1000&q=80",
        "https://ichef.bbci.co.uk/news/976/cpsprodpb/18655/production/_124252999_gettyimages-1152365789.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        initListener()
    }

    private fun init() {
        binding.apply {
            recycler.layoutManager = GridLayoutManager(this@MainActivity, 3)
            recycler.adapter = myAdapter
        }
        myAdapter.addAll(imageIdList)
    }


    private fun initListener() {
        binding.fabNext.setOnClickListener {
            println(myAdapter.selectedGunsList)
            val intent = Intent(this, SecondActivity::class.java)
            intent.putStringArrayListExtra(Constants.KEY, myAdapter.selectedGunsList)
            startActivity(intent)
        }
    }

}
