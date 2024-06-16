package com.sopt.team1.controller

import com.sopt.team1.controller.dto.FollowResponseDTO
import com.sopt.team1.service.FollowService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller

@Controller
class FollowController(
    private val followService: FollowService
) {
    @MutationMapping
    fun followUser(@Argument followerId: Long, @Argument followingId: Long): FollowResponseDTO {
        return followService.follow(followerId, followingId)
    }

    @MutationMapping
    fun unfollowUser(@Argument followerId: Long, @Argument followingId: Long): FollowResponseDTO {
        return followService.unfollow(followerId, followingId)
    }
}