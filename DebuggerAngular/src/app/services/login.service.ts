import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { userDB } from '../user-db';
import { TradeServiceService } from './trade-service.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Client } from '../models/Client';
import { Observable } from 'rxjs';
import { LoginRequest } from '../models/loginRequest';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public readonly loginURL = "http://localhost:8080/app/login";

  constructor(private tradeService:TradeServiceService, private http: HttpClient) { }

  loginClient(loginRequest:LoginRequest){
    console.log("email & password",loginRequest.email,loginRequest.password);
    const header = new HttpHeaders({
      "Content-type":"application/json"
    });
    return this.http.post(this.loginURL, loginRequest, {headers:header});
  }


  checkNewUser(email: string, pwd:string){
    console.log(email, pwd);
    
    if(userDB.find((DBuser) => DBuser.emailId === email)){
      // const userVerified = this.verifyUser(email,pwd);
      console.log('User Found');
      return false;
      
    }else{
      console.log('No user found');
      return true;
    
    }
  }

  returnToLogin:[User|undefined,boolean]=[userDB[0],false];


  verifyUser(email : string, pwd: string){
    var checkUserIndex=userDB.findIndex((DBuser)=>DBuser.emailId===email);
    var findUser=userDB.find((DBuser)=>DBuser.emailId===email);
    if(userDB[checkUserIndex].password===pwd){
      console.log('user Verified');
      this.tradeService.addUserToAppAfterLogin(findUser);
      this.returnToLogin=[findUser,true];
      return this.returnToLogin;
    }
    else{
      console.log('user not verified');
      this.returnToLogin=[undefined,false];
      return this.returnToLogin;
      
    }
  }

}
