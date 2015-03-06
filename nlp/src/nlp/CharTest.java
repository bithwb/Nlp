/*
 * ChnSeg1.0�����ķִʣ���Ȩ���������У������κ���ҵ��;�����ĺ�����߸Ų�����
 * �������ʹ�õĹ����з���bug������ϵ���ߡ�
 * email��wu_j_q@126.com
 * QQ��12537862
 */

package nlp;
/**
 * �ַ����,����Ƿ�����Ч�ַ�,�����Ƿ�������,Ӣ���ַ���,����ȫ�ǺͰ��
 * @author �⽨ǿ
 *
 */
public class CharTest {
	/**�����ַ�*/
	public static final int OTHER 		= -1; 
	/**�ı�����ı����������֣�����ȫ�ǺͰ��*/
	public static final int NUMBER 		= 0; 
	/**�ı�����ı�������Ӣ����ĸ������ȫ�ǺͰ��*/
	public static final int CHAR 		= 1; 
	/**�ı�����ı��������������֣���һ*/
	public static final int CHNNUMBER 	= 2; 
	/**�ı�����ı������������ַ�*/
	public static final int CHINESE 	= 3; 

	
	/**
	 * ���c�Ƿ��������ַ�,����Ƿ���true
	 * @param c
	 * @return
	 */
	public static boolean isChinese(char c){
		int i = (int)c;
		if (i >= 19968 && i <= 40869) return true;
		else return false;
	}
	/**
	 * ���c�Ƿ���0����9������ȫ�ǺͰ��,����Ƿ���true
	 * @param c
	 * @return
	 */
	public static boolean isNumber(char c){
		int i = (int)c;
		if ((i >= 48 && i <= 57) || (i >= 65296 && i <= 65305 ))
			return true;
		else return false;
	}
	/**
	 * ���c�Ƿ�����ĸ��������Сд��ȫ�ǺͰ��,����Ƿ���true
	 * @param c
	 * @return
	 */
	public static boolean isChar(char c){
		int i = (int)c;
		if ((i >= 65 && i <= 90) || (i >= 97 && i <= 122) ||
				(i >= 65313 && i <= 65338) || (i >= 65345 && i <= 65370))
			return true;
		else return false;
	}
	/**
	 * ���c�Ƿ������ĵ�һ����,����Ƿ���true
	 * @param c
	 * @return
	 */
	public static boolean isChnNumber(char c){
		if (c == 'һ') return true;
		if (c == '��') return true;
		if (c == '��') return true;
		if (c == '��') return true;
		if (c == '��') return true;
		if (c == '��') return true;
		if (c == '��') return true;
		if (c == '��') return true;
		if (c == '��') return true;
		else return false;
	}
	/**
	 * ���һ���ַ�����ʲô����
	 * @param c
	 * @return
	 */
	public static int testChar(char c){
		if (isChinese(c)) return CHINESE;
		if (isChar(c)) return CHAR;
		if (isNumber(c)) return NUMBER;
		else return OTHER;
	}
}
