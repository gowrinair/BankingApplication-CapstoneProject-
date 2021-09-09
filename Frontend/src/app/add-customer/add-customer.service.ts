import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Customer, CustomerResponse } from '../customer';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddCustomerService {
  accountNumber!:number;
 
  constructor(private httpService: HttpClient) { }


  public insertCustomer(customer:Customer): Observable<Customer> {
    console.log(customer);
    return this.httpService.post<Customer>(`${environment.APIUrl}/customer/addCustomer`, customer);
  }


}
