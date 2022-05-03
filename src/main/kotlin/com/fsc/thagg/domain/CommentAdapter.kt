package com.fsc.thagg.domain

interface CommentAdapter {
    fun getAllComments(url: String): List<Comment>
}
