export interface Customer { 
  
    accountNumber?:any;
    firstName?:any;
    lastName?:any;  
    aadharNumber?:any;
    phoneNumber?:any;
    userName?:any;
    password?:any;
    balance?:any;
    aod?:any;
    status?:any;
    bank?:Bank;
    
      
}


export interface CustomerResponse{
  status:string;
  msg:string;
  customer:Customer[];
 
}


export interface Bank{
  branchId?:any;
  branchName?:any;
  ifsc?:any;
}

export interface Transfer{
  transactionId?:any;
  dot?:any;
  toAccNo?:any;
  tAmount?:any;
  customer?:Customer;
}

export interface TransResponse{
  status:string;
  msg:string;
  transfer:Transfer[];
}
