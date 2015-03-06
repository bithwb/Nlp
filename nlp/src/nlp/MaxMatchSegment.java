
package nlp;

import java.util.ArrayList;
import java.util.List;
//import com.xq.util.CharTest;
//import com.xq.util.File;
//import com.xq.util.Search;


/**
 * ���ƥ��ִʣ���ÿ�����䰴���������ִʣ�ȡ��С�ִ����Ľ��������ִ�������ȣ�ȡ����ִʵĽ��
 *
 */
public class MaxMatchSegment implements Segment {
	/**
	 * �ı����ŵĻ�����
	 */
	private List lstTextBlock = null;
	/**
	 * ���ڷִʵ��ֵ�
	 */
	private SubDictionary dictionary1 = null;
	
	/**
	 * ʵ�ִַʵĽӿڣ������ò�ͬ���ֵ�Բ�ͬ�ı��ִ�
	 */
	public String segment(String sourc,SubDictionary dictionary) {
		String result = "";
		this.dictionary1= dictionary;
		filter(sourc);
		result = make();
		return result;
	}
	/**
	 * ����lstTextBlock�Ĺ����������ɲ���ַ���
	 * @return
	 */
	private String make(){
		String result = "";
		TextBlock block = null;
		int i = 0;
		if (lstTextBlock == null) return null;
		for (i = 0; i < lstTextBlock.size(); i++){
			block = (TextBlock)lstTextBlock.get(i);
			//System.out.println(block.getText());
			result += operate(block);
		}
		return result;
	}
	/**
	 * ����block���ݣ����������ַ�ʱ��֣���������������
	 * @param block
	 * @return
	 */
	private String operate(TextBlock block){
		String result = "";
		List list1 = null;
		List list2 = null;
		if (block.getProperty() != CharTest.CHINESE){
			result = block.getText() + " ";
		}else{
			list1 = segmentChnLToR(block.getText());
//			for (int i = 0; i < list1.size(); i++) {
//				result+=list1.get(i)+"/";
//			}
			list2 = segmentChnRToL(block.getText());
			result = compare(list1, list2);
		}
		return result;
	}
	/**
	 * �Ƚ�����ͷ����������ƥ�䣬���طִʽ��������������ķִʽ��һ�£������ַ�����
	 * ����һ�£����س���С�ģ�������һ�£����ط����
	 * @param list1
	 * @param list2
	 * @return
	 */
	private String compare(List list1, List list2){
		List list = null;
		String result = "";
		int i;
		String temp = "";
		boolean equal = true;
		int len1 = 0;
		int len2 = 0;
		int len = 0;
		
		if (list1 == null) return "";
		if (list2 == null) return "";
		//�����ã�������list���Ȳ����ʱ��������ִַʽ�������ڷ���
//		if (list1.size() != list2.size()) equal = false;
//		else{
//			for (i = 0; i < list1.size(); i++){
//				if (!((String)list1.get(i)).equals((String)list2.get(i))){
//					equal = false;
//					break;
//				}
//			}
//		}
//		if (!equal){
//			temp = "";
//			for (i = 0; i < list1.size(); i++){
//				temp += list1.get(i) + "/";
//			}
//			System.out.println("����ִʣ�" + temp);
//			temp = "";
//			for (i = 0; i < list2.size(); i++){
//				temp += list2.get(i) + "/";
//			}
//			System.out.println("����ִʣ�" + temp);
//			
//		}
//		
		
		if (list1.size() < list2.size()){
			list = list1;
		}else if (list1.size() > list2.size()){
			list = list2;
		}else{
			for (i = 0; i < list1.size(); i++){
				len = ((String)list1.get(i)).length();
				if (len1 < len) len1 = len;
				len = ((String)list2.get(i)).length();
				if (len2 < len) len2 = len;
			}
			if (len1 > len2) list = list1;
			else list = list2;
		}
		for (i = 0; i < list.size(); i++){
			result += list.get(i) + "/";
		}
		return result;
	}
	/**
	 * ���һ�ν������������ַ��Ĵ���������������ƥ��
	 * @param source
	 * @return
	 */
	private List segmentChnRToL(String source){
		//String result = "";
		String temp = "";
		List list = new ArrayList();
		List list1 = new ArrayList();
		int wordLen = dictionary1.getWordLen();
		int start = 0;
		int length = source.length();
		int minReadLen = 0;
		//if (wordLen.length == 0) return null;
		//minReadLen = wordLen;
		while (start < length&&length-start!=1){
			minReadLen = wordLen;
			if (minReadLen > (length - start)){
				minReadLen = length - start;
			}
			while(minReadLen > 1){
				temp = source.substring(length - start - minReadLen, length - start);
				if (dictionary1.find(temp)){
					break;
				}else{
					minReadLen--;
				}
			}
			temp = source.substring(length - start - minReadLen, length - start);
			list.add(temp);
			start += minReadLen;
		}
		for (int i = list.size() - 1; i >= 0; i--){
			temp = (String)list.get(i);
			list1.add(temp);
		}
		return list1;
	}
	/**
	 * ���һ�ν������������ַ��Ĵ�����������������ƥ��
	 * @param source
	 * @return
	 */
	private List segmentChnLToR(String source){
		//String result = "";
		String temp = "";
		List list = new ArrayList();
		int wordLen = dictionary1.getWordLen();
		//System.out.println(wordLen.length);
		int start = 0;
		int length = source.length();
		//System.out.println(length);
		int minReadLen = 0;
		//if (wordLen.length == 0) return null;
		//minReadLen = wordLen;
		//System.out.println(minReadLen);
		while (start < length){
			minReadLen = wordLen;
			//System.out.println(minReadLen);
			if (minReadLen > (length - start)){
				minReadLen = length - start;
			}
			while(minReadLen > 1){
				temp = source.substring(start, start + minReadLen);
				//System.out.println(temp+dictionary1.find(temp));
				if (dictionary1.find(temp)){
					break;
				}else{
					minReadLen--;
				}
			}
			temp = source.substring(start, start + minReadLen);
			//System.out.println(temp);
			list.add(temp);
			start += minReadLen;
		}
		//return result;
		return list;
	}
	/**
	 * ����Ҫ�ָ�Ĵ������˺�Ľ�������lstTextBlock
	 * @param source
	 */
	private void filter(String source){
		lstTextBlock = new ArrayList();
		TextBlock block = null;
		String temp = "";
		int type = 0;
		int tmpType = 0;
		int i = 0;
		char c;
		c = source.charAt(0);
		//System.out.println(c);
		type = CharTest.testChar(c);
		temp += c;
		for (i = 1; i < source.length(); i++){
			c = source.charAt(i);
			tmpType = CharTest.testChar(c);
			if (tmpType == type){
				temp += c;
			}else{
				block = new TextBlock(temp, type);
				lstTextBlock.add(block);
				type = tmpType;
				temp = "" + c;
			}
		}
		block = new TextBlock(temp, type);
		lstTextBlock.add(block);
	}

	
}
