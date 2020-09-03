package lelandacm.com.swagger3;

import java.util.List;

public interface UserService {
    /**
     * 获取列表数据
     *
     * @return List<UserEntity>
     */
    List<UserEntity> list();

    /**
     * 获取某个用户数据
     *
     * @param id id
     * @return UserEntity
     */
    UserEntity one(Long id);

    /**
     * 增加一个用户
     *
     * @param entity entity
     * @return 增加一个用户
     */
    boolean save(UserEntity entity);

    /**
     * 更新某个用户数据
     *
     * @param id     id
     * @param entity 用户数据
     * @return 结果
     */
    boolean update(Long id, UserEntity entity);

    /**
     * 删除某个用户
     *
     * @param id id
     * @return 结果
     * @throws Exception 异常
     */
    boolean delete(Long id) throws Exception;
}
