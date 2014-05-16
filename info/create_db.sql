delimiter $$

delimiter $$

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `cardno` varchar(50) NOT NULL,
  `birth` varchar(45) NOT NULL,
  `gender` int(11) NOT NULL,
  `domicile` varchar(45) NOT NULL,
  `school` varchar(45) NOT NULL,
  `major` varchar(45) NOT NULL,
  `industry` varchar(145) NOT NULL,
  `position` varchar(45) NOT NULL,
  `salary` int(11) NOT NULL,
  `welfare` int(11) NOT NULL,
  `vacation` int(11) NOT NULL,
  `freedom` int(11) NOT NULL,
  `burden` int(11) NOT NULL,
  `development` int(11) NOT NULL,
  `training` int(11) NOT NULL,
  `wtrip` int(11) NOT NULL,
  `atmosphere` int(11) NOT NULL,
  `brand` int(11) NOT NULL,
  `distance` int(11) NOT NULL,
  `lowSalary` int(11) NOT NULL,
  `expectedSalary` int(11) NOT NULL,
  `stateown` int(11) NOT NULL,
  `institution` int(11) NOT NULL,
  `administration` int(11) NOT NULL,
  `foreig` int(11) NOT NULL,
  `privat` int(11) NOT NULL,
  `startup` int(11) NOT NULL,
  `ngo` int(11) NOT NULL,
  `commonweal` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8



CREATE TABLE `t_dimension` (
  `qid` int(11) NOT NULL,
  `number` int(11) DEFAULT '0',
  `choice` int(11) DEFAULT '0',
  `loyalty` int(11) DEFAULT '0',
  `positive` int(11) DEFAULT '0',
  `responsibility` int(11) DEFAULT '0',
  `morality` int(11) DEFAULT '0',
  `thinking` int(11) DEFAULT '0',
  `plan` int(11) DEFAULT '0',
  `innovation` int(11) DEFAULT '0',
  `teamwork` int(11) DEFAULT '0',
  `communication` int(11) DEFAULT '0',
  `strain` int(11) DEFAULT '0',
  `details` int(11) DEFAULT '0',
  `potential` int(11) DEFAULT '0',
  PRIMARY KEY (`qid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维度表,保存每个答案的评分标准。number是指维度题的ABCD'$$


delimiter $$

CREATE TABLE `t_userid` (
  `id` int(11) NOT NULL,
  `cardno` varchar(45) DEFAULT NULL,
  `birth` datetime DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `domicile` varchar(45) DEFAULT NULL,
  `school` varchar(45) DEFAULT NULL,
  `major` int(11) DEFAULT NULL,
  `industry` int(11) DEFAULT NULL,
  `position` int(11) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `welfare` int(11) DEFAULT NULL,
  `vacation` int(11) DEFAULT NULL,
  `freedom` int(11) DEFAULT NULL,
  `burdon` int(11) DEFAULT NULL,
  `prospect` int(11) DEFAULT NULL,
  `training` int(11) DEFAULT NULL,
  `btrip` int(11) DEFAULT NULL,
  `people` int(11) DEFAULT NULL,
  `brand` int(11) DEFAULT NULL,
  `distance` int(11) DEFAULT NULL,
  `least_salary` int(11) DEFAULT NULL,
  `expected_salary` int(11) DEFAULT NULL,
  `state-own` int(11) DEFAULT NULL,
  `institution` int(11) DEFAULT NULL,
  `administration` int(11) DEFAULT NULL,
  `foreign` int(11) DEFAULT NULL,
  `private` int(11) DEFAULT NULL,
  `startup` int(11) DEFAULT NULL,
  `ngo` int(11) DEFAULT NULL,
  `commonweal` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `score` AS
    select 
        `t_dimension`.`id` AS `id`,
        sum(`t_dimension`.`loyalty`) AS `忠诚敬业`,
        sum(`t_dimension`.`positive`) AS `积极主动`,
        sum(`t_dimension`.`responsibility`) AS `责任心`,
        sum(`t_dimension`.`morality`) AS `道德感`,
		(sum(`t_dimension`.`loyalty`) + sum(`t_dimension`.`positive`) + sum(`t_dimension`.`responsibility`) + sum(`t_dimension`.`morality`)) AS `职业素养`,
        sum(`t_dimension`.`thinking`) AS `信息学习能力`,
        sum(`t_dimension`.`plan`) AS `计划能力`,
        sum(`t_dimension`.`innovation`) AS `创新意识`,
		(sum(`t_dimension`.`thinking`)+sum(`t_dimension`.`plan`)+sum(`t_dimension`.`innovation`)) AS `思维能力`,
        sum(`t_dimension`.`teamwork`) AS `团队观念`,
        sum(`t_dimension`.`communication`) AS `人际沟通`,
        sum(`t_dimension`.`strain`) AS `应变能力`,
        sum(`t_dimension`.`details`) AS `细节执行`,
		(sum(`t_dimension`.`teamwork`)+sum(`t_dimension`.`communication`)+sum(`t_dimension`.`communication`)+sum(`t_dimension`.`strain`)) AS `执行能力`,
        sum(`t_dimension`.`potential`) AS `成就潜力`
    from
        `t_dimension`

