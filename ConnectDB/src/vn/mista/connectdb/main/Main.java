package vn.mista.connectdb.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import vn.mista.connectdb.bo.User;
import vn.mista.connectdb.dao.UserDAO;

public class Main {

	public static void main(String[] args) throws SQLException {
		//UserDAO userDao = new UserDAO();
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = true;
		while (isContinue) {
			System.out.println("=================================================");
			// nhập username
			System.out.print("Enter username: ");
			String username = scanner.nextLine();

			// tìm user bằng username vừa nhập
			ArrayList<User> userList = UserDAO.findUserByUsername(username);

			// Nếu không tìm thấy: nhập vào các thông tin cần thiết và tạo mới một user và
			// insert vào Database
			if (userList.size() == 0) {
				System.out.println("No record found");

				// Nhập username
				System.out.print("Enter new username: ");
				String newUsername = scanner.nextLine();

				// Nhập password
				System.out.print("Enter new password: ");
				String newPassword = scanner.nextLine();

				// Nhập password
				System.out.print("Enter new age: ");
				int newAge = scanner.nextInt();

				User newUser = new User();
				// set dữ liệu cho newUser
				newUser.setName(newUsername);
				newUser.setPass(newPassword);
				newUser.setAge(newAge);
				
				// Gọi userDAO để thêm mới một user vào database
				UserDAO.addUserViaPreparedStatement(newUser);
				System.out.println("Insert successfully!");
			}

			// Nếu chỉ có 1 user: thì nhập password mới từ bàn phím và update password cho user trong database.
			if (userList.size() == 1) {
				// Hiển thị kết quả của user tìm được: id - username - password - age
				/*for(User user : userList) {
					System.out.println(user.getId() + " - " + user.getName() + " - " + user.getPass() + " - " + user.getAge());
				}*/
				UserDAO.displayUserList(userList);

				// Nhập password mới
				System.out.print("Enter new password: ");
				String newPassword = scanner.nextLine();

				// Gọi userDAO để cập nhật password mới cho user
				UserDAO.updatePassUser(newPassword, userList.get(0).getId());

				System.out.println("Update successfully!");
			}

			// Nếu có hơn nhiều hơn 1 user: thì xóa hết trong database chỉ giữ lại user đầu tiên.
			if (userList.size() > 1) {
				// Hiển thị kết quả của tất cả user tìm được: id - username - password - age
				UserDAO.displayUserList(userList);

				// Gọi userDAO để xóa user thứ 2 đến thứ N của listUser trong database.
				/*for(int i = 1; i < userList.size(); i++) {
					UserDAO.deleteUser(userList.get(i).getId());
				}*/
				userList.remove(0);
				UserDAO.deleteUser2(userList);
				System.out.println("Delete successfully!");
			}

			// Có tiếp tục làm việc không?
			scanner = new Scanner(System.in);
			System.out.print("Continue (Y/N): ");
			String result = scanner.nextLine();
			isContinue = "Y".equalsIgnoreCase(result);
		}
		scanner.close();

	}

}
