
package nlp;

/**
 * �ִʽӿ�
 */

public interface Segment {
	/**
	 * ���������ֵ���ı��ִ�
	 * @param source��Ҫ�ִʵ��ı�
	 * @param Subdictionary���������ֵ�
	 * @return
	 */
	public String segment(String source, SubDictionary dictionary);
}
