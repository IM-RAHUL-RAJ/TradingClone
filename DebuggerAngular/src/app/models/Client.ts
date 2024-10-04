export interface Client {
    client_id:number;
    client_firstName: string;
    client_lastName: string;
    client_emailId:string;
    client_username:string;
    client_country:string;
    client_dateOfBirth: Date;
    client_panCardIdentification: string;
    client_password: string;
    client_phoneNumber:number;
    client_balance:number;

    preferences?:{
        investmentPurpose:string,
        riskTolerance:string,
        incomeCategory:string,
        lengthOfInvestment:string
    }
}