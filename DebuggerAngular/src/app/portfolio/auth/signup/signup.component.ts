import { Component, EventEmitter, Output, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from 'src/app/models/Client';
import { User } from 'src/app/models/user';
import { SignupService } from 'src/app/services/signup.service';
import { userDB } from 'src/app/user-db';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  // inputText = '';
  // showWarning = false;

  // Trial: Angular service
  country = document.getElementById("country");
  couVal : string | undefined;
  
  constructor(private signupService:SignupService, private router: Router){}

  
  client:Client={
    client_id:0,
    client_firstName: '',
    client_lastName: '',
    client_emailId: '',
    client_username: '',
    client_country:'',
    client_dateOfBirth: new Date(),
    client_panCardIdentification: '',
    client_password: '',
    client_phoneNumber:0,
    client_balance:0
  }
  

  addClient(){

    console.log("Country"+this.couVal);

    this.client={
      client_id:0,
      client_firstName: this.client.client_firstName,
      client_lastName: this.client.client_lastName,
      client_emailId: this.client.client_emailId,
      client_username: this.client.client_username,
      client_country:this.client.client_country,
      client_dateOfBirth: this.client.client_dateOfBirth,
      client_panCardIdentification: this.client.client_panCardIdentification,
      client_password: this.client.client_password,
      client_phoneNumber:this.client.client_phoneNumber,
      client_balance:100000
    }

    console.log("Inside addClient function")
    console.log(this.client, 'client information')
    return this.signupService.signupUser(this.client).subscribe({
      next:(response)=>{
        console.log(response,"Inside response")
      }
    });
  }

  // Trial: end

  

  public passwordCheck:string='';
  public placeholdertext: string = 'Enter PAN ID'
  public patternvalidation : string = ''

  
  
  goToLogin() {
    this.router.navigate(['/login']);
  }

  

  user:User={
    firstName:'',
    lastName:'',
    emailId:'',
    username:'',
    country:'',
    dateOfBirth:new Date(),
    postalCode:'',
    panCardIdentification:'',
    password:'',
    phoneNumber:'',
    preferences:{
      incomeCategory:'',
      investmentPurpose:'',
      lengthOfInvestment:'',
      riskTolerance:''
    }
  }

  similarField:any;

  //@Output() userCheck=new EventEmitter<User>;

  changeInput(event:Event){
    const countrySelect = event.target as HTMLSelectElement;
    if(countrySelect.value === 'india'){
      this.placeholdertext = 'Enter PAN ID';
      this.patternvalidation = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
    }
    else if(countrySelect.value === 'usa'){
      this.placeholdertext='Enter SSN Code';
      this.patternvalidation="\d{3}-\d{2}-\d{4}";
    }
  }

  userAdded(){
    this.goToLogin(); 
  }

  checkUser(){
    //this.userCheck.emit(this.user);
    var checkExistingUser=this.signupService.checkExistingUser(this.user);
    this.similarField=checkExistingUser[1];
    var formId=document.getElementById('signupForm') as HTMLFormElement;
    //console.log(this.passwordCheck,this.user.password);
    //console.log(this.user);
    if(checkExistingUser[0]===false){
      if(this.passwordCheck===this.user.password){
        //this.addUser(this.user);
        userDB.push(this.user);
        console.log(userDB);
        console.log("NEW USER DETECTED");
        //this.userAdded();
        document.getElementById('user-added')?.classList.remove('user-added');
        //this.addUser(this.user);
        //formId.reset();
      }
      else{
        //TODO: error: password and re-enter password mismatch
        console.log("PASSWORD MISMATCH");
        var password1=document.getElementById('exampleInputPassword1') as HTMLInputElement;
        password1.value='';
        var repassword1=document.getElementById('exampleReInputPassword1') as HTMLInputElement;
        repassword1.value='';
      }
      
    }
    else{
      //route to login page
      document.getElementById('existing-user-found')?.classList.remove('existing-user-found');
      (document.getElementById('signupBtn') as HTMLButtonElement).disabled=true;
      
      console.log("USER FOUND");
    }
    // console.log(checkNewUser);
    // console.log(this.user.firstName, this.user.lastName);
  }

  //navigation

  addUser(user:User){
    userDB.push(user);
    console.log("NEW USER ADDED");
    
    console.log(userDB);
  }

  // checkInputLength(){
  //   if(this.inputText.length < 3){
  //     this.showWarning = true;
  //   }
  //   else{
  //     this.showWarning = false;
  //   }
  // }

  //navigation
  




}
