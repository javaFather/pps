package com.wzx.pro.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 * http 工具类
 *
 * @author wzx
 */
@Slf4j
public class HttpClientUtil {

    private static CloseableHttpClient httpClient;
    private static final int RSP_200 = 200;
    private static final int RSP_400 = 400;
    public static final String CHARSET = "UTF-8";

    private HttpClientUtil() {
    }

    static {
        RequestConfig config = RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(1000 * 60 * 60).build();
        httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
    }

    /**
     * http post请求
     *
     * @param url          请求url地址
     * @param formParamMap 请求的参数
     * @return
     */
    public static String doPostHttp(String url, Map<String, String> formParamMap) {
        log.info("==========excute http post request=========");
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        HttpPost post = null;
        CloseableHttpResponse response = null;
        try {
            post = new HttpPost(url);
            List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
            if (formParamMap != null) {
                for (Map.Entry<String, String> entity : formParamMap.entrySet()) {
                    nameValuePairList.add(new BasicNameValuePair(entity.getKey(), entity.getValue()));
                }
            }
            // 模拟表单
            post.setEntity(new UrlEncodedFormEntity(nameValuePairList, Consts.UTF_8));
            response = httpClient.execute(post);
            HttpEntity respEntity = response.getEntity();
            int responseCode = response.getStatusLine().getStatusCode();
            bufferedReader = new BufferedReader(new InputStreamReader(respEntity.getContent(), Consts.UTF_8));
            String text = null;
            if (responseCode == RSP_200 || responseCode == RSP_400) {
                while ((text = bufferedReader.readLine()) != null) {
                    stringBuilder.append(text);
                }
            } else {
                throw new RuntimeException("接口请求异常：接口响应状态=" + responseCode);
            }

        } catch (Exception e) {
            log.error("http 请求异常", e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (response != null) {
                    response.close();
                }
                if (post != null) {
                    post.releaseConnection();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }


    /**
     * json字符串类型的post发送
     *
     * @param url 地址
     * @param json 参数
     * @return
     */
    public static String doPostJson(String url, String json) {
        log.info("==========excute http post request By JSON=========");
        StringBuilder stringBuilder = new StringBuilder();
        HttpPost post = null;
        try {
            post = new HttpPost(url);
            StringEntity se = new StringEntity(json, CHARSET);
            se.setContentType("application/json");
            post.setEntity(se);
            CloseableHttpResponse response = httpClient.execute(post);
            HttpEntity respEntity = response.getEntity();
            int responseCode = response.getStatusLine().getStatusCode();
            if (responseCode == RSP_200 || responseCode == RSP_400) {
                // 返回json格式
                String result = EntityUtils.toString(respEntity);
                log.info("http请求返回结果：{}", result);
                stringBuilder.append(result);
            } else {
                throw new RuntimeException("接口请求异常：接口响应状态=" + responseCode);
            }
            response.close();
            post.releaseConnection();
        } catch (Exception e) {
            log.error("http 请求异常", e);
        }
        return stringBuilder.toString();
    }

    /**
     * https get请求
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static String doGet(String url,Map<String ,String> map) throws Exception {
        log.info("==========excute get post request=========");
        StringBuilder stringBuilder = new StringBuilder();
        HttpGet httpGet = new HttpGet(url);
        Iterator<String> ite = map.keySet().iterator();
        String key = null;
        while (ite.hasNext()) {
            key = ite.next();
            httpGet.addHeader(key, map.get(key));
        }
        HttpResponse response = httpClient.execute(httpGet);
        int responseCode = response.getStatusLine().getStatusCode();
        HttpEntity respEntity = response.getEntity();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(respEntity.getContent(), Consts.UTF_8));
        String text;
        if (responseCode == RSP_200 || responseCode == RSP_400) {
            while ((text = bufferedReader.readLine()) != null) {
                stringBuilder.append(text);
            }
        } else {
            throw new RuntimeException("接口请求异常：接口响应状态=" + responseCode);
        }
        bufferedReader.close();
        httpGet.releaseConnection();
        return stringBuilder.toString();
    }
    /**
     * HTTP Get 获取内容
     * @param url  请求的url地址 ?之前的地址
     * @param params	请求的参数
     * @param charset	编码格式
     * @return	页面内容
     */
    public static String doGet(String url, Map<String,String> params, String charset){
        if(StringUtils.isEmpty(url)){
            return null;
        }
        try {
            if(params != null && !params.isEmpty()){
                List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
                for(Map.Entry<String,String> entry : params.entrySet()){
                    String value = entry.getValue();
                    if(value != null){
                        pairs.add(new BasicNameValuePair(entry.getKey(),value));
                    }
                }
                url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, charset));
            }
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                httpGet.abort();
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null){
                result = EntityUtils.toString(entity, "utf-8");
            }
            EntityUtils.consume(entity);
            response.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * 解析 文件流响应
     *
     * @param response
     * @return
     * @throws Exception
     */
    public static InputStream analyseFileResponse(HttpResponse response) throws Exception {
        return response.getEntity().getContent();
    }

    /**
     * post请求公共参数创建
     *
     * @param methodName
     * @return
     * @throws Exception
     */
    public Map<String, String> buildPostCommonParam(String methodName) throws Exception {
        String serialNo = RandomStringUtils.random(10);
        if (checkParamNull(methodName, serialNo)) {
            return null;
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("method", methodName.trim());
        map.put("serial_no", serialNo);
        map.put("timestamp", Dates.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
        map.put("format", "json");
        map.put("v", "1.0");
        return map;
    }

    /**
     * get请求公共参数创建
     *
     * @param methodName
     * @return
     * @throws Exception
     */
    public String buildGetCommonParam(String methodName) throws Exception {
        String serialNo = RandomStringUtils.random(10);
        if (checkParamNull(methodName, serialNo)) {
            return null;
        }
        StringBuilder sbuff = new StringBuilder();
        sbuff.append("?").append("method=").append(methodName.trim()).append("&");
        sbuff.append("serial_no=").append(serialNo).append("&");
        sbuff.append("timestamp=").append(URLEncoder.encode(Dates.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss"), CHARSET)).append("&");
        sbuff.append("format=").append("json").append("&");
        sbuff.append("v=").append("1.0").append("&");
        return sbuff.toString();
    }

    private boolean checkParamNull(String methodName, String serialNo) {
        boolean flag = false;
        if (StringUtils.isEmpty(methodName)) {
            flag = true;
        }
        if (StringUtils.isEmpty(serialNo)) {
            flag = true;
        }
        return flag;
    }

    public static String buildParams(Map<String, String> param, String charset) {
        if (param != null && !param.isEmpty()) {
            StringBuffer buffer = new StringBuffer();
            for (Map.Entry<String, String> entry : param.entrySet()) {
                try {
                    buffer.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), charset)).append("&");
                } catch (UnsupportedEncodingException e) {
                    log.error("=======", e);
                }
            }
            return buffer.deleteCharAt(buffer.length() - 1).toString();
        } else {
            return null;
        }
    }

    /**
     * HTTPS POST 请求
     * @param url
     * @param p
     * @param charset
     * @param headers 请求头
     * @return
     */
    public static String sendPost(String url, String p, String charset, Map<String, String> headers) {
        OutputStream out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = getConnection(realUrl);
            Map<String, String> defaultHeaders = new LinkedHashMap<>();
            defaultHeaders.put("accept", "*/*");
            defaultHeaders.put("connection", "Keep-Alive");
            defaultHeaders.put("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            if (null != headers) {
                defaultHeaders.putAll(headers);
            }
            //set header
            //defaultHeaders.forEach((k, v) -> conn.setRequestProperty(k, v));
            Iterator<String> ite = defaultHeaders.keySet().iterator();
            String key = null;
            while (ite.hasNext()) {
                key = ite.next();
                conn.setRequestProperty(key, defaultHeaders.get(key));
            }
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = conn.getOutputStream();
            if (p != null) {
                // 发送请求参数
                out.write(p.getBytes(charset));
                // flush输出流的缓冲
                out.flush();
            }
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * POST 提交 application/x-www-form-urlencoded
     * @param url
     * @param param
     * @param charset
     * @param headers
     * @return
     */
    public static String sendPost(String url, Map<String, String> param, String charset, Map<String, String> headers) {
        return sendPost(url, buildParams(param, charset), charset, headers);
    }

    public static byte[] download(String url, Map<String, String> param, String savePath) {
        OutputStream out = null;
        InputStream in = null;
        try {
            URL realUrl = new URL(url);
            URLConnection conn = getConnection(realUrl);

            Map<String, String> defaultHeaders = new LinkedHashMap<>();
            defaultHeaders.put("accept", "*/*");
            defaultHeaders.put("connection", "Keep-Alive");
            defaultHeaders.put("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = conn.getOutputStream();

            String p = buildParams(param, CHARSET);
            if (p != null) {
                // 发送请求参数
                out.write(p.getBytes());
                // flush输出流的缓冲
                out.flush();
            }
            //读取响应数据
            in = conn.getInputStream();
            byte[] buff = new byte[1024];
            ByteArrayOutputStream baot = new ByteArrayOutputStream();
            int len;
            while ((len = in.read(buff)) != -1) {
                baot.write(buff, 0, len);
            }
            if (savePath != null) {//保存文件
                FileOutputStream fo = new FileOutputStream(savePath);
                fo.write(baot.toByteArray());
                fo.close();
            }
            return baot.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public static HttpURLConnection getConnection(URL url) {
        HttpURLConnection connection = null;
        try {
            if (url.getProtocol().toUpperCase().startsWith("HTTPS")) {
                SSLContext ctx = SSLContext.getInstance("SSL");
                ctx.init(new KeyManager[0], new TrustManager[]{new X509TrustManager() {

                    @Override
                    public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                }}, new SecureRandom());


                HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                conn.setSSLSocketFactory(ctx.getSocketFactory());
                conn.setConnectTimeout(10000);
                conn.setReadTimeout(1000 * 60 * 30);

                conn.setHostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                });

                connection = conn;
            } else {
                connection = (HttpURLConnection) url.openConnection();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }


}
