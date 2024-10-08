import { Component } from '@angular/core';
import { userDB } from 'src/app/user-db';
import { User } from 'src/app/models/user';
import { TradeComponent } from '../trade/trade.component';
import { Company } from 'src/app/models/company';

@Component({
  selector: 'app-client-report',
  templateUrl: './client-report.component.html',
  styleUrls: ['./client-report.component.css']
})
export class ClientReportComponent {

  userDB=userDB;

  company:Company[]= [
    {
    "askPrice": 104.75,
    "bidPrice": 104.25,
    "priceTimeStamp": "21-AUG-19 10.00.01.042000000 AM GMT",
    "instrument": {
    "instrumentId": "N123456",
    "externalIdType": "CUSIP",
    "externalId": "46625H100",
    "categoryId": "STOCK",
    "instrumentDescription": "JPMorgan Chase & Co. Capital Stock",
    "maxQuantity": 1000,
    "minQuantity": 1
    }
    },
    {
    "askPrice": 312500,
    "bidPrice": 312000,
    "priceTimeStamp": "21-AUG-19 05.00.00.040000000 AM -05:00",
    "instrument": {
    "instrumentId": "N123789",
    "externalIdType": "ISIN",
    "externalId": "US0846707026",
    "categoryId": "STOCK",
    "instrumentDescription": "Berkshire Hathaway Inc. Class A",
    "maxQuantity": 10,
    "minQuantity": 1
    }
    },
    {
    "askPrice": 95.92,
    "bidPrice": 95.42,
    "priceTimeStamp": "21-AUG-19 10.00.02.042000000 AM GMT",
    "instrument": {
    "instrumentId": "C100",
    "externalIdType": "CUSIP",
    "externalId": "48123Y5A0",
    "categoryId": "CD",
    "instrumentDescription": "JPMorgan Chase Bank, National Association 01/19",
    "maxQuantity": 1000,
    "minQuantity": 100
    }
    },
    {
    "askPrice": 1.03375,
    "bidPrice": 1.03390625,
    "priceTimeStamp": "21-AUG-19 10.00.02.000000000 AM GMT",
    "instrument": {
    "instrumentId": "T67890",
    "externalIdType": "CUSIP",
    "externalId": "9128285M8",
    "categoryId": "GOVT",
    "instrumentDescription": "USA, Note 3.125 15nov2028 10Y",
    "maxQuantity": 10000,
    "minQuantity": 100
    }
    },
    {
    "askPrice": 0.998125,
    "bidPrice": 0.99828125,
    "priceTimeStamp": "21-AUG-19 10.00.02.002000000 AM GMT",
    "instrument": {
    "instrumentId": "T67894",
    "externalIdType": "CUSIP",
    "externalId": "9128285Z9",
    "categoryId": "GOVT",
    "instrumentDescription": "USA, Note 2.5 31jan2024 5Y",
    "maxQuantity": 10000,
    "minQuantity": 100
    }
    },
    {
    "askPrice": 1,
    "bidPrice": 1.00015625,
    "priceTimeStamp": "21-AUG-19 10.00.02.002000000 AM GMT",
    "instrument": {
    "instrumentId": "T67895",
    "externalIdType": "CUSIP",
    "externalId": "9128286A3",
    "categoryId": "GOVT",
    "instrumentDescription": "USA, Note 2.625 31jan2026 7Y",
    "maxQuantity": 10000,
    "minQuantity": 100
    }
    },
    {
    "askPrice": 0.999375,
    "bidPrice": 0.999375,
    "priceTimeStamp": "21-AUG-19 10.00.02.002000000 AM GMT",
    "instrument": {
    "instrumentId": "T67897",
    "externalIdType": "CUSIP",
    "externalId": "9128285X4",
    "categoryId": "GOVT",
    "instrumentDescription": "USA, Note 2.5 31jan2021 2Y",
    "maxQuantity": 10000,
    "minQuantity": 100
    }
    },
    {
    "askPrice": 0.999375,
    "bidPrice": 0.999375,
    "priceTimeStamp": "21-AUG-19 10.00.02.002000000 AM GMT",
    "instrument": {
    "instrumentId": "T67899",
    "externalIdType": "CUSIP",
    "externalId": "9128285V8",
    "categoryId": "GOVT",
    "instrumentDescription": "USA, Notes 2.5% 15jan2022 3Y",
    "maxQuantity": 10000,
    "minQuantity": 100
    }
    },
    {
    "askPrice": 1.00375,
    "bidPrice": 1.00375,
    "priceTimeStamp": "21-AUG-19 10.00.02.002000000 AM GMT",
    "instrument": {
    "instrumentId": "T67880",
    "externalIdType": "CUSIP",
    "externalId": "9128285U0",
    "categoryId": "GOVT",
    "instrumentDescription": "USA, Note 1.5 31dec2023 5Y",
    "maxQuantity": 10000,
    "minQuantity": 100
    }
    },
    {
    "askPrice": 1.0596875,
    "bidPrice": 1.0596875,
    "priceTimeStamp": "21-AUG-19 10.00.02.002000000 AM GMT",
    "instrument": {
    "instrumentId": "T67883",
    "externalIdType": "CUSIP",
    "externalId": "912810SE9",
    "categoryId": "GOVT",
    "instrumentDescription": "USA, Bond 3.375 15nov2048 30Y",
    "maxQuantity": 10000,
    "minQuantity": 100
    }
    },
    {
    "askPrice": 0.9853125,
    "bidPrice": 0.98546875,
    "priceTimeStamp": "21-AUG-19 10.00.02.002000000 AM GMT",
    "instrument": {
    "instrumentId": "T67878",
    "externalIdType": "CUSIP",
    "externalId": "912810SD1",
    "categoryId": "GOVT",
    "instrumentDescription": "USA, Bond 3 15aug2048 30Y",
    "maxQuantity": 10000,
    "minQuantity": 100
    }
    },
    {
    "askPrice": 1162.42,
    "bidPrice": 1161.42,
    "priceTimeStamp": "21-AUG-19 06.52.20.350000000 PM AMERICA/NEW_YORK",
    "instrument": {
    "instrumentId": "Q123",
    "externalIdType": "CUSIP",
    "externalId": "02079K107",
    "categoryId": "STOCK",
    "instrumentDescription": "Alphabet Inc. Class C Capital Stock",
    "maxQuantity": 1000,
    "minQuantity": 1
    }
    },
    {
    "askPrice": 323.39,
    "bidPrice": 322.89,
    "priceTimeStamp": "21-AUG-19 06.52.20.356000000 PM AMERICA/NEW_YORK",
    "instrument": {
    "instrumentId": "Q456",
    "externalIdType": "CUSIP",
    "externalId": "88160R101",
    "categoryId": "STOCK",
    "instrumentDescription": "Tesla, Inc. Common Stock",
    "maxQuantity": 1000,
    "minQuantity": 1
    }
    }
    ];

  // user= User;

}
