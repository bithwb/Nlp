
package nlp;
/**
 * ����һ�����ʵ���
 *
 */
public class Word implements Comparable {

	/**���ʵ�����*/
	private String content = "";
	/**����ÿ���ַ���������ֵ�ͣ����ڶ�������*/
	private int value = 0;
	/**ÿ�����ʵ�����*/
	private int length = 0;
	
	/**
	 * Ĭ�Ϲ��캯��
	 *
	 */
	public Word(){
		
	}
	/**
	 * ���캯��������content��ʼ������
	 * @param content
	 */
	public Word(String content){
		setContent(content);
	}
	/**
	 * ���ص��ʵĳ���
	 * @return
	 */
	public int getLength() {
		return length;
	}
	/**
	 * ���ص��ʵ�����
	 * @return
	 */
	public String getContent() {
		return content;
	}
	/**
	 * ���õ��ʵ��ı��������ı����㵥�ʵ�value��length
	 * @param content
	 */
	public void setContent(String content) {
		int i;
		this.content = content;
		value = 0;
		for (i = 0; i < content.length(); i++){
			value += content.charAt(i);
		}
		length = content.length();
	}
	/**
	 * ȡ���ʵ�����ֵ
	 * @return
	 */
	public int getValue() {
		return value;
	}
	/**
	 * �Ƚ�����word�Ƿ���ȫ���
	 * @param word
	 * @return
	 */	
	public boolean equals(Word word){
		if (!content.equals(word.getContent())) return false;
		return true;
	}
	/**
	 * �ȽϷ��������ڷ���1��С�ڷ���-1�����ڷ���0
	 * @param arg0
	 * @return
	 */
	public int compareTo(Object obj) {
		Word word = (Word)obj;
		if (equals(word)) return 0;
		if (value > word.getValue()) return 1;
		else return -1;
	}
}
