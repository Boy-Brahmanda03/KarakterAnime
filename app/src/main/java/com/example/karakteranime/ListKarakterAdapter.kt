package com.example.karakteranime

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.karakteranime.databinding.LayoutKarakterItemBinding

class ListKarakterAdapter(
    private val listKarakter: ArrayList<Karakter>,
    private val onClick: (Karakter) -> Unit
) :
    RecyclerView.Adapter<ListKarakterAdapter.KarakterViewHolder>() {

    class KarakterViewHolder(var binding: LayoutKarakterItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KarakterViewHolder {
        val binding =
            LayoutKarakterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KarakterViewHolder(binding)
    }

    override fun getItemCount(): Int = listKarakter.size

    override fun onBindViewHolder(holder: KarakterViewHolder, position: Int) {
        val (name, description, photo) = listKarakter[position]
        holder.binding.tvKarakterName.text = name
        holder.binding.tvKarakterDescription.text = description
        Glide.with(holder.binding.ivKarakterPicture)
            .load(photo)
            .into(holder.binding.ivKarakterPicture)
        holder.itemView.setOnClickListener {
            onClick(listKarakter[position])
        }
    }
}