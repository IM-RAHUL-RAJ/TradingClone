export interface User {

    firstName:string,
    lastName:string,
    emailId:string,
    username:string,
    country:string,
    dateOfBirth:Date,
    postalCode:string,
    panCardIdentification:string,
    password:string,
    phoneNumber:string
    preferences:{
        investmentPurpose:string,
        riskTolerance:string,
        incomeCategory:string,
        lengthOfInvestment:string
    }
    
    accountBalance?:string
  

}
