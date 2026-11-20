-- 测试数据

USE campus_erp;

INSERT INTO member (name, role) VALUES
('小林', '成员'),
('王老师', '老师'),
('李财务', '财务');

INSERT INTO project (name, total_amount) VALUES
('传感器采购', 1000.00),
('服务器采购', 5000.00);

INSERT INTO project_member (project_id, member_id) VALUES
(1,1), (1,2), (1,3), (2,1);

INSERT INTO application (project_id, applicant_id, purpose, apply_amount, state) VALUES
(1, 1, '采购温湿度传感器', 600.00, 'PENDING_L1');