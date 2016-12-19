INSERT INTO users (id, username, password, name, enabled) VALUES ('1', 'admin', '$2a$10$iuP4W7eD1b8Z/1TwKpJQsuErZbhKI.jkuwK8HUrfbO.rnf7kgz6WW', '付佩玉', 1);
INSERT INTO users (id, username, password, name, enabled) VALUES ('2', 'root', '$2a$10$x6JzBvXC6/42nTcUCIUm8uyF1UoYe2kdNvdW.VXhm4oKgOoRWZYzC', '殷超', 1);

INSERT INTO groups (id, group_name, name, description, enabled) VALUES ('1', 'ROOT', '管理员', '管理用户组', 1);
INSERT INTO groups (id, group_name, name, description, enabled) VALUES ('2', 'ADMIN', '处理员', '处理数据', 1);

INSERT INTO group_members (username, group_id) VALUES ('root', '1');
INSERT INTO group_members (username, group_id) VALUES ('admin', '2');

INSERT INTO permissions (id, name, path, authority, enabled) VALUES ('1', '后台登录', '/admin/**', 'AUTH_ADMIN', 1);
INSERT INTO permissions (id, name, path, authority, enabled) VALUES ('2', '人员管理', '/admin/users/**', 'AUTH_USER_MGNT', 1);
INSERT INTO permissions (id, name, path, authority, enabled) VALUES ('3', '用户组管理', '/admin/groups/**', 'AUTH_GROUP_MGNT', 1);
INSERT INTO permissions (id, name, path, authority, enabled) VALUES ('4', '权限管理', '/admin/authorities/**', 'AUTH_AUTHORITY_MGNT', 1);

--后台登录
INSERT INTO group_authorities (group_id, authority) VALUES ('1', 'AUTH_ADMIN');
INSERT INTO group_authorities (group_id, authority) VALUES ('2', 'AUTH_ADMIN');
-- 人员管理
INSERT INTO group_authorities (group_id, authority) VALUES ('1', 'AUTH_USER_MGNT');
-- 用户组管理
INSERT INTO group_authorities (group_id, authority) VALUES ('1', 'AUTH_GROUP_MGNT');
-- 权限管理
INSERT INTO group_authorities (group_id, authority) VALUES ('1', 'AUTH_AUTHORITY_MGNT');

-- 权限管理--角色
INSERT INTO authorities (username, authority) VALUES ('root', 'ROLE_ROOT');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');