CREATE TABLE `order_info` (
  `id` int(32) NOT NULL,
  `order_id` varchar(32) DEFAULT NULL,
  `order_name` varchar(255) DEFAULT NULL,
  `createdAt` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `order_info_ext` (
  `id` int(32) NOT NULL,
  `order_id` varchar(32) DEFAULT NULL,
  `attach_info` varchar(255) DEFAULT NULL,
  `createdAt` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `spcc_area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `parentID` bigint(20) NOT NULL COMMENT '父id',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `level` tinyint(4) NOT NULL COMMENT '层级 0 1 2 省市区县',
  `mergeName` varchar(100) NOT NULL DEFAULT '',
  `archive` tinyint(1) NOT NULL DEFAULT '0',
  `createAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `index_parentId` (`parentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `spcc_banner` (
  `id` bigint(20) NOT NULL,
  `title` varchar(32) DEFAULT NULL COMMENT '名称',
  `img` text COMMENT '图片链接',
  `objID` bigint(20) DEFAULT NULL COMMENT '关联id',
  `objType` int(11) DEFAULT NULL COMMENT '类型',
  `weight` int(32) DEFAULT '0' COMMENT '权重',
  `display` tinyint(1) DEFAULT '1' COMMENT '开启关闭',
  `userID` bigint(20) DEFAULT NULL COMMENT '所属人id',
  `jurisdiction` varchar(32) DEFAULT NULL COMMENT '所属品牌',
  `archive` tinyint(1) DEFAULT '0',
  `createdAt` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `spcc_carry_area` (
  `id` bigint(10) NOT NULL,
  `areaID` bigint(10) NOT NULL COMMENT '地区id',
  `carryModeID` bigint(10) NOT NULL COMMENT '计算方式id',
  `archive` tinyint(1) NOT NULL DEFAULT '0',
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `spcc_carry_mode` (
  `id` bigint(21) NOT NULL,
  `fareTempID` bigint(21) NOT NULL COMMENT '模板表外键',
  `firstFare` decimal(11,0) DEFAULT NULL COMMENT '起步价',
  `stepFare` decimal(11,0) DEFAULT NULL COMMENT '加价',
  `maxFare` decimal(10,0) NOT NULL COMMENT '最高价',
  `archive` tinyint(1) NOT NULL DEFAULT '0',
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `spcc_cart` (
  `id` bigint(20) NOT NULL,
  `userId` bigint(20) NOT NULL,
  `skuId` bigint(20) NOT NULL,
  `count` smallint(6) NOT NULL,
  `archived` tinyint(1) NOT NULL DEFAULT '0',
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_userId_archived` (`userId`,`archived`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `spcc_cart_tcc` (
  `id` bigint(20) NOT NULL,
  `seqId` varchar(64) NOT NULL,
  `cartId` bigint(20) NOT NULL,
  `state` smallint(6) NOT NULL,
  `reason` varchar(32) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `index_seqId` (`seqId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `spcc_category` (
  `id` bigint(20) NOT NULL,
  `title` varchar(32) DEFAULT NULL COMMENT '名称',
  `parentID` bigint(20) DEFAULT NULL COMMENT '父id',
  `img` text COMMENT '图片链接',
  `claID` bigint(20) DEFAULT NULL COMMENT '分组关联id',
  `level` int(11) DEFAULT NULL COMMENT '分类的等级',
  `userID` bigint(20) DEFAULT NULL COMMENT '所属人id',
  `jurisdiction` varchar(32) DEFAULT NULL COMMENT '所属品牌',
  `archive` tinyint(1) DEFAULT '0',
  `createdAt` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `spcc_channel` (
  `id` bigint(20) NOT NULL,
  `title` varchar(32) DEFAULT NULL COMMENT '名称',
  `parentID` bigint(20) DEFAULT NULL COMMENT '父id',
  `img` text COMMENT '图片链接',
  `claID` bigint(20) DEFAULT NULL COMMENT '分组关联id',
  `level` int(11) DEFAULT NULL COMMENT '分类的等级',
  `userID` bigint(20) DEFAULT NULL COMMENT '所属人id',
  `jurisdiction` varchar(32) DEFAULT NULL COMMENT '所属品牌',
  `archive` tinyint(1) DEFAULT '0',
  `createdAt` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `spcc_classification` (
  `id` bigint(20) NOT NULL,
  `parentID` bigint(20) DEFAULT NULL,
  `classification` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `display` tinyint(1) DEFAULT '0',
  `userID` bigint(20) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `jurisdiction` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL,
  `archive` tinyint(1) DEFAULT '0',
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `spcc_content` (
  `id` bigint(20) NOT NULL,
  `typeId` bigint(20) NOT NULL,
  `operatorId` bigint(20) NOT NULL,
  `jurisdiction` varchar(32) NOT NULL,
  `title` varchar(32) NOT NULL,
  `text` varchar(256) NOT NULL,
  `image` text NOT NULL,
  `audio` text,
  `video` text,
  `detail` text,
  `showType` smallint(6) NOT NULL,
  `state` smallint(6) NOT NULL,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `addr` varchar(64) DEFAULT NULL,
  `weight` smallint(6) NOT NULL DEFAULT '1',
  `archived` tinyint(1) NOT NULL DEFAULT '0',
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_typeId_state` (`typeId`,`state`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `spcc_content_product_group` (
  `id` bigint(20) NOT NULL,
  `contentId` bigint(20) NOT NULL,
  `groupId` bigint(20) NOT NULL,
  `archived` tinyint(1) NOT NULL DEFAULT '0',
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `spcc_content_type` (
  `id` bigint(20) NOT NULL,
  `name` varchar(64) NOT NULL,
  `img` varchar(256) NOT NULL,
  `archived` tinyint(1) DEFAULT '0',
  `createdAt` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `spcc_dict_color` (
  `id` bigint(20) NOT NULL,
  `colorID` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL,
  `colorNa` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL,
  `archive` tinyint(1) DEFAULT '0',
  `erp` tinyint(1) DEFAULT '1',
  `createdAt` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `index_c_a` (`colorID`,`archive`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `spcc_dict_size` (
  `id` bigint(11) NOT NULL,
  `size` varchar(20) DEFAULT NULL,
  `archive` tinyint(1) DEFAULT '0',
  `createdAt` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `spcc_fare_temp` (
  `id` bigint(21) NOT NULL COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '模板名称',
  `allGoods` tinyint(1) DEFAULT '0',
  `allCust` tinyint(1) DEFAULT '0',
  `jurisdiction` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL,
  `archive` tinyint(1) NOT NULL DEFAULT '0' COMMENT '1-可用，0-不可用',
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `spcc_goods` (
  `id` bigint(20) NOT NULL,
  `goodsNo` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `goodsName` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL,
  `title` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `mainImg` text CHARACTER SET utf8mb4,
  `otherDesc` text CHARACTER SET utf8mb4,
  `year` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL,
  `season` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL,
  `category` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL,
  `category2` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL,
  `range` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sex` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL,
  `brand` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL,
  `wave` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL,
  `adapt` varchar(32) DEFAULT NULL,
  `display` tinyint(1) NOT NULL DEFAULT '1',
  `online` tinyint(1) NOT NULL DEFAULT '1',
  `onlineTime` bigint(20) DEFAULT NULL,
  `erp` tinyint(1) NOT NULL DEFAULT '1',
  `unitPrice` decimal(10,2) DEFAULT NULL,
  `minPrice` decimal(10,2) DEFAULT NULL,
  `maxPrice` decimal(10,2) DEFAULT NULL,
  `fareID` int(11) DEFAULT NULL,
  `mainSkc` varchar(256) CHARACTER SET utf8mb4 DEFAULT NULL,
  `jurisdiction` varchar(32) DEFAULT NULL,
  `agentId` bigint(20) DEFAULT NULL,
  `fxStatus` int(11) DEFAULT NULL,
  `fxMoney` float(11,2) DEFAULT NULL,
  `fxPoint` float(11,3) DEFAULT NULL,
  `fxEst` float(11,2) DEFAULT NULL,
  `archive` tinyint(1) NOT NULL DEFAULT '0',
  `createdAt` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `weight` int(20) DEFAULT NULL,
  `fictitious` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `index_o_d_a` (`online`,`display`,`archive`),
  KEY `index_g` (`goodsNo`) USING BTREE,
  KEY `index_o_a` (`online`,`archive`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `spcc_goods_skc` (
  `id` bigint(20) NOT NULL,
  `goodsNo` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `colorID` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `img` text CHARACTER SET utf8mb4,
  `erp` tinyint(1) DEFAULT '1',
  `archive` tinyint(1) DEFAULT '0',
  `createdAt` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `index_g_a` (`goodsNo`,`archive`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `spcc_goods_sku` (
  `id` bigint(20) NOT NULL,
  `goodsNo` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `colorID` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `size` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `skuCode` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `archive` tinyint(1) DEFAULT '0',
  `createdAt` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `index_s_a` (`skuCode`,`archive`) USING BTREE,
  KEY `index_g_c_a` (`goodsNo`,`colorID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `spcc_shop_account` (
  `id` bigint(20) NOT NULL,
  `customerid` varchar(100) NOT NULL,
  `balance` double NOT NULL DEFAULT '0',
  `createdAt` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_shop_account` (`customerid`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `spcc_shop_account_actions` (
  `id` bigint(20) NOT NULL,
  `customerid` varchar(255) NOT NULL,
  `type` varchar(50) NOT NULL,
  `amount` double NOT NULL,
  `desc` varchar(255) NOT NULL DEFAULT '',
  `module` varchar(255) NOT NULL DEFAULT '',
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `spcc_shop_account_withdraw` (
  `id` bigint(20) NOT NULL,
  `customerid` varchar(255) NOT NULL,
  `status` tinyint(3) unsigned NOT NULL DEFAULT '1',
  `desc` varchar(255) NOT NULL DEFAULT '',
  `userId` bigint(20) NOT NULL,
  `amount` double NOT NULL,
  `paymentWay` varchar(255) DEFAULT '',
  `paymentDesc` varchar(255) DEFAULT '',
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `spcc_shop_balance_tcc` (
  `id` bigint(20) NOT NULL,
  `seqId` varchar(64) NOT NULL,
  `customerid` varchar(255) NOT NULL,
  `amount` double NOT NULL,
  `type` varchar(50) NOT NULL,
  `desc` varchar(255) NOT NULL DEFAULT '',
  `module` varchar(255) NOT NULL DEFAULT '',
  `status` tinyint(1) NOT NULL,
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `spcc_shop_global_config` (
  `id` bigint(20) NOT NULL,
  `key` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `spcc_shop_goods` (
  `id` bigint(20) NOT NULL,
  `goodsNo` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `customerID` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL,
  `jurisdiction` varchar(32) DEFAULT NULL,
  `agentId` bigint(20) DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `descImg` text CHARACTER SET utf8mb4,
  `display` tinyint(1) DEFAULT '1',
  `online` tinyint(1) DEFAULT '1',
  `onlineTime` bigint(20) DEFAULT NULL,
  `weight` int(20) DEFAULT '0',
  `mainGoods` tinyint(1) DEFAULT '0',
  `fxStatus` int(11) DEFAULT NULL,
  `fxMoney` float(11,2) DEFAULT NULL,
  `fxPoint` float(11,3) DEFAULT NULL,
  `fxEst` float(11,2) DEFAULT NULL,
  `stockNum` int(11) DEFAULT NULL,
  `archive` tinyint(1) DEFAULT '0',
  `createdAt` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `saleNum` int(20) DEFAULT NULL,
  `balancePrice` decimal(20,2) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `index_cst_goodsno` (`customerID`,`goodsNo`),
  KEY `index_g` (`goodsNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `spcc_shop_goods_stock` (
  `id` bigint(20) NOT NULL,
  `skuId` bigint(20) DEFAULT NULL,
  `skuCode` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL,
  `stockNum` int(11) DEFAULT NULL,
  `customerID` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL,
  `online` tinyint(1) DEFAULT '1',
  `synStorage` tinyint(1) DEFAULT '1',
  `archive` tinyint(1) DEFAULT '0',
  `createdAt` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `index_c_o` (`customerID`,`online`) USING BTREE,
  KEY `index_c_s` (`customerID`,`skuId`) USING BTREE,
  KEY `index_c_c` (`customerID`,`skuCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `spcc_shop_goods_stock_tcc` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `seqId` varchar(64) CHARACTER SET utf8 NOT NULL,
  `skuId` bigint(20) NOT NULL,
  `customerID` varchar(32) NOT NULL,
  `status` int(11) NOT NULL,
  `value` int(11) NOT NULL,
  `remark` varchar(100) NOT NULL,
  `archive` tinyint(1) NOT NULL DEFAULT '0',
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `index_seqId` (`seqId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

CREATE TABLE `spcc_shop_goods_test` (
  `id` bigint(20) NOT NULL,
  `goodsNo` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `customerID` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL,
  `jurisdiction` varchar(32) DEFAULT NULL,
  `agentId` bigint(20) DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `descImg` text CHARACTER SET utf8mb4,
  `display` tinyint(1) DEFAULT '1',
  `online` tinyint(1) DEFAULT '1',
  `onlineTime` bigint(20) DEFAULT NULL,
  `weight` int(20) DEFAULT '0',
  `mainGoods` tinyint(1) DEFAULT '0',
  `fxStatus` int(11) DEFAULT NULL,
  `fxMoney` float(11,2) DEFAULT NULL,
  `fxPoint` float(11,3) DEFAULT NULL,
  `fxEst` float(11,2) DEFAULT NULL,
  `stockNum` int(11) DEFAULT NULL,
  `archive` tinyint(1) DEFAULT '0',
  `createdAt` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `saleNum` int(20) DEFAULT NULL,
  `balancePrice` decimal(20,2) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `index_cst_goodsno` (`customerID`,`goodsNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `spcc_shop_img_nodes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parentid` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  `level` tinyint(4) DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=737 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `spcc_shop_personal_config` (
  `id` bigint(20) NOT NULL,
  `customerid` varchar(255) DEFAULT NULL,
  `key` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `spcc_user_fx_product_collection` (
  `id` bigint(20) NOT NULL,
  `userid` bigint(20) NOT NULL,
  `productid` bigint(20) NOT NULL,
  `archive` tinyint(1) DEFAULT '0',
  `createdAt` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;