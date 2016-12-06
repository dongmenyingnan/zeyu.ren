package com.zeyu.util;

public class DataConvert {

	//这里说的前面的类型是协议里面的，不是语言里面的
	
		//把C里面的byte转换为byte
		public static byte CByte2Byte(byte bt)
		{
			return  (byte) ((bt>=0 && bt<128)?bt:(bt-256));
		}
		
		//把C里面的byte数据转换为整数
		public static int CByte2Int(byte bt)
		{
			return (int) ((256+bt)%256);
		}
		//把两个cbyte表示的unsigned int 转换为int
		public static int CUnsignedInt2Int(byte btH,byte btL)
		{
			return CByte2Int(btH)<<8 | CByte2Int(btL);
		}
		
		//把int转换为两个cbyte表示的unsigned int
		public static byte[] Int2CUnsignedInt(int iv)
		{
			byte[]rtv=new byte[2];
			rtv[0]=CByte2Byte((byte) (iv>>8));
			rtv[1]=CByte2Byte((byte) (iv&0xFF));
			return rtv;
		}
		
		//把两个cbyte表示的signed int 转换为int
		public static int CSignedInt2Int(byte btH,byte btL)
		{
			return ((int)btH)<<8 | CByte2Int(btL);
		}
		//把四个cbyte表示的unsigned long转换为long
		public static long CUnsignedLong2long(byte bt4,byte bt3,byte bt2,byte bt1)
		{
			return (long)CByte2Int(bt4)<<24 | CByte2Int(bt3)<<16 | CByte2Int(bt2)<<8|CByte2Int(bt1);
		}
		//把四个cbyte表示的signed long转换为long
		public static long CSignedLong2Long(byte bt4,byte bt3,byte bt2,byte bt1)
		{
			return ((long)bt4)<<24 | CByte2Int(bt3)<<16 | CByte2Int(bt2)<<8|CByte2Int(bt1);
		}
		
		public static String bcd2Str(byte[] bytes) {  
	        StringBuffer temp = new StringBuffer(bytes.length * 2);  
	        for (int i = 0; i < bytes.length; i++) {  
	            temp.append((byte) ((bytes[i] & 0xf0) >>> 4));  
	            temp.append((byte) (bytes[i] & 0x0f));  
	        }  
	        return temp.toString().substring(0, 1).equalsIgnoreCase("0") ? temp  
	                .toString().substring(1) : temp.toString();  
	    }
		//
		public static float Div10Int2Float(int vi)
		{
			return ((float)vi)/10;
		}
		
		public static byte[] hex2byte(String hex) {
	        String digital = "0123456789ABCDEF";
	        char[] hex2char = hex.toCharArray();
	        byte[] bytes = new byte[hex.length() / 2];
	        int temp;
	        for (int i = 0; i < bytes.length; i++) {
	            temp = digital.indexOf(hex2char[2 * i]) * 16;
	            bytes[i] = (byte) (temp & 0xff);
	        }
	        return bytes;
	    }
		public static byte int2OneByte(int num) {
	        return (byte) (num & 0xff);  
	    }  
		
		public static void main(String[] args){
			int indexi = DataConvert.CByte2Int((byte)DataConvert.CByte2Int((byte)62));
			System.out.println(indexi);
		}
}
