package com.zhaomeng;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author: zhaomeng
 * @Date: 2022/10/8 15:45
 */
// !利用多线程下载网络图片
public class TestThread02 extends Thread {

    private String url; // !网络图片地址
    private String name; // !本地保存的文件名

    public TestThread02(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        try {
            webDownloader.downloader(url, name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("下载了文件名为："+name);
    }

    public static void main(String[] args) {
        TestThread02 t1 = new TestThread02("https://img-blog.csdnimg.cn/img_convert/95b6af184f7eca312f71a38d0183f80b.png", "1.jpg");
        TestThread02 t2 = new TestThread02("https://img-blog.csdnimg.cn/img_convert/769ec434b8b7ddae9d35ce3dc77c2c68.png", "2.jpg");

        t1.start();
        t2.start();
    }

    class WebDownloader {
        public void downloader(String url, String name) throws IOException {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        }
    }
}
