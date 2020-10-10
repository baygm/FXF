package com.bay.fxf;
import android.content.*;
import android.os.*;
import java.net.*;
import java.io.*;
import android.app.*;
import okhttp3.*;
import android.widget.*;
import com.bay.lib.*;

public class Api
{
	Context context;
	public Api(Context ctx){
		this.context = ctx;
	}
	public void injectAntena(String data,final String msg){
	class getAntena extends AsyncTask<String,String,String>
	{
		private ProgressDialog pDialog;
		boolean success = false;
		@Override
		protected void onPreExecute(){
			pDialog = new ProgressDialog(context);
            pDialog.setMessage(Decryptor.Run(Strings.Loading));
            pDialog.setIndeterminate(false);
            pDialog.setMax(100);
            pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pDialog.setCancelable(true);
            pDialog.show();
		}
		@Override
		protected String doInBackground(String[] p1)
		{
			int count;
			
			OkHttpClient client = new OkHttpClient();
            try {
                URL url = new URL(p1[0]);
				Request request = new Request.Builder()
					.url(url)
					.build();
				Call call = client.newCall(request);
				Response response = call.execute();
				int isSucces = response.code();
				
				if(isSucces == 200){
					success = true;
				}
				
                URLConnection connection = url.openConnection();
                connection.connect();
				
                int lenghtOfFile = connection.getContentLength();
                InputStream input = new BufferedInputStream(url.openStream(),
														8192);
                OutputStream output = new FileOutputStream(Environment
														   .getExternalStorageDirectory().toString()
														   + Decryptor.Run(Strings.path));
                byte data[] = new byte[1024];
                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    publishProgress("" + (int) ((total * 100) / lenghtOfFile));
                    output.write(data, 0, count);
                }
                output.flush();
                output.close();
                input.close();

            } catch (Exception e) {}

            return null;
		}
		protected void onProgressUpdate(String... progress) {
			pDialog.setProgress(Integer.parseInt(progress[0]));
		}
		@Override
		protected void onPostExecute(String file_url) {
			pDialog.dismiss();
			Toast.makeText(context,success ? msg : Decryptor.Run(Strings.Failure),Toast.LENGTH_LONG).show();
		}
	}
	new getAntena().execute(data);
	}
}
