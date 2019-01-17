package bucom.repoistory;

import bucom.model.Friend;
import bucom.model.Friends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author HeavenY
 * @date 2019/1/17 16:25
 */
public interface UserReporistory extends JpaRepository<Friends,String> {

    Friends findByUseridAndFriendid(String userid, String friendid);

    @Modifying
    @Query(value = "update friend set islike=? where userid=? and friendid=?",nativeQuery = true)
    int updateIslike(String isLike,String friendid,String userid);

}
