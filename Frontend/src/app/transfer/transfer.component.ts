import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { TransferService } from './transfer.service';
import { NgForm } from '@angular/forms';
import { Transfer, TransResponse, Customer } from '../customer';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent implements OnInit {
transfer?:Transfer={};
customer?:Customer;

transferResp?:TransResponse;
toAccNo:any;
tAmount:any;
userName:any;
acc:any;
response?:Customer={};
  constructor(public dialog: MatDialog,private transferService:TransferService) { }
  
  openDialog() {
    this.dialog.open(DialogElementsExampleDialog);
  }

  ngOnInit(): void {
    this.userName=sessionStorage.getItem('user');
    this.transferService.transAccNo(this.userName).subscribe((response)=>{
     //this.customer =response;
    
     this.acc=response;
    // console.log(this.customer.accountNumber);
    console.log("response",response);

       
     });
  }

  // transferAmount()
  // {
   
  //    //console.log("first",form.value);
  //   this.transferService.transaction(this.transfer).subscribe((response)=>{
  //    // console.log("form",form.value);
  //     console.log("data",response); 
  //    console.log(response);
  //    this.transferResp=response;
    
    
  //   if(response.msg=="transaction done successfully")
  //      {
  //       this.openDialog();
  //       console.log("data from backend",response);  
        
  //   }
  //      else{
  //        console.log("Invalid")
  //        alert("Transaction failed");
  //   //     form.resetForm();
  //      }     
        
  //     })
   
     
  //   }

    


  }




@Component({
  selector: 'dialog-elements-example-dialog',
  templateUrl: 'dialog-elements-example-dialog.html'
})
export class DialogElementsExampleDialog {}


