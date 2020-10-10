package com.bay.lib;
import android.content.*;
import android.util.*;
import android.content.res.*;
import android.os.*;
import android.content.pm.*;
import androidx.core.app.*;
import android.*;
import android.app.*;

public class Utils {
	Context context;
	public Utils(Context c){
		context = c;
	}
	public  boolean isStoragePermissionGranted() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (context.checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
				return true;
			} else {
				ActivityCompat.requestPermissions((Activity)context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
				return false;
			}
		}
		else {
			return true;
		}
	}
	
}
