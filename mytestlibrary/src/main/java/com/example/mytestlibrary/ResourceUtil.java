package com.example.mytestlibrary;

import android.content.Context;

public class ResourceUtil {

	/**
	 * @param paramContext
	 * @param paramString
	 * @return 获取R.layout.xxx
	 */
	public static int getLayoutId(Context paramContext, String paramString) {
		return paramContext.getResources().getIdentifier(paramString, "layout", paramContext.getPackageName());
	}

	/**
	 * @param paramContext
	 * @param paramString
	 * @return 获取R.string.xxx
	 */
	public static int getStringId(Context paramContext, String paramString) {
		return paramContext.getResources().getIdentifier(paramString, "string", paramContext.getPackageName());
	}

	/**
	 * @param paramContext
	 * @param paramString
	 * @return 获取R.drawable.xxx
	 */
	public static int getDrawableId(Context paramContext, String paramString) {
		return paramContext.getResources().getIdentifier(paramString, "drawable", paramContext.getPackageName());
	}

	/**
	 * @param paramContext
	 * @param paramString
	 * @return 获取R.style.xxx
	 */
	public static int getStyleId(Context paramContext, String paramString) {
		return paramContext.getResources().getIdentifier(paramString, "style", paramContext.getPackageName());
	}

	/**
	 * @param paramContext
	 * @param paramString
	 * @return 获取R.id.xxx
	 */
	public static int getId(Context paramContext, String paramString) {
		return paramContext.getResources().getIdentifier(paramString, "id", paramContext.getPackageName());
	}

	/**
	 * @param paramContext
	 * @param paramString
	 * @return 获取R.color.xxx
	 */
	public static int getColorId(Context paramContext, String paramString) {
		return paramContext.getResources().getIdentifier(paramString, "color", paramContext.getPackageName());
	}

	/**
	 * @param paramContext
	 * @param paramString
	 * @return 获取R.array.xxx
	 */
	public static int getArrayId(Context paramContext, String paramString) {
		return paramContext.getResources().getIdentifier(paramString, "array", paramContext.getPackageName());
	}

	/**
	 * @param paramContext
	 * @param paramString
	 * @return 获取R.attr.xxx
	 */
	public static int getAttrId(Context paramContext, String paramString) {
		return paramContext.getResources().getIdentifier(paramString, "attr", paramContext.getPackageName());
	}
	
	/**
	 * @param paramContext
	 * @param attrsStr
	 * @return	获得原本是declare-styleable，但是现在去掉这个标签，把所有attr属性值组成一个int[]的数组 
	 */
	public static int[] getDeclareStybleId(Context paramContext,String[] attrsStr) {
		int[] decStybleId = new int[attrsStr.length];
		for (int i = 0; i < attrsStr.length; i++) {
			decStybleId[i] = getAttrId(paramContext, attrsStr[i]);
		}
		return decStybleId;
	}
	
	/**
	 * @param attrsStr
	 * @param attr
	 * @return 获取原本是在declare-styleable下面的attr属性的index值
	 */
	public static int getDeclareAttrIndex(String[] attrsStr,String attr) {
		int index = -1;
		for (int i = 0; i < attrsStr.length; i++) {
			if (attr.equals(attrsStr[i])) {
				index = i;
			}
		}
		return index;
	}
}