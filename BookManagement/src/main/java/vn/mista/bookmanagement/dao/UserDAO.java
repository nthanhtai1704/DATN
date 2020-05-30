package vn.mista.bookmanagement.dao;

import vn.mista.bookmanagement.model.User;

public interface UserDAO {

	public User getUserByUsername(String username);
}
