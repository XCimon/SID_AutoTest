package com.example.demo;

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @Author: Cirmons
 * @Date: 2022-11-08
 */
public class CompressTest {
    
    public static final String srcFile = "/Users/xupeng/Desktop/demo/cmd.txt";
    public static final String srcDir = "/Users/xupeng/Desktop/demo/dir0";
    public static final String targetDir = "/Users/xupeng/Desktop/demo/target";
    
    @Test
    public void compress7z_file(){
        try {
            SevenZOutputFile sevenZOutput = new SevenZOutputFile(FileUtils.getFile("/Users/xupeng/Desktop/demo/target","cmd.txt.7z"));
            
            SevenZArchiveEntry entry = sevenZOutput.createArchiveEntry(FileUtils.getFile("/Users/xupeng/Desktop/demo/cmd.txt"), "foo");
            sevenZOutput.putArchiveEntry(entry);
            sevenZOutput.write(FileUtils.readFileToByteArray(FileUtils.getFile("/Users/xupeng/Desktop/demo/cmd.txt")));
            sevenZOutput.closeArchiveEntry();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    
      
        
    }
    
    
    @Test
    public void un7z(){
        try {
            SevenZFile sevenZFile = new SevenZFile(new File("/Users/xupeng/Desktop/demo/target/cmd.txt.7z"));
        
            final Iterable<SevenZArchiveEntry> entries = sevenZFile.getEntries();
            for (SevenZArchiveEntry entry : entries) {
                System.out.println(entry.getName());
//                System.out.println(entry.getCompressedSize()); // 文件压缩后大小
                System.out.println(entry.getSize()); // 文件大小
            }
        
            System.out.println(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    
    
    
    
    
    
}
