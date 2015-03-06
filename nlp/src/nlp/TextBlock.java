
package nlp;
/**
 * �ִʵ��ı��飬ÿ���ı�����һ��Ϸ����ı���û�б����Ż������Ƿ��ı���
 * ֻ��ȫ�ǺͰ�ǵ�0����9��A����Z��a����z������
 */
public class TextBlock {

	/**
	 * ��ʶ�ı����ڵ�����
	 */
	private int property = -1;
	/**
	 * �ı���Ż����� 
	 */
	private String text = "";
	/**
	 * ��ʼ��
	 * @param text��Ҫ���õ��ı�
	 * @param property�����ı�����
	 */
	public TextBlock(String text, int property){
		this.text = text;
		this.property = property;
	}
	/**
	 * ȥ�ı�
	 * @return
	 */
	public String getText() {
		return text;
	}
	/**
	 * �����ı�
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * �����ı�������
	 * @return
	 */
	public int getProperty() {
		return property;
	}
	/**
	 * �����ı�������
	 * @param property
	 */
	public void setProperty(int property) {
		this.property = property;
	}
	
}
