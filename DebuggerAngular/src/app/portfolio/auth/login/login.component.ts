import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from 'src/app/models/Client';
import { LoginRequest } from 'src/app/models/loginRequest';
import { User } from 'src/app/models/user';
import { LoginService } from 'src/app/services/login.service';
import { SignupService } from 'src/app/services/signup.service';
import { userDB } from 'src/app/user-db';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  email : string = '';
  password : string = '';  

  constructor(private loginService : LoginService, private router: Router){}

  goToSignUp() {
    console.log("sign up calling");
    this.router.navigate(['/signup']);
  }

  goToHomePage(loggedInUser:User|undefined){
    if(loggedInUser!.preferences!.incomeCategory!==''){
      this.router.navigate(['home']);
      console.log("home page calling");
    }
    else{
      this.router.navigate(['preferences']);
    }

  }

  ngOnInit(){}

  loginClient(email: string, password: string){
    const loginRequest: LoginRequest = {
      email: email,
      password : password      
    };

    this.loginService.loginClient(loginRequest).subscribe({
      next:(response)=>{
        console.log(response,"Response of login:");
      },
      error:(error)=>{
        if(error.status===400){
          alert('Invalid Credentials');
        }
      }
    })
  }

  // verifyUser(){
  //   var newUser = this.loginService.checkNewUser(this.userEmail,this.userPassword);
  //   console.log(this.userEmail);
    
  //   if(!newUser){
  //     var userVerified = this.loginService.verifyUser(this.userEmail, this.userPassword);
  //     var loggedInUser=userVerified[0];
  //     if(userVerified[1]){
  //       console.log('VERIFIED STATUS FROM COMPONENT');
  //       //ROUTE TO HOME PAGE
  //       this.goToHomePage(loggedInUser);
  //       //this.router.navigate(['/home']);
  //     }else{
  //       console.log('UNVERIFIED FROM COMPONENT');
  //       //TODO  : DISPLAY ERROR : INCORRECT PASSWORD
  //       document.getElementById('wrong-password')?.classList.remove('wrong-password');
  //       this.userPassword='';
  //     }
  //   }else{
  //     console.log('NEW USER FOUND IN LOGIN PAGE');
  //     // ROUTE TO SIGNUP PAGE
  //     const userNotFoundId=document.getElementById('no-user-found');
  //     userNotFoundId!.textContent='USER NOT FOUND!!';
  //     userNotFoundId?.classList.add('user-not-found');
  //     this.userEmail='';
  //     this.userPassword='';
  //     //this.goToSignUp();
  //   }
  // }
}
