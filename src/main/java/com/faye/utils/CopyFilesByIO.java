package com.faye.utils;

import java.io.*;

/**
 * @Author Faye F F HE
 * @Date 2019/1/8 21:05
 */
public class CopyFilesByIO {
    public static void main(String[] args) {
//        copyFileByRedirecting("pom.xml", "copyFileByRedi recting.txt");
//        copyFileByReaderAndWritter("pom.xml", "copyFileByReaderAndWritter.txt");
//        copyFileByInAndOutputStream("C:\\Users\\xiaomi\\Pictures\\结婚照.jpg", "copyFileByInAndOutputStream.jpg");

        File sourceFile = new File("C:\\Users\\xiaomi\\Documents\\My FTPRush Downloads");
        File destFile = new File("C:\\Users\\xiaomi\\Documents\\copies");
        copyFolder(sourceFile, destFile);
    }

    /**
     *
     * @param sourceFile 要被复制的源文件（文件夹）
     * @param destFile 目标路径（文件夹）
     */
    public static void copyFolder(File sourceFile, File destFile){
        File[] files = sourceFile.listFiles();

        if (files.length == 0) { //复制空文件夹
            destFile = new File(destFile.getPath() + File.separator + sourceFile.getName());
            System.out.println("copy empty folder " + sourceFile + "    to  " + destFile.getPath());
        }

        if (!destFile.exists()) destFile.mkdir();

        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory()){
                copyFolder(files[i], new File(destFile.getPath() + files[i].getPath().substring(sourceFile.getPath().length())));
            }else {
                copyFileByInAndOutputStream(files[i], new File(destFile.getPath() + File.separator + files[i].getName()));
            }
        }
    }

    /**
     *
     * @param source
     * @param dest
     *
     * 适用于复制文本文件
     */
    public static void copyFileByReaderAndWritter(File source, File dest){
        try {
            if (!dest.exists()) dest.createNewFile();
            BufferedReader in = new BufferedReader(new FileReader(source));
            BufferedWriter out = new BufferedWriter(new FileWriter(dest));

            String i;
            while ((i = in.readLine()) != null) {
                out.write(i);
                out.newLine();
            }

            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param source
     * @param dest
     *
     * 适用于复制非文本文件
     */
    public static void copyFileByInAndOutputStream(File source, File dest){
        try {
            if (!dest.exists()) dest.createNewFile();

            BufferedInputStream in = new BufferedInputStream(new FileInputStream(source));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest));

            int i;
            while ((i = in.read()) != -1) out.write(i);

            in.close();
            out.close();

            System.out.println("copy " + source.getPath() + "        to     " + dest.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFileByRedirecting(String source, String dest){
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(source));
            PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(dest)));

            System.setIn(in);
            System.setOut(out); // 重定向

            int i;
            while ((i = in.read()) != -1) System.out.write(i); // 重定向

            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
