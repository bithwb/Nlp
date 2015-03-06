
package nlp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;



//import com.xq.util.File;
//import com.xq.util.Search; 
/**
 * �ֵ�
 *
 */
public class SubDictionary {
	/**
	 * �ֵ䵥�ʵ���󳤶�
	 */
	private int wordLen = 0;
	/**
	 * �ֵ�����
	 */
	private Hashtable<String, Integer> data = null;
	/**
	 * �ֵ��ļ�λ��
	 */
	private String url = "";
	
	/**
	 * ��ʼ�����ֵ�
	 * @param url���ֵ��url
	 */
	public SubDictionary(String url){
		this.url = url;
		data = new Hashtable<>();
	}
	
	/**
	 * �����ļ�
	 * @param url���ļ���λ��
	 */
	public void load(){
		Word word = null;
		BufferedReader br = null;
		String temp = "";
		int len;
		if (data == null) data = new Hashtable<>();
		br = File.openByReader(url);
		if (br != null){
			try {
				while(true){
					temp = br.readLine();
					if (temp == null) break;
					String temp1 = null;
					//System.out.println(temp.length());
					 int i=0;
					  for(int j = 0;j<temp.length();j++)
					   {if (temp.charAt(j)==' '&&i<j) 
					     { //System.out.println(1);
						   //System.out.println(i+"--"+j);
						  temp1=temp.substring(i, j);
						 // System.out.println(temp1);
						  word = new Word(temp1);
						  data.put(word.getContent(), word.getLength());
						  len=word.getLength();
						  if(len>wordLen)
						  { wordLen=word.getLength(); }
						  i=j+2;
						  j=j+2;
					     }
					     if (j==temp.length()-1) 
					     {
					    	//System.out.println(2);
							//System.out.println(i+"--"+j);
							temp1=temp.substring(i);
							//System.out.println(temp1);
							word = new Word(temp1);
							data.put(word.getContent(),word.getLength());
							len=word.getLength();
							if(len>wordLen)
							  {wordLen=word.getLength();}
							//i=temp.length()-1;
							break;
						 }
					   }
					
				}
				br.close();
			} catch (IOException e) {
				System.out.println("dictionary load error, " + url);
			}
		}
		
	}
	/**
	 * ���뵥�ʣ����word�ĳ����Ƿ�͵�ǰ�ֵ��һ��
	 * @param word��Ҫ����ĵ���
	 * @return
	 */
	/**
	 * �����ֵ�
	 *
	 */
	/**
	 * ���ֵ����word���ҵ�����true
	 * @param word
	 * @return
	 */
	/**
	 * ���ֵ����word���ҵ�����true
	 * @param word
	 * @return
	 */
	/**
	 * �����ֵ�ĵ��ʳ���
	 * @return
	 */
	public boolean find(String str){
		Word newWord = new Word(str);
		if(this.data.containsKey(newWord.getContent()))
			return true;
		else 
		    return false;
	}
	public int getWordLen() {
		return wordLen;
	}
	/**
	 * �����ֵ�ĵ��ʳ���
	 * @param wordLen
	 */
	public void setWordLen(int wordLen) {
		this.wordLen = wordLen;
	}
}
