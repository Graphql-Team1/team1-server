package com.sopt.team1.repository

import com.sopt.team1.domain.Follow
import org.springframework.data.jpa.repository.JpaRepository

interface FollowRepository : JpaRepository<Follow, Long>{
    fun deleteByFollowerIdAndFollowingId(followerId: Long, followingId: Long)
    fun existsByFollowerIdAndFollowingId(followerId: Long, followingId: Long): Boolean
}