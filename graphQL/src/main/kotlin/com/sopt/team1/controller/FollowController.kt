package com.sopt.team1.controller

import com.sopt.team1.controller.dto.FollowResponseDTO
import com.sopt.team1.service.FollowService
import graphql.GraphQLContext
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestHeader

@Controller
class FollowController(
    private val followService: FollowService
) {
    @MutationMapping
    fun followUser(context: GraphQLContext, @Argument followingId: Long): FollowResponseDTO {
        val followerId = context.get<String>("user-id").toLong()
        return followService.follow(followerId, followingId)
    }

    @MutationMapping
    fun unfollowUser(context: GraphQLContext, @Argument followingId: Long): FollowResponseDTO {
        val followerId = context.get<String>("user-id").toLong()
        return followService.unfollow(followerId, followingId)
    }
}