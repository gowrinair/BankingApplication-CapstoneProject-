import { Component, OnInit, Input } from '@angular/core';
import { Customer, CustomerResponse } from '../customer';
import { LoginService } from '../login/login.service';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent implements OnInit {
 
//  customer:Customer={};

  constructor(private logServe:LoginService) { 
    console.log("hai");
  }


  ngOnInit(): void {
    // const routeParams = this.route.snapshot.paramMap;
    // const userNameFromRoute = String(routeParams.get('userNameFromRoute'));
    // console.log(userNameFromRoute);
    // this.route.params.subscribe(params => {
    //   console.log(params) //log the entire params object
    //   console.log(params['customer']) //log the value of id
    // });
    // console.log("hello");
  
    // this.route.paramMap.subscribe(params => {
    //   // this.= params.get('customer');
    // });

    // this.route.queryParams.subscribe(params => {
    //   this.customer.userName = params['userName'];
   
    //   console.log( this.customer.userName );
    // });
    


  }
}
