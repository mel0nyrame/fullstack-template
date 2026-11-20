-- 校园经费管理系统 · 表结构
-- 适用：MySQL 8.0 及以上

CREATE DATABASE IF NOT EXISTS campus_erp
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE campus_erp;

-- 按外键依赖顺序删除，避免报错
DROP TABLE IF EXISTS application;
DROP TABLE IF EXISTS project_member;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS member;

CREATE TABLE member (
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE project (
    id           INT PRIMARY KEY AUTO_INCREMENT,
    name         VARCHAR(100) NOT NULL,
    total_amount DECIMAL(10,2) NOT NULL
);

CREATE TABLE project_member (
    project_id INT NOT NULL,
    member_id  INT NOT NULL,
    PRIMARY KEY (project_id, member_id),
    FOREIGN KEY (project_id) REFERENCES project(id),
    FOREIGN KEY (member_id)  REFERENCES member(id)
);

CREATE TABLE application (
    id              INT PRIMARY KEY AUTO_INCREMENT,
    project_id      INT NOT NULL,
    applicant_id    INT NOT NULL,
    purpose         VARCHAR(200) NOT NULL,
    apply_amount    DECIMAL(10,2) NOT NULL,
    approved_amount DECIMAL(10,2) NULL,
    actual_amount   DECIMAL(10,2) NULL,
    state           VARCHAR(20) NOT NULL,
    created_at      DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (project_id)   REFERENCES project(id),
    FOREIGN KEY (applicant_id) REFERENCES member(id)
);