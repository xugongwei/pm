package cn.ibona.pm.util;

import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;

import java.io.File;

/**
 * Git工具类
 */
public class JGitUtil {
    /**
     * 根据git地址克隆项目
     *
     * @param url       git项目
     * @param localPath 本地路径
     */
    public static String cloneRepository(String url, String localPath) {
        try {
            System.out.println("开始下载......");

            CloneCommand cc = Git.cloneRepository().setURI(url);
            cc.setDirectory(new File(localPath)).call();

            System.out.println("下载完成......");

            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}