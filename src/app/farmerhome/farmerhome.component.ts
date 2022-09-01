import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { Farmer } from '../farmer';
import { FarmerService } from '../farmer.service';

@Component({
  selector: 'app-farmerhome',
  templateUrl: './farmerhome.component.html',
  styleUrls: ['./farmerhome.component.css']
})
export class FarmerhomeComponent implements OnInit {
  id:Number;
  balance:Number;
  div1:boolean=false;
  constructor(private farmerService:FarmerService) { }
  farmers:Farmer[];
  farmer:Farmer[];
  ngOnInit(){
    this.id = Number(sessionStorage.getItem("farmerId"));
  }
  bal()
  {
    this.farmerService.getFarmerList().subscribe(data=>
      {
        this.farmers = data;
        this.farmer = this.farmers.filter(
          x=> x.farmerId == this.id
        )
        this.balance = this.farmer[0].balance;
        this.JSalert();
      })
  }
  JSalert(){
    Swal.fire("Your Balance is : "+this.balance);

  }
}
