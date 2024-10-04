package com.fidelity.integration;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fidelity.model.Client;
import com.fidelity.model.Person;
import com.fidelity.model.Portfolio;
import com.fidelity.model.Preferences;
import com.fidelity.model.Trade;
import com.fidelity.model.TradeHistory;

public class ClientDaoImpl implements ClientDao{

	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	private DataSource dataSource;
	
	public ClientDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private final String queryToInsertPreference="""
				INSERT
				INTO dbg_client_preference(client_emailid,investmentpurpose,risktolerance,incomecategory,lengthofinvestment)
				VALUES (?,?,?,?,?)
			""";

	private final String queryToUpdatePreference="""
				UPDATE dbg_client_preference
				SET investmentpurpose = ?, risktolerance = ?, incomeCategory = ?, lengthofinvestment=?
				WHERE client_emailid=?
			""";

	private final String queryToGetPreferenceById="""
				SELECT pf.investmentpurpose
				FROM dbg_client_preference pf
				WHERE client_emailid=?
			""";

	private final String queryToGetClient="""
				SELECT client_emailid,client_username,client_dateofbirth,client_country
				FROM dbg_client_profile
				WHERE client_emailid=?
			""";
	
	private final static String SELECT_ALL_CLIENTS = """
			SELECT
			c.client_firstName,
			c.client_lastName,
			c.client_emailId,
			c.client_username,
			c.client_country,
			c.client_dateOfBirth,
			c.client_panCardIdentification,
			c.client_password,
			c.client_phoneNumber
			FROM 
			dbg_client_profile c
			""";

	@Override
	public Client getClient(String emailId) {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(queryToGetClient)) {
			stmt.setString(1, emailId);
			ResultSet rs = stmt.executeQuery();
			
			Client client = handleResults(rs);
			
			return client;
		} 
		catch (SQLException e) {
			String msg = "Cannot execute query in client";
			logger.error(msg + ": " + e);
			throw new DatabaseException(msg, e);
		}

	}

	private Client handleResults(ResultSet rs) throws SQLException {
		Client client = null;
		while (rs.next()) {
			// get the Client parameters
			String email = rs.getString("client_emailid");
			String username = rs.getString("client_username");
			LocalDate date=(rs.getDate("client_dateofbirth")).toLocalDate();
			String country=rs.getString("client_country");	
			client = new Client(email,username,date,country);
		}
		return client;
	}
	
	public boolean loginClient(String email, String username) {
		Client client=getClient(email);
		if(client.getUsername().equals(username)) {
			return true;
		}
		throw new IllegalArgumentException("Credentials mismatch");
	}
	
	public boolean verifyEmailAddress(Connection conn,String emailId) {

		String sql = "SELECT COUNT(CLIENT_EMAILID) FROM DBG_CLIENT_PROFILE WHERE CLIENT_EMAILID = ?";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){


			stmt.setString(1, emailId);
			ResultSet resultSet = stmt.executeQuery();

	        if (resultSet.next()) {
	            int count = resultSet.getInt(1);
	            return count > 0;
	        }
		}
		
		catch(SQLException e) {
			String msg = "Cannot verify email";
			logger.error(msg + ": " + e);
			throw new DatabaseException(msg,e);
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public void addClient(Person person) {
		// TODO Auto-generated method stub
		//logger.debug("Inserting Client" + person);
		Objects.requireNonNull(person);
		try(Connection conn = dataSource.getConnection()){
			addClient(conn, person);
		}
		catch(SQLException e) {
			String msg = "Cannot insert client: " + person;
			logger.error(msg + ": " + e);
			throw new DatabaseException(msg,e);
		}
	}
	
	private final static String INSERT_CLIENT = """
			INSERT INTO dbg_client_profile p(

				p.client_firstname,
				p.client_lastname,
				p.client_emailid,
				p.client_username,
				p.client_country,
				p.client_dateofbirth,
				p.client_pancardidentification,
				p.client_password,
				p.client_phonenumber
			)VALUES(
				?,
				?,
				?,
				?,
				?,
				?,
				?,
				?,
				?
			)
			""";
	
	private void addClient(Connection conn, Person person) throws SQLException{
		Objects.requireNonNull(person);
		try(PreparedStatement stmt = conn.prepareStatement(INSERT_CLIENT)){
			stmt.setString(1,person.getFirstName());
			stmt.setString(2,person.getLastName());
			stmt.setString(3,person.getEmailId());
			stmt.setString(4,person.getUsername());
			stmt.setString(5,person.getCountry());
			stmt.setDate(6, Date.valueOf(person.getDateOfBirth()));
			stmt.setString(7, person.getPanCardIdentification());
			stmt.setString(8, person.getPassword());
			stmt.setLong(9, person.getPhoneNumber());
			stmt.executeUpdate();
		}
		
		catch(SQLException e) {
			String msg = "Cannot insert client: " + person;
			//logger.error(msg + ": " + e);
			throw new DatabaseException(msg,e);
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void addPreference(Preferences preference) {
		if(preference==null) {
			throw new IllegalArgumentException("Null preference cannot be inserted");
		}
		if(preference.getClientId()==null || preference.getClientId().length()==0) {
			throw new IllegalArgumentException("Client Email Id cannot be empty or null");
		}
		try(Connection connection =dataSource.getConnection();
				PreparedStatement stmt = connection.prepareStatement(queryToInsertPreference)) {
					stmt.setString(1, preference.getClientId());
					stmt.setString(2, preference.getInvestmentPurpose());
					stmt.setString(3, preference.getRiskTolerance());
					stmt.setString(4, preference.getIncomeCategory());
					stmt.setString(5, preference.getLengthOfInvestment());
					stmt.executeUpdate();
			} 
			catch (SQLException ex) {
				throw new DatabaseException("Unable to insert preference with client_emailid=" + preference.getClientId(), ex);
			}
	}

	@Override
	public void updatePreference(Preferences preference) {
		if(preference==null) {
			throw new IllegalArgumentException("Null preference cannot be updated");
		}
		getPreferenceById(preference.getClientId());
		try(Connection connection =dataSource.getConnection();
				PreparedStatement stmt = connection.prepareStatement(queryToUpdatePreference)) {
					stmt.setString(5, preference.getClientId());
					stmt.setString(1, preference.getInvestmentPurpose());
					stmt.setString(2, preference.getRiskTolerance());
					stmt.setString(3, preference.getIncomeCategory());
					stmt.setString(4, preference.getLengthOfInvestment());
					stmt.executeUpdate();
			} 
			catch (SQLException ex) {
				throw new DatabaseException("Unable to update Client with client_id=" + preference.getClientId(), ex);
			}
		
	}
	
	public boolean getPreferenceById(String clientEmailId) {
		String investmentPurpose=null;
		if(clientEmailId==null || clientEmailId.length()==0) {
			throw new IllegalArgumentException("Client Email id cannot be null or empty");
		}
		boolean found=false;
		try(Connection connection =dataSource.getConnection();
				PreparedStatement stmt = connection.prepareStatement(queryToGetPreferenceById)) {
					stmt.setString(1, clientEmailId);
					ResultSet rs=stmt.executeQuery();
					while(rs.next()) {
						investmentPurpose=rs.getString("investmentpurpose");
					}
					if(investmentPurpose==null || investmentPurpose.length()==0) {
						found=false;
						throw new IllegalArgumentException("Client Preferences not found for client email id="+clientEmailId);
					}
					found=true;
			} 
			catch (SQLException ex) {
				throw new DatabaseException("Unable to get Client preferences with client_id=" + clientEmailId, ex);
			}
		return found;
	}

	@Override
	public List<Portfolio> getPortfolio() {
		String sql = """
				SELECT 
				    i.externalid, 
				    i.categoryid, 
				    p.timestamp,
				    i.des, 
				    p.askprice, 
				    p.bigprice, 
				    pf.quantity_of_shares*p.askprice "holdings"
				FROM
				    dbg_instrument i ,dbg_price p, dbg_portfolio pf
				WHERE 
				    pf.instrument_id=p.instrumentid 
				    and 
				    pf.instrument_id=i.instrumentid
				""";
		
		List<Portfolio> portfolios = new ArrayList<>();
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String externalId = rs.getString("externalid");
				String externalType = rs.getString("categoryid");
			    String priceTimestamp = rs.getString("timestamp");
			    String instrumentDescription = rs.getString("des");
			    double bidPrice = rs.getDouble("askprice");
			    double askPrice = rs.getDouble("bigprice");
			    double currentHoldings = rs.getDouble("holdings");
			    
			    Portfolio p = new Portfolio(externalId, externalType, priceTimestamp, instrumentDescription, bidPrice, askPrice, currentHoldings);
			    portfolios.add(p);
			}
			
		}catch (SQLException e) {
			logger.error("Couldn't execue the SQL statement" ,e);
			throw new DatabaseException("Cannot execute SQL query "+ sql, e);
		}
		return portfolios;
	}

	@Override
	public List<TradeHistory> getTradeHistory() {
		
		List<TradeHistory> tradeHistory = new ArrayList<>();

        // Initialize database connection (you need to implement this)
        

        String sql = "SELECT tradeId,instrumentId,bidPrice,askPrice,quantityshares,totalPrice,action FROM DBG_TRADEHISTORY";
		
	     try {
	    	 Connection connection = dataSource.getConnection();;
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery();
             


             while (resultSet.next()) {
                 // Map database columns to Trade object fields
                 int tradeId = resultSet.getInt("TRADEID");
                 String instrumentId = resultSet.getString("INSTRUMENTID");
                 double bidPrice = resultSet.getDouble("BIDPRICE");
                 double askPrice = resultSet.getDouble("ASKPRICE");
                 int quantity = resultSet.getInt("QUANTITYSHARES");
                 double totalPrice = resultSet.getDouble("TOTALPRICE");
                 String action = resultSet.getString("ACTION");
               

                 // Create a Trade object and add it to the list
                 TradeHistory th = new TradeHistory(tradeId,instrumentId,bidPrice,askPrice,quantity,totalPrice,action);
                 tradeHistory.add(th);
             }

             resultSet.close();
             stmt.close();
         } catch (SQLException e) {
             e.printStackTrace();
//         } finally {
//        	 try {
//        		 connection.close();
//        	 }
//        	 catch(SQLException e) {
//        		 e.printStackTrace();
//        	 }
             // Close the database connection
            
         }
	     return tradeHistory;
     }


  
 
	

	
	@Override
	public void addBuyTrade(String instrumentName, int quantity) {
		String sql = """
				INSERT INTO dbg_tradehistory th 
				(
					th.tradeid,
					th.action,
					th.askprice,
					th.bidprice,
					th.instrumentid, 
					th.quantityshares,
					th.totalprice
				)
				VALUES (?, ?, ?, ?, ?, ?, ?)
				""";
		String getInstrumentSql = """
				
				SELECT 
					p.askprice, p.bigprice, p.instrumentid 
				FROM 
					dbg_price p 
				WHERE 
					p.instrumentid=?
				""";
		double askPrice = 0.0;
		double bidPrice = 0.0;
		String instrumentId = instrumentName;
		
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(getInstrumentSql)) {
			
			stmt.setString(1, instrumentId);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				askPrice = rs.getDouble("askprice");
				bidPrice = rs.getDouble("bigprice");
			}
		}catch (SQLException e) {
			logger.error("Couldn't execue the SQL statement" ,e);
			throw new DatabaseException("Cannot execute SQL query "+ sql, e);
		}
		
		
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setInt(1, 10);
			stmt.setString(2,  "Buy");
			stmt.setDouble(3, askPrice );
			stmt.setDouble(4, bidPrice);
			stmt.setString(5, instrumentId);
			stmt.setInt(6, quantity);
			stmt.setDouble(7, quantity*askPrice);
			stmt.executeUpdate();
			
		}catch (SQLException e) {
			logger.error("Couldn't execue the SQL statement" ,e);
			throw new DatabaseException("Cannot execute SQL query "+ sql, e);
		}
	}

	@Override
	public void addSellTrade(String instrumentName, int quantity) {
		String sql = """
				INSERT INTO dbg_tradehistory th 
				(
					th.tradeid,
					th.action,
					th.askprice,
					th.bidprice,
					th.instrumentid, 
					th.quantityshares,
					th.totalprice
				)
				VALUES (?, ?, ?, ?, ?, ?, ?)
				""";
		String getInstrumentSql = """
				
				SELECT 
					p.askprice, p.bigprice, p.instrumentid 
				FROM 
					dbg_price p 
				WHERE 
					p.instrumentid=?
				""";
		double askPrice = 0.0;
		double bidPrice = 0.0;
		String instrumentId = instrumentName;
		
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(getInstrumentSql)) {
			
			stmt.setString(1, instrumentId);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				askPrice = rs.getDouble("askprice");
				bidPrice = rs.getDouble("bigprice");
			}
		}catch (SQLException e) {
			logger.error("Couldn't execue the SQL statement" ,e);
			throw new DatabaseException("Cannot execute SQL query "+ sql, e);
		}
		
		
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setInt(1, 10);
			stmt.setString(2,  "Sell");
			stmt.setDouble(3, askPrice );
			stmt.setDouble(4, bidPrice);
			stmt.setString(5, instrumentId);
			stmt.setInt(6, quantity);
			stmt.setDouble(7, quantity*askPrice);
			stmt.executeUpdate();
			
		}catch (SQLException e) {
			logger.error("Couldn't execue the SQL statement" ,e);
			throw new DatabaseException("Cannot execute SQL query "+ sql, e);
		}
		
	}

	@Override
	public void deleteTradeFromPortfolioOnSell(String instrumentName, int quantity) {
		// TODO Auto-generated method stub
		
	}

}
