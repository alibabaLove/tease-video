# imooc-videos
java仿抖音短视频

名称:逗音

访问:http://localhost:8081/hello
GitHub:https://github.com/alibabaLove/tease-video
技术：
 1.SSM
 2.SpringBoot
 3.redis
 4.zookeeper&zk curator
    用于分布式云服务器之间的bgm自动下载，当客户在后台管理系统上传或者删除某个bgm后，会通知另外一台服务器去自动下载或删除
 5.mysql
 6.ffmpeg   
    视音频处理工具，比如视频合并，视频截取封面
 7.idworker 分布式id生成器
 8.swagger2  接口文档

-------------------------   
ffmpeg简介:
    文件上传
    @POSTMapping(value="upload",headers="content-type=multipart/form-data")
   
   1.介绍:视音频处理工具，跨平台
     主页:http://ffmpeg.org
     应用场景:
       1.播放器:暴风影音 
       2.转码工具:格式工厂,剪辑工具
       3.直播、视频加码、滤镜、水印、特效
     
   2.视频转换(有损)
     2.1>.命令行:
         windows:
           $ ffmpeg.exe -i input.mp4 output.avi
         linux:
           $ ffmpeg -i input.mp4 output.avi
     2.2>.java调用
       释放内存碎片 
     注意:视频和音频结合
          视频和音频不同时,以视频的长度为主
     2.3>.安装：
        windows:
            https://blog.csdn.net/chy466071353/article/details/54949221       
        linux:
            yum install
            https://www.cnblogs.com/wpjamer/p/ffmpeg.html
            #1.安装Nux Dextop Yum 源
            rpm --import http://li.nux.ro/download/nux/RPM-GPG-KEY-nux.ro
            wget https://mirrors.tuna.tsinghua.edu.cn/epel//7/x86_64/e/epel-release-7-9.noarch.rpm
            yum -y localinstall nux-dextop-release-0-5.el7.nux.noarch.rpm
            #2.安装FFmpeg 和 FFmpeg开发包
            yum install ffmpeg ffmpeg-devel -y
            #3.测试是否安装成功
            ffmpeg
            ffmpeg -h
-------------------------              
   腾讯云SpingBoot部署+HTTPS
    https://www.imooc.com/article/25673

-------------------------    
mysql5.7安装
 https://www.cnblogs.com/bigbrotherer/p/7241845.html

1 下载并安装MySQL官方的 Yum Repository
wget -i -c http://dev.mysql.com/get/mysql57-community-release-el7-10.noarch.rpm
yum -y install mysql57-community-release-el7-10.noarch.rpm
#安装MySQL服务器,安装完成后就会覆盖掉之前的mariad
yum -y install mysql-community-server
2 MySQL数据库设置
首先启动MySQL
systemctl start  mysqld.service
查看MySQL运行状态
systemctl status mysqld.service

报错,密码设置过于简单
ERROR 1819 (HY000): Your password does not satisfy the current policy requirements
解决办法:
https://blog.csdn.net/maxsky/article/details/51171474
set global validate_password_policy=0;  
set global validate_password_length=4;  

ALTER USER 'root'@'localhost' IDENTIFIED BY '12345678';

3.开启远程访问
update user set host = '%' where user = 'root';

需要重启服务
systemctl stop  mysqld.service
systemctl start  mysqld.service    
---------------------------------------------------
zookeeper安装
1.下载链接 
	http://mirrors.hust.edu.cn/apache/zookeeper/zookeeper-3.5.4-beta/zookeeper-3.5.4-beta.tar.gz
2.解压
	
3.配置
    {zookeeper_home}/conf/zoo_sample.cfg
    cp zoo_samp.conf zoo.cfg
    vi zoo.cfg
    dataDir=/usr/local/zookeeper/data
4.启动
   bin/zkServer.sh start
-------------------------------------------------------
抖音爬虫
    抖音短视频采集爬虫试用教程：如何设置用户ID
    https://www.shenjian.io/blog/?p=719
    分享个人名片->链接形式
    
    如何按分类批量采集抖音短视频？
    https://www.shenjian.io/blog/?p=920
    
    抖音个人主页
    https://www.douyin.com/share/user/98227575411/?share_type=link
    51445954443
    99783104932
    67869236014
    61628136351
    
    https://www.iesdouyin.com/share/video/6558310519202123012/?region=CN&mid=6548178255407483655&titleType=title&timestamp=1530283751&utm_campaign=client_share&app=aweme&utm_medium=ios&tt_from=copy&utm_source=copy&iid=36805703052
    
    nickname 昵称
    signature 个性签名
    author 用户头像 https://p3.pstatp.com/aweme/720x720/80e7000a6e22291f6d4e.jpeg
    
    SET NAMES utf8mb4;
    CREATE TABLE IF NOT EXISTS `task_1979314`(`id` int(11) NOT NULL AUTO_INCREMENT,`__time` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,`__url` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,`aweme_id` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,`user_id` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,`thumbnail` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,`user_name` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,`unique_id` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,`qualification` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,`location` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,`constellation` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,`focus` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,`follower` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,`liked_num` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,`publish_time` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,`video_img` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,`desc` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,`comment_count` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,`digg_count` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,`play_count` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,`share_count` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,`width` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,`height` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,`video_url` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci, PRIMARY KEY (`id`)) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;
    
    #状态 待发布 数据版本 视频id 用户id 头像 用户名 抖音id  认证 位置 星座 关注数 作者粉丝数 作者点赞数 发布时间 视频图像 描述 评论数量 点赞数量 播放数量 分享数量 宽 高 视频url
    INSERT INTO `task_1979314` (`__time`,`__url`,`aweme_id`,`user_id`,`thumbnail`,`user_name`,`unique_id`,`qualification`,`location`,`constellation`,`focus`,`follower`,`liked_num`,`publish_time`,`video_img`,`desc`,`comment_count`,`digg_count`,`play_count`,`share_count`,`width`,`height`,`video_url`) VALUES ('2018-06-29 23:01:43','https://www.douyin.com/aweme/v1/aweme/post/?user_id=98227575411&count=21&max_cursor=0&aid=1128&_signature=-Qn1JAAAokkG9grbePjYvPkJ9T#20','6568816979698781454','98227575411','https://p3.pstatp.com/aweme/720x720/887600086ab884c8a3a0.jpeg','王者秀','','','重庆','金牛座','2','35.7w','595.9w','1529421892','https://p1.pstatp.com/large/8fe1000b0c725770a6cc.jpg','1打5被抢五杀，心塞～','462','1.1w','67.3w','220','1024','576','https://aweme.snssdk.com/aweme/v1/playwm/?video_id=v0200ff70000bcki0f9dli3m0gv0ve90&line=0');
    INSERT INTO `task_1979314` (`__time`,`__url`,`aweme_id`,`user_id`,`thumbnail`,`user_name`,`unique_id`,`qualification`,`location`,`constellation`,`focus`,`follower`,`liked_num`,`publish_time`,`video_img`,`desc`,`comment_count`,`digg_count`,`play_count`,`share_count`,`width`,`height`,`video_url`) VALUES ('2018-06-29 23:01:43','https://www.douyin.com/aweme/v1/aweme/post/?user_id=98227575411&count=21&max_cursor=0&aid=1128&_signature=-Qn1JAAAokkG9grbePjYvPkJ9T#19','6568818656828984589','98227575411','https://p3.pstatp.com/aweme/720x720/887600086ab884c8a3a0.jpeg','王者秀','','','重庆','金牛座','2','35.7w','595.9w','1529422284','https://p3.pstatp.com/large/8fdf000fd5b9f32a9ebb.jpg','铭文：狩猎、心眼、红月   出装：法野刀、抵抗鞋、吸血书、极寒风暴、痛苦面具、辉月','1782','5.6w','215.7w','984','1024','576','https://aweme.snssdk.com/aweme/v1/playwm/?video_id=v0200ff50000bcki3gockqbl35m90dk0&line=0');
    INSERT INTO `task_1979314` (`__time`,`__url`,`aweme_id`,`user_id`,`thumbnail`,`user_name`,`unique_id`,`qualification`,`location`,`constellation`,`focus`,`follower`,`liked_num`,`publish_time`,`video_img`,`desc`,`comment_count`,`digg_count`,`play_count`,`share_count`,`width`,`height`,`video_url`) VALUES ('2018-06-29 23:01:43','https://www.douyin.com/aweme/v1/aweme/post/?user_id=98227575411&count=21&max_cursor=0&aid=1128&_signature=-Qn1JAAAokkG9grbePjYvPkJ9T#18','6569175603847630087','98227575411','https://p3.pstatp.com/aweme/720x720/887600086ab884c8a3a0.jpeg','王者秀','','','重庆','金牛座','2','35.7w','595.9w','1529505399','https://p3.pstatp.com/large/90170010741514f41145.jpg','星耀局排位，这张飞真可爱！','433','2.8w','59.9w','75','1024','576','https://aweme.snssdk.com/aweme/v1/playwm/?video_id=v0200f9e0000bcl6ci3rm1n32m8af8r0&line=0');
    INSERT INTO `task_1979314` (`__time`,`__url`,`aweme_id`,`user_id`,`thumbnail`,`user_name`,`unique_id`,`qualification`,`location`,`constellation`,`focus`,`follower`,`liked_num`,`publish_time`,`video_img`,`desc`,`comment_count`,`digg_count`,`play_count`,`share_count`,`width`,`height`,`video_url`) VALUES ('2018-06-29 23:01:43','https://www.douyin.com/aweme/v1/aweme/post/?user_id=98227575411&count=21&max_cursor=0&aid=1128&_signature=-Qn1JAAAokkG9grbePjYvPkJ9T#17','6569182235939835144','98227575411','https://p3.pstatp.com/aweme/720x720/887600086ab884c8a3a0.jpeg','王者秀','','','重庆','金牛座','2','35.7w','595.9w','1529506939','https://p3.pstatp.com/large/901c0000882a6e47e034.jpg','你们最喜欢的英雄是谁？','319','7152','21.7w','246','1024','576','https://aweme.snssdk.com/aweme/v1/playwm/?video_id=v0200f9e0000bcl6olt2v32fcs6la9cg&line=0');
    INSERT INTO `task_1979314` (`__time`,`__url`,`aweme_id`,`user_id`,`thumbnail`,`user_name`,`unique_id`,`qualification`,`location`,`constellation`,`focus`,`follower`,`liked_num`,`publish_time`,`video_img`,`desc`,`comment_count`,`digg_count`,`play_count`,`share_count`,`width`,`height`,`video_url`) VALUES ('2018-06-29 23:01:43','https://www.douyin.com/aweme/v1/aweme/post/?user_id=98227575411&count=21&max_cursor=0&aid=1128&_signature=-Qn1JAAAokkG9grbePjYvPkJ9T#16','6569550872114629901','98227575411','https://p3.pstatp.com/aweme/720x720/887600086ab884c8a3a0.jpeg','王者秀','','','重庆','金牛座','2','35.7w','595.9w','1529592764','https://p3.pstatp.com/large/91320007e39cce48b2b2.jpg','一猴我饮酒醉','165','8196','14.8w','475','1024','576','https://aweme.snssdk.com/aweme/v1/playwm/?video_id=v0200f7b0000bclrmvj82vufbm6c9llg&line=0');
    INSERT INTO `task_1979314` (`__time`,`__url`,`aweme_id`,`user_id`,`thumbnail`,`user_name`,`unique_id`,`qualification`,`location`,`constellation`,`focus`,`follower`,`liked_num`,`publish_time`,`video_img`,`desc`,`comment_count`,`digg_count`,`play_count`,`share_count`,`width`,`height`,`video_url`) VALUES ('2018-06-29 23:01:42','https://www.douyin.com/aweme/v1/aweme/post/?user_id=98227575411&count=21&max_cursor=0&aid=1128&_signature=-Qn1JAAAokkG9grbePjYvPkJ9T#15','6569564520983825672','98227575411','https://p3.pstatp.com/aweme/720x720/887600086ab884c8a3a0.jpeg','王者秀','','','重庆','金牛座','2','35.7w','595.9w','1529595940','https://p9.pstatp.com/large/913400080bbe8d9b7607.jpg','铭文：轮回 心眼 梦魇 出装：抵抗鞋 噬神之书 回响之杖 法帽  痛苦面具 辉月','187','1.2w','45.7w','164','1024','576','https://aweme.snssdk.com/aweme/v1/playwm/?video_id=v0200f7b0000bclsg5b6936r3in22rfg&line=0');
    INSERT INTO `task_1979314` (`__time`,`__url`,`aweme_id`,`user_id`,`thumbnail`,`user_name`,`unique_id`,`qualification`,`location`,`constellation`,`focus`,`follower`,`liked_num`,`publish_time`,`video_img`,`desc`,`comment_count`,`digg_count`,`play_count`,`share_count`,`width`,`height`,`video_url`) VALUES ('2018-06-29 23:01:42','https://www.douyin.com/aweme/v1/aweme/post/?user_id=98227575411&count=21&max_cursor=0&aid=1128&_signature=-Qn1JAAAokkG9grbePjYvPkJ9T#14','6569925190296276231','98227575411','https://p3.pstatp.com/aweme/720x720/887600086ab884c8a3a0.jpeg','王者秀','','','重庆','金牛座','2','35.7w','595.9w','1529679911','https://p3.pstatp.com/large/916d00120f2023db9aa2.jpg','一个终结 优秀','1323','2.5w','69.3w','448','1024','576','https://aweme.snssdk.com/aweme/v1/playwm/?video_id=v0200f7b0000bcmh07rcp23a6c4vcss0&line=0');
    INSERT INTO `task_1979314` (`__time`,`__url`,`aweme_id`,`user_id`,`thumbnail`,`user_name`,`unique_id`,`qualification`,`location`,`constellation`,`focus`,`follower`,`liked_num`,`publish_time`,`video_img`,`desc`,`comment_count`,`digg_count`,`play_count`,`share_count`,`width`,`height`,`video_url`) VALUES ('2018-06-29 23:01:42','https://www.douyin.com/aweme/v1/aweme/post/?user_id=98227575411&count=21&max_cursor=0&aid=1128&_signature=-Qn1JAAAokkG9grbePjYvPkJ9T#13','6570308129773325575','98227575411','https://p3.pstatp.com/aweme/720x720/887600086ab884c8a3a0.jpeg','王者秀','','','重庆','金牛座','2','35.7w','595.9w','1529769084','https://p3.pstatp.com/large/91bb000b612d7d3b97a0.jpg','有谁可以单挑过典韦？','2318','5794','26.6w','53','1024','576','https://aweme.snssdk.com/aweme/v1/playwm/?video_id=v0200f7b0000bcn6oobd82djlr11n0hg&line=0');
    INSERT INTO `task_1979314` (`__time`,`__url`,`aweme_id`,`user_id`,`thumbnail`,`user_name`,`unique_id`,`qualification`,`location`,`constellation`,`focus`,`follower`,`liked_num`,`publish_time`,`video_img`,`desc`,`comment_count`,`digg_count`,`play_count`,`share_count`,`width`,`height`,`video_url`) VALUES ('2018-06-29 23:01:42','https://www.douyin.com/aweme/v1/aweme/post/?user_id=98227575411&count=21&max_cursor=0&aid=1128&_signature=-Qn1JAAAokkG9grbePjYvPkJ9T#12','6570662894172638468','98227575411','https://p3.pstatp.com/aweme/720x720/887600086ab884c8a3a0.jpeg','王者秀','','','重庆','金牛座','2','35.7w','595.9w','1529851671','https://p3.pstatp.com/large/92000011bb1c060ad63e.jpg','排位10连跪','1446','4.9w','69.9w','361','1024','576','https://aweme.snssdk.com/aweme/v1/playwm/?video_id=v0200f5b0000bcnqu0ikr6g3j4dpc4fg&line=0');
    INSERT INTO `task_1979314` (`__time`,`__url`,`aweme_id`,`user_id`,`thumbnail`,`user_name`,`unique_id`,`qualification`,`location`,`constellation`,`focus`,`follower`,`liked_num`,`publish_time`,`video_img`,`desc`,`comment_count`,`digg_count`,`play_count`,`share_count`,`width`,`height`,`video_url`) VALUES ('2018-06-29 23:01:42','https://www.douyin.com/aweme/v1/aweme/post/?user_id=98227575411&count=21&max_cursor=0&aid=1128&_signature=-Qn1JAAAokkG9grbePjYvPkJ9T#11','6570673082577456388','98227575411','https://p3.pstatp.com/aweme/720x720/887600086ab884c8a3a0.jpeg','王者秀','','','重庆','金牛座','2','35.7w','595.9w','1529854044','https://p3.pstatp.com/large/9206000bd9ea8e5c3627.jpg','大家说说亚瑟此时有多绝望？','4472','14.5w','601.2w','2248','1024','576','https://aweme.snssdk.com/aweme/v1/playwm/?video_id=v0200fd80000bcnrgktjfrmgv2if7be0&line=0');
-------------------------     
产品原型图:
    https://www.xiaopiu.com/h5/byId?type=project&id=59f1cce4e7485455c20eb9a8            
逗音待实现的功能：
 1.登录:
  先调用小程序的登录,如果wx_opentId不存在,则注册时(使用默认的头像、逗音号)
  如果未绑定手机,则需要用户输入手机号码,验证码60秒内有效
 2.首页
    2.1>.浏览视频
        关注/推荐/附近
    2.2>.点赞/取消点赞    
    2.3>.评论/删除评论
    2.4>.举报视频
    2.5>.访问别人的主页-点击头像
        私信(关注对方&未被对方拉黑)
        关注
        打赏
            微信支付,必须先实名制&成年人
 3.上传:
     3.1>.视频(最短1秒,最长2分钟)
     3.2>.滤镜、道具
     3.3>.选择音乐
        搜索相关音乐内容
        选择音乐类型(两排，点击更多，展开)
        自己上传音乐
        我的收藏           
 4.消息  
    4.1>.系统推送
    4.2>.私信
    4.3>.关注&点赞&打赏
    4.4>.邀请好友
 5.搜索    
    音乐搜索
    逗音号搜索
    热搜
    搜索记录
 6.我的-个人中心
    1>.显示-获赞数、关注数、粉丝数
        点击查看详情
    2>.作品、喜欢
       作品可以删除
       点赞即为喜欢
    3>.意见反馈
    4>.邀请好友
    5>.个人资料修改
       头像、昵称、性别、生日、签名
  