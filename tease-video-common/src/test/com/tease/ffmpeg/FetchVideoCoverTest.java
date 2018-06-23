package com.tease.ffmpeg;

import com.imooc.utils.FetchVideoCover;

/**
 * 测试 获取视频信息
 */
public class FetchVideoCoverTest {
    /**
     * 视频转化为封面图
     * @param args
     */
    public static void main(String[] args) {
        // 获取视频信息。
        FetchVideoCover videoInfo = new FetchVideoCover("C:\\Program Files (x86)\\ffmpeg\\bin\\ffmpeg.exe");
        try {
            videoInfo.getCover("C:\\study\\慕课网java仿抖音实战\\第1章 千呼万唤史出来，微信小程序的简要学习\\1,4.mp4","c:\\北京.jpg");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
