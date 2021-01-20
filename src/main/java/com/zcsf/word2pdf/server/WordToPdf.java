package com.zcsf.word2pdf.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author ZXC
 * @Date 2021/1/20 11:35
 * @description
 */
@RestController
public class WordToPdf {

    Logger log = LoggerFactory.getLogger(WordToPdf.class);
    //调用python生成pdf
//    public static void main(String[] args){
//        long start = System.currentTimeMillis();
//        //docx文档路径 生成PDF的路径
//        String srcPath = "C:\\Users\\Administrator\\Desktop\\jfyxxy.docx", desPath = "C:\\Users\\Administrator\\Desktop\\create.pdf";
//        String command = "";
//        String osName = System.getProperty("os.name");
//        //py文件存放路径
//        String py = "C:\\Users\\Administrator\\PycharmProjects\\pythonProject\\wordToPdf.py";
//        try {
//            if (osName.contains("Windows")) {
//                command = "python " + py + " " + srcPath + " " + desPath;
////                doCmd(command);
//                final Process process = Runtime.getRuntime().exec(command);
//                System.out.println("start run cmd=" + command);
//                // 处理InputStream的线程
//                new Thread() {
//                    @Override
//                    public void run() {
//                        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
//                        String line = null;
//
//                        try {
//                            while ((line = in.readLine()) != null) {
//                                System.out.println("output: " + line);
//                            }
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        } finally {
//                            try {
//                                in.close();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                }.start();
//                new Thread() {
//                    @Override
//                    public void run() {
//                        BufferedReader err = new BufferedReader(new InputStreamReader(
//                                process.getErrorStream()));
//                        String line = null;
//
//                        try {
//                            while ((line = err.readLine()) != null) {
//                                System.out.println("err: " + line);
//                            }
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        } finally {
//                            try {
//                                err.close();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                }.start();
//
//                process.waitFor();
//                System.out.println("finish run cmd=" + command);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        long end = System.currentTimeMillis();
////        log.debug("用时:{} ms", end - start);
//    }




    //组装命令
    @GetMapping("/word2pdf")
    public void word2pdf(){
        long start = System.currentTimeMillis();
        //docx文档路径 生成PDF的路径
        String srcPath = "C:\\Users\\Administrator\\Desktop\\jfyxxy.docx", desPath = "C:\\Users\\Administrator\\Desktop\\create.pdf";
        String command = "";
        String osName = System.getProperty("os.name");
        //py文件存放路径
        String py = "C:\\Users\\Administrator\\PycharmProjects\\pythonProject\\wordToPdf.py";
        try {
            if (osName.contains("Windows")) {
                command = "python " + py + " " + srcPath + " " + desPath;
                doCmd(command);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        log.debug("用时:{} ms", end - start);
    }


    //执行命令
    public void doCmd(String cmd) throws Exception {
        final Process process = Runtime.getRuntime().exec(cmd);
//        System.out.println("start run cmd=" + cmd);
        log.info("start run cmd=" + cmd);
        // 处理InputStream的线程
        new Thread() {
            @Override
            public void run() {
                BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line = null;

                try {
                    while ((line = in.readLine()) != null) {
//                        System.out.println("output: " + line);
                        log.info("output: " + line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                BufferedReader err = new BufferedReader(new InputStreamReader(
                        process.getErrorStream()));
                String line = null;

                try {
                    while ((line = err.readLine()) != null) {
//                        System.out.println("err: " + line);
                        log.info("err: " + line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        err.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        process.waitFor();
        log.info("finish run cmd=" + cmd);
    }
}
