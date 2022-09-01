import { Component, Inject, Injectable, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Farmer } from '../farmer';
import { FarmerService } from "../farmer.service";
import { first } from 'rxjs/operators';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-farmer-reg',
  templateUrl: './farmer-reg.component.html',
  styleUrls: ['./farmer-reg.component.css']
})

@Injectable()
export class FarmerRegComponent  {
farmer=new Farmer();

constructor(private farmerService:FarmerService,private router:Router) {}
ngOnInit(){
}

register()
{
  
  this.farmerService.register(this.farmer).subscribe(
    data => {

    if(data.status == 'SUCCESS') {
      
      this.JSalert1();
      this.router.navigate(['FarmerLogin'])
    }
    else {
      this.JSalert2();
    }
    });
}
JSalert1(){
  Swal.fire("You have been successfully registered");
  

}
JSalert2(){
  Swal.fire("Not Registered! Already a user");

}
}
