package com.tindeo.BryanGomezHincapie.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tindeo.BryanGomezHincapie.data.models.Comment
import com.tindeo.BryanGomezHincapie.data.repositories.CommentRepository
import kotlinx.coroutines.launch

class CommentViewModel(private val repo: CommentRepository): ViewModel() {
    private var _comments: MutableLiveData<List<Comment>> = MutableLiveData()
    val comment: LiveData<List <Comment> > get() = _comments

    fun loadComment(){
        viewModelScope.launch {
            val result = repo.loadComments()
            _comments.postValue(result)
        }
    }
}