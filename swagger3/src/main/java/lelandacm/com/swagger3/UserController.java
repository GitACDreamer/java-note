package lelandacm.com.swagger3;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("用户列表")
    @GetMapping("/all")
    public String userAll() {
        return userService.list().toString();
    }

    @ApiOperation("添加用户")
    @PostMapping("/add")
    public String userAdd(@Valid UserEntity entity) {
        return userService.save(entity) ? "success" : "failure";
    }

    @ApiOperation("用户详情")
    @GetMapping("/{id}")
    public String userDetail(@PathVariable Long id) {
        return userService.one(id).toString();
    }

    @ApiOperation("更新用户")
    @PutMapping("/{id}")
    public String userUpdate(@PathVariable Long id, @Valid UserEntity userEntity) {
        return userService.update(id, userEntity) ? "success" : "failure";
    }

    @ApiOperation("删除指定用户")
    @DeleteMapping("/{id}")
    public String userDelete(@PathVariable Long id) throws Exception {
        return userService.delete(id) ? "success" : "failure";
    }
}

