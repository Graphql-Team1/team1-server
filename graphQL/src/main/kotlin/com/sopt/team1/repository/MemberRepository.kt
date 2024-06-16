package com.sopt.team1.repository

import com.sopt.team1.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long>