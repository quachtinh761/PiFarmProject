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
import static android.R.attr.id;

/**
 * Created by vanthi on 10/28/2016.
 */
//List<String[]> is multi Arr, String[] must 2 element (field is 1st and value is second)
    // Success
public class PostMethod {
    private String[] arrayData = new String[4];
    //data type $vsdv#vsdvds#csdd$
    public PostMethod(String url, String key, String idCard, String data){
        this.arrayData[0] = url;
        this.arrayData[1] = key;
        this.arrayData[2] = idCard;
        this.arrayData[3] = data;
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
                nameValuePairs.add(new BasicNameValuePair("Key", data[1]));
                nameValuePairs.add(new BasicNameValuePair("ID", data[2]));
                nameValuePairs.add(new BasicNameValuePair("Data", data[3]));
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