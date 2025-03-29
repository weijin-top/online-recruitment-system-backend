/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80036
 Source Host           : localhost:3306
 Source Schema         : db_recruitment

 Target Server Type    : MySQL
 Target Server Version : 80036
 File Encoding         : 65001

 Date: 29/03/2025 11:37:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_company
-- ----------------------------
DROP TABLE IF EXISTS `t_company`;
CREATE TABLE `t_company`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '公司别名',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `logo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `intro` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '公司简介',
  `status` int NULL DEFAULT 0 COMMENT '状态 0未审核 1通过 2未通过',
  `is_deleted` int NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `status`(`status`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  CONSTRAINT `t_company_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_company
-- ----------------------------
INSERT INTO `t_company` VALUES (1, 2, '阿里巴巴网络技术有限公司', '阿里巴巴', '浙江省杭州市西湖区文一西路788号杭州蒋村商务中心B1座F', 'recruitment/c100738b-843c-4dbe-9808-e6991218520f.jpg', '阿里巴巴集团的使命是让天下没有难做的生意。我们旨在助力企业，帮助其变革营销、销售和经营的方式，提升其效率。我们为商家、品牌、零售商及其他企业提供技术设施以及营销平台，帮助其借助新技术的力量与用户和客户互动，并更高效地经营。我们还为企业提供领先的云设施和服务，以及更强的工作协作能力，促进其数字化转型并支持其业务增长。', 1, 0);
INSERT INTO `t_company` VALUES (4, 5, '数联信（成都）网络信息技术有限公司', '数联信', '成都武侯区布鲁明顿广场B座605A', 'recruitment/eb9c0d50-e266-4b70-9ced-f4c76890a767.jpg', '一般项目：软件开发；光缆销售；配电开关控制设备销售；光通信设备销售；电线、电缆经营；安防设备销售；智能输配电及控制设备销售；软件销售；电力设施器材销售；电工器材销售；海上风电相关装备销售；销售代理；电气设备销售；电力电子元器件销售；电工仪器仪表销售；塑料制品销售；智能仪器仪表销售；', 1, 0);
INSERT INTO `t_company` VALUES (5, 6, '四川竹子汽车销售有限公司', '竹子买车', '四川省成都市金牛区聚霞路1号成都国际商贸城四区四楼', 'recruitment/9c863099-bf6d-4e8f-887d-84b866119309.png', 'ZCAR竹子买车是一家专注汽车新零售的公司，一直践行着【缩短人与汽车的距离】的使命。ZCAR竹子买车成立于2014年，集团现有销售团队人员2000+，常规在库车辆5000+，成都办公面积超6万平，杭州、长沙办公面积超3万平。作为汽车新零售平台，ZCAR竹子买车致力于构建线上、线下相融合的引流消费矩阵，全渠道布局、全时段触达不同层次消费客群，通过高频线上曝光向线下引流达成交易。创新运营方式，培养直播团队、布局直播平台，赋能汽车销售。现已组建直播团队超100人，直播矩阵曝光量合计超15亿次，直播粉丝超600万，月曝光7000万次，并于2023年12月实现单月交付突破2769台。', 1, 0);
INSERT INTO `t_company` VALUES (6, 7, '成都文彦教育咨询有限公司', '文彦教育', '成都武侯区文彦考研b座601', 'recruitment/259ae203-ab4e-45c7-b09e-122ec369ad8f.jpg', '文彦考研本着“以终为始、对等略高、适度超前”的教育服务理念，以学员需求为目标、系统研发为核心，形成了集研发、培训、评估于一体的教研体系。10年来，文彦考研致力于全国985.211重点高校研究生入学考试、教师培训、复试面试及测评等项目的教学研究。 为文彦教育集团三大事业部、6家分校、10余个教学点提供了优秀的师资、科学的课程体系及优质的配套教材等一系列支持，成为文彦教育集团发展的坚实基础和智力核心部门。团队核心成员均硕士以上，80%公司成员为硕士以上，60%为985，211毕业生，18年开始转型互联网+，每年均以100%以上速度在增长.\n', 1, 0);
INSERT INTO `t_company` VALUES (7, 8, '四川珈澜商务信息咨询有限公司', '珈澜商务', '成都金牛区成都金牛万达广场甲级写字楼B座1409', 'recruitment/319faa0e-377e-4afa-8cce-6e310ae4c7bc.jpg', '珈澜咨询主要从事信息咨询服务，社会经济咨询服务以及企业管理咨询；市场营销策划；商务信息咨询；财务咨询；企业管理咨询；市场调查等。主要服务于各大企业提供一站式代办服务工作。珈澜在遵守国家法律法规前提下，以诚信经营，客户至上为宗旨，以“缔造行业一流品牌 布局全国市场”的开放性发展格局，坚持口碑就是生命，同时还建立了完善专业、优质、高效的服务体系，我们相信，通过我们的不断努力和追求，一定能够实现与客户携手共进，合作共赢！', 0, 0);
INSERT INTO `t_company` VALUES (8, 9, '成都环宇知了科技有限公司', '之了', '成都郫都区电子科技大学西区科技园1栋7楼', 'recruitment/ce933db1-187a-471a-b0be-42d35de5d13b.webp', '之了集团是一家综合创新型教育服务企业，2019年已经通过“高新技术企业”认定。旗下有之了课堂、之了学历、之了专升本等知名品牌，业务涵盖会计、学历、专升本等考试和培训。\n集团自2016年成立以来，凭借先进的办学理念、雄厚的师资力量、专业的交互式学习方法、先进的人工智能技术和灵活多样的教学模式，每年为社会培养几十万名专业人才。经过近十年的探索与发展，在全国范围内取得了优秀业绩和良好口碑。集团目前拥有优秀教师和员工2000余人，为全国1000余万用户提供考试培训、继续教育、实务操作与职业提升、行业咨询等全方位的教育服务，受到广大用户的高度认可。', 0, 0);
INSERT INTO `t_company` VALUES (9, 10, '四川巨马互娱文化传媒有限公司', '巨马文化', '成都金牛区巨马互娱文化集团迅驰中心13楼', 'recruitment/78fd83c4-b99e-4ce9-b0dc-4bcd69e99812.webp', '巨马文化传媒有限公司，成立于2018年1月，公司注册资本500万。总部坐落于四川省成都市，目前在安徽合肥、安庆、蚌埠、淮南、浙江杭州、湖北黄冈、四川成都等地区设有区域分部，公司总占地面积12000多平方，拥有直播间300余间，设备优良齐全。\n巨马文化是集艺人孵化、直播演艺的数字娱乐公司，同时公司从才艺培训、艺人包装、直播内容打造及数字娱乐等方向，帮助旗下艺人实现直播演艺表演，提升自我价值，创造自我财富。\n2022年公司战略目标为20000万，我们在2022年年底实现公司稳定开播主播突破10000余人，月营业额突破1500万元，直营加盟公司达到30余家。巨马文化,成就梦想,让我们与巨马一起走向辉煌!', 0, 0);
INSERT INTO `t_company` VALUES (10, 11, '腾讯科技（上海）有限公司', '腾讯', '上海市徐汇区虹梅路1801号C区五层', 'recruitment/fee42f55-4564-4f20-a8e4-79dda94e02b3.jpg', '腾讯以技术丰富互联网用户的生活。\n通过通信及社交平台微信和 QQ 促进用户联系，并助其连接数字内容和生活服务，尽在弹指间。\n通过高效广告平台，协助品牌和市场营销者触达数以亿计的中国消费者。\n通过金融科技及企业服务，促进合作伙伴业务发展，助力实现数字化升级。\n我们大力投资于人才队伍和推动科技创新，积极参与互联网行业协同发展。\n腾讯于 1998 年11月在中国深圳成立，2004 年6月在香港联合交易所主板上市。', 1, 0);
INSERT INTO `t_company` VALUES (11, 12, '华为技术有限公司', '华为', '南京雨花台区华为南京研究所软件大道101号', 'recruitment/fbc9c21c-ee3e-4682-b7ef-7ac835226828.jpg', '华为创立于1987年，是全球领先的ICT（信息与通信）基础设施和智能终端提供商，我们致力于把数字世界带入每个人、每个家庭、每个组织，构建万物互联的智能世界：让无处不在的联接，成为人人平等的权利；为世界提供最强算力，让云无处不在，让智能无所不及；所有的行业和组织，因强大的数字平台而变得敏捷、高效、生机勃勃；通过AI重新定义体验，让消费者在家居、办公、出行等全场景获得极致的个性化体验。目前华为约有19.4万员工，业务遍及170多个国家和地区，服务30多亿人口。', 1, 0);
INSERT INTO `t_company` VALUES (12, 13, '北京达佳互联信息技术有限公司', '快手', '北京市海淀区西二旗西路16号院12号楼8层101', 'recruitment/2fb15bb5-427e-4ed4-9f72-316b7c65e599.jpg', '快手是领先的内容社区和社交平台，是短视频行业开创者与引领者。快手致力于创造一个温暖和信任的社区，让更多普通人拥有表达和被看见的机会，并由此培育了繁荣与高互动的社区生态，每天有上千万优质内容上传。', 0, 0);

-- ----------------------------
-- Table structure for t_education
-- ----------------------------
DROP TABLE IF EXISTS `t_education`;
CREATE TABLE `t_education`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `school_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `major` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '专业',
  `level` int NULL DEFAULT NULL COMMENT '学历,1小学2初中3高中4大专5本科6硕士7博士',
  `start_time` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `end_time` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '描述',
  `is_deleted` int NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `level`(`level`) USING BTREE,
  CONSTRAINT `t_education_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_education
-- ----------------------------
INSERT INTO `t_education` VALUES (2, 3, '四川大学', '计算机科学与技术', 5, '2016-09', '2020-06', '在校担任班长，协助辅导员管理班级;在校期间担任两年学生会主席，组织大大小小活动，近100场，最大参与人数1万人', 0);
INSERT INTO `t_education` VALUES (4, 3, '北京大学', '计算机科学与技术', 6, '2020-09', '2023-06', '协助导师完成各项试验，在校期间发布4篇期刊，连续三年获取奖学金', 0);
INSERT INTO `t_education` VALUES (5, 4, '四川大学', '软件工程', 5, '2019-09', '2023-06', '主修课程：计算机导论、程序设计基础、软件工程导论、软件设计与体系结构等', 0);

-- ----------------------------
-- Table structure for t_info
-- ----------------------------
DROP TABLE IF EXISTS `t_info`;
CREATE TABLE `t_info`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `post_id` int NULL DEFAULT NULL COMMENT '意向岗位',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '意向城市',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '现居住地',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `gender` int NULL DEFAULT NULL COMMENT '1男0女',
  `skill` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '专业技能',
  `summary` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '个人总结',
  `is_deleted` int NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `post_id`(`post_id`) USING BTREE,
  CONSTRAINT `t_info_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_info_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `t_post` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '基本信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_info
-- ----------------------------
INSERT INTO `t_info` VALUES (6, 3, 16, '张三', '四川省成都市', '四川省成都市锦江区', 35, '18716905234', 'c.yknnc@xkffkyfef.cq', 1, 'Java 基础扎实，有良好的编码习惯、了解HTML、CSS、JavaScript、Vue、Axios等前端开发技术;\n熟悉Java Web技术体系，熟练使用Servlet/Jsp;\n熟练使用Spring、SpringMVC、Spring Boot、Spring Security、Mybatis /MybatisPlus等主流开发框架;\n熟悉非关系型数据库Redis，了解数据类型、持久化机制;\n熟悉IDEA、Git、Maven等工具、熟悉Linux基本命令', '热衷于创新和技术探索，持续优化工作流程，提高效率。具备良好的问题解决能力，面对挑战时冷静分析，寻找最佳策略。注重细节同时不失大局观，全力以赴达成目标。', 0);
INSERT INTO `t_info` VALUES (7, 4, 17, '李四', '成都', '成都', 23, '18608283241', '456123255@qq.com', 1, '精通CSS、JavaScript、Ajax、DOM、HTML5等前端技术，熟悉nuxt.js、git、nuxt.js，掌握面向对象编程思想；\n能熟练使用Vue、React、uniapp等开发项目，能熟练使用ES6语法进行项目开发；\n善于与他人沟通、合作，具有团队精神，良好的自学能力。', '热衷于创新和技术探索，持续优化工作流程，提高效率。具备良好的问题解决能力，面对挑战时冷静分析，寻找最佳策略。注重细节同时不失大局观，全力以赴达成目标', 0);

-- ----------------------------
-- Table structure for t_interview
-- ----------------------------
DROP TABLE IF EXISTS `t_interview`;
CREATE TABLE `t_interview`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `rd_id` int NULL DEFAULT NULL,
  `user_id` int NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL COMMENT '面试时间',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '面试地点',
  `interview_remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '面试备注',
  `status` int NULL DEFAULT 0 COMMENT '面试状态 0待面试1通过2未通过',
  `result_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '面试结果备注',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `is_deleted` int NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `t_interview_ibfk_2`(`rd_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `t_interview_ibfk_2` FOREIGN KEY (`rd_id`) REFERENCES `t_resume_delivery` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_interview_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_interview
-- ----------------------------
INSERT INTO `t_interview` VALUES (5, 9, 3, '2024-11-04 10:00:00', '浙江省杭州市西湖区文一西路788号杭州蒋村商务中心B1座F', '请提前十五分钟到场，不用携带简历', 2, '很遗憾，您没有通过面试，祝你找到满意的工作。', '2024-11-02 19:17:35', 0);
INSERT INTO `t_interview` VALUES (6, 7, 4, '2024-11-04 10:30:00', '浙江省杭州市西湖区文一西路788号杭州蒋村商务中心B1座F', '请提前十五分钟到场，不用携带简历', 0, NULL, '2024-11-02 19:18:26', 0);
INSERT INTO `t_interview` VALUES (7, 8, 3, '2024-11-04 10:00:00', '成都武侯区布鲁明顿广场B座605A', '请提前十五分钟到场，不需要携带简历', 1, '恭喜你通过面试，请注意查看邮箱，offer将会以邮箱的形式发送给你。', '2024-11-03 15:14:34', 0);
INSERT INTO `t_interview` VALUES (8, 10, 3, '2024-11-07 10:00:00', '南京雨花台区华为南京研究所软件大道101号', '请提前十五分钟到场，不需要携带简历', 0, NULL, '2024-11-03 15:22:30', 0);

-- ----------------------------
-- Table structure for t_job
-- ----------------------------
DROP TABLE IF EXISTS `t_job`;
CREATE TABLE `t_job`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `company_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '公司名称',
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '职位',
  `start_time` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `end_time` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '工作内容',
  `is_deleted` int NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `company_name`(`company_name`) USING BTREE,
  INDEX `position`(`position`) USING BTREE,
  CONSTRAINT `t_job_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_job
-- ----------------------------
INSERT INTO `t_job` VALUES (1, 3, '北京抖音信息服务有限公司', 'java后端开发', '2020-06', '2022-06', '抖音开发团队核心人员，开发抖音app商城模块内容，并参与日常维护', 0);
INSERT INTO `t_job` VALUES (3, 3, '北京小米科技有限公司', 'Java后端开发', '2023-06', '2024-07', '小米汽车APP的后端接口开发，用户量达到数万人，主要负责高并发场景', 1);
INSERT INTO `t_job` VALUES (4, 4, '四川提克信息技术有限公司', '前端开发实习', '2022-06', '2023-06', '主要负负责一款即时通讯软件的开发', 0);

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `sender_id` int NULL DEFAULT NULL,
  `receiver_id` int NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `is_read` int NULL DEFAULT 0 COMMENT '是否已读，0未读，1已读，默认值0',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `create_time`(`create_time`) USING BTREE,
  INDEX `sender_id`(`sender_id`) USING BTREE,
  INDEX `receiver_id`(`receiver_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 95 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_message
-- ----------------------------
INSERT INTO `t_message` VALUES (1, 2, 3, '你好', '2025-03-24 19:30:44', 1);
INSERT INTO `t_message` VALUES (2, 3, 2, '该职位还招人吗', '2025-03-24 19:31:28', 1);
INSERT INTO `t_message` VALUES (3, 2, 3, '目前还在招哦', '2025-03-24 19:32:14', 0);
INSERT INTO `t_message` VALUES (4, 3, 11, '你好，我对该职位很感兴趣，已投递简历，希望你认真看看我的简历', '2025-03-14 20:33:25', 0);
INSERT INTO `t_message` VALUES (5, 11, 3, '不好意思，认真看了你的简历，不合适该岗位，祝你早日找到满意的工作', '2025-03-15 09:34:49', 1);
INSERT INTO `t_message` VALUES (6, 3, 11, '理解', '2025-03-15 10:35:13', 0);
INSERT INTO `t_message` VALUES (51, 3, 2, '好的，麻烦你看看我的简历，谢谢\n', '2025-03-26 14:38:49', 1);
INSERT INTO `t_message` VALUES (52, 2, 3, '好的，会仔细看的', '2025-03-26 14:39:14', 1);
INSERT INTO `t_message` VALUES (89, 3, 12, '您好，看到您发布的【算法工程师】职位信息，我很感兴趣，希望可以进一步沟通', '2025-03-27 18:54:41', 0);
INSERT INTO `t_message` VALUES (93, 4, 2, '您好，看到您发布的【Java】职位信息，我很感兴趣，希望可以进一步沟通', '2025-03-27 19:31:53', 0);
INSERT INTO `t_message` VALUES (94, 4, 12, '您好，看到您发布的【java开发工程师】职位信息，我很感兴趣，希望可以进一步沟通', '2025-03-27 19:32:13', 0);

-- ----------------------------
-- Table structure for t_position
-- ----------------------------
DROP TABLE IF EXISTS `t_position`;
CREATE TABLE `t_position`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `company_id` int NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '职位名称',
  `type` int NULL DEFAULT NULL COMMENT '职位类型',
  `number` int NULL DEFAULT NULL COMMENT '招聘人数',
  `mini_salary` int NULL DEFAULT NULL,
  `max_salary` int NULL DEFAULT NULL,
  `job_place` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '工作地点',
  `education` int NULL DEFAULT NULL COMMENT '学历要求',
  `job_require` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '任职要求',
  `status` int NULL DEFAULT 0 COMMENT '0未审核1通过2未通过3已下架',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `is_deleted` int NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `company_id`(`company_id`) USING BTREE,
  INDEX `type`(`type`) USING BTREE,
  INDEX `education`(`education`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  CONSTRAINT `t_position_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `t_company` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 81 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_position
-- ----------------------------
INSERT INTO `t_position` VALUES (1, 1, 'java开发工程师', 16, 6, 30000, 60000, '北京', 5, '该岗位仅限2025年应届生，具备一定独立开发经验(学校的项目也可以)，了解vue优先，至少实习5个月，每周5天', 1, '2024-07-09 15:38:00', 0);
INSERT INTO `t_position` VALUES (2, 1, 'Web 前端开发工程师', 17, 2, 6000, 8000, '北京', 6, '1.3年以上前端开发工作经验，具备扎实的JS编程基础；\n2. 能够独立完成前端设计、开发及调试，能够充分理解设计需求并实现功能；\n3. 熟悉W3C规范，Typescript、ES5/ES6、等；\n4. 精通React、Umi，深入理解其设计原理；\n5. 熟悉AntD等UI框架，具备对业务进行宏观思考有抽象成UI组件的能力；\n6. 熟悉模块化、前端编译和构建工具，掌握常用编译工具，如 webpack/rollup 等；\n7. 熟悉跨浏览器兼容性处理，熟悉前端性能的优化，熟悉响应式设计；\n8. 能够独立设计用户体验良好的前端界面者优先；', 1, '2024-07-19 22:20:55', 0);
INSERT INTO `t_position` VALUES (3, 1, 'Web前端实开发', 17, 1, 20000, 40000, '北京', 5, '1.扎实的html（html5）、css（css3）、JavaScript（es6+）技术；\n2.丰富的vue/vue3开发经验，包括对vue-router、vuex、pinia的使用，负责过复杂应用的前端开发项目；\n3.掌握至少一种前端构建工具（webpack/vite），并熟练使用对应的插件协助开发；\n4.熟悉ant-design-vue、vant等UI组件库；\n5.熟悉一种css预处理器（less/sass）；\n6.熟悉axios的使用；\n7.能解决跨浏览器兼容性问题、对项目性能进行优化；\n8.熟悉uni-app开发,有项目打包经验(优先)', 1, '2024-08-21 08:08:24', 0);
INSERT INTO `t_position` VALUES (4, 4, '中级java开发工程师', 16, 3, 5000, 7000, '成都', 4, '1.掌握java开发框架 \n2.有java开发项目经验\n3.对springboot和spring cloud非常熟悉\n4.能接受适当出差', 1, '2024-10-08 19:39:20', 0);
INSERT INTO `t_position` VALUES (5, 5, '汽车销售', 81, 3, 15000, 30000, '湘潭', 0, '1、性格开朗，具备良好的沟通表达能力；\n2、有责任心，热爱销售；', 0, '2024-11-02 14:26:29', 0);
INSERT INTO `t_position` VALUES (6, 6, '新媒体运营', 36, 4, 6000, 11000, '成都', 5, '1、国内全日制本科或硕士学历，有新媒体推广经验优先考虑。\n2、认真负责，善于沟通，学习能力强。\n3、团队协作，有责任心。', 0, '2024-11-02 14:32:43', 0);
INSERT INTO `t_position` VALUES (7, 6, '考研新媒体运营', 36, 2, 7000, 11000, '成都', 5, '1、国内全日制本科或硕士学历，有新媒体推广经验优先考虑。\n2、认真负责，善于沟通，学习能力强。\n3、团队协作，有责任心。', 0, '2024-11-02 14:33:39', 0);
INSERT INTO `t_position` VALUES (8, 6, '新媒体运营实习生', 36, 1, 2000, 3000, '成都', 5, '1、本科及以上学历，有考研推文或者新媒体推广经验优先考虑。\n2、认真负责，善于沟通。', 0, '2024-11-02 14:34:30', 0);
INSERT INTO `t_position` VALUES (9, 6, '新媒体运营（周末双休+五险一金） 6-11K', 36, 1, 6000, 10000, '成都', 5, '1、国内院校本科学历，有1年以上新媒体运营工作经验可放宽学历至本科。\n2、熟悉各平台使用规则。\n3、良好的自我驱动力，有责任心，有团队协作精神。', 0, '2024-11-02 14:35:40', 0);
INSERT INTO `t_position` VALUES (10, 7, '纯客服底薪4000', 31, 2, 4000, 9000, '成都', 0, '1、年龄不限，男女不限\n2、工作态度端正，善于学习', 0, '2024-11-02 14:39:00', 0);
INSERT INTO `t_position` VALUES (11, 7, '客服专员', 31, 2, 10000, 15000, '成都', 0, '不含销售的客服工作	线上客服	正常工作制\n办公室坐班	企业内部客服	不接受居家办公	\n重点!!!我们公司不是电销，不电销，无考核，无任务，无着装要求福利待遇\n1、底薪4000+10%-40%提成+季度奖+年底双薪 +国\n外旅游+节假日补助，综合平均工资8K-13K\n2、每三个月提供一次晋升机会，每个人都有机会成为主管、经理，甚至老板!\n3、我们有免费的带薪培训，有老员工一对一指导工\n作岗位职责\n公司提供意向客户，不用自己找，主要负责在公司平台上有客户会主动提交个人的资料，通过平台检查客户的资料是否符合办理，符合的客户在交由谈单部门对接', 0, '2024-11-02 14:40:39', 0);
INSERT INTO `t_position` VALUES (12, 8, '专升本全职讲师', 168, 2, 8000, 13000, '太原', 5, '1.热爱教师职业，对工作充满热情，责任心强、抗压能力强。\n2.语言表达流畅，具备较强的学习能力和创新能力。\n3.能够接受出差授课任务，能够接受晚上排直播课。\n4.本科及以上学历，有相关学科成人教学经验优先，具有相应教师资格证的优先考虑。', 0, '2024-11-02 15:05:29', 0);
INSERT INTO `t_position` VALUES (13, 8, '专升本讲师', 168, 2, 10000, 15000, '成都', 5, '1.有专升本教学经验者优先；\n2.语言表达流程，逻辑清晰，讲课有条理，具备较强的学习能力；\n3.热爱教育培训行业，良好的道德修养；\n4.能接受不超过3个月的短期出差。', 0, '2024-11-02 15:06:31', 0);
INSERT INTO `t_position` VALUES (14, 8, '会计私教老师-13薪', 166, 1, 5000, 10000, '成都', 5, '1、近1年内备考过CPA/中级，有科目通过优先（有证书补贴）；\n2、本科及以上学历，会计相关专业优先考虑；\n3、学习能力较强，有持续学习的心态和意愿；\n4、抗压能力强，有责任心，有担当，有良好的团队合作意识，执行力强。', 0, '2024-11-02 15:07:26', 0);
INSERT INTO `t_position` VALUES (15, 8, '新媒体运营（小红书/公众号/短视频）', 36, 2, 5000, 8000, '成都', 5, '1、本科及以上学历，1年以上相关工作经验；\n2、有新媒体运营经验者优先，具备项目运营能力者优先;\n3、有优秀的理解、协调及沟通能力，责任心强，有吃苦耐劳、踏实肯干的精神，自学能力强;', 0, '2024-11-02 15:08:30', 0);
INSERT INTO `t_position` VALUES (16, 8, '销售运营经理/主管', 76, 1, 10000, 13000, '成都', 5, '1、本科及以上学历，3年及以上销售/运营工作经验，具有大型互联网、电商公司背景更佳；\n2、对互联网流量业务逻辑有深入见解，具有敏锐的洞察力和数据敏感度，能诊断/发现业务痛点并输出系统解决方案；\n3、具备销售运营大型项目经验，具有优秀的数据分析能力和项目组织能力优先考虑；\n4、具备良好的沟通能力、逻辑思维和问题处理能力，目标感，自驱力，执行力和抗压能力强；\n5、互联网教育从业经验优先。', 0, '2024-11-02 15:09:23', 0);
INSERT INTO `t_position` VALUES (17, 8, '内容运营/公众号运营主管', 170, 1, 8000, 10000, '成都', 5, '1.本科及以上学历，新闻学、传播学、广告学、中文、市场营销等相关专业优先；\n2.2年以上文案及策划工作经验；\n3.有在线教育行业经验优先；\n4.能够准确捕捉行业热点，挖掘产品亮点，把握品牌营销重点；\n5.具有发散性创意思维，文字功底扎实，逻辑思维能力强。', 0, '2024-11-02 15:18:29', 0);
INSERT INTO `t_position` VALUES (18, 9, '主播', 198, 1, 7000, 12000, '成都', 0, '1、良好的镜头感\n2、服从公司管理，听从安排，有恒心，有上进心，有团队意识', 0, '2024-11-02 15:30:10', 0);
INSERT INTO `t_position` VALUES (19, 9, '行政前台/无责4k-7k/不打电话/不加班', 97, 1, 5000, 8000, '成都', 3, '1、接受无经验，接受应届生 ！！！\n2、工作热情积极，细致耐心，具有一定协调能力\n3、性格开朗，相貌端正 ，形象气质佳，待人热情\n4、身高156以上', 0, '2024-11-02 15:31:25', 0);
INSERT INTO `t_position` VALUES (20, 10, '前端开发工程师(深圳)', 17, 1, 20000, 40000, '深圳', 5, '1、大学本科及以上学历，精通Javascript，精通React、Vue、小程序等至少一种前端框架，并对其原理有过深入理解；\n2、熟悉前端工程的构建、打包、部署，能熟练运用各类前端工具，构建高性能网站；\n3、熟悉前端性能优化，熟悉web领域内常见的安全问题及防控方式；具备移动端开发能力，能解决移动端兼容性问题及性能问题，熟悉主流移动浏览器的技术特点；追求极致的用户体验，有效的通过监控、上报改善用户体验；\n4、关注业界发展，对最新的前端技术有浓厚的兴趣及独特的见解，关注前端前沿技术研究，通过新技术服务团队和业务，有AI大模型相关前端功能建设经验者优先。\n5、优秀的团队合作能力，拥有良好的主动性与推动力，优秀的分析问题和解决问题的。', 1, '2024-11-02 15:39:55', 0);
INSERT INTO `t_position` VALUES (21, 10, '微信视频号直播推荐算法', 241, 1, 50000, 80000, '广州', 6, '1.深入掌握常用机器学习、深度学习算法及原理，具备两年以上的推荐系统、广告系统或搜索引擎的算法研发经验； 2.具备优秀的编码能力，扎实的数据结构和算法功底； 3.优秀的分析问题和解决问题的能力，对解决挑战性问题充满热情； 4.有较好的沟通能力、团队协作能力，积极主动（工作地广州/深圳均可）。', 1, '2024-11-02 15:55:08', 0);
INSERT INTO `t_position` VALUES (22, 10, 'C＋＋', 50, 1, 26000, 50000, '深圳', 5, '后端服务开发，技术中台系统架构建设，技术规范设计等', 1, '2024-11-02 15:56:01', 0);
INSERT INTO `t_position` VALUES (23, 10, '导航AI算法工程师-深度AI模型', 248, 1, 35000, 65000, '北京', 6, '1.计算机相关专业，硕士及以上学历；\n2.至少3年以上相关工作经验，有地图AI算法等领域经验者优先；\n3.深刻理解深度学习，有独立分析问题、定位问题、解决问题的能力；\n4.对技术有激情，具备优秀的学习能力，良好的沟通与团队协作能力。', 1, '2024-11-02 15:57:37', 0);
INSERT INTO `t_position` VALUES (24, 10, '高级法律顾问（支付业务', 102, 1, 40000, 50000, '深圳', 5, '1.法学本科及以上学历，通过国家司法考试；\n2.10年以上法律工作经验，其中3年以上数据合规、网络安全相关工作经验，且具有大型律所、支付机构、清算机构或互联网公司工作经验者优先；\n3.项目管理能力和执行力强，善于处理复杂问题并提出建设性方案；\n4.具备出色的沟通能力、较好的学习能力、适应能力以及团队协作精神；\n5.乐观开朗、踏实尽责、抗压能力强。', 1, '2024-11-02 15:58:52', 0);
INSERT INTO `t_position` VALUES (25, 10, '推荐算法', 241, 1, 30000, 60000, '北京', 5, '1、对机器学习算法有深刻的理解，具备良好的问题建模和算法优化能力，有良好的工程素养，能够快速进行算法实现和迭代；\n2、有推荐系统、广告系统、搜索系统业务经验者优先；有短视频推荐业务经验者优先；\n3、有较好的沟通能力、团队协作能力，积极主动，愿意接受挑战；\n4、计算机、数学相关专业本科及以上学历，两年以上工作经验。\n\n', 1, '2024-11-02 15:59:57', 0);
INSERT INTO `t_position` VALUES (26, 10, '搜索引擎开发工程师', 242, 1, 35000, 65000, '北京', 5, '1.很强的 C++、Python 开发能力，且对索引底层开发和性能优化有强烈兴趣，有推荐、搜索、广告后台开发引擎开发和运营经验优先；\n2.对倒排&向量召回有清晰的认识，对向量召回、HNSW、IVF 等有深入开发经验优先；\n3.很强的后台服务架构设计能力，能够独立完成对后台服务的性能分析和改进方案落地；\n4.具有独立项目主导能力，能够熟练跨团队沟通并推进项目落地。', 1, '2024-11-02 16:00:51', 0);
INSERT INTO `t_position` VALUES (27, 10, '微信Android 客户端开发工程师(广州)', 18, 1, 20000, 40000, '广州', 5, '1.有一定的客户端开发经验，熟悉 Objective-C / Swift 或 Java / Kotlin ，熟悉 iOS 或 Android 开发，对具体平台有深入了解。iOS 和 Android都有经验者优先；\n2.有良好的沟通能力及学习能力，能够快速响应变化；\n3.有主动发现及解决问题的能力，能够及时总结开发问题并给出解决方案；\n4.有移动端跨平台、 Flutter 、 C++ 开发经验者优先；\n5.有音视频相关开发经验者优先。', 1, '2024-11-02 16:01:46', 0);
INSERT INTO `t_position` VALUES (28, 10, '测试工程师（犀牛鸟编制）', 219, 1, 15000, 20000, '深圳', 5, '1. 2年以上相关工作经验，全日制本科以上学历，计算机或相关专业； \n2. 思维逻辑清晰，工作严谨细致，具备良好的沟通及理解能力； \n3. 责任心和执行力强，具有创业者精神，能吃苦耐劳,能承担较高压力工作； \n4. 熟悉小程序及H5多端系统框架； \n5. 具备丰富的产品质量经验，可以独立完成大型项目整体质量体系规划和质量方案设计，以及功能、安全、接口、性能、兼容性测试等专项测试实施者优先； \n6. 具备自动化测试经验，有相关自动化测试框架使用经历者优先； ', 1, '2024-11-02 16:02:50', 0);
INSERT INTO `t_position` VALUES (29, 10, '高级GO开发工程师', 56, 1, 15000, 30000, '深圳', 5, '1. 三年以上研发经验，熟悉 shell 与 linux、能独立完成后台系统的开发、部署、维护；\n2. 熟练掌握go开发语言，有良好的的工程研发习惯并有对应的项目落地经验；\n3. 了解数据库原理，熟练掌握一种以上数据库，如 Mysql、Redis、MongoDB 等；\n4. 了解 Docker、Elasticsearch、K8S、gRPC、有相关开发或运维管理经验者优先；\n5. 具备良好的分析解决问题能力，能独立承担任务和有系统进度把控能力，责任心强，良好的对外沟通和团队协作能力；', 1, '2024-11-02 16:03:37', 0);
INSERT INTO `t_position` VALUES (30, 10, '大模型数据，专家工程师', 239, 1, 40000, 55000, '北京', 6, ' 1.熟悉至少一种编程语言，如 Go, Python, Java等；\n 2.良好的沟通协调能力，具备团队合作精神，能够独立思考、快速学习和解决问题；\n 3.对大模型技术、数据中台有深入了解加分；\n 4.有大模型训练或数据相关工作经验最优。', 1, '2024-11-02 16:04:28', 0);
INSERT INTO `t_position` VALUES (31, 10, '腾讯云安全产品测试开发工程师', 223, 1, 11000, 20000, '武汉', 5, '1、本科以上学历，2年以上测试工作经验，熟悉软件测试基础知识、良好的测试用例设计&需求分析能力等，具备客户化思维，具备大型系统和产品测试经验者优先；\n2、责任感强，具备良好的沟通能力和抗压能力，能够在工作中积极推动并解决问题；\n3，熟悉linux操作系统，熟悉Shell/Python/Go/Java语言中的至少一种编程语言，具备自动化脚本开发经验\n4，学习能力强，理解微服务框架/消息队列/Docker/Kubernetes等技术或相关云计算产品经验，有云计算行业相关业务背景优先\n5、有大型项目研发效能建设相关经验者优先', 1, '2024-11-02 16:05:15', 0);
INSERT INTO `t_position` VALUES (32, 10, '腾讯云渠道销售（北京）', 72, 1, 30000, 60000, '北京', 5, '1.本科及以上学历，计算机、电信、市场营销或其它相关专业；\n2.软件或互联网行业五年以上相关工作经验；\n3.具有丰富的渠道销售、区域管理及长尾中小企业客户覆盖经验；\n4.具有企业级应用软件销售经验，具有云计算及互联网行业渠道销售经验优先；\n5.能够有效通过渠道覆盖中长尾客户，承担区域销售业绩；\n6.能够建立区域渠道体系，有效处理渠道冲突与风险防范；\n7.能够主导制定各种服务与激励方式，持续提高渠道合作伙伴的满意度；\n8.具有出色的协调能力，良好的团队合作精神；为人诚信，工作敬业，有责任心；\n9.通过腾讯云技术认证或同等资格认证的优先录取。 通过腾讯云从业资格证或同等资格认证的优先录取；\n10.有公有云渠道管理和体系建设，有本地客户和伙伴资源优先录取。', 1, '2024-11-02 16:06:05', 0);
INSERT INTO `t_position` VALUES (33, 10, '后台高级开发工程师', 264, 1, 20000, 35000, '深圳', 5, '1.本科以上学历，计算机软件或相关专业，1年以上后台研发经验;\n2.熟悉Linux开发环境，精通C/C++、Golang、java其中一种语言，熟悉后台服务架构设计与性能优化;\n3.具备丰富的分布式系统、微服务架构、数据库技术、缓存技术、消息队列等技术经验;\n4.对技术有追求，喜欢钻研技术，对新技术有敏锐的洞察力和好奇心;\n5.具备良好的沟通、协作和解决问题的能力，有责任心，能够适应快节奏的工作环境;\n6.能熟练使用chatpgt，github copilot等AI工具来提升工作效率者优先;\n7.海量后台服务相关经验者，算法工程研发经验者优先。', 3, '2024-11-02 16:08:32', 0);
INSERT INTO `t_position` VALUES (34, 10, '腾讯云中间件高级运维工程师', 230, 1, 25000, 50000, '深圳', 5, '1、计算机或相关专业本科或以上学历，3年以上开发或技术支持相关经验\n2、熟悉微服务（Spring Boot / Service Mesh等），熟悉各种消息中间件（ActiveMQ/RocketMQ/Kafka等），熟悉开源服务框架（Meth/Dubbo/SpringCloud等）、熟悉容器技术(k8s/ servlerless)、低代码优先考虑；                                               \n3、掌握各MQ产品核心架构及原理，掌握MQ相关控制器、分布式协调器、消息限流等核心组件原理及消息动态平衡、消息队列与治理技术\n4、掌握C/C++/Golang/Java/Nodejs中的一种，掌握相关中间件云产品技术原理与功能调测，具备各产品使用常见问题的排查定位和解决能力；\n5、有良好的沟通能力，较强的抗压能力以及独立完成工作能力，做事认真、负责，可以响应处理应急事件；\n6、有公有云技术支持经验优先。', 0, '2024-11-02 16:09:20', 0);
INSERT INTO `t_position` VALUES (35, 1, 'sre运维工程师', 230, 1, 25000, 30000, '成都', 5, '(1）统招全日制大学本科及以上学历，计算机或者相关专业。\n（2）五年以上sre经验或信息行业工作经验。\n（3）熟悉云平台及应用理论和关键技术。\n（4）熟悉阿里云平台某一方面产品架构，对产品有较深入的理解。包括IaaS、PaaS、DaaS、分布式数据库、云安全等类型产品。\n（5）具备云平台产品自身及关联链路相关产品的疑难问题，具备产品维护和调优能力。\n（6）熟悉云平台部署架构及网络拓扑情况。\n（7）具备快速定位、处理云平台及其应用问题能力。\n（8）有较较强的逻辑分析和问题排查能力以及对新技术的追求精神，敢于承担压力。', 1, '2024-11-02 16:17:18', 0);
INSERT INTO `t_position` VALUES (36, 1, '后端开发工程师', 16, 1, 25000, 45000, '杭州', 5, '1. 扎实的编程基础，精通java开发语言，熟练掌握jvm，web开发、缓存，分布式架构、消息中间件等核心技术，拥有分布式、大数据量的系统开发经验者优先考虑；\n2. 技术思路清晰，结构化思维清晰，善于解决复杂问题；\n3. 良好的组件级建模能力，熟悉NoSQL、MQ、Cache、TCP/IP原理，能够设计复杂业务、高并发、大数据量的系统 ；\n4. 良好的设计能力、沟通能力，团队协作能力及项目掌控能力 ；\n5. 愿意深入了解业务知识，并能敏锐的发现业务痛点。\n6. 有供应链系统搭建基础的优先。', 1, '2024-11-02 16:19:22', 0);
INSERT INTO `t_position` VALUES (37, 1, 'Java技术专家', 16, 1, 20000, 30000, '武汉', 5, '1. java基础扎实，理解io，多线程，集合等基础框架\n2. 对开源框架熟悉，能熟练使用spring，ibatis等\n3. 熟悉多线程及高性能的设计与编码\n4. 学习能力强，适应能力好，抗压能力强', 1, '2024-11-02 16:20:05', 0);
INSERT INTO `t_position` VALUES (38, 1, '算法工程师', 246, 1, 30000, 50000, '北京', 6, '1、计算机、电子信息工程、自动化控制、数学、信息安全等相关专业背景，硕士及以上学历；\n2、在机器学习或深度学习领域有三年以上的项目经历，具备以下一个或多个方向的研究和应用经验，如时序预测模型、树模型、图神经网络、强化学习、多模态大模型、迁移学习等，在NIPS/ICML/ICLR/CVPR/KDD/AAAI等顶会顶级会议或者期刊发表论文者优先考虑；\n3、具备扎实的Python、C++或者Java等编程基础，熟悉主流深度学习工具TensorFlow/PyTorch等；\n4、有良好的数据敏感性和逻辑推理能力，较好的学习和沟通能力，对业界新技术敏感、喜欢钻研，具备熟练的英文读写能力；\n5、加分项：Kaggle等数据科学竞赛的优胜经历、ACM编程竞赛获奖经历等。', 1, '2024-11-02 16:20:49', 0);
INSERT INTO `t_position` VALUES (39, 1, '测试开发工程师', 223, 1, 20000, 30000, '上海', 5, '1、计算机或相关专业，4年以上开发、自动化、性能相关经验；\n2、精通测试流程和质量保障体系，有解决复杂问题和编写测试工具、系统平台经验；、\n3、在某2个测试领域具备很强的专业技能，如性能，安全，自动化，测试工具开发；\n4、精通Java/Python/Ruby等一种编程语言，熟练Linux，Oracle/MySQL数据库操作；\n5、很强的自我驱动学习能力和技术钻研能力，具备优秀的沟通技巧，很好的责任心与高执行力；\n6、 善于团队合作，理解和适应变化，具备较强的学习能力；\n7、有大型、成熟互联网（电商、金融）经验优先考虑。', 1, '2024-11-02 16:21:52', 0);
INSERT INTO `t_position` VALUES (40, 1, '高级前端/前端专家', 17, 1, 24000, 40000, '成都', 5, '1、精通各种前端技术，包括HTML/CSS/JavaScript/Node.JS等；\n2、具备跨终端的前端开发能力，在Web（PC+Mobile）/Node.js/Hybrid App/Native App三个方向上至少精通一个方向，具备多个的更佳；\n3、对前端工程化与模块化开发有一定了解，并有实践经验（如Webpack/Gulp/NPM/YARN等）；\n4、至少熟悉一门非前端的语言（如Java/PHP/C/C++/Python/Ruby），并有实践经验；\n5、具备良好的团队协作精神，能利用自身技术能力提升团队整体研发效率，提高团队影响力；\n6、对前端技术有持续的热情，个性乐观开朗，逻辑性强，善于和各种背景的人合作。', 1, '2024-11-02 16:22:42', 0);
INSERT INTO `t_position` VALUES (41, 1, '淘天-搜推广高级算法工程师', 242, 1, 60000, 90000, '北京', 6, '1、具备优秀的编码能力，扎实的数据结构和算法功底; 2、熟悉大规模机器学习/深度学习算法,； 3、优秀的分析问题和解决问题的能力，对解决具有挑战性问题充满激情, 不轻易放弃； 4、对技术有热情，有自己的理解, 能够用技术推动业务进步和变革； 5、有良好的沟通表达能力, 具有团队精神, 有良好的团队协同能力； 6、在计算机学术会议（SIGIR、SIGKDD、ICML、NIPS、WWW、AAAI、CIKM、ACL、RECSYS等）或期刊上发表过论文者', 1, '2024-11-02 16:23:26', 0);
INSERT INTO `t_position` VALUES (42, 1, '阿里巴巴-淘工厂-后端开发', 16, 1, 30000, 40000, '南京', 5, '1. 3年以上JAVA开发经验，具备扎实的编程基础，精通java开发语言，理解IO、多线程、集合等基础框架，熟练掌握jvm，web开发、缓存，分布式架构、消息中间件等核心技术。\n2. 熟悉分布式系统的设计和应用，熟悉缓存、消息和存储等机制；能对分布式常用技术进行合理应用和技术方案落地；\n3. 具备大型分布式系统开发和架构经验，或复杂B端系统的领域建模和系统设计经验；\n4. 具有高度的抽象设计能力，思路清晰，善于思考，能够独立分析和解决问题，责任心强；具备良好的团队合作精神和风险预判能力。', 1, '2024-11-02 16:24:17', 0);
INSERT INTO `t_position` VALUES (43, 1, '阿里妈妈-Java研发（电商）-北京', 16, 1, 20000, 40000, '北京', 5, '1.2年以上Java研发经验，擅长业务系统架构设计，具备一定的项目协调推进能力。\n2.具有扎实的Java功底，对JVM的原理有一定的了解，具有较好的Java IO、多线程、网络等方面的编程能力；\n3.熟悉spring、MyBatis、Tomcat等常用Java开源框架，对其运行原理有较好的理解。\n4.精通数据库设计（Mysql优先），优秀的SQL编写及调优能力，熟悉常见NoSQL存储，如Hbase、memcached、redis、mongodb等；\n5.有大规模高并发互联网应用的设计和开发经验，熟悉常规的分布式架构，熟悉缓存、消息队列等开源中间件。\n6.热爱技术研发，具有快速学习能力；注重代码质量,有良好的软件工程知识和编码规范意识。\n7.具有较好的沟通能力，思路清晰，善于思考，能独立分析和解决问题。\n8.有强烈的责任心和团队合作精神，良好的抗压能力，心态积极，能主动融入团队。\n9.相关广告应用系统研发经验者优先。', 1, '2024-11-02 16:25:23', 0);
INSERT INTO `t_position` VALUES (44, 1, '高级前端工程师', 17, 1, 20000, 40000, '杭州', 5, '1. 精通HTML、CSS、Javascript，热衷浏览各类网页的源代码；\n2. 熟练掌握Java、NodeJS、Python等任意一种或多种后端语言，并有实际的项目经验；\n3. 深谙 MV* 模式，熟悉AMP、AngularJs、ReactJS、VueJS、Polymer等任意一种前端 UI 框架，一定程度了解其原理；\n4. 熟悉主流浏览器特性，乐于探究和解决各种类型的兼容性问题。', 1, '2024-11-02 16:26:38', 0);
INSERT INTO `t_position` VALUES (45, 1, 'Java', 16, 1, 15000, 30000, '杭州', 5, '1.计算机或相关专业本科以上学历，至少一年以上工作经验。\n2.计算机基础扎实，以及具备有缜密的逻辑思维能力。\n3.对分布式系统开发有深入的了解，掌握大流量系统的设计与开发，对高并发有实际项目经验。\n4.具备良好的团队协作与沟通能力，有好奇心，有强烈的自驱能力以及学习能力。\n5.具有用户增长、营销、交易、广告、推荐、搜索、大数据等系统经验的优先。', 1, '2024-11-02 16:27:18', 0);
INSERT INTO `t_position` VALUES (46, 1, 'Android', 18, 1, 25000, 40000, '上海', 5, '1. 理解 B 端业务，根据需求合理制定技术方案，完成代码编写，保证代码质量\n2. 持续对所负责项目进行性能调优、结构优化\n3. 关注业务动向并梳理重点方向，清晰划分各领域职责及边界\n4. 关注新技术及实践，并与项目有效结合\n5. 带领伙伴成长，注重分享与沟通', 1, '2024-11-02 16:27:57', 0);
INSERT INTO `t_position` VALUES (47, 1, 'web前端', 17, 1, 20000, 40000, '杭州', 5, '1. 精通各种Web前端技术（HTML/CSS/Javascript等)，熟练跨浏览器、跨终端的开发；\n2. 有大型网站前端架构、前端性能、可访问性、可维护性等方面的实践经验；\n3. 至少熟练使用一门非前端脚本语言（如：NodeJS /Python/PHP等），并有项目经验；\n4. 技术视野广阔，有主导前端技术方案设计的能力和经验；\n5. 个性乐观开朗，逻辑性强，善于和各种背景的人合作，有一定的项目管理、团队管理经验；\n6. 有开源项目的成功经验。', 1, '2024-11-02 16:28:57', 0);
INSERT INTO `t_position` VALUES (48, 1, '淘宝互动Java开发工程师25届实习生', 16, 3, 9000, 12000, '杭州', 6, '1. 酷爱着计算机以及互联网技术，热衷于解决挑战性的问题，追求极致的用户体验。\n2. 计算机基础扎实，熟悉常用的数据结构和算法，熟悉计算机操作系统、数据库和计算机网络相关理论与实践。\n3. 熟练掌握JAVA或C++语言，有过硬的编码能力，了解常见的中间件，数据库，IO、多线程编程原理和分布式基础知识。\n4. 对技术有好奇心，乐于钻研原理和尝试新技术；具有较强的抽象设计能力，思路清晰，善于思考，能独立分析和解决问题。\n5. 乐观开朗，责任心强，具备良好的团队合作精神和沟通能力。', 1, '2024-11-02 16:30:25', 0);
INSERT INTO `t_position` VALUES (49, 1, 'Android开发专家', 18, 1, 25000, 40000, '杭州', 5, '1、3年以上Android开发经验；有丰富的客户端应用架构经验，可以独立承担架构设计，并主导项目。\n2、精通 AndroidFramework层，有通过源码阅读定位问题的经验，对业界较流行的开源库的实现方案有较为深刻的理解。\n3、对跨栈技术能力有一定经验，对APP性能调优有丰富经验、对网络协议有一定掌握，对服务端有一定编程经验。\n4、有强烈的责任心、团队精神和技术热情，善于沟通和合作。', 1, '2024-11-02 17:05:46', 0);
INSERT INTO `t_position` VALUES (50, 1, 'Java开发工程师', 16, 1, 8000, 13000, '杭州', 5, '学校专业：不限，只需要你有较强的学习能力，热爱计算机及互联网，喜欢挑战性的问题\n招聘职位： 研发（java，前端，客户端、测试开发、数据研发）， 算法 （机器学习、自然语言处理 ），数据 （数据分析、数据科学），产品运营（产品经理、产品运营、用户运营、市场营销）\n实习地点：杭州，深圳，米兰', 1, '2024-11-02 17:06:33', 0);
INSERT INTO `t_position` VALUES (51, 1, 'Java', 16, 1, 30000, 50000, '杭州', 5, '1. 高级JAVA工程师要求3年以上JEE开发经验； 架构师要求5年以上JEE开发经验，1年以上架构设计经验\n2. 扎实的Java编程基础，熟悉各种设计模式\n3. 熟练掌握Spring/Struts/Ibatis或其他主流JAVA框架\n4. 熟悉MySQL/PostgreSQL数据库中的一种或多种，有数据库调优经验\n5. 熟悉整个软件过程，能够沟通需求、控制项目进度，有良好的文档能力\n6. 架构师要求有良好的组件级建模能力，熟悉NoSQL、MQ、Cache、TCP/IP原理，能够设计复杂业务、高并发、大数据量的系统', 1, '2024-11-02 17:07:30', 0);
INSERT INTO `t_position` VALUES (52, 1, '测试开发工程师', 223, 1, 20000, 28000, '杭州', 5, '聪明好学，有java项目经历，白盒测试，有开发能力', 1, '2024-11-02 17:08:21', 0);
INSERT INTO `t_position` VALUES (53, 1, 'Java', 16, 2, 10000, 15000, '杭州', 5, '1、Java基础扎实，熟悉io、多线程、分布式、缓存、消息等机制； 2、熟练使用spring boot等主流框架，熟悉云上开发技术栈，熟悉Linux下的常用命令，熟悉MySQL等主流的数据库； 3、思路清晰，善于思考，能分析和解决问题，责任心强，具备良好的团队合作精神和承受压力的能力。', 1, '2024-11-02 17:09:10', 0);
INSERT INTO `t_position` VALUES (54, 1, 'Java高级开发工程师', 16, 2, 20000, 30000, '杭州', 5, '1、要求3年以上开发经验，扎实的JAVA基础，掌握JVM、并发编程、网络编程等基础知识；熟悉单元测试、WEB开发、数据库等基础技术。\n2、 熟悉Spring、SpringMVC、iBatis或其他主流开发框架；掌握常用数据结构、常见设计模式，拥有领域模型抽象能力。\n3、 具备大型网站核心开发、设计经验者优先；熟悉分布式系统设计、消息队列、缓存等技术者优先；有跨境供应链工作背景更优。\n4、有强烈的技术热情和钻研精神，热爱新技术；有独立、主动的学习习惯和良好的沟通表达、团队协作能力。\n5、具备较强的业务理解及业务抽象能力，能够快速从业务需求中找到技术设计的场景，有较强的业务sence。', 1, '2024-11-02 17:10:00', 0);
INSERT INTO `t_position` VALUES (55, 1, 'Java架构师/研发工程师', 260, 1, 30000, 60000, '杭州', 5, '1、本科或以上学历，计算机软件或相关专业；\n2、3年以上使用Java语言进行web开发的经验，精通Web编程，熟悉Spring、SpringBoot、iBatis/mybatis等开源框架，熟悉Linux，Docker，微服务，熟悉各种常用设计模式，对不同版本JDK的维护和调优有经验者优先；\n3、有架构设计经验，熟悉领域建模；\n4、对技术有强烈的兴趣，喜欢钻研，具有良好的学习能力，沟通技能，团队合作能力，认真细心；\n5、了解前端React，Angular，Vue框架，有开发经验更佳；\n6、有【机器学习、数据挖掘、深度学习，开源产品开发维护，SAAS化经验；供应链，ERP，采购应用经验；熟悉Salesforce ，OutSystem；有大数据量、高并发系统和大型网站构建经验者优先；风控系统研发经验；熟悉区块链相关技术和行业】之一的优先考虑', 1, '2024-11-02 17:10:59', 0);
INSERT INTO `t_position` VALUES (56, 1, 'Java', 16, 2, 20000, 35000, '杭州', 5, '1、计算机相关专业本科及以上学历，三年以上Java Web应用软件开发经验； \n2、精通Servlet、Spring、Hibernate、iBatis、Velocity开发，对SOA模式有深入理解，对虚拟机及Linux下的开发环境有 较深厚的开发经验； \n3、熟练MySQL，对数据库有较强的设计能力，同时熟悉大数据相关技术； \n4、熟悉Maven项目配置管理工具，熟悉Tomcat、Jboss等应用服务器，熟悉高并发处下的性能优化； \n5、熟悉网络编程，具有设计和开发对外API接口经验和能力； \n6、具有良好的沟通，团队协作、计划和创新的能力；', 1, '2024-11-02 17:12:28', 0);
INSERT INTO `t_position` VALUES (57, 11, '智能搜索推荐广告工程师', 242, 1, 30000, 60000, '杭州', 5, '1、熟练掌握C/C++/Java/Python开发语言，有较强的编码能力与软件设计能力\n2、掌握各类常用数据结构和相关算法，熟悉多线程模型编程者优先\n3、具有文件/网络IO等系统优化经验者优先\n4、具有搜索开发经验者优先\n5、有较强的工作责任心，具有探索和创新精神.', 1, '2024-11-02 17:17:38', 0);
INSERT INTO `t_position` VALUES (58, 11, 'c语言软件开发工程师', 50, 2, 15000, 30000, '武汉', 5, '1.熟练掌握C/C++/python等主流开发语言中的一种。\n2.具体linux/MCU开发经验,并能熟练使用基本的编程编译工具。\n3.具有以下经验者优先\n(1)熟悉Autosar软硬件架构,网络管理,车辆诊断服务。\n(2)熟悉linux BSP,掌握常见外设驱动软件开发。\n(3)熟悉linux进程/多线程编程技术,以太网开发技术。', 1, '2024-11-02 17:18:34', 0);
INSERT INTO `t_position` VALUES (59, 11, '自动驾驶规控算法工程师', 249, 1, 20000, 40000, '上海', 5, '1. 较强的分析和解决问题能力，强烈责任感，敏锐的洞察力，较好的沟通能力以及主动推进问题直至解决的能力。\n2. 良好的数学能力，熟悉数值优化，常见的规划，决策，控制算法。\n3. 有机器人控制北京或熟悉国内外自动驾驶算法者优先。\n4. 扎实的编程能力，熟悉并掌握c/c+中至少一种编程语言。\n', 1, '2024-11-02 17:19:19', 0);
INSERT INTO `t_position` VALUES (60, 11, 'C/C++', 50, 2, 16000, 30000, '上海', 5, 'A I软件开发工程师（OD）', 1, '2024-11-02 17:20:10', 0);
INSERT INTO `t_position` VALUES (61, 11, '运维开发工程师', 233, 1, 15000, 20000, '长沙', 5, '1、具有软件编程能力，熟悉Java/C/C++/Python任意一种编程语言；\n2、1年以上工作经验，有大型系统运维或者开发工作经验；\n3、熟悉K8S，Docker 虚拟化与容器原理及技术；\n4、熟悉Shell，并有过运维自动化开发工作经验；\n5、熟练掌握主流Java开发框架Spring, Struts2, Mybatis及Maven构建工具开发，熟悉Springboot\\SpringCloud技术栈优先。', 1, '2024-11-02 17:20:44', 0);
INSERT INTO `t_position` VALUES (62, 11, 'android开发工程师', 18, 1, 20000, 21000, '武汉', 5, '1.有软件开发经验，有良好的编码基础\n2.熟悉Android平台软件开发经验优先', 1, '2024-11-02 17:21:22', 0);
INSERT INTO `t_position` VALUES (63, 11, 'java开发工程师', 16, 2, 12000, 24000, '东莞', 5, '1、具备较强的沟通表达能力，较强的主动服务意识\n2、业务理解能力强，对技术有热情，喜欢钻研，能快速接受和掌握新技术，有较强的独立学习能力\n3、具备高度责任心，有较强的推动协调组织能力\n4、熟练掌握Java，代码能力扎实，善于分析问题需求，具有良好的代码风格，接口设计与框架实现能力\n5、了解常用的微服务开发框架，熟悉kafka、redis、ES等常见中间件\n5、了解kubernetes、docker等容器化工具原理，有集群部署，备份恢复等相关经验者优先', 1, '2024-11-02 17:22:01', 0);
INSERT INTO `t_position` VALUES (64, 11, '软件开发工程师', 264, 1, 16000, 30000, '杭州', 5, '1.计算机、电子、通信、自动化等相关专业本科及以上学历。\n2.熟悉C/C++、Java、Python、Go、shell等一门或多门编程语言，熟悉常用数据结构与算法。\n3.具备独立工作和解决问题的能力，乐于共同分享，善于团队协作。\n加分项：\n1.熟悉操作系统、计算机体系结构、编译原理者优先。\n2.具有linux开发相关经验者优先。', 1, '2024-11-02 17:22:50', 0);
INSERT INTO `t_position` VALUES (65, 11, '前端开发工程师', 17, 1, 12000, 24000, '成都', 5, '1. 熟练vue2开发，对vue2原理有一定了解；\n2. 熟练axios开发，了解axios原理；\n3. 熟练js开发，有ES6+开发经验，了解promise、await、async异步编程；\n4. 熟练组件化开发，对代码有一定的要求，定期审视并优化代码；\n5. 熟练css操作，在布局及响应式有自己的理解，有一定的css优化经验及css动效交互经验；\n6. 熟练echarts、element-plus进行图表、组件化开发；\n7. 熟悉Less语法，有Less开发经验；\n8. 熟悉http/https协议；\n9. 熟悉Chrome开发及调试，了解浏览器差异，具有浏览器兼容性及分辨率开发经验；\n10. 熟悉d3、svg、canvas开发，有相应的开发经验；', 1, '2024-11-02 17:23:49', 0);
INSERT INTO `t_position` VALUES (66, 11, '中高级软件开发工程师', 17, 1, 25000, 40000, '南昌', 5, '1、计算机及相关专业本科以上学历。\n2、熟练使用 JavaScript (es5,es6)、有TypeScript开发经验；\n3、熟悉理解 VUE，React 前端框架，并有实际的开发经验；\n4、有移动端 H5、小程序等开发经验，具有解决移动端不同移动设备不同版本的兼容问题的能力；\n5、能解决常见浏览器兼容性问题，并有可行的解决办法；\n6、具备良好的学习能力、沟通能力、分析及解决问题能力，', 1, '2024-11-02 17:24:29', 0);
INSERT INTO `t_position` VALUES (67, 11, 'java开发工程师', 16, 2, 12000, 24000, '西安', 5, '1、统招本科以上学历，1年以上相关工作经验；\n2、JAVA基础扎实，充分理解面向对象，熟悉io、nio、多线程、设计模式、通信协议等基础技术；熟悉JVM 工作原理并掌握常见性能调优方法；\n3、熟悉Spring、Springmvc、Mybatis、Hibernate等常用开发框架及特征，熟悉常用中间件Tomcat、Mq、Kafka等；\n4、熟悉单元测试用例开发；熟悉软件技术文档的编写；\n5、具备良好的文档编制习惯和代码书写规范；', 1, '2024-11-02 17:25:17', 0);
INSERT INTO `t_position` VALUES (68, 11, '前端开发工程师', 17, 2, 16000, 30000, '深圳', 5, '1、两年以上Web类应用前后端开发经验，具备Web服务前后端开发经验，熟练使用Vue/Spring/MySQL等常见框架或组件。\n2、能正确理解所从事模块/特性的软件需求，参加过相关特性/模块的软件设计，并能将需求文档的内容正确运用于软件设计和代码编写。\n3、良好的沟通协调能力和团队合作精神，善于钻研，解决问题能力强。', 1, '2024-11-02 17:26:04', 0);
INSERT INTO `t_position` VALUES (69, 11, '软件架构师（OS领域）', 260, 1, 70000, 100000, '上海', 5, '1. 负责OS领域的软件系统设计，看护调度、实时、成本等关键竞争力，并完成部分框架代码实现\n2. 负责OS领域的规划（含软硬件协同），保证竞争力持续迭代，并结合业务难题持续突破\n3. OS软件架构看护，结合业务实际完成架构分型，满足多产品形态和异构等多业务部署要求，合理控制架构数量， 以及软件货架化搭建\n4. 根据领域特性引入先进的架构设计方法和工具，带领团队持续突破软件难题\n5. 设计体系建设，搭建梯队，提升能力，保证架构、设计到代码的闭环落地', 1, '2024-11-02 17:26:48', 0);
INSERT INTO `t_position` VALUES (70, 11, '算法工程师', 246, 1, 15000, 30000, '广州', 5, '1、本科及以上学历，精通python，具有2年以上python使用经验，熟悉基本linux操作会使用常用的shell命令\n2、熟悉机器学习常用算法，了解深度学习，有kaggle等比赛经验优先，具体NLP领域AI算法和模型调优经验。\n3、善于总结工作过程中问题，具有强烈的责任心及团队协作能力，愿意挑战新的领域', 1, '2024-11-02 17:27:44', 0);
INSERT INTO `t_position` VALUES (71, 11, '前端开发工程师', 17, 2, 12000, 28000, '西安', 5, '1、1年以上工作经验，有扎实的web前端基础，熟练掌握HTML、CSS、JS等前端开发语言；\n2、至少熟悉一种常用的前端框架，Angular、Vue优先，具备组件开发的能力；\n3、掌握通用的前端编程规范和常用的代码重构知识；\n4、熟悉Web应用性能影响因素及优化方案，能有效分析并优化应用性能；\n5、有强烈的进取心和责任心，具有良好的沟通能力和团队合作精神；', 1, '2024-11-02 17:28:22', 0);
INSERT INTO `t_position` VALUES (72, 11, 'iOS', 59, 2, 13000, 26000, '西安', 5, '1、熟练掌握C/C++/JAVA一种或多种编程语言，熟悉嵌入式系统、移动操作系统，熟悉网络通信等专业知识；\n2、需要实际参与1~2个项目需求分析、设计及开发的具体工作；\n3、有嵌入式软件开发，Windows/Android/IOS等多平台终端产品开发经验者优先；\n4、有音视频架构设计，音视频算法，性能改进，关键/重大问题处理经验者优先。\n', 1, '2024-11-02 17:29:08', 0);
INSERT INTO `t_position` VALUES (73, 11, '软件开发工程师', 264, 1, 15000, 25000, '西安', 5, '1、掌握Python/Java/C++任何一门主流编程语言，掌握SQL脚本编写，熟悉数据采集与预处理技术； 2、具备基础数据分析能力，能围绕研发体系数字化需求进行数据仓库建模和数据分析，在AI算法、大数据、分布式场景设计与开发经验经验者优先； 3、做事认真细致，具备良好的团队合作精神，沟通能力佳，对技术充满热情，拥有一定的创新意识。', 1, '2024-11-02 17:29:49', 0);
INSERT INTO `t_position` VALUES (74, 11, '软件测试工程师', 219, 2, 15000, 30000, '东莞', 5, '1、制订测试计划、规划测试方案、编写软件测试工具、执行软件测试、分析测试数据、输出测试报告；\n2、对测试中的问题进行分析和定位，与开发人员一起寻求解决方案；\n3、提出对产品的进一步改进的建议，并评估改进方案是否合理；对测试结果进行总结与统计分析；\n4、能负责各个产品和解决方案的准入测试、比拼测试、选型测试，负责重大跨领域项目集成交付、问题故障界定、技术能力中心（包括竞争分析、场景分析、性能分析）的建设等工作；\n5、能直接与全球顶级的运营商、行业客户沟通对话，以专业的技术，架起与客户之间沟通的桥梁。', 1, '2024-11-02 17:30:44', 0);
INSERT INTO `t_position` VALUES (75, 12, 'iOS开发工程师', 59, 2, 30000, 50000, '北京', 5, '1.良好的编程风格，扎实基础\n2.熟练掌握iOS平台下的高性能编程及性能调优\n3.有较强分析和解决问题的能力\n4.有强烈的责任心和团队精神，善于沟通合作', 0, '2024-11-02 17:34:32', 0);
INSERT INTO `t_position` VALUES (76, 12, 'iOS', 59, 2, 20000, 40000, '北京', 6, '1、良好的编程风格，扎实的编程和数据结构算法基础；深入理解面向对象编程思想，具有较强的设计能力；\n2、深入理解iOS SDK，具有丰富的 Objective-C 及 C/C++ 开发经验；精通各种UI控件，能够实现复杂的界面交互；\n3、熟练掌握iOS平台下的高性能编程及性能调优；\n4、具有较强的分析和解决问题的能力；热爱互联网新技术，了解并探索业界技术动向；\n5、有强烈的责任心和团队精神，善于沟通和合作；\n6、具有音视频、直播、OpenGL相关开发经验者优先。\n\n阮先生\n阮先生\n半年前活跃', 0, '2024-11-02 17:35:17', 0);
INSERT INTO `t_position` VALUES (77, 12, '推荐算法工程师', 241, 1, 35000, 65000, '北京', 5, '1、计算机、数学或统计学相关专业本科及以上学历；\n2、熟练掌握Python，C++等编程语言，熟悉常用机器学习框架（如TensorFlow、PyTorch等）\n3、优秀的代码能力, 扎实的数据结构和算法功底；\n4、熟悉大规模数据挖掘、机器学习、分布式计算，具备实际工作经验；\n5、善于阅读文献，能够独立思考，解决实际问题，具备良好的逻辑思维和沟通能力；\n6、热爱技术，关注新技术和新领域，善于团队协作和知识分享；\n7、具备创新精神，不断探索新的算法和技术方案，为产品和业务提供优化建议；\n8、对直播、社交、电商等领域感兴趣，能够理解并分析用户行为和需求，提高用户粘性和用户体验。', 0, '2024-11-02 17:36:03', 0);
INSERT INTO `t_position` VALUES (78, 12, '测试开发', 223, 1, 25000, 50000, '北京', 5, '1、本科以上学历，具有三年及以上测试开发经验，具备良好的质量保障意识；\n2、熟悉业界主流测试技术，并具备至少一项深入研究经历和思考，能通过技术手段有效提升质量和效率\n3、工作态度严谨认真，愿意积极主动思考，乐观开朗，有创新意识\n4、熟练掌握Java/Python/Golang/C++至少一门编程语言，并掌握该语言相关通用框架，擅长Java尤佳\n5、具备良好的问题分析能力和抽象能力，能独立承担一整块业务并推动目标达成，整体具备良好的质量把控能力\n6、学习能力强，熟悉某一领域的业务特点和产品特性，具备一定的技术前瞻性，有支付相关经验尤佳', 0, '2024-11-02 17:36:56', 0);
INSERT INTO `t_position` VALUES (79, 12, '推荐算法', 241, 1, 30000, 60000, '北京', 6, '推荐算法岗位内推，简历通过直约面试', 0, '2024-11-02 17:38:05', 0);
INSERT INTO `t_position` VALUES (80, 12, '高级Java开发工程师', 16, 2, 30000, 40000, '北京', 5, '1、本科及以上学历，计算机、软件工程及相关专业；\n2、熟悉Java语言，具备扎实的Java基础，熟悉IO、多线程等基础技术，对多线程使用、并发处理、JVM基本原理有一定认识；\n3、熟练使用Spring、Spring MVC等框架，并对框架原理有一定了解；\n4、熟悉MySQL的应用开发、常见的性能调优和可扩展性设计，了解Redis缓存技术；\n5、熟悉ZooKeeper、Kafka等各种中间件，对事务、锁、并发等实现机制有深入了解；\n6、熟悉SOA架构，对RPC、序列化、服务治理有相应了解；\n7、熟悉DDD领域驱动设计，熟悉常用业务架构的设计，具备良好的编程能力和代码风格；\n8、具有一定的技术规划和设计能力，能发现架构设计中存在的问题，并给出有效的解决措施和方法。', 0, '2024-11-02 17:38:43', 0);
INSERT INTO `t_position` VALUES (81, 12, 'HR -人力资源专员', 91, 3, 5000, 8000, '铜仁', 5, '1、本科及以上学历，1-3年人力资源工作经验，其中有大型互联网工作经验优先；\n2、熟练运用Excel高级函数，PS修图工具，PR剪辑等办公软件优先；\n3、在组织发展、领导力、文化项目的落地实施方面有丰富经验者优先；\n4、有很强的责任心和抗压能力，和业务敏锐度，善于沟通，乐于合作。', 0, '2024-11-02 17:39:29', 0);

-- ----------------------------
-- Table structure for t_post
-- ----------------------------
DROP TABLE IF EXISTS `t_post`;
CREATE TABLE `t_post`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `parent_id` int NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '岗位名称',
  `is_deleted` int NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `parent_id`(`parent_id`) USING BTREE,
  CONSTRAINT `t_post_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `t_post` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 265 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_post
-- ----------------------------
INSERT INTO `t_post` VALUES (4, NULL, '互联网IT', 0);
INSERT INTO `t_post` VALUES (7, 4, '后端开发开发', 0);
INSERT INTO `t_post` VALUES (15, 4, '前端/移动开发', 0);
INSERT INTO `t_post` VALUES (16, 7, 'Java', 0);
INSERT INTO `t_post` VALUES (17, 15, '前端开发工程师', 0);
INSERT INTO `t_post` VALUES (18, 15, 'Android', 0);
INSERT INTO `t_post` VALUES (19, 15, '鸿蒙开发', 0);
INSERT INTO `t_post` VALUES (29, NULL, '客服/运营', 0);
INSERT INTO `t_post` VALUES (30, 29, '客服', 0);
INSERT INTO `t_post` VALUES (31, 30, '客服专员', 0);
INSERT INTO `t_post` VALUES (32, 30, '客服主管', 0);
INSERT INTO `t_post` VALUES (33, 30, '网络客服', 0);
INSERT INTO `t_post` VALUES (34, 30, '电话客服', 0);
INSERT INTO `t_post` VALUES (35, 29, '内容运营', 0);
INSERT INTO `t_post` VALUES (36, 35, '新媒体运营', 0);
INSERT INTO `t_post` VALUES (37, 35, '直播运营', 0);
INSERT INTO `t_post` VALUES (38, 35, '视频运营', 0);
INSERT INTO `t_post` VALUES (39, NULL, '金融', 0);
INSERT INTO `t_post` VALUES (40, 39, '银行', 0);
INSERT INTO `t_post` VALUES (41, 40, '柜员', 0);
INSERT INTO `t_post` VALUES (43, 40, '银行大堂经理', 0);
INSERT INTO `t_post` VALUES (44, 40, '信贷专员', 0);
INSERT INTO `t_post` VALUES (45, 39, '证券/基金/期货', 0);
INSERT INTO `t_post` VALUES (46, 45, '证券交易员', 0);
INSERT INTO `t_post` VALUES (47, 45, '卖方分析师', 0);
INSERT INTO `t_post` VALUES (48, 45, '买方分析师', 0);
INSERT INTO `t_post` VALUES (49, 45, '基金经理', 0);
INSERT INTO `t_post` VALUES (50, 7, 'C/C++', 0);
INSERT INTO `t_post` VALUES (51, 7, 'PHP', 0);
INSERT INTO `t_post` VALUES (53, 7, 'C#', 0);
INSERT INTO `t_post` VALUES (55, 7, 'Node.js', 0);
INSERT INTO `t_post` VALUES (56, 7, 'Golang', 0);
INSERT INTO `t_post` VALUES (58, 7, 'Python', 0);
INSERT INTO `t_post` VALUES (59, 15, 'IOS', 0);
INSERT INTO `t_post` VALUES (63, NULL, '销售', 0);
INSERT INTO `t_post` VALUES (66, 63, '销售员', 0);
INSERT INTO `t_post` VALUES (69, 66, '销售专员', 0);
INSERT INTO `t_post` VALUES (71, 66, '电话销售', 0);
INSERT INTO `t_post` VALUES (72, 66, '渠道销售', 0);
INSERT INTO `t_post` VALUES (73, 66, '网络销售', 0);
INSERT INTO `t_post` VALUES (75, 63, '销售管理', 0);
INSERT INTO `t_post` VALUES (76, 75, '销售经理', 0);
INSERT INTO `t_post` VALUES (78, 75, '销售总监', 0);
INSERT INTO `t_post` VALUES (80, 63, '汽车销售', 0);
INSERT INTO `t_post` VALUES (81, 80, '汽车销售专员', 0);
INSERT INTO `t_post` VALUES (82, 80, '汽车配件销售', 0);
INSERT INTO `t_post` VALUES (83, 63, '房地产销售', 0);
INSERT INTO `t_post` VALUES (84, 83, '地产中介', 0);
INSERT INTO `t_post` VALUES (85, 83, '房地产销售总监', 0);
INSERT INTO `t_post` VALUES (86, NULL, '人力/行政/法务', 0);
INSERT INTO `t_post` VALUES (87, 86, '人力资源', 0);
INSERT INTO `t_post` VALUES (88, 87, '招聘', 0);
INSERT INTO `t_post` VALUES (89, 87, '培训', 0);
INSERT INTO `t_post` VALUES (90, 87, '猎头顾问', 0);
INSERT INTO `t_post` VALUES (91, 87, '人力资源专员/助理', 0);
INSERT INTO `t_post` VALUES (92, 87, '人力资源主管/经理', 0);
INSERT INTO `t_post` VALUES (93, 86, '行政', 0);
INSERT INTO `t_post` VALUES (94, 93, '行政专员/助理', 0);
INSERT INTO `t_post` VALUES (95, 93, '行政经理/主管', 0);
INSERT INTO `t_post` VALUES (96, 93, '行政总监', 0);
INSERT INTO `t_post` VALUES (97, 93, '前台', 0);
INSERT INTO `t_post` VALUES (98, 93, '经理助理', 0);
INSERT INTO `t_post` VALUES (99, 93, '文员', 0);
INSERT INTO `t_post` VALUES (100, 86, '法律服务', 0);
INSERT INTO `t_post` VALUES (101, 100, '法务专员/助理', 0);
INSERT INTO `t_post` VALUES (102, 100, '法务经理/主管', 0);
INSERT INTO `t_post` VALUES (103, 100, '法务总监', 0);
INSERT INTO `t_post` VALUES (104, 100, '法律顾问', 0);
INSERT INTO `t_post` VALUES (105, 100, '律师', 0);
INSERT INTO `t_post` VALUES (106, NULL, '电子/电气/通信', 0);
INSERT INTO `t_post` VALUES (107, 106, '电子/硬件开发', 0);
INSERT INTO `t_post` VALUES (108, 107, '电子工程师', 0);
INSERT INTO `t_post` VALUES (109, 107, '硬件工程师', 0);
INSERT INTO `t_post` VALUES (110, 107, '嵌入式软件工程师', 0);
INSERT INTO `t_post` VALUES (111, 106, '半导体/芯片', 0);
INSERT INTO `t_post` VALUES (112, 107, '单片机', 0);
INSERT INTO `t_post` VALUES (113, 107, '电子维修技术员', 0);
INSERT INTO `t_post` VALUES (114, 111, '集成电路IC设计', 0);
INSERT INTO `t_post` VALUES (115, 111, '芯片测试工程师', 0);
INSERT INTO `t_post` VALUES (116, 111, '数字前端设计师', 0);
INSERT INTO `t_post` VALUES (117, 111, '数字IC验证工程师', 0);
INSERT INTO `t_post` VALUES (118, 111, '模拟版图设计工程师', 0);
INSERT INTO `t_post` VALUES (119, 111, 'DFT工程师', 0);
INSERT INTO `t_post` VALUES (120, 106, '电气/自动化', 0);
INSERT INTO `t_post` VALUES (121, 120, '电气工程师', 0);
INSERT INTO `t_post` VALUES (122, 120, '电气设计工程师', 0);
INSERT INTO `t_post` VALUES (123, 120, '自动化', 0);
INSERT INTO `t_post` VALUES (124, 120, '机电工程师', 0);
INSERT INTO `t_post` VALUES (125, 106, '技术项目管理', 0);
INSERT INTO `t_post` VALUES (126, 125, '实施工程师', 0);
INSERT INTO `t_post` VALUES (127, 125, '需求分析工程师', 0);
INSERT INTO `t_post` VALUES (128, 125, '硬件项目经理', 0);
INSERT INTO `t_post` VALUES (129, 106, '通信', 0);
INSERT INTO `t_post` VALUES (130, 129, '通信项目经理', 0);
INSERT INTO `t_post` VALUES (131, 129, '通信技术工程师', 0);
INSERT INTO `t_post` VALUES (132, 129, '网络工程师', 0);
INSERT INTO `t_post` VALUES (133, 129, '数据通信工程师', 0);
INSERT INTO `t_post` VALUES (134, NULL, '餐饮', 0);
INSERT INTO `t_post` VALUES (135, 134, '前厅', 0);
INSERT INTO `t_post` VALUES (136, 135, '服务员', 0);
INSERT INTO `t_post` VALUES (137, 135, '收银', 0);
INSERT INTO `t_post` VALUES (138, 135, '传菜员', 0);
INSERT INTO `t_post` VALUES (139, 135, '礼仪/迎宾/接待', 0);
INSERT INTO `t_post` VALUES (140, 134, '后厨', 0);
INSERT INTO `t_post` VALUES (141, 140, '中餐厨师', 0);
INSERT INTO `t_post` VALUES (142, 140, '西餐厨师', 0);
INSERT INTO `t_post` VALUES (143, 140, '面点师', 0);
INSERT INTO `t_post` VALUES (144, 140, '餐饮学徒', 0);
INSERT INTO `t_post` VALUES (145, 134, '甜点饮品', 0);
INSERT INTO `t_post` VALUES (146, 145, '咖啡师', 0);
INSERT INTO `t_post` VALUES (147, 145, '茶艺师', 0);
INSERT INTO `t_post` VALUES (148, 145, '调酒师', 0);
INSERT INTO `t_post` VALUES (149, 145, '面包/烘焙师', 0);
INSERT INTO `t_post` VALUES (150, NULL, '教育培训', 0);
INSERT INTO `t_post` VALUES (151, 150, '教师', 0);
INSERT INTO `t_post` VALUES (152, 150, '职业培训', 0);
INSERT INTO `t_post` VALUES (153, 151, '英语教师', 0);
INSERT INTO `t_post` VALUES (154, 151, '数学教师', 0);
INSERT INTO `t_post` VALUES (155, 151, '语文教师', 0);
INSERT INTO `t_post` VALUES (156, 151, '高中教师', 0);
INSERT INTO `t_post` VALUES (157, 151, '初中教师', 0);
INSERT INTO `t_post` VALUES (158, 151, '小学教师', 0);
INSERT INTO `t_post` VALUES (159, 151, '家教', 0);
INSERT INTO `t_post` VALUES (160, 151, '地理教师', 0);
INSERT INTO `t_post` VALUES (161, 151, '化学教师', 0);
INSERT INTO `t_post` VALUES (162, 151, '生物教师', 0);
INSERT INTO `t_post` VALUES (163, 151, '政治教师', 0);
INSERT INTO `t_post` VALUES (164, 151, '历史教师', 0);
INSERT INTO `t_post` VALUES (165, 152, 'IT培训师', 0);
INSERT INTO `t_post` VALUES (166, 152, '财会培训师', 0);
INSERT INTO `t_post` VALUES (167, 150, '讲师', 0);
INSERT INTO `t_post` VALUES (168, 167, '专升本讲师', 0);
INSERT INTO `t_post` VALUES (169, 167, '考研讲师', 0);
INSERT INTO `t_post` VALUES (170, 35, '微信运营', 0);
INSERT INTO `t_post` VALUES (171, 29, '电商运营', 0);
INSERT INTO `t_post` VALUES (172, 171, '淘宝/天猫运营', 0);
INSERT INTO `t_post` VALUES (173, 171, '京东运营', 0);
INSERT INTO `t_post` VALUES (174, 171, '拼多多运营', 0);
INSERT INTO `t_post` VALUES (175, 171, '跨境电商运营', 0);
INSERT INTO `t_post` VALUES (176, 171, '国内电商运营', 0);
INSERT INTO `t_post` VALUES (177, 171, '亚马逊运营', 0);
INSERT INTO `t_post` VALUES (178, 171, '阿里国际站运营', 0);
INSERT INTO `t_post` VALUES (179, 29, '业务运营', 0);
INSERT INTO `t_post` VALUES (180, 179, '产品运营', 0);
INSERT INTO `t_post` VALUES (181, 179, '用户运营', 0);
INSERT INTO `t_post` VALUES (182, 179, '商家运营', 0);
INSERT INTO `t_post` VALUES (183, 179, '游戏运营', 0);
INSERT INTO `t_post` VALUES (184, 179, '活动运营', 0);
INSERT INTO `t_post` VALUES (185, 179, '网站运营', 0);
INSERT INTO `t_post` VALUES (186, 179, '内容审核', 0);
INSERT INTO `t_post` VALUES (187, 179, '数据标注/AI训练师', 0);
INSERT INTO `t_post` VALUES (188, 29, '编辑', 0);
INSERT INTO `t_post` VALUES (189, 188, '文案编辑', 0);
INSERT INTO `t_post` VALUES (190, 188, '主编/副主编', 0);
INSERT INTO `t_post` VALUES (191, 188, '网站编辑', 0);
INSERT INTO `t_post` VALUES (192, 29, '高端运营职位', 0);
INSERT INTO `t_post` VALUES (193, 192, '运营经理/主管', 0);
INSERT INTO `t_post` VALUES (194, 192, '运营总监', 0);
INSERT INTO `t_post` VALUES (195, 192, 'COO', 0);
INSERT INTO `t_post` VALUES (196, NULL, '直播/影视/传媒', 0);
INSERT INTO `t_post` VALUES (197, 196, '直播', 0);
INSERT INTO `t_post` VALUES (198, 197, '主播', 0);
INSERT INTO `t_post` VALUES (199, 197, '带货主播', 0);
INSERT INTO `t_post` VALUES (201, 197, '游戏主播', 0);
INSERT INTO `t_post` VALUES (202, 197, '中控/场控/助播', 0);
INSERT INTO `t_post` VALUES (204, 196, '影视', 0);
INSERT INTO `t_post` VALUES (205, 204, '艺人助理', 0);
INSERT INTO `t_post` VALUES (206, 204, '模特', 0);
INSERT INTO `t_post` VALUES (207, 204, '编剧', 0);
INSERT INTO `t_post` VALUES (208, 204, '制片人', 0);
INSERT INTO `t_post` VALUES (209, 204, '动漫设计', 0);
INSERT INTO `t_post` VALUES (210, 204, '灯光师', 0);
INSERT INTO `t_post` VALUES (211, 204, '摄影/摄像师', 0);
INSERT INTO `t_post` VALUES (212, 196, '广告', 0);
INSERT INTO `t_post` VALUES (213, 212, '策划经理', 0);
INSERT INTO `t_post` VALUES (214, 212, '广告文案', 0);
INSERT INTO `t_post` VALUES (215, 212, '广告制作', 0);
INSERT INTO `t_post` VALUES (216, 212, '广告设计', 0);
INSERT INTO `t_post` VALUES (217, 212, '创意总监', 0);
INSERT INTO `t_post` VALUES (218, 4, '测试', 0);
INSERT INTO `t_post` VALUES (219, 218, '测试工程师', 0);
INSERT INTO `t_post` VALUES (220, 218, '软件测试', 0);
INSERT INTO `t_post` VALUES (221, 218, '自动化测试', 0);
INSERT INTO `t_post` VALUES (222, 218, '功能测试', 0);
INSERT INTO `t_post` VALUES (223, 218, '测试开发', 0);
INSERT INTO `t_post` VALUES (224, 218, '硬件测试', 0);
INSERT INTO `t_post` VALUES (225, 218, '游戏测试', 0);
INSERT INTO `t_post` VALUES (226, 218, '性能测试', 0);
INSERT INTO `t_post` VALUES (227, 218, '渗透测试', 0);
INSERT INTO `t_post` VALUES (228, 218, '测试经理', 0);
INSERT INTO `t_post` VALUES (229, 4, '运维/技术支持', 0);
INSERT INTO `t_post` VALUES (230, 229, '运维工程师', 0);
INSERT INTO `t_post` VALUES (231, 229, 'IT技术支持', 0);
INSERT INTO `t_post` VALUES (232, 229, '系统工程师', 0);
INSERT INTO `t_post` VALUES (233, 229, '运维开发工程师', 0);
INSERT INTO `t_post` VALUES (234, 229, '系统管理员', 0);
INSERT INTO `t_post` VALUES (235, 229, 'DBA', 0);
INSERT INTO `t_post` VALUES (236, 4, '人工智能', 0);
INSERT INTO `t_post` VALUES (237, 236, '图像算法', 0);
INSERT INTO `t_post` VALUES (238, 236, '自然语言处理算法', 0);
INSERT INTO `t_post` VALUES (239, 236, '大模型算法', 0);
INSERT INTO `t_post` VALUES (240, 236, '数据挖掘', 0);
INSERT INTO `t_post` VALUES (241, 236, '推荐算法', 0);
INSERT INTO `t_post` VALUES (242, 236, '搜索算法', 0);
INSERT INTO `t_post` VALUES (243, 236, '语言算法', 0);
INSERT INTO `t_post` VALUES (244, 236, '风控算法', 0);
INSERT INTO `t_post` VALUES (245, 236, '算法研究员', 0);
INSERT INTO `t_post` VALUES (246, 236, '算法工程师', 0);
INSERT INTO `t_post` VALUES (247, 236, '机器学习', 0);
INSERT INTO `t_post` VALUES (248, 236, '深度学习', 0);
INSERT INTO `t_post` VALUES (249, 236, '自动驾驶系统工程师', 0);
INSERT INTO `t_post` VALUES (250, 4, '销售技术支持', 0);
INSERT INTO `t_post` VALUES (251, 250, '售前技术支持', 0);
INSERT INTO `t_post` VALUES (252, 250, '售后技术支持', 0);
INSERT INTO `t_post` VALUES (254, 4, '技术项目管理', 0);
INSERT INTO `t_post` VALUES (255, 254, '项目经理/主管', 0);
INSERT INTO `t_post` VALUES (256, 254, '硬件项目经理', 0);
INSERT INTO `t_post` VALUES (257, 254, '需求分析工程师', 0);
INSERT INTO `t_post` VALUES (258, 4, '高端技术职位', 0);
INSERT INTO `t_post` VALUES (259, 258, '技术经理', 0);
INSERT INTO `t_post` VALUES (260, 258, '架构师', 0);
INSERT INTO `t_post` VALUES (261, 258, '技术总监', 0);
INSERT INTO `t_post` VALUES (262, 258, '运维总监', 0);
INSERT INTO `t_post` VALUES (263, 258, '技术合伙人', 0);
INSERT INTO `t_post` VALUES (264, 7, '高级后端开发', 0);
INSERT INTO `t_post` VALUES (265, NULL, '111', 1);

-- ----------------------------
-- Table structure for t_project
-- ----------------------------
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `project_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `start_time` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `end_time` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目内容',
  `is_deleted` int NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `t_project_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_project
-- ----------------------------
INSERT INTO `t_project` VALUES (1, 3, '在线点餐平台', '2023-10', '2024-06', '该项目主要分为用户端，商家端，骑手端，管理员端，用户可以维护自己的地址，浏览美食，美食加入购物车，付款，催单等功能；\n商户可以上新美食，取消订单，出餐等功能，骑手可以接单，取消订单，与商户或用户沟通等，管理员主要维护权限等功能。\n该项目技术栈使用 springboot、springsecurity、mybatisplus、redis、websocket、rabbitMQ等，我主要负责用户端的代码编写', 0);
INSERT INTO `t_project` VALUES (2, 4, '某即时通讯软件', '2022-06', '2023-06', '负责页面开发，页面主要负责，好有关系页面，聊天页面等，与后端接口的联调。', 0);

-- ----------------------------
-- Table structure for t_resume_delivery
-- ----------------------------
DROP TABLE IF EXISTS `t_resume_delivery`;
CREATE TABLE `t_resume_delivery`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `position_id` int NULL DEFAULT NULL,
  `status` int NULL DEFAULT 0 COMMENT '投递状态 0未查看1已查看2感兴趣3邀面试',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '投递日期',
  `is_deleted` int NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `position_id`(`position_id`) USING BTREE,
  CONSTRAINT `t_resume_delivery_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_resume_delivery_ibfk_2` FOREIGN KEY (`position_id`) REFERENCES `t_position` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_resume_delivery
-- ----------------------------
INSERT INTO `t_resume_delivery` VALUES (7, 4, 2, 3, '2024-11-02 19:12:28', 0);
INSERT INTO `t_resume_delivery` VALUES (8, 3, 4, 3, '2024-11-02 19:14:13', 0);
INSERT INTO `t_resume_delivery` VALUES (9, 3, 1, 3, '2024-11-02 19:14:22', 0);
INSERT INTO `t_resume_delivery` VALUES (10, 3, 63, 3, '2024-11-03 14:28:45', 0);
INSERT INTO `t_resume_delivery` VALUES (11, 3, 50, 1, '2024-11-03 14:29:11', 0);
INSERT INTO `t_resume_delivery` VALUES (12, 3, 51, 2, '2024-11-03 16:08:50', 0);
INSERT INTO `t_resume_delivery` VALUES (13, 3, 55, 2, '2024-11-06 10:17:46', 0);
INSERT INTO `t_resume_delivery` VALUES (14, 3, 26, 0, '2025-02-05 23:25:57', 0);
INSERT INTO `t_resume_delivery` VALUES (18, 3, 70, 0, '2025-03-27 18:54:41', 0);
INSERT INTO `t_resume_delivery` VALUES (19, 4, 45, 0, '2025-03-27 19:31:53', 0);
INSERT INTO `t_resume_delivery` VALUES (20, 4, 67, 0, '2025-03-27 19:32:13', 0);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT 'recruitment/beb7c795-1116-458c-aa1f-5c15201ef364.jpg',
  `role_id` int NULL DEFAULT NULL COMMENT '1求职者2招聘者3管理员',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `is_deleted` int NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username`(`username`) USING BTREE,
  INDEX `password`(`password`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', '$2a$10$1IUtG81ysGKxBysmYD/taeNCQ/6gEj4FiTiMTqrbGU3u4Uhu5LL9W', 'recruitment/beb7c795-1116-458c-aa1f-5c15201ef364.jpg', 3, '2024-06-30 08:00:00', 0);
INSERT INTO `t_user` VALUES (2, 'ali', '$2a$10$zfcALtO9bZU8X1xKWoWZsOzc74RPwvxlNkWV.LWmhm0sc7F5Hn7U.', 'recruitment/1e4f51ff-9950-4e27-a27a-d7eab9f66475.jpg', 2, '2024-07-10 08:00:00', 0);
INSERT INTO `t_user` VALUES (3, 'zhangsan', '$2a$10$PLX40UUxo1T7pNF2PvMnYOm5dZOXVTFwxOuBz6iEUfKmXv9HTgJEy', 'recruitment/d16351e9-7d0c-4beb-ac5b-39ab60f629f9.jpg', 1, '2024-07-20 08:00:00', 0);
INSERT INTO `t_user` VALUES (4, 'lisi', '$2a$10$4xIQON5CMlmSA7awMzpKkOAKFVpjmoSBlonrl7CDPjqung7oZbvNK', 'recruitment/48f79efd-53eb-42a9-8b89-d1534e8cf891.jpg', 1, '2024-09-15 16:36:37', 0);
INSERT INTO `t_user` VALUES (5, 'slx', '$2a$10$7GEYPXPcmc3HxWLQ7PFejuSs5KzaphzUwCYxnlJEvhGTy/MTKZES2', 'recruitment/beb7c795-1116-458c-aa1f-5c15201ef364.jpg', 2, '2024-10-08 19:12:21', 0);
INSERT INTO `t_user` VALUES (6, 'zhuzi', '$2a$10$FSQwUcskZOKQAzjDwpM01.PhOfYb6uQyalZSvN0GPiKpHvdtwxwGe', 'recruitment/beb7c795-1116-458c-aa1f-5c15201ef364.jpg', 2, '2024-11-02 13:34:54', 0);
INSERT INTO `t_user` VALUES (7, 'wenyan', '$2a$10$XKQZrdq8MIpbtRAnv1us7uZGghFJhl.qd7VtBI1Hyf.1uriNMmyXS', 'recruitment/beb7c795-1116-458c-aa1f-5c15201ef364.jpg', 2, '2024-11-02 14:30:13', 0);
INSERT INTO `t_user` VALUES (8, 'jialan', '$2a$10$2Rk3EehPAPfp0Mz/rY5JMezmbwK13RlshynYLFZwS/c3eFVGoZkXO', 'recruitment/beb7c795-1116-458c-aa1f-5c15201ef364.jpg', 2, '2024-11-02 14:36:30', 0);
INSERT INTO `t_user` VALUES (9, 'zhiliao', '$2a$10$F43I7wkYPhUcIcZfK9hhCeEuOqPLymKTbysy8npoUy70EjPqeQPwe', 'recruitment/beb7c795-1116-458c-aa1f-5c15201ef364.jpg', 2, '2024-11-02 14:49:05', 0);
INSERT INTO `t_user` VALUES (10, 'juma', '$2a$10$7Nz4ORaw7eq1vGaSyhcI8OtXi8YH9NV0I9YseDRq153Mom/9xTnZ2', 'recruitment/beb7c795-1116-458c-aa1f-5c15201ef364.jpg', 2, '2024-11-02 15:20:37', 0);
INSERT INTO `t_user` VALUES (11, 'tengxun', '$2a$10$jDB2RA3t.jJb0p6DyIvg6uNJfHb6ebm2Tjc3SIJyZAxruxQfhWfMi', 'recruitment/aabf9be8-11ac-4750-9bec-c93fefd2b771.jpg', 2, '2024-11-02 15:36:31', 0);
INSERT INTO `t_user` VALUES (12, 'huawei', '$2a$10$rjTKcJBqKoWuv9s88Lcu8.uAVuy4Lm5E/pGPJqvDGI40BRDsjzCf2', 'recruitment/5ef337da-c524-4660-8fd6-e06417f05de2.jpg', 2, '2024-11-02 17:15:26', 0);
INSERT INTO `t_user` VALUES (13, 'kuaishou', '$2a$10$hH3i1524ok5K2h2WdMiPJuOFbJHDgKJ/42EtivBcxVIJsXiPcM1TO', 'recruitment/beb7c795-1116-458c-aa1f-5c15201ef364.jpg', 2, '2024-11-02 17:33:00', 0);
INSERT INTO `t_user` VALUES (14, 'wangxiaoli', '$2a$10$EwK1WKF9hYr6d5Lk8Oupyex2zwPWHn0EpOSqb0pOZIgXMfdJLKmdG', 'recruitment/dac4ab01-eaa6-4364-ab3c-d333ea304c7e.jpg', 1, '2024-11-03 14:19:40', 0);

SET FOREIGN_KEY_CHECKS = 1;
