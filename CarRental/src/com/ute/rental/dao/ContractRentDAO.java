package com.ute.rental.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ute.rental.bo.ContractRent;
import com.ute.rental.dbconnection.ConnectionFactory;

public class ContractRentDAO {

		public ArrayList<ContractRent> getAllcontract(){
			Connection connection = null;
			Statement statement = null;
			ResultSet resultset = null;
			ArrayList<ContractRent> listcontract = new ArrayList<ContractRent>();
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				resultset = statement.executeQuery("Select * from rental_contract");
				while(resultset.next()) {
					listcontract.add(convertocontract(resultset));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
			return listcontract;
		}

		private ContractRent convertocontract(ResultSet rs) throws SQLException {
			ContractRent contract = new ContractRent();
			contract.setIdContract(rs.getInt(1));
			contract.setIdProduct(rs.getInt(2));
			contract.setIdUser(rs.getInt(3));
			contract.setProductName(rs.getString(4));
			contract.setProductSpecies(rs.getString(5));
			contract.setFullName(rs.getString(6));
			contract.setPrice(rs.getInt(7));
			contract.setPhone(rs.getString(8));
			contract.setAddressConsign(rs.getString(9));
			contract.setQuantity(rs.getInt(10));
			contract.setAvatar(rs.getString(11));
			contract.setAvatarsv(rs.getString(12));
			contract.setHireDay(rs.getString(13));
			contract.setPayDay(rs.getString(14));
			contract.setNumberDay(rs.getInt(15));
			contract.setTotal(rs.getInt(16));
			contract.setStatus(rs.getString(17));
			return contract;		
		}
		public void addcontract(ContractRent contract) {
			Connection connection = null;
			Statement statement = null;
			String insert = "Insert into rental_contract(id_product,idUser,product_name,product_species,full_name,price,phone_number,address_consign,quantity,hire_day,pay_day,number_day,total)"
					+ "values('"+contract.getIdProduct()+"','"+contract.getIdUser()+"','"+contract.getProductName()+"','"+contract.getProductSpecies()+"',N'"+contract.getFullName()+"',"
							+ "'"+contract.getPrice()+"','"+contract.getPhone()+"',N'"+contract.getAddressConsign()+"','"+contract.getQuantity()+"','"+contract.getHireDay()+"','"+contract.getPayDay()+"','"+contract.getNumberDay()+"','"+contract.getTotal()+"')";
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				statement.executeUpdate(insert);
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				if(connection != null) {
					try {
						connection.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
				if(statement != null) {
					try {
						statement.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
					
				}
			}				
		
		}
		
		public ArrayList<ContractRent> getContractById(int id){
			Connection connection = null;
			Statement statement = null;
			ResultSet resultset = null;
			ArrayList<ContractRent> listcontract = new ArrayList<ContractRent>();
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				resultset = statement.executeQuery("Select * from rental_contract where idUser = '"+id+"'");
				while(resultset.next()) {
					listcontract.add(convertocontract(resultset));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			return listcontract;
		}
		
		public ArrayList<ContractRent> getContract(int id){
			Connection connection = null;
			Statement statement = null;
			ResultSet resultset = null;
			ArrayList<ContractRent> listcontract = new ArrayList<ContractRent>();
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				resultset = statement.executeQuery("Select * from rental_contract where id_contract = '"+id+"'");
				while(resultset.next()) {
					listcontract.add(convertocontract(resultset));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			return listcontract;
		}

}
