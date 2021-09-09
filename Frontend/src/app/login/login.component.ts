import { Component, OnInit, Inject } from '@angular/core';
import { Customer, Bank, CustomerResponse } from '../customer';
import { NgForm } from '@angular/forms';
import { LoginService } from './login.service';
import { Router } from '@angular/router';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  customer?:any;
  custResp?:CustomerResponse;
  userName:any;
  password:any;
 

  constructor(public loginService:LoginService,public router:Router,public dialog: MatDialog) {

   }

  ngOnInit(): void {
    this.resetForm();
  }

  onSubmit(form:NgForm){
    this.validLogin(form);
    // console.log(val);
  }


  resetForm(form?:NgForm)
  {
    if(form!=null)    
      form.resetForm();
      this.loginService.formData={
        accountNumber:null,
        firstName:null,
        lastName:null,
        aadharNumber:null,
        phoneNumber:null,
        userName:null,
        password:null,
        balance:null,
        aod:null,
        status:null,
       
        bank:{
          branchId:null,
          branchName:null,
          ifsc:null
        
        }
       
    };
    
      }
  

      alertfun(){
        alert("Kindly Contact your Bank officials!")
      }

  validLogin(form:NgForm){
    console.log("first",form.value);
      this.loginService.getCustomerUserPass(form.value).subscribe((response)=>{
        console.log("form",form.value);
        console.log("data",response); 
       console.log(response);
       this.customer=response;
       
      console.log(this.userName);
      
      
       if(response.msg=="Customer details is displayed successfully")
       {
      
        console.log("data from backend",response); 
        
        sessionStorage.setItem('user',this.userName);
        sessionStorage.setItem('pass',this.password);

      this.router.navigate(['services']);     
        
    }
       else{
         console.log("Invalid")
         alert("Invalid username and password!");
         form.resetForm();
       }     
        
      })
   
     
    }

    

 }

 @Component({
  selector: 'viewprofile',
  templateUrl: 'viewprofile.html'
})
export class ViewProfileDialog{
  constructor(@Inject(MAT_DIALOG_DATA) public data: Customer) {}

     

  


}