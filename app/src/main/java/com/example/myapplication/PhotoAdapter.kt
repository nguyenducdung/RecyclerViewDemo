package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PhotoAdapter constructor(val photoList: List<Photo>) :
    RecyclerView.Adapter<PhotoAdapter.PhotoVH>() {

    inner class PhotoVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var ivPhoto: ImageView
        private var tvName: TextView

        init {
            ivPhoto = itemView.findViewById(R.id.ivPhoto)
            tvName = itemView.findViewById(R.id.tvName)
        }

        fun setData(photo: Photo) {
            tvName.text = photo.title
            Glide.with(itemView.context).load(photo.thumbnailUrl).into(ivPhoto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return PhotoVH(view)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: PhotoVH, position: Int) {
        holder.setData(photoList[position])
    }
}