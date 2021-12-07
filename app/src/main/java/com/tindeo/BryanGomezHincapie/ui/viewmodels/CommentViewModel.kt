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

//    private var _comment: MutableLiveData<Comment?> = MutableLiveData()
//    //Getter
//    val comment2: LiveData<Comment?> get() = _comment

    private var _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> get() = _error

    fun loadComment(){
        viewModelScope.launch {
            val result = repo.loadComments()
            _comments.postValue(result)
        }
    }

    fun addComment(id:String, author:String?, title:String, description:String, data:String, image:String?, like: Int, unlike: Int, rating: Float){
        viewModelScope.launch {
            try {
                //_comment.postValue(repo.addComments(id,title,description,data,like,unlike,rating))
                repo.addComments(id,title,description,data,like,unlike,rating)
            }catch (e: Error){
                _error.postValue(e.message)
            }
        }
    }
}
