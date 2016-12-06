package com.zeyu.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class GetImageFromVedio {

	private static String mencoder_home = "D:\\videoconvert\\mencoder.exe";// mencoder.exe所放的路径
	private static String ffmpeg_home = "D:\\videoconvert\\ffmpeg.exe";// ffmpeg.exe所放的路径

	public static String processImg(String str) {
		List<String> commend = new java.util.ArrayList<String>();
		commend.add("\"D:\\videoconvert\\ffmpeg.exe\"");
		commend.add("-i");
		commend.add("\"" + str + "\"");
		commend.add("-y");
		commend.add("-f");
		commend.add("image2");
		commend.add("-ss");
		commend.add("5");
		commend.add("-t");
		commend.add("0.001");
		commend.add("-s");
		commend.add("320x240");
		int index = str.lastIndexOf(".");
		String temp = str.substring(0, index);
		commend.add("\"" + temp + ".jpg\"");

		try {
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(commend);
			builder.start();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return temp + ".jpg";
	}

	public static String convert(final String inputFile) {
		int index = inputFile.lastIndexOf(".");
		// 取出文件后缀
		String type = inputFile.substring(index + 1, inputFile.length());
		// 文件名部分（不包含后缀名）
		final String fileName = inputFile.substring(0, index);
		
		if (type.equalsIgnoreCase("swf") || type.equalsIgnoreCase("flv")
				|| type.equalsIgnoreCase("mp4")) {
			return inputFile;
		} else if (type.equalsIgnoreCase("asx") || type.equalsIgnoreCase("asf")
				|| type.equalsIgnoreCase("mpg") || type.equalsIgnoreCase("wmv")
				|| type.equalsIgnoreCase("3gp") || type.equalsIgnoreCase("mov")
				|| type.equalsIgnoreCase("avi")) {
			new Thread(){
				public void run(){
					processFLV(inputFile, fileName + ".flv");					
				}
			}.start();
			return fileName+".flv";
		} else if (type.equalsIgnoreCase("wmv9") || type.equalsIgnoreCase("rm")
				|| type.equalsIgnoreCase("rmvb")){
			new Thread(){
				public void run(){
					processAVI(inputFile,fileName + ".avi");
					processFLV(fileName + ".avi",fileName + ".flv");					
				}
			}.start();

			return fileName+".flv";
		} else {
			return null;
		}
	}

	public static void main(String args[]) {
//		String str = "D:\\videoconvert\\input\\1.wmv";
//		processImg(str);
		String str = "D:\\videoconvert\\input\\DuShengcd999.rmvb";
		convert(str);
	}

	/**
	 * ffmepg: 能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
	 * 
	 * @param inputFile
	 * @param outputFile
	 * @return
	 */
	private static boolean processFLV(String inputFile, String outputFile) {
		List<String> commend = new java.util.ArrayList<String>();
		// 低精度
		commend.add(ffmpeg_home);
		commend.add("-i");
		commend.add(inputFile);
		commend.add("-ab");
		commend.add("128");
		commend.add("-acodec");
		commend.add("libmp3lame");
		commend.add("-ac");
		commend.add("1");
		commend.add("-ar");
		commend.add("22050");
		commend.add("-r");
		commend.add("29.97");
		// 清晰度 -qscale 4 为最好但文件大, -qscale 6就可以了
		commend.add("-qscale");
		commend.add("4");
		commend.add("-y");
		commend.add(outputFile);

		try {
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(commend);
			Process p = builder.start();
			final InputStream is1 = p.getInputStream();
			final InputStream is2 = p.getErrorStream();
			new Thread() {
				public void run() {
					BufferedReader br = new BufferedReader(
							new InputStreamReader(is1));
					try {
						String lineB = null;
						while ((lineB = br.readLine()) != null) {
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}.start();
			new Thread() {
				public void run() {
					BufferedReader br2 = new BufferedReader(
							new InputStreamReader(is2));
					try {
						String lineC = null;
						while ((lineC = br2.readLine()) != null) {
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
			}.start();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	/**
	 * Mencoder:
	 * 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等),可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
	 * 
	 * @param type
	 * @param inputFile
	 * @return
	 */
	public static void processAVI(String inputFile, String outputFile) {
		List<String> commend = new java.util.ArrayList<String>();
		commend.add(mencoder_home);
		commend.add(inputFile);
		commend.add("-oac");
		commend.add("mp3lame");
		commend.add("-lameopts");
		commend.add("preset=64");
		commend.add("-ovc");
		commend.add("xvid");
		commend.add("-xvidencopts");
		commend.add("bitrate=600");
		commend.add("-of");
		commend.add("avi");
		commend.add("-o");
		commend.add(outputFile);
		try {
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(commend);
			Process p = builder.start();
			/**
			 * 清空Mencoder进程 的输出流和错误流 因为有些本机平台仅针对标准输入和输出流提供有限的缓冲区大小，
			 * 如果读写子进程的输出流或输入流迅速出现失败，则可能导致子进程阻塞，甚至产生死锁。
			 */
			final InputStream is1 = p.getInputStream();
			final InputStream is2 = p.getErrorStream();
			
			final class Controller{
				boolean ok1 = false;
				boolean ok2 = false;
			}
			final Controller c = new Controller();
			new Thread() {
				public void run() {
					BufferedReader br = new BufferedReader(
							new InputStreamReader(is1));
					try {
						Thread.sleep(10000);
						String lineB = null;
						while ((lineB = br.readLine()) != null) {
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					c.ok1 = true;
				}
			}.start();
			new Thread() {
				public void run() {
					BufferedReader br2 = new BufferedReader(
							new InputStreamReader(is2));
					try {
						Thread.sleep(10000);
						String lineC = null;
						while ((lineC = br2.readLine()) != null) {
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					c.ok2 = true;
				}
			}.start();

			while(true){
				try{
					Thread.sleep(10000);
					if(c.ok1 && c.ok2){
						break;
					}
				}catch(Exception e){}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}