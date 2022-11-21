package com.zhaomeng;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @author: zhaomeng
 * @Date: 2022/10/8 16:43
 */
// !线程创建：实现callable接口
    // !可以定义返回值
    // !可以抛出异常
public class TestThread06 implements Callable<Boolean> {

    private String url; // !网络图片地址
    private String name; // !本地保存的文件名

    public TestThread06(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        try {
            webDownloader.downloader(url, name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("下载了文件名为："+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestThread06 t1 = new TestThread06("https://img-blog.csdnimg.cn/img_convert/95b6af184f7eca312f71a38d0183f80b.png", "1.jpg");
        TestThread06 t2 = new TestThread06("https://img-blog.csdnimg.cn/img_convert/769ec434b8b7ddae9d35ce3dc77c2c68.png", "2.jpg");

        // !创建执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // !提交执行
        Future<Boolean> r1 = executorService.submit(t1);
        Future<Boolean> r2 = executorService.submit(t2);

        // !获取结果
        Boolean rs1 = r1.get();
        Boolean rs2 = r2.get();

        // !关闭服务
        executorService.shutdown();
    }

    class WebDownloader {
        public void downloader(String url, String name) throws IOException {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        }
    }
}
