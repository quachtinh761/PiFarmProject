package function;

import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static android.R.attr.data;

/**
 * Created by vanthi on 10/28/2016.
 */

public class PostMethod {
    private String[] arrayData;
    public PostMethod(String url, String[] field, String[] value) {
        //build array String 0:url, then $field#value$
        if (field.length != value.length) return;
        this.arrayData[0] = url;
        String[] p = processStringPredefined.setStrProcess(field,value);
        for (int i = 0;i<field.length; i++){
            arrayData[i+1] = p[i];
        }
    }
    public String send(){
        post async = new post();
        async.execute(arrayData);
        return async.getValue();
    }

    private class post extends AsyncTask<String, String, String> {
        private String value;
        @Override
        protected String doInBackground(String... data) {
            // Create a new HttpClient and Post Header
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(data[0]);
            StringBuilder stringResponse = new StringBuilder();
            String[] temp;
            try {
                //add data
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(data.length - 1);
                for (int i=1;i<data.length;i++){
                    temp = processStringPredefined.getStrProcess(data[i]);
                    nameValuePairs.add(new BasicNameValuePair(temp[0],temp[1]));
                }
                //nameValuePairs.add(new BasicNameValuePair("Key", data[1]));
                //nameValuePairs.add(new BasicNameValuePair("ID", data[2]));
                //nameValuePairs.add(new BasicNameValuePair("Data", data[3]));
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                //execute http post
                HttpResponse response = httpclient.execute(httppost);
                if (response.getStatusLine().getStatusCode() == 200) {
                    HttpEntity messageEntity = response.getEntity();
                    InputStream is = messageEntity.getContent();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String line;
                    while ((line = br.readLine()) != null) {
                        stringResponse.append(line);
                    }
                }

                return stringResponse.toString();

            } catch (IOException e) {
            }
            return stringResponse.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            value = s;
        }

        public String getValue() {
            return value;
        }
    }
}