package com.psylife.util;

import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.psylife.common.Constant;

public class Util {

	public static String genRandomName(String prefix) {
		UUID uuid = UUID.randomUUID();
		return uuid.toString() + prefix;
	}
	
	private static String getLastName(String fileName) {
		int pos = fileName.lastIndexOf("\\");
		if (pos > -1) {
			fileName = fileName.substring(pos + 1);
		}
		pos = fileName.lastIndexOf("/");
		if (pos > -1) {
			fileName = fileName.substring(pos + 1);
		}
		return fileName;
	}

	public static void ReadAllFile(List<File> list, String filePath) {
		File f = null;
		f = new File(filePath);
		File[] files = f.listFiles(); // 得到f文件夹下面的所有文件。

		for (File file : files) {
			if (file.isDirectory()) {
				// 如何当前路劲是文件夹，则循环读取这个文件夹下的所有文件
				ReadAllFile(list, file.getAbsolutePath());
			} else {
				list.add(file);
			}
		}
	}

	public static String GenAvatar()
	{
		String avatar;
		int max=Constant.MAX_AVATAR;
        int min=1;
        Random random = new Random();

        int s = random.nextInt(max)%(max-min+1) + min;
        avatar = "../img/avatar/" + String.valueOf(s)+".jpg";
		return avatar;
	}

	public static void main(String[] args) {

	}
}
