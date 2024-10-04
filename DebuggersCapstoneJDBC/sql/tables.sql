DROP TABLE DBG_Instrument;
CREATE TABLE DBG_Instrument (
    instrumentId VARCHAR(50) PRIMARY KEY,
    des VARCHAR(255) NOT NULL,
    externalId VARCHAR(50) UNIQUE NOT NULL,
    maxQuantity INT NOT NULL,
    minQuantity INT NOT NULL,
    categoryId VARCHAR(50) NOT NULL
);

-- Inserting demo data
INSERT INTO DBG_Instrument (instrumentId, des, externalId, maxQuantity, minQuantity, categoryId)
VALUES ('AAPL', 'Apple Inc.', 'AAPL123', 1000, 100, 'TECH');
INSERT INTO DBG_Instrument (instrumentId, des, externalId, maxQuantity, minQuantity, categoryId)  
VALUES ('GOOGL', 'Alphabet Inc.', 'GOOGL456', 500, 50, 'TECH');

INSERT INTO DBG_Instrument (instrumentId, des, externalId, maxQuantity, minQuantity, categoryId)  
VALUES ('MSFT', 'Microsoft Corporation', 'MSFT789', 800, 75, 'TECH');
INSERT INTO DBG_Instrument (instrumentId, des, externalId, maxQuantity, minQuantity, categoryId)  
VALUES ('TSLA', 'Tesla, Inc.', 'TSLA101', 300, 25, 'AUTO');
INSERT INTO DBG_Instrument (instrumentId, des, externalId, maxQuantity, minQuantity, categoryId)  
VALUES ('AMZN', 'Amazon.com, Inc.', 'AMZN202', 750, 50, 'RTL');
INSERT INTO DBG_Instrument (instrumentId, des, externalId, maxQuantity, minQuantity, categoryId)  
VALUES ('NFLX', 'Netflix, Inc.', 'NFLX303', 400, 30, 'ENT');
INSERT INTO DBG_Instrument (instrumentId, des, externalId, maxQuantity, minQuantity, categoryId)  
VALUES ('NVDA', 'NVIDIA Corporation', 'NVDA404', 600, 60, 'TECH');
INSERT INTO DBG_Instrument (instrumentId, des, externalId, maxQuantity, minQuantity, categoryId)  
VALUES ('DIS', 'The Walt Disney Company', 'DIS505', 700, 70, 'ENT');


Drop TABLE DBG_PRICE;
CREATE TABLE DBG_PRICE (
    priceId INT PRIMARY KEY,
    instrumentId VARCHAR2(50),
    bigPrice NUMBER,
    askPrice NUMBER,
    timestamp TIMESTAMP,
    FOREIGN KEY (instrumentId) REFERENCES DBG_Instrument(instrumentId)
);

INSERT INTO DBG_PRICE (priceId, instrumentId, bigPrice, askPrice, timestamp)
VALUES(1, 'AAPL', 150.25, 151.00, TO_TIMESTAMP('2023-09-19 09:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO DBG_PRICE (priceId, instrumentId, bigPrice, askPrice, timestamp)
VALUES (2, 'GOOGL', 2750.50, 2751.75, TO_TIMESTAMP('2023-09-19 09:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO DBG_PRICE (priceId, instrumentId, bigPrice, askPrice, timestamp)
VALUES (3, 'MSFT', 305.75, 306.25, TO_TIMESTAMP('2023-09-19 09:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO DBG_PRICE (priceId, instrumentId, bigPrice, askPrice, timestamp)
VALUES (4, 'TSLA', 750.00, 752.50, TO_TIMESTAMP('2023-09-19 09:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO DBG_PRICE (priceId, instrumentId, bigPrice, askPrice, timestamp)
VALUES(5, 'AMZN', 3200.25, 3201.50, TO_TIMESTAMP('2023-09-19 09:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO DBG_PRICE (priceId, instrumentId, bigPrice, askPrice, timestamp)
VALUES (6, 'NFLX', 600.75, 601.25, TO_TIMESTAMP('2023-09-19 09:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO DBG_PRICE (priceId, instrumentId, bigPrice, askPrice, timestamp)
VALUES (7, 'NVDA', 250.50, 251.00, TO_TIMESTAMP('2023-09-19 09:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO DBG_PRICE (priceId, instrumentId, bigPrice, askPrice, timestamp)
VALUES (8, 'DIS', 170.00, 170.25, TO_TIMESTAMP('2023-09-19 09:30:00', 'YYYY-MM-DD HH24:MI:SS'));


DROP TABLE dbg_client_profile;
DROP TABLE dbg_client_preference;

 

CREATE TABLE dbg_client_profile(
    client_firstName VARCHAR(200) NOT NULL,
    client_lastName VARCHAR(200) NOT NULL,
    client_emailId VARCHAR(320) NOT NULL,
    client_username VARCHAR(200) NOT NULL,
    client_country VARCHAR (100) NOT NULL,
    client_dateOfBirth DATE NOT NULL,
    client_panCardIdentification VARCHAR(20) NOT NULL,
    client_password VARCHAR(20) NOT NULL,
    client_phoneNumber NUMBER(12) NOT NULL,
    CONSTRAINT dbg_client_profile_pk PRIMARY KEY(client_emailId)
);

 

CREATE TABLE dbg_client_preference(
    client_emailId VARCHAR(320) NOT NULL,
    investmentPurpose VARCHAR(100) NOT NULL,
    riskTolerance VARCHAR(100) NOT NULL,
    incomeCategory VARCHAR(100) NOT NULL,
    lengthOfInvestment VARCHAR(100) NOT NULL,
    CONSTRAINT dbg_client_preference_pk PRIMARY KEY(client_emailId)
);

 

 

 

INSERT INTO dbg_client_profile (client_firstName,client_lastName,client_emailId,client_username,client_country,client_dateOfBirth,client_panCardIdentification,client_password,client_phoneNumber) VALUES ('Vishwanath','Singh','test1@gmail.com','vish','India',TO_DATE('2023-3-3','YYYY-MM-DD'),'xxx-xx-xxxx','12345678',1234567890);
INSERT INTO dbg_client_profile (client_firstName,client_lastName,client_emailId,client_username,client_country,client_dateOfBirth,client_panCardIdentification,client_password,client_phoneNumber) VALUES ('Pratyush','Sahay','test2@gmail.com','pratyush','India',TO_DATE('2023-3-3','YYYY-MM-DD'),'xxx-xx-xxxx','12345678',1234567890);
INSERT INTO dbg_client_profile (client_firstName,client_lastName,client_emailId,client_username,client_country,client_dateOfBirth,client_panCardIdentification,client_password,client_phoneNumber) VALUES ('Swastika','Fmri','test3@gmail.com','fmri','India',TO_DATE('2023-3-3','YYYY-MM-DD'),'xxx-xx-xxxx','12345678',1234567890);
INSERT INTO dbg_client_profile (client_firstName,client_lastName,client_emailId,client_username,client_country,client_dateOfBirth,client_panCardIdentification,client_password,client_phoneNumber) VALUES ('Rahul','Raj','test4@gmail.com','Rahul','India',TO_DATE('2023-3-3','YYYY-MM-DD'),'xxx-xx-xxxx','12345678',1234567890);
INSERT INTO dbg_client_profile (client_firstName,client_lastName,client_emailId,client_username,client_country,client_dateOfBirth,client_panCardIdentification,client_password,client_phoneNumber) VALUES ('Ananya','Tomar','test5@gmail.com','Tomar','India',TO_DATE('2023-3-3','YYYY-MM-DD'),'xxx-xx-xxxx','12345678',1234567890);

 

 

INSERT INTO dbg_client_preference (client_emailId,investmentPurpose,riskTolerance,incomeCategory,lengthOfInvestment) VALUES ('test1@gmail.com','Marraige','low','40001 - 60000','7 years - 10 years');
INSERT INTO dbg_client_preference (client_emailId,investmentPurpose,riskTolerance,incomeCategory,lengthOfInvestment) VALUES ('test2@gmail.com','Education','high','40001 - 60000','7 years - 10 years');
INSERT INTO dbg_client_preference (client_emailId,investmentPurpose,riskTolerance,incomeCategory,lengthOfInvestment) VALUES ('test3@gmail.com','Retirement','low','40001 - 60000','7 years - 10 years');
INSERT INTO dbg_client_preference (client_emailId,investmentPurpose,riskTolerance,incomeCategory,lengthOfInvestment) VALUES ('test4@gmail.com','Security','low','40001 - 60000','7 years - 10 years');
INSERT INTO dbg_client_preference (client_emailId,investmentPurpose,riskTolerance,incomeCategory,lengthOfInvestment) VALUES ('test5@gmail.com','personal','low','40001 - 60000','7 years - 10 years');

 
DROP TABLE DBG_TradeHistory;

CREATE TABLE DBG_TradeHistory (
    tradeId INT PRIMARY KEY,
    instrumentId VARCHAR2(50),
    bidPrice NUMBER,
    askPrice NUMBER,
    quantityShares INT,
    totalPrice NUMBER,
    action VARCHAR2(4) CHECK (action IN ('buy', 'sell'))
);

-- Inserting demo data into the TradeHistory table
INSERT INTO DBG_TradeHistory (tradeId, instrumentId, bidPrice, askPrice, quantityShares, totalPrice, action)
VALUES (1, 'AAPL', 150.25, 151.00, 100, -15025.00, 'buy');
INSERT INTO DBG_TradeHistory (tradeId, instrumentId, bidPrice, askPrice, quantityShares, totalPrice, action)
VALUES (2, 'GOOGL', 2750.50, 2751.75, 50, -137525.00, 'buy');
INSERT INTO DBG_TradeHistory (tradeId, instrumentId, bidPrice, askPrice, quantityShares, totalPrice, action)
VALUES (3, 'MSFT', 305.75, 306.25, 75, -22931.25, 'buy');
INSERT INTO DBG_TradeHistory (tradeId, instrumentId, bidPrice, askPrice, quantityShares, totalPrice, action)
VALUES (4, 'TSLA', 750.00, 752.50, 25, -18750.00, 'buy');
INSERT INTO DBG_TradeHistory (tradeId, instrumentId, bidPrice, askPrice, quantityShares, totalPrice, action)
VALUES (5, 'AMZN', 3200.25, 3201.50, 30, -96007.50, 'sell');
INSERT INTO DBG_TradeHistory (tradeId, instrumentId, bidPrice, askPrice, quantityShares, totalPrice, action)
VALUES (6, 'NFLX', 600.75, 601.25, 40, -24030.00, 'sell');
INSERT INTO DBG_TradeHistory (tradeId, instrumentId, bidPrice, askPrice, quantityShares, totalPrice, action)
VALUES(7, 'NVDA', 250.50, 251.00, 60, -15030.00, 'sell');
INSERT INTO DBG_TradeHistory (tradeId, instrumentId, bidPrice, askPrice, quantityShares, totalPrice, action)
VALUES(8, 'DIS', 170.00, 170.25, 70, -11917.50, 'sell');


Drop table DBG_Portfolio;

CREATE TABLE DBG_Portfolio (
    portfolio_id INT PRIMARY KEY,
    instrument_id VARCHAR(50),
    quantity_of_shares INT,
    status VARCHAR(1) CHECK (status IN ('P', 'L'))
);

-- Inserting demo data into the Portfolio table
INSERT INTO DBG_Portfolio (portfolio_id, instrument_id, quantity_of_shares, status)
VALUES (1, 'AAPL', 100, 'P');
INSERT INTO DBG_Portfolio (portfolio_id, instrument_id, quantity_of_shares, status)
VALUES (2, 'GOOGL', 50, 'P');
INSERT INTO DBG_Portfolio (portfolio_id, instrument_id, quantity_of_shares, status)
VALUES (3, 'MSFT', 75, 'P');
INSERT INTO DBG_Portfolio (portfolio_id, instrument_id, quantity_of_shares, status)
VALUES (4, 'TSLA', 25, 'P');
INSERT INTO DBG_Portfolio (portfolio_id, instrument_id, quantity_of_shares, status)
VALUES (5, 'AMZN', 30, 'L');
INSERT INTO DBG_Portfolio (portfolio_id, instrument_id, quantity_of_shares, status)
VALUES (6, 'NFLX', 40, 'L');
INSERT INTO DBG_Portfolio (portfolio_id, instrument_id, quantity_of_shares, status)
VALUES (7, 'NVDA', 60, 'L');
INSERT INTO DBG_Portfolio (portfolio_id, instrument_id, quantity_of_shares, status)
VALUES (8, 'DIS', 70, 'L');
