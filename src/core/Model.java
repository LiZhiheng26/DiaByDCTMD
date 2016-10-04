package core;


import java.util.*;

import data.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Model 
{
	public static String getPassword(String name)
	{
		System.out.println("ok");
		Configuration conf = new Configuration()
				.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
			.applySettings(conf.getProperties()).build();
		// ��Configurationʵ������SessionFactoryʵ�� һ��Ӧ�ö�Ӧһ��
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		// ����Session
		Session sess = sf.openSession();
		// ��ʼ����
		Transaction tx = sess.beginTransaction();
		
		List list=sess.createQuery("select u from User u where name=:yhm")
				.setString("yhm",name).list();
		System.out.println(list.size());
		
		tx.commit();
		// �ر�Session
		sess.close();
		sf.close();
		if(list.size()==0) return null;
		else return (String) list.get(0);
	}
	public static boolean existName(String name)
	{
		return getPassword(name)!=null;
	}

}