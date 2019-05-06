package com.faye.utils;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Author Faye F F HE
 * @Date 2019/1/8 22:47
 */
public class ZipAndUnzip {
    private static String baseSrcPath;

    public static void main(String[] args) {
        String srcPath = "C:\\Users\\xiaomi\\Documents\\copies2";
        zip(srcPath, srcPath + ".zip");
    }

    public static void zip(String srcFilePath, String destFilePath) {
        baseSrcPath = srcFilePath;
        File src = new File(srcFilePath);

        try {
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File(destFilePath)));
            if (src.isDirectory()){
                zipFolder(src, zos);
            }else {
                zipSingleFile(src, zos);
            }

            zos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 压缩文件夹
     */
    private static void zipFolder(File dir, ZipOutputStream zos) {
        File[] files = dir.listFiles();

        try {
            for (File file : files) {
                if (file.isDirectory()) {
                    zos.putNextEntry(new ZipEntry(file.getName() + File.separator));
                    zipFolder(file, zos);
                }else {
                    zipFile(file, zos);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 压缩文件
     */
    private static void zipFile(File sourceFile, ZipOutputStream zos) {
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(sourceFile));
            zos.putNextEntry(new ZipEntry(sourceFile.getPath().substring(baseSrcPath.length() + 1)));
            int count;
            byte[] buf = new byte[1024];
            while ((count = in.read(buf)) != -1) {
                zos.write(buf, 0, count);
            }
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void zipSingleFile(File sourceFile, ZipOutputStream zos) {
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(sourceFile));
            zos.putNextEntry(new ZipEntry(sourceFile.getName()));
            int count;
            while ((count = in.read()) != -1) {zos.write(count); }
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
