import { TestBed } from '@angular/core/testing';

import { SignupService } from './signup.service';
import { User } from '../models/user';
import { userDB } from '../user-db';

describe('SignupService', () => {
  let service: SignupService;
  var testUsers: User[] = [];
  beforeEach(() => {
    testUsers=[{
      firstName:'Pratyush',
      lastName:'Srivastava',
      emailId:'pratyush.srivastava@fmr.com',
      username:'pratyush-09',
      country:'INDIA',
      dateOfBirth:new Date(2000,9,9),
      postalCode:'600028',
      panCardIdentification:'XXXXXXXXXX',
      password:'PRATYUSH09',
      phoneNumber:'7209550100',
      accountBalance:'10000',
      preferences:{
        incomeCategory:'',
        lengthOfInvestment:'',
        riskTolerance:'',
        investmentPurpose:''
      }
  },
  {
      firstName:'Swastika',
      lastName:'Swastika',
      emailId:'swastika.fmri@fmr.com',
      username:'swastika-fmr',
      country:'INDIA',
      dateOfBirth:new Date(1999,12,12),
      postalCode:'600028',
      panCardIdentification:'XXXXXXXXXX',
      password:'SWASTIKA12',
      phoneNumber:'7340901032',
      accountBalance:'50000',
      preferences:{
        incomeCategory:'',
        investmentPurpose:'',
        riskTolerance:'',
        lengthOfInvestment:''
      }
  }]
    TestBed.configureTestingModule({});
    service = TestBed.inject(SignupService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  // it('should check existing user - Positive Test', () => {
  //   expect(service.checkExistingUser(testUsers[0])).toBe(true);
  // });

  it('should add new user after Registration', () => {
    var mockUser = {
      firstName:'Ananya',
      lastName:'Tomar',
      emailId:'Ananya.Tomar@fmr.com',
      username:'ananya',
      country:'INDIA',
      dateOfBirth:new Date(1999,12,12),
      postalCode:'600028',
      panCardIdentification:'XXXXXXXXXX',
      password:'ANANAYA',
      phoneNumber:'7340901032',
      accountBalance:'50000',
      preferences:{
        incomeCategory:'',
        riskTolerance:'',
        lengthOfInvestment:'',
        investmentPurpose:''
      }
    };
    service.addUser(mockUser);
    expect(userDB.length).toBe(3);
    expect(userDB[2].firstName).toBe('Ananya');
  });
});
