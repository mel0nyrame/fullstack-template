# 数据库脚本

## 环境

- MySQL 8.0 及以上，字符集 utf8mb4

## 执行顺序

1. 执行 `schema.sql`：创建数据库与四张表
2. 执行 `seed.sql`：插入测试数据

在 MySQL Workbench 中通过 `File → Open SQL Script` 打开文件后执行；
或命令行 `mysql -u 用户名 -p < schema.sql`。

注意：`schema.sql` 会删除同名表，请勿在有真实数据的库上执行。