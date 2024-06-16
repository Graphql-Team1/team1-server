package com.sopt.team1.controller.dto

data class FollowResponseDTO(
    val id: Long,
    val followerCount: Int,
    val followingCount: Int
)