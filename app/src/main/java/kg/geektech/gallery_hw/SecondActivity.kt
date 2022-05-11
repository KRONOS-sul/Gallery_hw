package kg.geektech.gallery_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kg.geektech.gallery_hw.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private val myAdapter = GunAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        btnBack()
    }

    private fun btnBack() {
        binding.btnArrowBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun init() {
        binding.apply {
            recycler.layoutManager = GridLayoutManager(this@SecondActivity, 3)
            recycler.adapter = myAdapter
        }
        val stringArrayListExtra = intent.getStringArrayListExtra(Constants.KEY)
        stringArrayListExtra?.let { myAdapter.addAll(it) }
    }
}