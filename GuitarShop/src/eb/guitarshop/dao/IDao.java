package eb.guitarshop.dao;

import java.util.List;

import eb.guitarshop.bean.Guitar;

public interface IDao {

	public void addGuitar(Guitar g);
	// ���������

	public List<Guitar> getGuitar(String serialNumber);
	// �������кŵõ�����

	public Guitar search(Guitar g);
	// ��ѯ���
	public List<Guitar> list();
}	// �г��嵥
