package com.coloro.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

/**
 * 提示信息工具类
 * @author Administrator
 *
 */
public class MessageUtils {

	public static void showProgressDialog(Activity activity) {
		ProgressDialog.show(activity, "", "正在加载...", true, true).show();
	}

	/**
	 * 提示信息-时间短
	 * 
	 * @param context
	 * @param message
	 */
	public static void shortToast(Context context, String message) {
		Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}

	/**
	 * 提示信息-时间短
	 * 
	 * @param context
	 * @param message
	 */
	public static void shortToast(Context context, String message, boolean isShow) {
		if (isShow) {
			Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * 提示信息-时间长
	 * 
	 * @param context
	 * @param message
	 */
	public static void longToast(Context context, String message) {
		Toast.makeText(context, message, Toast.LENGTH_LONG).show();
	}

	/**
	 * 确认/取消对话框
	 * 
	 * @param context
	 * @param message
	 */
	public static void ConfirmCancelDialog(Context context, String message) {

	}

	/**
	 * 确认对话框
	 * 
	 * @param context
	 * @param message
	 */
	public static void ConfirmAlertDialog(Context context, String message) {
		MessageUtils.ConfirmAlertDialog(context, "提示", message);
	}

	/**
	 * 确认对话框
	 * 
	 * @param context
	 * @param title
	 * @param message
	 */
	public static void ConfirmAlertDialog(Context context, String title, String message) {
		new AlertDialog.Builder(context).setTitle(title).setMessage(message).setPositiveButton("确定", null).show();
	}
}
