package apkmarvel.androidhttpurlconnection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

import apkmarvel.androidhttpurlconnection.utils.UtilNetConnection;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void post(View v) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    String url="www.sampleurl.com";
                    HttpURLConnection con = UtilNetConnection.buildConnection(url);
                    /*add parameter*/
                    UtilNetConnection.writeParam(con,UtilNetConnection.getPostDataString(getParam()));
                    int responseCode = con.getResponseCode();
                    if (responseCode == HttpsURLConnection.HTTP_OK) {
                     String result= UtilNetConnection.inputStreamToString(con.getInputStream());
                        Log.e(TAG, result);
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    private HashMap<String, String> getParam() {
        HashMap<String, String> param = new HashMap<>();
        param.put("email", "johncarlo_franco@yahoo.com");
        param.put("source", "mobapps");
        return param;
    }
}
