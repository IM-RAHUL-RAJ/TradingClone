import { Injectable } from '@angular/core';
import { instrument } from '../models/instrument';
import { Observable, of } from 'rxjs';
import { TradeServiceService } from './trade-service.service';

@Injectable({
  providedIn: 'root'
})
export class RoboAdvisorServiceService {

  private riskValueSubject = '';

  mockRoboAdvisorDataH: instrument[] = [{
    "instrumentId": "Q123",
    "externalIdType": "CUSIP",
    "externalId": "02079K107",
    "categoryId": "STOCK",
    "instrumentDescription": "Alphabet Inc. Class C Capital Stock",
    "maxQuantity": 1000,
    "minQuantity": 1
  },
  {
    "instrumentId": "Q456",
    "externalIdType": "CUSIP",
    "externalId": "88160R101",
    "categoryId": "STOCK",
    "instrumentDescription": "Tesla, Inc. Common Stock",
    "maxQuantity": 1000,
    "minQuantity": 1
  },
  {
    "instrumentId": "N123456",
    "externalIdType": "CUSIP",
    "externalId": "46625H100",
    "categoryId": "STOCK",
    "instrumentDescription": "JPMorgan Chase & Co. Capital Stock",
    "maxQuantity": 1000,
    "minQuantity": 1
  },
  {
    "instrumentId": "N123789",
    "externalIdType": "ISIN",
    "externalId": "US0846707026",
    "categoryId": "STOCK",
    "instrumentDescription": "Berkshire Hathaway Inc. Class A",
    "maxQuantity": 10,
    "minQuantity": 1
  },
  {
    "instrumentId": "C100",
    "externalIdType": "CUSIP",
    "externalId": "48123Y5A0",
    "categoryId": "CD",
    "instrumentDescription": "JPMorgan Chase Bank, National Association 01/19",
    "maxQuantity": 1000,
    "minQuantity": 100
  }];

 

  mockRoboAdvisorDataM: instrument[] = [{
    "instrumentId": "N123456",
    "externalIdType": "CUSIP",
    "externalId": "46625H100",
    "categoryId": "STOCK",
    "instrumentDescription": "JPMorgan Chase & Co. Capital Stock",
    "maxQuantity": 1000,
    "minQuantity": 1
  },
  {
    "instrumentId": "N123789",
    "externalIdType": "ISIN",
    "externalId": "US0846707026",
    "categoryId": "STOCK",
    "instrumentDescription": "Berkshire Hathaway Inc. Class A",
    "maxQuantity": 10,
    "minQuantity": 1
  },]

 

  mockRoboAdvisorDataL: instrument[] = [{
    "instrumentId": "N123456",
    "externalIdType": "CUSIP",
    "externalId": "46625H100",
    "categoryId": "STOCK",
    "instrumentDescription": "JPMorgan Chase & Co. Capital Stock",
    "maxQuantity": 1000,
    "minQuantity": 1
  },
  {
    "instrumentId": "N123789",
    "externalIdType": "ISIN",
    "externalId": "US0846707026",
    "categoryId": "STOCK",
    "instrumentDescription": "Berkshire Hathaway Inc. Class A",
    "maxQuantity": 10,
    "minQuantity": 1
  }, {
    "instrumentId": "N123789",
    "externalIdType": "ISIN",
    "externalId": "US0846707026",
    "categoryId": "STOCK",
    "instrumentDescription": "Berkshire Hathaway Inc. Class A",
    "maxQuantity": 10,
    "minQuantity": 1
  }]

  constructor(private tradeService:TradeServiceService) { }

  getRoboAdvisorData(type:string): Observable<instrument[] | undefined> {
    if(type==='Low')
     return of(this.mockRoboAdvisorDataL)
   else if(type==='Medium')
     return of(this.mockRoboAdvisorDataM)
   else
   return of(this.mockRoboAdvisorDataH)
 }

 getRiskValue() : Observable<string>
{
  var currentUser=this.tradeService.getUser();
  this.riskValueSubject = currentUser!.preferences!.riskTolerance
  return of(this.riskValueSubject);
}

}
