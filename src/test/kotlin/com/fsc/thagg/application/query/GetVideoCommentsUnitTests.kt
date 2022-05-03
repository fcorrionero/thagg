package com.fsc.thagg.application.query

import com.fsc.thagg.domain.Comment
import com.fsc.thagg.domain.CommentAdapter
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetVideoCommentsUnitTests {

    @Mock
    lateinit var commentAdapterMock: CommentAdapter

    private lateinit var closeable: AutoCloseable

    @BeforeEach
    fun beforeEach() {
        closeable = MockitoAnnotations.openMocks(this)
    }

    @AfterEach
    @Throws(Exception::class)
    fun afterEach() {
        closeable.close()
    }

    @Test
    fun `should get all comments from a video url`() {
        val getAllCommentsQuery = GetAllCommentsQuery("url")

        val commentList = listOf(Comment("user1","text1"), Comment("user2","text2"))
        Mockito.`when`(commentAdapterMock.getAllComments(getAllCommentsQuery.url)).thenReturn(commentList)

        val getAllCommentsQueryHandler = GetAllCommentsQueryHandler(commentAdapterMock)
        val dto = getAllCommentsQueryHandler.handle(getAllCommentsQuery)

        Assertions.assertEquals(2, dto.comments.size)
        Assertions.assertEquals(dto.comments[0].text, commentList[0].text)
        Assertions.assertEquals(dto.comments[1].text, commentList[1].text)
        Assertions.assertEquals(dto.comments[0].user, commentList[0].user)
        Assertions.assertEquals(dto.comments[1].user, commentList[1].user)
    }

}