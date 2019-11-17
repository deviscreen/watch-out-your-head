package com.num6pj.watchout.user.infra;

import java.util.Optional;

import com.num6pj.watchout.user.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

    /**
     * ID 에 의해 유저를 조회한다.
     * @param userId 유저 ID
     * @return 유저 정보
     */
    public Optional<UserInfo> findByUserId(String userId);
}
