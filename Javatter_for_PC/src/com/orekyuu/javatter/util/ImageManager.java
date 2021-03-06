package com.orekyuu.javatter.util;

import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

/**
 * 画像管理クラス
 * @author orekyuu
 *
 */
public class ImageManager {

	private static Map<String,Image> map=new HashMap<String,Image>();
	private static Class<? extends ImageManager> clazz;
	/**
	 * Javatterのアイコン
	 */
	public static final String ICON="javatter";
	/**
	 * プレビューの画像
	 */
	public static final String PREVIEW = "preview";
	private static ImageManager instance=new ImageManager();

	private ImageManager(){
		clazz=getClass();
		load();
	}

	private void load(){
		map.put(ICON, loadImage("javatter.png"));
		map.put(PREVIEW, loadImage("preview.png"));
	}

	private Image loadImage(String path){
		try {
			return ImageIO.read(clazz.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 画像を取得
	 * @param s 画像を取り出すためのキー
	 * @return
	 */
	public Image getImage(String s){
		return map.get(s);
	}

	/**
	 * インスタンスを取得
	 * @return
	 */
	public static ImageManager getInstance(){
		return instance;
	}
}
