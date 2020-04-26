package com.capgemini.healthcaresystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.capgemini.healthcaresystem.entity.User;

@Transactional
@Repository("UserDao")
public class UserDao implements UserDaoInterface
{
	@PersistenceContext
	EntityManager em;

	@Override
	public boolean addRegistration(User user) 
	{
		// TODO Auto-generated method stub
		em.persist(user);
		return true;
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
		 User updateUser= em.find(User.class, user.getUser_id());
		 updateUser.getUser_role();
		 updateUser.getUser_name(); 
		 updateUser.getUser_mail();
		 updateUser.getUser_password();
		 updateUser.getUser_contact();
		 updateUser.getUser_gender();
		 updateUser.getUser_age();
		 updateUser.getSecret_message();
		 em.persist(updateUser);
	}

	@Override
	public Boolean delete(int userId) 
	{
		// TODO Auto-generated method stub
		User user = em.find(User.class, userId);
		if(user!=null)
		{
			em.remove(user);
			return true;
		}
		return false;
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
	public boolean findEmail(String userMail) {
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
	}

	@Override
	public List<User> login() 
	{
		// TODO Auto-generated method stub
		TypedQuery<User> query=em.createQuery("SELECT user FROM User AS user", User.class);
		return query.getResultList();
	}
}
