package lelandacm.com.resfulapi;

import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author lelandacm
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 创建线程安全的Map
     */
    static Map<Long, UserEntity> users = Collections.synchronizedMap(new HashMap<>());

    /**
     * 获取用户列表
     *
     * @return List<UserEntity>
     */
    @GetMapping("/all")
    public List<UserEntity> getUsers() {
        return new ArrayList<>(users.values());
    }

    /**
     * 添加用户
     *
     * @param userEntity 用户实体
     * @return string
     */
    @PostMapping("/add")
    public String addUser(UserEntity userEntity) {
        users.put(userEntity.getId(), userEntity);
        return "add success";
    }

    /**
     * 根据ID获取指定用户
     *
     * @param id id
     * @return UserEntity
     */
    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return users.get(id);
    }

    /**
     * 删除指定用户
     *
     * @param id id
     * @return string
     */
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        users.remove(id);
        return "delete success";
    }

    /**
     * 更新用户信息
     *
     * @param id     id
     * @param entity UserEntity
     * @return string
     */
    @PutMapping("/{id}")
    public String updateUserById(@PathVariable Long id, UserEntity entity) {
        UserEntity userEntity = users.get(id);
        if(userEntity == null){
            return "update default" ;
        }else {
            userEntity.setAge(entity.getAge());
            userEntity.setGender(entity.getGender());
            userEntity.setPassword(entity.getPassword());
            userEntity.setUsername(entity.getUsername());
            return "update success";
        }
    }
}
