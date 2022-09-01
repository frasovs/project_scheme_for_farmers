import { Component, Injectable, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Bidder } from '../Bidder';
import { BidderService } from "../bidder.service";

@Component({
  selector: 'app-bidder-reg',
  templateUrl: './bidder-reg.component.html',
  styleUrls: ['./bidder-reg.component.css']
})

@Injectable()
export class BidderRegComponent implements OnInit {
  BidderRegistrationForm:FormGroup=new FormGroup({
      firstName:new FormControl ('', [Validators.required]),
      lastName:new FormControl ('', [Validators.required]),
      email:new FormControl('',[Validators.required,Validators.email]),
      password:new FormControl("",[Validators.required,Validators.pattern("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")]),
      confirmPassword:new FormControl("",[Validators.required,Validators.pattern("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")]),
      contact:new FormControl('',[Validators.required]),
      address:new FormControl('',[Validators.required]),
      city:new FormControl('',[Validators.required]),
      state:new FormControl('',[Validators.required]),
      pincode:new FormControl('',[Validators.required]),
      amount:new FormControl('',[Validators.required]),
      traderLicense:new FormControl('',[Validators.required]),
      aadharNo:new FormControl('',[Validators.required,Validators.pattern("^[0-9]{12}$")])
  });
  bidder=new Bidder();
  constructor(private bidderService:BidderService,private router:Router) { }

  

  ngOnInit(): void {
  }

  register() {
    this.bidderService.register(this.bidder).subscribe(data => {
      
      
      if(data.status == 'SUCCESS') {
        this.JSalert1();
        this.router.navigate(['BidderLogin'])
      }
      else {
        this.JSalert2();
      }
    })
  }

  JSalert1(){
    Swal.fire("You have been successfully registered");
    
  
  }
  JSalert2(){
    Swal.fire("Not Registered! Already a user");
  
  }
}
