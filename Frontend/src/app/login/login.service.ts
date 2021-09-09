import { Injectable } from '@angular/core';
import { Customer, CustomerResponse } from '../customer';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  headers=new HttpHeaders()
  .set('content-type', 'application/json')
  .set('Access-Control-Allow-Origin', '*');

   formData?: Customer;

  constructor(private _httpService: HttpClient,private router:Router) { }
  
  getCustomerUserPass(formData:Customer): Observable<CustomerResponse>{
    
    return this._httpService.get<CustomerResponse>(environment.APIUrl +'customer/'+formData.userName+'/'+formData.password,{ 'headers': this.headers });
  }


  
}
