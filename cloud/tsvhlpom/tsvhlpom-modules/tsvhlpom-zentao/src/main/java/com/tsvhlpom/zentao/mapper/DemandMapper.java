package com.tsvhlpom.zentao.mapper;


import com.tsvhlpom.zentao.DO.DemandDO;
import com.tsvhlpom.zentao.DTO.ZenTaoDTO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandMapper {

    @Select("select * from \n" +
            "(\n" +
            "  SELECT\n" +
            "    z.`id` AS zid, -- 需求编码\n" +
            "\t\tzp.id AS zpid, -- 产品编码\n" +
            "    zp.`name` AS zpname, -- 产品名称\n" +
            "    z.`pri` AS zpri, -- 需求优先级\n" +
            "    z.`title` AS ztitle ,-- 需求名称\n" +
            "    m.`name` AS mname, -- 所属模块\n" +
            "    (\n" +
            "      CASE\n" +
            "        WHEN z.`source` = 'business'\n" +
            "        THEN '业务要求'\n" +
            "        WHEN z.`source` = 'supervise'\n" +
            "        THEN '监管要求'\n" +
            "        WHEN z.`source` = 'thirdparty'\n" +
            "        THEN '第三方对接'\n" +
            "        ELSE z.`source`\n" +
            "      END\n" +
            "    ) AS  zsource , -- 需求来源\n" +
            "    u.`realname` AS urealname, -- 需求创建\n" +
            "    u2.`realname` AS u2realname, -- 需求指派,\n" +
            "    (\n" +
            "      CASE\n" +
            "        WHEN z.`stage` IN ('wait', 'planned', 'projected')\n" +
            "        THEN '待开发'\n" +
            "        WHEN z.`stage` = 'developing'\n" +
            "        THEN '开发中'\n" +
            "        WHEN z.`stage` IN ('developed', 'testing', 'tested')\n" +
            "        THEN '待用户验收'\n" +
            "        WHEN z.`stage` = 'verified'\n" +
            "        THEN '已验收待上线'\n" +
            "        WHEN z.`stage` = 'released'\n" +
            "        THEN '已上线'\n" +
            "        WHEN z.`stage` = 'closed'\n" +
            "        THEN '已关闭'\n" +
            "        ELSE z.`stage`\n" +
            "      END\n" +
            "    ) AS zstage, -- 需求阶段,\n" +
            "    z.`openedDate` AS zopeneddate, -- 创建时间,\n" +
            "    (SELECT MAX(a.`date`) FROM `zt_action` a, `zt_history` h WHERE a.`id` = h.`action` AND a.`objectType` = 'story' AND h.`field` = 'stage' AND h.`new` = 'released' AND a.`objectID` = z.`id` GROUP BY a.`objectID`) AS proonlinedate, -- 预计上线时间,\n" +
            "    task.`realst`AS taskrealst, -- 开发开始时间,\n" +
            "    task.`realed` AS taskrealed, -- 开发完成时间,\n" +
            "    (SELECT MAX(a.`date`) FROM `zt_action` a, `zt_history` h WHERE a.`id` = h.`action` AND a.`objectType` = 'story' AND h.`field` = 'stage' AND h.`new` = 'verified' AND a.`objectID` = z.`id` GROUP BY a.`objectID`) AS checkdate, -- 需求验收时间,\n" +
            "    (SELECT MAX(a.`date`) FROM `zt_action` a, `zt_history` h WHERE a.`id` = h.`action` AND a.`objectType` = 'story' AND h.`field` = 'stage' AND h.`new` = 'released' AND a.`objectID` = z.`id` GROUP BY a.`objectID`) AS onlinedate, -- 需求上线时间\n" +
            "    '' AS remarks, -- 备注\n" +
            "    (\n" +
            "      CASE\n" +
            "        WHEN z.`stage` IN ('wait', 'planned', 'projected')\n" +
            "        THEN 1\n" +
            "        WHEN z.`stage` = 'developing'\n" +
            "        THEN 2\n" +
            "        WHEN z.`stage` IN ('developed', 'testing', 'tested')\n" +
            "        THEN 3\n" +
            "        WHEN z.`stage` = 'verified'\n" +
            "        THEN 4\n" +
            "        WHEN z.`stage` = 'released'\n" +
            "        THEN 6\n" +
            "        WHEN z.`stage` = 'closed'\n" +
            "        THEN 7\n" +
            "        ELSE 8\n" +
            "      END\n" +
            "    ) AS sorted," +
            "   task.ed as deadline"+
            "  FROM\n" +
            "    zt_story z\n" +
            "    LEFT JOIN zt_product zp\n" +
            "      ON z.`product` = zp.`id`\n" +
            "    LEFT JOIN zt_user u\n" +
            "      ON z.`openedBy` = u.`account`\n" +
            "    LEFT JOIN zt_user u2\n" +
            "      ON z.`assignedTo` = u2.`account`\n" +
            "    LEFT JOIN zt_module m\n" +
            "      ON z.`module` = m.`id`\n" +
            "    LEFT JOIN (SELECT t.`story` AS styid, GROUP_CONCAT(ztu.`realname`) AS toname, GROUP_CONCAT(CASE WHEN t.`status` = 'wait' THEN '未开始' WHEN t.`status` = 'doing' THEN '进行中' WHEN t.`status` = 'done' THEN '已完成' WHEN t.`status` = 'pause' THEN '已暂停' WHEN t.`status` = 'cancel' THEN '已取消' WHEN t.`status` = 'closed' THEN '已关闭' ELSE t.`status` END) AS tsts, COUNT(*) AS cnt, MIN(t.`estStarted`) AS st, MAX(t.`deadline`) AS ed, MIN(t.`realStarted`) AS realst, (CASE WHEN MIN(t.`finishedDate`) = '0000-00-00 00:00:00' THEN MIN(t.`finishedDate`) ELSE MAX(t.`finishedDate`) END) AS realed, SUM(t.`estimate`) AS ett, SUM(t.`consumed`) AS csm, SUM(t.`left`) AS lft, CONCAT(ROUND(((SUM(t.`consumed`) / (SUM(t.`consumed`) + SUM(t.`left`))) * 100), 0), '%') AS prg FROM zt_task t LEFT JOIN zt_user ztu ON t.`assignedTo` = ztu.`account` WHERE t.`deleted` = '0' AND t.`status` NOT IN ('cancel', 'closed') AND t.`story` <> 0 GROUP BY t.`story`) task\n" +
            "      ON z.`id` = task.`styid`\n" +
            "    WHERE z.`status` NOT IN  ('closed', 'draft')\n" +
            "    ORDER BY zp.`name`, \n" +
            "    (\n" +
            "      CASE\n" +
            "        WHEN z.`stage` = 'wait'\n" +
            "        THEN '01'\n" +
            "        WHEN z.`stage` = 'planned'\n" +
            "        THEN '02'\n" +
            "        WHEN z.`stage` = 'projected'\n" +
            "        THEN '03'\n" +
            "        WHEN z.`stage` = 'developing'\n" +
            "        THEN '04'\n" +
            "        WHEN z.`stage` = 'developed'\n" +
            "        THEN '05'\n" +
            "        WHEN z.`stage` = 'testing'\n" +
            "        THEN '06'\n" +
            "        WHEN z.`stage` = 'tested'\n" +
            "        THEN '07'\n" +
            "        WHEN z.`stage` = 'verified'\n" +
            "        THEN '08'\n" +
            "        WHEN z.`stage` = 'released'\n" +
            "        THEN '09'\n" +
            "        WHEN z.`stage` = 'closed'\n" +
            "        THEN '10'\n" +
            "        ELSE z.`stage`\n" +
            "      END\n" +
            "    ), z.`openedDate` DESC\n" +
            ") t  \n" +
            "where t.zpid= #{productId}  and \n" +
            "(\n" +
            "t.zstage in ('待开发','开发中','待用户验收','已验收待上线')\n" +
            "OR \n" +
            "(t.zstage = '已上线' AND \n" +
            "(t.onlinedate IS NULL OR t.onlinedate > #{startDate})\n" +
            ")\n" +
            "\n" +
            ")")
    List<DemandDO> findList(ZenTaoDTO zenTaoDTO);

    @Select("select * from \n" +
            "(\n" +
            "  SELECT\n" +
            "    z.`id` AS zid, -- 需求编码\n" +
            "		zp.id AS zpid, -- 产品编码\n" +
            "    zp.`name` AS zpname, -- 产品名称\n" +
            "    z.`pri` AS zpri, -- 需求优先级\n" +
            "    z.`title` AS ztitle ,-- 需求名称\n" +
            "    m.`name` AS mname, -- 所属模块\n" +
            "    (\n" +
            "      CASE\n" +
            "        WHEN z.`source` = 'business'\n" +
            "        THEN '业务要求'\n" +
            "        WHEN z.`source` = 'supervise'\n" +
            "        THEN '监管要求'\n" +
            "        WHEN z.`source` = 'thirdparty'\n" +
            "        THEN '第三方对接'\n" +
            "        ELSE z.`source`\n" +
            "      END\n" +
            "    ) AS  zsource , -- 需求来源\n" +
            "    u.`realname` AS urealname, -- 需求创建\n" +
            "    u2.`realname` AS u2realname, -- 需求指派,\n" +
            "    (\n" +
            "      CASE\n" +
            "        WHEN z.`stage` IN ('wait', 'planned', 'projected')\n" +
            "        THEN '待开发'\n" +
            "        WHEN z.`stage` = 'developing'\n" +
            "        THEN '开发中'\n" +
            "        WHEN z.`stage` IN ('developed', 'testing', 'tested')\n" +
            "        THEN '待用户验收'\n" +
            "        WHEN z.`stage` = 'verified'\n" +
            "        THEN '已验收待上线'\n" +
            "        WHEN z.`stage` = 'released'\n" +
            "        THEN '已上线'\n" +
            "        WHEN z.`stage` = 'closed'\n" +
            "        THEN '已关闭'\n" +
            "        ELSE z.`stage`\n" +
            "      END\n" +
            "    ) AS zstage, -- 需求阶段,\n" +
            "    z.`openedDate` AS zopeneddate, -- 创建时间,\n" +
            "    (SELECT MAX(a.`date`) FROM `zt_action` a, `zt_history` h WHERE a.`id` = h.`action` AND a.`objectType` = 'story' AND h.`field` = 'stage' AND h.`new` = 'released' AND a.`objectID` = z.`id` GROUP BY a.`objectID`) AS proonlinedate, -- 预计上线时间,\n" +
            "    task.`realst`AS taskrealst, -- 开发开始时间,\n" +
            "    task.`realed` AS taskrealed, -- 开发完成时间,\n" +
            "    (SELECT MAX(a.`date`) FROM `zt_action` a, `zt_history` h WHERE a.`id` = h.`action` AND a.`objectType` = 'story' AND h.`field` = 'stage' AND h.`new` = 'verified' AND a.`objectID` = z.`id` GROUP BY a.`objectID`) AS checkdate, -- 需求验收时间,\n" +
            "    (SELECT MAX(a.`date`) FROM `zt_action` a, `zt_history` h WHERE a.`id` = h.`action` AND a.`objectType` = 'story' AND h.`field` = 'stage' AND h.`new` = 'released' AND a.`objectID` = z.`id` GROUP BY a.`objectID`) AS onlinedate, -- 需求上线时间\n" +
            "    '' AS remarks, -- 备注\n" +
            "    (\n" +
            "      CASE\n" +
            "        WHEN z.`stage` IN ('wait', 'planned', 'projected')\n" +
            "        THEN 1\n" +
            "        WHEN z.`stage` = 'developing'\n" +
            "        THEN 2\n" +
            "        WHEN z.`stage` IN ('developed', 'testing', 'tested')\n" +
            "        THEN 3\n" +
            "        WHEN z.`stage` = 'verified'\n" +
            "        THEN 4\n" +
            "        WHEN z.`stage` = 'released'\n" +
            "        THEN 6\n" +
            "        WHEN z.`stage` = 'closed'\n" +
            "        THEN 7\n" +
            "        ELSE 8\n" +
            "      END\n" +
            "    ) AS sorted,   task.ed as deadline  FROM\n" +
            "    zt_story z\n" +
            "    LEFT JOIN zt_product zp\n" +
            "      ON z.`product` = zp.`id`\n" +
            "    LEFT JOIN zt_user u\n" +
            "      ON z.`openedBy` = u.`account`\n" +
            "    LEFT JOIN zt_user u2\n" +
            "      ON z.`assignedTo` = u2.`account`\n" +
            "    LEFT JOIN zt_module m\n" +
            "      ON z.`module` = m.`id`\n" +
            "    LEFT JOIN (SELECT t.`story` AS styid, GROUP_CONCAT(ztu.`realname`) AS toname, GROUP_CONCAT(CASE WHEN t.`status` = 'wait' THEN '未开始' WHEN t.`status` = 'doing' THEN '进行中' WHEN t.`status` = 'done' THEN '已完成' WHEN t.`status` = 'pause' THEN '已暂停' WHEN t.`status` = 'cancel' THEN '已取消' WHEN t.`status` = 'closed' THEN '已关闭' ELSE t.`status` END) AS tsts, COUNT(*) AS cnt, MIN(t.`estStarted`) AS st, MAX(t.`deadline`) AS ed, MIN(t.`realStarted`) AS realst, (CASE WHEN MIN(t.`finishedDate`) = '0000-00-00 00:00:00' THEN MIN(t.`finishedDate`) ELSE MAX(t.`finishedDate`) END) AS realed, SUM(t.`estimate`) AS ett, SUM(t.`consumed`) AS csm, SUM(t.`left`) AS lft, CONCAT(ROUND(((SUM(t.`consumed`) / (SUM(t.`consumed`) + SUM(t.`left`))) * 100), 0), '%') AS prg FROM zt_task t LEFT JOIN zt_user ztu ON t.`assignedTo` = ztu.`account` WHERE t.`deleted` = '0' AND t.`status` NOT IN ('cancel', 'closed') AND t.`story` <> 0 GROUP BY t.`story`) task\n" +
            "      ON z.`id` = task.`styid`\n" +
            "    WHERE z.`status` NOT IN  ('closed', 'draft')\n" +
            "    ORDER BY zp.`name`, \n" +
            "    (\n" +
            "      CASE\n" +
            "        WHEN z.`stage` = 'wait'\n" +
            "        THEN '01'\n" +
            "        WHEN z.`stage` = 'planned'\n" +
            "        THEN '02'\n" +
            "        WHEN z.`stage` = 'projected'\n" +
            "        THEN '03'\n" +
            "        WHEN z.`stage` = 'developing'\n" +
            "        THEN '04'\n" +
            "        WHEN z.`stage` = 'developed'\n" +
            "        THEN '05'\n" +
            "        WHEN z.`stage` = 'testing'\n" +
            "        THEN '06'\n" +
            "        WHEN z.`stage` = 'tested'\n" +
            "        THEN '07'\n" +
            "        WHEN z.`stage` = 'verified'\n" +
            "        THEN '08'\n" +
            "        WHEN z.`stage` = 'released'\n" +
            "        THEN '09'\n" +
            "        WHEN z.`stage` = 'closed'\n" +
            "        THEN '10'\n" +
            "        ELSE z.`stage`\n" +
            "      END\n" +
            "    ), z.`openedDate` DESC\n" +
            ") t  \n" +
            "where \n" +
            "zid =  #{zid} ")
    DemandDO findDemandById(Integer zid);

}
