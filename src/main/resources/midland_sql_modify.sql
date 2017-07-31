
  ALTER table user MODIFY `audit_status` int(11) DEFAULT 0 COMMENT '审核状态';
  ALTER table user MODIFY `is_black` varchar(255) DEFAULT 0 COMMENT '是否加入黑名单';