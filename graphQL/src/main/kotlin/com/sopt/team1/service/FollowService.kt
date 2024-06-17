package com.sopt.team1.service

import com.sopt.team1.controller.dto.FollowResponseDTO
import com.sopt.team1.domain.Follow
import com.sopt.team1.repository.FollowRepository
import com.sopt.team1.repository.MemberRepository
import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class FollowService(private val followRepository: FollowRepository, private val memberRepository: MemberRepository) {
    @Transactional
    fun follow(memberId: Long, targetId: Long): FollowResponseDTO {
        when {
            memberId == targetId -> throw IllegalArgumentException("You can't follow yourself")
            followRepository.existsByFollowerIdAndFollowingId(memberId, targetId) -> throw IllegalArgumentException("You already follow this member")
            else -> {
                val follow = Follow(followerId = memberId, followingId = targetId)
                followRepository.save(follow)

                val follower = memberRepository.findById(memberId)
                    .orElseThrow { throw EntityNotFoundException("Member not found with id: $memberId") }
                follower.following += 1

                val target = memberRepository.findById(targetId)
                    .orElseThrow { throw EntityNotFoundException("Member not found with id: $targetId") }
                target.follower += 1

                return FollowResponseDTO(
                    id = follower.id ?: error("Follower id should not be null"),
                    followerCount = follower.follower,
                    followingCount = follower.following
                )
            }
        }
    }

    @Transactional
    fun unfollow(memberId: Long, targetId: Long): FollowResponseDTO{
        when{
            memberId == targetId -> throw IllegalArgumentException("You can't unfollow yourself")
            !followRepository.existsByFollowerIdAndFollowingId(memberId, targetId) -> throw IllegalArgumentException("You don't follow this member")
            else -> {
                followRepository.deleteByFollowerIdAndFollowingId(memberId, targetId)

                val follower = memberRepository.findById(memberId)
                    .orElseThrow { throw EntityNotFoundException("Member not found with id: $memberId") }
                follower.following -= 1

                val target = memberRepository.findById(targetId)
                    .orElseThrow { throw EntityNotFoundException("Member not found with id: $targetId") }
                target.follower -= 1

                return FollowResponseDTO(
                    id = follower.id ?: error("Follower id should not be null"),
                    followerCount = follower.follower,
                    followingCount = follower.following
                )
            }
        }
    }
}