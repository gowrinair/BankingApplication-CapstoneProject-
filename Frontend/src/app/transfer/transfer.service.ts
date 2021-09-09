import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Transfer, TransResponse, Customer } from '../customer';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class TransferService {
  headers=new HttpHeaders()
  .set('content-type', 'application/json')
  .set('Access-Control-Allow-Origin', '*');

   //formData?: Transfer;
  constructor(private _httpService: HttpClient,private router:Router) { }

  transaction(transfer:Transfer): Observable<TransResponse>{
    
    return this._httpService.get<TransResponse>(environment.APIUrl +'transaction/transfer/'+transfer,{ 'headers': this.headers });
  }

  transAccNo(userName:any): Observable<number>{
    
    return this._httpService.get<number>(environment.APIUrl +'customer/getAccNumber/'+userName,{ 'headers': this.headers });
  }



  
}
