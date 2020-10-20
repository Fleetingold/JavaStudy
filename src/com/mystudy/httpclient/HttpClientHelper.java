package com.mystudy.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class HttpClientHelper {
	
	/**
	 * 调用本地FinanceRpc中的无参数方法
	 */
	static void FinanceRpcTest_NoParam(){
		String url = "http://localhost:11002/IFinance/GetFinaBankList";
		
		System.out.println(doGet(url));
	}
	
	/**
	 * 调用本地FinanceRpc中的一个参数方法
	 */
	static void FinanceRpcTest_OneParam() throws UnsupportedEncodingException{
		String url = "http://localhost:11002/IFinance/GetClerkBalanceItemByClerkNum";
		
		System.out.println(doPostJson(url,"\"a0001\""));
	}
	
	/**
	 * 调用本地FinanceRpc中的多个参数方法
	 */
	static void FinanceRpcTest_MuiltiParam(){
		String url = "http://localhost:11002/IFinance/IsFinaDrawerInfoExists";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("fullName", "安徽华源医药股份有限公司");
		paramMap.put("account", "184249387659");
		
		System.out.println(doPost(url,paramMap));
	}
	
	/**
	 * 调用本地FinanceRpc中的数组参数方法
	 */
	static void FinanceRpcTest_ArrayParam() throws UnsupportedEncodingException{
		String url = "http://localhost:11002/IFinance/QueryClerkCanSettledBalance";
		
		System.out.println(doPostJson(url,"[\"a0001\",\"a0002\",\"a0003\"]"));
	}
	
	/**
	 * 调用本地FinanceRpc中的分页查询方法
	 */
	static void FinanceRpcTest_PageQuery(){
		String url = "http://localhost:11002/IFinance/GetFinaBankAccountBalanceListByKeyByPage";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchkey", "1=1");
		paramMap.put("pagesize", 1);
		paramMap.put("pageIndex", 1);
		paramMap.put("sOrderBy", "CreateDate");
		
		System.out.println(doPost(url,paramMap));
	}
	
	/**
	 * 调用本地FinanceRpc中的Create方法
	 */
	static void FinanceRpcTest_Create() throws UnsupportedEncodingException{
		String url = "http://localhost:11002/IFinance/CreateFinaBankAccountBalance";
		
		JSONObject object = new JSONObject();
	    object.put("ID", "042C7348-4F76-4EFE-AAB1-6F76D5FA6908");
	    object.put("Bank", "JAVA_Call_RPC-API");
	    object.put("Account", "123456789");
	    object.put("Balance", 520.00);
	    object.put("Status", 1);
	    object.put("Creater", "jeffrey");
	    object.put("CreateDate", "2020-05-21");
	    object.put("Updater", "jeffrey");
	    object.put("UpdateDate", "2020-05-21");
	    object.put("Remark", "JAVA_Call_FinanceRpc");
		
		System.out.println(doPostJson(url,JSON.toJSONString(object)));
	}
	
	/**
	 * 调用本地FinanceRpc中的Update方法
	 */
	static void FinanceRpcTest_Update() throws UnsupportedEncodingException{
		String url = "http://localhost:11002/IFinance/UpdateFinaBankAccountBalance";
		
		JSONObject object = new JSONObject();
	    object.put("ID", "042C7348-4F76-4EFE-AAB1-6F76D5FA6908");
	    object.put("Bank", "JAVA_Call_RPC-API");
	    object.put("Account", "123456789");
	    object.put("Balance", 520.00);
	    object.put("Status", 1);
	    object.put("Creater", "jeffrey");
	    object.put("CreateDate", "2020-05-21");
	    object.put("Updater", "jeffrey");
	    object.put("UpdateDate", "2020-05-21");
	    object.put("Remark", "JAVA_Call_FinanceRpc");
		
		System.out.println(doPostJson(url,JSON.toJSONString(object)));
	}
	
	/**
	 * 调用本地FinanceRpc中的Delete方法
	 */
	static void FinanceRpcTest_Delete() throws UnsupportedEncodingException{
		String url = "http://localhost:11002/IFinance/DeleteFinaBankAccountBalance";
		
		JSONObject object = new JSONObject();
	    object.put("ID", "042C7348-4F76-4EFE-AAB1-6F76D5FA6908");
//	    object.put("Bank", "JAVA_Call_RPC-API");
//	    object.put("Account", "123456789");
//	    object.put("Balance", 520.00);
//	    object.put("Status", 1);
//	    object.put("Creater", "jeffrey");
//	    object.put("CreateDate", "2020-05-21");
//	    object.put("Updater", "jeffrey");
//	    object.put("UpdateDate", "2020-05-21");
//	    object.put("Remark", "JAVA_Call_FinanceRpc");
		
		System.out.println(doPostJson(url,JSON.toJSONString(object)));
	}
	
	public static String doGet(String url) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String result = "";
        try {
            // 通过址默认配置创建一个httpClient实例
            httpClient = HttpClients.createDefault();
            // 创建httpGet远程连接实例
            HttpGet httpGet = new HttpGet(url);
            // 设置请求头信息，鉴权
            httpGet.setHeader("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
            // 设置配置请求参数
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 连接主机服务超时时间
                    .setConnectionRequestTimeout(35000)// 请求超时时间
                    .setSocketTimeout(60000)// 数据读取超时时间
                    .build();
            // 为httpGet实例设置配置
            httpGet.setConfig(requestConfig);
            // 执行get请求得到返回对象
            response = httpClient.execute(httpGet);
            // 通过返回对象获取返回数据
            HttpEntity entity = response.getEntity();
            // 通过EntityUtils中的toString方法将结果转换为字符串
            result = EntityUtils.toString(entity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != response) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static String doPost(String url, Map<String, Object> paramMap) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        String result = "";
        // 创建httpClient实例
        httpClient = HttpClients.createDefault();
        // 创建httpPost远程连接实例
        HttpPost httpPost = new HttpPost(url);
        // 配置请求参数实例
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
                .setConnectionRequestTimeout(35000)// 设置连接请求超时时间
                .setSocketTimeout(60000)// 设置读取数据连接超时时间
                .build();
        // 为httpPost实例设置配置
        httpPost.setConfig(requestConfig);
        // 设置请求头
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        // 封装post请求参数
        if (null != paramMap && paramMap.size() > 0) {
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            // 通过map集成entrySet方法获取entity
            Set<Entry<String, Object>> entrySet = paramMap.entrySet();
            // 循环遍历，获取迭代器
            Iterator<Entry<String, Object>> iterator = entrySet.iterator();
            while (iterator.hasNext()) {
                Entry<String, Object> mapEntry = iterator.next();
                nvps.add(new BasicNameValuePair(mapEntry.getKey(), mapEntry.getValue().toString()));
            }

            // 为httpPost设置封装好的请求参数
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        try {
            // httpClient对象执行post请求,并返回响应参数对象
            httpResponse = httpClient.execute(httpPost);
            // 从响应对象中获取响应内容
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != httpResponse) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static String doPostJson(String url, String json) throws UnsupportedEncodingException {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        String result = "";
        // 创建httpClient实例
        httpClient = HttpClients.createDefault();
        // 创建httpPost远程连接实例
        HttpPost httpPost = new HttpPost(url);
        // 配置请求参数实例
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
                .setConnectionRequestTimeout(35000)// 设置连接请求超时时间
                .setSocketTimeout(60000)// 设置读取数据连接超时时间
                .build();
        // 为httpPost实例设置配置
        httpPost.setConfig(requestConfig);
        // 设置请求头
        httpPost.addHeader("Content-Type", "application/json");
        // 封装post请求参数
        httpPost.setEntity(new StringEntity(json));
        try {
            // httpClient对象执行post请求,并返回响应参数对象
            httpResponse = httpClient.execute(httpPost);
            // 从响应对象中获取响应内容
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != httpResponse) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
