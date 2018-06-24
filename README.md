# imooc-videos
java仿抖音短视频

名称:逗音

访问:http://localhost:8081/hello

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
   腾讯云SpingBoot部署+HTTPS
    https://www.imooc.com/article/25673

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
  