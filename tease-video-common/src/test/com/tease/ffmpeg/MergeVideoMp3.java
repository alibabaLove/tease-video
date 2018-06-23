package com.tease.ffmpeg;

public class MergeVideoMp3 {
    public static void main(String[] args) {
        com.imooc.utils.MergeVideoMp3 ffmpeg = new com.imooc.utils.MergeVideoMp3("C:\\ffmpeg\\bin\\ffmpeg.exe");
        try {
            ffmpeg.convertor("C:\\苏州大裤衩.mp4", "C:\\music.mp3", 7.1, "C:\\这是通过java生产的视频.mp4");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
