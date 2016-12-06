package com.zeyu.util;

public class CRC16 {

	public static int calc(short []bt,int pos,int length) 
	{
		int crc = 0xFFFF;
		for (int i = pos; i < pos + length; i++) {
			int b = bt[i];
			int x16 = 0;
			for (int j = 0; j < 8; j++) {
				if (((crc & 0x0001) ^ (b & 0x01)) > 0)
					x16 = 0x8408;
				else
					x16 = 0x0000;

				crc = crc >> 1;
				crc ^= x16;
				b = b >> 1;
			}
		}
		return crc;
	}
}
