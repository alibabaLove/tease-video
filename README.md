# imooc-videos
java仿抖音短视频

名称:逗音

访问:http://localhost:8081/hello

逗音实现的功能：
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
  