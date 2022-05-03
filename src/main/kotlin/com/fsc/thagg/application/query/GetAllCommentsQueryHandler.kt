package com.fsc.thagg.application.query

import com.fsc.thagg.application.dto.CommentDto
import com.fsc.thagg.application.dto.CommentListDto
import com.fsc.thagg.domain.CommentAdapter
import org.springframework.beans.factory.annotation.Autowired

data class GetAllCommentsQuery(val url: String)

class GetAllCommentsQueryHandler(
        @Autowired val commentAdapter: CommentAdapter
) {
    fun handle(getAllCommentsQuery: GetAllCommentsQuery): CommentListDto {
        val comments = commentAdapter.getAllComments(getAllCommentsQuery.url)

        val commentList: MutableList<CommentDto> = mutableListOf()
        comments.forEach { commentList.add(CommentDto(it.user,it.text)) }

        return CommentListDto(commentList)
    }

}
