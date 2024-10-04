package com.fidelity.integration;

import static org.junit.jupiter.api.Assertions.*;

import com.fidelity.model.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

class ClientDaoDMLTest {
	
	private SimpleDataSource dataSource;
	private Connection connection;
	private TransactionManager transactionManager;
	private DbTestUtils dbTestUtils;
	private JdbcTemplate jdbcTemplate;
	private ClientDaoImpl dao;

	@BeforeEach
	void setUp() throws SQLException {
		dataSource = new SimpleDataSource();
		connection = dataSource.getConnection();
		transactionManager = new TransactionManager(dataSource);
		transactionManager.startTransaction();
		
		dbTestUtils = new DbTestUtils(connection);
		jdbcTemplate = dbTestUtils.initJdbcTemplate();

		dao = new ClientDaoImpl(dataSource);
	}

	@AfterEach
	void tearDown() throws SQLException {
		transactionManager.rollbackTransaction();
		dataSource.shutdown();
	}
	
	@Test
	@DisplayName("Successfully Client Registered")
	void testAddClient() {
		String client_emailId = "test6@gmail.com";
		int oldSize = JdbcTestUtils.countRowsInTable(jdbcTemplate, "dbg_client_profile");
		System.out.println(oldSize);
		assertEquals(0,JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, "dbg_client_profile", "client_emailId = '" + client_emailId+"'"));
		Person person = new Person("Vishwanath","Kumar","test6@gmail.com","aryan","India",LocalDate.of(2023, 01, 01),"xxx-xx-xxxx","12345678",1234567890);
		dao.addClient(person);	
		assertEquals(oldSize+1, JdbcTestUtils.countRowsInTable(jdbcTemplate, "dbg_client_profile"));
		assertEquals(1, JdbcTestUtils.countRowsInTableWhere(jdbcTemplate , "dbg_client_profile", "client_emailId = '" + client_emailId+"'"));
	}
	
	@Test
	@DisplayName("Database throws an exception")
	void testAddClientException() {
		int oldSize = JdbcTestUtils.countRowsInTable(jdbcTemplate, "dbg_client_profile");
		assertThrows(DatabaseException.class, () -> {
			Person person = new Person("Vishwanath","Kumar","test5@gmail.com","aryan","India",LocalDate.of(2023, 01, 01),"xxx-xx-xxxx","12345678",1234567890);
			dao.addClient(person);
		});
		assertEquals(oldSize,JdbcTestUtils.countRowsInTable(jdbcTemplate, "dbg_client_profile"));
	}
	
	@Test
	@DisplayName("POSITIVE: Added Client Preferences Successfully")
	void addPreferenceTest_SUCCESS() {
		String clientEmailId = "test6@gmail.com";
		String investmentPurpose="Education";
		String riskTolerance="high";
		String incomeCategory="20000 - 30000";
		String lengthOfInvestment="5 years - 7 years";
		int preferencesOldSize = JdbcTestUtils.countRowsInTable(jdbcTemplate, "dbg_client_preference");
		assertEquals(0, JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, "dbg_client_preference", "client_emailid = 'test6@gmail.com'"));
		
		Preferences newPreference=new Preferences(clientEmailId,investmentPurpose,riskTolerance,incomeCategory,lengthOfInvestment);
		
		dao.addPreference(newPreference);
		
		assertEquals(preferencesOldSize + 1, JdbcTestUtils.countRowsInTable(jdbcTemplate, "dbg_client_preference"));
		assertEquals(1, JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, "dbg_client_preference", "client_emailid = 'test6@gmail.com'"));
	}
	
	@Test
	@DisplayName("NEGATIVE: Null Preference cannot be added")
	void addNullPreferenceTest_FAILURE() {
		Preferences preference=null;
		assertThrows(IllegalArgumentException.class,()->{
			dao.addPreference(preference);
		});
	}
	
	@Test
	@DisplayName("NEGATIVE: Client Email Id cannot be empty")
	void addPreferenceWithInvalidClientEmailId_FAILURE() {
		String clientEmailId = "";
		String investmentPurpose="Education";
		String riskTolerance="high";
		String incomeCategory="20000 - 30000";
		String lengthOfInvestment="5 years - 7 years";
		Preferences newPreference=new Preferences(clientEmailId,investmentPurpose,riskTolerance,incomeCategory,lengthOfInvestment);
		assertThrows(IllegalArgumentException.class,()->{
			dao.addPreference(newPreference);			
		});
	}
	
	@Test
	@DisplayName("POSITIVE: Updated Client Preferences Successfully")
	void updatePreferenceTest_SUCCESS() {
		String clientEmailId="test5@gmail.com";
		String investmentPurpose="Education";
		String riskTolerance="high";
		String incomeCategory="20000 - 30000";
		String lengthOfInvestment="5 years - 7 years";
		int preferencesOldSize = JdbcTestUtils.countRowsInTable(jdbcTemplate, "dbg_client_preference");
		assertEquals(0, JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, "dbg_client_preference", "client_emailid = 'test5@gmail.com' and lengthofinvestment='5 years - 7 years'"));
		
		Preferences newPreference=new Preferences(clientEmailId,investmentPurpose,riskTolerance,incomeCategory,lengthOfInvestment);
		
		dao.updatePreference(newPreference);
		
		assertEquals(preferencesOldSize, JdbcTestUtils.countRowsInTable(jdbcTemplate, "dbg_client_preference"));
		assertEquals(1, JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, "dbg_client_preference", "client_emailid = 'test5@gmail.com' and lengthofinvestment='5 years - 7 years'"));
	}
	
	@Test
	@DisplayName("NEGATIVE: Null preference cannot be updated")
	void updateNullPreferenceTest_FAILURE() {
		Preferences preference=null;
		assertThrows(IllegalArgumentException.class,()->{
			dao.updatePreference(preference);
		});
	}

	@Test
	@DisplayName("NEGATIVE: Cannot update preferences for non-existent client email id")
	void updatePreferenceForNonExistentClient_FAILURE() {
		String clientEmailId="test8@gmail.com";
		String investmentPurpose="Education";
		String riskTolerance="high";
		String incomeCategory="20000 - 30000";
		String lengthOfInvestment="5 years - 7 years";
		Preferences newPreference=new Preferences(clientEmailId,investmentPurpose,riskTolerance,incomeCategory,lengthOfInvestment);
		assertThrows(IllegalArgumentException.class,()->{
			dao.updatePreference(newPreference);			
		});
	}

}
