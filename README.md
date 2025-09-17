# 数据库表设计

## user(用户表)

* id
* account(账号)
* password(密码)
* is_lock(是否被冻结)
* created_at(注册时间)
* is_deleted(是否注销)
* update_at(更新时间)

## user_login_log(用户登陆日志表)

* id
* user_id
* ip_address(ip地址)
* login_time(登陆时间)
* status(登陆状态)
* device(设备名称)
* update_at(更新时间)

## user_info(用户信息表)

* id
* user_id(用户ID)
* account(用户账号)
* avatar(用户头像)
* signature(签名)
* nickname(昵称)
* gender(性别)
* job(职业)
* company(公司)
* location(所在地)
* hometown(故乡)
* email(邮箱)
* personal_statement(个人说明)
* update_at(更新时间)
* birth_day(出生日期)
* birth_month(出生月份)
* birth_year(出生年份)

## info_photo(精选照片表)

* id
* user_id(用户ID)
* photo_url(照片URL)
* is_deleted(是否删除)
* upload_at(上传时间)

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



