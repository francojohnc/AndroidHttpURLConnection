package apkmarvel.androidhttpurlconnection.webservice;

import android.os.AsyncTask;
import android.util.Log;

import apkmarvel.androidhttpurlconnection.webservice.interfaces.OnServiceListener;

public abstract class NetworkTask<Params,Progress,Result> extends AsyncTask<Params,Progress,Result> {
    public String TAG = this.getClass().getSimpleName();
    protected OnServiceListener onServiceListener;
    public abstract Result doNetworkTask();

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        long time = System.currentTimeMillis();
        Log.e(TAG,"onPreExecute:"+time);
    }
    @Override
    protected Result doInBackground(Params... paramses) {
        return doNetworkTask();
    }
    @Override
    protected void onPostExecute(Result result) {
        super.onPostExecute(result);
        long time = System.currentTimeMillis();
        Log.e(TAG,"onPostExecute:"+time);
        onPostSuccess(result);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
    public abstract void onPostSuccess(Result result);
    public abstract void setOnServiceListener(OnServiceListener onServiceListener);
}
