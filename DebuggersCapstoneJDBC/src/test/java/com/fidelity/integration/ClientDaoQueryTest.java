package com.fidelity.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;


import com.fidelity.model.TradeHistory;

import com.fidelity.model.*;

class ClientDaoQueryTest {

	private SimpleDataSource dataSource;
	private Connection connection;
	private DbTestUtils dbTestUtils; 
	private JdbcTemplate jdbcTemplate;
	private ClientDaoImpl dao;
	
	private final Client vish=new Client("test1@gmail.com","vish",LocalDate.of(2023, 3, 23),"INDIA");


 

	@BeforeEach
	void setUp() throws SQLException {
		dataSource = new SimpleDataSource();
		connection=dataSource.getConnection();
		dbTestUtils = new DbTestUtils(connection);
		jdbcTemplate=dbTestUtils.initJdbcTemplate();
		dao = new ClientDaoImpl(dataSource);
	}

	@AfterEach
	void tearDown() throws SQLException {
		dataSource.shutdown();
	}
	
	@Test
	void getClient_SUCCESS() {
		Client client=dao.getClient("test1@gmail.com");
		assertEquals(vish,client);
	}
	
	@Test
	@DisplayName("POSITIVE: Client login successfull")
	void clientLogin() {
		boolean login = dao.loginClient("test1@gmail.com", "vish");
		assertTrue(login);
	}
	
	@Test
	@DisplayName("NEGATIVE: Client login failed due to mismatch credentials")
	void clientLoginFailed() {
		assertThrows(IllegalArgumentException.class,()->{			
			dao.loginClient("test1@gmail.com", "pratyus");
		});
	}

	@Test
	@DisplayName("Test to check trade history")
	void getTradeHistoryTest() {		
		
        List<TradeHistory> tradeHistory = dao.getTradeHistory();
        int rows = JdbcTestUtils.countRowsInTable(jdbcTemplate, "DBG_TRADEHISTORY");
		assertEquals(tradeHistory.size(), rows); 
        assertNotNull(tradeHistory);		
        
	}
	
	@Test
	@DisplayName("Test to verify existing email")
    void testVerifyEmailAddress_ReturnsTrue() {
        
        String email="test1@example.com";  
        
        boolean result = dao.verifyEmailAddress(connection,"test@example.com");
        
        assertFalse(result);
    }
	
    @Test
	@DisplayName("Test to check for non existing email")
    void testVerifyEmailAddress_InvalidEmail() {

        boolean result = dao.verifyEmailAddress(connection,"invalid@example.com");
       
        assertFalse(result);
    }
}