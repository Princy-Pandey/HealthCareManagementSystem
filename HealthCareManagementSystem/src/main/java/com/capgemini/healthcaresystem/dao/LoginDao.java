package com.capgemini.healthcaresystem.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.capgemini.healthcaresystem.entity.Login;
import com.capgemini.healthcaresystem.entity.User;

@Transactional
@Repository
public class LoginDao implements LoginDaoInterface
{
	@PersistenceContext
	EntityManager em;

	@Override
	public Login getLogin(String loginId) 
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Login login = em.find(Login.class, loginId);
			//if(user==null) 
			//throw new userException("User Id does not exist for "+ userId);
		return login;
	}

	@Override
	public List<Login> getLogin() 
	{
		// TODO Auto-generated method stub
		TypedQuery<Login> query = em.createQuery("from Login", Login.class);
		List<Login> loginList = query.getResultList();
		return loginList;
	}

	
	
	/*@Override
	public List<Login> login() 
	{
		// TODO Auto-generated method stub
		TypedQuery<Login> query=em.createQuery("SELECT user FROM User AS user", Login.class);
		return query.getResultList();
	}
	
	@Override
	public boolean findEmail(String user_mail) 
	{
		// TODO Auto-generated method stub
		if(em.contains(em.find(Login.class, user_mail)))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean checkUserByMail(String user_mail) 
	{
		// TODO Auto-generated method stub
		String Qstr = "SELECT user.email FROM User user WHERE user.user_mail= :user_mail";
   		TypedQuery<String> query = em.createQuery(Qstr,String.class).setParameter("user_mail",user_mail);
   		try
   		{
   			query.getSingleResult();
   		}
   		catch(Exception ex)
   		{
   			return false;
   		}
   		return true;
	}
	
	@Override
	public Login getUserByMail(String user_mail) 
	{
		// TODO Auto-generated method stub
		String Qstr = "SELECT user FROM User user WHERE user.user_mail= :user_mail";
   		TypedQuery<Login> query = em.createQuery(Qstr,Login.class).setParameter("userMail",user_mail);
   		return query.getSingleResult();
	}
	
	@Override
	public List<User> login() 
	{
		// TODO Auto-generated method stub
		TypedQuery<User> query=em.createQuery("SELECT user FROM User AS user", User.class);
		return query.getResultList();
	}
	
	@Override
	public boolean findId(int userId) 
	{
		// TODO Auto-generated method stub
		if(em.contains(em.find(User.class, userId)))
		{
			return true;
		}
		return false;
	}

	@Override
	public User findById(int userId) 
	{
		// TODO Auto-generated method stub
		return em.find(User.class, userId);
	}

	@Override
	public void update(User user) 
	{
		// TODO Auto-generated method stub
		 User updateUser= em.find(User.class, user.getUserId());
		 updateUser.getUserRole();
		 updateUser.getUserName(); 
		 updateUser.getUserMail();
		 updateUser.getUserPassword();
		 updateUser.getUserContact();
		 updateUser.getUserGender();
		 updateUser.getUserAge();
		 updateUser.getSecretWord();
		 em.persist(updateUser);
	}

	@Override
	public boolean checkUserByMail(String userMail) 
	{
		// TODO Auto-generated method stub
		String Qstr="SELECT user.email FROM User user WHERE user.userMail= :userMail";
   		TypedQuery<String> query=em.createQuery(Qstr,String.class).setParameter("userMail",userMail);
   		try
   		{
   			query.getSingleResult();
   		}
   		catch(Exception ex)
   		{
   			return false;
   		}
   		return true;
	}

	@Override
	public User getUserByMail(String userMail) 
	{
		// TODO Auto-generated method stub
		String Qstr="SELECT user FROM User user WHERE user.userMail= :userMail";
   		TypedQuery<User> query=em.createQuery(Qstr,User.class).setParameter("userMail",userMail);
   		return query.getSingleResult();
	}

	@Override
	public boolean findEmail(String userMail) 
	{
		// TODO Auto-generated method stub
		if(em.contains(em.find(User.class, userMail)))
		{
			return true;
		}
		return false;
	}

	@Override
	public User findByEmail(String userMail) {
		// TODO Auto-generated method stub
		User user = null;
	    Query query = em.createQuery("SELECT u FROM User u WHERE u.email=:email");
	    query.setParameter("UserMail: ", userMail);
	    try 
	    {
	        user = (User) query.getSingleResult();
	    } 
	    catch (Exception e) 
	    {
	        // Handle exception
	    }
	    return user;
	}*/
}
