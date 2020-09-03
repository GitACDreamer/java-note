package lelandacm.com.swagger3;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lelandacm
 */
@Component
public class UserServiceImpl implements UserService {
    private final List<UserEntity> users = new ArrayList<>();

    public UserServiceImpl() {
        for (long i = 1L; i < 10; ++i) {
            UserEntity entity = new UserEntity();
            entity.setId(i);
            entity.setUsername("username-" + i);
            entity.setPassword("password_" + 2 * i);
            entity.setAge((int) (10 + 2 * i));
            entity.setGender(i % 2 == 0 ? "男" : "女");
            entity.setTelephone("1858825412" + i);
            entity.setEmail("lelandacm-" + i + "@sunet.net.cn");
            users.add(entity);
        }
    }

    /**
     * 获取列表数据
     *
     * @return List<UserEntity>
     */
    @Override
    public List<UserEntity> list() {
        return users;
    }

    /**
     * 获取某个用户数据
     *
     * @param id id
     * @return UserEntity
     */
    @Override
    public UserEntity one(Long id) {
        return users.stream().findFirst().filter(entity -> entity.getId().equals(id)).get();
    }

    /**
     * 增加一个用户
     *
     * @param entity entity
     * @return 增加一个用户
     */
    @Override
    public boolean save(UserEntity entity) {
        return users.add(entity);
    }

    /**
     * 更新某个用户数据
     *
     * @param id     id
     * @param entity 用户数据
     * @return 结果
     */
    @Override
    public boolean update(Long id, UserEntity entity) {
        UserEntity userEntity = users.get(Math.toIntExact(id));
        if (userEntity == null) {
            return false;
        } else {
            users.set(Math.toIntExact(id), entity);
            return true;
        }
    }

    /**
     * 删除某个用户
     *
     * @param id id
     * @return 结果
     */
    @Override
    public boolean delete(Long id) {
        if (users.size() < id) {
            return false;
        }
        UserEntity userEntity = users.get(Math.toIntExact(id));
        if (userEntity == null) {
            return false;
        } else {
            return users.remove(userEntity);
        }
    }
}
