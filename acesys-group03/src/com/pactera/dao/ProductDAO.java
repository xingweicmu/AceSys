/**
 * ����ϵͳҵ��ӿں����ݽӿ�
 */
package com.pactera.dao;

import java.util.List;

import com.pactera.bean.Product;

/**
 * ����Ʒ�����Ľӿ�
 * @author David.Wei
 * @version 1.0
 * create:2013-06-06
 */
public interface ProductDAO {
	
	/**
	 * ��ȡ������Ʒ�б�
	 * @param flag 0��ʾ��ͨ�û���ѯ���в�ѯ 1��ʾ����Ա��ѯ���в�ѯ������ɾ����
	 * @return ������Ʒ�������б�
	 */
	List<Product> getALLProduct(int flag);
	
	/**
	 * ������Ʒ��ʶ�Ų�ѯ��Ʒ
	 * @param theProductId ��Ʒ��ʶ��
	 * @return ��Ʒ����
	 */
	Product findProductByProductId(int theProductId);
	
//	/**
//	 * ������Ʒ��Ų�ѯ��Ʒ
//	 * @param theProductNumber ��Ʒ���
//	 * @return ��Ʒ����
//	 */
//	Product findProductByProductNumber(String theProductNumber);
	
	/**
	 * ��ɾ����Ʒ
	 * @param pid ��Ʒ��ʶ��
	 * @param delSoft ��ɾ����ʶ
	 * @return �Ƿ�ɹ� 1���ɹ���ɾ�� 0�� ��ɾ��ʧ��
	 */
	int delSoftProdcut(int pid, char delSoft);
	
	/**
	 * �����Ʒ
	 * @param theProduct ��Ʒ����
	 * @return �Ƿ�ɹ���� 1���ɹ���� 0�����ʧ��
	 */
	int insertProduct(Product theProduct);
	
	/**
	 * ������Ʒ��Ϣ
	 * @param theProduct ��Ʒ����
	 * @return �Ƿ������� 1�����³ɹ� 0������ʧ��
	 */
	int updateProductInfo(Product theProduct);
	
//	/**
//	 * ������Ʒ�������Ʋ�ѯ��Ʒ
//	 * @param theCategoryName ��Ʒ��������
//	 * @return ��Ʒ�б�
//	 */
//	List<Product> findProductsByCategoryName(String theCategoryName);	
//	
//	/**
//	 * ������Ʒ���Ʋ�ѯ��Ʒ
//	 * @param theProductName ��Ʒ����
//	 * @return ��Ʒ
//	 */
//	Product findProductsByProductName(String theProductName);	
//	
//	/**
//	 * ������Ʒ����Ų�ѯ��Ʒ
//	 * @param theCategoryNo ��Ʒ�����
//	 * @return ��Ʒ�б�
//	 */
//	List<Product> findProductsByCategoryNo(String theCategoryNo);		
//	
	/**
	 * ������Ʒ���ơ���Ʒ��š���Ʒ�������ơ���Ʒ�����Ų�ѯ��Ʒ��ģ����ѯ��
	 * @param searchName ��Ʒ��ѯ���ࣺ��Ʒ���ơ���Ʒ��š���Ʒ�������ơ���Ʒ������
	 * @param searchValue ��Ʒ��ѯ�ؼ���
	 * @return ��Ʒ�б�
	 */
	List<Product> findProducts(String searchName, String searchValue);
}
