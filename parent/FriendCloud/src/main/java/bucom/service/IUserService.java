package bucom.service;

import bucom.model.Friend;
import bucom.model.Friends;
import bucom.repoistory.UserReporistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author HeavenY
 * @date 2019/1/17 16:17
 */
@Service
@Transactional
public class IUserService {

    @Autowired
    private UserReporistory userReporistory;

  public int addFriend(String userId, String friendId) {
      Friends find = userReporistory.findByUseridAndFriendid(userId, friendId);
      //先判断userid到friendid是否有数据,有就是重复添加
    if (find!=null){
        return 0;
    }
    //直接添加好友,让好友列表中userid到friendid方向的type为0
        find=new Friends();
        find.setUserid(userId);
        find.setFriendid(friendId);
        find.setIslike("0");
        userReporistory.save(find);

    //判断从friendid到userid是否有数据,如果有,把双方的状态改为1
      if (userReporistory.findByUseridAndFriendid(friendId,userId)!=null){
          userReporistory.updateIslike("1", friendId, userId);
          userReporistory.updateIslike("1",userId,friendId);
      }
      return 1;
  }
}
