/*
 * Crystal McDonald
 * Java 1 1302
 * Week 3
 */
package com.cmcdonald.lib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

//build functionality to connect to a website and pull data back and text for internet connection
public class WebStuff {

	static Boolean _conn = false; //always assume there's no connection
	static String _connectionType = "Unavailable";
	
	public static String getConnnectionType(Context context){
		netInfo(context);
		return _connectionType;
	}
	
	public static Boolean getConnectionStatus(Context context){
		netInfo(context);
		return _conn;
	}
	
	//test internet connection on android device
	private static void netInfo(Context context){
		//creating 2 values representing if connected and what type of connection
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();
		if(ni != null){
			if(ni.isConnected()){
				_connectionType = ni.getTypeName();
				_conn = true;
				}
			}
		}
}
