package kg.geektech.gallery_hw

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kg.geektech.gallery_hw.databinding.GunsItemBinding

class GunAdapter : RecyclerView.Adapter<GunAdapter.GunsViewHolder>() {

    private var gunsList = arrayListOf<String>()
    var selectedGunsList = arrayListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GunsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.guns_item, parent, false)
        return GunsViewHolder(view)
    }

    override fun onBindViewHolder(holder: GunsViewHolder, position: Int) {
        holder.bind(gunsList[position])    //Заполнение айтема
    }

    override fun getItemCount(): Int {
        return gunsList.size
    }

    fun addAll(gun: ArrayList<String>) {
        this.gunsList = gun
        notifyDataSetChanged()
    }

    inner class GunsViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = GunsItemBinding.bind(item)
        fun bind(gun: String) = with(binding) { //Позволяет не писать binding
            Glide.with(binding.imgGun).load(gun).into(binding.imgGun)
            itemView.setOnClickListener {
                if (selectedImg.isInvisible) {
                    selectedImg.isVisible = true
                    selectedGunsList.add(gun)
                } else {
                    selectedImg.isInvisible = true
                    selectedGunsList.remove(gun)
                }
            }
        }
    }

}