package com.dev.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dev.dbconfig.DBConfig;
import com.dev.model.Address;

public class AddressService {

	public boolean addAddress(Address address) {
		try {
			Connection conn=DBConfig.getConnection();
			PreparedStatement ps=conn.prepareStatement("insert into address (deliveryname, street, city, state, country, pin, mobile) "
													 + "values (?,?,?,?,?,?,?)");
			
			ps.setString(1, address.getDeliveryname());
			ps.setString(2, address.getStreet());
			ps.setString(3, address.getCity());
			ps.setString(4, address.getState());
			ps.setString(5, address.getCountry());
			ps.setInt(6, address.getPin());
			ps.setString(7, address.getMobile());
			ps.executeUpdate();
			
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public boolean updateAddress(Address address) {
		try {
			Connection conn=DBConfig.getConnection();
			PreparedStatement ps=conn.prepareStatement("update address set deliveryname=? street=? city=? state=? country=? pin=? mobile=?"
													 + " where addressid=?");
			
			ps.setString(1, address.getDeliveryname());
			ps.setString(2, address.getStreet());
			ps.setString(3, address.getCity());
			ps.setString(4, address.getState());
			ps.setString(5, address.getCountry());
			ps.setInt(6, address.getPin());
			ps.setString(7, address.getMobile());
			ps.setInt(8, address.getAddressid());
			ps.executeUpdate();
			
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public Address getUserById(int id) {
		try {
			Connection conn=DBConfig.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from address where addressid=?");
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Address address = new Address();
				address.setAddressid(rs.getInt("addressid"));
				address.setDeliveryname(rs.getString("deliveryname"));
				address.setHouseno(rs.getString("houseno"));
				address.setStreet(rs.getString("street"));
				address.setCity(rs.getString("city"));
				address.setState(rs.getString("state"));
				address.setCountry(rs.getString("country"));
				address.setPin(rs.getInt("pin"));
				address.setMobile(rs.getString("mobile"));
				
				return address;
			}
			return null;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public List<Address> getAddressListByUserId(int userid) {
		try {
			Address address = new Address();
			List<Address> addressList = new ArrayList<Address>();
			
			Connection conn=DBConfig.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from address where userid=?");
			
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				address.setAddressid(rs.getInt("addressid"));
				address.setDeliveryname(rs.getString("deliveryname"));
				address.setHouseno(rs.getString("houseno"));
				address.setStreet(rs.getString("street"));
				address.setCity(rs.getString("city"));
				address.setState(rs.getString("state"));
				address.setCountry(rs.getString("country"));
				address.setPin(rs.getInt("pin"));
				address.setMobile(rs.getString("mobile"));
				
				addressList.add(address);
			}
			return addressList;
		}
		catch(Exception e) {
			return null;
		}
	}
}
