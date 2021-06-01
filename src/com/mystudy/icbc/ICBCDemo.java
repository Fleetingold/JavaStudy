package com.mystudy.icbc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class ICBCDemo {

	public static void main(String[] args) {
		
		queryAccounts();
		//settleAccounts();
		
		//查询余额成功返回的代码
		String s = "PD94bWwgIHZlcnNpb249IjEuMCIgZW5jb2Rpbmc9IkdCSyIgPz4KPENNUz4KPGViPgo8cHViPgo8\r\n" + 
				"VHJhbnNDb2RlPlFBQ0NCQUw8L1RyYW5zQ29kZT4KPENJUz4xMzAyOTAwMDAwMjcxNzI8L0NJUz4K\r\n" + 
				"PEJhbmtDb2RlPjEwMjwvQmFua0NvZGU+CjxJRD5ZR0RZWVFITC55LjEzMDI8L0lEPgo8VHJhbkRh\r\n" + 
				"dGU+MjAxNzA1MDk8L1RyYW5EYXRlPgo8VHJhblRpbWU+MTczMTAzNTM1PC9UcmFuVGltZT4KPGZT\r\n" + 
				"ZXFubz5GUksyMDE3MDUwOTE3MzEwMzUzNTwvZlNlcW5vPgo8UmV0Q29kZT4wPC9SZXRDb2RlPgo8\r\n" + 
				"UmV0TXNnPjwvUmV0TXNnPgo8L3B1Yj4KPG91dD4KPHJkPgo8aVNlcW5vPjE8L2lTZXFubz4KPEFj\r\n" + 
				"Y05vPjEzMDIwMTE5MTkwMjQ5MzUyMjA8L0FjY05vPgo8Q3VyclR5cGU+MDAxPC9DdXJyVHlwZT4K\r\n" + 
				"PENhc2hFeGY+MDwvQ2FzaEV4Zj4KPEFjY3RQcm9wZXJ0eT4wMDE8L0FjY3RQcm9wZXJ0eT4KPEFj\r\n" + 
				"Y0JhbGFuY2U+NTAwMDAwMDA8L0FjY0JhbGFuY2U+CjxCYWxhbmNlPjI3NTY0MjM0MzQ8L0JhbGFu\r\n" + 
				"Y2U+CjxVc2FibGVCYWxhbmNlPjI3NTY0MjM0MzQ8L1VzYWJsZUJhbGFuY2U+CjxGcnpBbXQ+MDwv\r\n" + 
				"RnJ6QW10Pgo8UXVlcnlUaW1lPjIwMTcwNTA5MTczMTAwMDAwMDE2PC9RdWVyeVRpbWU+CjxpUmV0\r\n" + 
				"Q29kZT4wPC9pUmV0Q29kZT4KPGlSZXRNc2c+PC9pUmV0TXNnPgo8UmVwUmVzZXJ2ZWQzPjwvUmVw\r\n" + 
				"UmVzZXJ2ZWQzPgo8UmVwUmVzZXJ2ZWQ0PjwvUmVwUmVzZXJ2ZWQ0Pgo8L3JkPgo8L291dD4KPC9l\r\n" + 
				"Yj4KPC9DTVM+Cg==";
		
		//TransCode=QHISD
		s = "PD94bWwgIHZlcnNpb249IjEuMCIgZW5jb2Rpbmc9IkdCSyIgPz4KPENNUz4KPGViPgo8cHViPgo8\r\n" + 
				"VHJhbnNDb2RlPlFISVNEPC9UcmFuc0NvZGU+CjxDSVM+MTMwMjkwMDAwNDk5NzU5PC9DSVM+CjxC\r\n" + 
				"YW5rQ29kZT4xMDI8L0JhbmtDb2RlPgo8SUQ+Z3luYmNzMDIyNy55LjEzMDI8L0lEPgo8VHJhbkRh\r\n" + 
				"dGU+MjAxODAzMjE8L1RyYW5EYXRlPgo8VHJhblRpbWU+MDk1NTM5NjMxPC9UcmFuVGltZT4KPGZT\r\n" + 
				"ZXFubz4yMDE4MDMyMS4wOTU1MzkuWkZGPC9mU2Vxbm8+CjxSZXRDb2RlPjA8L1JldENvZGU+CjxS\r\n" + 
				"ZXRNc2c+PC9SZXRNc2c+CjwvcHViPgo8b3V0Pgo8QWNjTm8+MTMwMjAxNTAwOTAyMjU3NjIwMjwv\r\n" + 
				"QWNjTm8+CjxBY2NOYW1lPrP11PzQ7cS71ObX2Mb4yOu0ytbZyfLJrjwvQWNjTmFtZT4KPEN1cnJU\r\n" + 
				"eXBlPlJNQjwvQ3VyclR5cGU+CjxCZWdpbkRhdGU+MjAxODAxMDE8L0JlZ2luRGF0ZT4KPEVuZERh\r\n" + 
				"dGU+MjAxODAxMzE8L0VuZERhdGU+CjxNaW5BbXQ+MDwvTWluQW10Pgo8TWF4QW10Pjk5OTk5OTk5\r\n" + 
				"OTk5PC9NYXhBbXQ+CjxCYW5rVHlwZT48L0JhbmtUeXBlPgo8TmV4dFRhZz48L05leHRUYWc+CjxU\r\n" + 
				"b3RhbE51bT4yPC9Ub3RhbE51bT4KPER1ZUJpbGxObz48L0R1ZUJpbGxObz4KPEFjY3RTZXE+PC9B\r\n" + 
				"Y2N0U2VxPgo8cmQ+CjxEcmNyZj4yPC9EcmNyZj4KPFZvdWhObz4wPC9Wb3VoTm8+CjxEZWJpdEFt\r\n" + 
				"b3VudD48L0RlYml0QW1vdW50Pgo8Q3JlZGl0QW1vdW50PjQwNzAxMzA4NDM8L0NyZWRpdEFtb3Vu\r\n" + 
				"dD4KPEJhbGFuY2U+NDEyMDEzMDg0MzwvQmFsYW5jZT4KPFJlY2lwQmtObz48L1JlY2lwQmtObz4K\r\n" + 
				"PFJlY2lwQmtOYW1lPjAwMDAwPC9SZWNpcEJrTmFtZT4KPFJlY2lwQWNjTm8+MTMwMjAxNTAwOTA0\r\n" + 
				"MDAwMjcyODwvUmVjaXBBY2NObz4KPFJlY2lwTmFtZT6z9dT80O3Eu9Tm19jG+MjrtMrW2cnyya48\r\n" + 
				"L1JlY2lwTmFtZT4KPFN1bW1hcnk+0K22qLTmv+6747uuv+7P7jwvU3VtbWFyeT4KPFVzZUNOPjwv\r\n" + 
				"VXNlQ04+CjxQb3N0U2NyaXB0PjwvUG9zdFNjcmlwdD4KPEJ1c0NvZGU+PC9CdXNDb2RlPgo8RGF0\r\n" + 
				"ZT4yMDE4MDEyMDwvRGF0ZT4KPFRpbWU+MjAxOC0wMS0wMi0wMi4xMi40OS43MjExNjI8L1RpbWU+\r\n" + 
				"CjxSZWY+PC9SZWY+CjxPcmVmPjwvT3JlZj4KPEVuU3VtbWFyeT48L0VuU3VtbWFyeT4KPEJ1c1R5\r\n" + 
				"cGU+PC9CdXNUeXBlPgo8Vm91aFR5cGU+MDAwPC9Wb3VoVHlwZT4KPEFkZEluZm8+PC9BZGRJbmZv\r\n" + 
				"Pgo8VG91dGZvPjEzMDJ8MDE1MHwxODAyMHwwMDAwMDE8L1RvdXRmbz4KPE9ubHlTZXF1ZW5jZT4x\r\n" + 
				"ODAyMDAwMDAwMTwvT25seVNlcXVlbmNlPgo8QWdlbnRBY2N0TmFtZT48L0FnZW50QWNjdE5hbWU+\r\n" + 
				"CjxBZ2VudEFjY3RObz48L0FnZW50QWNjdE5vPgo8VXBEdHJhbmY+MDwvVXBEdHJhbmY+CjxWYWx1\r\n" + 
				"ZURhdGU+MjAxODAxMjA8L1ZhbHVlRGF0ZT4KPFRyeENvZGU+NjAwMDc8L1RyeENvZGU+CjxSZWYx\r\n" + 
				"PjwvUmVmMT4KPE9yZWYxPjwvT3JlZjE+CjxDQVNIRj4wPC9DQVNIRj4KPFRyYWRlTG9jYXRpb24+\r\n" + 
				"PC9UcmFkZUxvY2F0aW9uPgo8U3ViQWNjdFNlcT48L1N1YkFjY3RTZXE+CjxUSEN1cnJlbmN5Pjwv\r\n" + 
				"VEhDdXJyZW5jeT4KPFJlY2lwQmtOYW1lMT66z7fKy97W3cK31qfQ0NOq0rXK0jwvUmVjaXBCa05h\r\n" + 
				"bWUxPgo8UmVjaXBCa05vMT48L1JlY2lwQmtObzE+CjxUSW5mb05ldz4xMzAyfDAxNTB8MTgwMjB8\r\n" + 
				"MDAwMDAxPC9USW5mb05ldz4KPFJlZnVuZE1zZz48L1JlZnVuZE1zZz4KPEJ1c1R5cE5vPjwvQnVz\r\n" + 
				"VHlwTm8+CjxSZWNlaXB0SW5mbz48L1JlY2VpcHRJbmZvPgo8VGVsTm8+MDAwMDE8L1RlbE5vPgo8\r\n" + 
				"TURDQVJETk8+PC9NRENBUkROTz4KPFRyeEFtdD48L1RyeEFtdD4KPFRyeEN1cnI+PC9UcnhDdXJy\r\n" + 
				"Pgo8L3JkPjxyZD4KPERyY3JmPjE8L0RyY3JmPgo8Vm91aE5vPjA8L1ZvdWhObz4KPERlYml0QW1v\r\n" + 
				"dW50PjEwMDAwMDA8L0RlYml0QW1vdW50Pgo8Q3JlZGl0QW1vdW50PjwvQ3JlZGl0QW1vdW50Pgo8\r\n" + 
				"QmFsYW5jZT40MTE5MTMwODQzPC9CYWxhbmNlPgo8UmVjaXBCa05vPjwvUmVjaXBCa05vPgo8UmVj\r\n" + 
				"aXBCa05hbWU+MDAwMDA8L1JlY2lwQmtOYW1lPgo8UmVjaXBBY2NObz4xMzAyMDE1MDI5MDIyNTc3\r\n" + 
				"MTE5PC9SZWNpcEFjY05vPgo8UmVjaXBOYW1lPrP11PzQ7cS71ObX2Mb4yOu0ytbZyfLJrjwvUmVj\r\n" + 
				"aXBOYW1lPgo8U3VtbWFyeT5ERU1PPC9TdW1tYXJ5Pgo8VXNlQ04+08PNvjwvVXNlQ04+CjxQb3N0\r\n" + 
				"U2NyaXB0Pri90dQ8L1Bvc3RTY3JpcHQ+CjxCdXNDb2RlPjwvQnVzQ29kZT4KPERhdGU+MjAxODAx\r\n" + 
				"MjA8L0RhdGU+CjxUaW1lPjIwMTgtMDEtMDUtMTEuMjcuNTkuNDE4MDY2PC9UaW1lPgo8UmVmPjwv\r\n" + 
				"UmVmPgo8T3JlZj48L09yZWY+CjxFblN1bW1hcnk+PC9FblN1bW1hcnk+CjxCdXNUeXBlPjAwMDwv\r\n" + 
				"QnVzVHlwZT4KPFZvdWhUeXBlPjAwMDwvVm91aFR5cGU+CjxBZGRJbmZvPjwvQWRkSW5mbz4KPFRv\r\n" + 
				"dXRmbz4xMzAyfDAxNTB8MTgwMjB8MDAwMDAyPC9Ub3V0Zm8+CjxPbmx5U2VxdWVuY2U+MTgwMjAw\r\n" + 
				"MDAwMDI8L09ubHlTZXF1ZW5jZT4KPEFnZW50QWNjdE5hbWU+PC9BZ2VudEFjY3ROYW1lPgo8QWdl\r\n" + 
				"bnRBY2N0Tm8+PC9BZ2VudEFjY3RObz4KPFVwRHRyYW5mPjA8L1VwRHRyYW5mPgo8VmFsdWVEYXRl\r\n" + 
				"PjIwMTgwMTIwPC9WYWx1ZURhdGU+CjxUcnhDb2RlPjQxMjQ4PC9UcnhDb2RlPgo8UmVmMT48L1Jl\r\n" + 
				"ZjE+CjxPcmVmMT48L09yZWYxPgo8Q0FTSEY+MDwvQ0FTSEY+CjxUcmFkZUxvY2F0aW9uPjwvVHJh\r\n" + 
				"ZGVMb2NhdGlvbj4KPFN1YkFjY3RTZXE+PC9TdWJBY2N0U2VxPgo8VEhDdXJyZW5jeT48L1RIQ3Vy\r\n" + 
				"cmVuY3k+CjxSZWNpcEJrTmFtZTE+uaTQ0LCyu9XKobrPt8rL3tbdwrfWp9DQPC9SZWNpcEJrTmFt\r\n" + 
				"ZTE+CjxSZWNpcEJrTm8xPjwvUmVjaXBCa05vMT4KPFRJbmZvTmV3PjEzMDJ8MDE1MHwxODAyMHww\r\n" + 
				"MDAwMDI8L1RJbmZvTmV3Pgo8UmVmdW5kTXNnPjwvUmVmdW5kTXNnPgo8QnVzVHlwTm8+PC9CdXNU\r\n" + 
				"eXBObz4KPFJlY2VpcHRJbmZvPjwvUmVjZWlwdEluZm8+CjxUZWxObz4wMDAyOTwvVGVsTm8+CjxN\r\n" + 
				"RENBUkROTz48L01EQ0FSRE5PPgo8VHJ4QW10PjwvVHJ4QW10Pgo8VHJ4Q3Vycj48L1RyeEN1cnI+\r\n" + 
				"CjwvcmQ+PC9vdXQ+CjwvZWI+CjwvQ01TPgo=";
		
		//PAYENT 账号中文户名不符PayAccNameCN
		s = "PD94bWwgIHZlcnNpb249IjEuMCIgZW5jb2Rpbmc9IkdCSyIgPz4KPENNUz4KPGViPgo8cHViPgo8\r\n" + 
				"VHJhbnNDb2RlPlBBWUVOVDwvVHJhbnNDb2RlPgo8Q0lTPjEzMDI5MDAwMDQ5OTc1OTwvQ0lTPgo8\r\n" + 
				"QmFua0NvZGU+MTAyPC9CYW5rQ29kZT4KPElEPkdZTllCWFlRSEwueS4xMzAyPC9JRD4KPFRyYW5E\r\n" + 
				"YXRlPjIwMTkwMjI1PC9UcmFuRGF0ZT4KPFRyYW5UaW1lPjE2MjI0NDkzNTwvVHJhblRpbWU+Cjxm\r\n" + 
				"U2Vxbm8+MjAxOTAyMjUuMTYyMjQ0LlhFTzwvZlNlcW5vPgo8U2VyaWFsTm8+Q01NMTI0NjUxOTgz\r\n" + 
				"NjwvU2VyaWFsTm8+CjxSZXRDb2RlPjA8L1JldENvZGU+CjxSZXRNc2c+PC9SZXRNc2c+CjwvcHVi\r\n" + 
				"Pgo8b3V0Pgo8T25sQmF0Rj4xPC9PbmxCYXRGPgo8U2V0dGxlTW9kZT4wPC9TZXR0bGVNb2RlPgo8\r\n" + 
				"VG90YWxOdW0+MTwvVG90YWxOdW0+CjxUb3RhbEFtdD4xPC9Ub3RhbEFtdD4KPFJlcFJlc2VydmVk\r\n" + 
				"MT48L1JlcFJlc2VydmVkMT4KPFJlcFJlc2VydmVkMj48L1JlcFJlc2VydmVkMj4KPEFsZXJ0Rmxh\r\n" + 
				"Zz48L0FsZXJ0RmxhZz4KPHJkPgo8aVNlcW5vPjE8L2lTZXFubz4KPE9yZGVyTm8+MTwvT3JkZXJO\r\n" + 
				"bz4KPFJlaW1idXJzZU5vPjwvUmVpbWJ1cnNlTm8+CjxSZWltYnVyc2VOdW0+PC9SZWltYnVyc2VO\r\n" + 
				"dW0+CjxTdGFydERhdGU+PC9TdGFydERhdGU+CjxTdGFydFRpbWU+PC9TdGFydFRpbWU+CjxQYXlU\r\n" + 
				"eXBlPjE8L1BheVR5cGU+CjxQYXlBY2NObz4xMzAyMDE1MDA5MDIyNTc2MjAyPC9QYXlBY2NObz4K\r\n" + 
				"PFBheUFjY05hbWVDTj64tr/uyMu7p8P7eHh4PC9QYXlBY2NOYW1lQ04+CjxQYXlBY2NOYW1lRU4+\r\n" + 
				"PC9QYXlBY2NOYW1lRU4+CjxSZWNBY2NObz4xMzAyMDE1MDA5MDIyNTc2MjAyPC9SZWNBY2NObz4K\r\n" + 
				"PFJlY0FjY05hbWVDTj7K1b/uyMu7p8P7eXl5PC9SZWNBY2NOYW1lQ04+CjxSZWNBY2NOYW1lRU4+\r\n" + 
				"PC9SZWNBY2NOYW1lRU4+CjxTeXNJT0ZsZz4xPC9TeXNJT0ZsZz4KPElzU2FtZUNpdHk+PC9Jc1Nh\r\n" + 
				"bWVDaXR5Pgo8UHJvcD48L1Byb3A+CjxSZWNJQ0JDQ29kZT48L1JlY0lDQkNDb2RlPgo8UmVjQ2l0\r\n" + 
				"eU5hbWU+uaTQ0M+1zbPE2s7e0OjXosP3PC9SZWNDaXR5TmFtZT4KPFJlY0JhbmtObz48L1JlY0Jh\r\n" + 
				"bmtObz4KPFJlY0JhbmtOYW1lPrmk0NDPtc2zxNrO3tDo16LD9zwvUmVjQmFua05hbWU+CjxDdXJy\r\n" + 
				"VHlwZT4wMDE8L0N1cnJUeXBlPgo8UGF5QW10PjE8L1BheUFtdD4KPFVzZUNvZGU+PC9Vc2VDb2Rl\r\n" + 
				"Pgo8VXNlQ04+yc/P37LiytQ8L1VzZUNOPgo8RW5TdW1tYXJ5PjwvRW5TdW1tYXJ5Pgo8UG9zdFNj\r\n" + 
				"cmlwdD48L1Bvc3RTY3JpcHQ+CjxTdW1tYXJ5PjwvU3VtbWFyeT4KPFJlZj48L1JlZj4KPE9yZWY+\r\n" + 
				"PC9PcmVmPgo8RVJQU3FuPjwvRVJQU3FuPgo8QnVzQ29kZT48L0J1c0NvZGU+CjxFUlBjaGVja25v\r\n" + 
				"PjwvRVJQY2hlY2tubz4KPENydm91aFR5cGU+PC9DcnZvdWhUeXBlPgo8Q3J2b3VoTmFtZT48L0Ny\r\n" + 
				"dm91aE5hbWU+CjxDcnZvdWhObz48L0Nydm91aE5vPgo8QmFua1R5cGU+PC9CYW5rVHlwZT4KPEZp\r\n" + 
				"bGVOYW1lcz48L0ZpbGVOYW1lcz4KPEluZGV4cz48L0luZGV4cz4KPFBheVN1Yk5vPjwvUGF5U3Vi\r\n" + 
				"Tm8+CjxSZWNTdWJObz48L1JlY1N1Yk5vPgo8UmVzdWx0PjY8L1Jlc3VsdD4KPGlSZXRDb2RlPkIw\r\n" + 
				"MDQzPC9pUmV0Q29kZT4KPGlSZXRNc2c+1cu6xdbQzsS7p8P7sru3+1BheUFjY05hbWVDTjwvaVJl\r\n" + 
				"dE1zZz4KPE1DYXJkTm8+PC9NQ2FyZE5vPgo8TUNhcmROYW1lPjwvTUNhcmROYW1lPgo8L3JkPgo8\r\n" + 
				"L291dD4KPC9lYj4KPC9DTVM+Cg==";
		
		//PAYENT 系统内收付方账号不能相同
		s= "PD94bWwgIHZlcnNpb249IjEuMCIgZW5jb2Rpbmc9IkdCSyIgPz4KPENNUz4KPGViPgo8cHViPgo8\r\n" + 
				"VHJhbnNDb2RlPlBBWUVOVDwvVHJhbnNDb2RlPgo8Q0lTPjEzMDI5MDAwMDQ5OTc1OTwvQ0lTPgo8\r\n" + 
				"QmFua0NvZGU+MTAyPC9CYW5rQ29kZT4KPElEPkdZTllCWFlRSEwueS4xMzAyPC9JRD4KPFRyYW5E\r\n" + 
				"YXRlPjIwMTkwMjI1PC9UcmFuRGF0ZT4KPFRyYW5UaW1lPjE3MTExNTk2MTwvVHJhblRpbWU+Cjxm\r\n" + 
				"U2Vxbm8+MjAxOTAyMjUuMTcxMTE1LlpUWDwvZlNlcW5vPgo8U2VyaWFsTm8+Q01NMTI0NjU1OTgz\r\n" + 
				"MjwvU2VyaWFsTm8+CjxSZXRDb2RlPjA8L1JldENvZGU+CjxSZXRNc2c+PC9SZXRNc2c+CjwvcHVi\r\n" + 
				"Pgo8b3V0Pgo8T25sQmF0Rj4xPC9PbmxCYXRGPgo8U2V0dGxlTW9kZT4wPC9TZXR0bGVNb2RlPgo8\r\n" + 
				"VG90YWxOdW0+MTwvVG90YWxOdW0+CjxUb3RhbEFtdD4xPC9Ub3RhbEFtdD4KPFJlcFJlc2VydmVk\r\n" + 
				"MT48L1JlcFJlc2VydmVkMT4KPFJlcFJlc2VydmVkMj48L1JlcFJlc2VydmVkMj4KPEFsZXJ0Rmxh\r\n" + 
				"Zz48L0FsZXJ0RmxhZz4KPHJkPgo8aVNlcW5vPjE8L2lTZXFubz4KPE9yZGVyTm8+MTwvT3JkZXJO\r\n" + 
				"bz4KPFJlaW1idXJzZU5vPjwvUmVpbWJ1cnNlTm8+CjxSZWltYnVyc2VOdW0+PC9SZWltYnVyc2VO\r\n" + 
				"dW0+CjxTdGFydERhdGU+PC9TdGFydERhdGU+CjxTdGFydFRpbWU+PC9TdGFydFRpbWU+CjxQYXlU\r\n" + 
				"eXBlPjE8L1BheVR5cGU+CjxQYXlBY2NObz4xMzAyMDE1MDA5MDIyNTc2MjAyPC9QYXlBY2NObz4K\r\n" + 
				"PFBheUFjY05hbWVDTj6/2LH4vdTBq8HbxKTO/M7p0rC4w7vTybU8L1BheUFjY05hbWVDTj4KPFBh\r\n" + 
				"eUFjY05hbWVFTj48L1BheUFjY05hbWVFTj4KPFJlY0FjY05vPjEzMDIwMTUwMDkwMjI1NzYyMDI8\r\n" + 
				"L1JlY0FjY05vPgo8UmVjQWNjTmFtZUNOPr/Ysfi91MGrwdvEpM78zunSsLjDu9PJtTwvUmVjQWNj\r\n" + 
				"TmFtZUNOPgo8UmVjQWNjTmFtZUVOPjwvUmVjQWNjTmFtZUVOPgo8U3lzSU9GbGc+MTwvU3lzSU9G\r\n" + 
				"bGc+CjxJc1NhbWVDaXR5PjE8L0lzU2FtZUNpdHk+CjxQcm9wPjA8L1Byb3A+CjxSZWNJQ0JDQ29k\r\n" + 
				"ZT4xMzAyPC9SZWNJQ0JDQ29kZT4KPFJlY0NpdHlOYW1lPrmk0NDPtc2zxNrO3tDo16LD9zwvUmVj\r\n" + 
				"Q2l0eU5hbWU+CjxSZWNCYW5rTm8+PC9SZWNCYW5rTm8+CjxSZWNCYW5rTmFtZT65pNDQz7XNs8Ta\r\n" + 
				"zt7Q6Neiw/c8L1JlY0JhbmtOYW1lPgo8Q3VyclR5cGU+MDAxPC9DdXJyVHlwZT4KPFBheUFtdD4x\r\n" + 
				"PC9QYXlBbXQ+CjxVc2VDb2RlPjwvVXNlQ29kZT4KPFVzZUNOPsnPz9+y4srUPC9Vc2VDTj4KPEVu\r\n" + 
				"U3VtbWFyeT48L0VuU3VtbWFyeT4KPFBvc3RTY3JpcHQ+PC9Qb3N0U2NyaXB0Pgo8U3VtbWFyeT48\r\n" + 
				"L1N1bW1hcnk+CjxSZWY+PC9SZWY+CjxPcmVmPjwvT3JlZj4KPEVSUFNxbj48L0VSUFNxbj4KPEJ1\r\n" + 
				"c0NvZGU+PC9CdXNDb2RlPgo8RVJQY2hlY2tubz48L0VSUGNoZWNrbm8+CjxDcnZvdWhUeXBlPjwv\r\n" + 
				"Q3J2b3VoVHlwZT4KPENydm91aE5hbWU+PC9DcnZvdWhOYW1lPgo8Q3J2b3VoTm8+PC9DcnZvdWhO\r\n" + 
				"bz4KPEJhbmtUeXBlPjwvQmFua1R5cGU+CjxGaWxlTmFtZXM+PC9GaWxlTmFtZXM+CjxJbmRleHM+\r\n" + 
				"PC9JbmRleHM+CjxQYXlTdWJObz48L1BheVN1Yk5vPgo8UmVjU3ViTm8+PC9SZWNTdWJObz4KPFJl\r\n" + 
				"c3VsdD42PC9SZXN1bHQ+CjxpUmV0Q29kZT5CMDA1MjwvaVJldENvZGU+CjxpUmV0TXNnPs+1zbPE\r\n" + 
				"2srVuLa3vdXLusWyu8Tcz+DNrDwvaVJldE1zZz4KPE1DYXJkTm8+PC9NQ2FyZE5vPgo8TUNhcmRO\r\n" + 
				"YW1lPjwvTUNhcmROYW1lPgo8L3JkPgo8L291dD4KPC9lYj4KPC9DTVM+Cg==";
		
		//PAYENT 成功
		s = "PD94bWwgIHZlcnNpb249IjEuMCIgZW5jb2Rpbmc9IkdCSyIgPz4KPENNUz4KPGViPgo8cHViPgo8\r\n" + 
				"VHJhbnNDb2RlPlBBWUVOVDwvVHJhbnNDb2RlPgo8Q0lTPjEzMDI5MDAwMDQ5OTc1OTwvQ0lTPgo8\r\n" + 
				"QmFua0NvZGU+MTAyPC9CYW5rQ29kZT4KPElEPkdZTllCWFlRSEwueS4xMzAyPC9JRD4KPFRyYW5E\r\n" + 
				"YXRlPjIwMTkwMjI1PC9UcmFuRGF0ZT4KPFRyYW5UaW1lPjE3MTIwNTA3MTwvVHJhblRpbWU+Cjxm\r\n" + 
				"U2Vxbm8+MjAxOTAyMjUuMTcxMjA1LktOSTwvZlNlcW5vPgo8U2VyaWFsTm8+Q01NMTI0NjU1OTgz\r\n" + 
				"NDwvU2VyaWFsTm8+CjxSZXRDb2RlPjA8L1JldENvZGU+CjxSZXRNc2c+s8m5pjwvUmV0TXNnPgo8\r\n" + 
				"L3B1Yj4KPG91dD4KPE9ubEJhdEY+MTwvT25sQmF0Rj4KPFNldHRsZU1vZGU+MDwvU2V0dGxlTW9k\r\n" + 
				"ZT4KPFRvdGFsTnVtPjE8L1RvdGFsTnVtPgo8VG90YWxBbXQ+MTwvVG90YWxBbXQ+CjxSZXBSZXNl\r\n" + 
				"cnZlZDE+PC9SZXBSZXNlcnZlZDE+CjxSZXBSZXNlcnZlZDI+PC9SZXBSZXNlcnZlZDI+CjxBbGVy\r\n" + 
				"dEZsYWc+PC9BbGVydEZsYWc+CjxyZD4KPGlTZXFubz4xPC9pU2Vxbm8+CjxPcmRlck5vPjE8L09y\r\n" + 
				"ZGVyTm8+CjxSZWltYnVyc2VObz48L1JlaW1idXJzZU5vPgo8UmVpbWJ1cnNlTnVtPjwvUmVpbWJ1\r\n" + 
				"cnNlTnVtPgo8U3RhcnREYXRlPjwvU3RhcnREYXRlPgo8U3RhcnRUaW1lPjwvU3RhcnRUaW1lPgo8\r\n" + 
				"UGF5VHlwZT4xPC9QYXlUeXBlPgo8UGF5QWNjTm8+MTMwMjAxNTAwOTAyMjU3NjIwMjwvUGF5QWNj\r\n" + 
				"Tm8+CjxQYXlBY2NOYW1lQ04+v9ix+L3UwavB28SkzvzO6dKwuMO708m1PC9QYXlBY2NOYW1lQ04+\r\n" + 
				"CjxQYXlBY2NOYW1lRU4+PC9QYXlBY2NOYW1lRU4+CjxSZWNBY2NObz4xMzAyMDE1MDI5MDIyNjA2\r\n" + 
				"ODg0PC9SZWNBY2NObz4KPFJlY0FjY05hbWVDTj6/2LH4vdTBq8HbxKTO/M7p0rC4w7vTybU8L1Jl\r\n" + 
				"Y0FjY05hbWVDTj4KPFJlY0FjY05hbWVFTj48L1JlY0FjY05hbWVFTj4KPFN5c0lPRmxnPjE8L1N5\r\n" + 
				"c0lPRmxnPgo8SXNTYW1lQ2l0eT4xPC9Jc1NhbWVDaXR5Pgo8UHJvcD4wPC9Qcm9wPgo8UmVjSUNC\r\n" + 
				"Q0NvZGU+MTMwMjwvUmVjSUNCQ0NvZGU+CjxSZWNDaXR5TmFtZT65pNDQz7XNs8Tazt7Q6Neiw/c8\r\n" + 
				"L1JlY0NpdHlOYW1lPgo8UmVjQmFua05vPjwvUmVjQmFua05vPgo8UmVjQmFua05hbWU+uaTQ0M+1\r\n" + 
				"zbPE2s7e0OjXosP3PC9SZWNCYW5rTmFtZT4KPEN1cnJUeXBlPjAwMTwvQ3VyclR5cGU+CjxQYXlB\r\n" + 
				"bXQ+MTwvUGF5QW10Pgo8VXNlQ29kZT48L1VzZUNvZGU+CjxVc2VDTj7Jz8/fsuLK1DwvVXNlQ04+\r\n" + 
				"CjxFblN1bW1hcnk+PC9FblN1bW1hcnk+CjxQb3N0U2NyaXB0PjwvUG9zdFNjcmlwdD4KPFN1bW1h\r\n" + 
				"cnk+PC9TdW1tYXJ5Pgo8UmVmPjwvUmVmPgo8T3JlZj48L09yZWY+CjxFUlBTcW4+PC9FUlBTcW4+\r\n" + 
				"CjxCdXNDb2RlPjwvQnVzQ29kZT4KPEVSUGNoZWNrbm8+PC9FUlBjaGVja25vPgo8Q3J2b3VoVHlw\r\n" + 
				"ZT48L0Nydm91aFR5cGU+CjxDcnZvdWhOYW1lPjwvQ3J2b3VoTmFtZT4KPENydm91aE5vPjwvQ3J2\r\n" + 
				"b3VoTm8+CjxCYW5rVHlwZT48L0JhbmtUeXBlPgo8RmlsZU5hbWVzPjwvRmlsZU5hbWVzPgo8SW5k\r\n" + 
				"ZXhzPjwvSW5kZXhzPgo8UGF5U3ViTm8+PC9QYXlTdWJObz4KPFJlY1N1Yk5vPjwvUmVjU3ViTm8+\r\n" + 
				"CjxSZXN1bHQ+NzwvUmVzdWx0Pgo8aVJldENvZGU+MDwvaVJldENvZGU+CjxpUmV0TXNnPrPJuaY8\r\n" + 
				"L2lSZXRNc2c+CjxNQ2FyZE5vPjwvTUNhcmRObz4KPE1DYXJkTmFtZT48L01DYXJkTmFtZT4KPC9y\r\n" + 
				"ZD4KPC9vdXQ+CjwvZWI+CjwvQ01TPgo=";
		
//		System.out.println("银企互联返回----"+s);
//        byte[] decodeResult = getbyteFromBASE64(s);
//        s = new String(decodeResult);
//        System.out.println("base64解码如下:" + s);
		
		System.out.println("Hello Java World!!!");
	}

	public static void queryAccounts() {
	       String xmlcontent = ""; // xml报文格式的字符串
	       String repcontent = ""; // 工行返回的信息
	       String NCIp = "127.0.0.1"; //你安装工行系统服务器的ip
	       String NCPort = "448"; // 客户端端口号
	       String fSeqno ="FRK"+ DateFormatUtil.formatDate(new Date(),"yyyyMMddHHmmssSSS");
	       String iSeqno ="IRK"+ DateFormatUtil.formatDate(new Date(),"yyyyMMddHHmmssSSS");

	       // 明文组包
	       //查询余额 返回D0098
	       xmlcontent = "<?xml version=\"1.0\" encoding = \"GB2312\"?>" + 
	       		"<ICBCYH>" + 
	       		"<opReq>" + 
	       		"<opName>NCQueryBalanceOp</opName>" + 
	       		"<ReqParam>" + 
	       		"<Area_code></Area_code>" + 
	       		"<Account_num>1311045029200040348</Account_num>"	+ 
	       		"<Account_cur></Account_cur>" + 
	       		"<userID>hyhl.y.1311</userID>" + 
	       		"<PackageID>" + fSeqno + "</PackageID>" + 
	       		"<ReqReserved1></ReqReserved1>" + 
	       		"<ReqReserved2></ReqReserved2>" + 
	       		"</ReqParam>" + 
	       		"</opReq>" + 
	       		"</ICBCYH>";
	       
	       xmlcontent = "<?xml version=\"1.0\" encoding = \"GBK\"?>" + 
	       		"<CMS>" + 
	       		"<eb>" + 
	       		"<pub>" + 
	       		"<TransCode>QACCBAL</TransCode>" + 
	       		"<CIS>131190000089723</CIS>" + 
	       		"<BankCode>102</BankCode>" + 
	       		"<ID>hyhl.y.1311</ID>" + 
	       		"<TranDate>"+DateFormatUtil.formatDate(new Date(),DateFormatUtil.PT_YYYYMMDD)+"</TranDate>" + 
	       		"<TranTime>"+DateFormatUtil.formatDate(new Date(),"hhmmssSSS")+"</TranTime>" + 
	       		"<fSeqno>" + fSeqno + "</fSeqno>" + 
	       		"</pub>" + 
	       		"<in>" + 
	       		"<TotalNum>1</TotalNum>" + 
	       		"<BLFlag>1</BLFlag>" + 
	       		"<SynFlag></SynFlag>" + 
	       		"<rd>" + 
	       		"<iSeqno>"+ iSeqno + "</iSeqno>" + 
	       		"<AccNo>1311045029200040348</AccNo>" + 
	       		"<CurrType></CurrType>" + 
	       		"<ReqReserved3></ReqReserved3>" + 
	       		"<AcctSeq></AcctSeq>" + 
	       		"</rd>" + 
	       		"</in>" + 
	       		"</eb>" + 
	       		"</CMS>";

	       xmlcontent = "<?xml version=\"1.0\" encoding = \"GBK\"?>\r\n" + 
	       		"<CMS>\r\n" + 
	       		"<eb>\r\n" + 
	       		"<pub>\r\n" + 
	       		"<TransCode>QACCBAL</TransCode>\r\n" + 
	       		"<CIS>71390256-5AAAAA</CIS>\r\n" + 
	       		"<BankCode>102</BankCode>\r\n" + 
	       		"<ID>hyhl.y.1311</ID>\r\n" + 
	       		"<TranDate>" + DateFormatUtil.formatDate(new Date(),DateFormatUtil.PT_YYYYMMDD) + "</TranDate>\r\n" + 
	       		"<TranTime>" + DateFormatUtil.formatDate(new Date(),"hhmmssSSS") + "</TranTime>\r\n" + 
	       		"<fSeqno>" + fSeqno + "</fSeqno>\r\n" + 
	       		"</pub>\r\n" + 
	       		"<in>\r\n" + 
	       		"<TotalNum>1</TotalNum>\r\n" + 
	       		"<ReqReserved1></ReqReserved1>\r\n" + 
	       		"<ReqReserved2></ReqReserved2>\r\n" + 
	       		"<rd>\r\n" + 
	       		"<iSeqno>1</iSeqno>\r\n" + 
	       		"<AccNo>1311045029200002528</AccNo>\r\n" + 
	       		"<CurrType>001</CurrType>\r\n" + 
	       		"<ReqReserved3></ReqReserved3>\r\n" + 
	       		"<ReqReserved4></ReqReserved4>\r\n" + 
	       		"</rd>\r\n" + 
	       		"</in>\r\n" + 
	       		"</eb>\r\n" + 
	       		"</CMS>";
	       
	       //客户编码
	       //刘慧慧 131190000089723
	       //刘慧慧 71390256-5AAAAA
	       
	       //131190000089723
	       //131190000115752
	       
	       System.out.println("xml报文明文组包:" + xmlcontent);
	       CloseableHttpClient httpClient = null;
	       CloseableHttpResponse httpResponse = null;
	       HttpPost httppost = null;

	       String urlStr1 = "http://" + NCIp + ":" + NCPort+ "/servlet/ICBCCMPAPIReqServlet";
	       
	       urlStr1 = urlStr1 + "?userID=hyhl.y.1311&PackageID=" + fSeqno + "&SendTime=" + DateFormatUtil.formatDate(new Date(),"yyyyMMddHHmmssSSS");

	       try {
	           httpClient = HttpClients.createDefault(); // 构建http客户端
	           httppost = new HttpPost(urlStr1); 
	           httppost.addHeader("Content-Type","application/x-www-form-urlencoded");
	           
	           //创建参数队列
	   			List<NameValuePair> list = new ArrayList<NameValuePair>();
	   		
	   			//存放post请求的参数
	   			list.add(new BasicNameValuePair("PackageID", fSeqno));
	   			list.add(new BasicNameValuePair("Version", "0.0.0.1"));
	   			list.add(new BasicNameValuePair("TransCode", "QACCBAL"));
	   			list.add(new BasicNameValuePair("BankCode", "102"));
	   			//Cert=客户的证书公钥信息（进行BASE64编码；NC客户送空) 
	   			//list.add(new BasicNameValuePair("Cert", ""));
	   			list.add(new BasicNameValuePair("ID", "hyhl.y.1311"));//证书id
	   			//131190000115752
	   			list.add(new BasicNameValuePair("GroupCIS", "71390256-5AAAAA"));//CIS
	   			list.add(new BasicNameValuePair("reqData", xmlcontent));
	   			//list.add(new BasicNameValuePair("SendTime", DateFormatUtil.formatDate(new Date(),"yyyyMMddHHmmssSSS")));
	   			UrlEncodedFormEntity entity;
	   			try {
	   				entity = new UrlEncodedFormEntity(list, "UTF-8");
	   				// 将请求体内容加入请求中
	   				httppost.setEntity(entity);
	   				System.out.println(httppost.getURI());
	   				HttpResponse response = httpClient.execute(httppost);
	   				HttpEntity et = response.getEntity();
	   				if(et != null){
	   					repcontent = EntityUtils.toString(et, "gbk");
	   					System.out.println("工行返回数据如下:" + repcontent);
	   				}
	   				System.out.println("http返回码:" + response.getStatusLine());
	   			} catch (UnsupportedEncodingException e) {
	   				
	   				e.printStackTrace();
	   			} catch (ClientProtocolException e) {
	   				
	   				e.printStackTrace();
	   			} catch (IOException e) {
	   				
	   				e.printStackTrace();
	   			}
	       } catch (Exception e) {
	           e.printStackTrace();
	           System.out.println("银企互联报错:" + e.toString());
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
	       
	       try {
	           repcontent = repcontent.substring(8);
	           System.out.println("银企互联返回----"+repcontent);
	           byte[] decodeResult = getbyteFromBASE64(repcontent);
	           repcontent = new String(decodeResult);
	           System.out.println("base64解码如下:\r\n" + repcontent);
	       } catch (Exception e) {
	           e.printStackTrace();
	           System.out.println("银企互联返回base64报错:" + e.toString());
	       }
	 }
	
	public static Map<String,Object> settleAccounts() {
	       Map result  =  new HashMap();
	       String xmlcontent = ""; // xml报文格式的字符串
	       String signcontent = ""; // 签名返回的信息
	       String repcontent = ""; // 工行返回的信息
	       String NCIp = "127.0.0.1"; //你安装工行系统服务器的ip
	       String NCPort = "448"; // 客户端端口号
	       String NCPort2 = "449"; // 加密端口号
	       String fSeqno ="FRK"+ DateFormatUtil.formatDate(new Date(),"yyyyMMddHHmmss");
	       String time =DateFormatUtil.formatDate(new Date(),"yyyyMMddHHmmssSSS");

	       // 明文组包
	       xmlcontent = "<?xml version=\"1.0\" encoding = \"GBK\"?>" +
	               "<CMS><eb>" +
	               "<pub>" +
	               "<TransCode>PAYENT</TransCode>" +
	               "<CIS></CIS>" +
	               "<BankCode>102</BankCode>" +
	               "<ID></ID>" +
	               "<TranDate>"+DateFormatUtil.formatDate(new Date(),DateFormatUtil.PT_YYYYMMDD)+"</TranDate>" +
	               "<TranTime>"+DateFormatUtil.formatDate(new Date(),"hhmmssSSS")+"</TranTime>" +
	               "<fSeqno>"+fSeqno+"</fSeqno>" +
	               "</pub>" +
	               "<in>" +
	               "<OnlBatF>1</OnlBatF>" +
	               "<SettleMode>0</SettleMode>" +
	               "<TotalNum>1</TotalNum>" +
	               "<TotalAmt>10</TotalAmt>" +
	               "<SignTime>"+time+"</SignTime>" +
	               "<ReqReserved1></ReqReserved1>" +
	               "<ReqReserved2></ReqReserved2>" +
	               "<rd>" +
	               "<iSeqno>1</iSeqno>" +
	               "<ReimburseNo></ReimburseNo>" +
	               "<ReimburseNum></ReimburseNum>" +
	               "<StartDate></StartDate>" +
	               "<StartTime></StartTime>" +
	               "<PayType>2</PayType>" +
	               "<PayAccNo></PayAccNo>" +
	               "<PayAccNameCN></PayAccNameCN>" +
	               "<PayAccNameEN></PayAccNameEN>" +
	               "<RecAccNo></RecAccNo>" +
	               "<RecAccNameCN></RecAccNameCN>" +
	               "<RecAccNameEN></RecAccNameEN>" +
	               "<SysIOFlg>1</SysIOFlg>" +
	               "<IsSameCity></IsSameCity>" +
	               "<Prop>1</Prop>" +
	               "<RecICBCCode></RecICBCCode>" +
	               "<RecCityName></RecCityName>" +
	               "<RecBankNo></RecBankNo>" +
	               "<RecBankName></RecBankName>" +
	               "<CurrType>001</CurrType>" +
	               "<PayAmt>10</PayAmt>" +
	               "<UseCode></UseCode>" +
	               "<UseCN>银企互联测试</UseCN>" +
	               "<EnSummary></EnSummary>" +
	               "<PostScript></PostScript>" +
	               "<Summary></Summary>" +
	               "<Ref>"+fSeqno+"</Ref>" +
	               "<Oref></Oref>" +
	               "<ERPSqn></ERPSqn>" +
	               "<BusCode></BusCode>" +
	               "<ERPcheckno></ERPcheckno>" +
	               "<CrvouhType></CrvouhType>" +
	               "<CrvouhName></CrvouhName>" +
	               "<CrvouhNo></CrvouhNo>" +
	               "<ReqReserved3></ReqReserved3>" +
	               "<ReqReserved4></ReqReserved4>" +
	               "</rd>" +
	               "</in></eb></CMS>";

	       String xmlContent = "<?xml version=\"1.0\" encoding = \"GBK\"?>" +
	                "<CMS><eb>" +
	                "<pub>" +
	                "<TransCode>PAYENT</TransCode>" +
	                "<CIS></CIS>" + //你的cis，自己找工商获取
	                "<BankCode>102</BankCode>" +
	                "<ID></ID>" + // 证书id
	                "<TranDate>"+DateFormatUtil.formatDate(new Date(),DateFormatUtil.PT_YYYYMMDD)+"</TranDate>" +//日期，格式自己看
	                "<TranTime>"+DateFormatUtil.formatDate(new Date(),"hhmmssSSS")+"</TranTime>" +
	                "<fSeqno>"+fSeqno+"</fSeqno>" +  //FDK随机字符 跟下面post到客户端的PackageID一致
	                "</pub>" +
	                "<in>" +
	                "<OnlBatF>1</OnlBatF>" +
	                "<SettleMode>0</SettleMode>" +
	                "<TotalNum>1</TotalNum>" + //这个为此次转账的发起数量（一个xml报文可以发起对多个账号提现）
	                "<TotalAmt>10</TotalAmt>" +//所有转账的总金额，注意这个单位为分
	                "<SignTime>"+time+"</SignTime>" +
	                "<ReqReserved1></ReqReserved1>" +
	                "<ReqReserved2></ReqReserved2>" +
	                "<rd>" +
	                "<iSeqno>1</iSeqno>" +
	                "<ReimburseNo></ReimburseNo>" +
	                "<ReimburseNum></ReimburseNum>" +
	                "<StartDate></StartDate>" +
	                "<StartTime></StartTime>" +
	                "<PayType>2</PayType>" +
	                "<PayAccNo></PayAccNo>" +// 付款方的银行卡账号
	                "<PayAccNameCN></PayAccNameCN>" + //支付的账户名称，需要跟刚才填写的账号对应，实名的，否则报错
	                "<PayAccNameEN></PayAccNameEN>" +
	                "<RecAccNo></RecAccNo>" +//收款方的账号
	                "<RecAccNameCN></RecAccNameCN>" +//收款方的账户名称，也需要跟账号对应
	                "<RecAccNameEN></RecAccNameEN>" +
	                "<SysIOFlg>1</SysIOFlg>" +//第一笔发起
	                "<IsSameCity></IsSameCity>" +
	                "<Prop>1</Prop>" +
	                "<RecICBCCode></RecICBCCode>" +
	                "<RecCityName></RecCityName>" +
	                "<RecBankNo></RecBankNo>" +
	                "<RecBankName></RecBankName>" +
	                "<CurrType>001</CurrType>" +
	                "<PayAmt>10</PayAmt>" +//第一笔发起的金额
	                "<UseCode></UseCode>" +
	                "<UseCN>上线测试</UseCN>" +
	                "<EnSummary></EnSummary>" +
	                "<PostScript></PostScript>" +
	                "<Summary></Summary>" +
	                "<Ref>"+fSeqno+"</Ref>" +
	                "<Oref></Oref>" +
	                "<ERPSqn></ERPSqn>" +
	                "<BusCode></BusCode>" +
	                "<ERPcheckno></ERPcheckno>" +
	                "<CrvouhType></CrvouhType>" +
	                "<CrvouhName></CrvouhName>" +
	                "<CrvouhNo></CrvouhNo>" +
	                "<ReqReserved3></ReqReserved3>" +
	                "<ReqReserved4></ReqReserved4>" +
	                "</rd>" +
	                "</in></eb></CMS>";
//			System.out.println(xmlContent);
	       
	       String dataTime =DateFormatUtil.formatDate(new Date(),"yyyyMMddHHmmss");

	       System.out.println("xml报文明文组包:" + xmlcontent);
	       CloseableHttpClient httpClient = null;
	       CloseableHttpResponse httpResponse = null;
	       HttpPost httppost = null;

	       // 如果明文xmlcontent中包括SignTime节点，即该交易需要签名
	       if (xmlcontent.indexOf("<SignTime>") > -1) {
	           try {
	               httpClient = HttpClients.createDefault(); // 构建http客户端
	               httppost = new HttpPost("http://" + NCIp + ":" + NCPort2); // 加密端口
	               httppost.addHeader("Content-Type", "INFOSEC_SIGN/1.0");
	               InputStream in = new ByteArrayInputStream(xmlcontent.getBytes());
	               InputStreamEntity entity = new InputStreamEntity(in);
	               httppost.setEntity(entity);
	               httpResponse = httpClient.execute(httppost); // 获得http返回码
	               System.out.println("返回响应: " + httpResponse.getStatusLine());
	               System.out.println("响应内容：" + EntityUtils.toString(httpResponse.getEntity()));
	               
	               String postResult = EntityUtils.toString(httpResponse.getEntity());
	               signcontent = new String(postResult.getBytes("ISO8859-1"),"gb2312");
	               System.out.println("NC签名返回数据如下:" + signcontent);
	           } catch (Exception e) {
	        	   System.out.println("签名出错:"+ e.toString());
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

	           signcontent.replaceAll("\n", "");
	           int beginSign = signcontent.indexOf("<sign>") + 6;
	           int endSign = signcontent.indexOf("</sign>");
	           signcontent = signcontent.substring(beginSign, endSign);
	           System.out.println("签名:"+ signcontent);
	       } else {
	           //如果不需要签名直接放明文
	           signcontent = xmlcontent;
	       }

	       String urlStr1 = "http://" + NCIp + ":" + NCPort+ "/servlet/ICBCCMPAPIReqServlet";

	       try {
	           httpClient = HttpClients.createDefault(); // 构建http客户端
	           httppost = new HttpPost(urlStr1); // 加密端口
	           httppost.addHeader("Content-Type","application/x-www-form-urlencoded");
	           
	           //创建参数队列
	   			List<NameValuePair> list = new ArrayList<NameValuePair>();
	   		
	   			//存放post请求的参数
	   			list.add(new BasicNameValuePair("PackageID", fSeqno));
	   			list.add(new BasicNameValuePair("Version", "1.0"));
	   			list.add(new BasicNameValuePair("TransCode", "PAYENT"));
	   			list.add(new BasicNameValuePair("BankCode", "102"));
	   			list.add(new BasicNameValuePair("Cert", ""));
	   			list.add(new BasicNameValuePair("ID", ""));//证书id
	   			list.add(new BasicNameValuePair("GroupCIS", ""));//CIS
	   			list.add(new BasicNameValuePair("reqData", signcontent));
	   			
	   			UrlEncodedFormEntity entity;
	   			try {
	   				entity = new UrlEncodedFormEntity(list,"UTF-8");
	   				// 将请求体内容加入请求中
	   				httppost.setEntity(entity);
	   				System.out.println(httppost.getURI());
	   				HttpResponse response = httpClient.execute(httppost);
	   				HttpEntity et = response.getEntity();
	   				if(et != null){
	   					repcontent = EntityUtils.toString(et);
	   					System.out.println("工行返回数据如下:" + repcontent);
	   				}
	   				System.out.println("http返回码:" + response.getStatusLine());
	   			} catch (UnsupportedEncodingException e) {
	   				
	   				e.printStackTrace();
	   			} catch (ClientProtocolException e) {
	   				
	   				e.printStackTrace();
	   			} catch (IOException e) {
	   				
	   				e.printStackTrace();
	   			}
	       } catch (Exception e) {
	           e.printStackTrace();
	           System.out.println("银企互联报错:" + e.toString());
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
	       try {
	           repcontent = repcontent.substring(8);
	           System.out.println("银企互联返回----"+repcontent);
	           byte[] decodeResult = getbyteFromBASE64(repcontent);
	           repcontent = new String(decodeResult);
	           System.out.println("base64解码如下:" + repcontent);
	           System.out.println("base64解码如下:" + repcontent);
	           result.put("xml",repcontent);
	           result.put("result","true");
	       } catch (Exception e) {
	           e.printStackTrace();
	           System.out.println("银企互联返回base64报错:" + e.toString());
	           result.put("result","false");
	           result.put("message",e.toString());
	       }
	       return  result;
	 }
	
	/**
	 * base64解码
	 * @param s:需要解码的数据
	 * @return 解码后的数据
	 */
		public static String getstrFromBASE64(String s) {
			if (s == null)
				return null;
//			sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
			try {
//				byte[] b = decoder.decodeBuffer(s);
//				return new String(b);
			} catch (Exception e) {
				return null;
			}
			return s;
		}
	/**
	 * base64解码
	 * @param s:需要解码的数据
	 * @return 解码后的数据
	 */
		public static byte[] getbyteFromBASE64(String s) {
			if (s == null)
				return null;
//			sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
			try {
//				return decoder.decodeBuffer(s);
			} catch (Exception e) {
				return null;
			}
			return s.getBytes();
		}
	/**
	 * base64编码
	 * @param s:需要编码的数据
	 * @return  编码后的数据
	 */
		public static String getrevFromBASE64(byte[] s) {
			if (s == null)
				return null;
//			sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
			try {
//				return encoder.encode(s);
			} catch (Exception e) {
				return null;
			}
			return new String(s);
		}
}
