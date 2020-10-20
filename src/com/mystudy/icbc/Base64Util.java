package com.mystudy.icbc;

public class Base64Util {
	
	public static void main(String[] args) {
		
		String str = "PD94bWwgIHZlcnNpb249IjEuMCIgZW5jb2Rpbmc9IkdCSyIgPz4KPENNUz4KPGViPgo8cHViPgo8\r\n" + 
				"VHJhbnNDb2RlPlFBQ0NCQUw8L1RyYW5zQ29kZT4KPENJUz43MTM5MDI1Ni01QUFBQUE8L0NJUz4K\r\n" + 
				"PEJhbmtDb2RlPjEwMjwvQmFua0NvZGU+CjxJRD5oeWhsLnkuMTMxMTwvSUQ+CjxUcmFuRGF0ZT4y\r\n" + 
				"MDIwMTAxOTwvVHJhbkRhdGU+CjxUcmFuVGltZT4wODM5NTM0ODA8L1RyYW5UaW1lPgo8ZlNlcW5v\r\n" + 
				"PkZSSzIwMjAxMDIwMTQwMTA2MjI4PC9mU2Vxbm8+CjxSZXRDb2RlPjA8L1JldENvZGU+CjxSZXRN\r\n" + 
				"c2c+PC9SZXRNc2c+CjwvcHViPgo8b3V0Pgo8cmQ+CjxpU2Vxbm8+MTwvaVNlcW5vPgo8QWNjTm8+\r\n" + 
				"MTMxMTA0NTAyOTIwMDA0MDM0ODwvQWNjTm8+CjxDdXJyVHlwZT4wMDE8L0N1cnJUeXBlPgo8Q2Fz\r\n" + 
				"aEV4Zj4wPC9DYXNoRXhmPgo8QWNjdFByb3BlcnR5PjAwNDwvQWNjdFByb3BlcnR5Pgo8QWNjQmFs\r\n" + 
				"YW5jZT41MDEyOTI0PC9BY2NCYWxhbmNlPgo8QmFsYW5jZT45MDg2Nzg2Mjc8L0JhbGFuY2U+CjxV\r\n" + 
				"c2FibGVCYWxhbmNlPjkwODY3ODYyNzwvVXNhYmxlQmFsYW5jZT4KPEZyekFtdD4wPC9GcnpBbXQ+\r\n" + 
				"CjxRdWVyeVRpbWU+MjAyMDEwMjAxNDAxMDAwMDAwMzQ8L1F1ZXJ5VGltZT4KPGlSZXRDb2RlPjA8\r\n" + 
				"L2lSZXRDb2RlPgo8aVJldE1zZz48L2lSZXRNc2c+CjxSZXBSZXNlcnZlZDM+PC9SZXBSZXNlcnZl\r\n" + 
				"ZDM+CjxSZXBSZXNlcnZlZDQ+PC9SZXBSZXNlcnZlZDQ+CjwvcmQ+Cjwvb3V0Pgo8L2ViPgo8L0NN\r\n" + 
				"Uz4K";
				
		System.out.println("银企互联返回:\r\n"+str);
	    byte[] decodeResult = getbyteFromBASE64(str);
	    str = new String(decodeResult);
	    System.out.println("base64解码如下:\r\n" + str);
		
		System.out.println("Hello Java World!!!");
	}
	
	/**
	 * base64解码
	 * @param s:需要解码的数据
	 * @return 解码后的数据
	 */
		public static String getstrFromBASE64(String s) {
			if (s == null)
				return null;
			sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
			try {
				byte[] b = decoder.decodeBuffer(s);
				return new String(b);
			} catch (Exception e) {
				return null;
			}
		}
	/**
	 * base64解码
	 * @param s:需要解码的数据
	 * @return 解码后的数据
	 */
		public static byte[] getbyteFromBASE64(String s) {
			if (s == null)
				return null;
			sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
			try {
				return decoder.decodeBuffer(s);
			} catch (Exception e) {
				return null;
			}
		}
	/**
	 * base64编码
	 * @param s:需要编码的数据
	 * @return  编码后的数据
	 */
		public static String getrevFromBASE64(byte[] s) {
			if (s == null)
				return null;
			sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
			try {
				return encoder.encode(s);
			} catch (Exception e) {
				return null;
			}
		}
}
