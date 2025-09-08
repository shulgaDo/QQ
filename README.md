# 数据库表设计

## user表

* id
* account(账号)
* password(密码)
* is_lock(是否被冻结)
* created_at(注册时间)
* is_deleted(是否注销)
* update_at(更新时间)

## user_login_log表

* id
* user_id
* ip_address(ip地址)
* login_time(登陆时间)
* status(登陆状态)
* device(设备名称)
* update_at(更新时间)

## API接口设计

1. 用户登陆接口(`/api/user/login`)  
    **请求参数**
    - ***account***:用户账号(必填)
    - ***password***:用户密码(必填)

    **请求方式**
    `POST`

    **返回值**
    - ***UserDTO***:用户账号信息
2. 用户登出接口(`/api/user/logout`)



