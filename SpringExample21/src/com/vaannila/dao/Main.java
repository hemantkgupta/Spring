package com.vaannila.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.vaannila.domain.Forum;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.xml");
		ForumDAO forumDAO = (ForumDAO) context.getBean("forumDAO");
		Forum springForum = new Forum(1, "Spring Forum",
				"Discuss everything related to Spring");
		try {
			forumDAO.insertForum(springForum);
		} catch (DuplicateKeyException e) {
			System.out.println("Forum Already Exist");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(forumDAO.selectForum(2));
		} catch (EmptyResultDataAccessException e) {
			System.out.println("The Forum id is invalid");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

	}

}
