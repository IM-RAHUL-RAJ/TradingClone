import { User } from "./models/user";

export var userDB:User[]=[{
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
    preferences:{
        incomeCategory:'$20,000-$40,000',
        lengthOfInvestment:'2-5',
        riskTolerance:'High',
        investmentPurpose:'Retirement'
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
    preferences:{
        incomeCategory:'',
        lengthOfInvestment:'',
        riskTolerance:'',
        investmentPurpose:''
    }
   
}]