package com.tindeo.BryanGomezHincapie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tindeo.BryanGomezHincapie.databinding.ItemCommentBinding

//Adapter par monstar la info
class CommentAdapter(var items: List<Comment>): RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    class ViewHolder(var item: ItemCommentBinding): RecyclerView.ViewHolder(item.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCommentBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.item.commentTitle.text = item.title
        holder.item.commentDate.text = item.data
        holder.item.commentDescription.text = item.description
        holder.item.commentLike.text = item.like.toString()
        holder.item.commentDislike.text = item.unlike.toString()
        holder.item.ratingBarComment.rating = item.rating.toFloat()


    }

    override fun getItemCount(): Int {
        return items.size
    }
}