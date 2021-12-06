package com.tindeo.BryanGomezHincapie.ui.adaptares

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tindeo.BryanGomezHincapie.data.models.Comment
import com.tindeo.BryanGomezHincapie.databinding.ItemCommentBinding

//Adapter par monstar la info
class CommentAdapter(var items: List<Comment>): RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    class ViewHolder(val item: ItemCommentBinding): RecyclerView.ViewHolder(item.root)

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
        holder.item.ratingBarComment.rating = item.rating!!.toFloat()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun newDataSet(newComments: List<Comment>){
        //Items cambiaron
        items = newComments
        // Indicar al recycler que se pinte again
        notifyDataSetChanged()
    }
}