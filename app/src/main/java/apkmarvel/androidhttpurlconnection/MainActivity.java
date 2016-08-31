package apkmarvel.androidhttpurlconnection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import apkmarvel.androidhttpurlconnection.webservice.WebServiceRequest;
import apkmarvel.androidhttpurlconnection.webservice.command.GetCommand;
import apkmarvel.androidhttpurlconnection.webservice.command.PostCommand;
import apkmarvel.androidhttpurlconnection.webservice.interfaces.OnServiceListener;
import apkmarvel.androidhttpurlconnection.webservice.model.WebResponse;
import apkmarvel.androidhttpurlconnection.webservice.model.WebServiceInfo;

public class MainActivity extends AppCompatActivity {
    /*sample api credit to https://github.com/typicode/jsonplaceholder#how-to*/

    private PostCommand postCommand;
    private GetCommand getCommand;
    public static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void cancel(View v){
        postCommand.cancel();
    }
    public void post(View v) {
        /*web info*/
        WebServiceInfo webServiceInfo = new WebServiceInfo();
        String url="http://jsonplaceholder.typicode.com/posts";
        webServiceInfo.setUrl(url);
        /*add parameter*/
        webServiceInfo.addParam("title", "sample title");
        webServiceInfo.addParam("body", "sample body");
        webServiceInfo.addParam("userId", "2");
        /*post command*/
        postCommand = new PostCommand(webServiceInfo);
        /*request*/
        WebServiceRequest webServiceRequest = new WebServiceRequest(postCommand);
        webServiceRequest.execute();
        webServiceRequest.setOnServiceListener(new OnServiceListener() {
            @Override
            public void onServiceCallback(WebResponse response) {
                Log.e(TAG,"WebResponse: "+response.getStringResponse());
            }
        });
    }
    public void get(View v){
         /*web info*/
        String url="http://jsonplaceholder.typicode.com/posts/1";
        WebServiceInfo webServiceInfo = new WebServiceInfo();
        webServiceInfo.setUrl(url);
        /*get command*/
        getCommand = new GetCommand(webServiceInfo);
        /*request*/
        WebServiceRequest webServiceRequest = new WebServiceRequest(getCommand);
        webServiceRequest.execute();
        webServiceRequest.setOnServiceListener(new OnServiceListener() {
            @Override
            public void onServiceCallback(WebResponse response) {
                Log.e(TAG,"WebResponse: "+response.getStringResponse());
            }
        });
    }
}
