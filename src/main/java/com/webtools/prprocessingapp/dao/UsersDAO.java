/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webtools.prprocessingapp.dao;

import com.webtools.prprocessingapp.exception.UsersException;
import com.webtools.prprocessingapp.pojo.UserRole;
import com.webtools.prprocessingapp.pojo.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ankitgoyal
 */
public class UsersDAO extends DAO {
	
	public UsersDAO() {
		super();
	}

	public User getUser(String email ,String password) throws UsersException {
		try {
			begin();
			Query q = getSession().createQuery("from User where username = :email and password = :password");
			q.setString("email", email);
			q.setString("password", password);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UsersException("Could not get user " + email, e);
		}
	}

	public User register(User u,String r) throws UsersException {
		try {
			begin();
			UserRole role = new UserRole(r);
			User newUser = new User(u.getFirstName(),u.getLastName(),u.getEmailId(), u.getUsername(), u.getPassword());
			newUser.setUserRole(role);
			role.setUser(newUser);
			getSession().save(newUser);
			getSession().save(role);
			commit();
			close();
			return u;
		}catch (HibernateException e) {
			rollback();
			throw new UsersException("Exception while creating user: " + e.getMessage());
		}
	}
	
	public void delete(User user) throws UsersException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UsersException("Could not delete user " + user.getFirstName() + "  " + user.getLastName(), e);
		}
	}
	
	public User findByUserName(String email) throws UsersException{
		try {
			
			begin();
			Query q = getSession().createQuery("from Users where username = :e");
			q.setString("e" , email);
			q.setMaxResults(1);
			
			User u = (User) q.uniqueResult();
			
			commit();
			return u ; 
			
			
		}catch (HibernateException e) {
			rollback();
			throw new UsersException("Exception while getting user with email " +email + " : " + e.getMessage());
		}
		
		
		
		
	}
	
	public List<User> getPendingUsers() throws UsersException{
		try {
			
			begin();
			
			Criteria  cr = getSession().createCriteria(User.class);
			
			 cr.add(Restrictions.eq("isEnabled" , "N")); 
			 cr.add(Restrictions.eq("role" ,"ROLE_USER"));
			 
			
			List<User> u =  cr.list();
			commit();
			return u ; 
			
			
		}catch (HibernateException e) {
			rollback();
			throw new UsersException("Exception while getting user with Status N" + e.getMessage());
		}
		
		
		
		
	}
	
	public int updateStatus(String emailId) throws UsersException{
		try {
			
			begin();
			Query query = getSession().createQuery("update Users set isAllowedAccess = :e" +
    				" where username = :email");
			query.setParameter("e", "Y");
			query.setParameter("email", emailId);
			int result = query.executeUpdate();
			
			commit();
			return result ; 
			
			
		}catch (HibernateException e) {
			rollback();
			throw new UsersException("Exception while Updating user Status with email " +emailId + " : " +e.getMessage());
		}
	}
	
	public User getUser(long id) throws UsersException{
		try {
			begin();
			Criteria  cr = getSession().createCriteria(User.class);
			cr.add(Restrictions.eq("userId" , id));
			cr.setMaxResults(1);
			User u  = (User) cr.uniqueResult();
			commit();
			return u;
		}catch (HibernateException e) {
            rollback();
            throw new UsersException("Exception while fetching User info for user id -" +id+ " : " +e.getMessage());
        }
	}
}
