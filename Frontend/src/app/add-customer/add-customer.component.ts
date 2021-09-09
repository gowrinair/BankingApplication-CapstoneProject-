import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AddCustomerService } from './add-customer.service';
import { Customer, CustomerResponse, Bank } from '../customer';
import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';




@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {
  customer:Customer={};
  bank :Bank = {}
  

  constructor( public service: AddCustomerService,private router: Router) { 
  
  }


  ngOnInit() {
    //this.reset();
   // this.getCustomer();
  // this.addCustomer(addForm:NgForm);

  }

 

  addCustomer() :void {
    this.customer.bank=this.bank;
 
    this.service.insertCustomer(this.customer).subscribe(
      (response: Customer)=> {
        console.log("actual:",response);
        // addForm.reset();
        alert("Account Created Successfully");
        this.router.navigate(['login']);
      },
      (error: HttpErrorResponse) => {
        // alert(error.message);
        // addForm.reset();
      }
    );}
}
