package action;

import core.Model;
import java.lang.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class LoginAndRegisterAction extends ActionSupport
{
	// 定义封装请求参数的username和password成员变量
	private String username;
	private String password;	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}	
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	//注册
	public String execute() throws Exception
	{
		System.out.println(getPassword());
		System.out.println(getUsername());
		if(Model.existName(getUsername())==true)
			return ERROR;
		return SUCCESS;
	}
}