import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { userDB } from '../user-db';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http'
import { Observable, catchError, of, throwError } from 'rxjs';
import { Client } from '../models/Client';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  public readonly signupURL = "http://localhost:8080/app/register";

  constructor(private http: HttpClient) { }

  getClient():Observable<Client[]>{
    return this.http.get<Client[]>(this.signupURL).pipe(catchError(this.handleError));
  }

  signupUser(client:Client):Observable<Client>{
    console.log("inside signup user")
    const header = new HttpHeaders({
      "Content-type":"application/json"
    });
    return this.http.post<Client>(this.signupURL, client, {headers:header});
  }

  handleError(response: HttpErrorResponse){
    if(response.error instanceof ProgressEvent){
      console.error(
        "A client-side or network error occurred; " +
          `${response.message} ${response.status} ${response.statusText}`
      );
    }
    else {
      console.error(
        `Backend returned code ${response.status}, ` +
          `body was: ${JSON.stringify(response.error)}`
      );
    }
    return throwError(
      () => "Unable to contact service; please try again later."
    );
  }

  similarField:string='';
  result:[User|undefined,string]=[userDB[0],''];

  checkEmail(user:User){
    //console.log("Email already registered");
    this.similarField='Email';
    this.result=[userDB.find((DBuser)=>DBuser.emailId===user.emailId),this.similarField];
    return this.result;
  }

  checkUsername(user:User){
    //console.log("Username already registered");
    this.similarField='Username';
    this.result=[userDB.find((DBuser)=>DBuser.username===user.username),this.similarField];
    return this.result;
  }

  checkPanCard(user:User){
    //console.log("PAN Card already registered");
    this.similarField='PAN Card';
    this.result= [userDB.find((DBuser)=>DBuser.panCardIdentification===user.panCardIdentification),this.similarField];
    return this.result;
  }

  checkPhoneNumber(user:User){
    //console.log("Phone Number already registered");
    this.similarField='Phone Number'; 
    this.result=[userDB.find((DBuser)=>DBuser.phoneNumber===user.phoneNumber),this.similarField]
    return this.result;
  }

  checkExistingUser(user:User){
    if(this.checkEmail(user)[0]){
      this.similarField=this.checkEmail(user)[1];
    }
    else if(this.checkUsername(user)[0]){
      this.similarField=this.checkUsername(user)[1];
    }else if(this.checkPanCard(user)[0]){
      this.similarField=this.checkPanCard(user)[1];
    }else if(this.checkPhoneNumber(user)[0]){
      this.similarField=this.checkPhoneNumber(user)[1];
    }
    if(this.checkEmail(user)[0] || this.checkPanCard(user)[0] || this.checkUsername(user)[0] || this.checkPhoneNumber(user)[0]){
      console.log("USER FOUND");
      
      return [true,this.similarField];
    }
    else{
      //this.addUser(user);
      return [false,this.similarField];
    }
  }

  addUser(user:User){
    userDB.push(user);
    //TODO: route to login page
  }

}
