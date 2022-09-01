import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {
  
    emailid:string;
    password:string;
 
  constructor(private router:Router) { }

  ngOnInit(): void {
  }
  checkLogin(){
    console.log(this.emailid+" "+this.password);
    if(this.emailid=="vstech7062@gmail.com" && this.password=="1234"){
      sessionStorage.setItem("email",this.emailid);
      //localStorage.setItem("uname",this.username);
      this.router.navigate(['/adminHome'])
    }
    else{
      this.JSalert();
      this.router.navigate(['/adminLogin'])
    }

  }
  JSalert(){
    Swal.fire("Wrong Login Credentials");

  }

}
