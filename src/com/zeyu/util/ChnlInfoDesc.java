package com.zeyu.util;

public class ChnlInfoDesc {
		//根据chnlType选择不同的通道
		//根据subType选择显示不同的内容
		public static String GetChnlDesc(final int chnlType,final int subType)
		{
			StringBuilder sb = new StringBuilder();
			sb.append("ChnlInfo:");
			switch(chnlType)
			{
			case 0x00:sb.append("系统通道");
				switch(subType)
				{
				case 0x01:sb.append("-系统状态"); break;
				case 0x02:sb.append("-电源电压");break;
				case 0x03:sb.append("-日期(BCD码：YYMMDDHHMMSS)");break;
				}
				break;
			case 0x01:sb.append("大气温度通道");
				switch(subType)
				{
				case 0x01:sb.append("-大气温度值"); break;
				case 0x02:sb.append("-小时最大值"); break;
				case 0x03:sb.append("-小时最小值"); break;
				case 0x04:sb.append("-小时最大值出现的时间(BCD码：MM)"); break;
				case 0x05:sb.append("-小时最小值出现的时间(BCD码：MM)"); break;
				case 0x06:sb.append("-当日最大值"); break;
				case 0x07:sb.append("-当日最小值"); break;
				case 0x08:sb.append("-当日最大值出现的时间(BCD码：HHMM)"); break;
				case 0x09:sb.append("-当日最小值出现的时间(BCD码：HHMM)"); break;
				}
			break;
			case 0x02:sb.append("大气湿度通道");
				switch(subType)
				{
				case 0x01:sb.append("-大气湿度值"); break;
				case 0x02:sb.append("-小时最大值"); break;
				case 0x03:sb.append("-小时最小值"); break;
				case 0x04:sb.append("-小时最大值出现的时间(BCD码：MM)"); break;
				case 0x05:sb.append("-小时最小值出现的时间(BCD码：MM)"); break;
				case 0x06:sb.append("-当日最大值"); break;
				case 0x07:sb.append("-当日最小值"); break;
				case 0x08:sb.append("-当日最大值出现的时间(BCD码：HHMM)"); break;
				case 0x09:sb.append("-当日最小值出现的时间(BCD码：HHMM)"); break;
				}
				break;
			case 0x03:sb.append("大气压力通道");
				switch(subType)
				{
				case 0x01:sb.append("-大气压力值"); break;
				case 0x02:sb.append("-小时最大值"); break;
				case 0x03:sb.append("-小时最小值"); break;
				case 0x04:sb.append("-小时最大值出现的时间(BCD码：MM)"); break;
				case 0x05:sb.append("-小时最小值出现的时间(BCD码：MM)"); break;
				case 0x06:sb.append("-当日最大值"); break;
				case 0x07:sb.append("-当日最小值"); break;
				case 0x08:sb.append("-当日最大值出现的时间(BCD码：HHMM)"); break;
				case 0x09:sb.append("-当日最小值出现的时间(BCD码：HHMM)"); break;
				}
				break;
			case 0x05:sb.append("风通道");
				switch(subType)
				{
				case 0x01:sb.append("-3秒风速值"); break;
				case 0x02:sb.append("-3秒风向值"); break;
				case 0x03:sb.append("-2分钟风速值"); break;
				case 0x04:sb.append("-2分钟风向值"); break;
				case 0x05:sb.append("-10分钟风速值"); break;
				case 0x06:sb.append("-10分钟风向值"); break;
				case 0x07:sb.append("-最大风速值"); break;
				case 0x08:sb.append("-最大风速对应风向值"); break;
				case 0x09:sb.append("-最大值出现的时间(BCD码：MM)"); break;
				case 0x0A:sb.append("-极大风速值"); break;
				case 0x0B:sb.append("-极大风速对应风向值"); break;
				case 0x0C:sb.append("-极大值出现的时间(BCD码：MM)"); break;
				}
				break;
			case 0x06:sb.append("降雨通道");
				switch(subType)
				{
				case 0x01:sb.append("-当日降雨值"); break;
				case 0x02:sb.append("-小时降雨值"); break;
				case 0x03:sb.append("-分钟降雨值"); break;
				case 0x04:sb.append("-当日最大分钟降雨值"); break;
				case 0x05:sb.append("-当日最大值出现的时间(BCD码：HHMM)"); break;
				}
				break;
			case 0x07:sb.append("土壤温度通道");
				switch(subType)
				{
				case 0x01:sb.append("-土壤温度值"); break;
				case 0x02:sb.append("-小时最大值"); break;
				case 0x03:sb.append("-小时最小值"); break;
				case 0x04:sb.append("-小时最大值出现的时间(BCD码：MM)"); break;
				case 0x05:sb.append("-小时最小值出现的时间(BCD码：MM)"); break;
				case 0x06:sb.append("-当日最大值"); break;
				case 0x07:sb.append("-当日最小值"); break;
				case 0x08:sb.append("-当日最大值出现的时间(BCD码：HHMM)"); break;
				case 0x09:sb.append("-当日最小值出现的时间(BCD码：HHMM)"); break;
				}
				break;
			case 0x08:sb.append("土壤湿度通道");
				switch(subType)
				{
				case 0x01:sb.append("-土壤湿度值"); break;
				case 0x02:sb.append("-小时最大值"); break;
				case 0x03:sb.append("-小时最小值"); break;
				case 0x04:sb.append("-小时最大值出现的时间(BCD码：MM)"); break;
				case 0x05:sb.append("-小时最小值出现的时间(BCD码：MM)"); break;
				case 0x06:sb.append("-当日最大值"); break;
				case 0x07:sb.append("-当日最小值"); break;
				case 0x08:sb.append("-当日最大值出现的时间(BCD码：HHMM)"); break;
				case 0x09:sb.append("-当日最小值出现的时间(BCD码：HHMM)"); break;
				}
				break;
			case 0x09:sb.append("表面温度通道");
				switch(subType)
				{
				case 0x01:sb.append("-表面温度值"); break;
				case 0x02:sb.append("-小时最大值"); break;
				case 0x03:sb.append("-小时最小值"); break;
				case 0x04:sb.append("-小时最大值出现的时间(BCD码：MM)"); break;
				case 0x05:sb.append("-小时最小值出现的时间(BCD码：MM)"); break;
				case 0x06:sb.append("-当日最大值"); break;
				case 0x07:sb.append("-当日最小值"); break;
				case 0x08:sb.append("-当日最大值出现的时间(BCD码：HHMM)"); break;
				case 0x09:sb.append("-当日最小值出现的时间(BCD码：HHMM)"); break;
				}
				break;
			case 0x0A:sb.append("总辐射通道");
				switch(subType)
				{
				case 0x01:sb.append("-总辐射值"); break;
				case 0x02:sb.append("-小时最大值"); break;
				case 0x03:sb.append("-小时最小值"); break;
				case 0x04:sb.append("-小时最大值出现的时间(BCD码：MM)"); break;
				case 0x05:sb.append("-小时最小值出现的时间(BCD码：MM)"); break;
				case 0x06:sb.append("-当日最大值"); break;
				case 0x07:sb.append("-当日最小值"); break;
				case 0x08:sb.append("-当日最大值出现的时间(BCD码：HHMM)"); break;
				case 0x09:sb.append("-当日最小值出现的时间(BCD码：HHMM)"); break;
				}
				break;
			case 0x0B:sb.append("紫外辐射通道");
				switch(subType)
				{
				case 0x01:sb.append("-紫外辐射值"); break;
				case 0x02:sb.append("-小时最大值"); break;
				case 0x03:sb.append("-小时最小值"); break;
				case 0x04:sb.append("-小时最大值出现的时间(BCD码：MM)"); break;
				case 0x05:sb.append("-小时最小值出现的时间(BCD码：MM)"); break;
				case 0x06:sb.append("-当日最大值"); break;
				case 0x07:sb.append("-当日最小值"); break;
				case 0x08:sb.append("-当日最大值出现的时间(BCD码：HHMM)"); break;
				case 0x09:sb.append("-当日最小值出现的时间(BCD码：HHMM)"); break;
				}
				break;
			case 0x0C:sb.append("光合辐射通道");
				switch(subType)
				{
				case 0x01:sb.append("-光合辐射值"); break;
				case 0x02:sb.append("-小时最大值"); break;
				case 0x03:sb.append("-小时最小值"); break;
				case 0x04:sb.append("-小时最大值出现的时间(BCD码：MM)"); break;
				case 0x05:sb.append("-小时最小值出现的时间(BCD码：MM)"); break;
				case 0x06:sb.append("-当日最大值"); break;
				case 0x07:sb.append("-当日最小值"); break;
				case 0x08:sb.append("-当日最大值出现的时间(BCD码：HHMM)"); break;
				case 0x09:sb.append("-当日最小值出现的时间(BCD码：HHMM)"); break;
				}
				break;
			case 0x0D:sb.append("直接辐射通道");
				switch(subType)
				{
				case 0x01:sb.append("-直接辐射值"); break;
				case 0x02:sb.append("-小时最大值"); break;
				case 0x03:sb.append("-小时最小值"); break;
				case 0x04:sb.append("-小时最大值出现的时间(BCD码：MM)"); break;
				case 0x05:sb.append("-小时最小值出现的时间(BCD码：MM)"); break;
				case 0x06:sb.append("-当日最大值"); break;
				case 0x07:sb.append("-当日最小值"); break;
				case 0x08:sb.append("-当日最大值出现的时间(BCD码：HHMM)"); break;
				case 0x09:sb.append("-当日最小值出现的时间(BCD码：HHMM)"); break;
				}
				break;
			case 0x0E:sb.append("净全辐射通道");
				switch(subType)
				{
				case 0x01:sb.append("-净全辐射值"); break;
				case 0x02:sb.append("-小时最大值"); break;
				case 0x03:sb.append("-小时最小值"); break;
				case 0x04:sb.append("-小时最大值出现的时间(BCD码：MM)"); break;
				case 0x05:sb.append("-小时最小值出现的时间(BCD码：MM)"); break;
				case 0x06:sb.append("-当日最大值"); break;
				case 0x07:sb.append("-当日最小值"); break;
				case 0x08:sb.append("-当日最大值出现的时间(BCD码：HHMM)"); break;
				case 0x09:sb.append("-当日最小值出现的时间(BCD码：HHMM)"); break;
				}
				break;
			case 0x0F:sb.append("散射通道");
				switch(subType)
				{
				case 0x01:sb.append("-散射值"); break;
				case 0x02:sb.append("-小时最大值"); break;
				case 0x03:sb.append("-小时最小值"); break;
				case 0x04:sb.append("-小时最大值出现的时间(BCD码：MM)"); break;
				case 0x05:sb.append("-小时最小值出现的时间(BCD码：MM)"); break;
				case 0x06:sb.append("-当日最大值"); break;
				case 0x07:sb.append("-当日最小值"); break;
				case 0x08:sb.append("-当日最大值出现的时间(BCD码：HHMM)"); break;
				case 0x09:sb.append("-当日最小值出现的时间(BCD码：HHMM)"); break;
				}
				break;
			case 0x10:sb.append("日照时数通道");
				switch(subType)
				{
				case 0x01:sb.append("-日照时数值"); break;
				case 0x02:sb.append("-小时最大值"); break;
				case 0x03:sb.append("-小时最小值"); break;
				case 0x04:sb.append("-小时最大值出现的时间(BCD码：MM)"); break;
				case 0x05:sb.append("-小时最小值出现的时间(BCD码：MM)"); break;
				case 0x06:sb.append("-当日最大值"); break;
				case 0x07:sb.append("-当日最小值"); break;
				case 0x08:sb.append("-当日最大值出现的时间(BCD码：HHMM)"); break;
				case 0x09:sb.append("-当日最小值出现的时间(BCD码：HHMM)"); break;
				}
				break;
			case 0x11:sb.append("能见度通道");
				switch(subType)
				{
				case 0x01:sb.append("-能见度值"); break;
				case 0x02:sb.append("-小时最大值"); break;
				case 0x03:sb.append("-小时最小值"); break;
				case 0x04:sb.append("-小时最大值出现的时间(BCD码：MM)"); break;
				case 0x05:sb.append("-小时最小值出现的时间(BCD码：MM)"); break;
				case 0x06:sb.append("-当日最大值"); break;
				case 0x07:sb.append("-当日最小值"); break;
				case 0x08:sb.append("-当日最大值出现的时间(BCD码：HHMM)"); break;
				case 0x09:sb.append("-当日最小值出现的时间(BCD码：HHMM)"); break;
				}
				break;
			case 0x12:sb.append("水位通道");
				switch(subType)
				{
				case 0x01:sb.append("-水位值"); break;
				case 0x02:sb.append("-小时最大值"); break;
				case 0x03:sb.append("-小时最小值"); break;
				case 0x04:sb.append("-小时最大值出现的时间(BCD码：MM)"); break;
				case 0x05:sb.append("-小时最小值出现的时间(BCD码：MM)"); break;
				case 0x06:sb.append("-当日最大值"); break;
				case 0x07:sb.append("-当日最小值"); break;
				case 0x08:sb.append("-当日最大值出现的时间(BCD码：HHMM)"); break;
				case 0x09:sb.append("-当日最小值出现的时间(BCD码：HHMM)"); break;
				}
				break;
			case 0xE0:sb.append("告警通道");
				switch(subType)
				{
				case 0x01:sb.append("-日雨量报警"); break;
				case 0x02:sb.append("-一小时雨量报警"); break;
				case 0x03:sb.append("-三小时雨量报警"); break;
				case 0x04:sb.append("-低温报警"); break;
				case 0x05:sb.append("-高温报警"); break;
				case 0x06:sb.append("-大风报警"); break;
				case 0x07:sb.append("-低电压报警"); break;
				case 0x08:sb.append("-雪深报警"); break;
				case 0x09:sb.append("-其它报警"); break;
				case 0x0a:sb.append("-其它报警"); break;
				case 0x0b:sb.append("-其它报警"); break;
				case 0x0c:sb.append("-其它报警"); break;
				}
				break;
			}
			
			return sb.toString();
		}
}
